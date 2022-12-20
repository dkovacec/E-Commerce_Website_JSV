import AddCategory from '../views/AddCategoryView.vue';
import AddProduct from '../views/AddProductView.vue';
import EditCategory from '../views/EditCategoryView.vue';
import EditProduct from '../views/EditProductView.vue';
import EditUser from '../views/EditUserView.vue';
import Home from "../views/Home.vue";
//import HomeView from "../views/HomeView.vue";
import ListOfCategories from '../views/ListOfCategoryView.vue';
import ListOfProducts from '../views/ListOfProductsView.vue';
import Login from '../views/Login.vue';

import Logout from "../views/Logout.vue";
import PageNotFoundView from "../views/PageNotFoundView.vue";
import ProductDetail from '../views/ProductDetailView.vue';
import ProductsInCategory from '../views/ProductsInCategoryView.vue';
import Register from '../views/Register.vue';

import UserInfo from '../views/UserInfo.vue';
import UserList from '../views/UserList.vue';
import UserProfile from '../views/UserProfile.vue';
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
        
        // { name: 'home', 
        //     path: '/', 
        //     alias: "/home",
        //     component: HomeView, 
        //          meta: {
        //         requiresAuth: false
        //     }
        // },
                
                
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
            path: '/editUser/:uId',
            name: 'EditUser', 
            component: EditUser,
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
            component: ListOfCategories,
                 meta: {
                requiresAuth: true
            }
        },
        { 
            path: '/categoryadd',
            name: 'AddCategories', 
            component: AddCategory,
                 meta: {
                requiresAuth: true
            }
        },
        
        { path: '/category/:id', name: 'EditCategory', component: EditCategory,
         meta: {
                requiresAuth: true
            }
        },
        
        { path: '/productlist', name: 'AllProducts', component: ListOfProducts,
         meta: {
                requiresAuth: true
            }
            },
        
        { path: '/productadd', name: 'AddProduct', component: AddProduct,
                 meta: {
                requiresAuth: true
            }
    
        },
        
        { path: '/product/:id', name: 'EditProduct', component: EditProduct,
                 meta: {
                requiresAuth: true
            }
    
        },
        
        { path: '/productsincategory/:name/:id', name: 'ProductsInCategory', component: ProductsInCategory,
         meta: {
                requiresAuth: false
            }
        },
        
        { path: '/productdetail/:productid', name: 'ProductDetail', component: ProductDetail,
    
         meta: {
                requiresAuth: false
            }
            },
  
    
        {
            path: '/:pathMatch(.*)*', 
            name: '404error', 
            component: PageNotFoundView,
            
            meta: {
                requiresAuth: false
            }
        }
]