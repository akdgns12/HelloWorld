<script>
export default {
    props: {
        show: Boolean,
        date: String,
        boardList: Array,
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
                        <div class="board-element" v-for="(board, i) in boardList" :key="i">
                            id가 {{ board }} 번인 글이 작성되었습니다
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