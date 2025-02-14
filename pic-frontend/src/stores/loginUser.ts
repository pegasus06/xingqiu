import { getLoginUserUsingGet } from "@/api/userController";
import { defineStore } from "pinia";
import { ref } from "vue";


export const useLoginUserStore = defineStore("loginUser", () => {
  const loginUser = ref<API.LoginUserVO>({
    userName: "未登录",
  });


  // 定义一个异步函数 fetchLoginUser 用于获取当前登录用户的信息
  async function fetchLoginUser() {
    const res=await getLoginUserUsingGet();
    if(res.data.code==0&&res.data.data){
      loginUser.value = res.data.data;
    }
    // 测试用户登录，3 秒后登录
    // setTimeout(() => {
    //   loginUser.value = { userName: '用户A', id: 1 }
    // }, 3000)
  }
  

  // 定义一个函数 setLoginUser 用于设置当前登录用户的信息
  function setLoginUser(newLoginUser: any) {
    loginUser.value = newLoginUser; // 将传入的新用户信息赋值给 loginUser 的 value 属性
  }

  // 返回一个对象，包含 loginUser、setLoginUser 和 fetchLoginUser 三个属性
  return { loginUser, setLoginUser, fetchLoginUser };
});
