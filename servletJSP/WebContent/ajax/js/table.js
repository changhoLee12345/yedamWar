/**
 * module생성. 다른 js파일에서 import 해서 기능을 사용하도록.
 */

export default class Table {
    constructor(data) {
        this.data = data;
        this.makeTable(); // 테이블 생성.
        return this.table;
    }
    makeTable() {
        this.table = document.createElement('table');
        // thead .
        this.makeHead();
        // tbody.
        this.makeBody();
    }
    makeHead() {
        let template = {};
        template = this.data[0];

        this.thead = document.createElement('thead');
        let tr = document.createElement('tr');
        for (let prop in template) {
            let td = document.createElement('th');
            td.innerText = prop;
            tr.append(td);
        }
        this.thead.append(tr);
        this.table.append(this.thead);
    }
    makeBody() {
        this.tbody = document.createElement('tbody');
        this.data.forEach((item, idx) => {
            let tr = this.makeTr(item)
            tr.className = idx % 2 == 0 ? 'odd' : 'even';
            this.tbody.append(tr)
        })
        this.table.append(this.tbody);
    }
    makeTr(item = {}) {
        let tr = document.createElement('tr');
        for (let prop in item) {
            let td = document.createElement('td');
            td.innerText = item[prop];
            tr.append(td);
        }
        return tr;
    }
}