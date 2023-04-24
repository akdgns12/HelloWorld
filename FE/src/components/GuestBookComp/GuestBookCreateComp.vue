<template>
    <div id="guestBookCreate">
        <div id="GBCreate">
            <img src="@/assets/minimi_temp/minime_me.png" alt="temp_minime">
            <textarea name="guestBookContent" id="GBContent" cols="80" rows="7" placeholder="방명록을 작성하세요"></textarea>
        </div>
        <div id="GBUser">
            <router-link to="" class="minime-link">미니미</router-link>
            <button id="GBCheck">확인</button>
        </div>       
    </div>
</template>

<script>
</script>

<style scoped>
    #guestBookCreate{
        border: solid;
        border-width: 1px 0 1px 0;
        background-color: #F0F0F0;
    }
    #GBCreate {
        margin : 2vh 0 2vh 0;
        display : flex;
        justify-content:space-around;
        align-items: center;
    }
    img {
        width : 12vh;
        height : 12vh;
    }

    #GBContent {
        resize:none;
        height: 15%;
        border : solid;
        border-width: 1px;
    }
    #GBUser {
        display: flex;
        margin : 1vh 2.5vw 1.2vh 3.7vw;
        justify-content: space-between;
    }
    .minime-link {
        text-decoration: none;
    }

    #GBCheck {
        background-color: white;
        border-radius:13%;
        font-size: 90%;
    }
</style>