<template>
    <div id="boardDetail">
        <UserTitleComp />
        <div id="Wrapper">
            <div id = "boardWrapper">
                <div id = "boardTitle">Git 이슈 정리</div>
                <div id = "boardInfo">
                    <p id="author">김싸피</p>
                    <p id="createdDate">2023.04.19 09:29</p>
                </div>
                <div class="temp">
                    <VMarkdownView 
                        :mode="mode"
                        v-model="content"
                        class="vm-view"
                    />
                </div>
                <div class="boardFooter">
                    <div class="checkSticker">
                        <p class="sticker">스티커</p>
                        <div class="sub_nav">
                            <p>좋아요</p>
                            <p style="padding : 0 0.3rem;">|</p>
                            <p>도움되요</p>
                            <p style="padding : 0 0.3rem;">|</p>
                            <p>이해가 쏙쏙되요</p>
                        </div>
                    </div>
                    <div id="boardUD">
                        <p id="boardShare">퍼가기</p>
                        <p>|</p>
                        <p id="boardUpdate">수정</p>
                        <p>|</p>
                        <p id="boardDelete">삭제</p>
                    </div>
                </div>
                <div id = "comment">
                    <CommentListComp />
                    <CommentCreateComp/>
                </div>
            </div>
        </div>
    </div>
</template>


<script setup>
import CommentListComp from '@/components/BoardComp/CommentComp/CommentListComp.vue'
import CommentCreateComp from '@/components/BoardComp/CommentComp/CommentCreateComp.vue'
import UserTitleComp from "../BasicComp/UserTitleComp.vue";
import { ref } from 'vue';
import { VMarkdownView }  from 'vue3-markdown';
import 'vue3-markdown/dist/style.css';
// import axios from 'axios';

const mode = ref('light');
const content = ref('');

// const headers = {
//     "Content-Type": "application/json;charset=utf-8",
//     Authorization: `Bearer ${localStorage.getItem("access-token")}`,
//   };


// const content = ref(`## Markdown Basic Syntax

// I just love **bold text**. Italicized text is the _cat's meow_. At the command prompt, type \`nano\`.

// My favorite markdown editor is [vue3-markdown](https://www.npmjs.com/package/vue3-markdown).

// 1. First item
// 2. Second item
// 3. Third item

// > Dorothy followed her through many of the beautiful rooms in her castle.

// \`\`\`js
// import { ref } from 'vue'
// import { VMarkdownEditor } from 'vue3-markdown'
// import 'vue3-markdown/dist/style.css'

// const handleUpload = (file) => {
//   console.log(file)
//   return 'https://i.postimg.cc/52qCzTVw/pngwing-com.png'
// }
// \`\`\`

// ## GFM Extended Syntax

// Automatic URL Linking: https://www.npmjs.com/package/vue3-markdown

// ~~The world is flat.~~ We now know that the world is round.

// - [x] Write the press release
// - [ ] Update the website
// - [ ] Contact the media

// | Syntax    | Description |
// | --------- | ----------- |
// | Header    | Title       |
// | Paragraph | Text        |

// ## Footnotes

// Here's a simple footnote,[^1] and here's a longer one.[^bignote]

// [^1]: This is the first footnote.
// [^bignote]: Here's one with multiple paragraphs and code.

//     Indent paragraphs to include them in the footnote.

//     \`{ my code }\`

//     Add as many paragraphs as you like.

// ## Math Equation

// Inline math equation: $a+b$

// `);


</script>

<style scoped>
    #boardDetail {
        overflow: hidden!important;
    }
    #Wrapper {
        height: 75vh;
        max-height: 75vh;
        width : 62vw;
        border: 1px solid #6A6A6A;
        border-radius : 15px;
        background-color: white;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #boardWrapper {
        height: 85%;
        width : 87%;
        overflow : scroll;
        overflow-x: hidden;
        /* overflow: hidden; */
        padding : 0 2% 0 2%;
    }
    #boardTitle {
        height: 1rem;
        background-color: #F2F2F2;
        display : flex;
        justify-content: center;
        align-items: center;
        font-size : 1.2rem;
        font-weight: bold;
        padding : 1%;
        border-style: solid;
        border-top-color: #E5E5E5;
        border-bottom-color: #E5E5E5;
        border-left: 0;
        border-right: 0;
    }
    #boardInfo {
        display : flex;
        height: 0.9rem;
        justify-content: space-between;
        align-items: center;
        padding : 1% 3% 1% 3%;
        background-color: #FAFAFA;
    }
    #author {
        color : #82ACC1;
        font-size : 0.9rem;
    }
    #createdDate {
        font-size : 0.8rem;
    }
    .vm-view{
        display: inline-block;
    vertical-align: top;
    overflow: auto;
    flex-grow: 1;
    flex-basis: 0;
    text-align: left;
    font-size: 14px;
    font-family: SFMono-Regular,Consolas,Liberation Mono,Menlo,monospace;
    padding: 0.8rem;
    } 
    .boardFooter{
        display : flex;
        flex-direction: row;
        justify-content: space-between;
        border-top : dashed black 1px;
        border-bottom : solid black 1px;
        margin : 2% 0 2% 0;
        padding : 0 2rem;
        font-size : 0.8rem;
    }
    .sticker {
        color : #D7AA71;
        font-weight: bold;
        cursor: pointer;
    }
    .checkSticker {
        display: flex;
        flex-direction : row;
        align-items: center;
    }

    .sub_nav {
        display: flex;
        flex-direction: row;
        margin-left : 1rem;
        visibility: hidden;
    }
    .sticker:hover > .sub_nav {
        visibility: visible;
        transition: visibility 0s, opacity 0.5s ease;
    }

    #boardUD {
        display : flex;
        flex-direction: row;
        width : 8rem;
        justify-content: space-between;
    }
    #boardUpdate, #boardDelete, #boardShare {
        color:#D7AA71;
        font-weight: bold;
        cursor: pointer;
    }

    #comment {
        background-color: #F0F0F0;
        display: flex;
        flex-direction: column;
        align-items: center;
        text-align :justify;
        padding : 1rem 0 0.5rem 0;
    }
</style>