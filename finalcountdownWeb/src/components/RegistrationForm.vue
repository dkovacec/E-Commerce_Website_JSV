<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "../store/auth";
import ErrorMessage from './ErrorMessage.vue';

export default defineComponent({
    components: {
        ErrorMessage
    },
    data() {
        return {
            user: {
                firstName: "",
                lastName: "",
                country: "",
                city: "",
                address: "",
                address2: "",
                phoneNumber: "",
                postCode: "",
                username: "",
                email: "",
                password1: "",
                password2: "",
            },
            response: null,
            error : null,

        }
    },
    computed: {
    ...mapStores(useAuthStore),

    },
    methods: {
    register() {
      console.log("register")
      this.error = null;
      this.authStore.register(this.user)
          .then(data => {
            this.response = data;
            this.$router.push({ name: 'home' })
          })
          .catch(errors => {
            this.errors = errors.message
          })
    }
}
});




</script>
<template>
    <form class="loginform" @submit.prevent="register" v-if="!response">
    <fieldset>
      <p for="firstName">
        <label>First name</label>
        <input type="text" id="firstName" autocomplete="firstName" v-model="user.firstName">
      </p>
      
      <p for="lastName">
        <label>Last name</label>
        <input type="text" id="lastName" autocomplete="lastName" v-model="user.lastName">
      </p>
     
      <p for="city">
        <label>City</label>
        <input type="text" id="city" autocomplete="city" v-model="user.city">
      </p>
      
      <p for="country">
        <label>Country</label>
        <input type="text" id="country" autocomplete="country" v-model="user.country">
      </p>
     
      <p for="address">
        <label>Address</label>
        <input type="text" id="address" autocomplete="address" v-model="user.address">
      </p>
     
      <p for="address2">
        <label>Address2</label>
        <input type="text" id="address2" autocomplete="address2" v-model="user.address2">
      </p>
     
      <p for="postCode">
        <label>PostCode</label>
        <input type="number" id="postCode" autocomplete="postCode" v-model="user.postCode">
     </p>
     
     <p for="phoneNumber">
        <label>Phone number</label>
        <input type="number" id="phoneNumber" autocomplete="phoneNumber" v-model="user.phoneNumber">
      </p>

      <p for="email">
        <label>E-mail</label>
        <input type="email" id="email" autocomplete="email" v-model="user.email">
      </p>
      <p for="username">
        <label>Username</label>
        <input type="username" id="username" autocomplete="username" v-model="user.username">
      </p>
      <p for="password2">
        <label>Password</label>
        <input type="password" id="password2" autocomplete="new-password" v-model="user.password2">
      </p>

      <p for="password1">
        <label>Password repeat</label>
        <input type="password" id="password1" autocomplete="new-password" v-model="user.password1">
      </p>

      <button class="buttonRegister">Register</button>
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
	border: 0px solid #380000;
	border-radius: 4px;
	background-color: whitesmoke;
	resize: none;
	color: black;

}

.loginform label {
    border: 0px solid #000;
    display: inline-block;
    width: 100px;
    text-align: left;
    margin-right: 5px;
    font-size: 15px;
}

input[type=text],[type=username], [type=email], [type="number"], [type="password"]  {
    height: 25px;
    width: 60%;
    padding: 3px;
    margin-left: 25px;
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

.buttonRegister {
  background-color: #1f0cc9;
  width: 100px;
  height: 40px;
  color: white;
  padding: 10px 10px;
  margin: 8px 8px;
  margin-left: 205px;
  text-align: center;
  text-decoration: none;
  display: block;
  font-size: 16px;
  border: 1px solid rgb(0, 0, 0);
  border-radius: 5px;
  box-shadow: 0px 3px 5px #000;
  cursor: pointer;
}


</style>