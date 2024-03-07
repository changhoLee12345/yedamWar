/**
 * center.js
 */
console.log('center.js');

let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=qCwQYxNXeK%2FaB1Ngf9oNZDttjmjQ6ku1OdR6%2Fd0Jj5EIdqOxMXolplih%2BYjTqB4uxCuK636co3tf9T5%2Fr9OLvw%3D%3D';

let showFields = ['id', 'centerName', 'phoneNumber', 'sido'];
let tbody = document.querySelector('#list');
let originData = '';
fetch(url)
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result.data[1]);
		originData = result.data;
		result.data.forEach(center => {
			let tr = document.createElement('tr');
			// 보여줄 항목 지정.
			showFields.forEach(field => {
				let td = document.createElement('td');
				if (field == 'centerName') {
					td.innerText = center[field].substring('코로나19 '.length);
				} else {
					td.innerText = center[field];
				}
				tr.append(td);
			})
			tbody.append(tr);
		})
	})
	.catch(err => console.log(err));

// 조회이벤트 처리.
document.querySelector('#searchBtn').addEventListener('click', function(e) {
	fetch('../registerCenter.do', {
		method: 'post',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(originData)
	})
		.then(resolve => resolve.text())
		.then(result => console.log(result))
		.catch(err => console.log(err))
})