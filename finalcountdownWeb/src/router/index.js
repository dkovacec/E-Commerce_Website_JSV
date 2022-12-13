import { createRouter, createWebHistory, useRoute }
    from "vue-router";
    import SignUp from '../views/SignUpView.vue';
    import Login from '../views/LoginView.vue';
   
    
    const routes = [
        { path: '/signup', name: 'SignUp', component: SignUp },
        { path: '/login', name: 'Login', component: Login },
  
    ]
    
    const router = createRouter({
        history: createWebHistory(),
        routes
    })
export default router
