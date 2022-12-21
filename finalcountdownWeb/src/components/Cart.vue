<script>
//for shopping cart
import { mapStores } from "pinia";
import { useCartStore } from "@/store/cart";

export default {

    computed: {
    ...mapStores(useCartStore),    
  },

}

methods: {

    removeFromCart(productId) {
            this.cart = this.cart.filter(item => item.id !== productId);
            alert(`Product ${productId} removed from cart`)
        },
        clear() {
            this.cart = [];
        },
        
}


</script>

<template>

</template>

<style>

</style>