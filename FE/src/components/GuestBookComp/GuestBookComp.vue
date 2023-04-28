<template>
    <div id = "Wrapper">
        <UserTitleComp />
        <div id = guestBookWrapper>
            <div id = "guestBook">
                <GuestBookCreateComp/>
                <div id = "guestBookList">
                    <div id="guestBookOne">
                        <div id="guestBookHeader">
                            <p class="GBWrite">
                                <span class="GBWriter">이싸피</span>
                                <img src="@/assets/icon/laptop.png" alt="laptop">
                                <span class="GBCreatedDate">[2023.04.23 14:15]</span>
                            </p>
                            <p class="GBEditor">
                                <span class="secret" style="font-weight: bold;">비밀로 하기</span>
                                <span style="padding: 0 0.5vw 0 0.5vw;" class="secret">|</span>
                                <span class="modify" style="font-weight: bold;">수정</span>
                                <span style="padding: 0 0.5vw 0 0.5vw;" class="modify">|</span>
                                <span class="delete" style="font-weight: bold;">삭제</span>
                            </p>
                        </div>
                        <div id="guestBookMain">
                            <img src="@/assets/minimi_temp/minime_1.png" alt="" class="guestMinime">
                            <div class="guestBookContent">
                                <span class="content">김싸피님 안녕하세요 일촌일촌!저희 일촌이예요! 안녕하세요!!! 안녕하세요 안녕하세요 안녕하세요 안녕하세요 안녕하세요</span>
                            </div>
                        </div>
                        <div id = "guestBookComment">
                            <input type="text" class="comment">
                            <button class="commentCreate">확인</button>
                        </div>
                    </div>
                    <div id="guestBookOne">
                        <div id="guestBookHeader" style="background-color : #FFEFD3; border-top : solid 1px #E29714;">
                            <p class="GBWrite">
                                <span class="GBWriter">choi싸피</span>
                                <img src="@/assets/icon/laptop.png" alt="laptop">
                                <span class="GBCreatedDate">[2023.04.23 14:15]</span>
                            </p>
                            <p class="GBEditor">
                                <span class="modify" style="font-weight: bold;">수정</span>
                                <span style="padding: 0 0.5vw 0 0.5vw;" class="modify">|</span>
                                <span class="delete" style="font-weight: bold;">삭제</span>
                            </p>
                        </div>
                        <div id="guestBookMain">
                            <img src="@/assets/minimi_temp/minime_2.png" alt="" class="guestMinime">
                            <div class="guestBookContent">
                                <p class="isSecret">
                                    <img src="@/assets/icon/lock.png" alt="" class="lock_icon">
                                    <span style="color : #AC6B19; padding : 0 0.3vw 0 0.3vw;">비밀이야</span>
                                    <span style="color : #D7AA71">(이 글은 홈 주인과 작성자만 볼 수 있어요)</span>
                                </p>
                                <span class="content">
                                    김ᄊトㅍı님 생일 축㈛합LI⊂ト! ㄴr중øłl 口ざㄴr요!</span>
                            </div>
                        </div>
                        <div id = "guestBookComment" style = "background-color: #FFEFD3;">
                            <input type="text" class="comment">
                            <button class="commentCreate">확인</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import GuestBookCreateComp from '@/components/GuestBookComp/GuestBookCreateComp.vue';
import UserTitleComp from "../BasicComp/UserTitleComp.vue";

export default {
components : {GuestBookCreateComp, UserTitleComp},
};
</script>

<style scoped>
    #Wrapper {
        padding-top : 40px;
    }
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
        margin-top:3vh;
    }
    /* 방명록 헤더 정보 */
    #guestBookHeader {
        display : flex;
        justify-content: space-between;
        align-items: center;
        padding : 0 2vw 0 2vw;
        background-color: #F0F0F0;
        height: 4vh;
        border-top : solid 1px;
        font-size : 1vw;
    }
    .GBWrite {
        display : flex;
        align-items:center;
    }
    .GBWriter {
        color : #4689aa;
        font-weight : bold;
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
        width : 10vw;
        height: 10vw;
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
        font-size : 1vw;
    }

    /* 방명록 댓글 CSS */
    #guestBookComment {
        background-color: #F0F0F0;
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        padding : 2vh 1vw 2vh 1vw;
        margin : 0 1vw 0 1vw;
    }
    .comment {
        width : 43vw;
        height: 3vh;
        font-size : 1vw;
        border : solid;
        border-color : #6A6A6A;
        border-width: 1px;
    }

    .commentCreate{
        background-color: white;
        border-radius : 5px;
        font-weight: bold;
    }
</style>