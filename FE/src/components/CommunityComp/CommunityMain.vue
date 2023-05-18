<template>
    <div class="wrap">
        <!-- <div class="blank"></div> -->
        <UserTitleComp />
        <div class="right-body">
            <div class="community-notice">
                <div class="search-container">
                    <form class="search-form">
                        <input type="search-input" class="search-input" name="search" required v-model="searchKeyword" @keyup.enter="searchWithKeyword">
                    </form>
                    <button class="search-button" @click="searchWithKeyword">검색</button>
                </div>
            </div>
            <!-- <div class="keyword-notice">
                    # 실시간 인기 검색어
                </div> -->
            <div style="width: 100%; margin: 0 auto;">
                <carousel :autoplay="3000" :wrap-around="true" :transition="1000" :navigation-enabled="true" :dir="ttb"
                    :i18n="{
                        'ariaNextSlide': '',
                        'ariaPreviousSlide': '',
                        'ariaNavigateToSlide': '',
                        'ariaGallery': '',
                        'itemXofY': '',
                        'iconArrowUp': '',
                        'iconArrowDown': '',
                        'iconArrowRight': '',
                        'iconArrowLeft': '',
                    }">
                    <slide v-for="(keyword, index) in topKeywords" :key="keyword">
                        <div class="keyword" :id="keyword" @click="search"> {{ index + 1 }}위&nbsp;&nbsp; {{ keyword }}
                        </div>
                    </slide>
                    <template #addons>
                    </template>
                </carousel>
            </div>
            <hr style="width: 96%; margin: 0 auto; margin-top: 5px;" />
            <div style="display: flex; margin-left: 3%; height: 25px; margin-top: 5px;" v-if="this.searchState == true">
                <div style="font-weight: 600; font-size: 20px; line-height: 25px;">' {{ searchDecisionKeyword }} ' </div>
                <div style="font-size: 15px; line-height: 25px;">&nbsp;&nbsp;에 대한 검색 결과입니다</div>
            </div>
            <div class="whole-alticles" v-if="this.searchState == true">
                <div class="articles" id="guestBookList" v-for="oneRow in this.chunkedResult" :key="oneRow">
                    <div class="article-container" v-for="article in oneRow" :key="article" :boardSeq="`${article.id}`"
                        :authorSeq="`${article.userSeq}`" @click="mvBoard">
                        <div class="represent-img-container">
                            <img class="represent-img" v-if="article.imageUrl == ''"
                                src="@/assets/KakaoTalk_20230116_110321475_05.jpg" alt="대표이미지" :boardSeq="`${article.id}`"
                                :authorSeq="`${article.userSeq}`" @click="mvBoard" />
                            <img class="represent-img" v-if="article.imageUrl != ''" :src="`${article.imageUrl}`"
                                alt="대표이미지" :boardSeq="`${article.id}`" :authorSeq="`${article.userSeq}`"
                                @click="mvBoard" />
                        </div>
                        <div class="title" :boardSeq="`${article.id}`" :authorSeq="`${article.userSeq}`" @click="mvBoard">
                            {{ article.title }}
                        </div>
                        <div class="author" :boardSeq="`${article.id}`" :authorSeq="`${article.userSeq}`" @click="mvBoard">
                            by {{ article.author }}
                        </div>
                        <div class="content" :boardSeq="`${article.id}`" :authorSeq="`${article.userSeq}`" @click="mvBoard">
                            {{ article.content }}
                        </div>
                        <hr width="92%">
                        <div class="sticker-and-comment" :boardSeq="`${article.id}`" :authorSeq="`${article.userSeq}`"
                            @click="mvBoard">
                            <div class="heart-icon-container" :boardSeq="`${article.id}`" :authorSeq="`${article.userSeq}`"
                                @click="mvBoard">
                                <img class="heart-icon" src="@/assets/icon/heart.png" alt="좋아요" :boardSeq="`${article.id}`"
                                    :authorSeq="`${article.userSeq}`" @click="mvBoard" />
                            </div>
                            <div class="heart-cnt" :boardSeq="`${article.id}`" :authorSeq="`${article.userSeq}`"
                                @click="mvBoard">{{ article.likeCnt }}</div>
                            <div class="comment-icon-container" :boardSeq="`${article.boardSeq}`"
                                :authorSeq="`${article.userSeq}`" @click="mvBoard">
                                <img class="comment-icon" src="@/assets/icon/comment.png" alt="댓글"
                                    :boardSeq="`${article.boardSeq}`" :authorSeq="`${article.userSeq}`" @click="mvBoard" />
                            </div>
                            <div class="comment-cnt">{{ article.commentCnt }}</div>
                        </div>
                    </div>
                    <div class="article-container hidden" v-for="i in 4 - oneRow.length" :key="i" style="display: hidden;">
                    </div>
                </div>
                <InfiniteLoading @infinite="loadMore" target="#guestBookList">
                    <template #no-more>
                        <div class="infinite-end">
                            검색 결과를 모두 불러왔습니다!
                        </div>
                    </template>
                </InfiniteLoading>
            </div>
            <div class="whole-alticles" v-if="this.searchState == false">
                <div class="articles" id="guestBookList2" v-for="oneRow in this.chunkedResult2" :key="oneRow">
                    <div class="article-container" v-for="article in oneRow" :key="article"
                        :boardSeq="`${article.boardSeq}`" :authorSeq="`${article.writerSeq}`" @click="mvBoard">
                        <div class="represent-img-container" :boardSeq="`${article.boardSeq}`"
                            :authorSeq="`${article.writerSeq}`" @click="mvBoard">
                            <img class="represent-img" v-if="article.imgUrl == ''"
                                src="@/assets/KakaoTalk_20230116_110321475_05.jpg" alt="대표이미지"
                                :boardSeq="`${article.boardSeq}`" :authorSeq="`${article.writerSeq}`" @click="mvBoard" />
                            <img class="represent-img" v-if="article.imgUrl != ''" :src="`${article.imgUrl}`" alt="대표이미지"
                                :boardSeq="`${article.boardSeq}`" :authorSeq="`${article.writerSeq}`" @click="mvBoard" />
                        </div>
                        <div class="title" :boardSeq="`${article.boardSeq}`" :authorSeq="`${article.writerSeq}`"
                            @click="mvBoard">
                            {{ article.title }}
                        </div>
                        <div class="author" :boardSeq="`${article.boardSeq}`" :authorSeq="`${article.writerSeq}`"
                            @click="mvBoard">
                            by {{ article.writer }}
                        </div>
                        <div class="content" :boardSeq="`${article.boardSeq}`" :authorSeq="`${article.writerSeq}`"
                            @click="mvBoard">
                            {{ article.content }}
                        </div>
                        <hr width="92%">
                        <div class="sticker-and-comment" :boardSeq="`${article.boardSeq}`"
                            :authorSeq="`${article.writerSeq}`" @click="mvBoard">
                            <div class="heart-icon-container" :boardSeq="`${article.boardSeq}`"
                                :authorSeq="`${article.writerSeq}`" @click="mvBoard">
                                <img class="heart-icon" src="@/assets/icon/heart.png" alt="좋아요"
                                    :boardSeq="`${article.boardSeq}`" :authorSeq="`${article.writerSeq}`"
                                    @click="mvBoard" />
                            </div>
                            <div class="heart-cnt" :boardSeq="`${article.boardSeq}`" :authorSeq="`${article.writerSeq}`"
                                @click="mvBoard">{{ article.likeCnt }}</div>
                            <div class="comment-icon-container" :boardSeq="`${article.boardSeq}`"
                                :authorSeq="`${article.writerSeq}`" @click="mvBoard">
                                <img class="comment-icon" src="@/assets/icon/comment.png" alt="댓글"
                                    :boardSeq="`${article.boardSeq}`" :authorSeq="`${article.writerSeq}`"
                                    @click="mvBoard" />
                            </div>
                            <div class="comment-cnt">{{ article.commentCnt }}</div>
                        </div>
                    </div>
                    <div class="article-container hidden" v-for="i in 4 - oneRow.length" :key="i" style="display: hidden;">
                    </div>
                </div>
                <InfiniteLoading @infinite="loadMore2" target="#guestBookList2">
                    <template #no-more>
                        <div class="infinite-end">
                            검색 결과를 모두 불러왔습니다!
                        </div>
                    </template>
                </InfiniteLoading>
            </div>
        </div>
    </div>
</template>

<script >
import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue"
import http from "@/api/httpWithAccessToken"
// import { isProxy, toRaw } from 'vue';
import 'vue3-carousel/dist/carousel.css'
import { Carousel, Slide, } from 'vue3-carousel'
import InfiniteLoading from 'v3-infinite-loading';

export default {
    components: { UserTitleComp, Carousel, Slide, InfiniteLoading },
    data() {
        return {
            topKeywords: [],
            searchKeyword: null,
            searchResult: [],
            boardResult: [],
            searchDecisionKeyword: null,
            value: 0,
            busy: false,
            chunkedResult: [],
            value2: 0,
            busy2: false,
            chunkedResult2: [],
            searchState: false,
        }
    },
    methods: {
        mvBoard: function (e) {
            e.preventDefault();
            this.$router.push(`/board/${e.target.getAttribute('authorSeq')}/${e.target.getAttribute('boardSeq')}`)
            // console.log(e.target.getAttribute('authorSeq'))
            // console.log(e.target.getAttribute('boardSeq'))
        },
        chunk: function (data = [], size = 1) {
            const arr = [];
            for (let i = 0; i < data.length; i += size) {
                arr.push(data.slice(i, i + size));
            }
            return arr;
        },
        search: async function (e) {
            e.preventDefault();
            this.searchState = true;
            this.searchResult = [];
            this.searchKeyword = e.target.id;
            this.searchDecisionKeyword = e.target.id;
            this.value = 0;
            this.busy = true;
            http.get(
                `/board/searchByKeyword?keyword=${this.searchKeyword}&page=${this.value}`
            ).then((response) => {
                this.searchResult = response.data;
                // this.searchResult.concat(response.data);
                // console.log(this.searchResult)
                this.chunkedResult = this.chunk(this.searchResult, 4);
                console.log(this.chunkedResult);
                this.value += 1;
                if(this.searchResult.length < 18) {
                    this.busy = false;
                }
                else {
                    this.busy = true;
                }
            },
                (error) => {
                    console.log(error);
                }
            );
        },
        searchWithKeyword: async function () {
            this.searchState = true;
            this.searchResult = [];
            this.searchDecisionKeyword = this.searchKeyword;
            this.value = 0;
            this.busy = true;
            http.get(
                `/board/searchByKeyword?keyword=${this.searchKeyword}&page=${this.value}`
            ).then((response) => {
                this.searchResult = response.data;
                this.chunkedResult = this.chunk(this.searchResult, 4);
                this.value += 1;
                if(this.searchResult.length < 18) {
                    this.busy = false;
                }
                else {
                    this.busy = true;
                }
            },
                (error) => {
                    console.log(error);
                }
            );
        },
        loadMore: async function () {
            console.log(`HERE ${this.busy}`)
            if (!this.busy) {
                await http.get(
                    `/board/searchByKeyword?keyword=${this.searchKeyword}&page=${this.value}`
                ).then((response) => {
                    this.searchResult = this.searchResult.concat(response.data);  // 기존 데이터에 새로운 데이터 추가
                    this.busy = false;  // 데이터 로딩 상태 해제
                    this.value += 1;  // 다음 데이터를 가져오기 위해 start 값 증가
                    this.chunkedResult = this.chunk(this.searchResult, 4);
                    console.log(this.chunkedResult);
                },
                    (error) => {
                        console.log(error);
                        this.busy = false;
                    }
                );
            }
        },

        loadMore2: function () {
            console.log(this.value2)
            http.get(
                `/board/board-list-all?start=${this.value2}&size=12`
            ).then((response) => {
                console.log(response.data.boardList)
                this.boardResult = this.boardResult.concat(response.data.boardList);  // 기존 데이터에 새로운 데이터 추가
                this.busy2 = false;  // 데이터 로딩 상태 해제
                this.value2 += 1;  // 다음 데이터를 가져오기 위해 start 값 증가
                this.chunkedResult2 = this.chunk(this.boardResult, 4);
            },
                (error) => {
                    console.log(error);
                    // this.busy2 = false;
                }
            );
        },
    },
    created() {
        http.get(`/board/getTopTen`).then(
            (result) => {
                this.topKeywords = result.data;
                console.log(this.topKeywords);
            },
            (error) => {
                console.log(error);
                alert("인기 검색어 로드 실패!");
            }
        );
        // http.get(`/board/board-list-all?start=${this.value2}&size=10`).then((result) => {
        //     // this.value2 = 0;
        //     this.boardResult = result.data.boardList;
        //     this.chunkedResult2 = this.chunk(this.boardResult, 4);
        //     this.value2 += 1;
        // }, (error) => {
        //     console.log(error)
        // })
    }
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
    height: 70%;
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
    height: 45vh;
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
    border: 2px solid #D9D9D9;
    width: 90%;
    height: 60%;
    margin: 0 auto;
    margin-top: 2.5%;
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
}</style>
