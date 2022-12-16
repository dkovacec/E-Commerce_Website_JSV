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
    <pre>{{ this.currentUser }}</pre>
  </template>
  <template v-else>
    <LoadingSpinner/>
  </template>

</template>

<style scoped>
</style>