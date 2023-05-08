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
import http from "@/api/httpWithAccessToken";
// import axios from "axios"
import 'url-search-params-polyfill';

export default {
    components: { UserProfile, MiniHomepage, CategoryNav, },
    methods: {
        getUser: function () {
            // var userAvatar;
            // await html2canvas(document.querySelector("#my-character-container")).then(function (canvas) {
            //     userAvatar = canvas.toDataURL();
            // });ole.log(user);
            http.get(`/user/userInfo/${localStorage.getItem("user-seq")}`).then(
                (response)=> {
                    console.log(response);
                },
                (error)=> {
                    console.log(error);
                }
            )
        },
        // getGrass: async function () {
        //     http.get(`/grass?startDate=2022-01-01&endDate=2023-05-01`).then(
        //         (response)=> {
        //             console.log(response);
        //         },
        //         (error)=> {
        //             console.log(localStorage.getItem('access-token'))
        //             console.log(error);
        //         }
        //     )
        // }
    },
    mounted() {
        this.getUser();
        localStorage.setItem("access-token", localStorage.getItem("access-token"));
        localStorage.setItem("refresh-token", localStorage.getItem("refresh-token"));
        localStorage.setItem("user-seq", localStorage.getItem("user-seq"));
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
