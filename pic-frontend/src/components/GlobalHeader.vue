<template>
  <a-row :wrap="false">
    <a-col flex="6px">
      <RouterLink to="/">
        <div class="title-bar" :style="logStyle">
          <img src="../assets/logo.svg" alt="logo" />
        </div>
      </RouterLink>
    </a-col>
    <a-col flex="auto">
      <div class="globalheader">
        <a-menu v-model:selectedKeys="current" mode="horizontal" :items="items" @click="doMenuClick" />
      </div>
    </a-col>
    <a-col flex="80px">
      <div class="user-login-status" :style="userStatusStyle">
        <div v-if="loginUserStore.loginUser.id">
          {{ loginUserStore.loginUser.userName ?? '无名' }}
        </div>
        <div v-else>
          <a-button type="primary" href="/user/login" shape="round" icon="" size="large">登录</a-button>
        </div>
      </div>
    </a-col>
  </a-row>
</template>
<script lang="ts" setup>
//@ts-ignore
import { useLoginUserStore } from '@/stores/loginUser';
const loginUserStore = useLoginUserStore()
import { h, ref } from 'vue'
import { HomeOutlined, AppstoreOutlined, SettingOutlined, WechatFilled } from '@ant-design/icons-vue'
import type { MenuProps } from 'ant-design-vue';
import type { CSSProperties } from 'vue';
import { useRouter } from 'vue-router';
const logStyle: CSSProperties = ({
  height: '28px',
  width: '28px',
  display: 'flex',
  alignItems: 'center',
  position: 'fixed',
  top: '30px',
  left: '15px',
})
const userStatusStyle: CSSProperties = ({
  color: 'black',
})
const current = ref<string[]>([])
const items = ref<MenuProps['items']>([
  {
    key: '/',
    icon: () => h(HomeOutlined),
    label: '主页',
    title: '主页',
  },
  {
    key: '2',
    icon: () => h(AppstoreOutlined),
    label: '日志',
    title: '日志',
  },
  {
    key: '2',
    icon: () => h(SettingOutlined),
    label: '图谱',
    title: '图谱',
    children:
      [
        {
          key: '/user/register',
          label: '用户注册',
          title: '图片素材',
        }, {
          key: '/admin/userManage',
          label: '用户管理',
          title: '视频素材',
        }
      ],
  }, {
    key: '3',
    label: '云空间',
    title: '云空间',
    icon: () => h(WechatFilled),
  }, {
    key: '4',
    label: '测试工具',
    title: '测试工具',
    icon: () => h(SettingOutlined),
    children: [{
      key: '1',
      label: '测试工具1',
      title: '测试工具1',
    }, {
      key: '2',
      label: '测试工具2',
      title: '测试工具2',
    }]
  }, {
    key: '/process',
    label: '项目进程',
    title: '项目进程',
    icon: () => h(SettingOutlined),
  }
])
const routes = useRouter();
//路由跳转
const doMenuClick = ({ key }: { key: string }) => {
  routes.push({ path: key });
}

routes.afterEach((to) => {
  current.value = [to.path]
})
//@ts-ignore
import { healthUsingGet } from '@/api/mainController'


</script>