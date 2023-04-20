<template>
    <div class="wrap">
        <div class="blank"></div>
        <UserTitleComp />
        <div class="right-body">
            <div class="story">
                <div class="select-story">
                    <splide :options="options" class="slider">
                        <splide-slide class="splide-slide">
                            <div class="one-slide">
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                            </div>
                        </splide-slide>
                        <splide-slide class="splide-slide">
                            <div class="one-slide">
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                                <div class="story-element-container"><img class="story-element"
                                        src="@/assets/image/Person.png" alt="스토리" /></div>
                            </div>
                        </splide-slide>
                    </splide>
                </div>
            </div>
            <div class="grass-container">
                <img class="grass" src="https://ghchart.rshah.org/songheewon" />
            </div>
            <div class="family-comment-container">
                <div class="family-comment-title">일촌평</div>
                <div class="comments">
                    <div class="comment">
                        <div class="comment-author">
                            이싸피 (싸피친구)
                        </div>
                        <div class="comment-content">
                            하이~ 오랜만에 놀러왔다
                        </div>
                        <div class="comment-created-time">
                            2023.04.13&nbsp;&nbsp;&nbsp;&nbsp;14:10
                        </div>
                    </div>
                    <div class="comment">
                        <div class="comment-author">
                            이싸피 (내평생의넘버원)
                        </div>
                        <div class="comment-content">
                            하이~ 오랜만에 놀러왔다하이~ 오랜만에 놀러왔다하이~ 오랜만에 놀러왔다하이~ 오랜만에 놀러왔다하이~ 오랜만에 놀러왔다하이~ 오랜만에 놀러왔다하이~ 오랜만에 놀러왔다하이~
                            오랜만에 놀러왔다하이~ 오랜만에 놀러왔다하이~ 오랜만에 놀러왔다하이~ 오랜만에 놀러왔다
                        </div>
                        <div class="comment-created-time">
                            2023.04.13&nbsp;&nbsp;&nbsp;&nbsp;14:10
                        </div>
                    </div>
                    <div class="comment">
                        <div class="comment-author">
                            이싸피 (싸피친구)
                        </div>
                        <div class="comment-content">
                            하이~ 오랜만에 놀러왔다
                        </div>
                        <div class="comment-created-time">
                            2023.04.13&nbsp;&nbsp;&nbsp;&nbsp;14:10
                        </div>
                    </div>
                    <div class="comment">
                        <div class="comment-author">
                            이싸피 (싸피친구)
                        </div>
                        <div class="comment-content">
                            하이~ 오랜만에 놀러왔다
                        </div>
                        <div class="comment-created-time">
                            2023.04.13&nbsp;&nbsp;&nbsp;&nbsp;14:10
                        </div>
                    </div>
                    <div class="comment">
                        <div class="comment-author">
                            이싸피 (싸피친구)
                        </div>
                        <div class="comment-content">
                            하이~ 오랜만에 놀러왔다
                        </div>
                        <div class="comment-created-time">
                            2023.04.13&nbsp;&nbsp;&nbsp;&nbsp;14:10
                        </div>
                    </div>
                </div>
                <div class="comment-input-container">
                    <div class="author-name">김싸피 (나)</div>
                    <input class="comment-input" placeholder="일촌평을 등록해보세요"/>
                    <div class="comment-post-btn">
                        등록
                    </div>
                </div>
            </div>
            <div class="room-container">
                <img class="room" src="@/assets/image/MiniRoom.png"/>
            </div>
        </div>
    </div>
</template>

<script>
import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue"

export default {
    components: { UserTitleComp },
    data() {
        return {
            options: {
                type: 'loop',
                rewind: true,
                perPage: 1,
                autoplay: false,
                pauseOnHover: false,
                arrows: true,
                dots: false,
                animatedDots: false,
                speed: 800,
                fixedWidth: '100%',
                padding: 10,
                pagination: false,
            },
        };
    },
}

</script>

<style scoped>
.blank {
    height: 23px;
}

.right-body {
    background-color: white;
    width: 62vw;
    height: 75vh;
    border: 1px solid #6A6A6A;
    border-radius: 15px;
}

.story {
    width: 98%;
    height: 13vh;
    margin: 0 auto;
    display: flex;
    justify-content: center;
}

.splide-slide {
    display: flex;
    height: 15vh;
}

.one-slide {
    margin: 0 auto;
    display: flex;
    justify-content: space-evenly;
    margin-top: 2.25vh;
}

.story-element-container {
    width: 50px;
    height: 50px;
    border-radius: 50%;
    border: 1px solid #6A6A6A;
    margin: 0 3px;
}

.story-element {
    width: 50px;
    height: 50px;
    object-fit: fill;
    cursor: pointer;
}

.story-element-container:hover {
    transform: scale(1.1);
    transition: 0.5s;
}

.grass-container {
    width: 95%;
    height: 20%;
    border: 1px solid #6A6A6A;
    border-radius: 5px;
    margin: 0 auto;
    margin-top: 5px;
}

.grass {
    width: 98%;
    height: 100%;
    margin: 0 auto;
}

.select-story {
    width: 100%;
}

.family-comment-container {
    width: 95%;
    height: 20%;
    border-radius: 5px;
    margin: 0 auto;
    margin-top: 5px;
    background-color: #F0F0F0;
}

.comments {
    height: 60%;
    overflow-y: scroll;
}

.family-comment-title {
    text-align: start;
    color: #6A6A6A;
    font-size: 10px;
    margin-left: 5px;
    margin-top: 3px;
    font-weight: bold;
    zoom: 0.9;
}

.comment {
    margin: 0 auto;
    margin-top: 2px;
    width: 100%;
    text-align: start;
    display: flex;
    font-size: 10px;
}

.comment-author {
    width: 11%;
    color: #82ACC1;
    margin-left: 5px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    zoom: 0.8;
    font-weight: bold;
    cursor: pointer;
}

.comment-author:hover {
    text-decoration: underline;
    text-decoration-color: #D9D9D9;
}

.comment-content {
    width: 70%;
    color: #6A6A6A;
    margin-left: 7px;
    zoom: 0.8;
}

.comment-created-time {
    color: #6A6A6A;
    margin-left: 10px;
    zoom: 0.8;
}

.comment-input-container {
    display: flex;
    font-size: 10px;
    margin-top: 3px;
    margin-bottom: 5px;
    width: 100%;
}

.comment-input::placeholder {
    color: #A5A5A5;
}

.author-name {
    width: 11%;
    color: #82ACC1;
    margin-left: 5px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    zoom: 0.8;
    font-weight: bold;
    text-align: end;
    margin-right: 5px;
}

.comment-input {
    font-size: 10px;
    zoom: 0.7;
    width: 69%;
    box-sizing: border-box;
    border: 1px solid #9A9A9A;
    background-color: #F5F5F5;
    box-shadow: 0.2px 0.4px #8C8C8C;
    border-radius: 3px;
}

.comment-post-btn {
    margin-left: 10px;
    background-color: #F9F9F9;
    color: #6A6A6A;
    font-size: 10px;
    padding: 1px 6px;
    zoom: 0.8;
    border-radius: 3px;
    font-weight: 600;
    box-shadow: 1px 0.8px #8C8C8C;
    cursor: pointer;
}

.room-container {
    width: 95%;
    height: 37%;
    border-radius: 5px;
    margin: 0 auto;
    margin-top: 5px;
}

.room {
    width: 100%;
    height: 100%;
    object-fit: fill;
}

.comments::-webkit-scrollbar {
    width: 6px;
    /*스크롤바의 너비*/
}

.comments::-webkit-scrollbar-thumb {
    background-color: #A3A3A3;
    border-radius: 3px;
}

.comments::-webkit-scrollbar-track {
    background-color: white;
    border-radius: 3px;
    border: 1.5px solid #6A6A6A;

}</style>