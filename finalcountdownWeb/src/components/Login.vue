<script>
import Message from './Message.vue';

export default {
    data() {
        return {
            user: {
              
                username: "",
                password: ""
            },
            formErrors: [],
            errors: {
        
                username: false,
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

        if (!this.user.username) {
            this.errors.username = true;
        } else {
            this.errors.username = false;
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

            this.username = "";
            this.password = "";
           
            this.errors.username = false;
            this.errors.password = false;

        }
    },
}
}


</script>
<template>

    <form class="loginform" @submit.prevent="processForm" novalidate>
        <p><label for="username">Username</label><input type="username" id="username" v-model="user.username"></p>
        <Message v-show="errors.username" :message="'Username field is empty'"></Message>

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

input[type=text],[type=username], [type=email]  {
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
</style>