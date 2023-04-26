<template>
    <Transition name="modal">
        <div v-if="show" class="modal-mask">
          <div class="modal-container">
            <div class="modal-header" @click="$emit('close')">
                <img src="@/assets/icon/close.png" alt="" style="cursor:pointer">
            </div>
            <ul class="notification-list">
                <li v-if="notifications.length === 0" class="notification-none">
                    <span>알림창이 비었습니다!</span>
                </li>
               <li v-else v-for="(notification, index) in notifications" v-bind:key="index" class="notification"
                :style="{ backgroundColor: notification.readState ? 'white' : '#FAF3E8'}">
                    <div v-if="notification.type == 0">
                        <span class="nickname">{{ notification.nickname }}</span>
                        <span>님이</span>
                        <span class="acc">일촌평</span>
                        <span>을 남겼습니다.</span>
                        <span class="date"> <timeago :datetime="notification.createdTime" auto-update /></span>
                    </div>
                    <div v-else-if="notification.type == 1">
                        <span class="nickname">{{ notification.nickname }}</span>
                        <span>님이</span>
                        <span class="acc">방명록</span>
                        <span>을 남겼습니다.</span>
                        <span class="date"> <timeago :datetime="notification.createdTime" auto-update/></span>
                    </div>
                    <div v-else-if="notification.type == 2">
                        <span class="nickname">{{ notification.nickname }}</span>
                        <span>님이</span>
                        <span class="acc">{{ notification.title.length > 22 ? notification.title.slice(0, 22) + '...' : notification.title }}</span>
                        <span>에</span>
                        <span class="acc">댓글</span>
                        <span>을 남겼습니다.</span>
                        <span class="date"> <timeago :datetime="notification.createdTime" auto-update/></span>
                    </div>
                    <div v-else-if="notification.type == 3">
                        <span class="nickname">{{ notification.nickname }}</span>
                        <span>님이</span>
                        <span class="ilchon">일촌신청</span>
                        <span>을 하였습니다.</span>
                        <span class="date"> <timeago :datetime="notification.createdTime" auto-update/></span>
                    </div>
                    <div v-else-if="notification.type == 4">
                        <span class="nickname">{{ notification.nickname }}</span>
                        <span>님이</span>
                        <span class="ilchon">일촌신청</span>
                        <span>을</span>
                        <span  class="acc">수락</span>
                        <span>하였습니다.</span>
                        <span class="date"> <timeago :datetime="notification.createdTime" auto-update/></span>
                    </div>
                    <img src="@/assets/icon/trash.png" alt="" @click="deleteNotification(index)" style="cursor:pointer">
                </li>
            </ul>
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
        return {notifications : [{notifySeq : 11, type : 4, readState : false,nickname : 'cotton_blanket', title : null, createdTime : '2023-04-26T14:25:43.511+09:00'},
                                {notifySeq : 10, type : 0, readState : false,nickname : '싸89', title : null, createdTime : '2023-04-25T18:25:43.511+09:00'}, 
                                {notifySeq : 7,type : 2, readState : true, nickname : '이싸피', title : 'CRA는 이제 그만!! 리액트 개발환경 직접 구축해보자!! (feat: webpack, babel)', createdTime : '2023-04-24T10:25:43.511+09:00'},
                                {notifySeq : 5,type : 2,readState : true, nickname : '윤싸피', title : 'CRA는 이제 그만!! 리액트 개발환경 직접 구축해보자!! (feat: webpack, babel)', createdTime : '2023-03-24T10:25:43.511+09:00'},
                                {notifySeq : 4,type : 3, readState : true,nickname : '싸89', title : null, createdTime : '2023-01-26T10:25:43.511+09:00'},
                                {notifySeq : 3,type : 1, readState : false,nickname:'이싸피', title: null, createdTime : '2022-04-26T10:25:43.511+09:00'}, 
                                {notifySeq : 2,type : 0, readState : false,nickname : '커피2리터', title : null, createdTime : '2022-03-26T10:25:43.511+09:00'},
                                {notifySeq : 1,type : 4,readState : true, nickname : '서울사람',title : null, createdTime : '2021-04-26T10:25:43.511+09:00'}
                            ]}
        
    },
    methods : {
        deleteNotification(i) {
            try {
                if (confirm('정말로 삭제하시겠습니까?')) {
                    this.notifications.splice(i,1);
                }
            } catch(error) {
                console.log(error);
            }
        }
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
    .notification-list {
        overflow-y:scroll;
        padding : 0 1vw;
        height : 70vh;
        -ms-overflow-style: none; /* 인터넷 익스플로러 */
        scrollbar-width: none; /* 파이어폭스 */
    }
    .notification-list::-webkit-scrollbar {
        display: none;
    }
    .notification-none {
        height : 50vh;
        display : flex;
        justify-content: center;
        align-items : center;
        font-size : 3.5vh;
    }
    .notification {
        border-top : solid 1px #6A6A6A;
        border-bottom : solid 1px #6A6A6A;
        margin : 1vh 0;
        font-size : 2vh;
        padding : 1vh 1vw;
        display: flex;
        justify-content: space-between;
        align-items: center;
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
    .date {
        margin : 0 1vh;
        font-size : 0.8vw;
        color : #6A6A6A;
    }
</style>