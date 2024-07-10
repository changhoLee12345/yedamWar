/**
 * main.js
 */
console.log('vue.js')
const {
	createApp,
	ref
} = Vue;

const app = createApp({
	data() {
		return {
			message: 'Hello Vue!!123',
			count: 0
		}
	}
});
app.mount('#app');
console.log(app);