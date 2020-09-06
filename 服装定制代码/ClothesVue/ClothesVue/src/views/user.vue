<template>
  <div>
    <h1>全部用户</h1>
    <div>
        <el-form>
          <table>
            <tr>
              <td>
            <el-input type="text" v-model="username" placeholder="请输入用户名"></el-input>
              </td>
            <el-button type="submit" @click="find('username')" style="color: aquamarine">根据用户名查找</el-button>
            </tr>
          </table>
        </el-form>
    </div>
    <div>
      <el-table
        :header-cell-style="{background:'#F3F4F7',color:'#555',align:'center'}"
        :data="datas"
        borde
        style="width: 85%">
        <el-table-column
          fixed
          prop="id"
          label="ID"
          width="200">
        </el-table-column>
        <el-table-column
          fixed
          prop="name"
          label="用户名"
          width="200">
        </el-table-column>
        <el-table-column
          fixed
          prop="password"
          label="用户密码"
          width="200"
        type="password">
        </el-table-column>
        <el-table-column
          fixed
          prop="phone"
          label="手机号码"
          width="250">
        </el-table-column>
        <el-table-column
          fixed
          prop="email"
          label="用户邮箱"
          width="250">
        </el-table-column>
        <!--<el-table-column-->
          <!--fixed="right"-->
          <!--label="操作"-->
          <!--width="100">-->
          <!--<template slot-scope="scope">-->
            <!--<el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>-->
          <!--</template>-->
        <!--</el-table-column>-->
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
        name: "user",
      data(){
        return{
          pagesize:0,
          total:0,
          results:{
            name:''
          },
          username:'',
          datas:[
            {
              id:'',
              name:'',
              password:'',
              phone:'',
              email:'',
            }
          ]
        }
      },
      methods:{
          page(currentpage){
            const _this=this
            this.$axios.get("http://localhost:8181/user/pageall/"+(currentpage-1)+"/5").then(function (resp) {
              console.log(resp.data)
              _this.datas=resp.data.content
              _this.pagesize=resp.data.size
              _this.total=resp.data.totalElements
            })
          },
        find(){
            this.$router.push({path:"/personaldata",query:{username:this.username}})
        }
      },
      created(){
          const _this=this
          this.$axios.get("http://localhost:8181/user/pageall/0/5").then(function (resp) {
            console.log(resp.data)
            _this.datas=resp.data.content
            _this.pagesize=resp.data.size
            _this.total=resp.data.totalElements
          })
      }
    }
</script>

<style scoped>

</style>
