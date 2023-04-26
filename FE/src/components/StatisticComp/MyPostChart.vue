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
export default {
    components: {
        apexchart: VueApexCharts,
    },
    data() {
        return {
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
                labels: ["CS", "Algorithm", "Project"],
                colors: ['#C18282', '#A1C182', '#82ACC1'],
                fill: {
                    colors: ['#C18282', '#A1C182', '#82ACC1']
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
            series: [10, 22, 31],
        }
    },
}
</script>

<style scoped>
.my-post {
    text-align: start;
    color: #6A6A6A;
    font-size: 18px;
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