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
      }, 300) // setTimeout is only for showing the usage of loadingSpinners!
    },
    async deleteUser(userId) {

if(confirm('Do you really want to delete this user ?')){


let urlDelete = `/api/users/${userId}`

    let response = await fetch(urlDelete,{
        method:'DELETE'
    }).then(response => {
        if(!response.ok){
            return Promise.reject("Error")
        }
    }).catch(error => alert("Cannot delete this user"))

    this.getUsers();
}
},
  }
})
</script>

<template>
  <h2>User Info</h2>
  <div v-if="user">
   <table>
        <pre>{{ JSON.stringify(user, null, 3) }}</pre>
    </table>
  </div>
  <div v-else>
    <LoadingSpinner/>
  </div>
</template>

<style scoped>
</style>