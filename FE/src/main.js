import { createApp } from 'vue'
import App from './App.vue'
import {router} from './router/index.js'
import VueSplide from '@splidejs/vue-splide';
import timeago from 'vue-timeago3';
import { ko } from 'date-fns/locale';

//createApp(App).mount('#app')

const app = createApp(App);
const timeagoOptions = {
    converterOptions: {
        includeSeconds : true,
    },
    locale: ko,
}

app.use(router)
app.use(VueSplide)
app.use(timeago, timeagoOptions)
app.mount("#app")