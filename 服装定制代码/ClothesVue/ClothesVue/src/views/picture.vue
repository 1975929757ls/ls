<template>
    <div>
      <el-page-header @back="goBack" content="首页">
      </el-page-header>
      <h1></h1>
      <viewer>
        <!--<img class="demo-image" :src="url">-->
        <img class="demo-image" :src="gets(imgsrc)">
      </viewer>
    </div>
</template>

<script>
    export default {
        name: "pic",
      data(){
          return{
            imgsrc:'',
            url:require("D:/files/pic/c43b0f334eb2b414175ddd6ca1546df0.jpg"),
            // url:require("D:/files/pic.03.jpg")
          }
      },
      methods:{
        goBack() {
          console.log('go back');
          this.$router.push({path:'/picmanage'})
        },
        gets(imgsrc){
          console.log(imgsrc)
          var s1=(imgsrc||"").split("pic\\")[1]
          console.log(s1)
          let img=require('D:/files/pic/'+s1)
          return img
        },
      },
      created(){
          const _this=this
        console.log(this.$route.query.src+"图片传递参数")
        var src=this.$route.query.src
        console.log(src)
        _this.imgsrc= src
      }
    }
</script>

<style scoped>
  .demo-image {
    width: 300px;
    height: 300px;
  }
</style>
