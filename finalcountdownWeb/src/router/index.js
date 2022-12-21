import { createRouter, createWebHistory}

    from "vue-router";
    import { routes } from "../router/routes";
    import { useAuthStore } from "../store/auth";

    //for shopping cart
    import { useCartStore } from "../store/cart";


export const router = createRouter({
    history: createWebHistory(),
    routes: routes,
    strict: true
})

   
router.beforeEach((to, _) => {
    const authStore = useAuthStore()
    if (to.meta.requiresAuth && !authStore.isAuthenticated) {
        return { name: 'login' }
    }
    const cart = useCartStore();

});
export default router;

