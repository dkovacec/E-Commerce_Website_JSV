
<script>
export default {
    mounted: function () {
        this.created()
    },

    data() {
        return {

            categoryList: [],
            totalCategories: 0
        };
    },


    methods: {

        async getCategories() {
            let url = 'api/categories'
            try {

                let response = await fetch(url);
                this.categoryList = await response.json();
                this.totalCategories = this.categoryList.length;
            } catch (error) {
                console.log("Error: ", error)

            }
        },
        created() {
            this.getCategories();
        },

        async deleteCategory(id) {

            if(confirm('Do you really want to delete this category ?')){


            let urlDelete = 'api/categories/' + id

                let response = await fetch(urlDelete,{
                    method:'DELETE'
                }).then(response => {
                    if(!response.ok){
                        return Promise.reject("Error")
                    }
                }).catch(error => alert("Cannot delete this category, there are still some products listed for that category, first delete all products with this category"))

                this.getCategories();
            }
        },
    }

}
</script>

<template>
    <table class="formattedTable">
        <thead>
            <th>Category Id</th>
            <th>Category Name</th>
            <th>Category Description</th>
            <th>Actions</th>
        </thead>
        <tbody>
            <tr v-for="category in categoryList" :key="category.id">
                <td>{{ category.id }}</td>
                <td>{{ category.name }}</td>
                <td>{{ category.description }}</td>
                <td>
                   <router-link :to="{name:'EditCategory', params: {id: category.id}}">
                    <Button class="buttonEdit"> Edit</Button>
                </router-link>
                    <Button class="buttonDelete" @click="deleteCategory(category.id)"> Delete</Button>
                </td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="4"> Total number of categories: <span> {{ totalCategories }}</span></td>
            </tr>
        </tfoot>

    </table>
</template>

<style>

.formattedTable, .formattedTable td {
    border: 1px solid black;
}


.formattedTable th:nth-child(1), .formattedTable th:nth-child(2) {
    border-right: 1px solid white;
}


.formattedTable {
    /*border-spacing: 0;*/
    border-collapse: collapse;
}

.formattedTable th, .formattedTable td {
    padding: 5px;
}

.formattedTable th {
    background-color: black;
    color: white;

}

.formattedTable tfoot td {
    background-color: #eee;
}

/* :nth-child - pseudo-class*/
.formattedTable tbody tr:nth-child(even) {
    background-color: #ccc;
}

.formattedTable tbody tr:hover {
    cursor: pointer;
    background-color: #555;
    color: white;
}

.formattedTable caption {
    margin-top: 3px;
    caption-side: bottom;
}

.input[type="checkbox"] {
	background-color: #000;
	margin: 2px;
	font: inherit;
	color: currentColor;
	width: 1.5em;
	height: 1.5em;
	border: 0.25em solid currentColor;
	border-radius: 0.15em;
	transform: translateY(-0.075em);
}

.buttonEdit {
	background-color: #02527d; /* Green */
    width: 75px;
	color: white;
	padding: 5px 10px;
	margin: 4px 2px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16p;
	border: 1px solid blue;
	border-radius: 5px;
    box-shadow: 0px 3px 5px #000;
}

.buttonDelete {
	background-color: #380000;
    width: 75px;
	color: yellow;
	padding: 5px 10px;
	margin: 4px 2px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	border: 1px solid crimson;
	border-radius: 5px;
    box-shadow: 0px 3px 5px #000;
}
</style>