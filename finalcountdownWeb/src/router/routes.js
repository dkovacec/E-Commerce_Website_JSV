
import ListOfCategories from '../views/ListOfCategoryView.vue';
import AddCategory from '../views/AddCategoryView.vue';
import Home from "../views/Home.vue";
import Register from '../views/Register.vue';
import Login from '../views/Login.vue';
import UserInfo from '../views/UserInfo.vue';
import UserList from '../views/UserList.vue';
import UserProfile from '../views/UserProfile.vue';
import Logout from "../views/Logout.vue";
import PageNotFoundView from "../views/PageNotFoundView.vue";

export const routes = [

    {
        name: "home",
        path: "/",
        alias: "/home",
        component: Home,
        meta: {
            requiresAuth: false
        }
    },
    {
        name: "register",
        path: "/register",
        component: Register,
        meta: {
            requiresAuth: false
        }
    },
    {
        name: "login",
        path: "/login",
        component: Login,
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
        name: "userList",
        path: "/user",
        component: UserList,
        meta: {
            requiresAuth: true
        }
    },
    {
        name: "userInfo",
        path: "/user/:userId",
        component: UserInfo,
        props: route => ({ userId: Number(route.params.userId)}),
        meta: {
            requiresAuth: true
        }
    },
    {
        name: "profile",
        path: "/profile",
        component: UserProfile,
        meta: {
            requiresAuth: true
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