
<script>
export default {
    mounted: function () {
        //this.fetchData()       
    },

    data() {
        return {
            productList: [],
            categoryList: [],
            totalProducts: 0   

        };
    },

    created () {
        this.$watch( () => this.$route.params, () => {
            this.fetchData();
        }, {
            immediate:true
        } )
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

        async getProducts() {
            //let urlGet = '/api/categories/1/products'
            let urlGet = '/api/categories/' + this.$route.params.id + '/products'
            try {

                let response = await fetch(urlGet);
                this.productList = await response.json();
                this.totalProducts = this.productList.length;
            } catch (error) {
                console.log("Error: ", error)

            }
        },   
                    
        fetchData() {
            this.getCategories();
            this.getProducts();
        },
    

        clicked() {           
            // this.fetchData(),
            // this.$router.go('/api/categories/' + category.id + '/products')           
            
        }

    }
}
</script>

<template>
<h1>{{ this.$route.params.name }}</h1>

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

        <section class="productsamount">
            Total number of products in category: {{ this.$route.params.name }} (id: {{ this.$route.params.id }}) <span> {{ totalProducts }}</span>
        </section>

            <section class="productCard" v-for="product in productList" :key="product.id">
        <h2 class="producttitle">{{ product.name }}</h2>
        <p class="productimagebox"><img class="productimage" :src="(`../../${product.imageName}`)"></p>   <!-- :src="require(`@${product.imageName}`)"    :src=product.imageName-->
        <p class="productid">Product id: {{ product.id }}</p>
        <p class="summary"><b>Short description:</b><br><br> {{ product.summary }}</p>
        <p class="price"><b>Price:</b> €{{ product.price }}</p>
        <p class="buttonPosition">
            <router-link :to="{name:'ProductDetail', params: {productid: product.id}}">
                    <button class="buttonMore">More info</button>
                </router-link>

        </p>

      

    </section>


</section>

</template>

<style>

/*Products*/
.productCard {
    border: 1px solid rgba(113, 110, 110, 0.1);
    min-height: 380px;
    width: 73%;
    margin-left: auto;
    /*margin-right: auto;*/
    padding: 8px 8px 8px 8px;

}

.productimagebox{
    /*border: 1px solid black;*/
    height: 285px;
    margin: 15px;
    float: left;

}
.productimage {
    height: 275px;
    padding: 3px;
}
.producttitle{
    background-color: rgb(216, 220, 225);
    padding: 15px;
    margin: 0;
}

.productscategorized {
    /*border: 1px solid black;*/
    background-color: rgb(243, 244, 245);
}

.productid {
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

.buttonPosition {
    position: relative;
    margin-left: auto;
    /*border: 1px solid blue;*/
    width: 150px;

}
.buttonMore {
	background-color: rgb(216, 220, 225);
    width: 150px;
	color: black;
	padding: 5px 5px;
    margin-bottom: 15px;
	text-align: center;
	text-decoration: none;
	font-size: 16px;
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
.productsamount {
    font-size: 0.7em;
    text-align: right;
    font-weight: bold;
    padding: 10px;
    color: gray;

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