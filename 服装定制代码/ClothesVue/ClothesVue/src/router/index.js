import Vue from 'vue'
import Router from 'vue-router'
import firstpage from '@/views/FirstPage'
import clothes from '@/views/clothes'
import login from '@/views/login'
import register from '@/views/register'
import personaldata from '@/views/personaldata'
import personalorder from '@/views/personalorder'
import updatedata from '@/views/updatedata'
import updateorder from '@/views/updateorder'
import business from '@/views/business'
import order from '@/views/order'
import ordermanage from '@/views/ordermanage'
import user from '@/views/user'
import pattern from '@/views/pattern'
import addpattern from '@/views/addpattern'
import dress from '@/views/dress'
import someorder from '@/views/someorder'
import chat from '@/views/chat'
import lod from '@/views/lod'
import information from '@/views/information'
import findorder from '@/views/findorder'
import result from '@/views/result'
import design from '@/views/design'
import picmanage from '@/views/picmanage'
import picture from '@/views/picture'
import test11 from '@/views/test11'
import reply from '@/views/reply'


Vue.use(Router)

export default new Router({
  routes: [
    // {
    //   path: '/',
    //   name: 'HelloWorld',
    //   component: HelloWorld
    // },
    {
      path:'/',
      name:'login',
      component:login
    },
    {
      path:'/firstpage',
      name:'firstpage',
      component:firstpage
    },
    {
      path:'/clothes',
      name:'clothes',
      component:clothes
    },
    {
      path:'/register',
      component:register
    },
    {
      path:'/personalorder',
      component:personalorder
    },
    {
      path:'/personaldata',
      component:personaldata
    },
    {
      path:'/updatedata',
      component:updatedata
    },
    {
      path:'/updateorder',
      component:updateorder
    },
    {
      path:'/business',
      component:business
    },
    {
      path:'/order',
      component:order
    },
    {
      path:"/ordermanage",
      component:ordermanage
    },
    {
      path:'/user',
      component:user
    },
    {
      path:"/pattern",
      component:pattern
    },
    {
      path:'/addpattern',
      component:addpattern
    },
    {
      path:"/dress",
      component:dress
    },
    {
      path:"/someorder",
      component:someorder
    },
    {
      path:"/chat",
      component:chat
    },
    {
      path:"/lod",
      component:lod
    },
    {
      path:'/information',
      component:information
    },
    {
      path:'/findorder',
      component:findorder
    },
    {
      path:'/result',
      component:result
    },
    {
      path:'/design',
      component:design
    },
    {
      path:'/picmanage',
      component:picmanage
    },
    {
      path:'/picture',
      component:picture
    },
    {
      path:'/test11',
      component:test11
    },
    {
      path:'/reply',
      component:reply
    }
  ]
})
