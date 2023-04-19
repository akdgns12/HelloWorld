<template>
    <div id = "boardmain">
        <VMarkdownEditor 
            v-model="content"
            />
    </div>
</template>

<script>
</script>

<style scoped>
#boardmain {
        height: 72vh;
        width : 60vw;
        border-style : solid;
        border-width : 0.2vh;
        border-radius : 2vh;
        border-color: black;
        background-color: white;
        padding : 2vh;
        margin-left : 2vh;
    }
</style>