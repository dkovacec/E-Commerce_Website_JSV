<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "../store/auth";
import ErrorMessage from './ErrorMessage.vue';

export default defineComponent({
    data() {
        return {
            user: {
              
                username: "",
                password: ""
            },
            // formErrors: [],
            // errors: {
        
            //     username: false,
            //     password: false
            // },
            // users: [],
            // totalUsers: 0
            error: null,
        isLoggedIn: false,
        }
    },
    components: {
        ErrorMessage
    },
    methods: {
    login() {
      this.authStore.login(this.user)
      .then( (user) => this.authStore.retrieveUserData(user.id))
          .then(() => this.$router.push({ name: 'home' }))
          .catch(error => this.error = { message: "Login failed." })
    },
  },
    computed: {
    ...mapStores(useAuthStore),
    valid() {
      return this.user.username.length > 0 && this.user.password.length > 0;
    }
  },
})

</script>
<template>

    <form class="loginform" @submit.prevent="login" v-if="!authStore.isAuthenticated">
    <fieldset>
      <label for="username">
        <span>Username</span>
        <input type="text" id="username" autocomplete="username" v-model="user.username">
      </label>

      <label for="password">
        <span>Password</span>
        <input type="password" id="password" autocomplete="current-password" v-model="user.password">
      </label>

      <button type="submit" :disabled="!valid">Login</button>
    </fieldset>
  </form>
  <ErrorMessage v-if="error?.message" :error="error"/>

</template>

<style scoped>
#listErrors {
    background-color: lightblue;
    padding: 20px;
    cursor: pointer;
    border: 1px solid #000;
    border-bottom: none;
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
}

.errors {
    color: red;

}


.loginform {
	width: 450px;
    margin-left: auto;
    margin-right: auto;
	padding: 20px 20px;
	box-sizing: border-box;
	border: 2px solid #380000;
	border-radius: 4px;
	background-color: whitesmoke;
	resize: none;
	color: black;

}

.loginform label {
    display: inline-block;
    width: 100px;
    text-align: right;
    margin: 1px;
    font-size: 14px;
}

input[type=text],[type=username], [type=email], [type=password] {
    height: 25px;
    width: 60%;
    padding: 3px;
    margin-left: 15px;
    border-radius: 3px;
    border: 1px solid transparent;
    border-top: none;
    border-bottom: 1px solid #DDD;
    background-color: #DDD;
    box-shadow: inset 0 1px 2px rgba(0,0,0,.39), 0 -1px 1px #FFF, 0 1px 0 #FFF
}

.input[type=button], input[type=submit], input[type=reset] {
	background-color: #00050f; /*inverted of floralwhite*/
	border: 2px solid darkblue;
	border-radius: 4px;
	color: white;
	padding: 10px 15px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}

fieldset {
  border: 0;
}
fieldset > label {
  display: block;
  width: 10rem;
  margin-bottom: 1rem;
}
label > span {
  display: block;
  margin-bottom: 0.2rem;
}



</style>