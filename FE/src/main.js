import { createApp } from 'vue'
import App from './App.vue'
import {router} from './router/index.js'
import VueSplide from '@splidejs/vue-splide';

//createApp(App).mount('#app')

const app = createApp(App);
app.use(router)
app.use(VueSplide)
app.mount("#app")