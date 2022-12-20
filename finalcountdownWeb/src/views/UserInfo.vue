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
  }
})
</script>

<template>
  <h2>User Info</h2>
  <div v-if="user">

    <!-- <table>
      <pre class="formattedTable">{{ JSON.stringify(user, null, 3) }}</pre>

    </table> -->

    <h2>Personal data of {{ user.username }}</h2>

    <p><b>Firstname: </b>{{ user.firstName }}</p>
    <p><b>Lastname: </b>{{ user.lastName }}</p>
    <p><b>Address: </b>{{ user.address }}</p>
    <p><b>Address 2: </b>{{ user.address2 }}</p>
    <p><b>City: </b>{{ user.city }}</p>
    <p><b>Postal code: </b>{{ user.postCode }}</p>
    <p><b>Country: </b>{{ user.country }}</p>
    <p><b>Phone number: </b>{{ user.phoneNumber }}</p>
    <p><b>Username: </b>{{ user.username }}</p>
    <p><b>Email: </b>{{ user.email }}</p>
    <p><b>Id#: </b>{{ user.id }}</p>
    <p><b>Admin: </b>{{ user.admin }}</p>
  </div>
  <div v-else>
    <LoadingSpinner />
  </div>
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
  background-color: #02527d;
  /* Green */
  width: 75px; 
  color: white;
  padding: 10px 10px;
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

.listimage {

  width: 150px;
  height: 150px;

}
</style>