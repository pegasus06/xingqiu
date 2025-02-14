<template>
    <a-space direction="vertical" :style="{ width: '100%' }" :size="[0, 48]">
      <a-layout>
        <a-layout-header :style="headerStyle">
            <GlobalHeader/>
        </a-layout-header>

        <a-layout-content :style="contentStyle">
          <router-view></router-view>
        </a-layout-content>
        <a-layout-footer :style="footerStyle"><a href="https://github.com/antfu/vitesse" target="_blank">效能工具</a></a-layout-footer>
      </a-layout>
    </a-space>
  

  </template>
  <script lang="ts" setup>
  import type { CSSProperties } from 'vue';
  //@ts-ignore
  import GlobalHeader from '@/components/GlobalHeader.vue';
  const headerStyle: CSSProperties = {
    textAlign: 'center',
    color: '#fff',
    height: 64,
    paddingInline: 50,
    lineHeight: '64px',
    backgroundColor: 'white',

  };
  
  const contentStyle: CSSProperties = {
    lineHeight: '120px',
    color: 'black',
    backgroundColor: 'white',
    margin: '48px',
  };
  
  const siderStyle: CSSProperties = {
    textAlign: 'center',
    lineHeight: '120px',
    color: '#fff',
    backgroundColor: '#3ba0e9',
  };
  
  const footerStyle: CSSProperties = {
    textAlign: 'center',
    color: '#fff',
    backgroundColor: '#7dbcea',
    padding: '16px',
    bottom:'0',
    position: 'fixed',
    left: 0,
    right: 0,
  };
  </script>

  
  