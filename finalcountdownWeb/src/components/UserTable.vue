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
        <th>is Admin?</th>
        <th>Details</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>

      <tr v-for="user in this.users" :key="user.id">
        <td>{{ user.id }}</td>
        <td>{{ user.username }}</td>
        <td>{{ user.firstName }}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.admin }}</td>
        <td><router-link :to="{ name: 'userInfo', params: { userId: user.id } }" class="buttonEdit">Profile</router-link></td>
        <td>
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

  border: 1px solid black;
}



.formattedTable th:nth-child(1),
.formattedTable th:nth-child(2) {

  border-right: 1px solid white;
}


.formattedTable {
  /*border-spacing: 0;*/
  border-collapse: collapse;
}

.formattedTable th,
.formattedTable td {

  padding: 5px;
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

.formattedTable caption {
  margin-top: 3px;
  caption-side: bottom;
}

.input[type="checkbox"] {

  background-color: #000;
  margin: 2px;
  font: inherit;
  color: currentColor;
  width: 1.5em;
  height: 1.5em;
  border: 0.25em solid currentColor;
  border-radius: 0.15em;
  transform: translateY(-0.075em);
}

.buttonEdit {
  background-color: #000;
  margin: 2px;
  font: inherit;
  color: currentColor;
  width: 1.5em;
  height: 1.5em;
  border: 0.25em solid currentColor;
  border-radius: 0.15em;
  transform: translateY(-0.075em);
}

.buttonEdit {
  background-color: #02527d;
  /* Green */
  width: 75px;
  color: white;
  padding: 5px 10px;
  margin: 4px 2px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16p;
  border: 1px solid blue;
  border-radius: 5px;
  box-shadow: 0px 3px 5px #000;
}

.buttonDelete {

  background-color: #380000;
  width: 75px;
  color: yellow;
  padding: 5px 10px;
  margin: 4px 2px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  border: 1px solid crimson;
  border-radius: 5px;
  box-shadow: 0px 3px 5px #000;
}

.listimage {

  width: 150px;
  height: 150px;


}
</style>