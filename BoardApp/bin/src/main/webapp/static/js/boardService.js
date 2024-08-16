/**
 * boardService.js
 */
// .pagination>a click이벤트.
console.log('javascript')
let page = 1;
function pagingFunc() {
	document.querySelectorAll('.pagination>a') // NodeList
		.forEach(item => {

			item.addEventListener('click', function(e) {
				e.preventDefault(); // 링크의 기능 차단.
				page = item.dataset.page; // item.getAttribute('data-page');
				replyList(page); //링크를 클릭할때마다 목록을 새롭게 그리고.
				pageList(); // 페이지목록을 새롭게 그리고.
			})

		});
}

// 등록이벤트.
document.querySelector('.addReply').addEventListener('click', addReplyFnc);
async function addReplyFnc(e) {

	let reply = document.querySelector('input[name="reply"]').value;
	if (!reply) {
		alert('댓글입력하세요.');
		return;
	} else if (!replyer) {
		alert('로그인 후 처리가능합니다.');
		return;
	}

	// ajax 호출.
	try {
		let resolve = await fetch('addReply.do', {
			method: 'post',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: 'bno=' + bno + '&reply=' + reply + '&replyer=' + replyer
		});
		let result = await resolve.json();
		if (result.retCode == 'OK') {
			alert('등록성공');
			document.querySelector('#reply').value = '';

			resolve = await fetch('getTotal.do?bno=' + bno);
			result = await resolve.json();
			page = Math.ceil(result.totalCount / 5);
			replyList(page);
			pageList();

		} else {
			alert('처리실패')
		}
	} catch (err) {
		console.log(err);
	} // end of ajax호출.

} // end of addReplyFnc

// 댓글 목록.
function makeRow(obj = {}) {
	let fields = ['replyNo', 'reply', 'replyer'];
	let liTag = document.createElement('li');
	liTag.setAttribute('data-rno', obj.replyNo);
	fields.forEach(prop => {
		let span = document.createElement('span');
		span.innerText = obj[prop];
		if (prop == 'reply') {
			span.className = 'col-sm-6';
		} else {
			span.className = 'col-sm-2';
		}
		liTag.appendChild(span);
	});
	// 삭제버튼.
	let span = document.createElement('span');
	span.className = 'col-sm-2';
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteRow);
	btn.innerText = '삭제';
	span.appendChild(btn);
	liTag.appendChild(span);
	return liTag;
}

function makeRow2(obj = {}) {
	let clon = document.querySelector('.content>ul>li:nth-of-type(1)')//
		.cloneNode(true);
	clon.setAttribute('data-rno', obj.replyNo);
	clon.querySelector('span:nth-of-type(1)').innerText = obj.replyNo;
	clon.querySelector('span:nth-of-type(2)').innerText = obj.reply;
	clon.querySelector('span:nth-of-type(3)').innerText = obj.replyer;
	// 삭제버튼.
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteRow);
	btn.innerText = '삭제';
	clon.querySelector('span:nth-of-type(4)').innerText = '';
	clon.querySelector('span:nth-of-type(4)').appendChild(btn);
	return clon;
}

// 삭제함수.
async function deleteRow(e) {
	let rno = this.parentElement.parentElement.dataset.rno;
	let li = this.parentElement.parentElement;
	// 작성자와 로그인 비교.
	console.dir(this.parentElement);
	let writer = this.parentElement.previousElementSibling.innerText;
	writer = li.querySelector('span:nth-of-type(3)').innerText;
	if (replyer != writer) {
		alert('삭제권한이 없습니다.')
		return;
	}
	// ajax 호출.
	const optObj = {
		method: 'post',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: 'rno=' + rno
	}

	try {
		let resolve = await fetch('removeReply.do', optObj);
		let result = await resolve.json();
		if (result.retCode == 'OK') {
			alert(result.retMsg);
			replyList(page);
			pageList();
		} else {
			alert(result.retMsg);
		}
	} catch (err) {
		console.log(err);
	}

} // end of deleteRow

// 목록함수.
function replyList(rpage = 1) {
	// ajax 호출.
	fetch('replyList.do?bno=' + bno + '&page=' + rpage)
		.then(resolve => resolve.json()) // 문자열 -> 객체.
		.then(data => {
			// 기존목록 삭제.
			document.querySelectorAll('li[data-rno]').forEach(item => item.remove());
			// 목록.
			data.forEach(item => {
				document.querySelector('.reply ul').appendChild(makeRow2(item));
			})
			// 목록이 없을 경우에..
			if (!data.length && page > 1) {
				page--;
				replyList(page);
				pageList();
			}
		})
		.catch(function(err) {
			console.log('error==>', err);
		})

}
replyList(); // 최초호출.

// 페이징 목록.
function pageList() {
	// ajax 호출.
	fetch('getTotal.do?bno=' + bno)
		.then(resolve => resolve.json()) // 문자열 -> 객체.
		.then(createPageElement)
		.catch(function(err) {
			console.log('error==>', err);
		}) // end of fetch

	function createPageElement(result) {
		// 기존 페이지 삭제.
		document.querySelector('div.pagination').innerHTML = '';

		let totalCnt = result.totalCount;
		let startPage, endPage; // 1~5, 6~10
		let next, prev;
		let realEnd = Math.ceil(totalCnt / 5);
		endPage = Math.ceil(page / 5) * 5;
		startPage = endPage - 4;
		endPage = endPage > realEnd ? realEnd : endPage;
		next = endPage < realEnd ? true : false;
		prev = startPage > 1;

		if (prev) {
			let aTag = document.createElement('a');

			aTag.innerHTML = '&laquo;'; // <<
			aTag.href = '#';
			aTag.setAttribute('data-page', startPage - 1)
			document.querySelector('div.pagination').appendChild(aTag);
		}
		for (let p = startPage; p <= endPage; p++) {
			let aTag = document.createElement('a');
			aTag.innerText = p;
			aTag.href = '#';
			aTag.setAttribute('data-page', p);
			if (p == page) {
				aTag.className = 'active';
			}
			document.querySelector('div.pagination').appendChild(aTag);
		}
		if (next) {
			let aTag = document.createElement('a');

			aTag.innerHTML = '&raquo;'; // >>
			aTag.href = '#';
			aTag.setAttribute('data-page', endPage + 1)
			document.querySelector('div.pagination').appendChild(aTag);
		}
		pagingFunc(); // 새로 생성된 a에 이벤트 등록.
	}
} // end of pageList
pageList(); // 최초 호출.
