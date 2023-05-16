import axios from "axios";

// axios 객체 생성
export default axios.create({
  baseURL: "https://k8a308.p.ssafy.io/notify",
  headers: {
    "Content-Type": "application/json;charset=utf-8",
    "Cache-Control": "no-cache",
    Authorization: `Bearer ${localStorage.getItem("access-token")}`,
  },
});

