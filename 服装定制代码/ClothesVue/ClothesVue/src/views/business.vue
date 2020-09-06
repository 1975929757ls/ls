<template>
    <div class="imagess" :style="note">
      <el-page-header @back="goBack" content="后台">
      </el-page-header>
      <h1>后台管理</h1>
      <div class="line"></div>
      <el-menu
        :default-active="activeIndex2"
        class="el-menu-demo"
        mode="horizontal"
        @select=""
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-menu-item index="1" @click="usermanage">用户管理</el-menu-item>
        <el-menu-item index="3" @click="clothesmanage">服装管理</el-menu-item>
        <el-menu-item index="4"@click="ordermanage">订单管理</el-menu-item>
        <el-menu-item index="5"@click="ask">用户请求管理</el-menu-item>
        <el-submenu index="2">
          <template slot="title">手稿管理</template>
          <el-menu-item index="2-1"@click="design">管理信息</el-menu-item>
          <el-menu-item index="2-1"@click="add">添加手稿</el-menu-item>
        </el-submenu>
        <!--<el-menu-item index="4"><a href="http://localhost:8080/#/order" target="_blank">订单管理</a></el-menu-item>-->
      </el-menu>
      <!--<div>-->
        <!--<viewer :images="imageinfo.src">-->
          <!--<ul>-->
            <!--<li v-for ="item_img in imageinfo" :key="item_img.id"@dblclick="open(item_img)" style="float: left;list-style: none;padding-top: 20px">-->
              <!--<img class="demo-image" :src="item_img.src">-->
              <!--<el-button>修改</el-button>-->
            <!--</li>-->
          <!--</ul>-->
        <!--</viewer>-->
      <!--</div>-->
    </div>
</template>

<script>
  import img1 from '@/image/img2.jpg'
    export default {
        name: "business",
      data(){
          return{
            image:img1,
            activeIndex2:'1',
            imageinfo:{
              src:'',
              id:0,
              info:''
            },
            note: {
              backgroundImage: "url(" + require("@/image/img2.jpg") + ") ",
              backgroundPosition: "center center",
              backgroundRepeat: "no-repeat",
              backgroundSize: "cover",
              width:"100%",
              height:"100%",
            },
          }
      },
      methods:{
        goBack(){
          this.$router.push({path:'/'})
        },
        usermanage(){
          this.$router.push({path:'/user'})
        },
        ordermanage(){
          this.$router.push({path:'/order'})
        },
        clothesmanage(){
          this.$router.push({path:'/pattern'})
        },
        ask(){
          this.$router.push({path:'/information'})
        },
        design(){
          this.$router.push({path:'/picmanage'})
        },
        add(){
          this.$router.push({path:'/lod'})
        },
        open(item_img) {
          console.log("click")
          alert(item_img.info)
          var r
          for (r in this.info) {
            this.$alert(this.info[r], {
              confirmButtonText: '确定',
              callback: action => {
                this.$message({
                  type: 'info',
                  message: this.info[r]
                });
              }
            });
          }
        },
      },
      created(){
        const _this=this
        _this.$axios.get("http://localhost:8181/pic/all").then(function (resp) {
          console.log(resp.data)
          _this.imageinfo=resp.data
        })
      }
    }
</script>

<style scoped>
.imagess{
  background: no-repeat center;
  position: fixed;
  background-size:100% ,100%;
}
</style>
