<template>
    <div id = "Wrapper">
        <UserTitleComp />
        <div id = guestBookWrapper>
            <div id = "guestBook">
                <GuestBookCreateComp v-if="showCreateComp" @addGuestBook="addGuestBook"/>
                <div id = "guestBookList" v-for="guestBook in guestBooks" :key=guestBook?.guestBookSeq>
                    <div id="guestBookOne" v-if="showSecretGuestBook(guestBook?.guestBookUserSeq, guestBook?.secret)">
                        <div :class="{'guestBookHeader_secret' : guestBook?.secret , 'guestBookHeader' : guestBook?.secret === false}">
                            <p class="GBWrite">
                                <span class="GBWriter" @click="goMainpage(guestBook?.guestBookUserSeq)">{{ guestBook?.guestBookUserNickname  }}</span>
                                <img src="@/assets/icon/laptop.png" alt="laptop">
                                <span class="GBCreatedDate">{{ formatDate(guestBook?.createdTime) }}</span>
                            </p>
                            <p class="GBEditor">
                                <span v-if="showEditGuestBook(guestBook?.guestBookUserSeq)" class="secret" style="font-weight: bold; cursor: pointer;" @click="isSecretGuestBook(guestBook?.guestBookSeq, guestBook?.secret, guestBook?.content)">{{ !guestBook?.secret ? "비밀로 하기" : "공개로 하기" }}</span>
                                <span v-if="showEditGuestBook(guestBook?.guestBookUserSeq)" style="padding: 0 0.5vw 0 0.5vw;" class="secret">|</span>
                                <span v-if="guestBook?.guestBookUserSeq == userSeq" class="modify" style="font-weight: bold; cursor: pointer;" @click="showEditArea(guestBook?.guestBookSeq)">수정</span>
                                <span v-if="!showCreateComp" class="delete" style="font-weight: bold; cursor: pointer;" @click="deleteGuestBook(guestBook?.guestBookSeq)">삭제</span>
                            </p>
                        </div>
                        <div id="guestBookMain">
                            <img :src="guestBook?.guestAvatar" alt="" class="guestMinime">
                            <div class="guestBookContent">
                                <p class="secret" v-if="guestBook.secret">
                                    <img src="@/assets/icon/lock.png" alt="" class="lock_icon">
                                    <span style="color : #AC6B19; padding : 0 0.3vw 0 0.3vw;">비밀이야</span>
                                    <span style="color : #D7AA71">(이 글은 홈 주인과 작성자만 볼 수 있어요)</span>
                                </p>
                                <span v-if="!edit[guestBook?.guestBookSeq]" class="content">{{ guestBook.content }}</span>
                                <div v-else class="updateContent">
                                    <textarea v-model="updateContent[guestBook?.guestBookSeq]" class="updateText"></textarea>
                                    <button class="updateB" @click="updateGuestBook(updateContent[guestBook?.guestBookSeq],guestBook?.guestBookSeq, guestBook?.secret)">저장</button>
                                </div>
                            </div>
                        </div>
                        <div :class="{'guestBookCommentList_secret' : guestBook?.secret , 'guestBookCommentList' : guestBook?.secret === false}" >
                            <div id="guestBookCommentWrapper" v-if="guestBook?.commentDto !== null">
                                <div class="commentOne">
                                    <p style="color : #4689aa; font-weight : bold;">{{ guestBook?.commentDto.nickname }}</p>
                                    <p style="padding : 0 1rem;">{{ guestBook?.commentDto.content }}</p>
                                    <button v-if="guestBook?.commentDto.userSeq === userSeq" class="commentDelete" @click="removeGuestBookComment(guestBook?.guestBookSeq,guestBook?.commentDto.guestBookCommentSeq)">삭제</button>
                                </div>
                            </div>
                            <div id = "guestBookComment"> 
                                <input type="text" class="comment" v-model="newComment[guestBook?.guestBookSeq]">
                                <button class="commentCreate" @click="addGuestBookComment(newComment[guestBook?.guestBookSeq], guestBook?.guestBookSeq)">확인</button>
                            </div>
                        </div>
                    </div>
                </div>
                <InfiniteLoading
                    @infinite="loadMore"
                    target="#guestBookList"
                >
                    <template #no-more>
                        <div class="infinite-end">
                            방명록을 모두 불러왔습니다!
                        </div>
                    </template>
                </InfiniteLoading>
            <div v-if="guestBooks.length === 0" class="nonegb">
                <img src="@/assets/noneGB.png" alt="" class="noneImg">
                <div class="noneText">방명록○l 없습LI⊂ト!</div>                
            </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import GuestBookCreateComp from '@/components/GuestBookComp/GuestBookCreateComp.vue';
import UserTitleComp from "../BasicComp/UserTitleComp.vue";
import { ref, computed, watch, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';
import InfiniteLoading from 'v3-infinite-loading';
import { router } from '@/router';

const headers = {
    "Content-Type" : "application/json;charset=utf-8",
    Authorization: `Bearer ${localStorage.getItem("access-token")}`,
  };
const baseURL = "https://k8a308.p.ssafy.io/api";
const route = useRoute();

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

const minihomeMaster = computed(() => route.params.userSeq);
const userSeq = ref(`${localStorage.getItem("user-seq")}`);
const start = ref(0);
const size = ref(10);
const updateContent = ref({});
const newComment = ref({});
const guestBooks = ref([]);

const busy = ref(false);

const showCreateComp = computed(() => {
    return minihomeMaster.value != userSeq.value;
})

const showSecretGuestBook = (guestBookUserSeq, secret) => {
    if (secret == 0) return 1;
    else {
        if (userSeq.value == guestBookUserSeq || minihomeMaster.value == userSeq.value) return 1;
        else return 0;
    }
}

const showEditGuestBook = (guestBookUserSeq) => {
    if (userSeq.value == guestBookUserSeq || minihomeMaster.value == userSeq.value) return 1;
    else return 0;
}

const edit = ref({});
const showEditArea = computed(() => (guestBookSeq) => edit.value[guestBookSeq] = guestBookSeq);

watch(showEditArea, (newValue) => {
  console.log(newValue);
});


const getGuestBooks = () => {
    busy.value = true;
    start.value = 0;
    guestBooks.value = [];
    axios
        .get(`${baseURL}/guestbook?userSeq=${minihomeMaster.value}&start=${start.value}&size=${size.value}`, {headers})
        .then(response => {
            guestBooks.value =  guestBooks.value.concat(response.data);
            start.value += 1;
            if (response.data.length < 10) busy.value = true;
            else busy.value = false;
        })
        .catch(error => {
            console.error(error);
        })
    
};

const loadMore = () => {
    if (busy.value) return;
    busy.value = true;
    axios
    .get(`${baseURL}/guestbook?userSeq=${minihomeMaster.value}&start=${start.value}&size=${size.value}`, {headers})
    .then(response => {
        if (response.data.length > 0 ) {
            guestBooks.value = guestBooks.value.concat(response.data);  // 기존 데이터에 새로운 데이터 추가
                 // 데이터 로딩 상태 해제
                start.value += 1;
                if (response.data.length < 10) busy.value = true;
                else busy.value = false;
          }  // 다음 데이터를 가져오기 위해 start 값 증가
    })
    .catch(error => {
      console.error(error);
      busy.value = false;  // 데이터 로딩 상태 해제
    });
};

const addGuestBook = () => {
    start.value = 0;
    busy.value = true;
    guestBooks.value= [];
    axios
        .get(`${baseURL}/guestbook?userSeq=${minihomeMaster.value}&start=${start.value}&size=${size.value}`,{headers})
        .then(response => {
                guestBooks.value = guestBooks.value.concat(response.data);  // 기존 데이터에 새로운 데이터 추가
                 // 데이터 로딩 상태 해제
                start.value += 1;
                if (response.data.length < 10) busy.value = true;
                else busy.value = false;
            })
            .catch(error => {
                console.error(error);
                alert("다시 렌더링할 때, 에러 발생");
            })
}

const isSecretGuestBook = (guestBookSeq, secret, content) => {
    const updateGuestBook = guestBooks.value.map(guestBook => {
        if (guestBook.guestBookSeq === guestBookSeq) {
            guestBook.secret = !secret;
        }
        return guestBook;
    })
    const requestDto = {
        content : content,
        isSecret : Number(!secret),
        guestBookSeq : guestBookSeq
    };
    console.log(updateGuestBook);
    axios
    .patch( `${baseURL}/guestbook`, requestDto, {headers})
    .then((response) => {
        console.log(response.data);
    })
    .catch((error) => {
        console.log(error);
        alert("수정할 수 없습니다!");
    })
}

const updateGuestBook = (updateContentValue, guestBookSeq, secret) => {
    const updateGuestBook = guestBooks.value.map(guestBook => {
        if (guestBook.guestBookSeq === guestBookSeq) {
            guestBook.content = updateContentValue;
        }
        return guestBook;
    })
    console.log(updateGuestBook);
    const requestDto = {
        content : updateContentValue,
        isSecret : Number(secret),
        guestBookSeq : guestBookSeq
    };
    axios
        .patch(`${baseURL}/guestbook`, requestDto, {headers})
        .then((reponse) => {
            console.log(reponse);
            edit.value[guestBookSeq] = !edit.value[guestBookSeq];
        })
        .catch((error) => {
        console.log(error);
        alert("수정할 수 없습니다!");
    })
}

onMounted(() => {
    busy.value = false;
    start.value = 0;
    guestBooks.value = [];
    getGuestBooks();
});


const deleteGuestBook = (guestBookSeq) => {
    axios
        .delete(`${baseURL}/guestbook/${guestBookSeq}`,{headers})
        .then(response => {
            console.log(response.data);
            busy.value = false;
            start.value = 0;
            guestBooks.value = [];
            getGuestBooks();
            alert("방명록이 삭제되었습니다!");
        })
        .catch(error => {
            console.error(error);
            alert("삭제할 수 없습니다!");
        });
}

const addGuestBookComment = (newCommentValue, guestBookSeq) => {
    const requestDto = {
        userSeq : userSeq.value,
        content : newCommentValue,
        guestbookCommentSeq : 0
    };
    newComment.value[guestBookSeq] = '';
    axios
        .post(`${baseURL}/guestbook/comment/${guestBookSeq}`, requestDto, {headers})
        .then(response => {
            console.log(response.data);
            axios.get(`${baseURL}/guestbook?userSeq=${minihomeMaster.value}&start=${start.value}&size=${size.value}`,{headers})
            .then(response => {
                guestBooks.value = response.data;
            })
            .catch(error => {
                console.error(error);
                alert("댓글을 불러올 수 없습니다!");
            })
        })
        .catch(error => {
            console.error(error);
            alert("댓글을 추가할 수 없습니다!");
        })
}

const removeGuestBookComment = (guestBookSeq) => {
    axios
        .delete(`${baseURL}/guestbook/comment/${guestBookSeq}`, {headers})
        .then(response => {
            console.log(response.data);
            getGuestBooks();
            alert("댓글이 삭제되었습니다!");
        })
        .catch(error => {
            console.error(error);
            alert("댓글을 삭제할 수 없습니다!");
        })
}

const goMainpage = (guestBookUserSeq) => {
    router.push(`/mainpage/${guestBookUserSeq}`);
}

</script>

<style scoped>

    #guestBookWrapper {
        height: 75vh;
        width : 62vw;
        border: 1px solid #6A6A6A;
        border-radius : 15px;
        background-color: white;
        display : flex;
        justify-content: center;
        align-items: center;
    }
    #guestBook {
        height : 65vh;
        width : 90vw;
        padding : 0 2vw 0 2vw;
        margin : 0 1vw 0 1vw;
        overflow-y : scroll;
    }
    /* 방명록 하나 CSS */
    #guestBookOne {
        margin-top:2rem;
    }
    /* 방명록 헤더 정보 */
    .guestBookHeader {
        display : flex;
        justify-content: space-between;
        align-items: center;
        padding : 0 2vw;
        background-color: #F0F0F0;
        height: 4vh;
        border-top : solid 1px;
        font-size : 1vw;
    }
    .guestBookHeader_secret {
        display : flex;
        justify-content: space-between;
        align-items: center;
        padding : 0 2vw;
        height: 4vh;
        font-size : 1vw;
        background-color : #FFEFD3; 
        border-top : solid 1px #E29714;
    }
    .GBWrite {
        display : flex;
        align-items:center;
    }
    .GBWriter {
        color : #4689aa;
        font-weight : bold;
        cursor: pointer;
    }
    .GBCreatedDate{
        font-size:1vh;
    }
    .GBWrite img {
        width : 2vw;
        height: 2vw;
        margin : 0 0.5vw 0 0.5vw;
    }
    .GBEditor{
        display : flex;
        align-items: center;
        font-size : 1.5vh;
    }
    
    /* 방명록 관련 -  미니미 이미지 & 내용 */
    #guestBookMain{
        margin : 2vh 0 2vh 0;
        display : flex;
        align-items: center;
        justify-content: space-around;
    }
    .guestMinime {
        width : 6rem;
        height: 6rem;
    }
    .guestBookContent {
        width : 40vw;
        display : flex;
        flex-direction: column;
        text-align: left;
    }
    .secret {
        font-size: 1.5vh;
    }
    .lock_icon {
        width : 1vw;
    }
    .content {
        margin-bottom : 2vh;
        font-size : 0.8rem;
    }

    .updateContent {
        display :flex;
        align-items:end;
    }
    .updateText {
        width : 80%;
        height: 5rem;
        border : 2px solid #82ACC1;
        resize : none;
    }
    .updateB {
        cursor: pointer;
        font-size: 10px;
        background-color: #82acc1;
        color: #fff;
        width: 60px;
        padding: 2px 4px;
        margin-left: 15px;
        border: none;
        border-radius: 15px;
    }
    /* 방명록 댓글 CSS */
    .guestBookCommentList {
        display: flex;
        flex-direction: column;
        background-color: #F0F0F0;
        margin : 0 0.5rem;
    }

    .guestBookCommentList_secret {
        display : flex;
        flex-direction: column;
        background-color: #FFEFD3;
        margin: 0 0.5rem;
    }

    #guestBookCommentWrapper {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        padding-top : 1rem;
        margin : 0 1vw;
        padding-left : 3vw;
        font-size : 0.8rem;
    }
    #guestBookComment {
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        padding : 1rem;
        margin : 0 1rem;
    }
    .comment {
        width : 43vw;
        height: 3vh;
        font-size : 1vw;
        border : solid;
        border-color : #6A6A6A;
        border-width: 1px;
    }
    .commentOne {
        padding : 0.1rem 0;
        display: flex;
        flex-direction: row;
        align-items: center;
        height: 1rem;
        padding-bottom : 0.5rem;
        font-size : 0.7rem;
    }
    .commentDelete {
        background-color: white;
        border-radius : 5px;
        border : 1px solid;
        font-size : 0.65rem;
    }
    .commentCreate{
        background-color: white;
        border-radius : 5px;
        border : 1px solid;
        font-size : 0.6rem;
    }
    .backButton, .nextButton {
        margin : 1rem;
        background-color: white;
        border-radius: 5px;
    }

    .disabled {
        opacity: 0.5;
        margin : 1rem;
        background-color: white;
        border-radius: 5px;
        cursor: not-allowed;
    }

    .nonegb {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }
    .noneText {
        font-size : 2rem;
        font-weight: bold;
    }
    .noneImg {
        width : 8rem;
        padding-top : 1rem;
        margin : 1rem 0;
    }
</style>