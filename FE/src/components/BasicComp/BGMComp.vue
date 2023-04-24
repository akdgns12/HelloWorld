<template>
    <div class="BN">
        <img src="@/assets/icon/alarm.png" alt="" class="notification" @click="showModal = true" style="cursor:pointer">
        <Teleport to="body">
            <modal :show="showModal" @close="showModal = false"/>
        </Teleport>
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
    .notification {
        width : 1vw;
    }
</style>