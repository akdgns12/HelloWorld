<template>
    <div class="wrapper">
        <!-- <div class="BGM">
            <p class="songTitle">The Weeknd - I Feel it Coming(cover by J.Fla)</p>
            <audio class="player" controls ref="player">
                <source src="" ref="source">
            </audio>
        </div> -->
        <div class="BN-container">
            <div class="BN">
                <router-link to="/mainpage">
                    <div class="router-btn">마이홈</div>
                </router-link>
            </div>
            <div class="BN">
                <div class="router-btn" @click="showModal = true">알림</div>
                <Teleport to="body">
                    <modal :show="showModal" @close="showModal = false" />
                </Teleport>
            </div>
            <div class="BN">
                <div class="router-btn logout-btn" @click="logout">로그아웃</div>
            </div>
        </div>
    </div>
</template>

<script>
import Modal from '@/components/NotifyComp/NotificationComp.vue';
import http from '@/api/httpWithAccessToken';
export default {
    components: { Modal },
    data() {
        return {
            showModal: false,
        }
    },
    methods: {
        logout: function () {
            var temp = localStorage.getItem('access-token');
            var tokens = {
                accessToken: temp,
            }
            console.log(tokens);
            http.post(`/user/logout`, JSON.stringify(tokens)).then(
                (response) => {
                    console.log(response);
                    localStorage.removeItem("access-token");
                    localStorage.removeItem("user-seq");
                    localStorage.removeItem("refresh-token");
                    // localStorage.clear();
                    window.location.replace('https://k8a308.p.ssafy.io/');
                    // this.$router.push({ name: 'before-login' });
                },
                (error) => {
                    console.log(error);
                    alert("로그아웃 실패!");
                }
            )
        }
        // play(sound) {
        //     if (sound) {
        //         var audio = new Audio(sound);
        //         audio.play();
        //     }
        // }
    }
}
</script>

<style scoped>
.wrapper {
    height: 62.6px;
    width: 25%;
}

.songTitle {
    width: 14rem;
    height: 0.9rem;
    font-size: 0.9rem;
    overflow-x: hidden;
    background-color: white;

}

.BGM {
    /* background-color: white; */
    border-radius: 30px;
    width: 15rem;

}

.player {
    width: 15rem;
    height: 1.5rem;
}

.notification {
    width: 1vw;
}

.BN-container {
    display: flex;
    width: 20vw;
    justify-content: space-evenly;
}

.router-btn {
    cursor: pointer;
    font-size: 10px;
    background-color: #82ACC1;
    /* opacity: 0.5; */
    color: #FFFFFF;
    width: 50px;
    padding: 2px 4px;
    text-align: center;
    font-weight: bold;
    border-radius: 20px;
    margin-left: 15px;
    margin-bottom: 5px;
}

.logout-btn {
    background-color: #D24646;
    opacity: 0.7;
}
</style>