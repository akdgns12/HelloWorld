<template>
    <Transition name="modal">
        <div v-if="show" class="modal-mask">
          <div class="modal-container">
            <div class="modal-header" @click="$emit('close')">
                <img src="@/assets/icon/close.png" alt="" style="cursor:pointer">
            </div>
            <div class="notification-list">
                <div v-for="notification in notifications" v-bind:key="notification.notification_id" class="notification">
                    <div v-if="notification.type == 0">
                        <span class="nickname">{{ notification.nickname }}</span>
                        <span>님이</span>
                        <span>일촌평</span>
                        <span>을 남겼습니다.</span>
                    </div>
                    <div v-else-if="notification.type == 1">
                        <span class="nickname">{{ notification.nickname }}</span>
                        <span>님이</span>
                        <span class="acc">방명록</span>
                        <span>을 남겼습니다.</span>
                    </div>
                    <div v-else-if="notification.type == 2">
                        <span class="nickname">{{ notification.nickname }}</span>
                        <span>님이</span>
                        <span>{{ notification.title }}</span>
                        <span>에</span>
                        <span class="acc">댓글</span>
                        <span>을 남겼습니다.</span>
                    </div>
                    <div v-else-if="notification.type == 3">
                        <span class="nickname">{{ notification.nickname }}</span>
                        <span>님이</span>
                        <span class="ilchon">일촌신청</span>
                        <span>을 하였습니다.</span>
                    </div>
                    <div v-else-if="notification.type == 4">
                        <span class="nickname">{{ notification.nickname }}</span>
                        <span>님이</span>
                        <span class="ilchon">일촌신청</span>
                        <span>을</span>
                        <span  class="acc">수락</span>
                        <span>하였습니다.</span>
                    </div>
                </div>
            </div>
          </div>
        </div>
    </Transition>
</template>

<script>
export default {
    props: {
        show: Boolean
    },
    data() {
        return {notifications : [{notification_id : 10, type : 0, nickname : '싸89', title : null}, {notification_id : 7,type : 2, nickname : '이싸피', title : '싸이월드 미니홈피 제작기 figma 제작'},
                        {notification_id : 5,type : 2, nickname : '윤싸피', title : '싸이월드 미니홈피 제작기 figma'},{notification_id : 4,type : 3, nickname : '싸89', title : null},
                        {notification_id : 3,type : 1, nickname:'이싸피', title: null}, {notification_id : 2,type : 0, nickname : '커피2리터', title : null}, {notification_id : 1,type : 4, nickname : '서울사람',title : null}]}
        
    }
}
</script>

<style scoped>
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
      width: 55vw;
      height: 80vh;
      margin: auto;
      padding: 2vw 3vh;
      background-color: #fff;
      border-radius: 2vw;
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
      transition: all 0.3s ease;
    }

    .modal-container img {
        width : 1.5vw;
        margin : 1vw;
    }

    .modal-header{
      margin-top: 0;
      display: flex;
      justify-content: right;
    }
    .modal-enter-from {
      opacity: 0;
    }

    .modal-leave-to {
      opacity: 0;
    }

    .modal-enter-from .modal-container,
    .modal-leave-to .modal-container {
      -webkit-transform: scale(1.1);
      transform: scale(1.1);
    }

    .notification {
        border : solid 1px;
        margin : 1vh 0;
        font-size : 2vh;
    }
    .nickname {
        color : #82ACC1;
        font-weight: bold;
        margin-right : 0.5vh;
    }

    .ilchon{
        color : #E29714;
        font-weight: bold;
        margin-left : 1vh;
    }
    .acc{
        font-weight:bold;
        margin-left : 1vh;
    }
</style>