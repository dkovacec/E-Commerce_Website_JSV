<script>
//for shopping cart
import { mapStores } from "pinia";
import { useCartStore } from "@/store/cart";

export default {

    computed: {
    ...mapStores(useCartStore),    
  },

}






</script>

<template>

</template>

<style>

</style>