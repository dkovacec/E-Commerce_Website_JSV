<script>
import HomeMain from '../components/HomeMain.vue';
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "../store/auth";

export default defineComponent({
    components: {
        Home,
    computed: {
    ...mapStores(useAuthStore)
  }, }
})

</script>

<template>



    <h1>BANNER GOES HERE</h1>


    <HomeMain></HomeMain>

 

</template>