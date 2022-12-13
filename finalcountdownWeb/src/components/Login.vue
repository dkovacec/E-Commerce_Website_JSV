<script>
import Message from './Message.vue';

export default {
    data() {
        return {
            user: {
              
                email: "",
                password: ""
            },
            formErrors: [],
            errors: {
        
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

            this.email = "";
            this.password = "";
           
            this.errors.email = false;
            this.errors.password = false;

        }
    },
}
}


</script>
<template>

    <form @submit.prevent="processForm" novalidate>
        <p><label for="email">E-mail</label><input type="email" id="email" v-model="user.email"></p>
        <Message v-show="errors.email" :message="'E-mail field is empty'"></Message>

        <p><label for="password">Password</label><input type="text" id="password" v-model="user.password"></p>
        <Message v-show="errors.password" :message="'Password field is empty'"></Message>

        <p><input type="submit" value="Login"></p>
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