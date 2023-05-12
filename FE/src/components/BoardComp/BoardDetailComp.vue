<template>
    <div id="boardDetail">
        <UserTitleComp />
        <div id="Wrapper">
            <div id = "boardWrapper">
                <div id = "boardTitle">{{ board?.title }}</div>
                <div id = "boardInfo">
                    <p id="author">{{ board?.writer }}</p>
                    <p id="createdDate">{{ board?.createTime }}</p>
                </div>
                <div v-html="changeMarkdown" class="content"></div>
                <div class="boardFooter">
                    <div class="checkSticker">
                        <div class="sticker">
                            <p style="color : #D7AA71; cursor: pointer;">좋아요</p>
                            <p style="padding : 0 0.3rem;">|</p>
                            <p style="color : #D7AA71; cursor: pointer;">도움되요</p>
                            <p style="padding : 0 0.3rem;">|</p>
                            <p style="color : #D7AA71; cursor: pointer;">이해가 쏙쏙되요</p>
                        </div>
                    </div>
                    <div id="boardUD">
                        <div>
                            <p id="boardShare">퍼가기</p>
                        </div>
                        <div class="myUpdate">
                            <p id="boardUpdate">수정</p>
                            <p>|</p>
                            <p id="boardDelete">삭제</p>
                        </div>
                    </div>
                </div>
                <div id = "comment">
                    <CommentListComp :comments="board.comments"/>
                    <CommentCreateComp @addBoardComment="addBoardComment"/>
                </div>
            </div>
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
        console.log(response.data.body);
        board.value = response.data.body;
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

</script>

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
    #boardWrapper {
        height: 85%;
        width : 87%;
        overflow : scroll;
        overflow-x: hidden;
        /* overflow: hidden; */
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
        width : 8rem;
        justify-content: space-between;
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
</style>