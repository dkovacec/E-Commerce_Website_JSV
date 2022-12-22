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
  <p>Are you sure that you want to logout?</p>
  <button id="buttonLogout" @click="logout" v-if="authStore.isAuthenticated">Logout</button>
</template>

<style scoped>

#buttonLogout {
  background-color: blue;
  width: 90px;
  font-weight: bold;
  color: white;
  padding: 5px 10px;
  margin: 4px 2px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  border: 1px solid black;
  border-radius: 5px;
  box-shadow: 0px 3px 5px #000;
  cursor: pointer;
}
</style>