<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "../store/auth";
export default defineComponent({
  methods: {
    logout() {
      this.authStore.logout()
          .then(() => this.$router.push({ name: 'home' }))
    },
  },
  computed: {
    ...mapStores(useAuthStore)
  }
});
</script>

<template>
  <section class="logoutForm">
  <p>Are you sure that you want to logout?</p>
  <button class="buttonLogout" @click="logout" v-if="authStore.isAuthenticated">Logout</button>
</section>
</template>
<style scoped>
.buttonLogout {
  background-color: #1f0cc9;
  width: 80px;
  height: 40px;
  color: white;
  padding: 10px 10px;
  margin-left: 27.5%;
  margin-right: auto;
  text-align: center;
  text-decoration: none;
  display: block;
  font-size: 16px;
  border: 1px solid rgb(0, 0, 0);
  border-radius: 5px;
  box-shadow: 0px 3px 5px #000;
}

.logoutForm {
	width: 400px;
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

</style>