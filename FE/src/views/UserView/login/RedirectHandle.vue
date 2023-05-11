<script>
export default {
    name: "RedirectHandler",
    methods: {
        getAuthCode: function () {
            const urlParams = new URL(location.href).searchParams;
            const access_token = urlParams.get('token');
            const userSeq = urlParams.get('userSeq');
            // console.log(userSeq);
            // console.log(access_token);
            localStorage.setItem("access-token", access_token);
            localStorage.setItem("user-seq", userSeq);
            // console.log(localStorage.getItem('user-seq'))
            window.location.replace(`https://k8a308.p.ssafy.io/mainpage/${userSeq}`);
            // this.$router.replace("mainpage/");
        }
    },
    mounted() {
        this.getAuthCode();
    }
}
</script>

<template>
    <div></div>
</template>

<style scoped></style>