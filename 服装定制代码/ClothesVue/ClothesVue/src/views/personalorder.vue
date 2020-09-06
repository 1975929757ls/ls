<template>
    <div>
      <el-page-header @back="goBack" content="首页">
      </el-page-header>
      <div>
        <h1>我的购物车</h1>
      </div>
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
          width="100">
        </el-table-column>
        <el-table-column
          fixed
          prop="colors"
          label="颜色"
          width="120">
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
          width="100">
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
          width="150">
          <template slot-scope="scope">
            <el-button @click="edits(scope.row)" type="text" size="small" :disabled="scope.row.state=='已提交'">修改</el-button>
            <!--<el-popconfirm title="确定提交？"></el-popconfirm>-->
            <el-button type="text" size="small"@click="deletes(scope.row)"  :disabled="scope.row.state=='已提交'">删除</el-button>
            <el-button type="text" size="small"@click="pass(scope.row)"  :disabled="scope.row.state=='已提交'">提交</el-button>
          </template>
        </el-table-column>
      </el-table>
      </div>
      总订单数为：{{count}} 件
      订单总价格为：{{sum}}元
    </div>
</template>

<script>
    // import ElPopconfirm from "element-ui/packages/popconfirm/src/main";
    export default {
        name: "personalorder",
      // components: {ElPopconfirm},
      data(){
          return{
            value:'',
            count:0,
            sum:0,
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
              },
                ]
          }
      },
      methods:{
        edits(row){
          console.log(row)
          console.log(row.id)
          console.log(this.$route.query.name)
            this.$router.push({
              path:'/updateorder',
              query:{
                id:row.id,
                name:this.value
              }
            })
          },
        pass(row){
            const _this=this
          _this.$axios.post("http://localhost:8181/clothes/submit/"+row.id).then(function (resp) {
            if(resp.data=="success"){
              _this.$router.push({
                path:'/firstpage',
                query:{
                  fan:_this.value
                }
              })
            }
          })
        },
        goBack(){
          this.$router.push({path:'/firstpage',query:{updatename:this.value}})
        },
        deletes(row){
          const _this=this
          _this.$axios.post("http://localhost:8181/clothes/delete/"+row.id).then(function (resp) {
            if (resp.data=="success"){
              console.log(_this.$route.query.name)
              _this.$router.push({
                path:'/firstpage',
                query:{
                  fandelete:_this.value
                }
              })
            }
          })
        }
      },
      created(){
          var name
          console.log(this.$route.query.name)
          console.log(this.$route.query.fanhuiname)
        if(this.$route.query.name!=null){
          name=this.$route.query.name
          this.value=this.$route.query.name
        }else{
          name=this.$route.query.fanhuiname
          this.value=this.$route.query.fanhuiname
        }
          const _this=this
        _this.$axios.get("http://localhost:8181/clothes/ordergoods/"+name).then(function (resp) {
          _this.datas=resp.data
          console.log(resp.data)
          _this.count=resp.data.length
          var i;
          for(i=0;i<resp.data.length;i++){
            _this.sum+=resp.data[i].price
          }
        })
      }
    }
</script>

<style scoped>

</style>
