<script>
export default {
    props: {
        show: Boolean
    }
}
</script>

<template>
    <Transition name="modal">
        <div v-if="show" class="modal-mask">
            <div class="modal-container">
                <div class="modal-header">
                    일촌을 신청해요!
                </div>
                <div class="modal-body">
                    <div class="user-info">
                        <div class="profile-img-container">
                            <img class="profile-img" src="@/assets/image/Person.png" />
                        </div>
                        <div class="user-name">최싸피</div>
                        <div class="request-msg">&nbsp;님께 일촌을 신청합니다</div>
                    </div>
                    <div class="select-name">
                        <div class="user-name">최싸피</div>
                        <div class="request-msg">&nbsp;님을&nbsp;</div>
                        <div class="user-name">김싸피 (나)</div>
                        <div class="request-msg">&nbsp;님의</div>
                        <input class="family-name-input" placeholder="일촌명" />
                        <div class="request-msg">&nbsp;로,</div>
                    </div>
                    <div class="select-name">
                        <div class="user-name">김싸피 (나)</div>
                        <div class="request-msg">&nbsp;님을&nbsp;</div>
                        <div class="user-name">최싸피</div>
                        <div class="request-msg">&nbsp;님의</div>
                        <input class="family-name-input" placeholder="일촌명" />
                        <div class="request-msg">&nbsp;로,</div>
                    </div>
                    <div class="request-msg-container">
                        <textarea class="request-msg-input" placeholder="일촌 신청 메시지를 작성해주세요"></textarea>
                    </div>
                    <div class="notice-msg">
                        상대방이 동의하면 일촌이 맺어집니다
                    </div>
                    <div class="btn-list">
                        <div class="send-btn">
                            보내기
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
    /* justify-content: start; */
    line-height: 80px;
    margin-bottom: 20px;
}

.user-name {
    color: #82ACC1;
    font-size: 12px;
    font-weight: 600;
    /* zoom: 0.8; */
}

.request-msg {
    color: #6A6A6A;
    font-size: 12px;
    /* zoom: 0.8; */
}

.profile-img-container {
    width: 80px;
    height: 80px;
    border: 1px solid #6A6A6A;
    border-radius: 5px;
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