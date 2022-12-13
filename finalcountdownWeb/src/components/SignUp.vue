<script>
import Message from './Message.vue';

export default {
    data() {
        return {
            user: {
                firstName: "",
                lastName: "",
                email: "",
                password: ""
            },
            formErrors: [],
            errors: {
                firstName: false,
                lastName: false,
                email: false,
                password: false
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

        let re = /^[A-Za-z ]{3,}$/;
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
    
        if (!this.user.email) {
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
            this.email = "";
            this.password = "";
            this.errors.firstName = false;
            this.errors.lastName = false;
            this.errors.email = false;
            this.errors.password = false;

        }
    },
    //     async createUser(user) {
    //         try {
    //             let url = "http://localhost:8080/users";
    //             let response2 = await fetch(url, {
    //                 method: "POST",
    //                 headers: {
    //                     'Content-Type': 'application/json'
    //                 },
    //                 body: JSON.stringify({
    //                     firstName: user.firstName,
    //                     lastName: user.lastName,
    //                     email: user.email,
    //                     password: user.password

    //                 })
    //             });
    //             let newUser = await response2.json();
    //             alert(`User inserted with id=${newUser.id}`)
    //             this.getUsers();
    //         } catch (error) {
    //             console.log("Error".error);
    //         }
    //     },
    //     async getUsers() {
    //         try {
    //             let url = "http://localhost:8080/users";
    //             let response = await fetch(url);
    //             this.users = await response.json();
    //             this.totalUsers = this.users.length;
    //             console.log(this.users);
    //         } catch (error) {
    //             console.log("Error".error);
    //         }
    //     }
    // },
    // created() {
    //     this.getUsers();
    // }
}
}


</script>
<template>
    <form @submit.prevent="processForm" novalidate>
        <ul id="listErrors" v-show="(formErrors.length > 0)">
            <li v-for="error of formErrors">{{ error }}</li>
        </ul>
        <p><label for="firstName">First name</label><input type="text" id="firstName" v-model="user.firstName"></p>
        <Message v-show="errors.firstName" :message="'First name field is empty'"></Message>

        <p><label for="lastName">Last name</label><input type="text" id="lastName" v-model="user.lastName"></p>
        <Message v-show="errors.lastName" :message="'Last name field is empty'"></Message>

        <p><label for="email">E-mail</label><input type="email" id="email" v-model="user.email"></p>
        <Message v-show="errors.email" :message="'E-mail field is empty'"></Message>

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