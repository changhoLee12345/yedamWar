/**
 * bookService.js
 */
console.log('bookService.js');

$(document).ready(function() {
	// 등록버튼 이벤트.
	$('div.register>table button:eq(0)').on('click', function() {
		// 입력값이 없을 경우에는 return;
		let chk = $('<input />').attr('type', 'checkbox');
		chk.on('click', function() {
			console.log('checked: ', $('tbody input[type="checkbox"]:checked').length);
			console.log('all: ', $('tbody input[type="checkbox"]').length);
			if ($('tbody input[type="checkbox"]:checked').length == //
				$('tbody input[type="checkbox"]').length) {
				//체크박스 갯수와 선택된 갯수를 비교.
				$('thead input[type="checkbox"]').prop('checked', true)
			} else {
				$('thead input[type="checkbox"]').prop('checked', false)
			}
		});
		let btn = $('<button>삭제</button>').on('click', deleteBook);
		$('#list').append(
			$('<tr />').append(
				$('<td />').text($('#bookCode').val()),
				$('<td />').text($('#bookName').val()),
				$('<td />').text($('#bookAuthor').val()),
				$('<td />').text($('#bookPrice').val()),
				$('<td />').append(btn),
				$('<td />').append(chk)// 
			));
		// 초기화.
		//$('#bookCode').val('');

	});

	// 삭제함수.
	function deleteBook(e) {
		$(e.target).parent().parent().remove();
	}

	// 선택/해제 체크박스 이벤트.
	$('thead input[type="checkbox"]').on('change', function() {
		let chk = $(this).prop('checked');
		$('tbody input[type="checkbox"]').prop('checked', chk);
	})

	// 선택삭제 버튼 이벤트.
	$('div.register>table button:eq(1)').on('click', function() {
		$('tbody input[type="checkbox"]:checked').parent().parent().remove();
	});

});

