<script>
import { defineComponent } from "vue";
import { mapState } from "pinia";
import { useAuthStore } from "@/store/auth";

// //for shopping cart
// import { useCartStore } from "@/store/cart";


export default defineComponent({

  data() {
    return {
      currentUser: null,
      // cart: [],
      // totalCart: 0
    }
  },
  created() {
    this.fetchCurrentUser();
  },
  methods: {
    async fetchCurrentUser() {
      const response = await fetch('/api/users/me')
      if (response.ok) {
        setTimeout(async () => {
          this.currentUser = await response.json();
        }, 500) // setTimeout is only for showing the usage of loadingSpinners!
      }
    },
  },

  computed: {
    ...mapState(useAuthStore, ["isAuthenticated", "user"] ),
    // ...mapState(useCartStore , ["cart", "totalCart"])
}
});

</script>

<template>

<nav class="topMenu">
    <img class="logo" src="..\images\logo.jpg">

    <p v-if="user" class="currentUser" > Hello {{ this.user?.username }} </p>


      <ul>
        <!-- use router-link instead of a to stop refreshing and request to server-->
        <!-- this makes it very fast and better -->
        <!-- <li><router-link to="/">Home</router-link></li>-->

        <li><router-link to="/">Home</router-link></li>
        
        <!-- using names for routing -->
        <!-- <li><router-link :to="{ name: 'Tabs'}">Tabs</router-link></li> -->
        <!-- <li><a href="#">Shop</a></li> -->

<li v-if="!isAuthenticated">
      <router-link :to="{ name: 'register' }">Register</router-link>
    </li>

    <li v-if="!isAuthenticated">
      <router-link :to="{ name: 'login' }">Login</router-link>
    </li>
    <li v-if="isAuthenticated">
      <router-link :to="{ name: 'logout' }">Logout</router-link>
    </li>

    <li v-if="isAuthenticated && this.user?.admin">
        <li><router-link to="/categorylist">Categories</router-link></li>
      </li>

        <li v-if="isAuthenticated && this.user?.admin">
        <li><router-link to="/categoryadd">Add Category</router-link></li>
      </li>

        <li v-if="isAuthenticated && this.user?.admin">
        <li><router-link to="/productlist">Products</router-link></li>
      </li>

        <li v-if="isAuthenticated && this.user?.admin">
        <li><router-link to="/productadd">Add Product</router-link></li>
      </li>

    <li v-if="isAuthenticated && this.user?.admin">
      <router-link :to="{ name: 'userList' }">Users</router-link>
    </li>
    <li v-if="isAuthenticated">
      <router-link :to="{ name: 'profile' }">Profile</router-link>
    </li>






        <li><a href="#">Cart</a></li>
      </ul>
    </nav>

</template>

<style>
.logo {
    padding: 0;
    margin: 0;
    vertical-align: center;
    float: left;
}

.logo a {
    padding: 0;
}

.currentUser {
  font-size: 0.8em;
  float: right;
  padding-right: 5px;
}

.topMenu {
    position: absolute;
    list-style: none;
    margin-left: auto;
  margin-right: auto;
  left: 0;
  right: 0;
    margin: auto;
    padding: 0;
    text-align: center;
    box-shadow: 0px 3px 5px #000;
    background-color: white;
    /*display: inline-block;*/
    /*overflow: hidden;*/
    position: fixed;
    width: 75%;
}

.topMenu ul {
    margin: 0;
}

.topMenu li {
    display: inline;
    /*border: 1px solid black;*/
}

.topMenu a {
    text-decoration: none;
    color: black;
    padding: 10px 20px;
    margin: 0;
    display: inline-block;
}



.topMenu a:hover {
    cursor: pointer;
    color: lightcyan;
    background-color: black;
}

</style>