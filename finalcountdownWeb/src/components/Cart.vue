<script>
//for shopping cart
import { mapStores } from "pinia";
import { useCartStore } from "@/store/cart";

export default {
    mounted: function () {
        // this.created()
        // this.getTotalPrice ()
    },

data () {
    return {
        productList: [],
        totalSum: 0,
        // cartList: []
    }
},

    computed: {
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

        multiplyForTotalPrice(x,y) {
            return x*y
        },

        
        getTotalPrice () {
            for (prod in this.cartStore.cart) {
                totalPrice = prod.price*prod.quantity;
                this.totalSum = totalPrice + this.totalSum;

            }
        },


        created() {
            // this.getProduct();
        },
}

}




</script>

<template>
<h1>Products in your cart</h1>
   

    <table>
        <thead>
            <th>Id</th>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total price</th>
            <th>Actions</th>
        </thead>
        <tbody>
            <tr v-for="product in this.cartStore.cart" :key="product.id">
                <td>{{ product.id }}</td>
                <td>{{ product.name }}</td>
                <td> € {{ product.price }}</td>
                <td>{{ product.quantity}}</td>
                <td>€ {{ product.price * product.quantity}}</td>
           <td>Remove button</td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="5">Total price: {{ this.totalSum }}</td>
            </tr>

        </tfoot>
    </table>




</template>

<style>

</style>