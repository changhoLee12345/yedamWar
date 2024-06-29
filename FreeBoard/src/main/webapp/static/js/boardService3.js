/**
 * boardService3.js
 */

let page = 1;

const ulTag = $('.reply ul');

// page링크 이벤트.
$('.reply .pagination').on('click', 'a', function(e) {
	e.preventDefault();
	page = $(this).data('page');
	service.replyList({ bno: bno, rpage: page },
		replyListCall,
		err => console.log(err))
})

// 등록이벤트.
$('.addReply').on('click', function(e) {
	let reply = $('input[name="reply"]').val();

	service.addReply({ bno, reply, replyer },
		//success callback.
		result => {
			if (result.retCode == 'OK') {
				service.replyList({ bno: bno, rpage: 1 },
					replyListCall,
					function(err) {
						console.log(err);
					})
			}
		},
		//error callback.
		err => console.log(err))
})

// 5건씩 보여주는 댓글 목록 리스트.
service.replyList({ bno: bno, rpage: 1 },
	replyListCall,
	err => console.log(err))

function replyListCall(result) {
	$('.content ul li:gt(1)').remove();

	result.forEach(reply => {
		let clon = $('.reply ul li:eq(0)').clone();

		const delBtn = $('<button>삭제</button>').on('click', function(e) {
			service.removeReply(reply.replyNo,
				result => {
					alert(result.retMsg);
					if (result.retCode == 'OK') {
						service.replyList({ bno: bno, rpage: page }, replyListCall, err => console.log(err))
					}
				},
				err => console.lor(err))
		});

		clon.find('span:eq(0)').text(reply.replyNo);
		clon.find('span:eq(1)').text(reply.reply);
		clon.find('span:eq(2)').text(reply.replyer);
		clon.find('span:eq(3)').html(delBtn);
		ulTag.append(clon);
	})

	service.pageList(bno, pageListCall, err => console.log(err));
} // end of replyListCall()

// 5페이지씩 보여주는 리스트.
service.pageList(bno, pageListCall, err => console.log(err));

// pageList 콜백함수.
function pageListCall(result) {

	$('div.pagination').html('');

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
		let aTag = $('<a />').html('&laquo;').attr('href', '#').attr('data-page', startPage - 1);
		$('div.pagination').append(aTag);
	}
	for (let p = startPage; p <= endPage; p++) {
		let aTag = $('<a />').html(p).attr('href', '#').attr('data-page', p);
		if (p == page) {
			aTag.addClass('active');
		}
		$('div.pagination').append(aTag);
	}
	if (next) {
		let aTag = $('<a />').html('&raquo;').attr('href', '#').attr('data-page', endPage + 1);
		$('div.pagination').append(aTag);
	}

} // end of pageListCall()