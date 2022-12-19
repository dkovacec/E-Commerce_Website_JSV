<script>
import { defineComponent } from "vue";
import LoadingSpinner from "../components/LoadingSpinner.vue";
export default defineComponent({
  components: { LoadingSpinner },
  created() {
    this.retrieveUserData(this.userId);
  },
  props: {
    userId: {
      type: Number,
      required: true,
    }
  },
  data() {
    return {
      user: null,
    }
  },
  methods: {
    async retrieveUserData(userId) {
      const response = await fetch(`/api/users/${userId}`)
      setTimeout(async () => {
        if (response.ok) {
          this.user = await response.json();
        }
      }, 3000) // setTimeout is only for showing the usage of loadingSpinners!
    },
  }
})
</script>

<template>
  <h2>User Info</h2>
  <div v-if="user">
    <pre>{{ JSON.stringify(user, null, 2) }}</pre>
  </div>
  <div v-else>
    <LoadingSpinner/>
  </div>
</template>

<style scoped>
</style>