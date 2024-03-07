/*
* script.js
*/

console.log("script.js");
console.log(document);

document.querySelector('button.btn').addEventListener('click', clickFnc);
function clickFnc(ev) {
	console.log(ev);
	let userValue = document.querySelector('input#name').value; // input 아이디값.
    let liTag = document.createElement('li');
    liTag.innerText = userValue + ' '; // <li>홍길동 <button>삭제</button></li>
    // button 생성.
    let btn = document.createElement('button');
    btn.innerText = '삭제';
    liTag.appendChild(btn);

    document.querySelector('#list').appendChild(liTag);
    // init.
    // document.querySelector('#name').value = '';
}

// addRow
document.querySelector('#addBtn').addEventListener('click', addRow);
function addRow() {
	let sno, sname, score;
	sno = document.querySelector('#sno').value//document.querySelector('#sno').value;
	sname = document.querySelector('#sname').value;
	score = document.querySelector('#score').value;
	if (!sno || !sname || !score) {
		alert('빈값을 채워주세요.');
		return; // 함수종료.
	}
	let obj = {sno, sname, score}
	let tr = makeRow(obj);
	document.querySelector('#studList').appendChild(tr);
	
	document.querySelectorAll('#stdTable input')
	        .forEach(function(item, idx, ary) {
		item.value = '';
	});
}

function makeRow(student={sno:1, sname:'test', score:90}) {
	let tr = document.createElement('tr');
	tr.addEventListener('click', displayRow, true)
	for (let prop in student) {
		let td = document.createElement('td');
		td.innerText = student[prop];
		tr.appendChild(td);
	}
	// 삭제버튼 추가.
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteRow, true);
	btn.innerText = '삭제';
	let td = document.createElement('td');
	td.appendChild(btn);
	tr.appendChild(td);
	
	return tr;
}
// 삭제.
function deleteRow(e) {
	//e.stopPropagation(); // 하 -> 상위 이벤트전파 차단.
	console.log(e.target);
	e.target.parentElement.parentElement.remove();
}
// 상세.
function displayRow(e) {
	//e.stopPropagation();
	//console.log(e.target, this);
	//id
	document.querySelector('#sno').value = this.children[0].innerText;
	//name
	document.querySelector('#sname').value = this.children[1].innerText;
	//score
	document.querySelector('#score').value = this.children[2].innerText;
}

document.querySelector('#editBtn').addEventListener('click', editRow);
function editRow(e) {
	let list = document.querySelectorAll('#studList tr');
	for(let std of list) {
		if(std.children[0].innerText == document.querySelector('#sno').value) {
			std.children[2].innerText = document.querySelector('#score').value;
			std.children[1].innerText = document.querySelector('#sname').value;
		}
	}
}

// str에 값을 활용해서 화면출력.
function makeTr() {
	for (let student of str) {
		// tr생성.
		let tr = makeRow(student);
		// tr을 tbody.appendChild
	    document.querySelector('#studList').appendChild(tr);
	}
}
makeTr();
