<script>
import { defineComponent } from "vue";
import { mapState } from "pinia";
import { useAuthStore } from "@/store/auth";
export default defineComponent({
  computed: {
    ...mapState(useAuthStore, ["isAuthenticated"])
  },
});
</script>

<template>
  <ul>
    <li v-if="!isAuthenticated">
      <router-link :to="{ name: 'register' }">Register</router-link>
    </li>
    <li v-if="!isAuthenticated">
      <router-link :to="{ name: 'login' }">Login</router-link>
    </li>
    <li v-if="isAuthenticated">
      <router-link :to="{ name: 'logout' }">Logout</router-link>
    </li>
    <li v-if="isAuthenticated">
      <router-link :to="{ name: 'userList' }">Users</router-link>
    </li>
    <li v-if="isAuthenticated">
      <router-link :to="{ name: 'profile' }">Profile</router-link>
    </li>
  </ul>
</template>

<style scoped>
</style>