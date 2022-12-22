<script>
//for shopping cart
import router from '../router';
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useCartStore } from "@/store/cart";
import { useAuthStore } from "@/store/auth";

export default {
    mounted: function () {
        this.getTotalPrice(),
        this.fetchCurrentUser()

    },

    data() {
        return {
            
         currentUser: null,
            totalSum: 0,
        }
    },

    computed: {
        totalItem: function () {
            let sum = 0;
            for (let i = 0; i < this.cartStore.cart.length; i++) {
                sum += (parseFloat(this.cartStore.cart[i].price) * parseFloat(this.cartStore.cart[i].quantity));
            }

            this.totalSum = sum

            return this.totalSum;
        },
        // ...mapState(useAuthStore, ["isAuthenticated", "user"] ),
        ...mapStores(useCartStore),

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
        async getProduct() {
            for (prod in this.cartStore.cart) {
                let urlGet = '/api/products/' + prod.id

                try {
                    let response = await fetch(urlGet);
                    this.productList = await response.json();

                } catch (error) {
                    console.log("Error: ", error);

                }
            }
        },

        multiplyForTotalPrice(x, y) {
            return x * y
        },
        getTotalPrice() {
            this.totalItem
        },
        clear() {
            // this.cart = [];
            this.cartStore.clear()
            this.getTotalPrice()
            router.push({ path: '/home' })
        },
    }
}

</script>

<template>
    
 <section v-show="(this.cartStore.cart.length >=1)">
    <h1>Thank you for your purchase  {{ this.currentUser?.firstName }}!</h1>
    <p>This invoice is billed to:</p>
    <ul class="billingData">
        <li>{{ this.currentUser?.firstName }} {{ this.currentUser?.lastName }}</li>
        <li>{{ this.currentUser?.address }}</li>
        <li>{{ this.currentUser?.city }} {{ this.currentUser?.postCode }}</li>
        <li>{{ this.currentUser?.email }}</li>
        <li>{{ this.currentUser?.phoneNumber }}</li>     
    </ul>
</section>

    <table class="cartTable">
        <thead>
            <th>Id</th>
            <th>Image:</th>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total price</th>
        </thead>
        <tbody>
            <tr v-for="product in this.cartStore.cart" :key="product.id">
                <td>{{ product.id }}</td>
                <td><img class="cartImage" :src=product.imageName></td>
                <td>{{ product.name }}</td>
                <td> € {{ product.price }}</td>
                <td>{{ product.quantity }}</td>
                <td>€ {{ product.price * product.quantity }}</td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td class="totalPrice" colspan="6">Total price: €{{ this.totalSum }}</td>
            </tr>

        </tfoot>
    </table>
    <button class="buttonHome" @click="clear()">Return to Homepage</button>
</template>

<style scoped>
.cartImage {
    width: 125px;
    height: 125px;
}

.cartTable {
  /*border-spacing: 0;*/
  border-collapse: collapse;
  margin-left: auto;
  margin-right: auto;
  text-align: center;
}

.cartTable th, .cartTable td {
  border: 2px black solid;
  padding: 5px;
}

.cartTable th {
  background-color: black;
  color: white;
  margin: 2px;
  /* border: 2px solid white; */

}

.cartTable tfoot td {
  background-color: #eee;
}

/* :nth-child - pseudo-class*/
.cartTable tbody tr:nth-child(even) {
  background-color: #ccc;
}

.cartTable tbody tr:hover {
  
  background-color: #555;
  color: white;
}

.cartTable caption {
  margin-top: 3px;
  caption-side: bottom;
}

.totalPrice {
    font-weight: bold;
    font-size: 1.3em;
    text-align: right;

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

.buttonHome {
  background-color: blue;
  float: left;
  width: 175px;
  font-weight: bold;
  color: white;
  padding: 5px 10px;
  margin: 4px 2px;
  text-align: center;
  text-decoration: none;
  cursor: pointer;
  font-size: 16px;
  border: 1px solid black;
  border-radius: 5px;
  box-shadow: 0px 3px 5px #000;
}


.billingData {

}

.billingData li {
    display: block;
    text-decoration: none;

}
</style>