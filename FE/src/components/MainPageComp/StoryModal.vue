<script>
export default {
    props: {
        show: Boolean,
        boardSeq: String,
        title: String,
        author: String,
        imgUrl: String,
        authorSeq: String,
    },
    methods: {
        mvArticle: function() {
            this.$router.push({name: 'board-detail', params: {
                userSeq: this.authorSeq,
                boardSeq: this.boardSeq,
            }})
        }
    }
}
</script>

<template>
    <Transition name="modal">
        <div v-if="show" class="modal-mask">
            <div class="modal-container">
                <div class="modal-header">
                    {{ author }} 님의 스토리
                </div>
                <div class="modal-body">
                    <div class="thumbnail">
                        <img :src="`${imgUrl}`" class="thumbnail-img" alt="썸네일" v-if="imgUrl!=''"/>
                        <img src="@/assets/KakaoTalk_20230116_110321475_05.jpg" class="thumbnail-img" alt="썸네일" v-if="imgUrl==''"/>
                    </div>
                    <div class="title-container">
                        <div class="msg">
                            제목
                        </div>
                        <div class="title">
                            {{ title }}
                        </div>
                    </div>
                    <div class="author-container">
                        <div class="msg">
                            작성자
                        </div>
                        <div class="author">
                            {{ author }}
                        </div>
                    </div>
                    <div class="btn-list">
                        <div class="send-btn" @click="mvArticle">
                            게시글 이동
                        </div>
                        <div class="close-btn" @click="$emit('close')">
                            닫기
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </Transition>
</template>

<style scoped>
.modal-header {
    color: #82ACC1;
    font-weight: 600;
    font-size: 14px;
}

.thumbnail {
    width: 90%;
    height: 300px;
    border: 1px solid #6A6A6A;
    border-radius: 3%;
    margin: 0 auto;
    margin-top: 10px;
    overflow: hidden;
}

.thumbnail-img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.title-container {
    display: flex;
    margin-left: 5%;
    margin-top: 10px;
}

.msg {
    width: 18%;
    font-size: 16px;
    font-weight: 600;
}

.title {
    width: 60%;
    font-size: 14px;
}

.author-container {
    display: flex;
    margin-left: 5%;
    margin-top: 10px;
}

.author {
    width: 60%;
    font-size: 14px;
}
.board-element {
    height: 50px;
    width: 90%;
    border: 1px solid #D9D9D9;
    border-radius: 5px;
    margin: 0 auto;
    margin-bottom: 2px;
    text-align: center;
    line-height: 50px;
}

.board-list::-webkit-scrollbar {
    width: 8px;  /* 스크롤바의 너비 */
}

.board-list::-webkit-scrollbar-thumb {
    height: 20%; /* 스크롤바의 길이 */
    background: #6A6A6A; /* 스크롤바의 색상 */
    
    border-radius: 10px;
}

.board-list::-webkit-scrollbar-track {
    background: #D9D9D9;  /*스크롤바 뒷 배경 색상*/
}

.btn-list {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}

.send-btn {
    margin-right: 10px;
    background-color: #82ACC1;
    color: white;
    font-size: 12px;
    height: 20px;
    padding: 2px 10px 2px 10px;
    line-height: 20px;
    cursor: pointer;
    /* zoom: 0.9; */
    border-radius: 5px;
}

.close-btn {
    background-color: #D9D9D9;
    color: #6A6A6A;
    font-size: 12px;
    height: 20px;
    padding: 2px 15px 2px 15px;
    line-height: 20px;
    cursor: pointer;
    /* zoom: 0.9; */
    border-radius: 5px;
}

.modal-mask {
    position: fixed;
    z-index: 9998;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    transition: opacity 0.3s ease;
}

.modal-container {
    width: 380px;
    margin: auto;
    padding: 20px 30px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 4px 6px rgba(0, 0, 0, 0.3);
    transition: all 0.2s ease-in-out;
    justify-content: center;
}

.modal-body {
    margin: 20px 0;
    justify-content: center;
}

.modal-enter-from {
    opacity: 0;
}

.modal-leave-to {
    opacity: 0;
}

.modal-enter-from .modal-container,
.modal-leave-to .modal-container {
    -webkit-transform: scale(1.3);
    transform: scale(1.3);
}
</style>