<template>
    <div>
      <el-form :model="ruleForm"  ref="ruleForm" >
        <table align="center">
          <tr>
            <td>
            <el-form-item label=" ID" >
              <el-input type="text" v-model="ruleForm.id" readonly=""></el-input>
            </el-form-item>
              </td>
              <td>
            <el-form-item label="布料" >
              <el-select v-model="ruleForm.materials" placeholder="ruleForm.materials"@change="changeprice">
                <el-option v-for="item in cloth"
                           :key="item"
                           :label="item"
                           :value="item">
                  <span style="float: left">{{ item}}</span>
                </el-option>
              </el-select>
            </el-form-item>
            </td>
          </tr>
          <tr>
            <td>
              <el-form-item label="风格">
              <el-select v-model="ruleForm.styles" placeholder="ruleForm.style">
                <el-option v-for="items in styles"
                           :key="items"
                           :label="items"
                           :value="items">
                  <span style="float: left">{{ items}}</span>
                </el-option>
              </el-select>
              </el-form-item>
            </td>
              <td>
            <el-form-item label="尺寸" >
              <el-select v-model="ruleForm.size" placeholder="ruleForm.size">
                <el-option v-for="item in size"
                           :key="item"
                           :label="item"
                           :value="item">
                  <span style="float: left">{{ item}}</span>
                </el-option>
              </el-select>
            </el-form-item>
            </td>
          </tr>
          <tr>
            <td>
            <el-form-item label="颜色" >
              <el-select v-model="ruleForm.colors" placeholder="ruleForm.color">
                <el-option v-for="item in color"
                           :key="item"
                           :label="item"
                           :value="item">
                  <span style="float: left">{{ item}}</span>
                </el-option>
              </el-select>
            </el-form-item>
            </td>
              <td>
            <el-form-item label="性别" >
              <el-select v-model="ruleForm.sex" placeholder="ruleForm.sex">
                <el-option v-for="item in sex"
                           :key="item"
                           :label="item"
                           :value="item">
                  <span style="float: left">{{ item}}</span>
                </el-option>
              </el-select>
            </el-form-item>
            </td>
          </tr>
          <tr>
            <td>
            <el-form-item label="衣服类别" >
              <el-input type="text" v-model="ruleForm.clothes" readonly=""></el-input>
            </el-form-item>
              </td>
              <td>
            <el-form-item label="订单状态" >
              <el-input type="text" v-model="ruleForm.state" readonly=""></el-input>
            </el-form-item>
            </td>
            </tr>
          <tr>
            <td>
              <el-form-item label="备注" >
                <el-input type="text" v-model="ruleForm.remarks"></el-input>
              </el-form-item>
            </td>
            <td>
              <el-form-item label="服装价格" >
                <el-input type="text" v-model="ruleForm.price"></el-input>
              </el-form-item>
            </td>
          </tr>
          <tr>
            <el-form-item style="text-align: center">
              <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            </el-form-item>
          </tr>
        </table>
      </el-form>
    </div>
</template>

<script>
    export default {
        name: "updateorder",
      data(){
          return{
            styles:[],
            cloth:[],
            sex:["男","女"],
            size:["S","M","L","XL","XXL","XXXL"],
            color:[],
            ruleForm:{
              id:1,
              materials:'j',
              styles:'d',
              size:'d',
              colors:'d',
              sex:'d',
              clothes:'d',
              state:'d',
              remarks:'d',
              make:'',
              price:0,
              username:'hjhj'
            }
          }
      },
      methods:{
        submitForm(ruleForm){
          const _this=this
          console.log(this.$route.query.name)
          var fanhui=this.$route.query.name
          _this.$axios.put("http://localhost:8181/clothes/update",this.ruleForm).then(function (resp) {
            if(resp.data=="success"){
              console.log(fanhui)
              alert("修改成功")
              _this.$router.push({
                path:'/personalorder',
                query:{
                  fanhuiname:fanhui
                }
              })
            }
          })
        },
        resetForm(ruleForm){
          this.$refs[formName].resetFields();
        },
        changeprice(){
          const _this=this
          var buliao=this.ruleForm.materials
          console.log(buliao)
          _this.$axios.get("http://localhost:8181/pattern/price/"+buliao).then(function (resp) {
            console.log(resp.data)
            _this.ruleForm.price=resp.data;
          })
        }
      },
      created() {
        const _this=this
        console.log(this.$route.query.id)
        console.log(this.$route.query.name)
        _this.username=this.$route.query.name
        var id=this.$route.query.id
        _this.$axios.get("http://localhost:8181/clothes/findbyid/"+this.$route.query.id).then(function (resp) {
          console.log(resp.data)
          _this.ruleForm=resp.data
        })
        _this.$axios.get("http://localhost:8181/pattern/style").then(function (resp) {
          _this.styles=resp.data
          console.log(resp.data)
        })
        _this.$axios.get("http://localhost:8181/pattern/buliao").then(function (resp) {
          _this.cloth=resp.data
          console.log(resp.data)
        })
        _this.$axios.get("http://localhost:8181/pattern/color").then(function (resp) {
          _this.color=resp.data
          console.log(resp.data)
        })
      }
    }
</script>

<style scoped>

</style>
