<template>
    <div>
      <el-page-header @back="goBack" content="首页">
      </el-page-header>
      <h1>全部订单</h1>
      <el-form>
        <table>
          <tr>
            <td>
              <el-input type="text" v-model="username" placeholder="请输入用户名"></el-input>
            </td>
            <el-button type="primary" icon="el-icon-search"@click="find('username')">根据用户搜索</el-button>
            <!--<el-button type="submit" @click="find('username')" style="color: aquamarine">根据用户名查找</el-button>-->

            <td>
              <el-input type="text" v-model="ids" placeholder="请输入服装ID"></el-input>
            </td>
            <el-button type="primary" icon="el-icon-search"@click="finds('ids')">根据服装ID搜索</el-button>
          </tr>
        </table>
      </el-form>
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
          <el-table-column
            fixed
            prop="price"
            label="价格"
            width="100">
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
        <el-pagination
          background
          layout="prev, pager, next"
          :page-size="pagesize"
          :total="total"
          @current-change="page"
        >
        </el-pagination>
      </div>
    </div>
</template>

<script>
    export default {
        name: "Order",
      data(){
          return{
            pagesize:0,
            total:0,
            username:'',
            ids:'',
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
        page(currentpage){
          const _this=this
          this.$axios.get("http://localhost:8181/manage/pagetest/"+(currentpage-1)+"/5").then(function (resp) {
            console.log(resp.data)
            _this.datas=resp.data.content
            _this.pagesize=resp.data.size
            _this.total=resp.data.totalElements
          })
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
        goBack(){
          this.$router.push({path:'/business'})
        },
        find(username){
          var username=this.username
          console.log(username)
          const _this=this
          _this.$axios.post("http://localhost:8181/user/findresult/"+username).then(function (resp) {
            if(resp.data=="success"){
              console.log(resp.data)
              _this.$router.push({path:"/someorder",query:{username:_this.username}})
            }else{
              alert("无此用户")
            }
          })
        },
        // finds(ids) {
        //       this.$router.push({path: "/findorder", query: {userid: this.ids}})
        // }
        finds(ids){
          var id=this.ids
          const _this=this
          _this.$axios.post("http://localhost:8181/manage/orderid/"+id).then(function (resp) {
            if(resp.data=="success"){
              console.log(resp.data)
              _this.$router.push({path:"/findorder",query:{userid:_this.ids}})
            }else{
              alert("无此订单")
            }
          })
        },
      },

      created(){
          const _this=this
        _this.$axios.get("http://localhost:8181/manage/pagetest/0/5").then(function (resp) {
          console.log(resp.data)
          _this.datas=resp.data.content
          console.log(resp.data.content[0].buliao)
          _this.pagesize=resp.data.size
          _this.total=resp.data.totalElements
        })
        // _this.$axios.get("http://localhost:8181/manage/pageallss/0/5").then(function (resp) {
        //   console.log(resp.data)
        //   _this.datas=resp.data
        // })
      }
    }
</script>

<style scoped>

</style>
