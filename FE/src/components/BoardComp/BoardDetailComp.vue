<template>
    <div id="boardDetail">
        <UserTitleComp />
        <div id="Wrapper">
            <div id = "boardWrapper">
                <div id = "boardTitle">Git 이슈 정리</div>
                <div id = "boardInfo">
                    <p id="author">김싸피</p>
                    <p id="createdDate">2023.04.19 09:29</p>
                </div>
                <div id="boardContent">
                    <img src="../../assets/boardboard.png" alt="">
                </div>
                <div class="boardFooter">
                    <div class="checkSticker">
                        <p class="sticker">스티커</p>
                        <div class="sub_nav">
                            <p>좋아요</p>
                            <p style="padding : 0 0.3rem;">|</p>
                            <p>도움되요</p>
                            <p style="padding : 0 0.3rem;">|</p>
                            <p>이해가 쏙쏙되요</p>
                        </div>
                    </div>
                    <div id="boardUD">
                        <p id="boardUpdate">수정</p>
                        <p>|</p>
                        <p id="boardDelete">삭제</p>
                    </div>
                </div>
                <div id = "comment">
                    <CommentListComp />
                    <CommentCreateComp/>
                </div>
            </div>
        </div>
    </div>
</template>


<script>
import CommentListComp from '@/components/BoardComp/CommentComp/CommentListComp.vue'
import CommentCreateComp from '@/components/BoardComp/CommentComp/CommentCreateComp.vue'
import UserTitleComp from "../BasicComp/UserTitleComp.vue";

export default {
    components : {CommentListComp, CommentCreateComp, UserTitleComp},
};
</script>

<style scoped>
    /* #boardDetail {
        padding-top : 40px;
    } */
    #Wrapper {
        height: 75vh;
        width : 62vw;
        border: 1px solid #6A6A6A;
        border-radius : 15px;
        background-color: white;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #boardWrapper {
        height: 85%;
        width : 87%;
        overflow : scroll;
        overflow-x: hidden;
        padding : 0 2% 0 2%;
    }
    #boardTitle {
        height: 1rem;
        background-color: #F2F2F2;
        display : flex;
        justify-content: center;
        align-items: center;
        font-size : 1.2rem;
        font-weight: bold;
        padding : 1%;
        border-style: solid;
        border-top-color: #E5E5E5;
        border-bottom-color: #E5E5E5;
        border-left: 0;
        border-right: 0;
    }
    #boardInfo {
        display : flex;
        height: 0.9rem;
        justify-content: space-between;
        align-items: center;
        padding : 1% 3% 1% 3%;
        background-color: #FAFAFA;
    }
    #author {
        color : #82ACC1;
        font-size : 0.9rem;
    }
    #createdDate {
        font-size : 0.8rem;
    }
    .boardFooter{
        display : flex;
        flex-direction: row;
        justify-content: space-between;
        border-top : dashed black 1px;
        border-bottom : solid black 1px;
        margin : 2% 0 2% 0;
        padding : 0 2rem;
        font-size : 0.8rem;
    }
    .sticker {
        color : #D7AA71;
        font-weight: bold;
    }
    .checkSticker {
        display: flex;
        flex-direction : row;
        align-items: center;
    }

    .sub_nav {
        display: flex;
        flex-direction: row;
        margin-left : 1rem;
        visibility: hidden;
    }
    .sticker:hover > .sub_nav {
        visibility: visible;
        transition: visibility 0s, opacity 0.5s ease;
    }

    #boardUD {
        display : flex;
        flex-direction: row;
        width : 11%;
        justify-content: space-between;
    }
    #boardUpdate, #boardDelete {
        color:#D7AA71;
        font-weight: bold;
    }

    #comment {
        background-color: #F0F0F0;
        display: flex;
        flex-direction: column;
        align-items: center;
        text-align :justify;
        padding : 1rem 0 0.5rem 0;
    }
</style>