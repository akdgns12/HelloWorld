<template>
    <div class="wrapper">
        <div>
            <div class="wrap">
                <router-link to="/mainpage">
                    <div id="username">김싸피 님의 미니홈피</div>
                </router-link>
                <div class="follow-request-btn" id="show-modal" @click="showModal = true">
                    일촌 신청
                </div>
                <div class="bgm-btn">
                    ♬ 가을 아침 - 아이유 🔊
                </div>
                <VueYtframe video-id="6ZUIwj3FgUY" height=0 width=0 :player-vars="{ loop: 1, autoplay: 1, listType: 'user_uploads'}" />
            </div>
            <Teleport to="body">
                <modal :show="showModal" @close="showModal = false">
                    <template #header>
                        <h3>custom header</h3>
                    </template>
                </modal>
            </Teleport>
        </div>
        <BGMComp />
    </div>
</template>


<script>
import Modal from '@/components/FollowComp/FollowRequestModal.vue'
import BGMComp from '@/components/BasicComp/BGMComp.vue'

export default {
    components: { Modal, BGMComp },
    data() {
        return {
            showModal: false,
        }
    }
}
</script>

<style scoped>
.wrapper {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    /* margin-right : 5rem; */
    align-items: end;
}

a {
    text-decoration: none;
    color: #499DC6;
}

a:hover {
    text-decoration: underline;
}

.wrap {
    display: flex;
}

#username {
    padding-left: 1vw;
    font-size: 15px;
    font-weight: bold;
    /* line-height: 25px; */
    color: #499DC6;
}

.follow-request-btn {
    cursor: pointer;
    font-size: 10px;
    background-color: #82ACC1;
    color: #FFFFFF;
    width: 60px;
    /* height: 20px; */
    padding: 2px 4px;
    text-align: center;
    /* zoom: 0.8; */
    font-weight: bold;
    border-radius: 20px;
    margin-left: 15px;
    /* line-height: 20px; */
    /* margin-top: 6px; */
    margin-bottom: 5px;
}

.bgm-btn {
    cursor: pointer;
    font-size: 12px;
    padding: 2px 0px;
    text-align: center;
    font-weight: bold;
    border-radius: 20px;
    /* line-height: 20px; */
    /* margin-top: 6px; */
    margin-left: 20px;
    margin-bottom: 5px;
}
</style>