<template>
    <div class="wrap">
        <UserTitleComp />
        <div class="right-body">
            <div class="family-list-notification">
                일촌 목록
            </div>
            <div class="whole-alticles" >
                <div class="articles" id="guestBookList" v-for="oneRow in this.chunkedResult" :key="oneRow">
                    <div class="article-container" v-for="info in oneRow" :key="info" :id="`${info.userSeq}`" @click="mvFamilyHome">
                        <div class="represent-img-container" :id="`${info.userSeq}`">
                            <img class="represent-img" :src="`${info.imageUrl}`" alt="대표이미지" :id="`${info.userSeq}`"/>
                        </div>
                        <div class="title" :id="`${info.userSeq}`">
                            {{ info.nickname }}
                        </div>
                        <div class="author" :id="`${info.userSeq}`">
                            {{ info.relationName }}
                        </div>
                    </div>
                    <div class="article-container hidden" v-for="i in 4 - oneRow.length" :key="i" style="display: hidden;"> </div>
                </div>
            </div>
            <!-- <div class="family-list-container">
                <div class="family-element">
                    <div class="family-avatar-container">
                        <img class="family-avatar" src="@/assets/KakaoTalk_20230116_110321475_05.jpg" />
                    </div>
                </div>
            </div> -->
        </div>
    </div>
</template>

<script>
import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue"
import http from '@/api/httpWithAccessToken'
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
        mvFamilyHome: function(e) {
            e.preventDefault();
            this.$router.push({name: 'mainpage', params: { userSeq: e.target.id }})
        }
    },
    async mounted() {
        await http.get(`/family?userSeq=${this.masterSeq}&status=all&hasComment=true`).then((result) => {
            // console.log(result.data.body)
            this.family=result.data.body;
        }, (error) => {
            console.log(error)
        });
        await http.get(`/family?userSeq=${this.masterSeq}&status=all&hasComment=false`).then((result) => {
            // var temp = result.data.body;
            this.family.concat(result.data.body);
            // this.chunkedResult = this.chunk(this.family, 4);
        }, (error) => {
            console.log(error)
        });
        console.log(this.family)
        for(var i = 0; i < this.family.length; i++) {
            await http.get(`/user/userInfo/${this.family[i].userSeq}`).then((result) => {
                this.family[i]['imageUrl'] = result.data.data.avatarUrl;
                this.family[i]['nickname'] = result.data.data.nickname;
            }, (error) => {
                console.log(error)
            })
        }
        this.chunkedResult = this.chunk(this.family, 4);
    },
    data() {
        return {
            masterSeq: this.$route.params.userSeq,
            userSeq: localStorage.getItem('user-seq'),
            family: [],
            chunkedResult: null,
        }
    },
}

</script>

<style scoped>
.right-body {
    background-color: white;
    width: 62vw;
    height: 75vh;
    border: 1px solid #6A6A6A;
    border-radius: 15px;
}

.family-list-notification {
    text-align: start;
    margin-top: 3%;
    margin-left: 2%;
    color: #82Acc1;
    font-size: 16px;
    font-weight: 600;
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

.content {
    width: 90%;
    margin: 0 auto;
    margin-top: 5%;
    text-align: start;
    font-size: 10px;
    color: #6A6A6A;
    overflow: hidden;
    white-space: normal;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
}

.sticker-and-comment {
    width: 90%;
    margin: 0 auto;
    justify-content: end;
    display: flex;
}

.heart-icon-container {
    width: 12px;
    height: 10px;
}

.heart-icon {
    width: 100%;
    height: 100%;
    object-fit: fill;
}

.heart-cnt {
    font-size: 8px;
    margin-left: 3px;
    height: 12px;
    line-height: 19px;
    color: #6A6A6A;
}

.comment-icon-container {
    margin-left: 5%;
    width: 12px;
    height: 10px;
}

.comment-icon {
    width: 100%;
    height: 100%;
    object-fit: fill;
}

.comment-cnt {
    font-size: 8px;
    margin-left: 3px;
    height: 12px;
    line-height: 19px;
    color: #6A6A6A;
}
</style>
