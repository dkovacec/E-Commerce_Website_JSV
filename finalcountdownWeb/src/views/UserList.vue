<script>
import { defineComponent } from "vue";
import UserTable from "../components/UserTable.vue";
export default defineComponent({
  name: "UserList",
  components: { UserTable },
  data() {
    return {
      users: [],

    }
  },
  created() {
    this.fetchUsers();
  },
  methods: {
    
    fetchUsers() {
      fetch('/api/users/users', {})
          .then(response => response.json())
          .then(data => {
            console.log('data', data)
            this.users = data;
          })
          .catch(error => console.log('error', error))
    },
  
  }
})
</script>

<template>
  <UserTable :users="this.users"></UserTable>
  
</template>

<style scoped>
</style>