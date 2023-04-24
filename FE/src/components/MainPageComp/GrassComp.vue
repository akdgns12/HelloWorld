<template>
    <svg class="grass" style="direction: ltr; margin-top: 4px;">
        <rect width="12" height="12" v-for="(grass, i) in grassInfo" :key="i" :x=17*parseInt(i/7) :y=15*(i%7) rx="2.5"
            stroke-width="0.5" fill="#82ACC1" :fill-opacity=0.25*(grass.boardList.length) 
            stroke="#D9D9D9" class="grass-element" :id=grass.createDate @mouseover="grassHovered">
            <title>HI</title>
        </rect>
    </svg>
</template>

<script>
export default {
    data() {
        return {
            grassInfo: [
                {'createDate' : '2023-04-16', 'boardList':[4, 12]},
                {'createDate' : '2023-04-17', 'boardList':[11,43,174,233]},
                {'createDate' : '2023-04-18', 'boardList':[]},
                {'createDate' : '2023-04-19', 'boardList':[1]},
                {'createDate' : '2023-04-20', 'boardList':[112]},
                {'createDate' : '2023-04-21', 'boardList':[114, 224]},
                {'createDate' : '2023-04-22', 'boardList':[333, 222]},
                {'createDate' : '2023-04-23', 'boardList':[444, 767, 235, 1522]},
                {'createDate' : '2023-04-24', 'boardList':[2, 3]},
            ],
            msg: "HI",
        }
    },
    methods: {
        grassHovered: function(e) {
            e.preventDefault();
            
            console.log(e.target.id);
            document.getElementById(e.target.id)
        }
    }
}
</script>


<style scoped>
.grass {
    width: 98%;
    height: 100%;
    margin: 0 auto;
}
</style>