<script>
export default {
    mounted:function(){
        this.created()
    },

    data() {
        return {

            categoryList: [],
            totalCategories: 0
        };
    },

    created(){

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
        }
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
            <tr v-for="category in categoryList"> 
                <td>{{ category.id}}</td>
                <td>{{category.name}}</td>
                <td>{{category.description}}</td>
                <td> 
                    <Button> Edit</Button>
                    <Button> Delete</Button>
                </td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="4"> Total number of categories: <span> {{totalCategories}}</span></td>
            </tr>
        </tfoot>

    </table>


</template>