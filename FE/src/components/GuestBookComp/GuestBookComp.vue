<template>
    <div id = "Wrapper">
        <UserTitleComp />
        <div id = guestBookWrapper>
            <div id = "guestBook">
                <GuestBookCreateComp/>
                <div id = "guestBookList" v-for="guestBook in guestBooks" :key="guestBook.guestbookSeq">
                    <div id="guestBookOne">
                        <div :class="{'guestBookHeader_secret' : guestBook.isSecret , 'guestBookHeader' : guestBook.isSecret === false}">
                            <p class="GBWrite">
                                <span class="GBWriter">{{ guestBook?.guestBookNickname  }}</span>
                                <img src="@/assets/icon/laptop.png" alt="laptop">
                                <span class="GBCreatedDate">{{ formatDate(guestBook.createdTime) }}</span>
                            </p>
                            <p class="GBEditor">
                                <span class="secret" style="font-weight: bold; cursor: pointer;">{{ guestBook.isSecret ? "비밀로 하기" : "공개로 하기" }}</span>
                                <span style="padding: 0 0.5vw 0 0.5vw;" class="secret">|</span>
                                <span class="modify" style="font-weight: bold; cursor: pointer;">수정</span>
                                <span style="padding: 0 0.5vw 0 0.5vw;" class="modify">|</span>
                                <span class="delete" style="font-weight: bold; cursor: pointer;">삭제</span>
                            </p>
                        </div>
                        <div id="guestBookMain">
                            <img src="@/assets/minimi_temp/minime_1.png" alt="" class="guestMinime">
                            <div class="guestBookContent">
                                <p class="isSecret" v-if="guestBook.isSecret">
                                    <img src="@/assets/icon/lock.png" alt="" class="lock_icon">
                                    <span style="color : #AC6B19; padding : 0 0.3vw 0 0.3vw;">비밀이야</span>
                                    <span style="color : #D7AA71">(이 글은 홈 주인과 작성자만 볼 수 있어요)</span>
                                </p>
                                <span class="content">{{ guestBook.content }}</span>
                            </div>
                        </div>
                        <div :class="{'guestBookCommentList_secret' : guestBook.isSecret , 'guestBookCommentList' : guestBook.isSecret === false}" >
                            <div id="guestBookCommentWrapper">
                                <div v-for="comment in guestBook.guestbook_comment" :key="comment" class="commentOne">
                                    {{ comment }}
                                </div>
                            </div>
                            <div id = "guestBookComment"> 
                                <input type="text" class="comment">
                                <button class="commentCreate">확인</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import GuestBookCreateComp from '@/components/GuestBookComp/GuestBookCreateComp.vue';
import UserTitleComp from "../BasicComp/UserTitleComp.vue";

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

const guestBooks = [
    {guestbookSeq : 1,createdTime : "2023-04-26T14:25:43.511+09:00",content : "안녕하세요 반가워요", guestBookUserSeq : 2, guestBookNickname : "지수", user : 1, avater : "", 
    guestbook_comment : ["안녕하세요", "안녕하세요"], isSecret : false},
    {guestbookSeq : 2,createdTime : "2023-04-26T14:25:43.511+09:00",content : "방명록 남겼습니다", guestBookUserSeq : 3, guestBookNickname : "제니", user : 1, avater : "", 
    guestbook_comment : ["아오"], isSecret : true},
    {guestbookSeq : 3,createdTime : "2023-04-26T14:25:43.511+09:00",content : "방명록 테스트테스트", guestBookUserSeq : 4, guestBookNickname : "로제", user : 1, avater : "", 
    guestbook_comment : ["졸려"], isSecret : true},
    {guestbookSeq : 4,createdTime : "2023-04-26T14:25:43.511+09:00",content : "방명록", guestBookUserSeq : 5, guestBookNickname : "리사", user : 1, avater : "", 
    guestbook_comment : ["집갈래"], isSecret : true},
    {guestbookSeq : 5,createdTime : "2023-04-26T14:25:43.511+09:00",content : "이것도 테스트테스트", guestBookUserSeq : 2, guestBookNickname : "지수", user : 1, avater : "", 
    guestbook_comment : ["몰라"], isSecret : false},
    {guestbookSeq : 6,createdTime : "2023-04-26T14:25:43.511+09:00",content : "testtest", guestBookUserSeq : 3, guestBookNickname : "제니", user : 1, avater : "", 
    guestbook_comment : ["과일"], isSecret : true},
    {guestbookSeq : 7,createdTime : "2023-04-26T14:25:43.511+09:00",content : "flflflflffl", guestBookUserSeq : 4, guestBookNickname : "로제", user : 1, avater : "", 
    guestbook_comment : ["ㅇㅇㅇㅇ"], isSecret : false},
    {guestbookSeq : 8,createdTime : "2023-04-26T14:25:43.511+09:00",content : "바나나바나나", guestBookUserSeq : 5, guestBookNickname : "리사", user : 1, avater : "",
     guestbook_comment : ["빨간색"], isSecret : true},
    {guestbookSeq : 9,createdTime : "2023-04-26T14:25:43.511+09:00",content : "딸기딸기", guestBookUserSeq : 2, guestBookNickname : "지수", user : 1, avater : "", 
    guestbook_comment : ["노란색"], isSecret : false},
    {guestbookSeq : 10,createdTime : "2023-04-26T14:25:43.511+09:00",content : "키위키위", guestBookUserSeq : 3, guestBookNickname : "제니", user : 1, avater : "", 
    guestbook_comment : ["초록색"], isSecret : true},
    {guestbookSeq : 11,createdTime : "2023-04-26T14:25:43.511+09:00",content : "레몬레몬", guestBookUserSeq : 4, guestBookNickname : "로제", user : 1, avater : "", 
    guestbook_comment : ["파란색"], isSecret : false},
];

</script>

<style scoped>
    /* #Wrapper {
        padding-top : 40px;
    } */
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
    .isSecret {
        font-size: 1.5vh;
    }
    .lock_icon {
        width : 1vw;
    }
    .content {
        margin-bottom : 2vh;
        font-size : 0.8rem;
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
    }
    .commentCreate{
        background-color: white;
        border-radius : 5px;
        font-weight: bold;
    }
</style>