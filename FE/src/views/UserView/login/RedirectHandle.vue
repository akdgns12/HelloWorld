<script>
export default {
    name: "RedirectHandler",
    methods: {
        getAuthCode: function() {
            window.location.assign("https://https://k8a308.p.ssafy.io/oauth2/authorize/github?redirect_uri=http://localhost:8080/mainpage");
        }
    },
    mounted() {
        this.getAuthCode();
    }

}
</script>

<template>
    <div>HI</div>
</template>

<style scoped>
</style>