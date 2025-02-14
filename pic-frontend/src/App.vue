<template>
  <div id="app">
    <BasicLayout />
  </div>
</template>
<script setup lang="ts">
//@ts-ignore
import BasicLayout from "@/layouts/BasicLayout.vue";
//@ts-ignore
import { useLoginUserStore } from "@/stores/loginUser";
const loginUserStore = useLoginUserStore()
loginUserStore.fetchLoginUser()

</script>
<style scoped>
#app {}
</style>