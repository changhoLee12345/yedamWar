/**
 * custToDo.js
 */

const ToDo = {
	initData: [],
	showCol: [],
	genUL: function () {
		if (!this.showCol.length)
			this.showCol = this.initData[0];

		this.ul = document.createElement('ul');
		this.initData.forEach(row => {
			this.ul.append(this.genList(row))
		})
		return this.ul;
	},
	genList: function (obj = {}) {
		let li = document.createElement('li');
		for (let col in this.showCol) {
			let span = document.createElement('span')
			span.innerText = obj[col];
			li.append(span);
		}
		return li;
	}
}