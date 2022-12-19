<script>
import ErrorMessage from './ErrorMessage.vue';

export default {
    mounted: function () {
        this.created()
    },

    data() {
        return {
            product: {
                name: "",
                summary: "",
                description: "",
                price: "",
                weight: "",
                imageName: "",
                categoryId: ""                
            },
            errors: {
                name: false,
                summary: false,
                description: false,
                price: false,
                weight: false,
                imageName: false,
                categoryId: false              
            },
            products: [],
            categoryList: [],
            totalProducts: 0
        }
    },

    created() {

    },

    components: {
        ErrorMessage
    },
    methods: {
        processForm() {
            if (!this.product.name.trim()) {
                this.errors.name = true;
            } else {
                this.errors.name = false;
            }

            if (!this.product.description.trim()) {
                this.errors.description = true;
            } else {
                this.errors.description = false;
            }

            let isErrors = false;

            for (let error in this.errors) {
                if (this.errors[error]) {
                    isErrors = true;
                }
            }

            if (!isErrors) {
                console.log("Clicked ")
                this.createProduct(this.product)
                console.log("Clicked 2")
                alert("You have created a new product!")
                this.name = "",
                this.summary = "",
                this.description = "",
                this.price = "",
                this.weight = "",
                this.product.categoryId = "",
                this.product.imageName = "",
                this.errors.name = false;
                this.errors.description = false;
            }
        },
 
        async createProduct(product) {
            try {
                
                let urlProduct = "/api/products"
                let responseProduct = await fetch(urlProduct, {

                    method: 'POST',

                    headers: {
                        'Content-Type': 'application/json'
                    },

                    body: JSON.stringify({
                        name: product.name,
                        summary: product.summary,
                        description: product.description,
                        price: product.price,
                        weight: product.weight,
                        imageName: product.imageName,
                        categoryId: product.categoryId
                    })
                });
                let newProduct = await responseProduct.json();
                alert(`Product inserted with id= ${newProduct.id}`)
            } catch (error) {
                console.log("Error: ", error)
            }
        },

        async getCategories() {
            let url = 'api/categories'
            try {

                let response = await fetch(url);
                this.categoryList = await response.json();
            } catch (error) {
                console.log("Error: ", error)

            }
        },
        created() {
            this.getCategories();
        },

    }
}

</script>

<template>

    <form class="loginform" @submit.prevent="processForm" novalidate>
        <p>
            <label for="productName">Product Name: </label>
            <input type="text" id="productName" v-model="product.name">   
        </p>
        <Message v-show="errors.name" :message="'Name of product should not be empty'"></Message>
        <p>
            <label for="productSummary">Summary (Short description): </label>
            <textarea type="textarea" id="productSummary" v-model="product.summary"></textarea> 
        </p>
        <Message v-show="errors.description" :message="'Short description of product should not be empty'"></Message>

        <p>
            <label for="productDescription">Detailed Description: </label>
            <textarea type="textarea" id="productDescription" v-model="product.description"></textarea> 
        </p>
        <Message v-show="errors.description" :message="'Description of product should not be empty'"></Message>

        <p><label for="productCategoryId">Category: </label>
            <select v-model="product.categoryId" name="productCategoryId" id="productCategoryId">
                    <option v-for="categ in categoryList" :key="categ.id" :value="categ.id">{{ categ.name }} - {{ categ.id }}</option>
            </select>           
        </p>
        <p>
            <label for="productPrice">Price: </label>
            <input type="text" id="productPrice" v-model="product.price">   
        </p>

        <p>
            <label for="productWeight">Weight: </label>
            <input type="text" id="productWeight" v-model="product.weight">   
        </p>
        
        <p>
            <label for="productImageName">Image path/URL: </label>
            <input type="text" id="productImageName" v-model="product.imageName"/></p>

        <p><input type="submit" value="Add product"></p>



    </form>

</template>

<style>

.loginform {
	width: 65%;
	margin: 0;
	padding: 20px 20px;
	box-sizing: border-box;
	border: 2px solid #380000;
	border-radius: 4px;
	background-color: whitesmoke;
	resize: none;
	color: black;
}

.loginform label {
    display: inline-block;
    width: 100px;
    text-align: right;
    margin: 1px;
    font-size: 14px;
}

.loginform textarea {
    box-shadow: inset 0 2px 3px rgba(0,0,0,.39), 0 -1px 1px #FFF, 0 1px 0 #FFF;
    background-color: #DDD;
    width: 80%;
    height: 100px;
    resize: none;
    padding: 3px;
    margin-left: 15px;
}

input[type=text],[type=username], [type=email]  {
    height: 25px;
    width: 80%;
    padding: 3px;
    margin-left: 15px;
    border-radius: 3px;
    border: 1px solid transparent;
    border-top: none;
    border-bottom: 1px solid #DDD;
    background-color: #DDD;
    box-shadow: inset 0 1px 2px rgba(0,0,0,.39), 0 -1px 1px #FFF, 0 1px 0 #FFF
}

.input[type=button], input[type=submit], input[type=reset] {
	background-color: #00050f; /*inverted of floralwhite*/
	border: 2px solid darkblue;
	border-radius: 4px;
	color: white;
	padding: 10px 15px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}

select {
    background-color: #ddd;
    padding: 3px;
    margin-left: 15px;
    border-radius: 3px;
    width: 200px;
    font-size: 14px;
}



</style>