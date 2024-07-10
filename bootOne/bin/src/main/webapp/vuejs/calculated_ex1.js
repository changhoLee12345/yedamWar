import item from './calculated.js';

const { createApp, ref, nextTick } = Vue;

const app = createApp(item)
	.mount('#app');