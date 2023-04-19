<template>
    <div id="CategoryList">
        <div id="title">게시글</div>
        <hr>
        <div id="category">
            <div id = "Allcategory">
                전체보기
            </div>
            <div>
                <img src="../../assets/folder.png" alt="">
                <p>CS</p>
            </div>
            <div>
                <img src="../../assets/folder.png" alt="">
                <p>Algorithm</p>
            </div>
            <div>
                <img src="../../assets/folder.png" alt="">
                <p>Project</p>
            </div>
        </div>
    </div>
</template>

<script>
</script>

<style scoped>
#CategoryList {
    width : 20vw;
    height: 60vh;
    padding-left : 1vw;
    padding-top : 3vh;
}

hr {
    width : 14vw;
    text-align: left;
    margin-left : 0;
}

#title {
    font-size: 1.3vw;
    font-weight: bold;
    color:#82ACC1;
    display: flex;
    padding-left : 1.5vh;
    padding-bottom : 1.0vh;
}

#Allcategory {
    font-size : 1VW;
    padding : 1vh 0 1vh 0;
    font-weight: bold;
}

#category {
    font-size: 1vw;
    color: black;
    margin: 1vh;
}

#category > div {
    display: flex;
}

img {
    height:2.5vh;
    width: 2.5vh;
    padding : 1.5vh 1.5vh 0 0;
}
</style>