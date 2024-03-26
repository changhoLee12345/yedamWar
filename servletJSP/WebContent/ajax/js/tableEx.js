/**
 * table 기능 생성.
 */
import Table from './table.js';

let data = [{
        name: 'hong',
        age: 20
    },
    {
        name: 'hwang',
        age: 22
    },
    {
        name: 'park',
        age: 26
    },
    {
        name: 'kim',
        age: 29
    }
]
var app = document.getElementById('app');
var tbl = new Table(data);
app.append(tbl);