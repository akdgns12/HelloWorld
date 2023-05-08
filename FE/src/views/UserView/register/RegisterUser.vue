<script>
export default {
    name: 'RegisterUser',
    data() {
        return {
            isLoginError: false,
            user: {
                userEmail: null,
                userPwd: null,
                userName: null,
                userNickname: null,
                userPhoneNum: null,
            },
            userPwd2: null,
            ret: false,
        };
    },
    methods: {
        beforeJoinCheck: function () {
            // 회원가입 정보 체크

            // console.log("모두 입력 완료!");
            this.ret = true;
            let emailReg = new RegExp('[a-z0-9]+@[a-z]+.[a-z]{2,3}');
            let pwReg = new RegExp('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$');
            // 이메일 유효성 검사
            if (!emailReg.test(this.user.userEmail)) {
                this.ret = false;
                document.getElementById("email-msg").style.visibility = "visible";
            }
            else {
                document.getElementById("email-msg").style.visibility = "hidden";
            }
            // 비밀번호 유효성 검사
            // 비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다
            if (!pwReg.test(this.user.userPwd)) {
                this.ret = false;
                document.getElementById("pwd-msg").style.visibility = "visible";
            }
            else {
                document.getElementById("pwd-msg").style.visibility = "hidden";
            }
            // 비밀번호 일치 검사
            if (this.user.userPwd != this.userPwd2) {
                this.ret = false;
                document.getElementById("pwd2-msg").style.visibility = "visible";
            }
            else {
                document.getElementById("pwd2-msg").style.visibility = "hidden";
            }
            // 빈칸 검사
            if (!(this.user.userEmail != null &&
                this.user.userPwd != null &&
                this.user.userName != null &&
                this.user.userNickname != null &&
                this.userPwd2 != null &&
                this.user.userPhoneNum != null &&
                this.user.userEmail != '' &&
                this.user.userPwd != '' &&
                this.user.userName != '' &&
                this.user.userNickname != '' &&
                this.userPwd2 != '' &&
                this.user.userPhoneNum != '')) {

                this.ret = false;
                document.getElementById("before-join-msg").style.visibility = "visible";
            }
            // 모두 통과
            if (this.ret) {
                document.getElementById("before-join-msg").style.visibility = "hidden";
            }
        },
        join: function () {
            if (!(this.user.userEmail != null &&
                this.user.userPwd != null &&
                this.user.userName != null &&
                this.user.userNickname != null &&
                this.userPwd2 != null &&
                this.user.userPhoneNum != null &&
                this.user.userEmail != '' &&
                this.user.userPwd != '' &&
                this.user.userName != '' &&
                this.user.userNickname != '' &&
                this.userPwd2 != '' &&
                this.user.userPhoneNum != '')) {

                this.ret = false;
                document.getElementById("before-join-msg").style.visibility = "visible";
                return;
            }
            this.$router.push({
                name: 'register-character', params: {
                    email: this.user.userEmail,
                    password: this.user.userPwd, 
                    userName: this.user.userName, 
                    nickname: this.user.userNickname,
                    phonenum: this.user.userPhoneNum,
                }
            });
        }
    }
}
</script>

<template>
    <div class="logos">
        <div class="logo">
            <router-link to="/"><img class="logo-img" src="@/assets/image/Logo.png" alt="logo" /></router-link>
        </div>
        <div class="person">
            <router-link to="/"><img class="person-img" src="@/assets/image/Person.png" alt="logo" /></router-link>
        </div>
    </div>
    <div class="wrap">
        <form>
            <div class="email-container">
                <div class="email">이메일</div>
                <input class="email-input" type="email" v-model="user.userEmail" @input="beforeJoinCheck" />
                <div id="email-msg"
                    style="visibility: show; font-size: 8px; margin-top: 5px; text-align: start; color: red;">이메일 형식에 맞지
                    않습니다</div>
            </div>
            <div class="pw-container">
                <div class="pw">비밀번호</div>
                <input class="pw-input" type="password" v-model="user.userPwd" @input="beforeJoinCheck" />
                <div id="pwd-msg" style="visibility: show; font-size: 8px; margin-top: 5px; text-align: start; color: red;">
                    비밀번호는 8자
                    이상이어야 하며, 숫자/대문자/소문자/특수문자(#?!@$%^&*-)를 모두 포함해야 합니다</div>
            </div>
            <div class="pw-check-container">
                <div class="pw-check">비밀번호 확인</div>
                <input class="pw-check-input" type="password" v-model="userPwd2" @input="beforeJoinCheck" />
                <div id="pwd2-msg"
                    style="visibility: show; font-size: 8px; margin-top: 5px; text-align: start; color: red;">비밀번호와 비밀번호
                    확인란이 일치하지 않습니다</div>
            </div>
            <div class="name-container">
                <div class="name">이름</div>
                <input class="name-input" type="text" v-model="user.userName" @input="beforeJoinCheck" />
            </div>
            <div class="nickname-container">
                <div class="nickname">닉네임</div>
                <input class="nickname-input" type="text" v-model="user.userNickname" @input="beforeJoinCheck" />
            </div>
            <div class="phonenum-container">
                <div class="phonenum">핸드폰 번호</div>
                <input class="phonenum-input" type="text" v-model="user.userPhoneNum" @input="beforeJoinCheck" />
            </div>
        </form>
        <div id="before-join-msg"
            style="visibility: show; font-size: 10px; margin: 0 auto; margin-top: 20px; margin-bottom: 20px; text-align: center; color: red; width: 30%;">
            빈칸을 모두 작성해주세요</div>
        <div class="button-group">
            <button class="cancel-btn" @click="this.$router.push({ path: '/' })">취소</button>
            <button v-if="!ret" class="next-btn-disabled" disabled>다음</button>
            <button v-if="ret" class="next-btn" @click="join">다음</button>
        </div>
    </div>
</template>

<style scoped>
a {
    text-decoration: none;
    color: white;
}

.wrap {
    margin-top: 2%;

}

.pw-container {
    width: 30%;
    margin: 0 auto;
    margin-top: 30px;
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

.pw-check-container {
    width: 30%;
    margin: 0 auto;
    margin-top: 30px;
}

.pw-check {
    color: #82ACC1;
    font-size: 15px;
    font-weight: 600;
    text-align: start;
    margin-bottom: 5px;
}

.pw-check-input {
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    border-radius: 3px;
    width: 100%;
    font-size: 15px;
    height: 30px;
    box-shadow: 1px 2px #8C8C8C;
    padding-left: 5px;
}

.email-container {
    width: 30%;
    margin: 0 auto;
    margin-top: 50px;
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
    padding-left: 5px;
}

.name-container {
    width: 30%;
    margin: 0 auto;
    margin-top: 30px;
}

.name {
    color: #82ACC1;
    font-size: 15px;
    font-weight: 600;
    text-align: start;
    margin-bottom: 5px;
}

.name-input {
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    border-radius: 3px;
    width: 100%;
    font-size: 15px;
    height: 30px;
    box-shadow: 1px 2px #8C8C8C;
    padding-left: 5px;
}

.nickname-container {
    width: 30%;
    margin: 0 auto;
    margin-top: 50px;
}

.nickname {
    color: #82ACC1;
    font-size: 15px;
    font-weight: 600;
    text-align: start;
    margin-bottom: 5px;
}

.nickname-input {
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    border-radius: 3px;
    width: 100%;
    font-size: 15px;
    height: 30px;
    box-shadow: 1px 2px #8C8C8C;
    padding-left: 5px;
}

.phonenum-container {
    width: 30%;
    margin: 0 auto;
    margin-top: 50px;
}

.phonenum {
    color: #82ACC1;
    font-size: 15px;
    font-weight: 600;
    text-align: start;
    margin-bottom: 5px;
}

.phonenum-input {
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    border-radius: 3px;
    width: 100%;
    font-size: 15px;
    height: 30px;
    box-shadow: 1px 2px #8C8C8C;
    padding-left: 5px;
}

.button-group {
    display: flex;
    justify-content: space-between;
    margin: 0 auto;
    width: 30%;
}

.cancel-btn {
    width: 49%;
    padding-top: 10px;
    padding-bottom: 10px;
    background-color: #D24646;
    opacity: 78%;
    border: none;
    border-radius: 4px;
    color: white;
    font-weight: 500;
    cursor: pointer;
    text-decoration: none;
    font-size: 15px;
}

.cancel-btn:hover {
    transform: scale(1.05);
    transition: 0.5s;
}

.next-btn {
    width: 49%;
    padding-top: 10px;
    padding-bottom: 10px;
    background-color: #82ACC1;
    border: none;
    border-radius: 4px;
    color: white;
    font-weight: 500;
    cursor: pointer;
    font-size: 15px;
}

.next-btn:hover {
    transform: scale(1.05);
    transition: 0.5s;
}

.next-btn-disabled {
    width: 49%;
    padding-top: 10px;
    padding-bottom: 10px;
    background-color: #D9D9D9;
    border: none;
    border-radius: 4px;
    color: white;
    font-weight: 500;
    font-size: 15px;
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