<template>
    <div id="boardDetail">
        <UserTitleComp />
        <div id="Wrapper">
            <perfect-scrollbar>
                <div id = "boardTitle">{{ board?.title }}</div>
                <div id = "boardInfo">
                    <p id="author">{{ board?.writer }}</p>
                    <p id="createdDate">{{ board?.createTime }}</p>
                </div>
                <div v-html="changeMarkdown" class="content"></div>
                <div class="boardFooter">
                    <div class="checkSticker" v-if="board && board.sticker">
                        <div class="sticker" v-if="board.userSeq !== userSeq">
                            <img src="@/assets/boardIcon/heart.png" alt="heart" v-if="board.sticker[0] === true" @click="toggleSticker(0)">
                            <img src="@/assets/boardIcon/heart_no.png" alt="heart_no" v-else @click="toggleSticker(0)">
                            <img src="@/assets/boardIcon/help.png" alt="plus" v-if="board.sticker[1] === true" @click="toggleSticker(1)">
                            <img src="@/assets/boardIcon/help_no.png" alt="plus_no" v-else @click="toggleSticker(1)">
                            <img src="@/assets/boardIcon/bulb.png" alt="idea" v-if="board.sticker[2] === true" @click="toggleSticker(2)">
                            <img src="@/assets/boardIcon/bulb_no.png" alt="idea_no" v-else @click="toggleSticker(2)">
                        </div>
                    </div>
                    <div id="boardUD">
                        <div v-if="board.userSeq !== userSeq">
                            <p id="boardShare" @click="shareBoard(board.boardSeq)">퍼가기</p>
                        </div>
                        <div class="myUpdate" v-else>
                            <p id="boardUpdate" @click="updateBoard(board.boardSeq)">수정</p>
                            <p style="padding : 0 0.5rem">|</p>
                            <p id="boardDelete" @click="deleteBoard(board.boardSeq)">삭제</p>
                        </div>
                    </div>
                </div>
                <div id = "comment">
                    <CommentListComp :comments="board.comments"/>
                    <CommentCreateComp @addBoardComment="addBoardComment"/>
                </div>
        </perfect-scrollbar>
        </div>
    </div>
</template>


<script setup>
import CommentListComp from '@/components/BoardComp/CommentComp/CommentListComp.vue'
import CommentCreateComp from '@/components/BoardComp/CommentComp/CommentCreateComp.vue'
import UserTitleComp from "../BasicComp/UserTitleComp.vue";
import { ref, onMounted, computed } from 'vue';
import axios from 'axios';
import { marked } from 'marked';
import { useRoute } from 'vue-router';
import { router } from '@/router';
import {PerfectScrollbar} from 'vue3-perfect-scrollbar';

const content = ref(``);
const board = ref({});

const route = useRoute();
const minihomeMaster = computed(() => route.params.userSeq);
const boardSeq = computed(() => route.params.boardSeq);
const baseUrl = `https://k8a308.p.ssafy.io/api`;
const headers = {
    "Content-Type": "application/json;charset=utf-8",
    Authorization: `Bearer ${localStorage.getItem("access-token")}`,
  };
const userSeq = Number(localStorage.getItem('user-seq'));

const formatDate = (dateString) => {
  const date = new Date(dateString);
  const year = date.getFullYear();
  const month = ("0" + (date.getMonth() + 1)).slice(-2);
  const day = ("0" + date.getDate()).slice(-2);
  const hours = ("0" + date.getHours()).slice(-2);
  const minutes = ("0" + date.getMinutes()).slice(-2);
  const seconds = ("0" + date.getSeconds()).slice(-2);

  return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
};

const getBoardDetail = () => {
    axios.get(`${baseUrl}/board?userSeq=${minihomeMaster.value}&boardSeq=${boardSeq.value}`,{headers})
    .then((response) => {
        console.log(response.data);
        board.value = response.data;
        content.value = board.value?.content;
        board.value.createTime = formatDate(board.value?.createTime);
    })
    .catch((error) => {
        console.error(error);
        alert("게시글을 불러올 수 없습니다");
    })
}

onMounted (() => {
    getBoardDetail();
});

const changeMarkdown = computed(() => {
    let changedText = marked.parse(content.value);
    changedText = changedText.replaceAll("&lt;", "<");
    changedText = changedText.replaceAll("&gt;", ">");
    changedText = changedText.replaceAll("&quot;", '"');
    return changedText; 
});

const addBoardComment = () => {
    board.value = {};
    getBoardDetail();
}

const updateBoard = (boardSeq) => {
    router.push(`/board/${userSeq}/create/${boardSeq}`);
}

const deleteBoard = (boardSeq) => {
    console.log(boardSeq);
    axios.delete(`${baseUrl}/board?boardSeq=${boardSeq}`, {headers})
    .then(response => {
        console.log(response);
        alert("게시글 삭제 완료!");
        router.push(`/board/${userSeq}/boardlist/all`);
    })
    .catch(error => {
        console.error(error);
        alert("게시글 삭제 불가");
    })
}

const toggleSticker = (index) => {
    const requestDto = {
        boardSeq : boardSeq.value,
        type : index + 1,
        userSeq : userSeq,
    };

    if (board.value.sticker[index]) {
        const deleteSticker = axios.create({
            baseURL : `https://k8a308.p.ssafy.io/api`,
            headers : {
                    Authorization : `Bearer ${localStorage.getItem("access-token")}`,
                    //"Content-Type": "application/json;charset=utf-8"
                }
        });
            deleteSticker.delete("/board/sticker", {data:requestDto})
            .then(response => {
                console.log(response.data);
                board.value.sticker[index] = false;
            })
            .catch(error => {
                console.error(error);
            })
        // axios
        //     .delete(`${baseUrl}/board/sticker`, {data : requestDto }, {headers})
        //     .then(response => {
        //         console.log(response);
        //         board.value.sticker[index] = false;
        //     })
            
    } else {
        axios
            .post(`${baseUrl}/board/sticker`, requestDto, {headers})
            .then(response => {
                console.log(response);
                board.value.sticker[index] = true;
            })
            .catch(error => {
                console.error(error);
            })
    }
}

const shareBoard = (boardSeq) => {
    const requestDto = {
        userSeq : userSeq,
        boardSeq : boardSeq
    };
    axios
        .post(`${baseUrl}/bookmark`, requestDto, {headers})
        .then(response => {
            console.log(response.data);
            if(confirm("북마크로 이동하시겠습니까?")) {
                router.push(`/board/${userSeq}/boardlist/Share`);
            }
        })
        .catch(error => {
            console.error(error);
            alert("북마크에 담지 못했습니다");
        })
}

</script>

<style src="vue3-perfect-scrollbar/dist/vue3-perfect-scrollbar.css"/>
<style scoped>
    #boardDetail {
        overflow: hidden!important;
    }
    #Wrapper {
        height: 75vh;
        max-height: 75vh;
        width : 62vw;
        border: 1px solid #6A6A6A;
        border-radius : 15px;
        background-color: white;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .ps {
        height : 85%;
        width : 87%;
        padding : 0 2% 0 2%;
    }
    #boardTitle {
        height: 1rem;
        background-color: #F2F2F2;
        display : flex;
        justify-content: center;
        align-items: center;
        font-size : 1.2rem;
        font-weight: bold;
        padding : 1%;
        border-style: solid;
        border-top-color: #E5E5E5;
        border-bottom-color: #E5E5E5;
        border-left: 0;
        border-right: 0;
    }
    #boardInfo {
        display : flex;
        height: 0.9rem;
        justify-content: space-between;
        align-items: center;
        padding : 1% 3% 1% 3%;
        background-color: #FAFAFA;
    }
    #author {
        color : #82ACC1;
        font-size : 0.9rem;
    }
    #createdDate {
        font-size : 0.8rem;
    }

    .content {
        display: flex;
        flex-direction: column;
        text-align : justify;
        padding : 0 1rem;
    }

    .boardFooter{
        display : flex;
        flex-direction: row;
        justify-content: space-between;
        border-top : dashed black 1px;
        border-bottom : solid black 1px;
        margin : 2% 0 2% 0;
        padding : 0 2rem;
        font-size : 0.8rem;
    }
    .sticker {
        
        font-weight: bold;
        cursor: pointer;
        display: flex;
        flex-direction: row;
        align-items: center;
    }
    .checkSticker {
        display: flex;
        flex-direction : row;
        align-items: center;
    }

    .sub_nav {
        display: flex;
        flex-direction: row;
        margin-left : 1rem;
        visibility: hidden;
    }
    .sticker:hover > .sub_nav {
        visibility: visible;
        transition: visibility 0s, opacity 0.5s ease;
    }

    #boardUD {
        display : flex;
        flex-direction: row;
    }
    .myUpdate {
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: space-between;
    }
    #boardUpdate, #boardDelete, #boardShare {
        color:#D7AA71;
        font-weight: bold;
        cursor: pointer;
    }

    #comment {
        background-color: #F0F0F0;
        display: flex;
        flex-direction: column;
        align-items: center;
        text-align :justify;
        padding : 1rem 0 0.5rem 0;
    }
    img {
        width : 1.2rem;
        padding-right : 0.7rem;
        cursor: pointer;
    }
    .temp {
        width : 1.5rem;
    }
</style>