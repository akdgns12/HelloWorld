<template>
    <div class="wrap">
        <!-- <div class="blank"></div> -->
        <UserTitleComp />
        <div class="right-body">
            <TodayChart />
            <div class="row">
                <MyPostChart />
                <MyAchievement />
            </div>
        </div>
    </div>
</template>

<script>
import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue"
import TodayChart from "@/components/StatisticComp/TodayChart.vue"
import MyPostChart from "@/components/StatisticComp/MyPostChart.vue"
import MyAchievement from "@/components/StatisticComp/MyAchievement.vue"

export default {
    components: { UserTitleComp, TodayChart, MyPostChart, MyAchievement },
}

</script>

<style scoped>
.blank {
    height: 40px;
}

.right-body {
    background-color: white;
    width: 62vw;
    height: 75vh;
    border: 1px solid #6A6A6A;
    border-radius: 15px;
}

.row {
    /* width: 100%; */
    display: flex;
}
</style>
