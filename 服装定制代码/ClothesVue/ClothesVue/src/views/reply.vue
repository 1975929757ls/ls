<template>
  <div>
    <el-form :model="datas">
      <table style="width: 500px">
        <el-input
          type="textarea"
          autosize=""
          placeholder="输入"
          v-model="datas.reply">
        </el-input>
        <el-button type="submit" @click="pass">提交</el-button>
      </table>
    </el-form>
  </div>
</template>

<script>
    export default {
        name: "reply",
      data(){
        return{
          datas:
            {
              reply:'',
              cid:0,
              bid:1
            },
        }
      },
      methods:{
        pass(){
          const _this=this
          console.log(this.datas)
          _this.$axios.post("http://localhost:8181/chat/addreply",this.datas).then(function (resp) {
            if(resp.data=="success"){
              _this.$router.push({
                path:'/information',
              })
            }
          })
        }
      },
      created(){
        const  _this=this
        var id=this.$route.query.id
        _this.datas.cid=id
        _this.datas.bid=1
      }
    }
</script>

<style scoped>

</style>
