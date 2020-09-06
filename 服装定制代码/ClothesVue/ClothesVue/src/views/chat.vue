<template>
    <div>
      <el-table
        :data="datas"
        border
        style="width: 43%">
        <el-table-column
          fixed
          prop="info"
          label="发送信息"
          width="300">
        </el-table-column> <el-table-column
        fixed
        prop="reply"
        label="回复信息"
        width="300">
      </el-table-column>
      </el-table>
      <el-form :model="chatvalue">
        <table style="width: 500px">
              <el-input
                type="textarea"
                autosize=""
                placeholder="输入"
                v-model="chatvalue.info">
              </el-input>
              <el-button type="submit" @click="pass">提交</el-button>
        </table>
      </el-form>

    </div>
</template>

<script>
    export default {
        name: "chat",
      data(){
          return{
            chatvalue:{
              name:'',
              info:''
            },
            information:{},
            datas:[
              {
                info:"",
                reply:''
              }
            ],
          }
      },
      methods:{
        pass(){
          console.log(this.chatvalue.name)
          console.log(this.chatvalue.info)
          const _this=this
          this.$axios.post("http://localhost:8181/chat/add",this.chatvalue).then(function (resp) {
            if(resp.data=="success"){
              _this.$router.push({path:'/firstpage',query:{chat:_this.chatvalue.name}})
            }
          })
        }
      },
      created(){
        console.log(this.$route.query.name)
        this.chatvalue.name=this.$route.query.name
        var name= this.$route.query.name
        const  _this=this
        _this.$axios.get("http://localhost:8181/chat/zhan/"+name).then(function (resp) {
          console.log(resp.data)
          _this.datas=resp.data
        })
      }
    }
</script>

<style scoped>

</style>
