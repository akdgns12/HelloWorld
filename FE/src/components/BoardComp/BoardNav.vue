<template>
    <div id = "leftFrame">
        <TodayCnt />
        <div id="CategoryList">
            <div id="title">게시글</div>
            <hr>
            <div id="category">
                <div id = "Allcategory" :class="{ active: selectedCategory === 'all' }"
                @click="handleClick('all')" style="cursor: pointer;">
                    전체보기
                </div>
                <div v-for="category in categories" :key="category.id">
                    <img src="../../assets/icon/folder.png" alt="">
                    <p :class="{ active: selectedCategory === category.id }"
                    @click="handleClick(category.id)" style="cursor: pointer;">{{ category.name }}</p>
                </div>
                <div>
                    <img src="../../assets/icon/share.png" alt="">
                    <p :class="{ active: selectedCategory === 5 }"
                    @click="handleClick(5)" style="cursor: pointer;">퍼간글</p>
                </div>
            </div>
        </div>
    </div>
</template>


<script>
// import { router } from '@/router';
import TodayCnt from "@/components/BasicComp/TodayCnt.vue";
export default {
    components: { TodayCnt },
    data( ) {
        return {
            selectedCategory : 'all',
            categories : [
                {id : 0, name : 'cs'},
                {id : 1, name : 'Algorithm'},
                {id : 2, name : 'Project'},
                {id : 3, name : 'Language'},
                {id : 4, name : 'Etc'}
            ]
        }
    },
    methods: {
        handleClick(category) {
            console.log(category);
            this.selectedCategory = category;
            this.$emit('category-selected', category);
        }
    }
}
</script>

<style scoped>
#leftFrame {
    margin-top : 6vh;
}
#CategoryList {
    width: 18vw;
    height: 75vh;
    background-color: white;
    margin-left: 1vw;
    margin-top: 4px;
    border: 1px solid #6A6A6A;
    border-radius: 15px;
}

hr {
    width : 14vw;
    text-align: left;
    margin : 0 1.8rem;
}

#title {
    font-size: 1.2rem;
    font-weight: bold;
    color:#82ACC1;
    display: flex;
    /* padding-left : 2.5rem; */
    margin : 2.5rem 2.5rem 1rem 2.5rem;
}

#Allcategory {
    font-size : 1VW;
    padding : 1vh 0 1vh 0;
}

#category {
    font-size: 1vw;
    color: black;
    margin: 1rem 2.5rem 2.5rem 2.5rem;
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