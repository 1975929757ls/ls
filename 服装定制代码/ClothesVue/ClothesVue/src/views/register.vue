<template>
  <div>
  <h1>注册信息</h1>
    <el-form :model="ruleForm"  :rules="rules" ref="ruleForm" >
      <table align="center">
        <tr>
          <el-form-item label="用  户 名" prop="name">
            <el-input v-model="ruleForm.name"placeholder="输入用户名" clearable=""></el-input>
          </el-form-item>
          <el-form-item label="手机号码" prop="phone">
            <el-input type="text" v-model="ruleForm.phone" autocomplete="off" placeholder="输入手机号码"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="ruleForm.email"></el-input>
          </el-form-item>
        </tr>
        <tr>
      <el-form-item label="密    码" prop="pass">
        <el-input type="password" v-model="ruleForm.password" autocomplete="off" placeholder="输入密码"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="checkPass">
        <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
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
        name: "register",
      data() {
        var validatePass = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入密码'));
          } else {
            if (this.ruleForm.checkPass !== '') {
              this.$refs.ruleForm.validateField('checkPass');
            }
            callback();
          }
        };
        var validatePass2 = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请再次输入密码'));
          } else if (value !== this.ruleForm.password) {
            callback(new Error('两次输入密码不一致!'));
          } else {
            callback();
          }
        };
        // 手机号验证
        var checkPhone = (rule, value, callback) => {
          const phoneReg = /^1[3|4|5|6|7|8][0-9]{9}$/
          if (!value) {
            return callback(new Error('电话号码不能为空'))
          }
          setTimeout(() => {

            if (!Number.isInteger(+value)) {
              callback(new Error('请输入数字值'))
            } else {
              if (phoneReg.test(value)) {
                callback()
              } else {
                callback(new Error('电话号码格式不正确'))
              }
            }
          }, 100)
        };
        return {
          ruleForm: {
            name:'',
            phone:'',
            password: '',
            checkPass: '',
            email:'',
          },
          rules: {
            name:[
              { required: true, message: '请输入姓名', trigger: 'blur' },
              { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
            ],
            phone:[
              {required: true, validator: checkPhone, trigger: 'blur' }
            ],
            email: [
              { required: true, message: '请输入邮箱地址', trigger: 'blur' },
              { type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur' }
            ],
            password: [
              { validator: validatePass, trigger: 'blur' },

            ],
            checkPass: [
              { validator: validatePass2, trigger: 'blur' }
            ]
          }
        };

      },
      methods: {
        submitForm(formName) {
          const _this=this;
          this.$refs[formName].validate((valid) => {
            if (valid) {
              _this.$axios.post("http://localhost:8181/user/register",this.ruleForm).then(function (resp) {
                if(resp.data=="success"){
                  alert("确认提交");
                  _this.$router.push({path:'/'})
                }else{
                  alert("用户名已存在")
                }
              })
            } else {
              console.log('error submit!!');
              return false;
            }
          });
        },
        resetForm(formName) {
          this.$refs[formName].resetFields();
        }
      }
    }
</script>

<style scoped>

</style>
