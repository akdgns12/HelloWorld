<template>
    <div class="wrap">
        <!-- <div class="blank"></div> -->
        <UserTitleComp />
        <div class="right-body">
            <div class="profile-img-container">
                <img class="profile-img" :src="`${this.userAvatar}`" alt="프로필 사진" />
                <div class="select-profile-img-btn" for="file">아바타 변경하기
                    <input type="file" style="display: none;" id="file" />
                </div>
            </div>
            <ModalView>

            </ModalView>
            <div class="user-info-whole-container">
                <div class="user-info-container">
                    <div class="user-info-title">이메일</div>
                    <div class="user-info-content">{{this.userEmail}}</div>
                </div>

                <div class="user-info-container">
                    <div class="user-info-title">닉네임</div>
                    <input class="user-info-content" v-model="this.modifyNickname" :placeholder="`${this.userNickname}`"/>
                </div>
                <div class="user-info-container">
                    <div class="user-info-title">이름</div>
                    <input class="user-info-content"  v-model="this.modifyName" :placeholder="`${this.userName}`"/>
                </div>
                <!-- <div class="user-info-container">
                    <div class="user-info-title">BGM</div>
                    <div class="user-info-content">♬ 복숭아 - 아이유</div>
                    <div class="select-bgm-btn">변경</div>
                </div> -->
                <!-- <div class="user-info-container">
                    <div class="user-info-title">미니홈피명</div>
                    <input class="user-info-content" value="김싸피 님의 미니홈피" />
                </div> -->
                <div class="user-info-container">
                    <div class="user-info-title">한 줄 소개</div>
                    <input class="user-info-content" v-model="this.modifyOneLineDesc" :placeholder="`${this.oneLineDesc}`"/>
                </div>
                <div class="user-info-container">
                    <div class="user-info-title">핸드폰 번호</div>
                    <input class="user-info-content" v-model="this.modifyPhoneNum" :placeholder="`${this.phoneNum}`"/>
                </div>
                <div class="user-info-container">
                    <div class="delete-user-btn" @click="showModal = true">
                        회원 탈퇴
                    </div>
                </div>
                <div class="user-info-container">
                    <div class="logout-user-btn" @click="logout">
                        로그아웃
                    </div>
                </div>
                <div class="user-info-container">
                    <div class="modify-user-btn" @click="modify">
                        수정
                    </div>
                </div>
            </div>
        </div>
        <Teleport to="body">
                <modal :show="showModal" @close="showModal = false">
                    <template #header>
                        <h3>custom header</h3>
                    </template>
                </modal>
            </Teleport>
    </div>
</template>

<script>
import http from '@/api/httpWithAccessToken';
import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue"
import Modal from '@/components/UserComp/UserDeleteModal.vue'
export default {
    components: { UserTitleComp, Modal },
    data() {
        return {
            userSeq: localStorage.getItem('user-seq'),
            userEmail: null,
            userNickname: null,
            userName: null,
            oneLineDesc: null,
            phoneNum: null,
            userAvatar: null,
            showModal: false,
            modifyNickname: null,
            modifyName: null,
            modifyOneLineDesc: null,
            modifyPhoneNum: null,
        }
    },
    methods: {
        logout: function () {
            var tokens = {
                accessToken: localStorage.getItem('access-token'),
            }
            http.post(`/user/logout`, JSON.stringify(tokens)).then(
                (response) => {
                    console.log(response);
                    localStorage.removeItem("access-token");
                    localStorage.removeItem("user-seq");
                    localStorage.removeItem("refresh-token");
                    var link = document.location.href; 
                    if(link.includes('localhost')) {
                        window.location.replace('http://localhost:8081/');
                    }
                    else {
                        window.location.replace('https://k8a308.p.ssafy.io/');
                    }
                },
                (error) => {
                    console.log(error);
                    alert("로그아웃 실패!");
                }
            )
        },

        modify: function() {
            if(this.modifyOneLineDesc=="" || this.modifyOneLineDesc==null) {
                this.modifyOneLineDesc=this.oneLineDesc;
            }
            if(this.modifyName=="" || this.modifyName==null) {
                this.modifyName=this.userName;
            }
            if(this.modifyNickname=="" || this.modifyNickname==null) {
                this.modifyNickname=this.userNickname;
            }
            if(this.modifyPhoneNum=="" || this.modifyPhoneNum==null) {
                this.modifyPhoneNum=this.phoneNum;
            }
            var info = {
                comment: this.modifyOneLineDesc,
                name: this.modifyName,
                nickname: this.modifyNickname,
                phoneNumber: this.modifyPhoneNum,
                userSeq: localStorage.getItem('user-seq'),
            }
            http.put(`/user/modify`, JSON.stringify(info)).then((result) => {
                console.log(result);
                var link = document.location.href;
                if (link.includes('localhost')) {
                    // window.location.replace(`http://localhost:8081/mainpage/${localStorage.getItem('user-seq')}`);
                    this.$router.push({name: 'mainpage', params: { userSeq: localStorage.getItem('user-seq') }})
                }
                else {
                    // window.location.replace(`https://k8a308.p.ssafy.io/mainpage/${localStorage.getItem('user-seq')}`);
                    this.$router.push({name: 'mainpage', params: { userSeq: localStorage.getItem('user-seq') }})
                }
            }, (error) => {
                console.log(error);
            })
        }
    },
    created() {
        http.get(`/user/userInfo/${this.userSeq}`).then((result) => {
            this.userEmail = result.data.data.email;
            this.userNickname = result.data.data.nickname;
            this.userName = result.data.data.name;
            this.oneLineDesc = result.data.data.comment;
            console.log(result.data.data)
            if(this.oneLineDesc==null) {
                this.oneLineDesc="";
            }
            this.phoneNum = result.data.data.phoneNumber;
            this.userAvatar = result.data.data.avatarUrl;
        }, (error)=>{
            console.log(error);
        });
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
    margin-top: 18vh;
    margin-left: 10vw;
}

.profile-img {
    width: 100%;
    height: 100%;
    object-fit: fill;
}

.user-info-whole-container {
    margin-top: 13vh;
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