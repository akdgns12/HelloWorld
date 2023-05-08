<script>
export default {
    name: "RedirectHandler",
    methods: {
        getAuthCode: function () {
            const urlParams = new URL(location.href).searchParams;
            const access_token = urlParams.get('token');
            console.log(access_token);
            localStorage.setItem("access-token", access_token);
            window.location.replace('https://k8a308.p.ssafy.io/mainpage');
            // this.$router.push("mainpage");
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

<style scoped></style>