<template>
    <div id = "line">
        <div id = "Board">
            <BoardNav @category-selected="selectCategory"/>
            <div>
                <div id = "MainBoard">
                    <div v-if="selectedCategory === 5 || categoryNameIndex === 5">
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
import BoardShareList from "@/components/BoardComp/BoardShareList.vue";
import { ref, computed } from 'vue';
import { useRoute } from 'vue-router';

export default {
    components : { BoardNav, BoardListComp, BoardShareList, CategoryNav},
    setup() {

        const route = useRoute();
        const categoryName = computed(() => route.params.category);
        const categoryList = ["CS", "Algorithm", "Project", "Language", "Etc", "Share"];
        const categoryNameIndex = computed(() => {
            return categoryList.findIndex((item) => item === categoryName.value);
        });

        const selectedCategory = ref('all');
        console.log(selectedCategory);
        const selectCategory = (category) => {
            selectedCategory.value = category;
        };
        return {
            categoryNameIndex,
            selectedCategory,
            selectCategory
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