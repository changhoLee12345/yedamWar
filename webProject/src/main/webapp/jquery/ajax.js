/**
 * ajax.js
 */
$(document).ready(function() {
	// 페이지로딩 후 목록 출력.memberAjax.do
	// fetch().then().then().then().catch()
	$.ajax({
		url: '../memberAjax.do', //호출페이지.
		method: 'get',
		dataType: 'json' // JSON.parse();
	})
		.done(function(result) {
			console.log(result);
			// 목록출력. id, 이름, 연락처, 비번. => 작성.
			result.forEach(member => {
				$('div#show tbody').append(makeRow(member))
			})
		})
		.fail(function(err) {
			console.error(err);
		})
		.always(function(data) {
			//console.log(data);
		})

	// 등록버튼 이벤트.
	$('div#register form[name="myFrm"]').on('submit', function(e) {
		e.preventDefault(); // 
		let data = $('form[name="myFrm"]').serialize();
		console.log(data);

		$.ajax({
			url: '../addMemberAjax.do',
			method: 'post',
			data: data, // 전송데이터
			dataType: 'json'
		})
			.done(function(result) {
				let member = {
					memberId: $('input[name="mid"]').val(),
					memberPw: $('input[name="pass"]').val(),
					memberNm: $('input[name="name"]').val(),
					phone: $('input[name="phone"]').val()
				}
				if (result.retCode == "Success") {
					$('div#show tbody').append(makeRow(member))
				} else {
					alert('처리중 예외.')
				}
			})
			.fail(function(err) {
				console.error(err);
			})
	})
});

function makeRow(member = {}) {
	return $('<tr />').append($('<td />').text(member.memberId)//
		, $('<td />').text(member.memberNm)//
		, $('<td />').text(member.phone)//
		, $('<td />').text(member.memberPw)//
	);
}