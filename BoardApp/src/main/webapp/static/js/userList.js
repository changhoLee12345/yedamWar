/**
 * userList.js
 */
console.log('userList.js');

let str = `[{"id":1,"first_name":"Wernher","last_name":"Cromar","email":"wcromar0@hubpages.com","gender":"Male","salary":3768},
{"id":2,"first_name":"Coriss","last_name":"Capaldo","email":"ccapaldo1@altervista.org","gender":"Female","salary":4090},
{"id":3,"first_name":"Melesa","last_name":"Strase","email":"mstrase2@hibu.com","gender":"Female","salary":4683},
{"id":4,"first_name":"Teresita","last_name":"Inwood","email":"tinwood3@gizmodo.com","gender":"Female","salary":4349},
{"id":5,"first_name":"Salli","last_name":"Rheubottom","email":"srheubottom4@jalbum.net","gender":"Female","salary":4283},
{"id":6,"first_name":"Anallese","last_name":"Baribal","email":"abaribal5@answers.com","gender":"Female","salary":2481},
{"id":7,"first_name":"Myca","last_name":"Clutterham","email":"mclutterham6@sogou.com","gender":"Male","salary":3357},
{"id":8,"first_name":"Devinne","last_name":"Litel","email":"dlitel7@hugedomains.com","gender":"Female","salary":3911},
{"id":9,"first_name":"Nanine","last_name":"Matei","email":"nmatei8@nih.gov","gender":"Female","salary":4621},
{"id":10,"first_name":"Colline","last_name":"Shurrock","email":"cshurrock9@lycos.com","gender":"Female","salary":4559},
{"id":11,"first_name":"Gabby","last_name":"Guirau","email":"gguiraua@tinyurl.com","gender":"Male","salary":4862},
{"id":12,"first_name":"Olympe","last_name":"Hurdidge","email":"ohurdidgeb@economist.com","gender":"Female","salary":2757},
{"id":13,"first_name":"Bobbette","last_name":"Keelan","email":"bkeelanc@over-blog.com","gender":"Female","salary":4512},
{"id":14,"first_name":"Hilly","last_name":"Brockman","email":"hbrockmand@latimes.com","gender":"Male","salary":3389},
{"id":15,"first_name":"Pascal","last_name":"Dance","email":"pdancee@yelp.com","gender":"Male","salary":3122}]`;

let json = JSON.parse(str); // 문자열 -> object로 변환.

document.addEventListener('DOMContentLoaded', function(e) {

	document.querySelector('#name').value = '홍길동';

	// thead 생성.
	let title = json[0];
	let tr = document.createElement('tr');
	for (let prop in title) {
		let th = document.createElement('th');
		th.innerText = prop;
		tr.appendChild(th);
	}
	document.querySelector('#tableList thead').appendChild(tr);

	// tbody 영역.
	json.forEach(function(item, idx) {
		console.log(item, idx); // item => {}
		if (idx < 10) { // 최초에는 10건만 출력하기.
			let tr = makeRow(item);
			document.querySelector('#tableList tbody').appendChild(tr);
		}
	});

	// change 이벤트 처리.
	document.querySelector('#genderList') //
		.addEventListener('change', function(e) {
			// showList(this.value);
			// filterList(this.value);
			reduceList(this.value);
		});

}); // end of DOMContentLoaded.

// 한건 생성.
function makeRow(obj = {}) {
	let tr = document.createElement('tr');
	for (let prop in obj) {
		let td = document.createElement('td');
		td.innerText = obj[prop];
		tr.appendChild(td);
	}
	return tr;
}

// 성별에 따른 목록출력.
function showList(gender = 'Male') {

	// 조회목록 초기화.
	document.querySelector('tbody').innerHTML = '';

	json.forEach(function(item) {
		if (item.gender == gender || gender == 'All') {
			document.querySelector('tbody').appendChild(makeRow(item))
		}
	})
}
showList()