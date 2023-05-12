<template>
    <div id = "boardmain">
        <UserTitleComp />
        <div class="boardWrapper">
            <div id = "categoryinfo">
                <p id = "folder">[{{ category == 'all' ? "전체보기" : categoryName[category] }}]</p>
                <p style="font-size:0.9rem"> 폴더입니다</p>
                <p id = "cnt">({{ visibleBoards.length }})</p>
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
                    <tbody >
                        <tr v-for="board in visibleBoards" :key="board.boardSeq" style="cursor: pointer;">
                            <td id = "boardNum">{{ board.boardSeq }}</td>
                            <td id = "boardTitle" @click="goDetail()">{{ board.title }}</td>
                            <td id = "boardWriter">{{ board.nickname }}</td>
                            <td id = "boardDate">{{ board.createdTime.slice(0,10) }}</td>
                            <td id = "boardCnt">{{ board.cnt }}</td>
                        </tr>
                    </tbody>
                </table>
                <div id = "writeboard">
                    <button @click="WriteBoard()">글쓰기</button>
                </div>
                <div id = "searchboard">
                    <p style="font-size:0.9rem;">검색</p>
                    <input type="search">
                    <button @click="searchBoard">확인</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useRouter} from "vue-router";
import { defineProps, reactive, computed } from 'vue';
import UserTitleComp from "../BasicComp/UserTitleComp.vue";

const categoryName = ["CS", "Algorithm", "Project", "Language", "Etc"];
const createUser = `${localStorage.getItem("user-seq")}`;

const router = useRouter();
const WriteBoard = () => {
    router.push({
        path: `/board/${createUser}/create`,
    });
}

const goDetail = () => {
    router.push({
        path:"/board/detail",
    })
}

const props = defineProps({
    category : String,
});
const state = reactive ({
    boards: [
        // {boardSeq : 20, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '0', title : '싸이월드 구현하기', cnt : 5},
        // {boardSeq : 19, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '1', title : '싸이월드 구현하기', cnt : 5},
        // {boardSeq : 18, userSeq : 20, nickname : '한싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '2', title : '싸이월드 구현하기', cnt : 5},
        // {boardSeq : 17, userSeq : 20, nickname : '한싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '3', title : '싸이월드 구현하기', cnt : 5},
        // {boardSeq : 16, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '4', title : '싸이월드 구현하기', cnt : 5},
        // {boardSeq : 15, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '0', title : '싸이월드 구현하기', cnt : 5},
        // {boardSeq : 14, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '1', title : '싸이월드 구현하기', cnt : 5},
        // {boardSeq : 13, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '2', title : '싸이월드 구현하기', cnt : 5},
        // {boardSeq : 12, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '3', title : '싸이월드 구현하기', cnt : 5},
        // {boardSeq : 11, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '4', title : '싸이월드 구현하기', cnt : 5},
        {boardSeq : 10, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '0', title : '싸이월드 구현하기', cnt : 5},
        {boardSeq : 9, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '1', title : '싸이월드 구현하기', cnt : 5},
        {boardSeq : 8, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '2', title : '싸이월드 구현하기', cnt : 5},
        {boardSeq : 7, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '3', title : '싸이월드 구현하기', cnt : 5},
        {boardSeq : 6, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '4', title : '싸이월드 구현하기', cnt : 5},
        {boardSeq : 5, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '0', title : '싸이월드 구현하기', cnt : 5},
        {boardSeq : 4, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '1', title : '싸이월드 구현하기', cnt : 5},
        {boardSeq : 3, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '2', title : '싸이월드 구현하기', cnt : 5},
        {boardSeq : 2, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '3', title : '싸이월드 구현하기', cnt : 5},
        {boardSeq : 1, userSeq : 20, nickname : '김싸피', createdTime : '2023-04-26T14:25:43.511+09:00', categoryId : '4', title : '싸이월드 구현하기', cnt : 5},
    ]
});

const visibleBoards = computed(() => {

    if (props.category === 'all') {
        return state.boards;
    } else {
        return state.boards.filter(
            (board) => Number(board.categoryId) === props.category
        );
    }
});
</script>

<style scoped>

    .boardWrapper {
        height: 75vh;
        width : 62vw;
        border: 1px solid #6A6A6A;
        border-radius : 15px;
        background-color: white;
        
    }
    #folder {
        font-size : 0.9rem;
        font-weight:bold;
        margin : 0 0.2rem;
    }
    #cnt {
        font-size : 0.7rem;
        color : #D7AA71;
        margin-left : 0.3rem;
    }
    #categoryinfo {
        display: flex;
        justify-content: right;
        align-items:baseline;
        margin : 1rem 3vw 1vh 0;
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
        font-size : 0.9rem;
    }
    #boardheader {
        background-color: #F2F2F2;
        font-weight : bolder;
    }
    th {
        padding: 0.3rem 0;
    }
    td{
        border-bottom : dashed 0.05rem #6A6A6A;
        padding : 0.25rem 0;
    }

    #writeboard{
        width : 80%;
        display: flex;
        justify-content: right;
        padding : 0.5rem;
        
    }
    button {
        background-color: white;
        border-radius: 5px;
        font-size : 0.9rem;
        border-color : #6A6A6A;
        margin : 1px;
        cursor: pointer;
    }

    #searchboard {
        display: flex;
        width : 65%;
        justify-content: space-between;
        align-items: center;
        margin-bottom : 0.5rem;
    }
    input {
        width : 27rem;
        height: 1.8rem;
        background-color: #FFF9F9;
        border : 0;
    }
</style>