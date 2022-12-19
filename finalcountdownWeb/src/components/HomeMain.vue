<script>
export default {
    mounted: function () {
        this.created()
    },
    data() {
        return {
            categoryList: [],
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
    }
}
</script>

<template>

<nav class="ctgMenu">

    <ul>
        <li v-for="category in categoryList" :key="category.id" >
            <router-link :to="{name:'ProductsInCategory', params: {id: category.id, name: category.name}}">{{ category.name }} </router-link></li>
    </ul>

</nav>
</template>


<style scoped>
.ctgMenu {
    position: absolute;
    list-style: none;
    margin:auto;
    text-align: center;
    box-shadow: 0px 3px 5px #000;
    background-color: white;
    /*display: inline-block;*/
    /*overflow: hidden;*/
    position: fixed;
    width: 75%;
}
.ctgMenu li {
    display: inline;
    padding-left: 5%;
    padding-right: 5%;
    text-align: center;
    /* border: 1px solid black; */
}
.ctgMenu a {
    text-decoration: none;
    color: black;
    padding: 10px 20px;
    margin: 0;
    display: inline-block;
}
.ctgMenu li a:hover {
    cursor: pointer;
    color: lightcyan;
    background-color: black;
}
</style>