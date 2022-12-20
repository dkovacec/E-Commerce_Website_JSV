<script>
import { defineComponent } from "vue";
import LoadingSpinner from "../components/LoadingSpinner.vue";
export default defineComponent({
  components: { LoadingSpinner },
  data() {
    return {
      currentUser: null,
    }
  },
  created() {
    this.fetchCurrentUser();
  },
  methods: {
    async fetchCurrentUser() {
      const response = await fetch('/api/users/me')
      if (response.ok) {
        setTimeout(async () => {
          this.currentUser = await response.json();
        }, 500) // setTimeout is only for showing the usage of loadingSpinners!
      }
    },
  
  }
});
</script>

<template>



  <template v-if="currentUser">
    <h2>Profile of {{ this.currentUser.username }}</h2>
    <!-- <pre>{{ this.currentUser }}</pre> -->

    <p>This page contains all of your personal data that you provided on the registration form.</p>
    <!-- <pre>{{ this.currentUser }}</pre> -->

    <p><b>Firstname: </b>{{ this.currentUser.firstName }}</p>
    <p><b>Lastname: </b>{{ this.currentUser.lastName }}</p>
    <p><b>Address: </b>{{ this.currentUser.address }}</p>
    <p><b>Address 2: </b>{{ this.currentUser.address2 }}</p>
    <p><b>City: </b>{{ this.currentUser.city }}</p>
    <p><b>Postal code: </b>{{ this.currentUser.postCode }}</p>
    <p><b>Country: </b>{{ this.currentUser.country }}</p>
    <p><b>Phone number: </b>{{ this.currentUser.phoneNumber }}</p>
    <p><b>Username: </b>{{ this.currentUser.username }}</p>
    <p><b>Email: </b>{{ this.currentUser.email }}</p>
    <p><b>Id#: </b>{{ this.currentUser.id }}</p>

  </template>
  <template v-else>
    <LoadingSpinner/>
  </template>

</template>

<style scoped>
</style>