/**
 * boardDataTable.js : datatable 기능을 보기위한 예제.
 */
const table = new DataTable('#example', {
	ajax: 'datatable.do?bno=' + bno,
	columns: [{ data: 'replyNo' },
	{ data: 'reply' },
	{ data: 'replyer' },
	{ data: 'replyDate' }
	],
	lengthMenu: [
		[5, 10, 25, -1],
		[5, 10, 25, 'All']
	],
	order: [
		[0, 'desc']
	],
	columnDefs: [{
		render: (data, type, row) => "<button onclick=''>Delete</button>",
		targets: 4
	},
		//{ visible: false, targets: [3] }
	]
});
let selectedNo = -1; // 선택한 tr의 댓글번호를 담아놓기 위한 변수.
table.on('click', 'tbody tr', (e) => {

	if (selectedNo == -1) {
		selectedNo = e.currentTarget.children[0].innerText;
	} else {
		selectedNo = -1;
	}

	let classList = e.currentTarget.classList;

	if (classList.contains('selected')) {
		classList.remove('selected');
	} else {
		table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
		classList.add('selected');
	}

	if (e.target.nodeName == 'BUTTON') {
		deleteRow(e);
	}
});

function addNewRow(reply = {}) {
	table.row
		.add({
			replyNo: reply.replyNo,
			reply: reply.reply,
			replyer: reply.replyer,
			replyDate: reply.replyDate
		})
		.draw(false);

} // end of addNewRow().

// addReply 를 클릭하면...ajax호출...성공: 화면에 row추가.
document.querySelector('#addReply').addEventListener('click', function(e) {
	let reply = document.querySelector('#reply').value;
	if (!logId) {
		alert("로그인하세요...");
		return;
	}
	if (!reply) {
		alert("댓글입력하세요...");
		return;
	}
	// ajax호출.
	fetch('addReply.do', {
		method: 'post',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: 'bno=' + bno + '&reply=' + reply + '&replyer=' + logId
	})
		.then(result => result.json())
		.then(result => {
			console.log(result);
			if (result.retCode == 'Success') {
				alert('등록성공!!!');
				addNewRow(result.retVal);
			}
			document.querySelector('#reply').value = '';
		})
		.catch(err => console.error(err));
}); // 등록버튼 이벤트.

document.querySelector('#button').addEventListener('click', deleteRow); // 삭제이벤트.

function deleteRow(e) {
	e.stopPropagation();
	fetch('removeReply.do?rno=' + selectedNo)
		.then(result => result.json())
		.then(result => {
			if (result.retCode == 'Success') {
				alert('삭제성공!!');
				table.row('.selected').remove().draw(false);
				selectedNo = -1;
			} else {
				alert('삭제할 댓글을 선택하세요.')
			}
		})
		.catch(err => console.error(err))
}