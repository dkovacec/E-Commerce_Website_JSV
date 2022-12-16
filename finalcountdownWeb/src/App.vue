<script>
import HeaderMain from './components/HeaderMain.vue';
import HeaderSecondary from './components/HeaderSecondary.vue';

import FooterMain from './components/FooterMain.vue';
import Login from './components/Login.vue';
import SignUp from './components/SignUp.vue';
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
    FooterMain,
    Login,
    SignUp
  }
}
</script>
<template>

<!-- <HeaderSecondary></HeaderSecondary> -->

  <main class="container">

    <router-view></router-view>
  </main>

  <HeaderMain></HeaderMain>
  <FooterMain></FooterMain>
</template>

<style>
.container {
	position: absolute;
  margin-top: 70px;
	width: 75%;
	padding: 10px;
  padding-top: 100px;
	font-family: Tahoma, Arial, sans-serif;
  border: 1px solid black;
	/*background-color: whitesmoke;  /*inverted of whitesmokr  #0a0a0a*/
	color: black;
}
</style>