
<script>
import router from '../router';
import Message from './Message.vue';


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
            category: {
                name: "",
                description: ""
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
        }
    },

    components: {
        Message
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

        async getCategory() {
            let urlGet = '/api/categories'

            try {

                let response = await fetch(urlGet);
                this.categoryList = await response.json();
                console.log(this.categoryList)

            } catch (error) {

            }

        },

        async getProduct() {
            let urlGetProduct = '/api/products/' + this.$route.params.id

            try {

                let response = await fetch(urlGetProduct);
                this.products = await response.json();
                console.log(this.products)

            } catch (error) {

            }

        },

        created() {
            this.getProduct();
            this.getCategory();

        },

        async updateProduct() {
            try {
                let urlUpdate = '/api/products/' + this.$route.params.id
                let responseCategory = await fetch(urlUpdate, {

                    method: 'PUT',

                    headers: {
                        'Content-Type': 'application/json'
                    },

                    body: JSON.stringify({
                        id: this.$route.params.id,
                        name: this.products.name,
                        summary: this.products.summary,
                        description: this.products.description,
                        price: this.products.price,
                        weight: this.products.weight,
                        imageName: this.products.imageName,
                        categoryId: this.products.categoryId
                    })
                });
                let updateProduct = await responseCategory.json();
                alert(`Category updated with id= ${updateProduct.id}`)

                router.push({ path: '/productlist' })



            } catch (error) {
                console.log("Error: ", error)
            }
        }
    }
}


</script>

<template>
    <h1>Edit a category</h1>
    <form class="loginform" @submit.prevent="processForm" novalidate>
        <p>
            <label for="productName">Product Name: </label>
            <input type="text" id="productName" v-model="products.name">
        </p>
        <!-- <Message v-show="errors.name" :message="'Name of product should not be empty'"></Message> -->
        <p>
            <label for="productSummary">Summary (Short description): </label>
            <textarea type="textarea" id="productSummary" v-model="products.summary"></textarea>
        </p>
        <!-- <Message v-show="errors.description" :message="'Short description of product should not be empty'"></Message> -->

        <p>
            <label for="productDescription">Detailed Description: </label>
            <textarea type="textarea" id="productDescription" v-model="products.description"></textarea>
        </p>
        <!-- <Message v-show="errors.description" :message="'Description of product should not be empty'"></Message> -->

        <p><label for="productCategoryId">Category: </label>
            <select v-model="products.categoryId" name="productCategoryId" id="productCategoryId">
                <option v-for="categ in categoryList" :key="categ.id" :value="categ.id">{{ categ.name }} - {{ categ.id
                }}</option>
            </select>
        </p>
        <p>
            <label for="productPrice">Price: </label>
            <input type="text" id="productPrice" v-model="products.price">
        </p>

        <p>
            <label for="productWeight">Weight: </label>
            <input type="text" id="productWeight" v-model="products.weight">
        </p>

        <p>

            <label for="productImageName">Image path/URL: </label>

            <input type="text" id="productImageName" v-model="products.imageName" />
        </p>



        <p><input @click="updateProduct()" type="submit" value="Update"></p>

    </form>

</template>

<style>

</style>