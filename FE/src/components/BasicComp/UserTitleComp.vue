<template>
    <div class="wrap">
        <router-link to="/mainpage">
            <div id="username">김싸피 님의 미니홈피</div>
        </router-link>
        <div class="follow-request-btn" id="show-modal" @click="showModal = true">
            일촌 신청
        </div>
    </div>
    <Teleport to="body">
        <modal :show="showModal" @close="showModal = false">
            <template #header>
                <h3>custom header</h3>
            </template>
        </modal>
    </Teleport>
</template>

<script>
import Modal from '@/components/FollowComp/FollowRequestModal.vue'
export default {
    components: { Modal },
    data() {
        return {
            showModal: false,
        }
    }
}
</script>

<style scoped>
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
    font-size: 12px;
    font-weight: bold;
    line-height: 25px;
    color: #499DC6;
}

.follow-request-btn {
    cursor: pointer;
    font-size: 10px;
    background-color: #82ACC1;
    color: #FFFFFF;
    width: 50px;
    height: 15px;
    padding: 2px 4px;
    text-align: center;
    zoom: 0.8;
    font-weight: bold;
    border-radius: 20px;
    margin-left: 10px;
    line-height: 15px;
    margin-top: 6px;
}</style>