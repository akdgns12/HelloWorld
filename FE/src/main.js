import { createApp } from "vue";
//import store from './store';
import App from "./App.vue";
import { router } from "./router/index.js";
import VueSplide from "@splidejs/vue-splide";
import VueApexCharts from "vue3-apexcharts";
import { plugin as VueTippy } from "vue-tippy";
import "tippy.js/dist/tippy.css";
import timeago from 'vue-timeago3';
import { ko } from 'date-fns/locale';
import Tabs from 'vue3-tabs';

//createApp(App).mount('#app')

const app = createApp(App);
//app.use(store);
app.use(router);
app.use(VueSplide);
app.use(VueApexCharts);
const timeagoOptions = {
    converterOptions: {
        includeSeconds : true,
    },
    locale: ko,
}

app.use(
  VueTippy,
  // optional
  {
    directive: "tippy", // => v-tippy
    component: "tippy", // => <tippy/>
    componentSingleton: "tippy-singleton", // => <tippy-singleton/>,
    defaultProps: {
      placement: "auto-end",
      allowHTML: true,
    }, // => Global default options * see all props
  }
);
app.use(Tabs);
// app.component('apexChart', VueApexChart)

app.use(timeago, timeagoOptions)
app.mount("#app")
