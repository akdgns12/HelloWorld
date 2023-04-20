<template>
    <div id = "boardmain">
        <div id = "categoryinfo">
            <p id = "folder">[전체보기]</p>
            <p style="font-size:1.3vw"> 폴더입니다</p>
            <p id = "cnt">(26)</p>
        </div>
        <div id="boardlist">
            <table>
                <thead>
                    <tr id = "boardheader">
                        <th id = "boardNum">번호</th>
                        <th id = "boardTitle">제목</th>
                        <th id = "boardWriter">작성자</th>
                        <th id = "boardDate">작성일</th>
                        <th id = "boardCnt">조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td id = "boardNum">10</td>
                        <td id = "boardTitle" @click="goDetail()">Git 이슈 정리</td>
                        <td id = "boardWriter">김싸피</td>
                        <td id = "boardDate">2023.04.19</td>
                        <td id = "boardCnt">5</td>
                    </tr>
                    <tr>
                        <td id = "boardNum">9</td>
                        <td id = "boardTitle">싸이월드 구현하기 프로젝트</td>
                        <td id = "boardWriter">김싸피</td>
                        <td id = "boardDate">2023.04.19</td>
                        <td id = "boardCnt">5</td>
                    </tr>
                    <tr>
                        <td id = "boardNum">8</td>
                        <td id = "boardTitle">싸이월드 구현하기 프로젝트</td>
                        <td id = "boardWriter">김싸피</td>
                        <td id = "boardDate">2023.04.19</td>
                        <td id = "boardCnt">5</td>
                    </tr>
                    <tr>
                        <td id = "boardNum">7</td>
                        <td id = "boardTitle">싸이월드 구현하기 프로젝트</td>
                        <td id = "boardWriter">김싸피</td>
                        <td id = "boardDate">2023.04.19</td>
                        <td id = "boardCnt">5</td>
                    </tr>
                    <tr>
                        <td id = "boardNum">6</td>
                        <td id = "boardTitle">싸이월드 구현하기 프로젝트</td>
                        <td id = "boardWriter">김싸피</td>
                        <td id = "boardDate">2023.04.19</td>
                        <td id = "boardCnt">5</td>
                    </tr>
                    <tr>
                        <td id = "boardNum">5</td>
                        <td id = "boardTitle">싸이월드 구현하기 프로젝트</td>
                        <td id = "boardWriter">김싸피</td>
                        <td id = "boardDate">2023.04.19</td>
                        <td id = "boardCnt">5</td>
                    </tr>
                    <tr>
                        <td id = "boardNum">4</td>
                        <td id = "boardTitle">싸이월드 구현하기 프로젝트</td>
                        <td id = "boardWriter">김싸피</td>
                        <td id = "boardDate">2023.04.19</td>
                        <td id = "boardCnt">5</td>
                    </tr>
                    <tr>
                        <td id = "boardNum">3</td>
                        <td id = "boardTitle">싸이월드 구현하기 프로젝트</td>
                        <td id = "boardWriter">김싸피</td>
                        <td id = "boardDate">2023.04.19</td>
                        <td id = "boardCnt">5</td>
                    </tr>
                    <tr>
                        <td id = "boardNum">2</td>
                        <td id = "boardTitle">싸이월드 구현하기 프로젝트</td>
                        <td id = "boardWriter">김싸피</td>
                        <td id = "boardDate">2023.04.19</td>
                        <td id = "boardCnt">5</td>
                    </tr>
                    <tr>
                        <td id = "boardNum">1</td>
                        <td id = "boardTitle">싸이월드 구현하기 프로젝트</td>
                        <td id = "boardWriter">김싸피</td>
                        <td id = "boardDate">2023.04.19</td>
                        <td id = "boardCnt">5</td>
                    </tr>
                </tbody>
            </table>
            <div id = "writeboard">
                <button @click="WriteBoard()">글쓰기</button>
            </div>
            <div id = "searchboard">
                <p>검색</p>
                <input type="search">
                <button @click="searchBoard">확인</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useRouter } from "vue-router";
const router = useRouter();
const WriteBoard = () => {
    router.push({
        path: "/board/create",
    });
}

const goDetail = () => {
    router.push({
        path:"/board/detail",
    })
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
    #folder {
        font-size : 1.3vw;
        font-weight:bold;
        margin : 0 0.5vw 0 0.5vw;
    }
    #cnt {
        font-size : 1vw;
        color : #D7AA71;
        margin-left : 0.5vw;
    }
    #categoryinfo {
        display: flex;
        justify-content: right;
        align-items:baseline;
        margin : 1vh 3vw 1vh 0;
    }
    #boardlist {
        display:flex;
        flex-direction : column;
        align-items: center;
    }
    table{
        border-collapse : collapse;
        margin: 0 0.5vw 0 0.5vw;
        width : 90%;
        padding : 0 3vw 0 3vw;
    }
    #boardheader {
        background-color: #F2F2F2;
        font-size : 1.2vw;
        font-weight : bolder;
    }
    th {
        padding: 0.5vh 0 0.5vh 0;
    }
    td{
        border-bottom : dashed 0.1vw #6A6A6A;
        padding : 0.6vh 0 0.6vh 0;
    }

    #writeboard{
        width : 80%;
        display: flex;
        justify-content: right;
        padding : 1vw;
        
    }
    button {
        background-color: white;
        border-radius: 0.5vh;
        font-size : 1.7vh;
        border-color : #6A6A6A;
        margin : 1px;
    }

    #searchboard {
        display: flex;
        width : 65%;
        justify-content: space-between;
        align-items: center;
        margin : 1vh;
    }
    input {
        width : 30vw;
        height: 4vh;
        background-color: #FFF9F9;
        border : 0;
    }
</style>