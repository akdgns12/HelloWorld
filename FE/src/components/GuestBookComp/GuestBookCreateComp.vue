<template>
    <div id="guestBookCreate" v-if="showCreateComp">
        <div id="GBCreate">
            <img src="@/assets/minimi_temp/minime_me.png" alt="temp_minime">
            <textarea name="guestBookContent" id="GBContent" cols="80" rows="7" placeholder="방명록을 작성하세요" v-model="newGuestBookContent"></textarea>
        </div>
        <div id="GBUser">
            <router-link to="" class="minime-link">미니미</router-link>
            <button id="GBCheck" @click="addGuestBook">확인</button>
        </div>       
    </div>
</template>

<script setup>
import axios from 'axios';
import { useRoute } from 'vue-router';
import { ref, getCurrentInstance, computed } from 'vue';

const emit = getCurrentInstance().emit;
const newGuestBookContent = ref('');
const baseURL = "https://k8a308.p.ssafy.io/api";
const headers = {
    "Content-Type": "application/json;charset=utf-8",
    Authorization: `Bearer ${localStorage.getItem("access-token")}`,
  };
const route = useRoute();
const minihomeMaster = computed(() => route.params.userSeq);
const userSeq = ref(`${localStorage.getItem("user-seq")}`);

const showCreateComp = computed(() => {
    return minihomeMaster.value !== userSeq.value;
})

const addGuestBook = () => {
    const requestDto = {
        "content" : newGuestBookContent.value,
        "isSecret" : 0,
        "readSeq" : Number(minihomeMaster.value),
        "writeSeq" : Number(userSeq.value),
    };
    newGuestBookContent.value = '';
    axios.post(`${baseURL}/guestbook`, requestDto, {headers})
        .then(response => {
            console.log(response.data);
            emit('addGuestBook');
        })
        .catch(error => {
            console.error(error);
            alert('방명록 작성에 실패했습니다!');
        })
}
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
        height: 11vh;
        border : solid;
        border-width: 1px;
    }
    #GBUser {
        display: flex;
        margin : 1vh 2.5vw 1.2vh 3.7vw;
        justify-content: space-between;
        font-size : 1vw;
    }
    .minime-link {
        text-decoration: none;
    }

    #GBCheck {
        background-color: white;
        border-radius : 5px;
        font-weight: bold;
    }
</style>