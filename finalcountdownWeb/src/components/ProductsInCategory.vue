
<script>
export default {
    mounted: function () {
        this.created()
    },

    data() {
        return {

            productList: [],
            totalProducts: 0
        };
    },

    created() {

    },

    methods: {

        async getProducts() {
            //let urlGet = 'api/categories/1/products'
            let urlGet = '/api/categories/' + this.$route.params.id + '/products'
            try {

                let response = await fetch(urlGet);
                this.productList = await response.json();
                this.totalProducts = this.productList.length;
            } catch (error) {
                console.log("Error: ", error)

            }
        },
        created() {
            this.getProducts();
        },

    }

}
</script>

<template>
<h1>{{ this.$route.params.name }} {{ this.$route.params.id }}</h1>

<section class="productscategorized">

    <section class="categorylisted">
  <p>  List of categories</p>
    </section>

    <section class="productCard" v-for="product in productList" :key="product.id">
        <h2 class="producttitle">{{ product.name }}</h2>
        <p class="productimagebox"><img class="productimage" src={{product.imageName}}></p>
        <p class="productid">Product id: {{ product.id }}</p>
        <p class="summary"><b>Short description:</b><br><br> {{ product.summary }}</p>
        <p class="price"><b>Price:</b> €{{ product.price }}</p>
        <p class="buttonPosition">
            <!-- <router-link :to="{name:'ProductInfo', params: {id: product.id}}"> -->
                    <Button class="buttonMore">More info</Button>
                <!-- </router-link> -->

        </p>

    </section>

</section>

</template>

<style>

.productCard {
    border: 1px solid black;
    min-height: 380px;
    width: 73%;
    margin-left: auto;
    /*margin-right: auto;*/
    padding: 8px 8px 8px 8px;

}

.productimagebox{
    border: 1px solid black;
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

.categorylisted {
    border: 1px solid black;
    min-height: 450px;
    width: 22%;
    float: left;
    margin-right: auto;
    /*margin-right: auto;*/
    padding: 8px 8px 8px 8px;
}

.productscategorized {
    border: 1px solid black;
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


</style>