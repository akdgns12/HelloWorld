<template>
    <svg class="grass" style="direction: ltr; margin-top: 4px;">
        <rect width="1.5%" height="10.15%" v-for="(grass, i) in grassInfo" :key="i" :x=17*parseInt(i/7) :y=15*(i%7) rx="2.5"
            stroke-width="0.5" fill="#82ACC1" :fill-opacity=0.25*(grass.boardList.length) 
            stroke="#6A6A6A" class="grass-element" :id=grass.grassDate @click="dateDetail" :boardList=grass.boardList
            v-tippy="{ content: `${grass.grassDate} 게시글 ${grass.boardList.length}개 작성`, arrow: false, placement: 'right' }">
        </rect>
    </svg>
    <Teleport to="body">
        <modal :show="showModal" @close="showModal = false" :date="date" :boardInfo="boardInfo">
            <template #header>
                <h3>custom header</h3>
            </template>
        </modal>
    </Teleport>
</template>

<script>
import Modal from '@/components/MainPageComp/GrassModal.vue'
import http from '@/api/httpWithAccessToken'
export default {
    components: {Modal,},
    data() {
        return {
            grassInfo: null,
            showModal: false,
            date: null,
            detailBoardList: null,
            masterSeq: this.$route.params.userSeq,
            boardInfo: [],
        }
    },
    created() {
        http.get(`/user/mainpage/${this.masterSeq}`).then((result) => {
            this.grassInfo = result.data.data.grassList.slice(2,);
        }, (error)=>{
            console.log(error);
        });
    },
    methods: {
        dateDetail: async function(e) {
            e.preventDefault();
            this.date = e.target.id;
            this.detailBoardList = await e.target.getAttribute("boardList").split(",");
            this.boardInfo = [];
            if(this.detailBoardList[0].length !=0) {
            for(var i = 0; i < this.detailBoardList.length; i++) {
                
            await http.get(`/board?userSeq=${this.masterSeq}&boardSeq=${this.detailBoardList[i]}`).then((result) => {
                this.boardInfo.push(result.data)
                // console.log(result.data)
            }, (error) => {
                console.log(error)
            })
        }
    }
            console.log(this.boardInfo);
            this.showModal = true;
        }
    }
}
</script>


<style scoped>
.grass {
    width: 97.5%;
    height: 100%;
    margin: 0 auto;
}
</style>