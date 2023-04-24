<template>
    <div id="boardDetail">
        <div id = "boardWrapper">
            <div id = "boardTitle">Git 이슈 정리</div>
            <div id = "boardInfo">
                <p id="author">김싸피</p>
                <p id="createdDate">2023.04.19 09:29</p>
            </div>
            <div id="boardContent">
                <img src="../../assets/boardboard.png" alt="">
            </div>
            <div id="boardFooter">
                <p id="sticker">스티커</p>
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
</template>


<script>
import CommentListComp from '@/components/BoardComp/CommentComp/CommentListComp.vue'
import CommentCreateComp from '@/components/BoardComp/CommentComp/CommentCreateComp.vue'
export default {
    components : {CommentListComp, CommentCreateComp},
};
</script>

<style scoped>
    #boardDetail {
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
    #boardWrapper {
        height: 90%;
        width : 90%;
        overflow : scroll;
        padding : 0 2% 0 2%;
    }
    #boardTitle {
        height: 5%;
        background-color: #F2F2F2;
        display : flex;
        justify-content: center;
        align-items: center;
        font-size : 130%;
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
        height: 5%;
        justify-content: space-between;
        align-items: center;
        padding : 1% 3% 1% 3%;
        background-color: #FAFAFA;
    }
    #author {
        color : #82ACC1;
        font-size : 120%;
    }
    #createdDate {
        font-size : 110%;
    }
    #boardFooter{
        display : flex;
        flex-direction: row;
        justify-content: space-between;
        border-top : dashed black 1px;
        border-bottom : solid black 1px;
        margin : 2% 0 2% 0;
        padding : 0 3% 0 3%;
        font-size : 90%;
    }

    #sticker {
        color : #D7AA71;
        font-weight: bold;
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
        padding : 1% 0 1% 0;
    }
</style>