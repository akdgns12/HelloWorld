<template>
    <div class="dashed-border">
        <div class="grey-bg">
            <UserProfile />
            <MiniHomepage />
                <CategoryNav />
        </div>
    </div>
    <!-- <audio controls autoplay loop> -->
    <!-- <source src="http://soundbible.com/mp3/Air Plane Ding-SoundBible.com-496729130.mp3" type="audio/mp3"> -->
    
    <!-- <source src="http://www.youtube.com/v/EkRuV-h6Bv0?" type="audio/mp3"> -->
    <!-- 이 문장은 사용자의 웹 브라우저가 audio 요소를 지원하지 않을 때 나타납니다! -->
    <!-- </audio> -->
</template>

<script>
import UserProfile from "@/components/MainPageComp/UserProfile.vue"
import MiniHomepage from "@/components/MainPageComp/MiniHompage.vue"
import CategoryNav from "@/components/BasicComp/CategoryNav.vue"
// import http from "@/api/http";
import axios from "axios"
import 'url-search-params-polyfill';

export default {
    components: { UserProfile, MiniHomepage, CategoryNav, },
    methods: {
        isLogined: async function () {
            const url = new URL(window.location.href)
            const authorizationCode = url.searchParams.get('code');
            // console.log(authorizationCode);
            // var ret;
            var params = new URLSearchParams();
            params.append("client_id", "67e5f9075db550de602e");
            params.append("client_secret", "6c9aee8228c4c7293b41193c772fdf97ca80888e");
            params.append("code", authorizationCode);
            // var userInfo = JSON.stringify(
            //     {
            //         client_id: "67e5f9075db550de602e",
            //         client_secret: "6c9aee8228c4c7293b41193c772fdf97ca80888e",
            //         code: authorizationCode,
            //     }
            // )
            // console.log(userInfo);
            var response = await axios.post(`https://github.com/login/oauth/access_token`, params, {
                headers: {
                    Accept: "application/json",
                }
            }).then().catch();
            const access_token = response.data.access_token;

            params = new URLSearchParams();
            params.append("access_token", access_token);
            var response2 = await axios.get(`https://api.github.com/user`, {
                headers: {
                    authorization: `token ${access_token}`,
                }
            }
            )
            console.log(response2);
            console.log(response2.data.login + " 계정으로 로그인 성공!!!!!!!")
        }
    },
    mounted() {
        this.isLogined();
    },
    // created() {
    //     (function () { var w = window; if (w.ChannelIO) { return w.console.error("ChannelIO script included twice."); } var ch = function () { ch.c(arguments); }; ch.q = []; ch.c = function (args) { ch.q.push(args); }; w.ChannelIO = ch; function l() { if (w.ChannelIOInitialized) { return; } w.ChannelIOInitialized = true; var s = document.createElement("script"); s.type = "text/javascript"; s.async = true; s.src = "https://cdn.channel.io/plugin/ch-plugin-web.js"; var x = document.getElementsByTagName("script")[0]; if (x.parentNode) { x.parentNode.insertBefore(s, x); } } if (document.readyState === "complete") { l(); } else { w.addEventListener("DOMContentLoaded", l); w.addEventListener("load", l); } })();

    //     window.ChannelIO('boot', {
    //         "pluginKey": "acbc3cce-55f3-4812-89d5-823845c119bd"
    //     });
    // }
};
</script>


<style scoped>
.dashed-border {
    width: 90vw;
    height: 90vh;
    margin: 0 auto;
    margin-top: 5vh;
    border: 3px dashed #6A6A6A;
    border-radius: 10px;
}

.grey-bg {
    width: 88vw;
    height: 86vh;
    margin: 0 auto;
    margin-top: 2vh;
    background-color: #F0F0F0;
    border-radius: 10px;
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
