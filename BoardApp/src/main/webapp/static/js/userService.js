/**
 * userService.js
 */

function filterList(gender = 'Male') {
	document.querySelector('tbody').innerHTML = '';

	json//
		.filter(function(item) {
			return item.gender == gender || gender == 'All';
		})//
		.forEach(function(item) {
			document.querySelector('tbody').appendChild(makeRow(item))
		})
	// jAry.forEach()
}

function reduceList(gender = 'Female') {
	let tbody = document.querySelector('tbody');
	tbody.innerHTML = '';

	json.reduce((acc, item) => {
		if (item.gender == gender || gender == 'All') {
			acc.appendChild(makeRow(item));
		}
		return acc;
	}, tbody);
}

document.addEventListener('DOMContentLoaded', function(e) {
	console.clear();
	console.log('userService.js')
	// forEach() => 반환값은 없음.
	let fAry = json.filter(function(item, idx, ary) {
		return true; // 
	}); // filter() => 새로운 배열 생성. A -> B

	// map() A -> A'
	// item {id, fn, ln, email, salary}
	// item {id, name, salary}
	let mAry = fAry.map(item => {
		return {
			id: item.id,
			name: item.first_name + '-' + item.last_name,
			salary: item.salary
		}
	});
	console.log(mAry);

	// reduce() => 새로운 값을 생성.
	//json.reduce();

	let result = [1, 3, 2, 4, 5].reduce((acc, item, idx, ary) => {
		console.log(acc, item, idx);
		acc.push(item * 2);
		return acc;
	}, []);

	result = json.reduce((acc, item) => {
		if (item.gender == 'Male') {
			acc.push(item);
		}
		return acc;
	}, []);

	console.log(result);

}); // end of DOMContentLoaded.



