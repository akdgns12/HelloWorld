<script>
import http from '@/api/httpWithAccessToken';
export default {
    props: {
        show: Boolean
    },
    data() {
        return {
            userSeq: localStorage.getItem('user-seq'),
            nickname: null,
            userAvatar: null,
        }
    },
    methods: {
        deleteUser: function () {
            http.delete(`/user/delete`).then((response) => {
                console.log(response);
                localStorage.clear();
                var link = document.location.href; 
                    if(link.includes('localhost')) {
                        window.location.replace(`http://localhost:8081/`);
                    }
                    else {
                        window.location.replace(`https://k8a308.p.ssafy.io/`);
                    }
            }, (error) => {
                console.log(error);
            })
        }
    },
    created() {
        http.get(`/user/userInfo/${this.userSeq}`).then((result) => {
            this.nickname = result.data.data.nickname;
            this.userAvatar = result.data.data.avatarUrl;
        }, (error) => {
            console.log(error);
        });
    }
}
</script>

<template>
    <Transition name="modal">
        <div v-if="show" class="modal-mask">
            <div class="modal-container">
                <div class="modal-header">
                    서비스를 탈퇴해요 ㅠㅅㅠ
                </div>
                <div class="modal-body">
                    <div class="user-info">
                        <div class="profile-img-container">
                            <img class="profile-img" :src="`${this.userAvatar}`" />
                            
                        </div>
                    </div>

                    <div class="nickname-msg">{{this.nickname}}님!</div>
                    <div class="request-msg">회원님의 모든 정보가 삭제됩니다</div>
                    <div class="request-msg">그래도 탈퇴하시겠습니까?</div>
                    <div class="btn-list">
                        <div class="send-btn" @click="deleteUser">
                            탈퇴하기
                        </div>
                        <div class="close-btn" @click="$emit('close')">
                            닫기
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </Transition>
</template>

<style scoped>
.modal-header {
    color: #82ACC1;
    font-weight: 600;
    font-size: 14px;
}

.user-info {
    display: flex;
    justify-content: center;
    line-height: 80px;
    margin-bottom: 20px;
}

.user-name {
    color: #82ACC1;
    font-size: 12px;
    font-weight: 600;
}

.nickname-msg {
    color: #6A6A6A;
    font-size: 15px;
    text-align: center;
    margin-bottom: 10px;
    font-weight: 600;
}
.request-msg {
    color: #6A6A6A;
    font-size: 12px;
    text-align: center;
}

.profile-img-container {
    width: 80px;
    height: 80px;
    margin-right: 10px;
}

.profile-img {
    width: 100%;
    height: 100%;
    object-fit: fill;
}

.select-name {
    display: flex;
    margin-top: 10px;
    /* justify-content: center; */
    width: 90%;
}

.family-name-input {
    width: 8vw;
    height: 12px;
    font-size: 12px;
    /* zoom: 0.8; */
    margin-left: 5px;
    border-radius: 3px;
    border: 1px solid #6A6A6A;
    padding: 2px;
}

.family-name-input::placeholder {
    color: #A5A5A5;
}

.request-msg-container {
    justify-content: center;
    display: flex;
    margin-top: 10px;
}

.request-msg-input {
    width: 100%;
    border: 1px solid #6A6A6A;
    border-radius: 0px;
    height: 100px;
    resize: none;
    font-size: 12px;
    padding: 10px;
    color: #6A6A6A;
}

.request-msg-input::placeholder {
    color: #A5A5A5;
}

.notice-msg {
    color: #6A6A6A;
    width: 100%;
    text-align: center;
    font-size: 10px;
    margin-top: 8px;
    /* zoom: 0.7; */
}

.btn-list {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}

.send-btn {
    margin-right: 10px;
    background-color: #82ACC1;
    color: white;
    font-size: 12px;
    height: 20px;
    padding: 2px 10px 2px 10px;
    line-height: 20px;
    cursor: pointer;
    /* zoom: 0.9; */
    border-radius: 5px;
}

.close-btn {
    background-color: #D9D9D9;
    color: #6A6A6A;
    font-size: 12px;
    height: 20px;
    padding: 2px 15px 2px 15px;
    line-height: 20px;
    cursor: pointer;
    /* zoom: 0.9; */
    border-radius: 5px;
}

.modal-mask {
    position: fixed;
    z-index: 9998;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    transition: opacity 0.3s ease;
}

.modal-container {
    width: 380px;
    margin: auto;
    padding: 20px 30px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 4px 6px rgba(0, 0, 0, 0.3);
    transition: all 0.2s ease-in-out;
    justify-content: center;
}

.modal-body {
    margin: 20px 0;
    justify-content: center;
}

.modal-enter-from {
    opacity: 0;
}

.modal-leave-to {
    opacity: 0;
}

.modal-enter-from .modal-container,
.modal-leave-to .modal-container {
    -webkit-transform: scale(1.3);
    transform: scale(1.3);
}
</style>