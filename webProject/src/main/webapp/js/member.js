/**
 * member.js
 */

const fields = ['id', 'first_name', 'last_name', 'email', 'salary', 'gender'];

document.querySelector('#show>table').innerHTML = '';
const tab = document.querySelector('#show>table');
tab.appendChild(makeHeader()); // thead.
tab.appendChild(makeBody()); // tbody.

// thead 생성. 아이디/이름/이메일/성별/급여
function makeHeader() {
	// thead 생성. tr 생성. th*5
	let thd = document.createElement('thead');
	let tr = document.createElement('tr');
	thd.appendChild(tr);
	fields.forEach(field => {
		let th = document.createElement('th');
		th.innerHTML = field;
		tr.appendChild(th);
	});
	return thd;
}

// tbody 생성. 데이터를 기반 생성.
function makeBody() {
	let thd = document.createElement('tbody');
	members.forEach((elem, idx) => {
		//console.log(elem, idx);
		if (idx < 2) {
			thd.appendChild(makeRow(elem)); // tr생성 반환.			
		}
	});
	return thd;
}

// row 생성.
function makeRow(member = {}) {
	let tr = document.createElement('tr');
	// td요소 생성.
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = member[field];
		tr.appendChild(td);
	})
	tr.addEventListener('click', function(e) {
		//console.log(tr.children)
		e.stopPropagation();
		document.getElementById('mid').value = tr.children[0].innerHTML;
		document.getElementById('fname').value = tr.children[1].innerHTML;
		document.getElementById('lname').value = tr.children[2].innerHTML;
		document.getElementById('email').value = tr.children[3].innerHTML;
		document.getElementById('salary').value = tr.children[4].innerHTML;
		document.getElementById('gender').value = tr.children[5].innerHTML;
	}, false); // capturing(상->하), bubbling(하->상)
	// 버튼 추가.
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	btn.className = "btn"; // <button class="btn" /> btn.setAttribute('class', 'btn')
	btn.classList.add('btn-danger');
	btn.addEventListener('click', e => {
		e.stopPropagation(); // 상위요소로 이벤트 전파 차단.
		btn.parentElement.parentElement.remove();
	}, false);
	let td = document.createElement('td');
	td.appendChild(btn);
	tr.appendChild(td);

	return tr;
}

// 저장 버튼 이벤트.
document.getElementById('addBtn').addEventListener('click', function(e) {
	console.log('message');
	// id, fname, lname, email, gender, salary => 입력값.
	const userVal = {}
	userVal.id = document.getElementById('mid').value;
	userVal.first_name = document.getElementById('fname').value;
	userVal.last_name = document.getElementById('lname').value;
	userVal.email = document.getElementById('email').value;
	userVal.gender = document.getElementById('gender').value;
	userVal.salary = document.getElementById('salary').value;

	let tr = makeRow(userVal);
	document.querySelector('#show tbody').appendChild(tr);
});

document.querySelector('form:nth-of-type(1)')//
	.addEventListener('submit', function(evt) {
		evt.preventDefault(); // submit 기본기능 차단.

	});

// 수정 처리.
document.getElementById('editBtn').addEventListener('click', function(e) {

	const mid = document.getElementById('mid').value;

	document.querySelectorAll('#show tbody tr').forEach(item => {
		if (mid == item.children[0].innerHTML) {
			item.children[1].innerHTML = document.getElementById('fname').value;
			item.children[2].innerHTML = document.getElementById('lname').value;
			item.children[3].innerHTML = document.getElementById('email').value;
			item.children[4].innerHTML = document.getElementById('salary').value;
			item.children[5].innerHTML = document.getElementById('gender').value;

		}
	})
});
