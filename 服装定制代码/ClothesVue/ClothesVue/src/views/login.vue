<template>
    <div class="img":style="note">
        <h1>服装定制</h1>
      <div>
        <el-form :model="user":rules="rules" ref="user">
        <table align="right" style="width: 400px">
        <tr>
        <el-form-item label="用户名" prop="name">
          <el-input  type="text" v-model="user.name" placeholder="输入用户名"></el-input>
        </el-form-item>
        </tr>
        <tr>
        <el-form-item label="密  码" prop="password">
          <el-input type="password"  show-password="true" v-model="user.password"></el-input>
        </el-form-item>
        </tr>
          <tr>
            <input type="text" placeholder="请输入验证码" class="yanzhengma_input" @blur="checkLpicma" v-model="picLyanzhengma">
            <input type="button" id="code" @click="createCode"  class="verification1" v-model="checkCode"/> <br>
            <span class="tishixiaoxi disappear">请输入验证码。</span>
          </tr>
        <tr>
        <el-button type="submit" @click="dologin('user')">用户登录</el-button>
        <el-button type="submit" @click="business('user')">商家登录</el-button>
        <el-button @click="resetForm('user')">重置</el-button>
        <el-button type="submit" @click="register">注册</el-button>
        <!--<el-button type="submit" @click="load">tou</el-button>-->
        <!--<el-button type="submit" @click="imgs">img</el-button>-->
        </tr>
        </table>
        </el-form>
      </div>
    </div>
</template>

<script>
  var code ;
  import img1 from '@/image/back1.jpg'
  export default {
        name: "login",
      data() {
          return{
            images:img1,
            picLyanzhengma:'',
            checkCode:'',
            note: {
              backgroundImage: "url(" + require("@/image/back1.jpg") + ") ",
              backgroundPosition: "center center",
              backgroundRepeat: "no-repeat",
              backgroundSize: "cover",
              width:"100%",
              height:"100%",
            },
            user:{
              name: '',
              password: ''
            },
            rules:{
              name:[
                // { required: true, message: '请输入用户名' },
                // { min: 1, max: 10, message: '长度在 3 到 10个字符' }
              ],
              password:[
                { required: true, message: '请输入密码', trigger: 'blur' },
                { min: 3, max: 10, message: '长度在 3 到 10个字符', trigger: 'blur' }
              ]
            }
          }
      },
      methods:{
        // 图片验证码
        createCode(){
          code = "";
          var codeLength = 4;//验证码的长度
          var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V','W','X','Y','Z');//随机数
          for(var i = 0; i < codeLength; i++) {//循环操作
            var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）
            code += random[index];//根据索引取得随机数加到code上
          }
          this.checkCode = code;//把code值赋给验证码
        },
        // 失焦验证图和密码
        checkLpicma(){

          this.picLyanzhengma.toUpperCase();//取得输入的验证码并转化为大写
          if(this.picLyanzhengma == '') {
            $(".login_content1 span:eq(2)").text("请输入验证码")
            $(".login_content1 span:eq(2)").removeClass("disappear");

          }else if(this.picLyanzhengma.toUpperCase() != this.checkCode ) { //若输入的验证码与产生的验证码不一致时
            console.log( this.picLyanzhengma.toUpperCase())
            console.log(code)
            $(".login_content1 span:eq(2)").text("验证码不正确")
            $(".login_content1 span:eq(2)").removeClass("disappear");
            this.createCode();//刷新验证码
            this.picLyanzhengma = '';
          }else { //输入正确时
            $(".login_content1 span:eq(2)").addClass("disappear");
            $(".login_content1 span:eq(2)").text("请输入验证码")
            return true;
          }
        },
          dologin(user){
          if(this.checkLpicma()==true){
            const _this=this
            this.$refs[user].validate((valid)=>{
              if(valid){
                console.log(_this.user);
                this.$axios.post('http://localhost:8181/user/login',this.user).then(function (resp) {
                  if(resp.data=="success"){
                    console.log(resp+"you are right");
                    _this.$router.push({path:'/firstpage',query:{c:_this.user.name}})
                  }else{
                    alert("密码或账号错误，重新登录");
                  }
                })
              }
            });
          }else {
            alert("输入验证码")
          }

        },
        load(){
          this.$router.push({path:'/lod'})
        },
        imgs(){
          this.$router.push({path:'/design'})
        },
        business(user){
          if(this.checkLpicma()==true){
            const _this=this
            this.$refs[user].validate((valid)=>{
              if(valid){
                console.log(_this.user);
                this.$axios.post('http://localhost:8181/admin/pass',this.user).then(function (resp) {
                  if(resp.data=="success"){
                    _this.$router.push({path:'/business'})
                  }else{
                    alert("密码或账号错误，重新登录");
                  }
                })
              }
            });
          }else {
            alert("输入验证码")
          }

        },
        resetForm(user){
          this.$refs[user].resetFields();
        },
        register(){
          this.$router.push({path:'/register'})
        }
      },
      created(){
        this.createCode();
      }
    }
</script>

<style scoped>
  .img{
    background: no-repeat center;
    position: fixed;
    background-size:contain ;
  }
  .tishixiaoxi{
    font-size: 14px;
    color:#ed711f;
    display: block;
    margin-left: 30px;
    line-height: 20px;

  }
  .yanzhengma_input{
    width: 250px;
    height: 30px;
  }
  .disappear{
    visibility:hidden;
  }
  .verification1{
    vertical-align: middle;
    transform: translate(15px,0);
    width: 120px;
  }
  #code{
    font-size: 18px;
    letter-spacing:3px;
    color: #053d84;
    background: #f2f2f5;
  }

</style>
