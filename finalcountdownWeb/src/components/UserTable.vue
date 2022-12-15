<script>
import { defineComponent } from "vue";
export default defineComponent({
  props: {
    users: {
      type: Array,
      default: () => []
    }
  }
});
</script>

<template>

  <table>
    <thead>
    <tr>
      <th>ID</th>
      <th>Username</th>
      <th>Info</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="user in this.users" :key="user.id">
      <td>{{ user.id }}</td>
      <td>{{ user.username }}</td>
      <td><router-link :to="{ name: 'userInfo', params: { userId: user.id}}">ℹ️</router-link></td>
    </tr>
    </tbody>

  </table>

</template>

<style scoped>
</style>