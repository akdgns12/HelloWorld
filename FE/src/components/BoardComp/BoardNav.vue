<template>
    <div id = "leftFrame">
        <div id="CategoryList">
            <div id="title">게시글</div>
            <hr>
            <div id="category">
                <div id = "Allcategory" :class="{ active: selectedCategory === 'all' }"
                @click="handleClick('all')">
                    전체보기
                </div>
                <div>
                    <img src="../../assets/icon/folder.png" alt="">
                    <p :class="{ active: selectedCategory === 'cs' }"
                    @click="handleClick('cs')">CS</p>
                </div>
                <div>
                    <img src="../../assets/icon/folder.png" alt="">
                    <p :class="{ active: selectedCategory === 'algorithm' }"
                    @click="handleClick('algorithm')">Algorithm</p>
                </div>
                <div>
                    <img src="../../assets/icon/folder.png" alt="">
                    <p :class="{ active: selectedCategory === 'project' }"
                    @click="handleClick('project')">Project</p>
                </div>
                <div>
                    <img src="../../assets/icon/folder.png" alt="">
                    <p :class="{ active: selectedCategory === 'language' }"
                    @click="handleClick('language')">Language</p>
                </div>
                <div>
                    <img src="../../assets/icon/folder.png" alt="">
                    <p :class="{ active: selectedCategory === 'etc' }"
                    @click="handleClick('etc')">Etc</p>
                </div>
                <div>
                    <img src="../../assets/icon/share.png" alt="">
                    <p :class="{ active: selectedCategory === 'share' }"
                    @click="goShare()">퍼간글</p>
                </div>
            </div>
        </div>
    </div>
</template>


<script>
import { router } from '@/router';

export default {
    data( ) {
        return {
            selectedCategory : 'all',
        }
    },
    methods: {
        goShare() {
            router.push({
                path:'/board/share',
            })
        },
        handleClick(category) {
            this.selectedCategory = category;
            this.$emit('category-selected', category);
        }
    }
}
</script>

<style scoped>
#leftFrame {
    width: 16vw;
    height: 72vh;
    border-style : solid;
    border-width : 0.2vh;
    border-radius : 2vh;
    border-color: black;
    background-color: white;
    padding : 2vh;
}
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
.active {
    font-weight: bold;
}
</style>