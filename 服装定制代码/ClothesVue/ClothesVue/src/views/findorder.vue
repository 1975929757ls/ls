<template>
  <div>
    <el-page-header @back="goBack" content="">
    </el-page-header>
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
          width="80">
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
          width="80">
        </el-table-column>
        <el-table-column
          fixed
          prop="colors"
          label="颜色"
          width="80">
        </el-table-column>
        <el-table-column
          fixed
          prop="sex"
          label="性别"
          width="80">
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
          width="110">
        </el-table-column>
        <el-table-column
          fixed
          prop="make"
          label="制作状态"
          width="100">
        </el-table-column>
        <el-table-column
          fixed
          prop="remarks"
          label="备注"
          width="150">
        </el-table-column>
        <el-table-column
          fixed
          prop="price"
          label="价格"
          width="80">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="140">
          <template slot-scope="scope">
            <el-button @click="edits(scope.row)" type="text" size="small":disabled="scope.row.make=='已制作'">修改</el-button>
            <el-button @click="deletes(scope.row)" type="text" size="small":disabled="scope.row.make=='已制作'">删除</el-button>
            <el-button @click="makes(scope.row)" type="text" size="small":disabled="scope.row.state=='未提交'||scope.row.make=='已制作'">制作</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  export default {
    name: "someorder",
    data(){
      return{
        //     id:'',
        // materials:'',
        //     styles:'',
        //     size:'',
        //     colors:'',
        //     sex:'',
        //     clothes:'',
        //     state:'',
        //     remarks:'',
        datas:[
          {
            id:'',
            materials:'',
            styles:'',
            sizes:'',
            color:'',
            sex:'',
            clothes:'',
            state:'',
            remarks:'',
          }
        ],
      }
    },
    methods:{
      goBack(){
        this.$router.push({path:'/order'})
      },
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
            _this.$router.push("/result")
          }else {
            alert("出错")
          }
        })
      },
    },
    created(){
      console.log(this.$route.query.userid)
      var orderid=this.$route.query.userid
      const _this=this
      _this.$axios.get("http://localhost:8181/clothes/orders/"+orderid).then(function (resp) {
        console.log(resp.data )
        _this.datas=resp.data
      })
    }
  }
</script>

<style scoped>

</style>
