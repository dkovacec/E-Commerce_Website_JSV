import { createRouter, createWebHistory, useRoute }
    from "vue-router";
    import LoginSignUp from '../views/LoginSignUpView.vue';
   
    
    const routes = [
        { path: '/loginsignup', name: 'LoginSignUp', component: LoginSignUp },
  
    ]
    
    const router = createRouter({
        history: createWebHistory(),
        routes
    })
export default router
