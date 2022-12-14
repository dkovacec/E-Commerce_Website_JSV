<script>
import { defineComponent } from "vue";
import { mapState } from "pinia";
import { useAuthStore } from "@/store/auth";
export default defineComponent({
  computed: {
    ...mapState(useAuthStore, ["isAuthenticated"])
  },
});

</script>

<template>

<nav class="topMenu">
    <a href="#"><img class="logo" src="src\images\logo.jpg"></a>
      <ul>
         <!-- use router-link instead of a to stop refreshing and request to server-->
        <!-- this makes it very fast and better -->
        <!-- <li><router-link to="/">Home</router-link></li>-->
        <li><router-link to="/">Home</router-link></li>
        
        <!-- using names for routing -->
        <!-- <li><router-link :to="{ name: 'Tabs'}">Tabs</router-link></li> -->
        <!-- <li><a href="#">Shop</a></li> -->

        <!-- <li><router-link to="/login">Login</router-link></li>
        <li><router-link to="/signup">Sign Up</router-link></li> -->
        <li><router-link to="/categorylist">Categories</router-link></li>
        <li><router-link to="/categoryadd">Add Category</router-link></li>

        <li v-if="!isAuthenticated">
          <li><router-link to="/signup">Sign Up</router-link></li>
    </li>
    <li v-if="!isAuthenticated">
      <li><router-link to="/login">Login</router-link></li>
    </li>
    <li v-if="isAuthenticated">
      <li><router-link to="/logout">Logout</router-link></li>
    </li>
    <li v-if="isAuthenticated">
      <li><router-link to="/userListView">Users</router-link></li>
    </li>
    <li v-if="isAuthenticated">
      <li><router-link to="/profileView">Profile</router-link></li>
      <!-- <router-link :to="{ name: 'profileView' }">Profile</router-link> -->
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

.topMenu {
    position: absolute;
    list-style: none;
    margin: auto;
    padding: 0;
    text-align: center;
    box-shadow: 0px 3px 5px #000;
    /*display: inline-block;*/
    /*overflow: hidden;*/
    /*position: fixed;*/
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