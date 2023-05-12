<template>
    <div style="width: 100%">
        <div class="my-post"># 내 포스팅</div>
        <div style="width: 80%; height: 70%;">
            <apexchart class="my-post-chart" width="100%" height="100%" :options="options" :series="series" :labels="labels">
            </apexchart>
        </div>
    </div>
</template>

<script>
import VueApexCharts from "vue3-apexcharts";
import http from '@/api/httpWithAccessToken'
export default {
    components: {
        apexchart: VueApexCharts,
    },
    data() {
        return {
            categoryInfo: null,
            categoryCount: [0, 0, 0, 0, 0],
            options: {
                chart: {
                    type: 'donut',
                    animations: {
                        enabled: true,
                        easing: 'easeinout',
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
                labels: ["CS", "Algorithm", "Project", "Language", "etc"],
                colors: ['#C18282', '#A1C182', '#82ACC1', '#8297C1', '#B882C1'],
                fill: {
                    colors: ['#C18282', '#A1C182', '#82ACC1', '#8297C1', '#B882C1']
                },
                plotOptions: {
                    pie: {
                        donut: {
                            labels: {
                                show: true,
                                total: {
                                    label: "전체 게시글",
                                    show: true,
                                    color: "#6A6A6A",
                                    fontWeight: 600,
                                },
                            },

                        }
                    }
                }
            },
            series: null,
        }
    },
    created() {
        var masterSeq = this.$route.params.userSeq;
        http.get(`/statistic/${masterSeq}?userSeq=${masterSeq}`).then((result) => {
            console.log(result.data.data.categoryInfo);
            this.categoryInfo = result.data.data.categoryInfo;
            for(var i = 0; i < this.categoryInfo.length; i++) {
                this.categoryCount[this.categoryInfo[i].categorySeq] = this.categoryInfo[i].count;
                // console.log(this.categoryInfo[i]);
            }
            console.log(this.categoryCount)
            this.series = this.categoryCount
        }, (error) => {
            console.log(error);
        })
    }
}
</script>

<style scoped>
.my-post {
    text-align: start;
    color: #6A6A6A;
    font-size: 16px;
    font-weight: 600;
    margin-left: 6%;
    margin-top: 5%;
    margin-bottom: 3%;
    width: 100%;
}

.my-post-chart {
    margin-left: 3%;
    text-align: start;
}
</style>