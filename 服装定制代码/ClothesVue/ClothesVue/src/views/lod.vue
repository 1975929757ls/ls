<template>
  <div >
    <h1>{{ msg }}</h1>
    <!--<img :src="url">-->
    <!--<img :src="getUrl()">-->
    <form>
      <input type="file" @change="getFile($event)">
      <!--<label>手稿信息</label>-->
      <el-input v-model="info" placeholder="请输入手稿信息" style="width: 200px"></el-input>
      <button class="button button-primary button-pill button-small" @click="submit($event)">提交</button>
    </form>
  </div>
</template>

<script>
  import axios from 'axios';
  // import src from 'D:\\files\\20191016006_SH4781.jpg'
  import src from '@/image/20191016006_SH4781.jpg'
  export default {
    name: 'lod',
    data() {
      return {
        msg: '添加手稿',
        file: '',
        info:'',
        im:'',
        // dihi:"@/image/",
        // url:require("D:\\files\\20191016006_SH4781.jpg")
        // // url:require(dihi+"20191016006_SH4781.jpg")
      }
    },
    methods: {
      // getUrl(){
      //   var s="351.jpg"
      //   let img=require('D:/files/'+s)
      //   return img
      // },
      getFile: function (event) {
        this.file = event.target.files[0];
        console.log(this.file);
      },
      submit: function (event) {
        //组织元素发生默认的行为
        event.preventDefault();
        console.log(this.info)
        var info=this.info
        let formData = new FormData();
        formData.append("file", this.file);
        console.log(formData)
        axios.post('http://localhost:8181/upload/singlefile/'+info ,formData)
          .then(function (response) {
            alert(response.data);
            console.log(response);
            window.location.reload();
          })
          .catch(function (error) {
            alert("上传失败");
            console.log(error);
            window.location.reload();
          });
      }
    },
    created(){
      const _this=this
      _this.dizhi="D:\\files\\20191016006_SH4781.jpg"
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }
  .button-pill {
    border-radius: 200px;
  }
  .button-primary, .button-primary-flat {
    background-color: #1B9AF7;
    border-color: #1B9AF7;
    color: #FFF;
  }
  .button {
    color: #FFF;
    background-color: #1B9AF7;
    border-color: #EEE;
    font-size: 16px;
    font-family: "Helvetica Neue Light", "Helvetica Neue", Helvetica, Arial, "Lucida Grande", sans-serif;
    text-decoration: none;
    text-align: center;
    line-height: 40px;
    height: 40px;
    padding: 0 40px;
    margin: 0;
    display: inline-block;
    appearance: none;
    cursor: pointer;
    border: none;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    -webkit-transition-property: all;
    transition-property: all;
    -webkit-transition-duration: .3s;
    transition-duration: .3s;
  }
  .button-small {
    font-size: 12px;
    height: 30px;
    line-height: 30px;
    padding: 0 30px;
  }
</style>
