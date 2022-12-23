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

<hr>
<h1 class="title">DigitLion</h1>
<p class="text">Best gaming and computing equipment you can find online. Browse through our offers and find whatever you need.</p>
<hr>
<HomeMain></HomeMain>

  <!-- <p>This application provides a simple introduction for enabling user authentication for a VueJS web application with a Spring Boot
    backend.</p>

  <p>This example uses <abbr title="JSON Web Token">jwt</abbr> for storing and transporting login information.</p> -->

  <!-- <div class="authenticated" v-if="authStore.isAuthenticated">
    You are only seeing this message when you are logged in!
    Great you just logged inn
  </div> -->





</template>

<style scoped>
.authenticated {
  background-color: lightcoral;
}

.mainBanner {
  border: 0px solid black;
  margin-top: -50px;
  width: 99%;
  padding: 0;
  margin-left: auto;
  margin-right: auto;
}

.banner {
  width: 100%;
  margin: 0;
  margin-left: auto;
  margin-right: auto;
}


.title{
  text-align: center;
  font-variant: small-caps;
}
.text{
  text-align: center;
  font-style: italic;
}



</style>