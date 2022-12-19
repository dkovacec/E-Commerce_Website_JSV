<script>
import Message from './Message.vue';
//import Message from './ErrorMessage.vue';

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

    <form class="loginform" @submit.prevent="processForm" novalidate>
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

<style>

.loginform {
	width: 65%;
    margin: 0;
    margin-left: auto;
    margin-right: auto;
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

</style>