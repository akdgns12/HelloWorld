<template>
    <div id = "line">
        <div id = "Board">
            <div>
                <TodayCnt />
                <BoardNav />
            </div>
            <div>
                <div id = "boardheader">
                    <UserTitleComp />
                    <BGMComp />
                </div>
                <div id = "MainBoard">
                    <BoardDetailComp/>
                    <CategoryNav/>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import BoardNav from "@/components/BoardComp/BoardNav.vue";
import BoardDetailComp from "@/components/BoardComp/BoardDetailComp.vue";
import CategoryNav from "@/components/BasicComp/CategoryNav.vue";
import TodayCnt from "@/components/BasicComp/TodayCnt.vue";
import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue";
import BGMComp from "@/components/BasicComp/BGMComp.vue";
export default {
    components : { BoardNav, BoardDetailComp, CategoryNav, TodayCnt, UserTitleComp, BGMComp },
};
</script>


<style scoped>
    #line {
        border-radius : 2vh;
        border-style: dashed;
        border-color: black;
        margin : 4vh 3vw 4vh 3vw;
        padding : 2vh 0 2vh 0;
        height: 90vh;
    }

    #Board {
        display : flex;
        align-items: center;
        justify-content: center;
        background-color: #E5E5E5;
        padding : 4vh 0.5vw 4vh 0.5vw;
        margin : 0 1vw 0 1vw;
        border-radius : 2vh;
        height : 82vh;
    }

    #boardheader {
        display: flex; 
    }
    #MainBoard{
        display : flex;
        align-items: center;
        justify-content: center;
    }
</style>