<script>
import http from '@/api/http';
export default {
    name: 'LogIn',
    data() {
        return {
            email: null,
            password: null,
        };
    },
    methods: {
        login: function () {
            var user = {
                email: this.email,
                password: this.password,
            }
            http.post(`/user/signIn`, JSON.stringify(user)).then(
                (response) => {
                    console.log(response);
                    localStorage.clear()
                    localStorage.setItem("access-token", response.data.data.accessToken);
                    localStorage.setItem("refresh-token", response.data.data.refreshToken);
                    localStorage.setItem("user-seq", response.data.data.userSeq);
                    // window.location.replace('https://k8a308.p.ssafy.io/mainpage');
                    this.$router.replace({path: `/mainpage/${response.data.data.userSeq}`});
                },
                (error) => {
                    console.log(error);
                    alert("로그인 실패!");
                }
            )
        }
    },
    created() {
        localStorage.clear();
    }
}
</script>

<template>
    <div class="wrapper">
        <div class="login-header">
            <div class="logo">
                <router-link to="/"><img class="logo-img" src="../../../assets/image/Logo.png" alt="logo" /></router-link>
            </div>
            <div class="person">
                <router-link to="/"><img class="person-img" src="../../../assets/image/Person.png"
                        alt="logo" /></router-link>
            </div>
        </div>
        <form>
            <div class="id-container">
                <div class="id">이메일</div>
                <input class="id-input" type="email" v-model="email" />
            </div>
            <div class="pw-container">
                <div class="pw">비밀번호</div>
                <input class="pw-input" type="password" v-model="password" />
            </div>
        </form><button class="login-btn" @click="login">로그인</button>
        <div class="other-option">
            <router-link to="/find-pw">
                <div class="pw-search">비밀번호 찾기</div>
            </router-link>
            <div>&nbsp;&nbsp;|&nbsp;&nbsp;</div>
            <router-link to="/join">
                <div class="join">회원가입</div>
            </router-link>
            <div>&nbsp;&nbsp;|&nbsp;&nbsp;</div>
            <div class="login-with-github">github으로 로그인</div>
        </div>
    </div>
</template>

<style scoped>
a {
    text-decoration: underline;
    color: #8C8C8C;
}

.wrapper {
    margin-top: 6%;
}

.login-header {
    display: flex;
    justify-content: center;
}

.logo {
    width: 20%;
    height: 30%;
    cursor: pointer;
}

.logo-img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.person {
    width: 10%;
    height: 25%;
    cursor: pointer;
}

.person-img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.id-container {
    width: 30%;
    margin: 0 auto;
}

.id {
    color: #82ACC1;
    font-size: 15px;
    font-weight: 600;
    text-align: start;
    margin-bottom: 5px;
}

.id-input {
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    border-radius: 3px;
    width: 100%;
    font-size: 15px;
    height: 30px;
    box-shadow: 1px 2px #8C8C8C;
    padding-left: 5px;
}

.pw-container {
    width: 30%;
    margin: 0 auto;
    margin-top: 20px;
}

.pw {
    color: #82ACC1;
    font-size: 15px;
    font-weight: 600;
    text-align: start;
    margin-bottom: 5px;
}

.pw-input {
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    border-radius: 3px;
    width: 100%;
    font-size: 15px;
    height: 30px;
    box-shadow: 1px 2px #8C8C8C;
    padding-left: 5px;
}

.login-btn {
    width: 30%;
    padding-top: 10px;
    padding-bottom: 10px;
    margin: 0 auto;
    margin-top: 25px;
    background-color: #D24646;
    opacity: 78%;
    border: none;
    border-radius: 4px;
    color: white;
    font-weight: 500;
    cursor: pointer;
    font-size: 15px;
}

.login-btn:hover {
    transform: scale(1.05);
    transition: 0.5s;
}

.other-option {
    justify-content: center;
    margin-top: 20px;
    display: flex;
    color: #8C8C8C;
    font-size: 12px;
}

.pw-search {
    text-decoration: underline;
    cursor: pointer;
}

.join {
    text-decoration: underline;
    cursor: pointer;
}

.login-with-github {
    text-decoration: underline;
    cursor: pointer;
}
</style>