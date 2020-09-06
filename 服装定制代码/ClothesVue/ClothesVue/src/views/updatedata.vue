<template>
    <div>
      <el-form :model="ruleForm"  ref="ruleForm" >
        <table align="center">
          <tr>
            <el-form-item label="用  户 ID" >
              <el-input type="text" v-model="ruleForm.id" autocomplete="off" placeholder="输入用户id" readonly=""></el-input>
            </el-form-item>
            <el-form-item label="用  户 名" >
              <el-input type="text" v-model="ruleForm.name" autocomplete="off" placeholder="输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="手机号码">
              <el-input type="text" v-model="ruleForm.phone" autocomplete="off" placeholder="输入手机号码"></el-input>
            </el-form-item>
          </tr>
          <tr>
            <el-form-item label="密    码" >
              <el-input type="password" v-model="ruleForm.password" show-password="true" autocomplete="off" placeholder="输入密码"></el-input>
            </el-form-item>
          </tr>
          <tr>
            <el-form-item label="邮箱" >
              <el-input v-model="ruleForm.email" autocomplete="off" placeholder="输入邮箱"></el-input>
            </el-form-item>
          </tr>
          <tr>
            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </tr>
        </table>
      </el-form>
    </div>
</template>

<script>
    export default {
        name: "updatedata",
      data(){
          return{
            ruleForm: {
                id: '',
                name: '',
                phone: '',
                password: '',
                email: '',
              }
          }
      },
      methods:{
        submitForm(ruleForm){
          const _this=this
          _this.$axios.post("http://localhost:8181/user/update",this.ruleForm).then(function (resp) {
            if(resp.data="success"){
              alert("确认提交修改")
              _this.$router.push({path:'/'})
            }
          })
        },
        resetForm(ruleForm){
          this.$refs[formName].resetFields();
        }
      },
      created(){
          var username=this.$route.query.username
        console.log(this.$route.query.username)
          const _this=this
        _this.$axios.get("http://localhost:8181/user/info/"+username).then(function (resp) {
          console.log(resp.data)
          _this.ruleForm=resp.data
        })
      }
    }
</script>

<style scoped>

</style>
