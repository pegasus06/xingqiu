import App from './App.vue'
import router from './router'
import Antd from "ant-design-vue";
import { createPinia } from 'pinia'
import { createApp } from 'vue'
const app = createApp(App)
app.use(Antd);
app.use(createPinia())
app.use(router)

app.mount('#app')
