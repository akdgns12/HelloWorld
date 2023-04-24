<template>
    <div id = "guestBookWrapper">
        <div id = "guestBook">
            <GuestBookCreateComp/>
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
                    <img src="@/assets/minimi_temp/minime_1.png" alt="">
                    <div>
                        <p>
                            <span>비밀이야</span>
                            <span>(이 글은 홈 주인과 작성자만 볼 수 있어요)</span>
                        </p>
                        <span class="content">김싸피님 안녕하세요 일촌일촌!</span>
                        <p>하이하이</p>
                        <p>하이하이</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import GuestBookCreateComp from '@/components/GuestBookComp/GuestBookCreateComp.vue';

export default {
components : {GuestBookCreateComp},
};
</script>

<style scoped>
    #guestBookWrapper {
        height: 72vh;
        width : 60vw;
        border-style : solid;
        border-width : 0.2vh;
        border-radius : 2vh;
        border-color: black;
        background-color: white;
        padding : 2vh;
        margin-left : 2vh;
        display : flex;
        justify-content: center;
        align-items: center;
    }

    #guestBook {
        height : 90%;
        width : 90%;
    }
    #guestBookOne {
        margin-top:3vh;
    }
    #guestBookHeader {
        display : flex;
        justify-content: space-between;
        align-items: center;
        padding : 0 2vw 0 2vw;
        background-color: #F0F0F0;
        height: 4vh;
        border-top : solid 1px;
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
    #guestBookMain{
        margin : 2vh 2vw 2vh 2vw;
        display : flex;
        align-items: center;
    }
</style>