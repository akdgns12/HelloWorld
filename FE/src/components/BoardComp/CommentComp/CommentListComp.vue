<template>
    <div id = "commentList" v-for="(comment,index) in comments" :key="index">
        <div class="commentline">
            <span id="commentAuthor">{{ comment.writer }}</span>
            <span style="padding : 0 0.4rem;"> : </span>
            <span id="commentContent">{{ comment.content }}</span>
            <div class="myUd">
                <img src="@/assets/icon/pencil.png" alt="modifyComment" @click="updateBoardComment(comment.CommentSeq)">
                <img src="@/assets/icon/clear.png" alt="deleteComment" @click="deleteBoardComment(comment.CommentSeq)">
            </div>
        </div>
    </div>
</template>

<script>

export default {
    props : {
        comments: {
            default : () => []
        }
    },
    methods : {
        
    }
}
</script>

<style scoped>
    #commentList {
        width : 94%;
    }
    .commentline {
        display : flex;
        flex-direction : row;
        align-items: center;
    }
    .myUd {
        display: flex;
        flex-direction : row;
        align-items: center;
        width : 2rem;
        justify-content: space-around;
    }
    #commentAuthor {
        width : auto;
        color : #82ACC1;
        font-weight: bold;
        font-size : 0.9rem;
    }
    #commentContent {
        font-size : 0.8rem;
    }
    img {
        width : 0.6rem;
        height: 0.6rem;
        padding : 0 0.5% 0 1%;
        margin-top : 1%;
        opacity: 0.7;
    }
</style>