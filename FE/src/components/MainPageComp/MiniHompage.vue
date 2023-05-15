<template>
    <div class="wrap">
        <UserTitleComp />
        <div class="right-body">
            <div class="story">
                <div class="select-story">
                    <!-- {{ this.story }} -->
                    <splide :options="options" class="slider">
                        <splide-slide class="splide-slide" v-for="stories in this.story" :key="stories">
                            <div class="one-slide">
                                <div :class="`story-element-container isRead_${oneStory.isRead}`"
                                    v-for="oneStory in stories" :key="oneStory" @click="showStoryInfo"
                                    :id="`${oneStory.storySeq}`">
                                    <img class="story-element" src="@/assets/KakaoTalk_20230116_110321475_05.jpg" alt="스토리"
                                        v-if="oneStory.imgUrl == ''" :id="`${oneStory.storySeq}`" />
                                    <img class="story-element" :src="`${oneStory.imgUrl}`" alt="스토리"
                                        v-if="oneStory.imgUrl != ''" :id="`${oneStory.storySeq}`" />
                                </div>
                                <div class="story-element-container" v-for="i in (10 - stories.length)" :key="i">
                                    <img class="story-element" src="@/assets/KakaoTalk_20230116_110321475_05.jpg" alt="스토리"
                                        hidden />
                                </div>
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
                <img class="room" src="@/assets/image/MiniRoom.png" />
            </div>
        </div>
    </div>
    <Teleport to="body">
        <modal :show="showModal" @close="showModal = false" :title="`${this.title}`" :author="`${this.author}`" :imgUrl="`${this.imgUrl}`" :boardSeq="`${this.boardSeq}`" :authorSeq="`${this.authorSeq}`">
            <template #header>
                <h3>custom header</h3>
            </template>
        </modal>
    </Teleport>
</template>

<script>
import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue"
import GrassComp from "@/components/MainPageComp/GrassComp.vue"
import FamilyComment from "@/components/MainPageComp/FamilyComment.vue"
import http from '@/api/httpWithAccessToken';
import httpStory from '@/api/httpStory';
import Modal from '@/components/MainPageComp/StoryModal.vue'

export default {
    components: { UserTitleComp, GrassComp, FamilyComment, Modal },
    data() {
        return {
            options: {
                type: 'slide',
                rewind: false,
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
            readStory: [],
            newStory: [],
            story: [],
            masterSeq: this.$route.params.userSeq,
            showModal: false,
            title: null,
            author: null,
            authorSeq: null,
            boardSeq: null,
            imgUrl: null,
        };
    },
    methods: {
        showStoryInfo: async function (e) {
            e.preventDefault();
            // console.log(e.target.id)
            httpStory.get(`/story/${e.target.id}`).then((result) => {
                console.log(result.data)
                this.title=result.data.title;
                this.author=result.data.nickname;
                this.boardSeq=result.data.boardSeq.toString();
                this.authorSeq=result.data.writerSeq.toString();
                this.imgUrl=result.data.imgUrl;
                this.showModal=true;
            }, (error) => {
                console.log(error)
            })
            
        }
    },
    created() {
        var userSeq = localStorage.getItem('user-seq');
        http.get(`/user/mainpage/${userSeq}`).then((result) => {
            this.avatraUrl = result.data.data.avatarUrl;
        }, (error) => {
            console.log(error);
        });
        httpStory.get(`/story/all/${this.masterSeq}`).then((result) => {
            console.log(result.data)
            this.readStory = result.data.readStory;
            this.newStory = result.data.newStory;
            var temp = []
            for (var i = 0; i < this.readStory.length + this.newStory.length; i++) {
                if (i % 10 == 9) {
                    this.story.push(temp);
                    temp = []
                }
                else {
                    if (i < this.newStory.length) {
                        temp.push(this.newStory[i])
                    }
                    else {
                        temp.push(this.readStory[i])
                    }
                }
            }
            this.story.push(temp);
        }, (error) => {
            console.log(error);
        })
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
    margin-top: 3vh;
    width: 90%;
    overflow: hidden;
}

.story-element-container {
    width: 65px;
    height: 65px;
    border-radius: 100%;
    margin: 0 8px;
    overflow: hidden;
}

.isRead_0 {
    border: 2px solid red;
}

.isRead_1 {
    border: 2px solid #D9D9D9;
    filter: grayscale(0.5);
}

.story-element {
    width: 100%;
    height: 100%;
    object-fit: fill;
    cursor: pointer;
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