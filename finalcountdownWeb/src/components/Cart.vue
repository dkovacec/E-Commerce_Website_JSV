<script>
//for shopping cart
import router from '../router';
import { mapStores } from "pinia";
import { useCartStore } from "@/store/cart";

export default {
    mounted: function () {
        this.getTotalPrice()

    },

    data() {
        return {
            productList: [],
            totalSum: 0,
        }
    },

    computed: {
        totalItem: function () {
            let sum = 0;
            for (let i = 0; i < this.cartStore.cart.length; i++) {
                sum += (parseFloat(this.cartStore.cart[i].price) * parseFloat(this.cartStore.cart[i].quantity));
            }

            this.totalSum=sum

            return this.totalSum;
        },



        ...mapStores(useCartStore),

    },



    methods: {
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

        removeFromCart(productId) {
            this.cartStore.removeFromCart(productId)
            alert(`Product ${productId} removed from cart`)
            this.getTotalPrice()
        },

        clear() {
            // this.cart = [];
            this.cartStore.clear()
            this.getTotalPrice()
        },


        multiplyForTotalPrice(x, y) {
            return x * y
        },


        getTotalPrice() {
            this.totalItem
        },
        completePurchase(){
        router.push({ path: '/purchase' })
    }
    }
}




</script>

<template>
    <h1>Products in your cart</h1>


    <table class="cartTable">
        <thead>
            <th>Id</th>
            <th>Image:</th>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total price</th>
            <th>Actions</th>
        </thead>
        <tbody>
            <tr v-for="product in this.cartStore.cart" :key="product.id">
                <td>{{ product.id }}</td>
                <td><img class="cartImage" :src=product.imageName></td>
                <td>{{ product.name }}</td>
                <td> € {{ product.price }}</td>
                <td>{{ product.quantity }}</td>
                <td>€ {{ product.price * product.quantity }}</td>
                <td><button class="buttonDelete" @click="removeFromCart(product.id)">Remove from cart</button></td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td class="totalPrice" colspan="7"> 

                    <button class="buttonBuy" v-show="(this.cartStore.cart.length >=1)" @click="completePurchase()">Complete purchase</button>
                    <button class="buttonDeleteCart" v-show="(this.cartStore.cart.length >=1)" @click="clear()">Empty the cart</button>Total price: €{{this.totalSum}}</td>
            </tr>

        </tfoot>
    </table>



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
}

.cartTable th, .cartTable td {

  padding: 5px;
}

.cartTable th {
  background-color: black;
  color: white;
  margin: 2px;
  border: 2px solid white;

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



.buttonBuy {
  background-color: green;
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

.buttonDelete {
  background-color: red;
  width: 175px;
  font-weight: bold;
  color: white;
  padding: 5px 10px;
  margin: 4px 2px;
  text-align: center;
  text-decoration: none;
  float: left;
  cursor: pointer;
  font-size: 16px;
  border: 1px solid black;
  border-radius: 5px;
  box-shadow: 0px 3px 5px #000;
}

.buttonDeleteCart {
  background-color: red;
  width: 175px;
  font-weight: bold;
  color: white;
  padding: 5px 10px;
  margin: 4px 2px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
  border: 1px solid black;
  border-radius: 5px;
  box-shadow: 0px 3px 5px #000;
}



</style>