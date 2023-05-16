<template>
    <div class="wrap">
        <!-- <div class="blank"></div> -->
        <UserTitleComp />
        <div class="right-body">
            <div class="weekly-today"># 주간 TODAY</div>
            <apexchart class="weekly-today-chart" width="94%" height="35%" type="line" :options="options" :series="series">
            </apexchart>
            <div class="row">
                <MyPostChart />
                <div style="width: 100%">
                    <div class="my-achievement"># 내가 이룬 업적</div>
                    <div style="width: 80%; height: 70%;">
                        <div class="row-achievement">
                            <div class="achievement-container">
                                <img id="ten-sticker" class="achievement-element not-yet"
                                    src="@/assets/image/achievement/pixil-layer-1.png" alt="업적"
                                    v-tippy="{ content: '스티커 10개 달성', arrow: false, placement: 'top', }" />
                            </div>
                            <div class="achievement-container">
                                <img id="hundred-sticker" class="achievement-element not-yet"
                                    src="@/assets/image/achievement/pixil-layer-2.png" alt="업적"
                                    v-tippy="{ content: '스티커 100개 달성', arrow: false, placement: 'top', }" />
                            </div>
                            <div class="achievement-container">
                                <img id="thousand-sticker" class="achievement-element not-yet"
                                    src="@/assets/image/achievement/pixil-layer-3.png" alt="업적"
                                    v-tippy="{ content: '스티커 1000개 달성', arrow: false, placement: 'top', }" />
                            </div>
                            <div class="achievement-container">
                                <img id="ten-today" class="achievement-element not-yet" src="@/assets/image/achievement/pixil-layer-4.png"
                                    alt="업적" v-tippy="{ content: 'TOTAL 10 달성', arrow: false, placement: 'top', }" />
                            </div>
                        </div>
                        <div class="row-achievement">
                            <div class="achievement-container">
                                <img id="hundread-today" class="achievement-element not-yet" src="@/assets/image/achievement/pixil-layer-5.png"
                                    alt="업적" v-tippy="{ content: 'TOTAL 100 달성', arrow: false, placement: 'top', }" />
                            </div>
                            <div class="achievement-container">
                                <img  id="thousand-today" class="achievement-element not-yet" src="@/assets/image/achievement/pixil-layer-6.png"
                                    alt="업적" v-tippy="{ content: 'TOTAL 1000 달성', arrow: false, placement: 'top', }" />
                            </div>
                            <div class="achievement-container">
                                <img id="ten-post" class="achievement-element not-yet" src="@/assets/image/achievement/pixil-layer-7.png"
                                    alt="업적" v-tippy="{ content: '포스팅 10개 달성', arrow: false, placement: 'top', }" />
                            </div>
                            <div class="achievement-container">
                                <img id="hundred-post" class="achievement-element not-yet" src="@/assets/image/achievement/pixil-layer-8.png"
                                    alt="업적" v-tippy="{ content: '포스팅 100개 달성', arrow: false, placement: 'top', }" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import UserTitleComp from "@/components/BasicComp/UserTitleComp.vue"
import MyPostChart from "@/components/StatisticComp/MyPostChart.vue"
// import MyAchievement from "@/components/StatisticComp/MyAchievement.vue"
import VueApexCharts from "vue3-apexcharts";
import http from '@/api/httpWithAccessToken'

export default {
    components: { UserTitleComp, MyPostChart, apexchart: VueApexCharts },
    methods: {
        showAchievementInfo: function (e) {
            e.preventDefault();
            alert(e.target.className);
            console.log(e.target.className);
        }
    },
    created() {
        // var userSeq = localStorage.getItem('user-seq');
        var masterSeq = this.$route.params.userSeq;
        http.get(`/user/userInfo/${masterSeq}`).then((response)=> {
            if (response.data.data.total >= 10) {
                var tenToday = document.querySelector('#ten-today');
                tenToday.classList.remove('not-yet');
            }
            if (response.data.data.total >= 100) {
                var hundredToday = document.querySelector('#hundred-today');
                hundredToday.classList.remove('not-yet');
            }
            if (response.data.data.total >= 1000) {
                var thousandToday = document.querySelector('#thousand-today');
                thousandToday.classList.remove('not-yet');
            }
        }, (error) => {
            console.log(error)
        })
        http.get(`/statistic/${masterSeq}?userSeq=${masterSeq}`).then((response) => {
            console.log(response.data.data.categoryInfo);
            var postCnt = 0;
            for (var j = 0; j < response.data.data.categoryInfo.length; j++) {
                postCnt += response.data.data.categoryInfo[j].count;
            }
            if (postCnt >= 10) {
                var tenPosting = document.querySelector('#ten-post');
                tenPosting.classList.remove('not-yet');
            }
            if (postCnt >= 100) {
                var hundredPosting = document.querySelector('#hundred-post');
                hundredPosting.classList.remove('not-yet');
            }
            var temp = response.data.data.weeklyTodayInfoList;
            temp = temp.reverse();
            console.log(`엥??????${temp[0].date}`);
            for (var i = 0; i < 7; i++) {
                if (temp[i] != undefined) {
                    this.weeklyToday.push(temp[i].today);
                    this.weeklyDate.push(temp[i].date);
                }
                else {
                    this.weeklyToday.push(0);
                    this.weeklyDate.push("");
                }
            }
            this.weeklyToday = this.weeklyToday.reverse();
            this.weeklyDate = this.weeklyDate.reverse();
            this.options = {
                chart: {
                    toolbar: {
                        show: false,
                    },
                    zoom: {
                        enabled: false,
                    },
                    animations: {
                        enabled: true,
                        speed: 900,
                        animateGradually: {
                            enabled: true,
                            delay: 150
                        },
                        dynamicAnimation: {
                            enabled: true,
                            speed: 350
                        }
                    },
                },
                xaxis: {
                    categories: this.weeklyDate,
                },
                yaxis: [
                    {
                        labels: {
                            formatter: function (val) {
                                return val.toFixed(0);
                            }
                        }
                    }
                ],

                colors: ['#D9D9D9'],
                fill: {
                    type: 'gradient',
                    gradient: {
                        shadeIntensity: 1,
                        type: "vertical",
                        colorStops: [
                            { offset: 0, color: "#82ACC1", opacity: 1 },
                            { offset: 100, color: "#82ACC1", opacity: 1 }
                        ]
                    }
                }, plotOptions: {
                    bar: { columnWidth: '30%', endingShape: 'rounded', dataLabels: { position: 'center' } }
                },
                tooltip: {
                    enabled: true,
                    shared: false,
                    followCursor: true,
                    fillSeriesColor: true,
                    theme: 'light'
                },
                markers: {
                    size: 4,
                    colors: "#D9D9D9",
                    strokeColors: '#A5A5A5',
                    onClick: undefined,
                    onDblClick: undefined,
                },
            };
            this.series = [{ name: 'TODAY', data: this.weeklyToday }];


            this.likeCnt = response.data.data.likeCnt;
            this.helpfulCnt = response.data.data.helpfulCnt;
            this.understandCnt = response.data.data.understandCnt;
            var stickerCnt = this.likeCnt + this.helpfulCnt + this.understandCnt;
            if (stickerCnt >= 10) {
                var tenSticker = document.querySelector('#ten-sticker');
                tenSticker.classList.remove('not-yet');
            }
            if (stickerCnt >= 100) {
                var hundredSticker = document.querySelector('#hundred-sticker');
                hundredSticker.classList.remove('not-yet');
            }
            if (stickerCnt >= 1000) {
                var thousandSticker = document.querySelector('#thousand-sticker');
                thousandSticker.classList.remove('not-yet');
            }
        }, (error) => {
            console.log(error);
            alert("통계 내역 호출 중 오류 발생!");
        })
    },
    data() {
        return {
            weeklyToday: [],
            weeklyDate: [],
            likeCnt: null,
            helpfulCnt: null,
            understandCnt: null,
            options: {
                chart: {
                    toolbar: {
                        show: false,
                    },
                    zoom: {
                        enabled: false,
                    },
                    animations: {
                        enabled: true,
                        speed: 900,
                        animateGradually: {
                            enabled: true,
                            delay: 150
                        },
                        dynamicAnimation: {
                            enabled: true,
                            speed: 350
                        }
                    },
                },
                xaxis: {
                    categories: ['', '', '', '', '', '', ''],
                },
                yaxis: [
                    {
                        labels: {
                            formatter: function (val) {
                                return val.toFixed(0);
                            }
                        }
                    }
                ],
                colors: ['#D9D9D9'],
                fill: {
                    type: 'gradient',
                    gradient: {
                        shadeIntensity: 1,
                        type: "vertical",
                        colorStops: [
                            { offset: 0, color: "#82ACC1", opacity: 1 },
                            { offset: 100, color: "#82ACC1", opacity: 1 }
                        ]
                    }
                }, plotOptions: {
                    bar: { columnWidth: '30%', endingShape: 'rounded', dataLabels: { position: 'center' } }
                },
                tooltip: {
                    enabled: true,
                    shared: false,
                    followCursor: true,
                    fillSeriesColor: true,
                    theme: 'light'
                },
                markers: {
                    size: 4,
                    colors: "#D9D9D9",
                    strokeColors: '#A5A5A5',
                    onClick: undefined,
                    onDblClick: undefined,
                },
            },
            series: [{ name: 'TODAY', data: [0, 0, 0, 0, 0, 0, 0] }],

        }
    },
}

</script>

<style scoped>
.blank {
    height: 40px;
}

.right-body {
    background-color: white;
    width: 62vw;
    height: 75vh;
    border: 1px solid #6A6A6A;
    border-radius: 15px;
}

.row {
    /* width: 100%; */
    display: flex;
}

.weekly-today {
    text-align: start;
    color: #6A6A6A;
    font-size: 16px;
    font-weight: 600;
    margin-left: 3%;
    margin-top: 2%;
    margin-bottom: 3%;
}

.weekly-today-chart {
    margin-left: 3%;
}

.my-achievement {
    text-align: start;
    color: #6A6A6A;
    font-size: 16px;
    font-weight: 600;
    margin-top: 5%;
    margin-bottom: 3%;
    width: 100%;
}

.row-achievement {
    display: flex;
    width: 400px;
}

.achievement-container {
    width: 20%;
    height: 60%;
    border: 1px solid #D9D9D9;
    box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
    border-radius: 5px;
    margin: 6px;
}

.achievement-element {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.achievement-container:hover {
    border: 1px solid #6A6A6A;
    transform: scale(1.1);
    transition: .5s;
}

.achievement-element:hover {
    transform: scale(2);
    transition: .5s;
}

.not-yet {
    filter: grayscale(100%);
}</style>
