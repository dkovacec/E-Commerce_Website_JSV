<script>
export default {

    methods: {

        async getCart() {
            try {
                this.cart = await response.json();
                this.totalCart = this.cart.length;
            } catch (error) {
                console.log("Error: ", error)
            }
        }
}

}





</script>

<template>

</template>

<style>

</style>