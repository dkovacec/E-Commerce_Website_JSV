import HomeView from "../views/HomeView.vue";
import SignUp from '../views/SignUpView.vue';
import Login from '../views/LoginView.vue';
import ListOfCategories from '../views/ListOfCategoryView.vue';
import AddCategory from '../views/AddCategoryView.vue';
import UserInfo from '../views/userInfoView.vue';
import UserList from '../views/userListView.vue';
import UserProfile from '../views/UserProfileView.vue';
import Logout from "../views/LogoutView.vue";

import PageNotFoundView from "../views/PageNotFoundView.vue";

export const routes = [

    {
        path: '/',
        name: 'Home',
        component: HomeView,
        meta: {
            requiresAuth: false
        }
    },
    {
        path: '/signup',
        name: 'SignUp', component: SignUp,
        meta: {
            requiresAuth: false
        }
    },
    {
        name: "logout",
        path: "/logout",
        component: Logout,
        meta: {
            requiresAuth: true
        }
    },
    {
        name: "userListView",
        path: "/user",
        component: UserList,
        meta: {
            requiresAuth: true
        }
    },
    {
        name: "userInfoView",
        path: "/user/:userId",
        component: UserInfo,
        props: route => ({ userId: Number(route.params.userId) }),
        meta: {
            requiresAuth: true
        }
    },
    {
        name: "profileView",
        path: "/profile",
        component: UserProfile,
        meta: {
            requiresAuth: true
        }
    },

    {
        path: '/login',
        name: 'Login',
        component: Login, meta: {
            requiresAuth: false
        }
    },
    {
        path: '/categorylist',
        name: 'Categories',
        component: ListOfCategories
    },
    { 
        path: '/categoryadd',
        name: 'AddCategories', 
        component: AddCategory 
    },

    {
        path: '/:pathMatch(.*)*', 
        name: '404error', 
        component: PageNotFoundView
    }

]