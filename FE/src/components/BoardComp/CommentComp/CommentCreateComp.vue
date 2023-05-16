<template>
    <div id = "createComments">
        <p style="font-weight:bold">댓글</p>
        <input type="search" v-model="content">
        <button @click="createComment">확인</button>
    </div>
</template>

<script setup>
import { ref, computed, getCurrentInstance } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const emit =getCurrentInstance().emit;

const content = ref('');
const baseUrl = `https://k8a308.p.ssafy.io/api`;
const headers = {
    "Content-Type": "application/json;charset=utf-8",
    Authorization: `Bearer ${localStorage.getItem("access-token")}`,
};
const route = useRoute();
const boardSeq = computed(() => route.params.boardSeq);

const createComment = () => {
    const requestDto = {
        "boardSeq": boardSeq.value,
        "content": content.value,
        "userSeq": localStorage.getItem('user-seq')
    };
    axios.post(`${baseUrl}/board/comment`, requestDto, {headers})
    .then(response => {
        content.value = '';
        axios.post(`https://k8a308.p.ssafy.io/notify/`, response.data, {headers});
        emit('addBoardComment');
    })
    .catch(error => {
        console.error(error);
        alert("댓글 달기 실패");
    })
}

</script>

<style scoped>
    #createComments {
        display: flex;
        width : 94%;
        justify-content: space-between;
        align-items: center;
        font-size : 0.9rem;
    }
    input {
        width : 80%;
        height: 1.5rem;
        background-color: #FFF9F9;
        border : 0;
    }
    button {
        background-color: white;
        border-radius: 0.5vh;
        font-size : 1.7vh;
        border-color : #6A6A6A;
        margin : 1px;
    }
</style>