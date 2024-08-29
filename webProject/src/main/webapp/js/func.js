/**
 * func.js
 */
const fruits = ['Apple', 'Banana', 'Cherry'];

document.querySelector('#show').innerHTML = '';

// 화살표 함수.
let ul = document.createElement('ul');
document.querySelector('#show').appendChild(ul);

fruits.forEach(elem => {
	let li = document.createElement('li');
	li.addEventListener('mouseover', e => {
		li.style.background = 'red';
	});
	li.addEventListener('mouseout', e => {
		li.style.background = '';
	});
	li.innerText = elem; // <li>Apple <button>삭제</button></li>
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	btn.addEventListener('click', e => btn.parentElement.remove()); // 이벤트유형, 이벤트핸들러.
	// button의 상위요소(li)
	li.appendChild(btn);

	ul.appendChild(li);
});
