<script>
export default {
    name: 'RegisterUser',
}
</script>

<template>
    <div class="logos">
            <div class="logo">
                <router-link to="/"><img class="logo-img" src="../../../assets/image/Logo.png" alt="logo" /></router-link>
            </div>
            <div class="person">
                <router-link to="/"><img class="person-img" src="../../../assets/image/Person.png" alt="logo" /></router-link>
            </div>
        </div>
    <div class="wrap">
        <form>
            <div class="id-container">
                <div class="id">이메일</div>
                <input class="id-input" type="email"/>
            </div>
            <div class="pw-container">
                <div class="pw">비밀번호</div>
                <input class="pw-input" type="password" />
            </div>
            <div class="pw-check-container">
                <div class="pw-check">비밀번호 확인</div>
                <input class="pw-check-input" type="password" />
            </div>
            <!-- <div class="email-container">
                <div class="email">이메일</div>
                <input class="email-input" type="email" />
            </div> -->
            <div class="name-container">
                <div class="name">이름</div>
                <input class="name-input" type="text" />
            </div>
            <div class="nickname-container">
                <div class="nickname">닉네임</div>
                <input class="nickname-input" type="text" />
            </div>
        </form>
        
        <div class="button-group">
            <button class="cancel-btn" @click="this.$router.push({path: '/'})">취소</button>
            <button class="next-btn" @click="this.$router.push({path: '/register-character'})">다음</button>
        </div>
    </div>
</template>

<style scoped>
a {
  text-decoration: none;
  color: white;
}

.wrap {
    margin-top: 3%;

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
    padding-left: 5px;
}

.pw-container {
    width: 30%;
    margin: 0 auto;
    margin-top: 30px;
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
    padding-left: 5px;
}

.pw-check-container {
    width: 30%;
    margin: 0 auto;
    margin-top: 30px;
}

.pw-check {
    color: #82ACC1;
    font-size: 13px;
    font-weight: 600;
    text-align: start;
    margin-bottom: 5px;
}

.pw-check-input {
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    border-radius: 3px;
    width: 100%;
    font-size: 12px;
    height: 27px;
    box-shadow: 1px 2px #8C8C8C;
    padding-left: 5px;
}

.email-container {
    width: 30%;
    margin: 0 auto;
    margin-top: 30px;
}

.email {
    color: #82ACC1;
    font-size: 13px;
    font-weight: 600;
    text-align: start;
    margin-bottom: 5px;
}

.email-input {
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    border-radius: 3px;
    width: 100%;
    font-size: 12px;
    height: 27px;
    box-shadow: 1px 2px #8C8C8C;
    padding-left: 5px;
}

.name-container {
    width: 30%;
    margin: 0 auto;
    margin-top: 30px;
}

.name {
    color: #82ACC1;
    font-size: 13px;
    font-weight: 600;
    text-align: start;
    margin-bottom: 5px;
}

.name-input {
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    border-radius: 3px;
    width: 100%;
    font-size: 12px;
    height: 27px;
    box-shadow: 1px 2px #8C8C8C;
    padding-left: 5px;
}

.nickname-container {
    width: 30%;
    margin: 0 auto;
    margin-top: 30px;
}

.nickname {
    color: #82ACC1;
    font-size: 13px;
    font-weight: 600;
    text-align: start;
    margin-bottom: 5px;
}

.nickname-input {
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    border-radius: 3px;
    width: 100%;
    font-size: 12px;
    height: 27px;
    box-shadow: 1px 2px #8C8C8C;
    padding-left: 5px;
}

.button-group {
    display: flex;
    justify-content: space-between;
    margin: 0 auto;
    margin-top: 40px;
    width: 30%;
}

.cancel-btn {
    width: 49%;
    padding-top: 6px;
    padding-bottom: 6px;
    background-color: #D24646;
    opacity: 78%;
    border: none;
    border-radius: 4px;
    color: white;
    font-weight: 500;
    cursor: pointer;
    text-decoration: none;
}

.cancel-btn:hover {
    transform: scale(1.05);
    transition: 0.5s;
}

.next-btn {
    width: 49%;
    padding-top: 6px;
    padding-bottom: 6px;
    background-color: #82ACC1;
    border: none;
    border-radius: 4px;
    color: white;
    font-weight: 500;
    cursor: pointer;
}

.next-btn:hover {
    transform: scale(1.05);
    transition: 0.5s;
}

.logos {
    display: flex;
    position: absolute;
    top: 5%;
    left: 10%;
    width: 15%;
    
}

.logo {
    width: 80%;
    height: 140%;
}

.logo-img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.person {
    width: 45%;
    height: 100%;
}

.person-img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}
</style>