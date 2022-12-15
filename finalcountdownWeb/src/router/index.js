import { createRouter, createWebHistory, useRoute }

    from "vue-router";
    import HomeView from "../views/HomeView.vue";
    import SignUp from '../views/SignUpView.vue';
    import Login from '../views/LoginView.vue';
    import ListOfCategories from '../views/ListOfCategoryView.vue';
    import AddCategory from '../views/AddCategoryView.vue';
    import ListOfProducts from '../views/ListOfProductsView.vue';
    import AddProduct from '../views/AddProductView.vue';

    import PageNotFoundView from "../views/PageNotFoundView.vue";

   
   

    const routes = [

        {
            path: '/', name: 'Home', component: HomeView
        },
        { path: '/signup', name: 'SignUp', component: SignUp },

        { path: '/login', name: 'Login', component: Login },
        { path: '/categorylist', name: 'Categories', component: ListOfCategories },
        { path: '/categoryadd', name: 'AddCategories', component: AddCategory },
        { path: '/productlist', name: 'AllProducts', component: ListOfProducts },
        { path: '/productadd', name: 'AddProduct', component: AddProduct },

        {
            path: '/:pathMatch(.*)*', name: '404error', component: PageNotFoundView
        }
 
    ]

   
    const router = createRouter({
        history: createWebHistory(),
        routes
    })

export default router