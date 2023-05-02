<template>
    <nav id = "category">
        <ul>
            <li class="navitem">
                <router-link to="/mainpage" class="nav-link">홈</router-link>
            </li>
            <li class="navitem">
                <router-link to="/board" class="nav-link">게시글</router-link>
            </li>
            <li class="navitem">
                <router-link to="/community" class="nav-link">커뮤니티</router-link>
            </li>
            <li class="navitem">
                <router-link to="/guestbook" class="nav-link">방명록</router-link>
            </li>
            <li class="navitem">
                <router-link to="/statistic" class="nav-link">통계</router-link>
            </li>
        </ul>
    </nav>
</template>


<script>

</script>

<style scoped>
a {
    text-decoration: none;
    font-size: 10px;
    color: white;
    border: 1px solid #499DC6;
}
    #category {
        height: 72vh;
        margin-top : 4rem;
    }

    ul {
        list-style-type: none;
        padding : 0;
    }
    #category .navitem .nav-link {
        text-decoration: none;
        height : 5.5vh;
        width : 4.5vw;
        border-style: solid;
        border-radius : 0 1vw 1vw 0;
        border: 1px solid #6A6A6A;
        border-left : 0;
        margin-bottom : 1.5vh;
        background-color: #499DC6;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 1vw;
        color : white;
    }

    #category .navitem .router-link-active {
        background-color: white ;
        color : black !important;
        font-size : 1vw;
        font-weight: bold;
    }
</style>