import { createRouter, createWebHistory}

    from "vue-router";
    import { routes } from "../router/routes";
    import { useAuthStore } from "../store/auth";


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
});
export default router;