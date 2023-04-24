<script>
export default {
    name: 'LoginOption',
}
</script>

<template>
    <div class="wrapper">
        <div class="login-header">
            <div class="logo">
                <img class="logo-img" src="../../../assets/image/Logo.png" alt="logo" />
            </div>
            <div class="person">
                <img class="person-img" src="../../../assets/image/Person.png" alt="logo" />
            </div>
        </div>
        <div>
            <router-link to="/login">
                <button class="login-btn">일반 로그인</button>
            </router-link>
        </div>
        <div>
            <button class="login-with-github-btn">
                <div class="github-icon-container"><img class="github-icon" src="../../../assets/image/GithubLogo.png" />
                </div>
                github으로 로그인
            </button>
        </div>
        <div class="other-option">
            <router-link to="/find-pw"><div class="pw-search">비밀번호 찾기</div></router-link>
            <div>&nbsp;&nbsp;|&nbsp;&nbsp;</div>
            <router-link to="/join">
                <div class="join">회원가입</div>
            </router-link>
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

.login-with-github-btn {
    display: flex;
    justify-content: center;
    width: 30%;
    padding-top: 10px;
    padding-bottom: 10px;
    margin: 0 auto;
    margin-top: 20px;
    background-color: black;
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

.login-with-github-btn:hover {
    transform: scale(1.05);
    transition: 0.5s;
}
.github-icon-container {
    width: 30px;
    height: 20px;
}

.github-icon {
    width: 100%;
    height: 100%;
    object-fit: cover;
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