<template>
    <div id = "boardmain">
        <UserTitleComp />
        <div class="boardWrapper">
            <div id ="boardheader">
                <input type="text" placeholder="제목 쓰기" v-model="title">
                <select name="boardCategory" id="boardCategory" v-model="category">
                    <option value=1>CS</option>
                    <option value=2>Algorithm</option>
                    <option value=3>Project</option>
                    <option value=4>Language</option>
                    <option value=5>Etc</option>
                </select>
            </div>
            <div id="boardMD">
                <VMarkdownEditor 
                    id = "mdeditor"
                    v-model="content"
                    locale="en"
                    :upload-action="handleUpload"
                />
            </div>
            <div id="boardfooter">
                <button @click="createBoard">글쓰기</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import {ref} from 'vue'
import { VMarkdownEditor } from 'vue3-markdown'
import 'vue3-markdown/dist/style.css'
import UserTitleComp from "../BasicComp/UserTitleComp.vue";
import axios from 'axios';

const title = ref('');
const content = ref('');
const category = ref(0);
const handleUpload = (file) => {
    console.log(file)
    return 'https://i.postimg.cc/52qCzTVw/pngwing-com.png'
}

const headers = {
    "Content-Type": "application/json;charset=utf-8",
    Authorization: `Bearer ${localStorage.getItem("access-token")}`,
  };

const createBoard = () => {
    console.log(category.value);
    console.log(title.value);
    console.log(content.value);
    const requestDto = {
        "content" : content.value,
        "title" : title.value,
        "category" : category.value,
        "userSeq" : `${localStorage.getItem("user-seq")}`
    }
    axios.post(`/api/board`, {headers}, requestDto)
    .then((response) => {
        console.log(response.data);
        
    })
    .catch((error) => {
        console.error(error);
        alert("게시글이 왜 안만들어짐...?");
    })
}
</script>

<style scoped>
    /* #boardmain {
        padding-top : 40px;
    } */
    .boardWrapper {
        height: 75vh;
        width : 62vw;
        border: 1px solid #6A6A6A;
        border-radius : 15px;
        background-color: white;
        display : flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
    #boardheader{
        display : flex;
        justify-content: space-between;
        align-items: center;
        padding : 0 3vw 0 3vw;
        margin : 5vh 0 0.1rem 0;
        width : 45rem;
    }

    input {
        width : 60%;
    }
    select {
        width : 30%;
        /* -moz-appearance: none;
        -webkit-appearance: none;
        appearance: none; */
    }
    #boardMD {
        width : 45rem;
        height: 80%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #mdeditor{
        width : 100%;
        height: 95%;
    }

    #boardfooter {
        display : flex;
        justify-content: right;
        align-items: center;
        width : 45rem;
        font-size : 0.9rem;
        margin-bottom : 0.4rem;
    }
    #boardOpen {
        display: flex;
        width : 60%;
        align-items: center;
    }
    #boardOpen select {
        width : 55%;
        padding : 0.3vh 0 0.3vh 0;
        margin: 0 1vw 0 1vw;
    }
    p {
        font-size : 0.9rem;
        font-weight: bold;
    }
    button {
        background-color: #499DC6;
        color : white;
        font-size : 0.9rem;
        width : 4rem;
        border-radius: 5px;
        border : 2px solid;
    }

    option {
        width : 100%;
    }
</style>