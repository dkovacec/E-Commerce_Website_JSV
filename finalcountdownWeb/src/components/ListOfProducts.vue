
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
            let url = 'api/products'
            try {

                let response = await fetch(url);
                this.productList = await response.json();
                this.totalProducts = this.productList.length;
            } catch (error) {
                console.log("Error: ", error)

            }
        },
        created() {
            this.getProducts();
        },

        async deleteProduct(id) {

            if(confirm('Do you really want to delete this product ?')){


            let urlDelete = 'api/products/' + id

                let response = await fetch(urlDelete,{
                    method:'DELETE'
                }).then(response => {
                    if(!response.ok){
                        return Promise.reject("Error")
                    }
                }).catch(error => alert("Cannot delete this product"))

                this.getProducts();
            }
        },
    }

}
</script>

<template>
    <table class="formattedTable">
        <thead>
            <th>Product Id</th>
            <th>Product Name</th>
            <th>Summary</th>
            <th>Price</th>
            <th>Weight</th>
            <th>Description</th>
            <th>Image</th>
            <th>Category</th>
            <th>Actions</th>
        </thead>
        <tbody>
            <tr v-for="product in productList" :key="product.id">
                <td>{{ product.id }}</td>
                <td>{{ product.name }}</td>
                <td>{{ product.summary }}</td>
                <td>{{ product.price }}</td>
                <td>{{ product.weight }}</td>
                <td>{{ product.description }}</td>
                <td><img class="listimage" :src=product.imageName></td>
                <td>{{ product.category.name }}</td>
                <td>
                    <router-link :to="{name:'EditProduct', params: {id: product.id}}">
                    <Button> Edit</Button>
                </router-link>
                    <Button  @click="deleteProduct(product.id)"> Delete</Button>
                </td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="9"> Total number of products: <span> {{ totalProducts }}</span></td>
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

.button {
	background-color: #380000; /* Green */
	color: white;
	padding: 5px 10px;
	margin: 4px 2px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	border: 1px solid crimson;
	border-radius: 5px;
}

.listimage {

width: 150px;

height: 150px;



}

</style>