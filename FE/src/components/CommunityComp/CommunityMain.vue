<template>
    <div class="wrap">
        <!-- <div class="blank"></div> -->
        <UserTitleComp />
        <div class="right-body">
            <div class="community-notice"># 다양한 게시글들을 만나보세요</div>
            
        </div>
    </div>
</template>

<script>
import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue"


export default {
    components: { UserTitleComp, },
   
}

</script>

<style scoped>
.right-body {
    background-color: white;
    width: 62vw;
    height: 75vh;
    border: 1px solid #6A6A6A;
    border-radius: 15px;
}

.community-notice {
    text-align: start;
    color: #6A6A6A;
    font-size: 20px;
    /* font-weight: 600; */
    margin-left: 3%;
    margin-top: 2%;
    margin-bottom: 3%;
}
</style>
