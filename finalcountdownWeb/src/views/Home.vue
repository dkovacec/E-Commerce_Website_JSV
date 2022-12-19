<script>
import HomeMain from '../components/HomeMain.vue';
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "../store/auth";
export default defineComponent({
  components: {
        HomeMain,
  },
  computed: {
    ...mapStores(useAuthStore)
  }
})
</script>

<template>

<h1>BANNER GOES HERE</h1>
<HomeMain></HomeMain>

  <p>This application provides a simple introduction for enabling user authentication for a VueJS web application with a Spring Boot
    backend.</p>

  <p>This example uses <abbr title="JSON Web Token">jwt</abbr> for storing and transporting login information.</p>

  <div class="authenticated" v-if="authStore.isAuthenticated">
    You are only seeing this message when you are logged in!
    Great you just logged inn
  </div>





</template>

<style scoped>
.authenticated {
  background-color: lightcoral;
}
</style>