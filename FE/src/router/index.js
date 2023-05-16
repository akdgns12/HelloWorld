import { createRouter, createWebHistory } from "vue-router";
import BoardListView from "../views/BoardView/BoardList.vue";
import BoardCreateView from "../views/BoardView/BoardCreateView.vue";
import BoardDetailView from "../views/BoardView/BoardDetailView.vue";
import GuestBookListView from "../views/GuestBookList.vue";
import LogIn from '@/views/UserView/login/LogIn.vue'
import LoginOption from '@/views/UserView/login/LoginOption.vue'
import RegisterUser from '@/views/UserView/register/RegisterUser.vue'
import PasswordSearch from '@/views/UserView/findpw/FindPassword.vue'
import MainPage from '@/views/MainPage.vue'
import RegisterCharacter from '@/views/UserView/register/RegisterCharacter.vue'
import ModifyUser from '@/views/UserView/modify/ModifyUser.vue'
import Statistic from '@/views/StatisticView.vue'
import RedirectHandler from '@/views/UserView/login/RedirectHandle.vue'
import Community from '@/views/CommunityView.vue';
import ModifyAvatar from '@/components/UserComp/UserAvatarModify.vue'
import MyFamilyView from '@/views/MyFamilyView.vue'


const routes = [
  {
    path: "/",
    name: "before-login",
    component: LoginOption,
  },
  {
    path: "/login",
    name: "login",
    component: LogIn,
  },
  {
    path: "/join",
    name: "join",
    component: RegisterUser,
    props: true,
  },
  {
    path: "/register-character",
    name: "register-character",
    component: RegisterCharacter,
    props: true,
  },
  {
    path: "/find-pw",
    name: "find-password",
    component: PasswordSearch,
  },
  {
    path: "/mainpage/:userSeq",
    name: "mainpage",
    component: MainPage,
  },
  {
    path: "/board/:userSeq/boardlist/:category",
    name : 'boardlist',
    component: BoardListView
  },
  {
    path : "/board/:userSeq/create/:boardSeq?",
    component : BoardCreateView,
  },
  {
    path : '/board/:userSeq/:boardSeq',
    name: 'board-detail',
    component : BoardDetailView,
  },
  {
    path: "/guestbook/:userSeq",
    component: GuestBookListView,
  },
  {
    path: "/modify-user/:userSeq",
    name: "modify-user",
    component: ModifyUser,
  },
  {
    path: "/statistic/:userSeq",
    name: "statistic",
    component: Statistic,
  },
  {
    path: "/modify-avatar",
    name: "modify-avatar",
    component: ModifyAvatar,
  },
  {
    path: "/redirect-handler",
    name: "redirect-handler",
    component: RedirectHandler,
  },
  {
    path: "/community/:userSeq",
    name: "community",
    component: Community,
  },
  {
    path: "/my-family/:userSeq",
    name: "my-family",
    component: MyFamilyView,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export { router };
