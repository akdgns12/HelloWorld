<template>
    <div class="wrap">
        <div style="font-size:12px">TODAY</div>
        <div id="today">1234</div>
        <div style="font-size:12px; padding-right : 0.5vw"> | </div>
        <div style="font-size:12px">TOTAL</div>
        <div id="total">123123</div>

    </div>
</template>

<script>
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