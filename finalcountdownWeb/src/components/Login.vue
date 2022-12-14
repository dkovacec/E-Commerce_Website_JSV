<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";
import Message from './Message.vue';

export default defineComponent({
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
    computed: {
    ...mapStores(useAuthStore),
    valid() {
      return this.user.username.length > 0 && this.user.password.length > 0;
    },
  }
}
});


</script>
<template>

    <form @submit.prevent="processForm" novalidate v-if="!authStore.isAuthenticated">
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
</style>