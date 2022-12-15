/**
 * custTable.js
 */

const Table = {
    initData: [],
    showField: [],
    addField: {
        col1: ['button', '삭제'],
        col2: ['button', '변경'],
        col3: ['input', 'checkbox']
    },
    generateTable: function () {
        this.table = document.createElement('table');
        this.table.setAttribute('border', '1')
        this.thead = document.createElement('thead');
        this.tbody = document.createElement('tbody');
        this.table.append(this.thead, this.tbody);

        // thead 생성.
        this.htr = document.createElement('tr');
        this.showField.forEach(field => {
            let th = document.createElement('th')
            th.innerText = field;
            this.htr.append(th)
        })
        // 추가 칼럼.
        for (let col in this.addField) {
            let th = document.createElement('th');
            th.innerHTML = this.addField[col][1] != 'checkbox' ? this.addField[col][1] : '<input type="checkbox">'
            this.htr.append(th)
        }
        this.thead.append(this.htr);

        // tbody 생성.
        this.initData.forEach(obj => {
            this.tbody.append(this.addRow(obj));
        })

        return this.table;
    },
    addRow: function (obj = {}) {
        this.btr = document.createElement('tr');
        for (let prop of this.showField) {
            let td = document.createElement('td');
            td.innerText = obj[prop]
            this.btr.append(td);
        }
        // 추가 칼럼.
        for (let col in this.addField) {
            let td = document.createElement('td');
            let childElement = document.createElement(this.addField[col][0]);
            childElement.innerText = this.addField[col][1];
            if (this.addField[col][0] == 'input')
                childElement.setAttribute('type', this.addField[col][1])
            td.append(childElement)
            this.btr.append(td);
        }
        return this.btr;
    }
}