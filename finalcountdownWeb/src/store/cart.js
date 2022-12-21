import { defineStore } from "pinia";
export const useCartStore = defineStore('cart', {
    state: () => ({
        cart: [],
        totalCart: 0
    }),
    actions: {
        addToCart(productId, productName, productPrice, quantity) {
            this.cart.push({id: productId, 
                name: productName,
                price: productPrice,
                quantity: quantity});



            alert(`Product ${productId} added to cart`)
        },
        removeFromCart(productId) {
            this.cart = this.cart.filter(item => item.id !== productId);
            alert(`Product ${productId} removed from cart`)
        },
        clear() {
            this.cart = [];
        },
    }
});