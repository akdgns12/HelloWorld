<template>
    <div class="wrap">
        <!-- <div class="blank"></div> -->
        <UserTitleComp />
        <div class="right-body">
            <div class="profile-img-container">
                <img class="profile-img" src="@/assets/image/Person.png" alt="프로필 사진" />
                <div class="select-profile-img-btn" for="file">사진 변경하기
                    <input type="file" style="display: none;" id="file" />
                </div>
            </div>
            <ModalView>

            </ModalView>
            <div class="user-info-whole-container">
                <div class="user-info-container">
                    <div class="user-info-title">아이디</div>
                    <div class="user-info-content">ssafy1234</div>
                </div>
                <div class="user-info-container">
                    <div class="user-info-title">이메일</div>
                    <input class="user-info-content" value="ssafy1234@gmail.com" />
                </div>
                <div class="user-info-container">
                    <div class="user-info-title">닉네임</div>
                    <input class="user-info-content" value="나는야김싸피" />
                </div>
                <div class="user-info-container">
                    <div class="user-info-title">이름</div>
                    <input class="user-info-content" value="김싸피" />
                </div>
                <div class="user-info-container">
                    <div class="user-info-title">BGM</div>
                    <div class="user-info-content">♬ 복숭아 - 아이유</div>
                    <div class="select-bgm-btn">변경</div>
                    <!-- <audio controls autoplay loop style="display: none;">
                        <source src="http://soundbible.com/mp3/Air Plane Ding-SoundBible.com-496729130.mp3"
                            type="audio/mp3">
                        이 문장은 사용자의 웹 브라우저가 audio 요소를 지원하지 않을 때 나타납니다!
                    </audio> -->

                </div>
                <div class="user-info-container">
                    <div class="user-info-title">미니홈피명</div>
                    <input class="user-info-content" value="김싸피 님의 미니홈피" />
                </div>
                <div class="user-info-container">
                    <div class="user-info-title">한 줄 소개</div>
                    <input class="user-info-content" value="안녕하세요 꿈꾸는 개발자 입니다!" />
                </div>
                <div class="user-info-container">
                    <div class="delete-user-btn">
                        회원 탈퇴
                    </div>
                </div>
                <div class="user-info-container">
                    <div class="logout-user-btn" @click="logout">
                        로그아웃
                    </div>
                </div>
                <div class="user-info-container">
                    <div class="modify-user-btn">
                        수정
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import http from '@/api/httpWithAccessToken';
import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue"
export default {
    components: { UserTitleComp },
    methods: {
        logout: async function () {
            var tokens = {
                accessToken: window.localStorage.getItem('access-token'),
            }
            console.log(tokens);
            http.post(`/user/logout`, JSON.stringify(tokens)).then(
                (response) => {
                    console.log(response);
                    window.localStorage.removeItem("access-token");
                    window.localStorage.removeItem("user-seq");
                    this.$router.push({ name: 'before-login' });
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
.blank {
    height: 40px;
}

.right-body {
    background-color: white;
    width: 62vw;
    height: 75vh;
    border: 1px solid #6A6A6A;
    border-radius: 15px;
    display: flex;
}

.profile-img-container {
    width: 10vw;
    height: 20vh;
    border: 1px solid #6A6A6A;
    border-radius: 5px;
    margin-top: 10vh;
    margin-left: 10vw;
}

.profile-img {
    width: 100%;
    height: 100%;
    object-fit: fill;
}

.user-info-whole-container {
    margin-top: 6vh;
}

.user-info-container {
    margin-top: 30px;
    margin-left: 50px;
    display: flex;
}

.user-info-title {
    color: #82ACC1;
    font-weight: bold;
    font-size: 12px;
    text-align: start;
    width: 10vw;
}

.user-info-content {
    color: #6A6A6A;
    font-size: 12px;
    margin-left: 30px;
}

.select-bgm-btn {
    cursor: pointer;
    font-size: 12px;
    background-color: #82ACC1;
    color: #FFFFFF;
    padding: 2px 10px;
    text-align: end;
    margin-left: 1vw;
    font-weight: bold;
    border-radius: 20px;
}

.select-profile-img-btn {
    cursor: pointer;
    font-size: 12px;
    background-color: #82ACC1;
    color: #FFFFFF;
    padding: 3px 1px;
    text-align: center;
    /* margin-left: 27vw; */
    font-weight: bold;
    border-radius: 20px;
}

.delete-user-btn {
    cursor: pointer;
    font-size: 12px;
    color: #CC0000;
    text-decoration: underline;
    text-align: start;
    width: 10vw;
    font-weight: bold;
}

.logout-user-btn {
    cursor: pointer;
    font-size: 12px;
    color: #CC0000;
    text-decoration: underline;
    text-align: start;
    width: 10vw;
    font-weight: bold;
}

.modify-user-btn {
    cursor: pointer;
    font-size: 12px;
    background-color: #82ACC1;
    color: #FFFFFF;
    padding: 3px 10px;
    text-align: end;
    margin-left: 27vw;
    font-weight: bold;
    border-radius: 20px;
}
</style>