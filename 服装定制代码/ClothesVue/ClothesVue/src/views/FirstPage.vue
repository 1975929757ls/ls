<template>
    <div>
      <div :style="{backgroundImage:'url('+images2+')'}">
        <el-page-header @back="goBack" content="首页">
        </el-page-header>
        <h1 >时尚经典  服装定制</h1>
      </div>
      <el-container style="height: 500px; border: 1px solid #eee ">
        <!--style="background-color: rgb(238, 241, 246)"-->
        <el-aside width="200px" :style="{backgroundImage: 'url('+images1+')'}">
          <el-row class="tac">
              <el-menu
                router :default-active="$route.path"
                default-active="2"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose">
                <el-submenu index="1">
                  <template slot="title">
                    <i class="el-icon-menu"></i>
                    <span>外套</span>
                  </template>
                  <el-menu-item-group>
                    <!--<template slot="title">外套</template>-->
                    <!--<el-menu-item index="item.id" @click="pass">{{item.overcoat}}</el-menu-item>-->
                    <el-menu-item v-for="item in coat"  :key="item" index="item.id"@click="pass">{{item.overcoat}}</el-menu-item>
                  </el-menu-item-group>
                  <!--<el-submenu index="1-4">-->
                    <!--<template slot="title">选项4</template>-->
                    <!--<el-menu-item index="1-4-1">选项1</el-menu-item>-->
                  <!--</el-submenu>-->
                </el-submenu>

                <el-submenu index="2">
                  <template slot="title">
                    <i class="el-icon-menu"></i>
                    <span>裤子</span>
                  </template>
                  <el-menu-item-group>
                    <!--<el-menu-item index="1-1" @click="pass">外套</el-menu-item>-->
                    <!--<el-menu-item index="1-2" @click="submit">裤子</el-menu-item>-->
                    <!--<el-menu-item index="1-3"@click="ps">裙子</el-menu-item>-->
                    <el-menu-item v-for="item in pant"  :key="item" index="item.id"@click="submit">{{item.trousers}}</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
              </el-menu>
          </el-row>
        </el-aside>
        <el-container>
          <el-header>
            <div style="text-align: right">
            <el-link type="primary" @click="personal">个人信息</el-link>
            <el-link type="primary" @click="order">个人订单</el-link>
            <!--<el-link type="primary" @click="f">test</el-link>-->
            <el-link type="primary" @click="chat">联系客服</el-link><br>
            </div>
            <h3>服装设计手稿</h3>
          </el-header>
          <el-main>
            <div>
              <viewer :images="imageinfo.src">
                <ul>
                  <li v-for ="item_img in imageinfo" :key="item_img.id"@dblclick="open(item_img)" style="float: left;list-style: none;padding-top:0px;width: 210px">
                    <img class="demo-image" :src="geturl(item_img)" alt="">
                  </li>
                </ul>
              </viewer>
            </div>
          </el-main>
          <el-footer></el-footer>
        </el-container>
      </el-container>
    </div>
</template>

<script>
  import img1 from '@/image/img1.jpg'
  import img2 from '@/image/img3.jpg'
    import ElLink from "element-ui/packages/link/src/main";
    import ElImage from "element-ui/packages/image/src/main";
    import TabBar from "element-ui/packages/tabs/src/tab-bar";
    import ElSlPanel from "element-ui/packages/color-picker/src/components/sv-panel";
    import ElPopover from "element-ui/packages/popover/src/main";
    import Vue from 'vue';
    import Viewer from 'v-viewer'
    import 'viewerjs/dist/viewer.css'
    Vue.use(Viewer);
    Viewer.setDefaults({
      Options: { "inline": true, "button": true, "navbar": true, "title": true, "toolbar": true, "tooltip": true, "movable": true, "zoomable": true, "rotatable": true, "scalable": true, "transition": true, "fullscreen": true, "keyboard": true, "url": "data-source"}
    });
    export default {
        // name: "FirstPage",
      components: {ElPopover, ElSlPanel, TabBar, ElImage, ElLink},
      data(){
        return {
          images2:img1,
          images1:img2,
          signImages:[],
          info:[],
          coat:[
            {
              id:1,
              overcoat:"夏季"
            },

            {
              id:2,
              overcoat:"春"
            },
            {
              id:3,
              overcoat:"秋"
            }
          ],
          pant:[
            {
              id:0,
              trousers:""
            }
          ],
          user: {
            name: '',
            password: '',
            id:'',
            stateopen:false,
            stateclose:false
          },
          imageinfo:{
            src:'',
            id:0,
            info:''
          },
        }
      },
      methods: {
          open(item_img) {
            console.log("click")
            // alert(item_img.info)
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
        geturl(item_img){
          var res=item_img.src
          var s1=(res||"").split("pic\\")[1]
          console.log(s1)
          let img=require('D:/files/pic/'+s1)
          return img
        },
        handleOpen(key, keyPath) {
          console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
          console.log(key, keyPath);
        },
        pass(){
          console.log(this.user.name)
          var test1=new Array()
          var i;
          for(i=0;i<this.coat.length;i++){
            test1[i]=this.coat[i].overcoat
          }
          // test1[0]="春秋薄款"
          // test1[1]="夏季防晒外套"
          // test1[2]="羽绒服"
          this.$router.push({path:'/clothes',query:{username:this.user.name,coat:test1}})
          // this.$router.push({path:'/waitao',query:{username:this.info}})
        },
        submit(){
          var test2=new Array()
          test2[0]="长裤"
          test2[1]="短裤"
          this.$router.push({path:'/clothes',query:{username:this.user.name,pants:test2}})
        },
        ps(){
          console.log(this.user.name)
          var test=new Array()
          var i;
          for(i=0;i<this.pant.length;i++){
            test[i]=this.pant[i].overcoat
          }
          this.$router.push({path:'/clothes',query:{username:this.user.name,firsttest:test}})
        },
        goBack() {
          console.log('go back');
          this.$router.push({path:'/'})
        },
        personal(){
          this.$router.push({path:'/personaldata',query:{name:this.user.name}})
        },
        order(){
          this.$router.push({path:'/personalorder',query:{name:this.user.name}})
        },
        f(){
          this.$router.push({path:'/test11'})
        },
        chat(){
          this.$router.push({path:'/chat',query:{name:this.user.name}})
        },
      },
      created() {
        console.log(this.$route.query.c+"测试传递参数")
        console.log(this.$route.query.fanhui+"测试传递参数")
        console.log(this.$route.query.fan+"测试传递参数")
        console.log(this.$route.query.fandelete+"测试传递参数")
        console.log(this.$route.query.updatename+"测试传递参数")
        if(this.$route.query.c!=null) {
          this.user.name = this.$route.query.c
          console.log(this.user.name)
        }else if(this.$route.query.fanhui!=null){
          this.user.name=this.$route.query.fanhui
        }else if(this.$route.query.fan!=null){
          this.user.name=this.$route.query.fan
        }
        else if(this.$route.query.chat!=null){
          this.user.name=this.$route.query.chat
        }
        else  if(this.$route.query.fandelete!=null){
          this.user.name=this.$route.query.fandelete
        }else {
          this.user.name=this.$route.query.updatename
        }
          const _this=this
          _this.$axios.get("http://localhost:8181/coat/find").then(function (resp) {
            console.log(resp.data)
            _this.coat=resp.data
          })
        _this.$axios.get("http://localhost:8181/pant/find").then(function (resp) {
          _this.pant=resp.data
        })
        _this.$axios.get("http://localhost:8181/pic/all").then(function (resp) {
          // console.log(resp.data)
          _this.imageinfo=resp.data
        })
      }
    }
</script>

<style>
  .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
.el-header{
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 20px;
}
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    /*background-color: #E9EEF3;*/
    background-color: floralwhite;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
  .demo-image{
    width: 180px;
    height: 200px;
   }
</style>
