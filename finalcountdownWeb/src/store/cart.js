import { defineStore } from "pinia";
export const useCartStore = defineStore('cart', {
    state: () => ({
        cart: [],
        totalCart: 0
    }),
    actions: {
        addToCart(productId, quantity) {
            this.cart.push({id: productId, quantity: quantity});
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