<script>
import http from '@/api/http'
export default {
    name: 'FindPassword',
    methods: {
        sendEmail: async function() {
            console.log(this.email)
            var info = {
                "email": this.email,
                "message": "HI I AM SSONGHEEEEEEEEEEEEEEE!!!!",
            }
            await http.post(`/user/email-certification/sends`, JSON.stringify(info)).then((result) => {
                console.log(result);
            }, (error) => {
                console.log(error);
            })
        }
    },
    data() {
        return {
            email: null,
        }
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
                <router-link to="/"><img class="person-img" src="../../../assets/image/Person.png" alt="logo" /></router-link>
            </div>
        </div>
        <form>
            <div class="email-container">
                <div class="email">이메일</div>
                <input class="email-input" type="email" v-model="email"/>
            </div>
        </form>
        <button class="get-new-pw-btn" @click="sendEmail">임시 비밀번호 발급받기</button>
        <div class="other-option">
            <router-link to="/"><div class="login">로그인</div></router-link>
            <div>&nbsp;&nbsp;|&nbsp;&nbsp;</div>
            <router-link to="/join"><div class="join">회원가입</div></router-link>
        </div>
    </div>
</template>

<style scoped>
a {
  text-decoration: underline;
  color: #8C8C8C;
}
.wrapper {
    margin-top: 10%;
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

.email-container {
    width: 30%;
    margin: 0 auto;
}

.email {
    color: #82ACC1;
    font-size: 15px;
    font-weight: 600;
    text-align: start;
    margin-bottom: 5px;
}

.email-input {
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    border-radius: 3px;
    width: 100%;
    font-size: 15px;
    height: 30px;
    box-shadow: 1px 2px #8C8C8C;
}

.get-new-pw-btn {
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
    font-size: 15px;
    cursor: pointer;
}

.get-new-pw-btn:hover {
    transform: scale(1.05);
    transition: 0.5s;
}

.other-option {
    justify-content: center;
    margin-top: 20px;
    display: flex;
    color: #8C8C8C;
    font-size: 10px;
}

.login {
    text-decoration: underline;
    cursor: pointer;
}

.join {
    text-decoration: underline;
    cursor: pointer;
}
</style>