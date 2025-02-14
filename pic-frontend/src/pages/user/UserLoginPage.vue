<template>
  <div id="userLoginPage">
    <a-form :model="formState" name="basic" :label-col="{ span: 8 }" :wrapper-col="{ span: 16 }" autocomplete="off"
      @finish="onFinish" @finishFailed="onFinishFailed">
      <a-form-item label="Username" name="username"
        :rules="[{ required: true, message: 'Please input your username!' }]">
        <a-input v-model:value="formState.username" placeholder="请输入账号" />
      </a-form-item>

      <a-form-item label="Password" name="password"
        :rules="[{ required: true, message: 'Please input your password!' }]">
        <a-input-password v-model:value="formState.password" placeholder="请输入密码" />
      </a-form-item>

      <div class="tips" :style="toRegisterStyle">没有账号？<router-link to="/user/register">去注册</router-link>
      </div>
      <a-form-item :wrapper-col="{ offset: 8, span: 16 }">
        <a-button type="primary" html-type="submit">login</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>
<script lang="ts" setup>
//@ts-ignore
import { useLoginUserStore } from '@/stores/loginUser';

//@ts-ignore
import { userLoginUsingPost } from '@/api/userController';
const loginUserStore = useLoginUserStore()
import { message } from 'ant-design-vue';
import { reactive } from 'vue';
import type { CSSProperties } from 'vue';
import {  useRouter } from 'vue-router';
const router=useRouter()
const toRegisterStyle: CSSProperties = ({
  textAlign: 'right',
  fontSize: '12px',
  color: '#999',
})
interface FormState {
  username: string;
  password: string;
  remember: boolean;
}

const formState = reactive<FormState>({
  username: '',
  password: '',
  remember: true,
});
const onFinish = (values: any) => {
  console.log('Success:', values);
};

const onFinishFailed = (errorInfo: any) => {
  console.log('Failed:', errorInfo);
};
const handleSubmit = async (values: any) => {
  const res = await userLoginUsingPost(values)
  // 登录成功，把登录态保存到全局状态中
  if (res.data.code === 0 && res.data.data) {
    await loginUserStore.fetchLoginUser()
    message.success('登录成功')
    router.push({
      path: '/',
      replace: true,
    })
  } else {
    message.error('登录失败，' + res.data.message)
  }
}
</script>
<style scoped>
#userLoginPage{
  margin: 100px 500px ;
}
</style>
