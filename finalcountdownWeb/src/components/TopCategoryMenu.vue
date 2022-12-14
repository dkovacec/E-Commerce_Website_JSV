<script>
export default {

}

</script>

<template>

<nav class="topCategoryMenu">
      <ul>
        <!-- use router-link instead of a to stop refreshing and request to server-->
        <!-- this makes it very fast and better -->
        <!-- <li><router-link to="/">Home</router-link></li>-->
        <!-- <li><router-link to="/">Home</router-link></li> -->
        <!-- using names for routing -->
        <!-- <li><router-link :to="{ name: 'Tabs'}">Tabs</router-link></li> -->
        <li><a href="#">Category 1</a></li>
        <li><a href="#">Category 2</a></li>
        <li><a href="#">Category 3</a></li>
        <li><a href="#">Category 4</a></li>
        <li><a href="#">Category 5</a></li>
    </ul>
    </nav>

</template>

<style>


.topCategoryMenu {
    list-style: none;
    margin-top: 50px;
    padding: 0;
    text-align: center;
    box-shadow: 0px 3px 5px #000;
    /*display: inline-block;*/

    position: fixed;
    width: 75%;
}

.topCategoryMenu ul {
    margin: 0;
}


.topCategoryMenu li {
    display: inline;
    /*border: 1px solid black;*/
}

.topCategoryMenu a {
    text-decoration: none;
    color: black;
    padding: 10px 15px;
    margin: 0;
    display: inline-block;
}

.topCategoryMenu a:hover {
    cursor: pointer;
    color: lightcyan;
    background-color: black;
}

</style>