<template>
    <div class="wrapper">
        <!-- <div class="BGM">
            <p class="songTitle">The Weeknd - I Feel it Coming(cover by J.Fla)</p>
            <audio class="player" controls ref="player">
                <source src="" ref="source">
            </audio>
        </div> -->
        <div class="BN">
            <img src="@/assets/icon/alarm.png" alt="" class="notification" @click="showModal = true" style="cursor:pointer">
            <Teleport to="body">
                <modal :show="showModal" @close="showModal = false"/>
            </Teleport>
        </div>
    </div>
</template>

<script>
import Modal from '@/components/NotifyComp/NotificationComp.vue';
export default {
    components: {Modal},
    data() {
        return {
            showModal : false,
        }
    }
}
</script>

<style scoped>
    .wrapper {
        height: 62.6px;
        
    }
    .songTitle {
        width : 14rem;
        height: 0.9rem;;
        font-size : 0.9rem;
        overflow-x: hidden;
        background-color: white;

    }
    .BGM {
        /* background-color: white; */
        border-radius: 30px;
        width : 15rem;
        
    }
    .player {
        width : 15rem;
        height: 1.5rem;
    }
    .notification {
        width : 1vw;
    }
</style>