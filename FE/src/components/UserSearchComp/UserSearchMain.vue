<template>
    <div class="wrap">
        <UserTitleComp />
        <div class="right-body">
            <div class="community-notice">
                <div class="search-container">
                    <form class="search-form">
                        <select v-model="type" @change="selectType">
                            <option value="">검색 조건&nbsp;&nbsp;▼</option>
                            <option value="1">이름</option>
                            <option value="2">닉네임</option>
                            <option value="3">이메일</option>
                        </select>
                        <input type="search-input" class="search-input" name="search" required v-model="searchKeyword">
                    </form>
                    <button class="search-button" @click="search">검색</button>
                </div>
            </div>
            <div class="whole-alticles">
                    <div class="articles" id="guestBookList" v-for="oneRow in this.chunkedResult" :key="oneRow">
                        <div class="article-container" v-for="info in oneRow" :key="info" :id="`${info.userSeq}`"
                            @click="mvFamilyHome">
                            <div class="represent-img-container" :id="`${info.userSeq}`">
                                <img class="represent-img" :src="`${info.imageUrl}`" alt="대표이미지" :id="`${info.userSeq}`" />
                            </div>
                            <div class="title" :id="`${info.userSeq}`">
                                {{ info.nickname }}
                            </div>
                            <div class="author" :id="`${info.userSeq}`">
                                {{ info.relationName }}
                            </div>
                        </div>
                        <div class="article-container hidden" v-for="i in 4 - oneRow.length" :key="i"
                            style="display: hidden;"> </div>
                    </div>
                </div>
        </div>
    </div>
</template>

<script>
import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue"
// import http from "@/api/httpWithAccessToken"
export default {
    components: { UserTitleComp, },
    methods: {
        chunk: function (data = [], size = 1) {
            const arr = [];
            for (let i = 0; i < data.length; i += size) {
                arr.push(data.slice(i, i + size));
            }
            return arr;
        },
        mvFamilyHome: function (e) {
            e.preventDefault();
            this.$router.push({ name: 'mainpage', params: { userSeq: e.target.id } })
        },
        selectType: function(e) {
            e.preventDefault();
            console.log(e.target.value)
            console.log(`value: ${this.type}`)
        },
        search: function() {
            console.log(this.searchKeyword)
            // http.get(`/user/search?type=${this.type}&keyword=${this.searchKeyword}`).then((result) => {
            //     console.log(result)
            // }, (error) => {
            //     console.log(error);
            // })
        }
    },
    async mounted() {
        this.chunkedResult = this.chunk(this.searchResult, 4);
    },
    data() {
        return {
            masterSeq: this.$route.params.userSeq,
            userSeq: localStorage.getItem('user-seq'),
            searchResult: [],
            chunkedResult: null,
            type: "",
            searchKeyword: "",
        }
    },
}

</script>

<style scoped>
select {
    width: 30%;
    height: 32px;
    margin-right: 3%;
    text-align: center;
    border: 0;
    border-radius: 15px;
    background-color: #82ACC1;
    color: white;
    font-weight: 600;
    cursor: pointer;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
}

option {
    border-radius: 15px;
    background-color: rgb(233, 233, 233);
    color: #6A6A6A;
    font-weight: 600;
    cursor: pointer;
    border: 0;
}

select::-ms-expand {
    display: none;
}

.right-body {
    background-color: white;
    width: 62vw;
    height: 75vh;
    border: 1px solid #6A6A6A;
    border-radius: 15px;
}

.community-notice {
    text-align: start;
    color: #6A6A6A;
    font-size: 20px;
    display: flex;
    justify-content: start;
    height: 9%;
}

.keyword-notice {
    width: 100%;
    text-align: center;
    color: #6A6A6A;
    font-size: 12px;
    font-weight: 600;
}

.keyword {
    background-color: #82ACC1;
    color: white;
    width: 150px;
    padding: 3px 6px;
    font-size: 11px;
    font-weight: 600;
    border-radius: 10px;
    justify-content: start;
    cursor: pointer;
}

.search-container {
    width: 100%;
    display: flex;
    justify-content: center;
}

.search-form {
    width: 50%;
    margin-top: 10px;
    display: flex;
}

.search-input {
    width: 100%;
    height: 32px;
    font-size: 15px;
    border: 0;
    border-radius: 15px;
    outline: none;
    padding-left: 10px;
    background-color: rgb(233, 233, 233);
}

.search-button {
    margin-left: 30px;
    width: 50px;
    height: 32px;
    margin-top: 10px;
    border: 0;
    border-radius: 15px;
    background-color: #82ACC1;
    color: white;
    font-weight: 600;
    cursor: pointer;
}

.whole-alticles {
    width: 98%;
    margin: 0 auto;
    height: 80%;
    overflow: hidden;
    overflow-y: scroll;
}

.whole-alticles::-webkit-scrollbar {
    width: 8px;
    /* 스크롤바의 너비 */
}

.whole-alticles::-webkit-scrollbar-thumb {
    height: 20%;
    /* 스크롤바의 길이 */
    background: #8C8C8C;
    /* 스크롤바의 색상 */

    border-radius: 20px;
}

.whole-alticles::-webkit-scrollbar-track {
    background: #D9D9D9;
    /*스크롤바 뒷 배경 색상*/
}

.articles {
    width: 100%;
    justify-content: space-evenly;
    display: flex;
    margin-top: 15px;
    margin-bottom: 10px;
}

.article-container {
    width: 14vw;
    height: 30vh;
    border: 1px solid #A8A8A8;
    border-radius: 10px;
    box-shadow: rgba(0, 0, 0, 0.2) 2px 2px 3px;
    cursor: pointer;
}

.article-container:hover {
    transform: scale(1.03);
    transition: 0.8s;
}

.hidden {
    border: none;
    box-shadow: none;
}


.represent-img-container {
    /* border: 2px solid #D9D9D9; */
    width: 90%;
    height: 70%;
    margin: 0 auto;
    margin-top: 4%;
}

.represent-img {
    width: 100%;
    height: 100%;
    object-fit: fill;
}

.title {
    width: 90%;
    margin: 0 auto;
    margin-top: 5%;
    text-align: start;
    font-size: 13px;
    font-weight: 700;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

.author {
    font-size: 9px;
    width: 90%;
    margin: 0 auto;
    text-align: start;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    margin-top: 1%;
}
</style>
