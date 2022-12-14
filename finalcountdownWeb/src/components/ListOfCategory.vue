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

    created() {

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
    <table>
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
                    <Button> Edit</Button>
                    <Button  @click="deleteCategory(category.id)"> Delete</Button>
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