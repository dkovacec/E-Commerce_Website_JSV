<script>
export default {
    data() {
        return {

        }
    },
    props: {
        message: String
    }
}
</script>
<template>
    <small class="errors">{{ message }}</small>

</template>
<style scoped>
.errors {
    color: red;

}
</style>