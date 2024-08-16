/**
 * boardService3.js
 */
let page = 1;
// 댓글목록 5건 출력.
service.replyList({ bno: bno, page: page },// 인자값1
	replyListCall,
	err => console.log('error=> ', err)
);

function replyListCall(result) {
	let ul = $('.content>ul');
	// 기존목록 삭제.
	$('.content>ul>li:gt(1)').remove();

	$(result).each(function(idx, item) {
		let clon = $('.content>ul>li').eq(0).clone();
		let btn = $('<button>삭제</button>')

		clon.find('span:eq(0)').text(item.replyNo);
		clon.find('span:eq(1)').text(item.reply);
		clon.find('span:eq(2)').text(item.replyer);
		clon.find('span:eq(3)').html(btn);
		ul.append(clon);
	});

	// 페이지 리스트 생성.
	service.pageList(bno,
		createPageElement,
		err => console.log('error=> ', err)
	)
}

// 페이지 목록 출력.
/*service.pageList(bno,
	createPageElement,
	err => console.log('error=> ', err)
)*/

// 페이지 목록 생성.
function createPageElement(result) {
	// 기존 페이지 삭제.
	let pagination = $('div.pagination');
	pagination.html('');

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
		$('<a />').attr('href', '#').attr('data-page', startPage - 1)//
			.html('&laquo;').appendTo(pagination);
	}
	for (let p = startPage; p <= endPage; p++) {
		let aTag = $('<a />').attr('href', '#').attr('data-page', p)//
			.html(p).appendTo(pagination);
		if (p == page) {
			aTag.addClass('active');
		}
	}
	if (next) {
		$('<a />').attr('href', '#').attr('data-page', endPage + 1)//
			.html('&raquo;').appendTo(pagination);
	}
}

// 페이지 이동.
$('.pagination').on('click', 'a', function(e) {
	page = $(this).data('page');
	service.replyList({ bno: bno, page: page },// 인자값1
		replyListCall,
		err => console.log('error=> ', err)
	);
})


$('.addReply').click(function(e) {

	service.pageList(bno,
		result => {
			page = Math.ceil(result.totalCount / 5);
			service.replyList({ bno: bno, page: page },// 인자값1
				replyListCall,
				err => console.log('error=> ', err)
			);

		}
	)

})