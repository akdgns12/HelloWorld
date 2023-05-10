<template>
    <div class="wrap">
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
                <GrassComp />
            </div>
            <div class="family-comment-container">
                <FamilyComment />
            </div>
            <div class="room-container">
                <img class="room" src="@/assets/image/MiniRoom.png"/>
            </div>
        </div>
    </div>
</template>

<script>
import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue"
import GrassComp from "@/components/MainPageComp/GrassComp.vue"
import FamilyComment from "@/components/MainPageComp/FamilyComment.vue"
import http from '@/api/httpWithAccessToken';

export default {
    components: { UserTitleComp, GrassComp, FamilyComment },
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
            avatarUrl: null,
        };
    },
    created() {
        var userSeq = localStorage.getItem('user-seq');
        http.get(`/user/mainpage/${userSeq}`).then((result) => {
            this.avatraUrl = result.data.data.avatarUrl;
        }, (error)=>{
            console.log(error);
        });
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
    width: 90%;
    overflow: hidden;
}

.story-element-container {
    width: 70px;
    height: 70px;
    border-radius: 50%;
    border: 1px solid #6A6A6A;
    margin: 0 8px;
}

.story-element {
    width: 100%;
    height: 100%;
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