<template>
  <div>
    <h1>个人信息</h1>
    <div style="text-align: center">
      <el-table
        :data="datas"
        border
        style="margin: auto;width: 60%">
        <el-table-column
          fixed
          prop="id"
          label="ID"
          width="50">
        </el-table-column>
        <el-table-column
          fixed
          prop="name"
          label="用户名"
          width="100">
        </el-table-column>
        <el-table-column
          fixed
          prop="password"
          label="用户密码"
          width="100">
        </el-table-column>
        <el-table-column
          fixed
          prop="phone"
          label="联系方式"
          width="150">
        </el-table-column>
        <el-table-column
          fixed
          prop="email"
          label="用户邮箱"
          width="200">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="150">
          <template slot-scope="scope">
          <el-button type="text" @click="edits(scope.row)">修改</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>


</template>

<script>
    export default {
      name: "personaldata",
      data() {
        return {
          datas:[
            {
              id:"",
              name:'',
              password:'',
              phone:'',
              eamil:'',
            }
          ],
        }
      },
      methods: {
        edits(row) {
          this.$router.push({path:'/updatedata',query:{username:row.name}})
        },
      },

      created(){
          console.log(this.$route.query.name)
          console.log(this.$route.query.username)
        if(this.$route.query.name!=null){
          this.username=this.$route.query.name
        }else {
          this.username=this.$route.query.username
        }
        const _this=this
        _this.$axios.get("http://localhost:8181/user/data/"+this.username).then(function (resp) {
          console.log(resp.data)
          // _this.id=resp.data.id;
          // _this.name=resp.data.name
          // _this.password=resp.data.password
          // _this.phone=resp.data.phone
          // _this.email=resp.data.email
          _this.datas=resp.data
        }).catch((e)=>{})
      }
    }
</script>

<style scoped>

</style>
