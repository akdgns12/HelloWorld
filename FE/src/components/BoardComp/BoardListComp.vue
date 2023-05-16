<template>
    <div id = "boardmain">
        <UserTitleComp />
        <div class="boardWrapper">
            <div id = "categoryinfo">
                <p id = "folder">[{{ category == 'all' ? "전체보기" : categoryName[category] }}]</p>
                <p style="font-size:0.9rem"> 폴더입니다</p>
                <p id = "cnt">({{ pageCnt }})</p>
            </div>
            <div id="boardlist">
                <table>
                    <thead>
                        <tr id = "boardheader">
                            <th id = "boardNum">게시글ID</th>
                            <th id = "boardTitle">제목</th>
                            <th id = "boardWriter">작성자</th>
                            <th id = "boardDate">작성일</th>
                            <th id = "boardCnt">조회수</th>
                        </tr>
                    </thead>
                    <tbody >
                        <tr v-for="board in boards" :key="board.boardSeq" style="cursor: pointer;">
                            <td id = "boardNum">{{ board.boardSeq }}</td>
                            <td id = "boardTitle" @click="goDetail(board.boardSeq)">{{ board.title.length > 12? board.title.slice(0,12) + "..." : board.title }}</td>
                            <td id = "boardWriter">{{ board.writer }}</td>
                            <td id = "boardDate">{{ board.createTime.slice(0,10) }}</td>
                            <td id = "boardCnt">{{ board.viewCnt }}</td>
                        </tr>
                    </tbody>
                </table>
                <div id = "writeboard" v-if="minihomeMaster === userSeq">
                    <button @click="WriteBoard()">글쓰기</button>
                </div>
            </div>
            <ul class="pagination">
              <li class="page-item" :class="{'disabled' : isBtnFirst}"><img src="@/assets/boardIcon/arrow_first.png" alt="pageFirst" class="page-link-img" href="#" @click.prevent="pageArrow('first')"></li>
              <li class="page-item" :class="{'disabled' : isBtnPrev}"><img src="@/assets/boardIcon/arrow_prev.png" alt="pagePrev" class="page-link-img" href="#" @click.prevent="pageArrow('prev')"></li>
              <template v-for="(item, index) in pageList" :key="`list-${index}`">
                <li class="page-item" :class="{'active' : item == currentPage}"><a class="page-link" href="#" @click.prevent="page(item)">{{item+1}}</a></li>
              </template>
              <li class="page-item" :class="{'disabled' : isBtnNext}"><img src="@/assets/boardIcon/arrow_next.png" alt="pageNext" class="page-link-img" href="#" @click.prevent="pageArrow('next')"></li>
              <li class="page-item" :class="{'disabled' : isBtnLast}"><img src="@/assets/boardIcon/arrow_last.png" alt="pageLast" class="page-link-img" href="#" @click.prevent="pageArrow('last')"></li>
            </ul>
        </div>
    </div>
</template>

<script setup>
import { useRoute } from "vue-router";
//import { defineProps } from 'vue';
import { ref, defineProps, computed, onBeforeMount, watch } from 'vue';
import UserTitleComp from "../BasicComp/UserTitleComp.vue";
import { router } from '@/router';
import axios from "axios";

const route = useRoute();
const categoryName = ["CS", "Algorithm", "Project", "Language", "Etc"];
const createUser = `${localStorage.getItem("user-seq")}`;
const minihomeMaster = computed(() => route.params.userSeq);
const userSeq = localStorage.getItem('user-seq');
const baseURL = "https://k8a308.p.ssafy.io/api";
const headers = {
    "Content-Type" : "application/json;charset=utf-8",
    Authorization: `Bearer ${localStorage.getItem("access-token")}`,
  };

const WriteBoard = () => {
    router.push({
        path: `/board/${createUser}/create`,
    });
}

const goDetail = (boardSeq) => {
    router.push(`/board/${minihomeMaster.value}/${boardSeq}`)
}

const props = defineProps({
    category : String,
});

console.log(props);

const boards = ref([]);

let currentPage = ref(0);
const pageCnt = ref(0);
let totalPage = ref();
let pageNum = 10;
let isBtnFirst = ref(true);
let isBtnPrev = ref(true);
let isBtnNext = ref(true);
let isBtnLast = ref(true);
const pageList = ref([]);

const page = (page) => {
    currentPage.value = page;
    getBoardList();
}

const pageArrow = (type) => {
    switch (type) {
        case 'first' : 
            currentPage.value = 0;
            break;
        case 'prev' :
            if(currentPage.value > 0) {
                currentPage.value--;
            }
            break;
        case 'next' :
            if (currentPage.value < totalPage.value -1) {
                currentPage.value++;
            }
            break;
        case 'last' : 
            currentPage.value = totalPage.value - 1;
            break;
    }
    getBoardList();
}

const currentPageListStart = () =>{
  return Math.floor(currentPage.value / pageNum) * pageNum
}

const updatePageButtons = () => {
    isBtnFirst.value = currentPage.value === 0;
    isBtnPrev.value = currentPage.value > 0;
    isBtnNext.value = currentPage.value < totalPage.value - 1;
    isBtnLast.value = currentPage.value === totalPage.value - 1;
};

const updatePageList = () => {
    pageList.value = [];
    let pageListStart = currentPageListStart();
    for (let i = 0; i < pageNum && pageListStart < totalPage.value; i++) {
        pageList.value.push(pageListStart);
        pageListStart++;
    }
}
updatePageButtons();
updatePageList();

const getBoardList = () => {
    if (props.category === 'all') {
        axios.get(`${baseURL}/board/board-list-by-user`, {headers,
        params : {
            userSeq : minihomeMaster.value,
            start : currentPage.value,
            size: 10
        }})
        .then (response => {
            console.log(response);
            pageCnt.value = response.data.boardCount;
            totalPage.value = pageCnt.value / 10
            boards.value = response.data.boardList;

            updatePageButtons();
            updatePageList();
        })
        .catch(error => {
        console.error(error);
        alert("게시글을 불러오지 못했습니다");
    })
    } else {
        const categoryId = props.category;
        axios.get(`${baseURL}/board/board-list-by-user`, {headers,
            params : {
                userSeq : minihomeMaster.value,
                start : currentPage.value,
                size : 10,
                categorySeq : categoryId
            }
        })
        .then (response => {
            console.log(response);
            pageCnt.value = response.data.boardCount;
            totalPage.value = pageCnt.value / 10;
            boards.value = response.data.boardList;
        })
        .catch(error => {
        console.error(error);
        alert("게시글을 불러오지 못했습니다");
    })
}}

onBeforeMount(() => {
    currentPage.value = 0;
    boards.value = [];
    getBoardList();
})

watch(() => props.category, () => {
    currentPage.value = 0;
    boards.value = [];
    pageList.value = [];
    getBoardList();
})

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
    tr {
        height: 1.8rem;;
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
    #boardTitle{
        width : 18rem;
    }
    #boardWriter {
        width : 8rem;
    }
    button {
        background-color: white;
        border-radius: 5px;
        font-size : 0.9rem;
        border-color : #6A6A6A;
        margin : 1px;
        margin-top : 1.2rem;
        cursor: pointer;
    }

    .pagination {
        list-style: none;
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
    }
    .page-link-img {
        width : 0.9rem;
        padding : 0 0.5rem;
        opacity: 0.5;
        cursor: pointer;
    }
    .page-link {
        padding : 0 0.5rem;
        text-decoration: none;
        color : black;
    }

    .active {
        color: #D7AA71;
        font-weight: bold;
    }
</style>