<template>
  <div>
    <el-table
      :data="datas"
      border
      style="width: 100%">
      <el-table-column
        fixed
        prop="id"
        label="ID"
        width="50">
      </el-table-column>
      <el-table-column
        fixed
        prop="materials"
        label="布料"
        width="100">
      </el-table-column>
      <el-table-column
        fixed
        prop="styles"
        label="风格"
        width="100">
      </el-table-column>
      <el-table-column
        fixed
        prop="size"
        label="尺寸"
        width="100">
      </el-table-column>
      <el-table-column
        fixed
        prop="colors"
        label="颜色"
        width="100">
      </el-table-column>
      <el-table-column
        fixed
        prop="sex"
        label="性别"
        width="100">
      </el-table-column>
      <el-table-column
        fixed
        prop="clothes"
        label="衣服类别"
        width="150">
      </el-table-column>
      <el-table-column
        fixed
        prop="state"
        label="订单状态"
        width="120">
      </el-table-column>
      <el-table-column
        fixed
        prop="make"
        label="制作状态"
        width="120">
      </el-table-column>
      <el-table-column
        fixed
        prop="remarks"
        label="备注"
        width="150">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="150">
        <template slot-scope="scope">
          <el-button @click="edits(scope.row)" type="text" size="small":disabled="scope.row.make=='已制作'">修改</el-button>
          <el-button @click="deletes(scope.row)" type="text" size="small":disabled="scope.row.make=='已制作'">删除</el-button>
          <el-button @click="makes(scope.row)" type="text" size="small":disabled="scope.row.state=='未提交'||scope.row.make=='已制作'">制作</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
    export default {
        name: "someorder",
      data(){
        return{
          datas:[
            {
              id:'',
              materials:'混纺',
              styles:'日韩',
              size:'M',
              colors:'黄色',
              sex:'女',
              clothes:'裤子',
              state:'未提交',
              remarks:'',
              make:''
            },
          ]
        }
      },
      methods:{
        edits(row){
          console.log(row)
          console.log(row.id)
          this.$router.push({
            path:'/ordermanage',
            query:{
              id:row.id,
            }
          })
        },
        deletes(row){
          var rid=row.id
          const _this=this
          _this.$axios.post("http://localhost:8181/clothes/delete/"+rid).then(function (resp) {
            if(resp.data=="success"){
              _this.$router.push("/order")
            }
          })
        },
        makes(row){
          var rid=row.id
          const _this=this
          _this.$axios.post("http://localhost:8181/clothes/makes/"+rid).then(function (resp) {
            if(resp.data=="success"){
              alert("确认操作")
              _this.$router.push("/order")
            }else {
              alert("出错")
            }
          })
        },
      },
      created(){
          console.log(this.$route.query.username)
        var name=this.$route.query.username
        const _this=this
        _this.$axios.get("http://localhost:8181/clothes/order/"+name).then(function (resp) {
          _this.datas=resp.data
          for(var key in resp.data){
            console.log(resp.data[key].state)
          }
        })
      }
    }
</script>

<style scoped>

</style>
