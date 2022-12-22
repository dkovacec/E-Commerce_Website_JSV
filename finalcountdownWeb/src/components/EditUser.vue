<script>
import router from '../router';
import ErrorMessage from './ErrorMessage.vue';

//ovo
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
                admin: ""

            },
            errors: {
                firstName: false,
                lastName: false,
                country: false,
                city: false,
                address: false,
                address2: false,
                phoneNumber: false,
                postCode: false,
                username: false,
                email: false,
                admin: false,
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
                this.createUser(this.user)
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
                    this.admin=""
                    this.errors.username = false;
                this.errors.email = false;
            }
        },



        async getUser() {
            let urlGetUser = '/api/users/' + this.$route.params.uId

            try {

                let response = await fetch(urlGetUser);
                this.users = await response.json();
                console.log(this.users)

            } catch (error) {

            }

        },
        // do ovdje

        created() {
            this.getUser();

        },

        async updateUser() {
            try {
                let urlUpdateUser = `/api/users/` + this.$route.params.uId
                let responseCategory = await fetch(urlUpdateUser, {

                    method: 'PUT',

                    headers: {
                        'Content-Type': 'application/json'
                    },

                    body: JSON.stringify({
                        id: this.$route.params.uId,
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
                        admin: this.users.admin
                    })
                });
                let updateUser = await responseCategory.json();

                
                alert(`User ${updateUser.username} has been updated`)

                router.push({ path: '/user' })


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
                <span>Username:</span><label class="lbl1">{{users.username}}</label>
                <!-- <input type="username" id="username" autocomplete="username" v-model="users.username"> -->
            </p>

            <p for="admin">
                <span>Select user role: </span>
                <label>Admin: 
                <input type="radio" id="admin" autocomplete="admin" v-model="users.admin" :value="true">
                </label>
                <label> User: <input type="radio" id="admin" autocomplete="admin" v-model="users.admin" :value="false"></label>
                <br><br>
            </p>

            <p><input class="buttonUpdate" @click="updateUser()" type="submit" value="Update"></p>
        </fieldset>
    </form>

</template>

<style scoped>

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

.loginform span {
    border: 0px solid #000;
    display: inline-block;
    width: 125px;
    text-align: left;
    margin-right: -10px;
    font-size: 15px;
}

.loginform label {
    border: 0px solid #000;
    display: inline-block;
    width: 125px;
    text-align: right;
    margin-right: -10px;
    font-size: 15px;
}


.lbl1 {
    border: 0px solid #000;
    display: inline-block;
    text-align: right;
    margin-left: -50px;
    font-size: 15px;
}

input[type=text],[type=username], [type=email], [type="number"], [type="password"]  {
    height: 25px;
    width: 50%;
    padding: 3px;
    margin-left: 25px;
    border-radius: 3px;
    border: 1px solid transparent;
    border-top: none;
    border-bottom: 1px solid #DDD;
    background-color: #DDD;
    box-shadow: inset 0 1px 2px rgba(0,0,0,.39), 0 -1px 1px #FFF, 0 1px 0 #FFF
}

.buttonUpdate {
  background-color: green;
  width: 100px;
  height: 40px;
  color: white;
  padding: 10px 10px;
  margin: 8px 8px;
  margin-left: 150px;
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


