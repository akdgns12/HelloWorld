<template>
    <div class="wrap">
        <div style="font-size:12px">TODAY</div>
        <div id="today">{{this.today}}</div>
        <div style="font-size:12px; padding-right : 0.5vw"> | </div>
        <div style="font-size:12px">TOTAL</div>
        <div id="total">{{this.total}}</div>

    </div>
</template>

<script>
import http from '@/api/httpWithAccessToken'
export default {
    data() {
        return {
            masterSeq: this.$route.params.userSeq,
            today: null,
            total: null,
        }
    },
    created() {
        http.get(`/user/mainpage/${this.masterSeq}`).then((result) => {
            this.today = result.data.data.today;
            this.total = result.data.data.total;
        }, (error)=>{
            console.log(error);
        });
    },
}
</script>

<style scoped>
    .wrap {
        width: 20vw;
        display: flex;
        text-align: center;
        justify-content: center;
    }

    #today {
        font-size : 12px;
        color : #AE4B59;
        font-weight: bold;
        padding: 0 0.5vw 0 0.5vw;
    }
    #total {
        font-size: 12px;
        /* font-weight: bold; */
        padding: 0 0.5vw 0 0.5vw;
    }
</style>