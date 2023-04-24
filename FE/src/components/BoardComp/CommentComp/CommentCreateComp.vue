<template>
    <div id = "createComments">
        <p style="font-weight:bold">댓글</p>
        <input type="search">
        <button @click="createComment">확인</button>
    </div>
</template>

<script>
</script>

<style scoped>
    #createComments {
        display: flex;
        width : 94%;
        justify-content: space-between;
        align-items: center;
        margin : 1%;
    }
    input {
        width : 80%;
        height: 3vh;
        background-color: #FFF9F9;
        border : 0;
    }
    button {
        background-color: white;
        border-radius: 0.5vh;
        font-size : 1.7vh;
        border-color : #6A6A6A;
        margin : 1px;
    }
</style>