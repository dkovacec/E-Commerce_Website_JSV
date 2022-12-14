<script>
import Message from './Message.vue';

export default {
    data() {
        return {
            category: {
                name: "",
                description: ""
            },
            errors: {
                name: false,
                description: false
            },
            categories: [],
            totalCategories: 0
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
        async createCategory(category) {
            try {
                let urlCategory = "/api/categories"
                let responseCategory = await fetch(urlCategory, {

                    method: 'POST',

                    headers: {
                        'Content-Type': 'application/json'
                    },

                    body: JSON.stringify({
                        name: category.name,
                        description: category.description
                    })
                });
                let newCategory = await responseCategory.json();
                alert(`Category inserted with id= ${newCategory.id}`)
            } catch (error) {
                console.log("Error: ", error)
            }
        }
    }
}

</script>

<template>

    <form @submit.prevent="processForm" novalidate>
        <p>
            <label for="categoryName">Category Name: </label>
            <input type="text" id="categoryName" v-model="category.name">   
        </p>
        <Message v-show="errors.name" :message="'Name of category should not be empty'"></Message>
        <p>
            <label for="categoryDescription">Category Description: </label>
            <textarea type="textarea" id="categoryDescription" v-model="category.description"></textarea> 
        </p>
        <Message v-show="errors.description" :message="'Description of category should not be empty'"></Message>

        <p><input type="submit" value="Add category"></p>



    </form>

</template>