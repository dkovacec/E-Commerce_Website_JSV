<script>
import HeaderMain from './components/HeaderMain.vue';
import HeaderSecondary from './components/HeaderSecondary.vue';
import FooterMain from './components/FooterMain.vue';
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
    
  }
}
</script>
<template>
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