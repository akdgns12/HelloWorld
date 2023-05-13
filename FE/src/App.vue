<template>
  <div id="app">
    <div style="margin-top: 50px;">
      <!-- <iframe src="https://www.youtube.com/embed/EkRuV-h6Bv0?autoplay=1&mute=1&loop=1 " title="YouTube video player"
      frameborder="0"
      height="25px"
      width="400px"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; web-share"></iframe>
      <embed src="http://www.youtube.com/v/EkRuV-h6Bv0?version=2&autoplay=1&mute=1&loop=1&playlist=EkRuV-h6Bv0&showinfo=0&modestbranding=0&disablekb=1&controls=1&rel=0" type="application/x-shockwave-flash" 
      width="500" height="40" autohide="0" /> -->
    </div>
    <router-view></router-view>
    <VueYtframe :video-id="`${this.videoId}`" height=0 width=0
      :player-vars="{ loop: 1, autoplay: 1, listType: 'user_uploads' }" v-if="this.userSeq != null" />
  </div>
</template>

<script>
import http from '@/api/httpWithAccessToken';
export default {
  name: 'App',
  components: {

  },
  data() {
    return {
      userSeq: localStorage.getItem('user-seq'),
      videoId: null,
    }
  },
  mounted() {
    // console.log(this.userSeq);
    http.get(`/user/mainpage/${this.userSeq}`).then((result) => {
      console.log(result.data.data.bgmList[0])
      this.videoId = result.data.data.bgmList[0].videoId;
    }, (error) => {
      console.log(error);
    });

  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Dongle:wght@300&display=swap');

/* embed {
  visibility: hidden;
} */

#app {
  /* font-family: 'Dongle', sans-serif; */
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
