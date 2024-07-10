/**
 * 
 */
const { createApp, ref, nextTick } = Vue;

console.log('vue.js');

const app = createApp({
	data() {
		return {
			message: 'Hello Vue!!123',
			count: 0
		}
	},
	methods: {
		 increment() {
			this.count++;
			//await nextTick();
		}
	}
});
app.mount('#app');

