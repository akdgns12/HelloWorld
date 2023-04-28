<template>
    <div style="width: 100%">
        <div class="my-achievement"># 내가 이룬 업적</div>
        <div style="width: 80%; height: 70%;">
            <div class="row">
                <div class="achievement-container">
                    <img class="achievement-element" src="@/assets/image/achievement/pixil-layer-1.png" alt="업적"
                        v-tippy="{ content: '스티커 10개 달성', arrow: false, placement: 'top', }" />
                </div>
                <div class="achievement-container">
                    <img class="achievement-element" src="@/assets/image/achievement/pixil-layer-2.png" alt="업적"
                        v-tippy="{ content: '스티커 100개 달성', arrow: false, placement: 'top', }" />
                </div>
                <div class="achievement-container">
                    <img class="achievement-element" src="@/assets/image/achievement/pixil-layer-3.png" alt="업적"
                        v-tippy="{ content: '스티커 1000개 달성', arrow: false, placement: 'top', }" />
                </div>
                <div class="achievement-container">
                    <img class="achievement-element" src="@/assets/image/achievement/pixil-layer-4.png" alt="업적"
                        v-tippy="{ content: 'TODAY 10 달성', arrow: false, placement: 'top', }" />
                </div>
            </div>
            <div class="row">
                <div class="achievement-container">
                    <img class="achievement-element" src="@/assets/image/achievement/pixil-layer-5.png" alt="업적"
                        v-tippy="{ content: 'TODAY 100 달성', arrow: false, placement: 'top', }" />
                </div>
                <div class="achievement-container">
                    <img class="achievement-element" src="@/assets/image/achievement/pixil-layer-6.png" alt="업적"
                        v-tippy="{ content: 'TODAY 1000 달성', arrow: false, placement: 'top', }" />
                </div>
                <div class="achievement-container">
                    <img class="achievement-element not-yet" src="@/assets/image/achievement/pixil-layer-1.png" alt="업적"
                        v-tippy="{ content: '스티커 10개 미달성', arrow: false, placement: 'top', }" />
                </div>
                <div class="achievement-container">
                    <img class="achievement-element not-yet" src="@/assets/image/achievement/pixil-layer-2.png" alt="업적"
                        v-tippy="{ content: '스티커 100개 미달성', arrow: false, placement: 'top', }" />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
// import Popper from "vue3-popper";

export default {
    components: {},
    methods: {
        showAchievementInfo: function (e) {
            e.preventDefault();
            alert(e.target.className);
            console.log(e.target.className);
        }
    }

}
</script>

<style scoped>
.my-achievement {
    text-align: start;
    color: #6A6A6A;
    font-size: 16px;
    font-weight: 600;
    margin-top: 5%;
    margin-bottom: 3%;
    width: 100%;
}

.row {
    display: flex;
    width: 400px;
}

.achievement-container {
    width: 20%;
    height: 60%;
    border: 1px solid #D9D9D9;
    box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
    border-radius: 5px;
    margin: 6px;
}

.achievement-element {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.achievement-container:hover {
    border: 1px solid #6A6A6A;
    transform: scale(1.1);
    transition: .5s;
}

.achievement-element:hover {
    transform: scale(2);
    transition: .5s;
}

.not-yet {
    filter: grayscale(100%);
}
</style>