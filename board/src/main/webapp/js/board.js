/**
 * board.js
 * 댓글목록 5개씩 생성해주고 페이징목록 5개씩 생성.
 * 페이징을 이동할 때마다 댓글목록 5개씩 새로 생성.
 */

import { svc } from './boardService.js';

// 댓글목록 출력.
let page = 1;
svc.replyList({ bno, page }, replyListFnc2);

function replyListFnc2(result) {
	// 초기화.
	document.querySelectorAll('.content>ul>li[style="display: block;"]')//
		.forEach(item => item.remove());

	// 5개 출력.
	result.forEach(elem => {
		let template = document.querySelector('div.content>ul>li:nth-of-type(3)')//
			.cloneNode(true);

		template.querySelector('span:nth-of-type(1)').innerText = elem.replyNo;
		template.querySelector('span:nth-of-type(2)').innerText = elem.reply;
		template.querySelector('span:nth-of-type(3)').innerText = elem.replyer;
		template.querySelector('button').addEventListener('click', function(e) {
			if (logId != elem.replyer) {
				alert("권한이 없습니다.")
				return;
			}
			// 댓글삭제.
			svc.removeReply(elem.replyNo, // 삭제할 댓글번호.
				// 성공했을 때 실행할 함수.
				() => svc.replyList({ bno, page }, replyListFnc2),
				// 실패했을 때 실행할 함수.
				() => alert('처리중 에러!!'));
		});
		template.style.display = 'block';
		document.querySelector('div.content>ul').appendChild(template);
	});

	// 페이징 생성.
	svc.pagigList(bno, createPageList);
} // end of replyListFnc2.

function replyListFnc1(result) {

	result.forEach(elem => {
		let li = document.createElement('li');
		let span = document.createElement('span');
		span.innerText = elem.replyNo;
		span.className = 'col-sm-2';
		li.appendChild(span);

		span = document.createElement('span');
		span.innerText = elem.reply;
		span.className = 'col-sm-6';
		li.appendChild(span);

		span = document.createElement('span');
		span.innerText = elem.replyer;
		span.className = 'col-sm-2';
		li.appendChild(span);

		let btn = document.createElement('button');
		btn.innerText = '삭제';
		btn.className = 'col-sm-2';
		li.appendChild(btn);

		// ul
		document.querySelector('div.content ul').appendChild(li);
	});
} // replyListFnc1

function deleteFormFunc() {
	document.forms[1].action = "removeForm.do";
	document.forms[1].submit();
	document.forms[1].action = "modifyForm.do";
}

// submitForm
document.querySelector('form[name="submitForm"]') //
	.addEventListener('submit', function(e) {
		e.preventDefault(); // 기본기능 차단.
		if (logId == writer) {
			this.submit();
		} else {
			alert('권한이 없습니다.');
		}
	})

// paging 생성.
let pageTarget = document.querySelector('div.pagination');

function createPageList(result) {

	// 기존태그가 존재하면 초기화....
	pageTarget.innerHTML = '';

	let totalCnt = result.totalCount; // 64
	let startPage, endPage; // 시작페이지, 마지막페이지
	let next, prev; // 이전,이후
	let realEnd = Math.ceil(totalCnt / 5);

	endPage = Math.ceil(page / 5) * 5;
	startPage = endPage - 4;
	endPage = endPage > realEnd ? realEnd : endPage;

	next = endPage < realEnd ? true : false;
	prev = startPage > 1;

	// a 태그 생성.
	if (prev) {
		let aTag = document.createElement('a');
		aTag.innerHTML = "&laquo;";
		aTag.href = "#";
		aTag.setAttribute('data-page', (startPage - 1));
		pageTarget.appendChild(aTag);
	}
	for (let pg = startPage; pg <= endPage; pg++) {
		let aTag = document.createElement('a');
		aTag.innerHTML = pg;
		aTag.href = "#";
		aTag.setAttribute('data-page', pg);
		pageTarget.appendChild(aTag);
		if (pg == page) {
			aTag.className = 'active';
		}
	}
	if (next) {
		let aTag = document.createElement('a');
		aTag.innerHTML = "&raquo;";
		aTag.href = "#";
		aTag.setAttribute('data-page', (endPage + 1));
		pageTarget.appendChild(aTag);
	}
	// pagination 이동 event.
	document.querySelectorAll('.pagination>a').forEach(item => {
		item.addEventListener('click', function(e) {
			e.preventDefault();

			page = item.dataset.page;
			svc.replyList({ bno, page }, replyListFnc2);
		})
	})
} // end of createPageList;

// 등록버튼 클릭.
document.getElementById('addReply').addEventListener('click', function(e) {
	// 필수입력값 확인!!
	if (!logId) {
		alert("로그인 하세요!!");
		return;
	}
	let reply = document.getElementById('reply').value;
	if (!reply) {
		alert('댓글을 입력하세요!!');
		return;
	}
	// 입력값.
	let rvo = {
		bno: bno,// 
		replyer: logId, //
		reply: reply
	}
	// 서비스등록 메소드.
	svc.addReply(rvo, function(result) {

		if (result.retCode == 'Success') {
			svc.replyList({ bno, page }, replyListFnc2);
		} else {
			alert('처리중 에러가 발생!!');
		}
	});
	document.getElementById('reply').value = ''; // 초기화.
});
