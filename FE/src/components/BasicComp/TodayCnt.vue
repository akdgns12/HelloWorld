<template>
    <div>
        <p style="font-size:0.5rem">TODAY</p>
        <p id="today">1234</p>
        <p style="font-size:0.5rem; padding-right : 0.5vw"> | </p>
        <p style="font-size:0.5rem">TOTAL</p>
        <p id="total">123123</p>
    </div>
</template>

<script>
</script>

<style scoped>
    div{
        display : flex;
        justify-content: center;
        align-items: center;
    }

    #today {
        font-size : 0.7rem;
        color : red;
        font-weight: bold;
        padding: 0 0.5vw 0 0.5vw;
    }
    #total {
        font-size: 0.7rem;
        font-weight: bold;
        padding: 0 0.5vw 0 0.5vw;
    }
</style>