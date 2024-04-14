/**
 * 댓글관련 함수..
 */
let page = 1;
document.querySelector('div.pagination').addEventListener('click', function(e) {
	console.log(e.target);
	e.preventDefault();
	page = e.target.getAttribute('href');

	replyList(page);
	pagingList(page);
})

const targetUl = document.querySelector('div.content>ul');

// 댓글출력함수.
function replyList(rpage = 1) {

	fetch('replyList.do?bno=' + bno + '&rpage=' + rpage)
		.then(resolve => resolve.json())
		.then(result => {
			replyListCallback(result);
		})
		.catch(err => console.log(err));

	// 목록출력하는 콜백함수.
	const replyListCallback = function(boardAry = []) {
		document.querySelectorAll('div.content>ul>li').forEach((item, idx) => {
			console.log(item)
			if (idx > 2) {
				item.remove();
			}
		})
		boardAry.forEach(board => {
			let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true);
			template.style.display = 'block';
			template.querySelector('span:nth-of-type(1)').textContent = board.replyNo;
			template.querySelector('span:nth-of-type(2)').textContent = board.reply;
			template.querySelector('span:nth-of-type(3)').textContent = board.replyer;
			targetUl.appendChild(template);
		})
	}
}
replyList(); // 함수호출.

// 페이지 출력 함수.
let targetPage = document.querySelector('div.footer .pagination');

function pagingList(rpage = 1) {

	fetch('replyCount.do?bno=' + bno)
		.then(resolve => resolve.json())
		.then(result => {

			targetPage.innerHTML = '';

			let totalCnt = parseInt(result.totalCount);
			let realEnd = Math.ceil(totalCnt / 5);
			let endPage = Math.ceil(rpage / 5) * 5;
			let startPage = endPage - 4;

			endPage = endPage > realEnd ? realEnd : endPage;

			let prev = startPage > 1;
			let next = endPage < realEnd;

			if (prev) {
				let aTag = document.createElement('a');
				aTag.setAttribute('href', startPage - 1);
				aTag.innerHTML = '<<';
				targetPage.appendChild(aTag);
			}

			for (let p = startPage; p <= endPage; p++) {
				let aTag = document.createElement('a');
				aTag.setAttribute('href', p);
				if (rpage == p) {
					aTag.className = 'active';
				}
				aTag.textContent = p;
				targetPage.appendChild(aTag);
			}

			if (next) {
				let aTag = document.createElement('a');
				aTag.setAttribute('href', endPage + 1);
				aTag.innerHTML = '>>';
				targetPage.appendChild(aTag);
			}

		})
		.catch(err => console.log(err))
}
pagingList();