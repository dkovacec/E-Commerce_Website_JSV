<script>
import { defineComponent } from "vue";
import router from '../router';
export default defineComponent({
  props: {
    users: {
      type: Array,
      default: () => []
    }
  },
  methods: {
    // async getUser() {
    //   let urlGetUser = '/api/users/users'
    //   try {
    //     let response = await fetch(urlGetUser);
    //     this.users = await response.json();
    //     console.log(this.users)
    //   } catch (error) {
    //   }
    // },
    // created() {
    //   this.getUser();
    // },

    async deleteUser(userId) {
      if (confirm('Do you really want to delete this user ?')) {
        let urlDelete = `/api/users/${userId}`
        let response = await fetch(urlDelete, {
          method: 'DELETE'
        }).then(response => {
          if (!response.ok) {
            return Promise.reject("Error")
          }
        }).catch(error => alert("Cannot delete this user"))

        this.getUser();
      }
    },
  }
});
</script>

<template>


  <table class="formattedTable">


    <thead>
      <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Role</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>

      <tr v-for="user in this.users" :key="user.id">
        <td>{{ user.id }}</td>
        <td>{{ user.username }}</td>
        <td>{{ user.firstName }}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.admin ? "Admin" : "User"}}</td>
        <!-- <td><router-link :to="{ name: 'userInfo', params: { userId: user.id } }" class="buttonProfile">Profile</router-link></td> -->
        <td>
          <router-link :to="{ name: 'userInfo', params: { userId: user.id } }"><button class="buttonProfile">Profile</button></router-link>
          <router-link :to="{ name: 'EditUser', params: { uId: user.id } }">
            <button class="buttonEdit">Edit</button>
          </router-link>
          <button class="buttonDelete" @click="deleteUser(user.id)">Delete</button>
        </td>
      </tr>

    </tbody>

  </table>

</template>
<style scoped>
.formattedTable,
.formattedTable td {
  border:2px solid black;
  margin-left: auto;
  margin-right: auto;
}



.formattedTable th:nth-child(1),
.formattedTable th:nth-child(2) {

  border-right: 0px solid white;
}


.formattedTable {
  /*border-spacing: 0;*/
  border-collapse: collapse;
}

.formattedTable th,
.formattedTable td {
  padding: 15px;
  text-align: center;
}

.formattedTable th {
  background-color: black;
  color: white;

}

.formattedTable tfoot td {
  background-color: #eee;
}

/* :nth-child - pseudo-class*/
.formattedTable tbody tr:nth-child(even) {
  background-color: #ccc;
}

.formattedTable tbody tr:hover {
  cursor: pointer;
  background-color: #555;
  color: white;
}

/* .formattedTable caption {
  margin-top: 3px;
  caption-side: bottom;
} */

.buttonEdit {
  background-color: green;
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

.buttonProfile {
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

.buttonDelete {

  background-color: red;
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