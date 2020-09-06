<template>
  <div class="imgbox" :style="{backgroundImage:'url('+img+')'}">
    <!--<viewer :images="signImages">-->
      <!--<ul>-->
        <!--<li v-for ="item_img in signImages" :key="item_img.id"@dblclick="open" style="float: left;list-style: none;padding-top: 20px">-->
          <!--<img class="demo-image" :src="item_img">-->
          <!--&lt;!&ndash;<img class="demo-image"v-for="src in signImages" :src="src" :key="src" >&ndash;&gt;-->
        <!--</li>-->
      <!--</ul>-->
    <!--</viewer>-->
    <h1>设计手稿</h1>
    <viewer :images="imageinfo.src">
      <ul>
        <li v-for ="item_img in imageinfo" :key="item_img.id"@dblclick="open(item_img)" style="float: left;list-style: none;padding-top: 20px">
          <img class="demo-image" :src="item_img.src">
          <el-button>修改</el-button>
        </li>
      </ul>
    </viewer>
  </div>
</template>

<script>
  import img1 from '@/image/img5.jpg'
  export default {
    name: 'HelloWorld',
    data(){
      return{
        img:img1,
        signImages:[
          {src:''}
        ],
        imageinfo:{
          src:'',
          id:0,
          info:''
        },
        info:'',
      }
    },
    methods: {
      open(item_img) {
        console.log("click")
          this.$alert(item_img.info, {
            confirmButtonText: '确定',
            callback: action => {
              this.$message({
                type: 'info',
                message: item_img.info
              });
            }
          });
      },
    },
    created(){
      const _this=this
      _this.$axios.get("http://localhost:8181/pic/find").then(function (resp) {
        console.log(resp.data)
        _this.signImages=resp.data
      })
      _this.$axios.get("http://localhost:8181/pic/all").then(function (resp) {
        console.log(resp.data)
        _this.imageinfo=resp.data
      })
    }
  }
</script>


<style scoped>
  .demo-image {
    width: 150px;
    height: 150px;
    margin-top: 10px;
  }
  .imgbox{
    width:100%;
    height: 900px;
    background-size: cover;
  }
</style>
