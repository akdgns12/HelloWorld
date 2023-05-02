<template>
    <div class="article-container">
        <div class="represent-img-container">
            <img class="represent-img" src="@/assets/KakaoTalk_20230116_110321475_05.jpg" alt="대표이미지" />
        </div>
        <div class="title">
            제목입니다제목입니다제목입니다제목입니다
        </div>
        <div class="author">
            by 작성자
        </div>
        <div class="content">
            내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다
        </div>
        <hr width="92%">
        <div class="sticker-and-comment">
            <div class="heart-icon-container">
                <img class="heart-icon" src="@/assets/icon/heart.png" alt="좋아요" />
            </div>
            <div class="heart-cnt">101</div>
            <div class="comment-icon-container">
                <img class="comment-icon" src="@/assets/icon/comment.png" alt="댓글" />
            </div>
            <div class="comment-cnt">12</div>
        </div>
    </div>
</template>

<script>
export default {
}
</script>

<style scoped>
.article-container {
    width: 14vw;
    height: 45vh;
    border: 1px solid #A8A8A8;
    border-radius: 10px;
    box-shadow: rgba(0, 0, 0, 0.2) 2px 2px 3px;
    cursor: pointer;
}

.article-container:hover {
    transform: scale(1.03);
    transition: 0.8s;
}

.represent-img-container {
    border: 2px solid #D9D9D9;
    width: 90%;
    height: 60%;
    margin: 0 auto;
    margin-top: 2.5%;
}

.represent-img {
    width: 100%;
    height: 100%;
    object-fit: fill;
}

.title {
    width: 90%;
    margin: 0 auto;
    margin-top: 5%;
    text-align: start;
    font-size: 13px;
    font-weight: 700;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

.author {
    font-size: 9px;
    width: 90%;
    margin: 0 auto;
    text-align: start;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    margin-top: 1%;
}

.content {
    width: 90%;
    margin: 0 auto;
    margin-top: 5%;
    text-align: start;
    font-size: 10px;
    color: #6A6A6A;
    overflow: hidden;
    white-space: normal;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
}

.sticker-and-comment {
    width: 90%;
    margin: 0 auto;
    justify-content: end;
    display: flex;
}

.heart-icon-container {
    width: 12px;
    height: 10px;
}

.heart-icon {
    width: 100%;
    height: 100%;
    object-fit: fill;
}

.heart-cnt {
    font-size: 8px;
    margin-left: 3px;
    height: 12px;
    line-height: 19px;
    color: #6A6A6A;
}

.comment-icon-container {
    margin-left: 5%;
    width: 12px;
    height: 10px;
}

.comment-icon {
    width: 100%;
    height: 100%;
    object-fit: fill;
}

.comment-cnt {
    font-size: 8px;
    margin-left: 3px;
    height: 12px;
    line-height: 19px;
    color: #6A6A6A;
}
</style>