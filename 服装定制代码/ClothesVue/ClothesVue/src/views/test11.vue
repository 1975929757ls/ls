<template>
    <div>
      <el-table
        :data="datas"
        border
        style="width: 100%">
        <el-table-column
          fixed
          prop="buliao"
          label="布料"
          width="100">
        </el-table-column>
        <el-table-column
          fixed
          prop="price"
          label="价格"
          width="100">
        </el-table-column>
      </el-table>
    </div>
</template>

<script>
    export default {
        name: "test11",
      data(){
        return{
          datas:[
            {
              buliao:'混纺',
              prices:0,
            },
          ]
        }
      },
      created(){
        const _this=this
        _this.$axios.get("http://localhost:8181/clothes/f").then(function (resp) {
          _this.datas=resp.data
        })
      }
    }
</script>

<style scoped>

</style>
