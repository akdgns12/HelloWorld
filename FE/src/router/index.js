import { createRouter, createWebHistory } from "vue-router";
import BoardListView from "../views/BoardList.vue";
import BoardCreateView from "../views/BoardCreateView.vue";
import BoardDetailView from "../views/BoardDetailView.vue";
import GuestBookListView from "../views/GuestBookList.vue";
import LogIn from '@/components/user/login/LogIn.vue'
import LoginOption from '@/components/user/login/LoginOption.vue'
import RegisterUser from '@/components/user/register/RegisterUser.vue'
import PasswordSearch from '@/components/user/findpw/FindPassword.vue'
import MainPage from '@/components/mainpage/MainPage.vue'
import RegisterCharacter from '@/components/user/register/RegisterCharacter.vue'

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
  },
  {
    path: "/register-character",
    name: "register-character",
    component: RegisterCharacter,
  },
  {
    path: "/find-pw",
    name: "find-password",
    component: PasswordSearch,
  },
  {
    path: "/mainpage",
    name: "mainpage",
    component: MainPage,
  },
  {
    path: "/board",
    component: BoardListView
  },
  {
    path : "/board/create",
    component : BoardCreateView,
  },
  {
    path : '/board/detail',
    component : BoardDetailView,
  },
  {
    path: "/guestbook",
    component: GuestBookListView,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export { router };
