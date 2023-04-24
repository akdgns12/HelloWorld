<template>
    <div class="wrap">
        <TodayCnt />
        <div class="left-header">
            <div class="blank"></div>
            <div class="blank"></div>
            <div class="profile-img-container">
                <img class="profile-img" src="../../assets/image/Person.png" alt="프로필 사진" />
            </div>
            <p class="one-line-desc">안녕하세요 꿈꾸는 개발자입니다!</p>
            <div class="blank"></div>
            <select class="wave" v-model="selected2">
                <option v-for="(item, index) in selectList" :key="index" :value="item.value">{{ item.name }}</option>
            </select>
            <div class="edit-and-history">
                <router-link to="/modify-user">
                <div class="edit-btn">
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
export default {
    components: { TodayCnt },
    data() {
        return {
            selected2: "",
            selectList: [
                { name: "파도타기", value: "" },
                { name: "name1", value: "a" },
                { name: "name2", value: "b" },
                { name: "name3", value: "c" },
            ],
        };
    },
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
    border: 1px solid #6A6A6A;
    border-radius: 3%;
    margin: 0 auto;

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
    font-size: 12px;
    /* zoom: 0.8; */
    font-weight: bold;
}

.wave {
    font-size: 12px;
    width: 16vw;
    margin-top: 50%;
    border: 1px solid #6A6A6A;
    border-radius: 3px;
    padding: 3px;
    /* zoom: 0.8; */
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