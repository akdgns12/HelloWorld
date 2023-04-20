import { createRouter, createWebHistory } from "vue-router";
import BoardListView from "../views/BoardList.vue";
import GuestBookListView from "../views/GuestBookList.vue";
import LogIn from '@/views/UserView/login/LogIn.vue'
import LoginOption from '@/views/UserView/login/LoginOption.vue'
import RegisterUser from '@/views/UserView/register/RegisterUser.vue'
import PasswordSearch from '@/views/UserView/findpw/FindPassword.vue'
import MainPage from '@/views/MainPage.vue'
import RegisterCharacter from '@/views/UserView/register/RegisterCharacter.vue'
import ModifyUser from '@/views/UserView/modify/ModifyUser.vue'

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
    path: "/boardlist",
    component: BoardListView,
  },
  {
    path: "/guestbook",
    component: GuestBookListView,
  },
  {
    path: "/modify-user",
    name: "modify-user",
    component: ModifyUser,
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export { router };
