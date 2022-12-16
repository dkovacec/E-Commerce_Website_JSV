<script>
export default {

}

</script>

<template>

<nav class="bottomMenu">
      <ul>
         <!-- use router-link instead of a to stop refreshing and request to server-->
        <!-- this makes it very fast and better -->
        <!-- <li><router-link to="/">Home</router-link></li>-->

        
        <!-- using names for routing -->
        <!-- <li><router-link :to="{ name: 'Tabs'}">Tabs</router-link></li> -->
        <li><a href="#">Admin home</a></li>
        <li><a href="#">Shipping rates</a></li>
        <li><a href="#">Privacy Policy</a></li>
      </ul>
    </nav>

</template>

<style>


.bottomMenu {
    position: absolute;
    list-style: none;
    margin-left: auto;
    margin-right: auto;
    left: 0;
    right: 0;
    margin-bottom: 0;
    padding: 0;
    text-align: right;
    background-color: white;
    box-shadow: 0px 3px 5px #000;
    /*display: inline-block;*/
    overflow: hidden;
    position: fixed;
    bottom: 10px;
    width: 75%;
}

.bottomMenu ul {
    margin: 0;
}

.bottomMenu li {
    display: inline;
    /*border: 1px solid black;*/
}

.bottomMenu a {
    text-decoration: none;
    color: black;
    padding: 10px 20px;
    margin: 0;
    display: inline-block;
}

.bottomMenu a:hover {
    cursor: pointer;
    color: lightcyan;
    background-color: black;
}

</style>