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
               <li v-for="(notification, index) in notifications" :key="index" class="notification"
                :style="{ backgroundColor: notification.readState ? 'white' : '#FAF3E8'}">
                    <div v-if="notification?.type === 0" class="changeRead" @click="putNotification(notification?.notifySeq, 0, notification?.typeSeq)">
                        <div class="type" style="border:3px solid #FCB9AA">일</div>
                        <div>{{ notification?.title }}</div>
                        <div class="date"> <timeago :datetime="notification.createdTime" auto-update /></div>
                    </div>
                    <div v-else-if="notification?.type === 1" class="changeRead" @click="putNotification(notification?.notifySeq, 1, notification?.typeSeq)">
                        <div class="type" style="border:3px solid #C6E2FF">방</div>
                        <div>{{ notification?.title }}</div>
                        <div class="date"> <timeago :datetime="notification.createdTime" auto-update /></div>
                    </div>
                    <div v-else-if="notification?.type === 2" class="changeRead" @click="putNotification(notification?.notifySeq, 2, notification?.typeSeq)">
                        <span class="type" style="border:3px solid #008080">댓</span>
                        <span>{{ notification?.title }}</span>
                        <span class="date"> <timeago :datetime="notification.createdTime" auto-update /></span>
                    </div>
                    <div v-else-if="notification?.type === 3" class="changeRead" @click="putNotification(notification?.notifySeq, 3, notification?.typeSeq)">
                        <span class="type" style="border:3px solid #55CBCD">신</span>
                        <span>{{ notificaiton?.title }}</span>
                        <span class="date"> <timeago :datetime="notification.createdTime" auto-update /></span>
                    </div>
                    <div v-else-if="notification?.type === 4" class="changeRead" @click="putNotification(notification?.notifySeq, 4, notification?.typeSeq)">
                        <span class="type" style="border:3px solid black">수</span>
                        <span>{{ notification?.title }}</span>
                        <span class="date"> <timeago :datetime="notification.createdTime" auto-update /></span>
                    </div>
                    <img src="@/assets/icon/trash.png" alt="" @click="deleteNotification(notification?.notifySeq, index)" style="cursor:pointer">
                </li>
            </ul>
          </div>
        </div>
    </Transition>
</template>

<script>
import axios from 'axios';
import { EventSourcePolyfill } from 'event-source-polyfill';

const baseURL = `https://k8a308.p.ssafy.io/notify/`;
const notifyURL = baseURL + `${localStorage.getItem("user-seq")}`;
const headers = {
                "Authorization" : `Bearer ${localStorage.getItem("access-token")}`,
                "Accept" : 'text/event-stream',
                "Content-Type": "text/event-stream;charset=utf-8"
            };
export default {
    props: {
      show: Boolean,
    },
    data() {
        return  {
            notifications : [],
        }
    },
    methods : {
        linkSSE() {
            const source = new EventSourcePolyfill(
               notifyURL,{headers, heartbeatTimeout : 1000 * 60 * 60}
            );
            source.onmessage = (event) => {
              const temp = JSON.parse(event.data);
              console.log(temp);
              this.notifications.push(JSON.parse(event.data));
            };
            source.onerror = (error) => {
                console.error(error);
              source.close();
              //alert("SSE 에러 발생");
            };
        },
        putNotification(notifySeq, type, typeSeq) {
            console.log(type, typeSeq);
            const header = {
                "Content-Type": "application/json;charset=utf-8",
                Authorization: `Bearer ${localStorage.getItem("access-token")}`,
            }
            const requestDto = {
                notifySeq : notifySeq
            }
            axios.put(`/notify/`, {header}, requestDto)
            .then((response) => {
                console.log(response.data);
                const updateNotification = this.notifications.map(notification => {
                if (notification.notifySeq === notifySeq) {
                    notification.readState = true;
                }
                return notification;
            })
            console.log(updateNotification);
                
            })
            .catch((error) => {
                console.error(error);
                alert("알람을 읽지 못했습니다")
            })
        },
        deleteNotification(notifySeq, index) {
            const header = {
                "Content-Type": "application/json;charset=utf-8",
                Authorization: `Bearer ${localStorage.getItem("access-token")}`,
            };
            const requestDto = {
                notifySeq : notifySeq
            };
            try {
                if (confirm('정말 삭제하시겠습니까?')) {
                    axios.delete("https://k8a308.p.ssafy.io/notify/", {header}, requestDto)
                    .then((response) => {
                        console.log(response.data);
                        this.notifications.splice(index,1);
                    })
                    .catch((error) => {
                        console.error(error);
                        alert("알림 삭제가 되지 않습니다!");
                    })
                }
            } catch (error) {
                console.log(error);
                alert('이미 삭제가 된 알림입니다!')
            }
        }
    },
    created() {
        this.linkSSE();
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
    .changeRead {
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
    }
    .type {
        background-color: white;
        border-radius: 30px;
        font-size : 1.5rem;
        width : 3rem;
        height : 3rem;
        display: flex;
        justify-content: center;
        align-items: center;
        margin-right : 1rem;
    }

</style>