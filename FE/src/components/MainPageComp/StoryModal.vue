<script>
export default {
    props: {
        show: Boolean,
        boardSeq: String,
        title: String,
        author: String,
    }
}
</script>

<template>
    <Transition name="modal">
        <div v-if="show" class="modal-mask">
            <div class="modal-container">
                <div class="modal-header">
                    {{ title }}
                </div>
                <div class="modal-body">
                        {{author}}가 작성한 글입니다
                    <div class="btn-list">
                        <div class="close-btn" @click="$emit('close')">
                            닫기
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </Transition>
</template>

<style scoped>

</style>