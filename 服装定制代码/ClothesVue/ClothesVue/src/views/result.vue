<template>
  <div>
    <el-page-header @back="goBack" content="首页">
    </el-page-header>
    <h1>完成订单</h1>
    <div>
      <div><h2 align="left">已经完成订单总数为：{{sum}}件 完成订单总价格为：{{count}}元</h2></div>
      <el-table
        :data="datas"
        border
        style="width: 100%">
        <el-table-column
          fixed
          prop="id"
          label="ID"
          width="80">
        </el-table-column>
        <el-table-column
          fixed
          prop="materials"
          label="布料"
          width="120">
        </el-table-column>
        <el-table-column
          fixed
          prop="styles"
          label="风格"
          width="120">
        </el-table-column>
        <el-table-column
          fixed
          prop="size"
          label="尺寸"
          width="120">
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
          width="80">
        </el-table-column>
        <el-table-column
          fixed
          prop="clothes"
          label="衣服类别"
          width="180">
        </el-table-column>
        <el-table-column
          fixed
          prop="price"
          label="服装价格"
          width="150">
        </el-table-column>
        <el-table-column
          fixed
          prop="state"
          label="订单状态"
          width="150">
        </el-table-column>
        <el-table-column
          fixed
          prop="make"
          label="制作状态"
          width="150">
        </el-table-column>
        <el-table-column
          fixed
          prop="remarks"
          label="备注"
          width="150">
        </el-table-column>
        <!--<el-table-column-->
          <!--fixed="right"-->
          <!--label="操作"-->
          <!--width="140">-->
          <!--<template slot-scope="scope">-->
            <!--<el-button @click="edits(scope.row)" type="text" size="small":disabled="scope.row.make=='已制作'">修改</el-button>-->
            <!--<el-button @click="deletes(scope.row)" type="text" size="small":disabled="scope.row.make=='已制作'">删除</el-button>-->
            <!--<el-button @click="makes(scope.row)" type="text" size="small":disabled="scope.row.state=='未提交'||scope.row.make=='已制作'">制作</el-button>-->
          <!--</template>-->
        <!--</el-table-column>-->
      </el-table>
    </div>
  </div>
</template>

<script>
    export default {
        name: "result",
      data(){
          return{
            sum:0,
            count:0,
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
                make:'',
                price:''
              }
            ]
          }
      },
      methods:{
        goBack(){
          this.$router.push({path:'/business'})
        },
      },
      created(){
        const _this=this
        _this.$axios.get("http://localhost:8181/manage/findmake").then(function (resp) {
          console.log(resp.data)
          console.log(resp.data.length)
          _this.sum=resp.data.length
          _this.datas=resp.data
          for(var i=0;i<resp.data.length;i++){
            _this.count=resp.data[i].price+ _this.count
            console.log(resp.data[i].price)
          }
        })
      }
    }
</script>

<style scoped>

</style>
