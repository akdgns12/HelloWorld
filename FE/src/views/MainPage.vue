<template>
    <div class="dashed-border">
        <div class="grey-bg">
            <UserProfile />
            <MiniHomepage />
                <CategoryNav />
        </div>

    </div>
</template>

<script>
import UserProfile from "@/components/MainPageComp/UserProfile.vue"
import MiniHomepage from "@/components/MainPageComp/MiniHompage.vue"
import CategoryNav from "@/components/BasicComp/CategoryNav.vue"
// import http from "@/api/http";
import axios from "axios"
import 'url-search-params-polyfill';

export default {
    components: { UserProfile, MiniHomepage, CategoryNav },
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
            console.log(response2.data.login+" 계정으로 로그인 성공!!!!!!!")
            console.log(response2.avatar_url)
        }
    },
    mounted() {
        this.isLogined();
    }
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