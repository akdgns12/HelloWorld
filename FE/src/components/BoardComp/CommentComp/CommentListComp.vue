<template>
    <div id = "commentList">
        <div>
            <span id="commentAuthor">이싸피</span>
            <span> : </span>
            <span id="commentContent">오 많은 도움 되었습니다! 혹시 git branch 전략에 대해서 물어보고 싶은게 있는데 여쭤봐도 괜찮을까요?</span>
        </div>
        <div>
            <span id="commentAuthor">김싸피</span>
            <span> : </span>
            <span id="commentContent">언제든지 질문 주세요!</span>
            <img src="@/assets/icon/pencil.png" alt="modifyComment">
            <img src="@/assets/icon/clear.png" alt="deleteComment">
        </div>
        <div>
            <span id="commentAuthor">최싸피</span>
            <span> : </span>
            <span id="commentContent">좋아요 스티커 누르고 갑니다!</span>
        </div>
    </div>
</template>

<script>
</script>

<style scoped>
    #commentList {
        width : 94%;
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
        width : 0.8rem;
        height: 0.8rem;
        padding : 0 0.5% 0 1%;
        margin-top : 1%;
        opacity: 0.7;
    }
</style>