<script>
import { defineComponent } from "vue";
import LoadingSpinner from "../components/LoadingSpinner.vue";

export default defineComponent({
  components: { LoadingSpinner },
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
      currentUser: null,
      edit: false

    }
  },
  created() {
    this.fetchCurrentUser();
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
        this.createUser(this.user)
        this.username = "",
          this.firstName = "",
          this.lastName = "",
          this.address = "",
          this.address2 = "",
          this.city = "",
          this.country = "",
          this.postCode = "",
          this.phoneNumber = "",
          this.admin = ""
        this.errors.username = false;
        this.errors.email = false;
      }
    },

    async updateUser() {
      try {
        let urlUpdateUser = `/api/users/` + this.currentUser.id
        let responseCategory = await fetch(urlUpdateUser, {

          method: 'PUT',

          headers: {
            'Content-Type': 'application/json'
          },

          body: JSON.stringify({
            id: this.currentUser.id,
            firstName: this.currentUser.firstName,
            lastName: this.currentUser.lastName,
            username: this.currentUser.username,
            city: this.currentUser.city,
            country: this.currentUser.country,
            address: this.currentUser.address,
            address2: this.currentUser.address2,
            postCode: this.currentUser.postCode,
            phoneNumber: this.currentUser.phoneNumber,
            email: this.currentUser.email,
            admin: this.currentUser.admin
          })
        });
        let updateUser = await responseCategory.json();


        alert(`You updated your info`)

        // router.push({ path: '/' })
        this.isEdit();

      } catch (error) {
        console.log("Error: ", error)
      }
    },

    async fetchCurrentUser() {
      const response = await fetch('/api/users/me')
      if (response.ok) {
        setTimeout(async () => {
          this.currentUser = await response.json();
        }, 500) // setTimeout is only for showing the usage of loadingSpinners!
      }
    },
    isEdit() {
      if (!this.edit) {
        this.edit = true
      } else {
        this.edit = false
      }

    }


  }
});
</script>

<template>



  <template v-if="currentUser">
    <h2>Profile of {{ this.currentUser.username }}</h2>
    <!-- <pre>{{ this.currentUser }}</pre> -->

    <p>This page contains all of your personal data that you provided on the registration form at the moment of
      registration.</p>
    <!-- <pre>{{ this.currentUser }}</pre> -->

    <section v-show="!this.edit">
      <p><b>Username: </b>{{ this.currentUser.username }}</p>
      <p><b>Email: </b>{{ this.currentUser.email }}</p>
      <p><b>Firstname: </b>{{ this.currentUser.firstName }}</p>
      <p><b>Lastname: </b>{{ this.currentUser.lastName }}</p>
      <p><b>Address: </b>{{ this.currentUser.address }}</p>
      <p><b>Address 2: </b>{{ this.currentUser.address2 }}</p>
      <p><b>City: </b>{{ this.currentUser.city }}</p>
      <p><b>Postal code: </b>{{ this.currentUser.postCode }}</p>
      <p><b>Country: </b>{{ this.currentUser.country }}</p>
      <p><b>Phone number: </b>{{ this.currentUser.phoneNumber }}</p>
    </section>

    <section v-show="this.edit">
      <form class="loginform" @submit.prevent="processForm" novalidate>

        <fieldset>
          <p for="firstName">
            <span>First name</span>
            <input type="text" id="firstName" autocomplete="firstName" v-model="currentUser.firstName">
          </p>

          <p for="lastName">
            <span>Last name</span>
            <input type="text" id="lastName" autocomplete="lastName" v-model="currentUser.lastName">
          </p>

          <p for="city">
            <span>City</span>
            <input type="text" id="city" autocomplete="city" v-model="currentUser.city">
          </p>

          <p for="country">
            <span>Country</span>
            <input type="text" id="country" autocomplete="country" v-model="currentUser.country">
          </p>

          <p for="address">
            <span>Address</span>
            <input type="text" id="address" autocomplete="address" v-model="currentUser.address">
          </p>

          <p for="address2">
            <span>Address2</span>
            <input type="text" id="address2" autocomplete="address2" v-model="currentUser.address2">
          </p>

          <p for="postCode">
            <span>PostCode</span>
            <input type="number" id="postCode" autocomplete="postCode" v-model="currentUser.postCode">
          </p>

          <p for="phoneNumber">
            <span>Phone number</span>
            <input type="number" id="phoneNumber" autocomplete="phoneNumber" v-model="currentUser.phoneNumber">
          </p>

          <p for="email">
            <span>E-mail</span>
            <input type="email" id="email" autocomplete="email" v-model="currentUser.email">
          </p>

          <p><input @click="updateUser()" type="submit" value="Update"></p>

        </fieldset>
      </form>
    </section>



    <button @click="isEdit()"> {{ this.edit ? "Cancle" : "Edit info" }}</button>
    <!-- <p><b>Id#: </b>{{ this.currentUser.id }}</p> -->
    <!-- <p><b>Role: </b>{{ this.currentUser.admin ? "Admin" : "User"}}</p> -->

  </template>
  <template v-else>
    <LoadingSpinner />
  </template>

</template>

<style scoped>

</style>