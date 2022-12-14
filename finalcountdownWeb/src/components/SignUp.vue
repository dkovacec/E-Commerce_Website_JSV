<script>
import Message from './Message.vue';

export default {
    data() {
        return {
            user: {
                firstName: "",
                lastName: "",
                country: "",
                address: "",
                address2: "",
                phoneNumber: "",
                postCode: "",
                username: "",
                email: "",
                password: "",
            },
            formErrors: [],
            errors: {
                firstName: false,
                lastName: false,
                city: false,
                country: false,
                address: false,
                address2: false,
                phoneNumber: false,
                postCode: false,
                username: false,
                email: false,
                password: false,
            },
            users: [],
            totalUsers: 0
        }
    },
    components: {
        Message
    },
    methods: {
    processForm() {
        console.log("Form submitted");
        console.log(this.user);
        this.formErrors = [];

        let re = /^[A-Za-z ]{2,}$/;
        if (!re.test(this.user.firstName.trim())) {
            this.errors.firstName = true;
        } else {
            this.errors.firstName = false;
        }
       
        if (!re.test(this.user.lastName.trim())) {
            this.errors.lastName = true;
        } else {
            this.errors.lastName = false;
        }
        if (!re.test(this.user.username.trim())) {
            this.errors.username = true;
        } else {
            this.errors.username = false;
        }
        if (!re.test(this.user.city.trim())) {
            this.errors.city = true;
        } else {
            this.errors.city = false;
        }
        if (!re.test(this.user.country.trim())) {
            this.errors.country = true;
        } else {
            this.errors.country = false;
        }
        let addr = /^[A-Za-z  0-9]{2,}$/;
        if (!addr.test(this.user.address.trim())) {
            this.errors.address = true;
        } else {
            this.errors.address = false;
        }
        if (!this.user.address2.trim) {
            this.errors.address2 = true;
        } else {
            this.errors.address2 = false;
        }
        
        let num = /^\d+$/;
        if (!num.test(this.user.postCode.trim())) {
            this.errors.postCode = true;
        } else {
            this.errors.postCode = false;
        }
       
        if (!num.test(this.user.phoneNumber.trim())) {
            this.errors.phoneNumber = true;
        } else {
            this.errors.phoneNumber = false;
        }

        let mail = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
        if (!mail.test(this.user.email.trim())) {
            this.errors.email = true;
        } else {
            this.errors.email = false;
        }
      
        if (!this.user.password) {
            this.errors.password = true;
        } else {
            this.errors.password = false;
        }

        let isErrors = false;
        for (const error in this.errors) {
            if (this.errors[error]) {
                isErrors = true;
            }
        }
        if (!isErrors) {

            this.createUser(this.user);
            alert("User inserted");
            this.firstName = "";
            this.lastName = "";
            this.city = "";
            this.country = "";
            this.address = "";
            this.address2 = "";
            this.postCode = "";
            this.phoneNumber = "";
            this.username = "";
            this.email = "";
            this.password = "";
            this.errors.firstName = false;
            this.errors.lastName = false;
            this.errors.city = false;
            this.errors.country = false;
            this.errors.address = false;
            this.errors.address2 = false;
            this.errors.postCode = false;
            this.errors.phoneNumber = false;
            this.errors.username = false;
            this.errors.email = false;
            this.errors.password = false;

        }
    },
        async createUser(user) {
            try {
                let url = "/api/users";
                let response2 = await fetch(url, {
                    method: "POST",
            
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        firstName: user.firstName,
                        lastName: user.lastName,
                        username: user.username,
                        city: user.city,
                        country: user.country,
                        address: user.address,
                        address2: user.address2,
                        postCode: user.postCode,
                        phoneNumber: user.phoneNumber,
                        email: user.email,
                        password: user.password
                    })
                });
                let newUser = await response2.json();
                alert(`User inserted with id=${newUser.id}`)
                this.getUsers();
            } catch (error) {
                console.log("Error".error);
            }
        },
        async getUsers() {
            try {
                let url = "/api/users";
                let response = await fetch(url);
                this.users = await response.json();
                this.totalUsers = this.users.length;
                console.log(this.users);
            } catch (error) {
                console.log("Error".error);
            }
        }
    },
    created() {
        this.getUsers();
    }
}



</script>
<template>
    <form @submit.prevent="processForm" novalidate>
        <ul id="listErrors" v-show="(formErrors.length > 0)">
            <li v-for="error of formErrors">{{ error }}</li>
        </ul>
        <p><label for="firstName">First name</label><input type="text" id="firstName" v-model="user.firstName"></p>
        <Message v-show="errors.firstName" :message="'First name field is empty or incorrect'"></Message>

        <p><label for="lastName">Last name</label><input type="text" id="lastName" v-model="user.lastName"></p>
        <Message v-show="errors.lastName" :message="'Last name field is empty'"></Message>

        <p><label for="city">City</label><input type="text" id="city" v-model="user.city"></p>
        <Message v-show="errors.city" :message="'City field is empty'"></Message>

        <p><label for="country">Country</label><input type="text" id="country" v-model="user.country"></p>
        <Message v-show="errors.country" :message="'Country field is empty'"></Message>

        <p><label for="address">Address</label><input type="text" id="address" v-model="user.address"></p>
        <Message v-show="errors.address" :message="'Address field is empty'"></Message>

        <p><label for="address">Address2</label><input type="text" id="address" v-model="user.address2"></p>
       
        
        <p><label for="postCode">Post Code</label><input type="text" id="postCode" v-model="user.postCode"></p>
        <Message v-show="errors.postCode" :message="'PostCode number field is empty'"></Message>

        <p><label for="phoneNumber">Phone number</label><input type="text" id="phoneNumber" v-model="user.phoneNumber"></p>
        <Message v-show="errors.phoneNumber" :message="'Phone number field is empty'"></Message>
        
        <p><label for="username">Username</label><input type="username" id="username" v-model="user.username"></p>
        <Message v-show="errors.username" :message="'Username field is empty or incorrect'"></Message>

        <p><label for="email">E-mail</label><input type="email" id="email" v-model="user.email"></p>
        <Message v-show="errors.email" :message="'E-mail field is empty or incorrect'"></Message>

        <p><label for="password">Password</label><input type="text" id="password" v-model="user.password"></p>
        <Message v-show="errors.password" :message="'Password field is empty'"></Message>
        
        <p><input type="submit" value="Register user"></p>
    </form>
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
</style>