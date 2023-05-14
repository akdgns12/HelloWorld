<template>
    <div id = "commentList" v-for="comment in comments" :key="comment.commentSeq">
        <div class="commentline">
            <span id="commentAuthor">{{ comment.writer }}</span>
            <span style="padding : 0 0.4rem;"> : </span>
            <span id="commentContent" v-if="!isEditingComment(comment?.commentSeq)">{{ comment.content }}</span>
            <div class="editComment" v-else>
                <input type="text" v-model="comment.content">
                <button  @click="updateBoardComment(comment.commentSeq, comment.content)" class="update">수정</button>
            </div>
            <div class="myUd" v-if="comment.userSeq == userSeq">
                <img src="@/assets/icon/pencil.png" alt="modifyComment" @click="editComment(comment.commentSeq)">
                <img src="@/assets/icon/clear.png" alt="deleteComment" @click="deleteBoardComment(comment.commentSeq)">
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import { ref, computed, watch } from 'vue';

export default {
    props : {
        comments: {
            default : () => []
        }
    },
    data() {
        return {
            userSeq : localStorage.getItem('user-seq'),
            edit : {},
        }
    },
    setup(props) {
        const headers = {
            "Content-Type" : "application/json;charset=utf-8",
            Authorization: `Bearer ${localStorage.getItem("access-token")}`,
          };
        const baseURL = "https://k8a308.p.ssafy.io/api";
        // //const edit = ref({});
        // const editComment = computed(() => (commentSeq) => {return !!this.edit[commentSeq];});

        const edit = ref({});
        const isEditingComment = computed(() => (commentSeq) => !!edit.value[commentSeq]);

        watch(isEditingComment, (newValue) => {
            console.log(newValue);
        })

        const updateBoardComment = (commentSeq, content) => {
            const updateComment = props.comments.map(comment => {
                if (comment.commentSeq === commentSeq) {
                    comment.content = content;
                }
                return comment;
            })
            console.log(updateComment);
            const requestDto = {
                commentSeq : commentSeq,
                content : content
            };
            axios.
                put(`${baseURL}/board/comment`, requestDto, {headers})
                .then(response => {
                    console.log(response);
                    edit.value[commentSeq] = !edit.value[commentSeq];
                })
                .catch(error => {
                    console.error(error);
                    alert("댓글 수정이 되지 않습니다!");
                })
        }

        const deleteBoardComment = (commentSeq) => {
            axios
                .delete(`${baseURL}/board/comment?commentSeq=${commentSeq}`, {headers})
                .then(response => {
                    console.log(response);
                    //props.comments.filter(comment => comment.commentSeq !== commentSeq);
                    //props.comments.splice(props.comments.findIndex(comment => comment.commentSeq === commentSeq),1);
                    const index = props.comments.findIndex(comment => comment.commentSeq === commentSeq);
                    if (index !== -1) {
                      // eslint-disable-next-line vue/no-mutating-props
                      props.comments.splice(index, 1);
                    }
                })
                .catch(error => {
                    console.errer(error);
                    alert("댓글 삭제가 되지 않습니다");
                })
        }

        const editComment = (commentSeq) => {
          edit.value[commentSeq] = true;
        };
        return {
            isEditingComment,
            editComment,
            updateBoardComment,
            deleteBoardComment
        };
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
        padding-bottom: 0.3rem;
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
    .editComment {
        display:flex;
        flex-direction: row;
        align-items: center;
    }
    .update {
        font-size : 0.5rem;
        color : white;
        background-color: #82ACC1;
        border-radius: 20px;
        border : none;
        margin : 0 0.4rem;
    }
    img {
        width : 0.6rem;
        height: 0.6rem;
        padding : 0 0.5% 0 1%;
        margin-top : 1%;
        opacity: 0.7;
        cursor: pointer;
    }
</style>