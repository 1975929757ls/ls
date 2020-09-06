<template>
    <div>
      <el-table
        :data="datas"
        border
        style="width: 65%">
        <el-table-column
          fixed
          prop="id"
          label="ID"
          width="110">
        </el-table-column>
        <el-table-column
          fixed
          prop="name"
          label="用户名"
          width="153">
        </el-table-column>
        <el-table-column
          fixed
          prop="info"
          label="用户请求"
          width="500">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="150">
          <template slot-scope="scope">
            <el-button @click="edits(scope.row)" type="text" size="small" >回复</el-button>
          </template>
        </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        name: "information",
      data(){
          return{
            datas:[
              {
                info:'xiuhai',
                name:'hjhj',
                id:1,
              }
            ],
          }
      },
      methods:{
        edits(row){
          const _this=this

          _this.$router.push({
            path:'/reply',
            query:{
              id:row.id,
            }
          })
        }
      },
      created(){
          const  _this=this
        _this.$axios.get("http://localhost:8181/chat/info").then(function (resp) {
          console.log(resp.data)
          _this.datas=resp.data
        })
      }
    }
</script>

<style scoped>

</style>
