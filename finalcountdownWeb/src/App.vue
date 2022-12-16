<script>
import HeaderMain from './components/HeaderMain.vue';
import HeaderSecondary from './components/HeaderSecondary.vue';
import FooterMain from './components/FooterMain.vue';
import NavigationBar from "@/components/NavigationBar.vue";
export default {
  data() {
    return {
    }
  },
  methods: {
  },
  components: {
    NavigationBar,
    HeaderMain,
    HeaderSecondary,
    FooterMain,
    
  }
}
</script>
<template>
  <NavigationBar></NavigationBar>
<HeaderMain></HeaderMain>
<!-- <HeaderSecondary></HeaderSecondary> -->

  <main class="container">

    <router-view></router-view>
  </main>

  <FooterMain></FooterMain>
</template>

<style>
.container {
    margin: 0;
    padding-top: 100px;
    width: 85%;
    border: 1px solid black;
}
</style>