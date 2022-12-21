<script>
//for shopping cart
import { mapStores } from "pinia";
import { useCartStore } from "@/store/cart";

export default {
    mounted: function () {
        this.created()       
    },
    data() {
        return {
            //productList: [],
            categoryList: [],
            product: {},
            quantity: 1,
        };
    },

    computed: {
    ...mapStores(useCartStore),    
  },

    methods: {
        async getCategories() {
            let url = '/api/categories'
            try {
                let response = await fetch(url);
                this.categoryList = await response.json();
                this.totalCategories = this.categoryList.length;
            } catch (error) {
                console.log("Error: ", error)
            }
        },
        async getProduct() {
            let productId = this.$route.params.id
            //let urlGet = '/api/categories/1/products'
            let urlGet = '/api/products/' + this.$route.params.productid
            //let urlGet = '/api/categories/' + this.$route.params.id + '/products'
            //let urlGet = '/api/products/1'
            try {
                let response = await fetch(urlGet);
                this.product = await response.json();
                // console.log("get-product " + this.product.id);
            } catch (error) {
                console.log("Error: ", error);

            }
        },      
        
                    
        created() {
            this.getCategories();
            this.getProduct();
            // console.log("cartarray " + this.cart);
            // let prodId2 = this.$route.params.productid
            // console.log("prodId " + this.prodId2)
        },

        // //for shopping cart
        addToCart() {
            this.cartStore.addToCart(this.product.id, this.product.name, this.product.price, this.product.imageName, this.quantity);
            alert(`Product ${this.product.name} added to cart`);
            // console.log("Showcart: ", cart);
        },

    
        // clicked() {           
        //     this.created(),
        //     this.$router.go('/api/categories/' + category.id + '/products')           
            
        // }
    }
}
</script>

<template>


<section class="productscategorized">

<section class="categorylisted">
<h2 class="categories">Categories</h2>

<nav class="verticalMenu">

    <ul>
        <li v-for="category in categoryList" :key="category.id">
            <router-link :to="{name:'ProductsInCategory', params: {id: category.id, name: category.name}}">{{ category.name }} </router-link></li>
    </ul>

</nav>

</section>


 <section class="productCard">

    <h2 class="productdetailtitle">{{ product.name }}</h2>

        <p class="productdetailid">Product id: {{ product.id }}</p>
        <p class="productdetailimagebox"><img class="productdetailimage" :src="(`../../${product.imageName}`)"></p>  
        <p class="productdetailsummary"><b>Summary:</b><br><br>{{ product.summary }}</p>
        <p class="productdetailprice"><b>Price:</b> €{{ product.price }}</p>
        <p class="buttondetailPosition">
            Quantity<input type="number" v-model="quantity"/>
            <button class="buttonCart" @click="addToCart()">Add to Cart Button</button>
        </p>

        <p class="productdetaildescription"><b>Description:</b><br><br>{{ product.description }} </p>
        <p class="productdetailweight"><b>Weight:</b> {{ product.weight }}g</p>

  

</section>


</section>


</template>

<style>
.productDetailCard {
    /*border: 1px solid rgba(113, 110, 110, 1);*/
    min-height: 450px;
    width: 90%;
    margin: auto;
    /*margin-right: auto;*/
    padding: 8px 8px 8px 8px;
}
.productdetailimagebox{
    /*border: 1px solid rgba(113, 110, 110, 1);*/    
    width: 380px;
    margin: 10px;
    float: left;
}
.productdetailimage {
    position: relative;
    width: 95%;
    padding: 3px;
}
.productdetailtitle{
    /*border: 1px solid rgba(113, 110, 110, 1);*/
    background-color: rgb(216, 220, 225);
    padding: 15px;
    margin: 0;
}
.productdetailid {
    font-size: 0.7em;
    text-align: right;
    font-weight: bold;
    padding: 10px;     
}
.summary {
    font-size: 1em;
    text-align: justify;
    padding: 5px; 
}
.price {
    font-size: 1.4em;
    text-align: right;
    padding: 5px; 
}
.buttondetailPosition {
    position: relative;
    margin-left: auto;
    /*border: 1px solid blue;*/
    width: 150px;
}
.buttonCart {
	background-color: rgb(76, 151, 244);
    width: 150px;
	color: black;
	padding: 5px 5px;
    margin-bottom: 15px;
	text-align: center;
	text-decoration: none;
	font-size: 16px;
    Font-weight: bold;
	border: 1px solid rgb(167, 185, 203);
	border-radius: 5px;
    box-shadow: 0px 3px 5px #000;
}
.buttonMore:hover {
	background-color: rgb(13, 57, 111);
    width: 150px;
	color: white;
	padding: 5px 5px;
    margin-bottom: 15px;
	text-align: center;
	text-decoration: none;
	font-size: 16px;
	border: 1px solid rgb(167, 185, 203);
	border-radius: 5px;
    box-shadow: 0px 3px 5px #000;
    cursor: pointer;
}
/*CategoryMenu*/
.categorylisted {
    /*border: 1px solid black;*/
    min-height: 450px;
    width: 22%;
    float: left;
    margin-right: auto;
    /*margin-right: auto;*/
    padding: 5px;
}
.categories {
    color: gray;
    font-size: 1.3em;
}
.verticalMenu {
    position: relative;
    margin: 0;
    padding: 0;
    text-align: center;
    box-shadow: 0px 3px 5px #000;
    background-color: white;
    /*display: inline-block;*/
    /*overflow: hidden;*/
    width: 98%;
 
}
.verticalMenu ul {
    margin: 0;
    padding: 0;
}
.verticalMenu li {
    padding: 0;
    margin-bottom: 5px;
    text-align: left;
    list-style: none;
    border: 1px solid rgba(113, 110, 110, 0.4);
}
.verticalMenu a {
    text-decoration: none;
    color: black;
    padding: 3px;
    margin: 0;
    display: block;
    font-size: 1.4em;
}
.verticalMenu li a:hover {
    cursor: pointer;
    color: lightcyan;
    background-color: black;
}
.verticalMenu li a:active {
    color: black;
    background-color: rgb(216, 220, 225);
}
</style>