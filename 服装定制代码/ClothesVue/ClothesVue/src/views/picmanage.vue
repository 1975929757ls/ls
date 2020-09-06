<template>
    <div>
      <el-page-header @back="goBack" content="">
      </el-page-header>
      <h1></h1>
      <el-table :data="imageinfo" border="">
        <el-table-column
        prop="id"
        label="ID"
        width="50">
      </el-table-column>
        <el-table-column
          prop="src"
        label="图片地址">
        </el-table-column>
        <el-table-column
          prop="info"
        label="图片信息">
        </el-table-column>
        <el-table-column
          label="操作"
          width="200">
          <template slot-scope="scope">
            <el-button @click="reads(scope.row)" type="text" size="small">查看手稿</el-button>
           <el-button @click="deletes(scope.row)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
</template>

<script>
    export default {
        name: "picmanage",
      data(){
          return{
            imageinfo:[
              {
                src: '',
                id: 0,
                info: ''
              }
            ],
            // imageinfo:{
            //   src: '',
            //   id: 0,
            //   info: ''
            // }
          }
      },
      methods:{
        reads(row){
          this.$router.push(
            {path:'/picture',
              query:{
              src:row.src
              }
            })
        },
        goBack() {
          console.log('go back');
          this.$router.push({path:'/business'})
        },
        deletes(row){
          var rid=row.id
          const _this=this
          _this.$axios.post("http://localhost:8181/pic/delete/"+rid).then(function (resp) {
              _this.$router.push("/business")
          })
        },
      },
      created(){
          const _this=this
        _this.$axios.get("http://localhost:8181/pic/all").then(function (resp) {
          console.log(resp.data)
          _this.imageinfo=resp.data
        })
      }
    }
</script>

<style scoped>

</style>
