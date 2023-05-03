<template>
    <div id = "line">
        <div id = "Board">
            <BoardNav @category-selected="selectCategory"/>
            <div>
                <div id = "MainBoard">
                    <div v-if="selectedCategory === 5">
                        <BoardShareList />
                    </div>
                    <div v-else>
                        <BoardListComp :category="selectedCategory"/>
                    </div>
                    <CategoryNav/>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import BoardNav from "@/components/BoardComp/BoardNav.vue";
import BoardListComp from "@/components/BoardComp/BoardListComp.vue";
import CategoryNav from "@/components/BasicComp/CategoryNav.vue";
// import TodayCnt from "@/components/BasicComp/TodayCnt.vue";
//import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue";
//import BGMComp from "@/components/BasicComp/BGMComp.vue";
import BoardShareList from "@/components/BoardComp/BoardShareList.vue";
export default {
    components : { BoardNav, BoardListComp, BoardShareList, CategoryNav},
    data() {
        return {
            selectedCategory : 'all'
        }
    },
    methods : {
        selectCategory(categoryId) {
            this.selectedCategory = categoryId;
        }
    }
};
</script>


<style scoped>
    #line {
        width: 90vw;
        height: 90vh;
        margin: 0 auto;
        margin-top: 5vh;
        border: 3px dashed #6A6A6A;
        border-radius: 10px;
    }

    #Board {
        display : flex;
        align-items: center;
        justify-content: center;
        width: 88vw;
        height: 86vh;
        margin: 0 auto;
        margin-top: 2vh;
        background-color: #F0F0F0;
        border-radius: 10px;
    }
    #MainBoard{
        display : flex;
        align-items: center;
        justify-content: center;
    }
</style>