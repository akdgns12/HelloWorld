<template>
    <div class="wrap">
        <UserTitleComp />
        <div class="right-body">
            <div class="story">
                <div class="select-story">
                    <!-- {{ this.story }} -->
                    <splide :options="options" class="slider">
                        <splide-slide class="splide-slide">
                            <div class="one-slide" v-for="stories in this.story" :key="stories">
                                <div :class="`story-element-container-${oneStory.storySeq} isRead_${oneStory.isRead} story-element-container`"
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
                <img class="room" src="@/assets/image/room/room1.png" v-if="this.roomNum==1"/>
                <img class="room" src="@/assets/image/room/room2.png" v-if="this.roomNum==2"/>
                <img class="room" src="@/assets/image/room/room3.png" v-if="this.roomNum==3"/>
                <img class="room" src="@/assets/image/room/room4.png" v-if="this.roomNum==4"/>
            </div>
        </div>
    </div>
    <Teleport to="body">
        <modal :show="showModal" @close="showModal = false" :title="`${this.title}`" :author="`${this.author}`"
            :imgUrl="`${this.imgUrl}`" :boardSeq="`${this.boardSeq}`" :authorSeq="`${this.authorSeq}`">
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
            userSeq: localStorage.getItem('user-seq'),
            showModal: false,
            title: null,
            author: null,
            authorSeq: null,
            boardSeq: null,
            imgUrl: null,
            roomNum: 1,
        };
    },
    methods: {
        showStoryInfo: async function (e) {
            e.preventDefault();
            // console.log(e.target.id)
            console.log(`story-element-container-${e.target.id}`)
            var temp = e.target.closest('div');
            if (temp.classList.contains('isRead_0')) {
                temp.classList.remove(`isRead_0`);
                temp.classList.add(`isRead_1`);
            }
            console.log(document.getElementsByClassName(`story-element-container-${e.target.id}`));
            httpStory.get(`/story/${e.target.id}`).then((result) => {
                console.log(result.data)
                this.title = result.data.title;
                this.author = result.data.nickname;
                this.boardSeq = result.data.boardSeq.toString();
                this.authorSeq = result.data.writerSeq.toString();
                this.imgUrl = result.data.imgUrl;
                this.showModal = true;
            }, (error) => {
                console.log(error)
            })

        }
    },
    created() {
        // var userSeq = localStorage.getItem('user-seq');
        http.get(`/user/mainpage/${this.masterSeq}`).then((result) => {
            // this.avatarUrl = result.data.data.avatarUrl;
            console.log(result.data.data)
            if(result.data.data.likeCnt+result.data.data.understandCnt+result.data.data.helpfulCnt > 10 || result.data.data.today > 10) {
                this.roomNum = 2;
            }
            else if (result.data.data.likeCnt+result.data.data.understandCnt+result.data.data.helpfulCnt > 100 || result.data.data.today > 100) {
                this.roomNum = 3;
            }
            else if (result.data.data.likeCnt+result.data.data.understandCnt+result.data.data.helpfulCnt > 500 || result.data.data.today > 500) {
                this.roomNum = 4;
            }
        }, (error) => {
            console.log(error);
        });
        httpStory.get(`/story/all/${this.userSeq}`).then((result) => {
            this.readStory = result.data.readStory;
            this.newStory = result.data.newStory;
            console.log(this.newStory)
            console.log(this.readStory)
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
                        temp.push(this.readStory[i - this.newStory.length])
                    }
                }
            }
            this.story.push(temp);
            console.log(this.story)
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
    border: 1px solid #F6F6F6;
    border-radius: 5px;
    margin: 0 auto;
    margin-top: 5px;
    background-color: #F7F7F7;
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

}
</style>