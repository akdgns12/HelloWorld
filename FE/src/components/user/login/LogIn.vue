<script>
export default {
    name: 'LogIn',
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
            <div class="id-container">
                <div class="id">아이디</div>
                <input class="id-input" />
            </div>
            <div class="pw-container">
                <div class="pw">비밀번호</div>
                <input class="pw-input" type="password" />
            </div>
        </form>
        <router-link to="/mainpage"><button class="login-btn">로그인</button></router-link>
        <div class="other-option">
            <router-link to="/find-pw"><div class="pw-search">비밀번호 찾기</div></router-link>
            <div>&nbsp;&nbsp;|&nbsp;&nbsp;</div>
            <router-link to="/join"><div class="join">회원가입</div></router-link>
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
    font-size: 13px;
    font-weight: 600;
    text-align: start;
    margin-bottom: 5px;
}

.id-input {
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    border-radius: 3px;
    width: 100%;
    font-size: 12px;
    height: 27px;
    box-shadow: 1px 2px #8C8C8C;
}

.pw-container {
    width: 30%;
    margin: 0 auto;
    margin-top: 20px;
}

.pw {
    color: #82ACC1;
    font-size: 13px;
    font-weight: 600;
    text-align: start;
    margin-bottom: 5px;
}

.pw-input {
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    border-radius: 3px;
    width: 100%;
    font-size: 12px;
    height: 27px;
    box-shadow: 1px 2px #8C8C8C;
}

.login-btn {
    width: 30%;
    padding-top: 6px;
    padding-bottom: 6px;
    margin: 0 auto;
    margin-top: 25px;
    background-color: #D24646;
    opacity: 78%;
    border: none;
    border-radius: 4px;
    color: white;
    font-weight: 500;
}

.other-option {
    justify-content: center;
    margin-top: 20px;
    display: flex;
    color: #8C8C8C;
    font-size: 10px;
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