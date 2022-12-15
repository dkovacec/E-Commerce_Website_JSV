
<script>
import router from '../router';
import Message from'./Message.vue';


export default {
    mounted: function () {
        this.created()
    },

    data() {
        return {
            category: {
                name: "",
                description: ""
            },

            errors: {
                name:false,
                description:false
            },
            categoryList: []
        }
    },

    components: {
        Message
    },

    methods: {

        processForm() {
            if (!this.category.name.trim()) {
                this.errors.name = true;
            } else {
                this.errors.name = false;
            }

            if (!this.category.description.trim()) {
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
                this.createCategory(this.category)
                alert("You have created a new category !")
                this.name = "",
                this.description = ""
                this.errors.name = false;
                this.errors.description = false;
            }
        },

        async getCategory() {
            let urlGet = '/api/categories/' + this.$route.params.id

            try {

                let response = await fetch(urlGet);
                this.categoryList = await response.json();
                console.log(this.categoryList)

            } catch (error) {

            }

        },

        created() {
            this.getCategory();

        },

        async updateCategory() {
            try {
                let urlUpdate = '/api/categories/' + this.$route.params.id
                let responseCategory = await fetch(urlUpdate, {

                    method: 'PUT',

                    headers: {
                        'Content-Type': 'application/json'
                    },

                    body: JSON.stringify({
                        id: this.$route.params.id,
                        name:this.categoryList.name,
                        description:this.categoryList.description
                    })
                });
                let updateCategory = await responseCategory.json();
                alert(`Category updated with id= ${updateCategory.id}`)

                router.push({path: '/categorylist'})



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
            <label for="categoryName">Category Name: </label>
            <input type="text" id="categoryName" v-model="categoryList.name">
        </p>

        <p>
            <label for="categoryDescription">Category Description: </label>
            <textarea type="textarea" id="categoryDescription" v-model="categoryList.description"></textarea>
        </p>

        <p><input @click="updateCategory()"  type="submit" value="Update"></p>

    </form>

</template>

<style>

</style>