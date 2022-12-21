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
  <button class="buttonLogout" @click="logout" v-if="authStore.isAuthenticated">Logout</button>
</template>
<style scoped>
.buttonLogout {
  background-color: #380000;
  width: 75px;
  height: 40px;
  color: yellow;
  padding: 10px 10px;
  margin: 4px 2px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  border: 1px solid crimson;
  border-radius: 5px;
  box-shadow: 0px 3px 5px #000;
}

</style>