<template>
    <div class="boardWrapper">
        <UserTitleComp/>
        <div class="shareWrapper">
            <div v-if="boards.length === 0">
                <img src="@/assets/no_bookmark.png" alt="no_bookmark" class="NoBM">
                <div class="NoBookMark">북마크가 없어요</div>
            </div>
            <ul class="shareBoardlist" v-else>
                <li v-for="board in boards" v-bind:key="board?.bookmarkSeq" class="shareBoard">
                    <img v-if="board?.imgUrl !== ''" :src="board?.imgUrl" alt="" class="board_img">
                    <img v-else src="@/assets/no_image.jpg" alt="" class="board_img">
                    <div class="boardInfo">
                        <div class="boardHeader">
                            <span class="author">{{ board.writerNickname }}</span>
                            <span class="createdTime">{{ board?.updateTime?.slice(0, 10) }}</span>
                        </div>
                        <img class="menu_dots" src="@/assets/icon/drop_dots.png" alt="" @click="onContextMenu($event,board?.writerSeq,board?.boardSeq, board?.bookMarkSeq)" style="cursor: pointer;">
                    </div>
                    <div class="title">{{ board?.title?.length > 22 ? board?.title?.slice(0, 22) + '...' : board?.title }}</div>
                    <div class="content">
                        <p>{{ board.content }}</p>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</template>

<script setup>
import UserTitleComp from "../BasicComp/UserTitleComp.vue";
import axios from 'axios';
import { ref, onBeforeMount } from 'vue';
import ContextMenu from '@imengyu/vue3-context-menu';
import { router } from "@/router";

const headers = {
    "Content-Type" : "application/json;charset=utf-8",
    Authorization: `Bearer ${localStorage.getItem("access-token")}`,
  };
const baseURL = "https://k8a308.p.ssafy.io/api";

const boards = ref([]);
const userSeq = ref(`${localStorage.getItem("user-seq")}`);

const getBookmarks = () => {
    axios.get(`${baseURL}/bookmark?user=${userSeq.value}`, {headers})
    .then(response => {
        console.log(response);
        boards.value = response.data;
    })
    .catch(error => {
        console.error(error);
    })
}

onBeforeMount(() => {
    getBookmarks();
})

const onContextMenu = (event, writerSeq, boardSeq, bookmarkSeq) => {
    event.preventDefault();
    const menuItems = [
        {
            label : '바로가기',
            onClick : () => {
                router.push(`/board/${writerSeq}/${boardSeq}`)
            }
        },{
            label : '북마크 삭제',
            onClick : () => {
                axios
                    .delete(`${baseURL}/bookmark?bookMarkSeq=${bookmarkSeq}`, {headers})
                    .then(response => {
                        console.log(response);
                        boards.value = boards.value.filter(board => board.bookMarkSeq !== bookmarkSeq);
                    })
                    .catch(error => {
                        console.error(error);
                    })
            }
        }
    ]
    ContextMenu.showContextMenu({
        items : menuItems,
        zIndex : 3,
        minWidth : 100,
        maxWidth : 100,
        x : event.pageX,
        y : event.pageY
    });
}

</script>


<style scoped>
    /* .boardWrapper {
        padding-top : 40px;
    } */
    .shareWrapper {
        height: 75vh;
        width : 62vw;
        border: 1px solid #6A6A6A;
        border-radius : 15px;
        background-color: white;
        display : flex;
        justify-content: center;
        align-items: center;
    }
    .shareBoardlist {
        height : 90%;
        width : 100%;
        list-style: none;
        display : grid;
        grid-template-columns : 19vw 19vw 19vw;
        overflow-y:scroll;
        -ms-overflow-style: none; /* 인터넷 익스플로러 */
        scrollbar-width: none; /* 파이어폭스 */
    }
    .shareBoardlist::-webkit-scrollbar {
        display: none;
    }

    .shareBoard{
        border : 1px solid #D9D9D9;
        border-radius : 5px;
        margin : 1vw;
        padding : 1rem 0.2rem;
        height : 15rem;
        box-shadow: rgba(0,0,0,0.04) 0px 4px 16px 0px;
    }
    .boardInfo {
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
    .board_img{
        height: 8rem;
    }
    .boardHeader {
        display: flex;
        margin : 1vh 1.8vw;
    }
    .author {
        color : #82ACC1;
        font-size: 0.7rem;
    }
    .createdTime {
        color : #c0c0c0;
        font-size : 0.6rem;
        padding : 0 0.5vh;           
    }

    .title {
        text-align: justify;
        margin : 0.5vh 1.8vw;
        font-size : 0.825rem;
        font-weight : bold;
    }
    .content {
        font-size : 0.7rem;
        margin : 0.5vh 1.8vw;
        text-align:justify;
    }
    .menu_dots {
        height: 0.8rem;
        margin-right : 0.5rem;
        cursor: pointer;
    }
    .NoBookMark {
        font-size : 1.7rem;
        font-weight: bold;
    }
    .NoBM {
        width : 11rem;
        height : 16rem;
    }
</style>