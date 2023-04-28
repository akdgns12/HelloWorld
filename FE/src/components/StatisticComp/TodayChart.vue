<template>
    <div class="weekly-today"># 주간 TODAY</div>
    <apexchart class="weekly-today-chart" width="94%" height="35%" type="line" :options="options" :series="series">
    </apexchart>
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
                    categories: ['2023-04-19', '2023-04-20', '2023-04-21', '2023-04-22', '2023-04-23', '2023-04-24', '2023-04-25'],
                },
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
            series: [{ name: 'TODAY', data: [1, 5, 3, 1, 5, 0, 4] }],
        }
    },
}
</script>

<style scoped>
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
</style>