<template>
    <div>
      <el-menu
        :default-active="activeIndex2"
        class="el-menu-demo"
        mode="horizontal"
        @select=""
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-menu-item index="1" @click="manage">添加服装样式</el-menu-item>
      </el-menu>
      <el-table
        :data="datas"
        height="600"
        border
        style="width: 100%">
        <el-table-column
          fixed
          prop="style"
          label="服装风格"
          width="250">
        </el-table-column>
        <el-table-column
          fixed
          prop="buliao"
          label="服装布料"
          width="250">
        </el-table-column>
        <el-table-column
          fixed
          prop="price"
          label="服装颜色"
          width="250">
        </el-table-column>
        <el-table-column
          fixed
          prop="color"
          label="服装颜色"
          width="250">
        </el-table-column>
      </el-table>
    </div>
</template>

<script>
    export default {
        name: "pattern",
      data(){
          return{
            datas:[
              {
                buliao:'混纺',
                style:'日韩',
                price:0,
                color:'黄色',
              }
            ],
          }
      },
      methods:{
          manage(){
            this.$router.push({path:'/addpattern'})
          }
      },
      created(){
          const _this=this
        this.$axios.get("http://localhost:8181/pattern/findall").then(function (resp) {
          console.log(resp.data)
          _this.datas=resp.data
        })
      }
    }
</script>

<style scoped>

</style>
