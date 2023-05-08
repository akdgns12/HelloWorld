<template>
    <div class="wrap">
        <!-- <div class="blank"></div> -->
        <UserTitleComp />
        <div class="right-body">
            <div class="community-notice">
                <form action="" class="search-bar">
                    <input type="search" name="search" pattern=".*\S.*" required>
                    
                    <button class="search-btn" type="submit">
                    </button>
                </form>

            </div>
            <div class="whole-alticles">
                <div class="articles">
                    <ArticleComp />
                    <ArticleComp />
                    <ArticleComp />
                    <ArticleComp />
                </div>
                <div class="articles">
                    <ArticleComp />
                    <ArticleComp />
                    <ArticleComp />
                    <ArticleComp />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue"
import ArticleComp from "@/components/CommunityComp/ArticleComp.vue"
import http from "@/api/httpWithAccessToken"

export default {
    components: { UserTitleComp, ArticleComp },
    methods: {
        getTopArticles: function () {
            http.get(`/board/board-list?start=0&size=8`).then(
                (response) => {
                    console.log(response);
                    return response;
                },
                (error) => {
                    console.log(error);
                    alert("인기 게시물 로드 실패!");
                }
            )
        }
    },
    mounted() {
        this.getTopArticles();
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
    /* font-weight: 600; */
    display: flex;
    justify-content: start;
    height: 11%;
    /* margin-left: 1%; */
}
.whole-alticles {
    width: 98%;
    margin: 0 auto;
    height: 84%;
    /* overflow: hidden; */
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


:root {
    font-size: calc(16px + (24 - 16)*(100vw - 320px)/(1920 - 320));
}

button,
input {
    font-size: 12px;
    line-height: 12px;
}

input {
    color: #171717;
}

.search-bar {
    display: flex;
}
.search-bar input,
.search-btn,
.search-btn:before,
.search-btn:after {
    transition: all 0.25s ease-out;
}

.search-bar input,
.search-btn {
    width: 2.5em;
    height: 2.5em;
}



.search-bar input:invalid:not(:focus),
.search-btn {
    cursor: pointer;
}

.search-bar,
.search-bar input:focus,
.search-bar input:valid {
    width: 50%;
}

.search-bar input:focus,
.search-bar input:valid {
    width: 80%;
    margin-left: 5%;
}

.search-bar input:focus,
.search-bar input:not(:focus)+.search-btn:focus {
    outline: transparent;
}

.search-bar {
    padding-top: 1.5em;
    justify-content: start;
    max-width: 30em;
}

.search-bar input {
    background: transparent;
    border-radius: 1.5em;
    box-shadow: 0 0 0 0.4em #171717 inset;
    padding: 0.2em;
    transform: translate(0.5em, 0.5em) scale(0.5);
    transform-origin: 100% 0;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
}

.search-bar input::-webkit-search-decoration {
    -webkit-appearance: none;
}

.search-bar input:focus,
.search-bar input:valid {
    background: #fff;
    border-radius: 0.375em 0 0 0.375em;
    box-shadow: 0 0 0 0.1em #d9d9d9 inset;
    transform: scale(1);
}

.search-btn {
    background: #171717;
    border-radius: 0 0.75em 0.75em 0 / 0 1.5em 1.5em 0;
    padding: 0.2em;
    position: relative;
    transform: translate(0.25em, 0.25em) rotate(45deg) scale(0.25, 0.125);
    transform-origin: 0 50%;
}

.search-btn:before,
.search-btn:after {
    content: "";
    display: block;
    opacity: 0;
    position: absolute;
}

.search-btn:before {
    border-radius: 50%;
    box-shadow: 0 0 0 0.2em #f1f1f1 inset;
    top: 0.5em;
    left: 0.5em;
    width: 1.2em;
    height: 1.2em;
}

.search-btn:after {
    background: #f1f1f1;
    border-radius: 0 0.25em 0.25em 0;
    top: 63%;
    left: 63%;
    width: 0.3em;
    height: 0.3em;
    transform: translate(0.2em, 0) rotate(45deg);
    transform-origin: 0 50%;
}

.search-btn span {
    display: inline-block;
    overflow: hidden;
    width: 1px;
    height: 1px;
}

/* Active state */
.search-bar input:focus+.search-btn,
.search-bar input:valid+.search-btn {
    background: #82ACC1;
    border-radius: 0 0.375em 0.375em 0;
    transform: scale(1);
}

.search-bar input:focus+.search-btn:before,
.search-bar input:focus+.search-btn:after,
.search-bar input:valid+.search-btn:before,
.search-bar input:valid+.search-btn:after {
    opacity: 1;
}

.search-bar input:focus+.search-btn:hover,
.search-bar input:valid+.search-btn:hover,
.search-bar input:valid:not(:focus)+.search-btn:focus {
    background: #82ACC1;
}

.search-bar input:focus+.search-btn:active,
.search-bar input:valid+.search-btn:active {
    transform: translateY(1px);
}

@media screen and (prefers-color-scheme: dark) {

    body,
    input {
        color: #f1f1f1;
    }

    body {
        background: #171717;
    }

    .search-bar input {
        box-shadow: 0 0 0 0.4em #f1f1f1 inset;
    }

    .search-bar input:focus,
    .search-bar input:valid {
        background: #3d3d3d;
        box-shadow: 0 0 0 0.1em #3d3d3d inset;
    }

    .search-btn {
        background: #f1f1f1;
    }
}</style>
