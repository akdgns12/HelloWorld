<script>
// import http from '@/api/httpWithAccessToken'
export default {
    props: {
        show: Boolean,
        date: String,
        boardInfo: Array,
    },
    data() {
        return {
            userSeq: localStorage.getItem('user-seq'),
            masterSeq: this.$route.params.userSeq, 
        }
    },
    methods: {
        mvBoard: function(e) {
            e.preventDefault();
            console.log(e.target.id);
            this.$router.push(`/board/${this.masterSeq}/${e.target.id}`)
        }
    },  
    async created() {
        // if(this.boardList==null) {
        //     return;
        // }
        // for(var i = 0; i < this.boardList.length; i++) {
        //     await http.get(`/board?userSeq=${this.userSeq}&boardSeq=${this.boardList[i]}`).then((result) => {
        //         this.boardInfo.push(result.data)
        //         // console.log(result.data)
        //     }, (error) => {
        //         console.log(error)
        //     })
        // }

    }
}
</script>

<template>
    <Transition name="modal">
        <div v-if="show" class="modal-mask">
            <div class="modal-container">
                <div class="modal-header">
                    {{ date }} 에 작성한 게시글
                </div>
                <div class="modal-body">
                    <div class="board-list">
                        <div class="board-element" v-for="(board, i) in this.boardInfo" :key="i" :id="`${board.boardSeq}`" @click="mvBoard">
                            <div class="board-category" v-if="board.categorySeq==0" :id="`${board.boardSeq}`" @click="mvBoard">CS</div>
                            <div class="board-category" v-if="board.categorySeq==1" :id="`${board.boardSeq}`" @click="mvBoard">Algorithm</div>
                            <div class="board-category" v-if="board.categorySeq==2" :id="`${board.boardSeq}`" @click="mvBoard">Project</div>
                            <div class="board-category" v-if="board.categorySeq==3" :id="`${board.boardSeq}`" @click="mvBoard">Language</div>
                            <div class="board-category" v-if="board.categorySeq==4" :id="`${board.boardSeq}`" @click="mvBoard">Etc</div>
                            <div class="board-title" :id="`${board.boardSeq}`" @click="mvBoard">{{board.title}}</div>
                            <div class="board-create-time" :id="`${board.boardSeq}`" @click="mvBoard">{{ board.createTime.slice(11, 16) }}에 작성됨</div>
                        </div>
                    </div>
                    <div class="btn-list">
                        <!-- <div class="send-btn">
                            보내기
                        </div> -->
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

.board-list {
    height: 250px;
    overflow-y: auto;
}

.board-element {
    height: 50px;
    width: 90%;
    border: 1px solid #D9D9D9;
    border-radius: 5px;
    margin: 0 auto;
    margin-bottom: 5px;
    text-align: start;
    line-height: 50px;
    display: flex;
}

.board-category {
    width: 20%;
    margin-left: 2%;
    color: #6A6A6A;
    font-size: 12px;
    /* text-align: center; */
}

.board-title {
    /* margin-left: 2%; */
    width: 52%;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    color: #6A6A6A;
    font-size: 14px;
    font-weight: 600;
}

.board-create-time {
    width: 26%;
    color: #6A6A6A;
    font-size: 12px;
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