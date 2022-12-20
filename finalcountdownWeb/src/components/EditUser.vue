<script>
import router from '../router';
import ErrorMessage from './ErrorMessage.vue';


export default {
    mounted: function () {
        this.created()
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
                isAdmin: false,
               
            },
            errors: {
                firstName:false,
                lastName: false,
                country: false,
                city: false,
                address: false,
                address2:false,
                phoneNumber:false,
                postCode:false,
                username: false,
                email: false,
                isAdmin: false,
            },
            users: [],
        }
    },
    components: {
        ErrorMessage
    },
    methods: {   
        processForm() {
            if (!this.user.username.trim()) {
                this.errors.username = true;
            } else {
                this.errors.username = false;
            }

            if (!this.user.email.trim()) {
                this.errors.email = true;
            } else {
                this.errors.email = false;
            }

            let isErrors = false;

            for (let error in this.errors) {
                if (this.errors[error]) {
                    isErrors = true;
                }
            }

            if (!isErrors) {
                console.log("Clicked ")
                this.createProduct(this.product)
                console.log("Clicked 2")
                alert("You have edited a user!")
                this.username = "",
                    this.firstName = "",
                    this.lastName = "",
                    this.address = "",
                    this.address2 = "",
                    this.city = "",
                    this.country = "",
                    this.postCode = "",
                    this.phoneNumber = "",
                    this.errors.username = false;
                this.errors.email = false;
            }
        },
        
        async getUser() {
            let urlGetUser = '/api/users/' + this.$route.params.id

            try {

                let response = await fetch(urlGetUser);
                this.users = await response.json();
                console.log(this.users)

            } catch (error) {

            }

        },

        created() {
            this.getUser();
            

        },

        async updateUser() {
            try {
                let urlUpdateUser = '/api/users/' + this.$route.params.id
                let responseCategory = await fetch(urlUpdateUser, {

                    method: 'PUT',

                    headers: {
                        'Content-Type': 'application/json'
                    },

                    body: JSON.stringify({
                        id: this.this.$route.params.id,
                        firstName: this.users.firstName,
                        lastName: this.users.lastName,
                        username: this.users.username,
                        city: this.users.city,
                        country: this.users.country,
                        address: this.users.address,
                        address2: this.users.address2,
                        postCode: this.users.postCode,
                        phoneNumber: this.users.phoneNumber,
                        email: this.users.email,
                        isAdmin: this.users.isAdmin,
                    })
                });
                let updateUser= await responseCategory.json();
                alert(`User updated with id= ${updateUser.id}`)

                router.push({ path: '/userList' })



            } catch (error) {
                console.log("Error: ", error)
            }
        }
    }
}



</script>

<template>
    <h1>Edit user</h1>
    <form class="loginform" @submit.prevent="processForm" novalidate>
    
    <fieldset>
      <p for="firstName">
        <span>First name</span>
        <input type="text" id="firstName" autocomplete="firstName" v-model="users.firstName">
      </p>
      
      <p for="lastName">
        <span>Last name</span>
        <input type="text" id="lastName" autocomplete="lastName" v-model="users.lastName">
      </p>
     
      <p for="city">
        <span>City</span>
        <input type="text" id="city" autocomplete="city" v-model="users.city">
      </p>
      
      <p for="country">
        <span>Country</span>
        <input type="text" id="country" autocomplete="country" v-model="users.country">
      </p>
     
      <p for="address">
        <span>Address</span>
        <input type="text" id="address" autocomplete="address" v-model="users.address">
      </p>
     
      <p for="address2">
        <span>Address2</span>
        <input type="text" id="address2" autocomplete="address2" v-model="users.address2">
      </p>
     
      <p for="postCode">
        <span>PostCode</span>
        <input type="number" id="postCode" autocomplete="postCode" v-model="users.postCode">
     </p>
     
     <p for="phoneNumber">
        <span>Phone number</span>
        <input type="number" id="phoneNumber" autocomplete="phoneNumber" v-model="users.phoneNumber">
      </p>

      <p for="email">
        <span>E-mail</span>
        <input type="email" id="email" autocomplete="email" v-model="users.email">
      </p>
      <p for="username">
        <span>Username</span>
        <input type="username" id="username" autocomplete="username" v-model="users.username">
      </p>
      <p for="isAdmin">
        <span>User/Admin</span>
        <input type="checkbox" id="isAdmin" autocomplete="isAdmin" v-model="users.isAdmin" true-value="1" false-value="false"> // when unchecked:false
      </p>
      <p><input @click="updateUser()"  type="submit" value="Update"></p>
    </fieldset>
    </form>

</template>

<style>

</style>

