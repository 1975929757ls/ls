<template>
  <div id="app">
    <!--<img src="./assets/logo.png">-->
    <!--<router-link to="/firstpage">Firstpage</router-link>-->
    <!--<router-link to="/"style="color: cyan" align="left">退出网站</router-link>-->
    <router-view/>
    <!--<button @click="pass">Firstpage</button>-->
  </div>
</template>

<script>
import ElLink from "element-ui/packages/link/src/main";
export default {
  name: 'App',
  components: {ElLink},
  methods:{
    pass(){
      this.$router.push({path:'/firstpage'})
    }

  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
</style>
