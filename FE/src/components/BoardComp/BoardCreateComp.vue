<template>
    <div id = "boardmain">
        <div id ="boardheader">
            <input type="text" placeholder="제목 쓰기">
            <select name="boardCategory" id="boardCategory">
                <option value="cs">CS</option>
                <option value="algorithm">Algorithm</option>
                <option value="pjt">PJT</option>
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
            <div id="boardOpen">
                <p>공개 설정</p>
                <select name="boardOpen">
                    <option value="all">전체 공개</option>
                    <option value="onlyfriend">일촌 공개</option>
                    <option value="onlyme">비공개</option>
                </select>
            </div>
            <button>글쓰기</button>
        </div>
    </div>
</template>

<script setup>
import {ref} from 'vue'
import { VMarkdownEditor } from 'vue3-markdown'
import 'vue3-markdown/dist/style.css'
const content = ref('')
const handleUpload = (file) => {
    console.log(file)
    return 'https://i.postimg.cc/52qCzTVw/pngwing-com.png'
}
</script>

<style scoped>
    #boardmain {
        height: 72vh;
        width : 60vw;
        border-style : solid;
        border-width : 0.2vh;
        border-radius : 2vh;
        border-color: black;
        background-color: white;
        padding : 2vh;
        margin-left : 2vh;
    }
    #boardheader{
        display : flex;
        justify-content: space-between;
        padding : 0 3vw 0 3vw;
        margin : 5vh 0 1vh 0;
        width : 90%;
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
        width : 100%;
        height: 80%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #mdeditor{
        width : 90%;
        height: 90%;;
    }

    #boardfooter {
        display : flex;
        justify-content: space-between;
        align-items: center;
        padding : 0 3vw 0 3vw;
        width : 90%;
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
        font-size : 1vw;
        font-weight: bold;
    }
    button {
        background-color: #499DC6;
        color : white;
        font-size : 1vw;
        width : 10%;
        border-radius: 0.8vh;
    }

    option {
        width : 100%;
    }
</style>