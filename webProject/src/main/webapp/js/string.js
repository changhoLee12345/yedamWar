/**
 * string.js
 */
// form 요소 제거.
document.querySelector('form').remove();
document.getElementById('show').innerHTML = '';

let str1 = new String('hello');
console.log(typeof str1);

let str2 = ' hello ';

console.log(str2.trim().toUpperCase().slice(-2));

let str3 = 'hello,nice,kind';
console.log(str3.indexOf('nice'))

let str4 = str3.replace('hello', '안녕');
console.log(str3, str4);

let str3Ary = str3.split(",");
console.log(str3Ary);
str3.charAt(0);// 위치의 인덱스에 해당하는 문자반환.

// 성별을 구분하는 함수.
function checkGender(sso = '031005-4234567') {
	// 1, 3 -> 남자 반환
	// 2, 4 -> 여자 반환.
	let genChar = sso.replace('-', '').replace(' ', '');
	console.log(genChar)
	switch (genChar.charAt(6)) {
		case '1':
		case '3': console.log("남자"); break;
		case '2':
		case '4': console.log("여자");
	}
}
let numbers = ['990102-2345678', '010204-3123456'//
	, '0303044123456', '970304 1123456'];
numbers.forEach(elem => checkGender(elem));

console.clear();
// Date객체.
const today = new Date(); // 실행시점의 시스템시간.

// 년,월을 지정해서 달력출력.
document.getElementById('calBtn').addEventListener('click', function(e) {
	const year = document.getElementById('year').value;
	const mon = document.getElementById('month').value;
	createCalendar(year, mon);

})

// 출력위치 지정.
const show = document.querySelector('#show');

createCalendar();
function createCalendar(year = 2024, month = 4) {
	show.innerHTML = '';

	show.innerHTML = "<h3>" + year + "년" + month + "월" + "</h3 > ";

	const thisMonth = new Date(year, month - 1, 1);
	console.log(thisMonth);

	// table 생성.
	let table = document.createElement('table');
	table.className = 'table';
	show.appendChild(table);

	// 요일 출력 
	const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat']
	let thead = document.createElement('thead');
	let tr = document.createElement('tr');
	days.forEach(function(elem) {
		let th = document.createElement('th');
		th.innerText = elem;
		tr.appendChild(th);
	})
	thead.appendChild(tr);
	table.appendChild(thead);

	// 날짜 출력 ()
	let tbody = document.createElement('tbody');

	// 요일지정.
	let spaces = thisMonth.getDay();
	tr = document.createElement('tr');
	// 빈공간 td.
	for (let d = 0; d < spaces; d++) {
		let td = document.createElement('td');
		td.innerText = '';
		tr.appendChild(td);
	}

	thisMonth.setMonth(month);
	thisMonth.setDate(0);
	let end = thisMonth.getDate();
	for (let d = 1; d <= end; d++) {
		let td = document.createElement('td');
		td.innerText = d;
		tr.appendChild(td);
		// 토, 일 색상지정.
		if ((d + spaces) % 7 == 0) {
			td.style.background = 'blue';
			td.style.color = 'yellow';
		} else if ((d + spaces) % 7 == 1) {
			td.style.background = 'red';
			td.style.color = 'yellow';
		}

		if ((d + spaces) % 7 == 0) {
			tbody.appendChild(tr)
			tr = document.createElement('tr');
		}
	}
	tbody.appendChild(tr);

	table.appendChild(tbody);
}

// timer.
let timer = document.getElementById('timer');
// setInterval(함수, 시간간격);

setInterval(function() {
	let now = new Date();
	timer.innerHTML = now.format();
}, 1000);

Date.prototype.format = function() {
	let yyyy = this.getFullYear();
	let MM = this.getMonth() + 1;
	let dd = this.getDate();
	let hh = this.getHours();
	let mm = this.getMinutes();
	let ss = this.getSeconds();

	return yyyy + "/" + ("0" + MM).slice(-2) + "/" + ("0" + dd).slice(-2)//
		+ " " + ("0" + hh).slice(-2) + ":" + ("0" + mm).slice(-2) 
		+ ":" + ("0" + ss).slice(-2);
}


