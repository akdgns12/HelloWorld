<template>
    <div class="boardWrapper">
        <UserTitleComp/>
        <div class="shareWrapper">
            <ul class="shareBoardlist">
                <li v-for="(board, index) in boards" v-bind:key="index" class="shareBoard">
                    <div class="boardInfo">
                        <div class="boardHeader">
                            <span class="author">{{ board.author }}</span>
                            <span class="createdTime">{{ board.createdTime.slice(0, 10) }}</span>
                        </div>
                        <img src="@/assets/icon/drop_dots.png" alt="">
                    </div>
                    <div class="title">{{ board.title.length > 22 ? board.title.slice(0, 22) + '...' : board.title }}</div>
                    <div class="content">
                        <p>{{ board.content.length > 90 ? board.content.slice(0,90) + '...' : board.content }}</p>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
import UserTitleComp from "../BasicComp/UserTitleComp.vue";

export default {
    components : { UserTitleComp },
    data() {
        return {
            boards : [
                {title : 'CRA는 이제 그만!! 리액트 개발환경 직접 구축해보자!! (feat: webpack, babel)', content : '자유로운 리액트 React vs (Angular + Vue) Angular나 Vue는 웹 어플리케이션에서 제공하는 다양한 라이브러리를 제공한다. 하지만 React의 경우 UI 관련 기능만 제공한다. (전역 상태 관리, 라우팅, 빌드 시스템은 개발자가 직접 구축해야 된다) 전반적인 시스템을 직접 구축할 수 있어서 자유도가 높다는 장점 이 있는 동시에 개발환경을 직접 구축해야 한다는 단점이 존재한다. 우리는 이런 단점을 create-react-app이라는 툴을 사용하여 해당 단점을 보완할 수 있다.', boardSeq : 10, author : 'turtle601', createdTime : '2023-04-26T14:25:43.511+09:00'},
                {title : '코드 컨벤션이 뭐라고?', content : '코드 컨벤션(Code Convention) or 코딩 컨벤션 (Coding Convention) 내가 작성한 코드를 다른사람들도 쉽게 이해할 수 있게 가독성 있는 코드를 작성하는 법에 대한 규칙 노테이션(표기법,명명법) 코딩 시 변수명, 클래스명, 함수명, View, ID 등등 이름 명명에 쓰이는 표기법', boardSeq : 4, author : 'joosing', createdTime : '2023-04-25T18:25:43.511+09:00'},
                {title : 'Hello World 이녀석아~ 반갑다✋', content : '블로그를 시작하게 된 이유를 간단하게 적어보려고 한다. 공부한 내용, 에러, 새로운 지식 등등 그 순간은 중요하니까 기억해두자 하면서 시간 지나면 백지 → 똑같은 상황을 반복하게 됨 누군가에게 설명을 해줄 순간이 있는데, 머리속에 남아 있으면 좋지만 가끔 까먹을 때가 있고, 다 설명해도 상대방이 이해가 조금 덜 됐을 때, 참고 자료로 줄 수 있다. 프로젝트를 하면서 느낀점을 적어 놓고 싶었다. → 열심히 프로젝트 해 놓고 뭘 했었는지 기억을 못 해버려', boardSeq : 16, author : 'dbwjd5864', createdTime : '2021-04-26T10:25:43.511+09:00'},
                {title : 'HTML/CSS animation 최적화 기법', content : 'css에서 animation 이란? 애니메이션은 웹 페이지에서 요소들의 동작을 부드럽게 만들어주는 기능이다. 애니메이션을 사용하면 웹 페이지를 더 생동감 있게 꾸밀 수 있다. 사용자의 행동에 따라 움직이거나 변하는 등의 간단한 인터렉션을 할 수 있다는 장점이 있지만 너무 많이 사용하거나 복잡한 애니메이션을 적용하면 웹 페이지의 성능을 떨어뜨릴 수 있다는 단점이 있다.', boardSeq : 79, author : 'lucky', createdTime : '2021-04-26T10:25:43.511+09:00'},
                {title : '[우아한테크코스 FE 5기] 레벨2 다시, 점심 뭐 먹지 미션 회고', content : '이번 미션에서 리액트와의 첫 만남을 가졌다. 첫 만남인 만큼 어색했고 어려웠으나 리액트의 편리함 또한 느낄 수 있었던 미션이었다. 이제 컴포넌트를 만들 수는 있다. 하지만 ‘컴포넌트를 잘! 만드는 것’을 고민해야할 때라고 느꼈다. 잘 만들어진 컴포넌트의 특징은 역시 높은 ‘재사용성’과 ‘예측 가능성’이라고 생각한다. 다른 개발자가 봐도 사용하기 쉽도록 말이다.', boardSeq : 55, author : 'deepdev', createdTime : '2023-03-24T10:25:43.511+09:00'},
                {title : '당근마켓 지원 후기', content : '먼저 당근마켓 기업은 지역내 중고거래 플랫폼을 주 사업으로 하며 동네 가게, 동네 생활 등 "동네" 라는 키워드를 가지고 하이퍼 로컬 서비스를 꿈꾸고 있는 기업입니다. 저는 이런 당근마켓의 비전과 "우리는 함께 성장할 수 있다고 믿어요." 라는 성장에 관한 팀문화가 마음에 들어서 1학년때부터 눈독을 들이고 있었습니다. 😅 그렇게 눈독을 들이며 실력을 쌓았고 현재(19살, 취준생), 취준을 해야하는 시기가 찾아와서 당근마켓 프론트엔드 - 광고서비스 파트에 지원했습니다. 서류를 넣을 당시 에는 원티드 서류 불합격 지옥을 맛본 상태라서 반신반의 하며 서류를 넣었습니다 🥲 따라서 고등학생인 내가 과연 할 수 있을까 라는 마음가지게 했지만 2022 당근마켓 프론트엔드 개발자 Q&A 세션을 보고 신입이라도 기술적인 역량만 가지고 있으면 가능하다라는 개발자 분들의 말씀 덕분에 자신감을 가질 수 있었습니다.', boardSeq : 30, author : 'minn4646', createdTime : '2023-03-24T10:25:43.511+09:00'},
                {title : '카카오 Map Zoom Issue', content : '직접 하기 전에 React에서 Id 를 사용했을 때 문제점을 체크한 후, 실행에 옮기는 것이 좋아서 확인해보았다. React가 캡슐화와 재사용성을 중요시한다. 만약 같은 id를 가진 두 개의 컴포넌트가 있다면, DOM에는 중복 ID가 존재하게 되어 문제가 발생할 수 있다. 읽어보니 2개의 id만 작성하지 않으면 Virtual DOM에는 문제가 될 것이 없어보인다. 이제와서 생각해보면 React는 프레임워크가 아니라 라이브러리이기때문에 크게 문제될 것은 없없던거 같다. 검토를 거치고 카카오가 원하는 방향으로 작성하였다.', boardSeq : 46, author : 'haker337', createdTime : '2021-04-26T10:25:43.511+09:00'},
                {title : 'Hot한 이슈 ChatGPT 관련기사에 대해', content : '기사에 대해서 오늘은 내가 읽은 기사에 대해서 나의 생각과 이야기를 해보려고 한다. 먼저 내가 읽은 기사는 이 기사이다. 이 기사는 미국 연방거래위원회가 "ChatGPT와 같은 생성형 AI로 인하여 사기 등 소비자가 피해가 급증할것"이라고 이야기를 했다. ChatGPT는 미국 비영리 연구소 OpenAI에서 만든 대화형 AI 채팅봇이다. 지금도 엄청난 인기를 끌고 있고 검색엔진(구글, 네이버)에 대적하는 프로그램이 될 것같다', boardSeq : 89, author : 'psb7687465', createdTime : '2023-04-24T10:25:43.511+09:00'},
                {title : '뒤로 가기 방지', content : '발단 보안이나 데이터의 무결성을 위해서 뒤로가기를 막고 싶었다. 개인적으론 다음과 같은 방법이 있을 거라 생각한다. 구현 난이도가 지나치게 높거나 현실성이 없을 수도 있다고 생각하지만 혹시 지나가시다 눈에 띄신다면 조언 부탁드립니다. prop을 쥐어줘서 정상적인 루트의 접근이 아니라면 막는 방법 history자체를 지워서 뒤로가기 정상적으로 작동시키지 않는 방법 location의 state에 접근해서 처리하는 방법', boardSeq : 97, author : 'endmoseung', createdTime : '2023-03-24T10:25:43.511+09:00'},
                {title : '알고리즘을 대하는 자세', content : '자료구조 및 알고리즘을 공부하면서 또는 알고리즘 문제를 풀면서 가장 기본적이면서 가장 중요하다고 생각하는 부분입니다. 효율적으로 코딩 테스트 공부하는 방법 처음에는 주변에 잘하는 사람에게 물어보는 방식이 빠르게 실력이 늘 수 있습니다. 혼자 오래 고민하는 것은 힘만 빠지고 한계가 있을 것입니다. (혼자 고민하는 것은 최대 1 ~ 2시간까지만) 혼자 오래 고민하는 것은 이미 실력이 어느 정도 쌓인 후에 하는 것이 좋을 것같습니다.', boardSeq : 44, author : 'asdfasdf', createdTime : '2022-04-26T10:25:43.511+09:00'},
                {title : '왜 TBD 쓰세요?', content : 'Git을 이용해 개발할 때는 모두들 브랜칭 전략을 택하여 팀의 컨벤션으로 가져갑니다. 저는 git flow 와 gitlab flow, 그리고 TBD를 이용해 봤는데요, 지금은 TBD로 정착하여 회사와 사이드 프로젝트 모두에서 TBD를 이용하고 있습니다. 이번 글에서는 제가 TBD를 좋아하는 이유와 TBD의 장점에 대해 소개해보려 합니다.', boardSeq : 103, author : 'oneook', createdTime : '2023-04-24T10:25:43.511+09:00'},
                {title : 'Apple Pay를 연동하는 세 가지 방법', content : '3월 21일, 국내 iPhone 유저들이 오랫동안 기다려온 애플페이가 한국에 도착했는데요. 첫날에만 17만 명이나 가입했다는 소식도 있었죠. 앞으로 애플페이 사용자는 점점 늘어날 것으로 보여요. 단말기 제약이 있는 오프라인과 달리, 온라인에는 바로 애플페이를 연동할 수 있어요. 이번 포스트에서는 토스페이먼츠로 내 쇼핑몰에 애플페이를 연동할 수 있는 세 가지 방법을 알아볼게요.', boardSeq : 561, author : 'tosspayments', createdTime : '2022-04-26T10:25:43.511+09:00'},
                {title : 'React hook은 왜 컴포넌트 최상단에서만 동작할까?', content : 'React를 조금만이라도 공부해본 사람이 위 코드를 보게 되면 틀림없이 잘못된 코드라고 말할겁니다. 그 사람에게 저 코드가 왜 잘못됐냐고 물어보면 뭐라고 대답할까요? 장담은 못하겠지만 아마 많은 사람들이 "React에서 그렇게 쓰지 말래" 라고 말할것 같습니다 같은 사람에게 "왜 React에서 저렇게 쓰지 말래?" 라고 물어보면 이번에도 장담은 못하겠지만 아마도 "오... 그거까지는 모르겠는데...?" 라고 대답할것 같습니다.', boardSeq : 456, author : 'oneoneone', createdTime : '2022-04-26T10:25:43.511+09:00'},
                {title : 'Lambda 스케줄링으로 매일 아침 자동으로 노션 페이지 만들기', content : '저는 매일 아침 오늘의 할일과 메모, 배운것을 기록하기 위한 노션 페이지를 만듭니다. 그날 작성한 기록들은 하루를 마감할때 관련된 카테고리나 페이지로 재분류하는 방식으로 저만의 기록을 쌓고 있습니다. 단순한 일도 매일 하게 되면 까먹기도 하고, 귀찮아지기도 합니다. 저는 그리 부지런하지 않기 때문에 기록을 위한 데일리 노트 템플릿을 매일 아침 지정된 시간마다 자동으로 생성하기 위해 몇 가지 도구를 이용했습니다.', boardSeq : 774, author : '뚜잉뚜잉', createdTime : '2022-04-26T10:25:43.511+09:00'},
            ]
        }
    }
}
</script>


<style scoped>
    .boardWrapper {
        padding-top : 40px;
    }
    .shareWrapper {
        height: 75vh;
        width : 62vw;
        border: 1px solid #6A6A6A;
        border-radius : 15px;
        background-color: white;
        display : flex;
        justify-content: center;
        align-items: center;
    }
    .shareBoardlist {
        height : 90%;
        width : 100%;
        list-style: none;
        display : grid;
        grid-template-columns : 28vw 28vw;
        overflow-y:scroll;
        -ms-overflow-style: none; /* 인터넷 익스플로러 */
        scrollbar-width: none; /* 파이어폭스 */
    }
    .shareBoardlist::-webkit-scrollbar {
        display: none;
    }

    .shareBoard{
        border : 1px solid #D9D9D9;
        border-radius : 5px;
        margin : 1vw;
        padding : 1vw 1vh;
        /* height : 25vh; */
        height : 10rem;
        box-shadow: rgba(0,0,0,0.04) 0px 4px 16px 0px;
    }
    .boardInfo {
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
    .boardHeader {
        display: flex;
        margin : 1vh 2vw;
    }
    .author {
        color : #82ACC1;
        font-size: 0.7rem;
    }
    .createdTime {
        color : #c0c0c0;
        font-size : 0.6rem;
        padding : 0 0.5vh;           
    }

    .title {
        text-align: left;
        margin : 1vh 2vw;
        font-size : 1rem;
        font-weight : bold;
    }
    .content {
        font-size : 0.9rem;
        margin : 1vh 2vw;
        text-align:left;
    }
    img {
        height: 0.8rem;
        margin-right : 0.5rem;
        cursor: pointer;
    }
</style>