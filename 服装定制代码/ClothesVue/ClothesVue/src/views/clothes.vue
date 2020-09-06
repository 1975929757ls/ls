<template>
  <div style="text-align: center">
    <h1>服装选择</h1>
    <el-form :model="values">
      <table style="margin: auto">
        <tr>
          <td>
            <el-form-item label="服装风格">
        <el-select v-model="values.style" placeholder="请选择服装风格">
          <el-option
            v-for="item in styles"
            :key="item"
            :label="item"
            :value="item">
            <span style="float: left">{{ item}}</span>
            <!--<span style="float: right; color: #8492a6; font-size: 13px">{{ item.value }}</span>-->
          </el-option>
        </el-select>
            </el-form-item>
         </td>
          <td>
            <el-form-item label="服装衣料">
        <el-select v-model="values.materials" placeholder="请选择服装衣料" @change="chagetest()">
          <el-option
            v-for="item in cloth"
            :key="item"
            :label="item"
            :value="item">
            <span style="float: left">{{ item}}</span>
            <!--<span style="float: right; color: #8492a6; font-size: 13px">{{ item.value }}</span>-->
          </el-option>
        </el-select>
            </el-form-item>
          </td>
        </tr>
        <tr>
          <td>
            <el-form-item label="服装颜色">
        <el-select v-model="values.color" placeholder="请选择服装颜色">
          <el-option
            v-for="item in color"
            :key="item"
            :label="item"
            :value="item">
            <span style="float: left">{{ item}}</span>
            <!--<span style="float: right; color: #8492a6; font-size: 13px">{{ item.value }}</span>-->
          </el-option>
        </el-select>
            </el-form-item>
          </td>
          <td>
            <el-form-item label="服装尺寸">
        <el-select v-model="values.size" placeholder="请选择服装尺寸">
          <el-option
            v-for="item in sizeresult"
            :key="item"
            :label="item"
            :value="item">
            <span style="float: left">{{ item}}</span>
            <!--<span style="float: right; color: #8492a6; font-size: 13px">{{ item.value }}</span>-->
          </el-option>
        </el-select>
            </el-form-item>
          </td>
        </tr>
        <tr>
          <td>
            <el-form-item label="性别">
        <el-select v-model="values.sex" placeholder="请选性别">
          <el-option
            v-for="item in sexresult"
            :key="item"
            :label="item"
            :value="item">
            <span style="float: left">{{ item}}</span>
            <!--<span style="float: right; color: #8492a6; font-size: 13px">{{ item.value }}</span>-->
          </el-option>
        </el-select>
            </el-form-item>
          </td>
          <td>
            <el-form-item label="服装类别">
        <el-select v-model="values.clothes" placeholder="请选择衣服" >
          <el-option
            v-for="item in clothesselect"
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
        <el-form-item label="备注信息">
          <el-input type="text" v-model="values.remarks"></el-input>
        </el-form-item>
          </td>
          <td>
            <el-form-item label="服装价格">
        <el-input  type="text" v-model="values.price"></el-input>
            </el-form-item>
          </td>
        </tr>
        <el-button type="primary" @click="pass('values')">提交</el-button>
      </table>
    </el-form>
  </div>
</template>

<script>
    export default {
        name: "nanwaitao",
      data() {
        return {
          clothesselect:[],
          styles:[],
          cloth:[],
          color:[],
          sexresult:["男","女"],
          sizeresult:["S","M","L","XL","XXL","XXXL"],
          values: {
            materials: '',
            style:'',
            size:'',
            color:'',
            sex:'',
            clothes:'',
            remarks:'',
            username:'',
            price:''
          },
          user:{
            id:'',
            name:'',
            password:'',
          }
        }
      },
      methods:{
          pass(values){
            const _this=this;
            console.log(this.values.username)
            console.log(this.values)
            this.$axios.post("http://localhost:8181/clothes/addordergoods",this.values).then((resp)=>{
              console.log(this.values)
              console.log("测试")
              _this.$router.push({path:"/firstpage",query:{fanhui:resp.data}})
            }).catch((e)=>{})
        },
        chagetest(){
            const _this=this
          var buliao=this.values.materials
          console.log(buliao)
            _this.$axios.get("http://localhost:8181/pattern/price/"+buliao).then(function (resp) {
              console.log(resp.data)
              _this.values.price=resp.data;
            })
        }
      },
      created() {
        console.log(this.$route.query.username+"测试传递参数")
        console.log(this.$route.query.coat+"测试传递参数")
        console.log(this.$route.query.firsttest+"测试传递参数")
        console.log(this.$route.query.pants+"测试传递参数")
        this.values.username=this.$route.query.username
        console.log(this.values.username)
          const _this=this;
        if(this.$route.query.firsttest!=null){
          _this.clothesselect=this.$route.query.firsttest
        }else if(this.$route.query.coat!=null){
          _this.clothesselect = this.$route.query.coat
        }else{
          _this.clothesselect = this.$route.query.pants
        }

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
      },
    }
</script>

<style scoped>

</style>
