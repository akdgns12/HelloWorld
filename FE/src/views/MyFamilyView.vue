<template>
    <div id="line">
        <div id="Board">
            <UserProfile />
            <div id="MainBoard">
                <MyFamilyMain />
                <CategoryNav />
            </div>
        </div>
    </div>
</template>

<script>
import UserProfile from "@/components/MainPageComp/UserProfile.vue"
import CategoryNav from "@/components/BasicComp/CategoryNav.vue"
import MyFamilyMain from "@/components/MyFamilyComp/MyFamilyMain.vue"
// import http from "@/api/httpWithAccessToken"

export default {
    components: { UserProfile, CategoryNav, MyFamilyMain },
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
    display: flex;
    align-items: center;
    justify-content: center;
    width: 88vw;
    height: 86vh;
    margin: 0 auto;
    margin-top: 2vh;
    background-color: #F0F0F0;
    border-radius: 10px;
}

#MainBoard {
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>