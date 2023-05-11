<template>
    <div class="wrap">
        <TodayCnt />
        <div class="left-header">
            <div class="blank"></div>
            <div class="blank"></div>
            <div class="profile-img-container">
                <img class="profile-img" :src=this.avatarUrl alt="프로필 사진" />
            </div>
            <p class="one-line-desc" v-if="this.oneLineDesc!=null">{{this.oneLineDesc}}</p>
            <p class="one-line-desc-null" v-if="this.oneLineDesc==null">한 줄 소개가 없습니다</p>
            <div class="blank"></div>
            <select class="wave" v-model="selected2">
                <option v-for="(item, index) in selectList" :key="index" :value="item.value">{{ item.name }}</option>
            </select>
            <div class="edit-and-history">
                <router-link :to="`/modify-user/${this.masterSeq}`">
                <div class="edit-btn" v-if="this.userSeq==this.masterSeq">
                    <div class="blue-arrow">▶</div>
                    <div class="edit">EDIT</div>
                </div>
            </router-link>
                <div class="history-btn">
                    <div class="blue-arrow">▶ </div>
                    <div class="history">HISTORY</div>
                </div>
            </div>
            <hr class="divider"/>
        </div>
    </div>
</template>

<script>
import TodayCnt from "@/components/BasicComp/TodayCnt.vue"
import http from "@/api/httpWithAccessToken"
export default {
    components: { TodayCnt },
    data() {
        return {
            selected2: "",
            selectList: [
                { name: "파도타기", value: "" },
            ],
            userSeq: localStorage.getItem('user-seq'),
            masterSeq: this.$route.params.userSeq,
            avatarUrl: null,
            oneLineDesc: null,
        };
    },
    mounted() {
        http.get(`/user/mainpage/${this.masterSeq}`).then((result) => {
            this.avatarUrl = result.data.data.avatarUrl;
            this.oneLineDesc = result.data.data.comment;
        }, (error)=>{
            console.log(error);
        });
        http.get(`/family/recommend?userSeq=${this.masterSeq}`).then((result) => {
            var temp = result.data.body;
            for(var i = 0; i < temp.length; i++) {
                this.selectList.push({name: temp[i], value: ''});
            }
        }, (error) => {
            console.log(error);
        })
    }
};
</script>

<style scoped>
a {
    text-decoration: none;
    color: black;
}
.wrap {
    margin-top: 3vh;
}

.left-header {
    width: 18vw;
    height: 75vh;
    background-color: white;
    margin-left: 1vw;
    margin-top: 4px;
    border: 1px solid #6A6A6A;
    border-radius: 15px;
}

.blank {
    height: 1vh;
}

.profile-img-container {
    width: 16vw;
    height: 35%;
    border: 0;
    margin: 0 auto;
    overflow: hidden;
}

.profile-img {
    width: 16vw;
    height: 100%;
    object-fit: fill;
    margin: 0 auto;
}

.one-line-desc {
    margin-top: 3vh;
    color: #499DC6;
    font-size: 13px;
    font-weight: bold;
}

.one-line-desc-null {
    margin-top: 3vh;
    color: lightgrey;
    font-size: 13px;
    font-weight: bold;
}

.wave {
    font-size: 12px;
    width: 16vw;
    margin-top: 50%;
    border: 1px solid #6A6A6A;
    border-radius: 3px;
    padding: 3px;
}

.edit-and-history {
    display: flex;
    width: 16vw;
    margin: 0 auto;
    margin-top: 20px;
}

.edit-btn {
    display: flex;
    cursor: pointer;
}

.history-btn {
    display: flex;
    cursor: pointer;
    margin-left: 10px;
}

.blue-arrow {
    font-size: 10px;
    /* zoom: 0.7; */
    color: #499DC6;
    line-height: 10px;
    margin-right: 1px;
}

.edit {
    font-size: 10px;
    /* zoom: 0.8; */
    font-weight: 600;
}

.history {
    font-size: 10px;
    /* zoom: 0.8; */
    font-weight: 600;
}

.divider {
    width: 16vw;
    margin: 0 auto;
    margin-top: 2px;
}
</style>