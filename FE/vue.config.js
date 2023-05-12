const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer : {
    proxy : {
      "/api" : {
        target : 'https://k8a308.p.ssafy.io',
        changeOrigin : true,
        logLevel : 'debug'
      },
    }
  }
})
