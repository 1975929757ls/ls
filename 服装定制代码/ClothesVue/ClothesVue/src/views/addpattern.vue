<template>
    <div>
      <el-form :model="ruleForm" ref="ruleForm" >
        <table align="center">
          <tr>
            <el-form-item label="添加服装布料">
              <el-input type="text" v-model="ruleForm.buliao" ></el-input>
            </el-form-item>
            <el-form-item label="设置价格">
              <el-input type="text" v-model="ruleForm.price"></el-input>
            </el-form-item>
            <el-form-item label="添加服装风格">
              <el-input type="text" v-model="ruleForm.style"></el-input>
            </el-form-item>
          </tr>
          <tr>
            <el-form-item label="添加服装颜色">
              <el-input type="text" v-model="ruleForm.color"></el-input>
            </el-form-item>
          </tr>
          <tr>
            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            </el-form-item>
          </tr>
        </table>
      </el-form>
    </div>
</template>

<script>
    export default {
        name: "addpattern",
      data(){
          return {
            ruleForm: {
              buliao:'',
              style:'',
              color:'',
              price:0,
            }
          }
      },
      methods:{
        submitForm(ruleForm){
          const _this=this
          _this.$axios.post("http://localhost:8181/pattern/addall",this.ruleForm).then(function (resp) {
            if(resp.data=="success"){
              alert("确认添加")
              _this.$router.push({path:'/pattern'})
            }else {
              alert("重新添加")
            }
          })
        }
      }
    }
</script>

<style scoped>

</style>
