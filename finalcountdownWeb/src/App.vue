<script>
import HeaderMain from './components/HeaderMain.vue';
import HeaderSecondary from './components/HeaderSecondary.vue';
//import FooterMain from './components/FooterMain.vue';
//import NavigationBar from "@/components/NavigationBar.vue";
// import Login from './components/Login.vue';
// import SignUp from './components/SignUp.vue';
export default {
  data() {
    return {
    }
  },
  methods: {
  },
  components: {
    HeaderMain,
    HeaderSecondary,
    // FooterMain,
    // NavigationBar
  }
}
</script>
<template>

<!-- <HeaderSecondary></HeaderSecondary> -->

  <main class="container">
    <div class="mainBanner"><img class="banner" src="src\images\banner2.jpg"></div>

    <router-view></router-view>


  </main>

  <!-- <NavigationBar></NavigationBar> -->
  <HeaderMain></HeaderMain>
  <!-- <FooterMain></FooterMain> -->


</template>

<style>
body {
  margin: 0;
  padding: 0;
}
.container {
  position: absolute;
  margin-left: auto;
  margin-right: auto;
  left: 0;
  right: 0;
  margin-top: 60px;
	width: 75%;
	padding: 10px;
  padding-top: 90px;
	font-family: Tahoma, Arial, sans-serif;
  /*border: 1px solid black;*/
	background-color: whitesmoke;  /*inverted of whitesmokr  #0a0a0a*/
	color: black;
}

.mainBanner {
  border: 0px solid black;
  margin-top: -70px;
  width: 99%;
  padding: 0;
  margin-left: auto;
  margin-right: auto;
}

.banner {
  width: 100%;
  margin: 0;
  margin-left: auto;
  margin-right: auto;
}
</style>