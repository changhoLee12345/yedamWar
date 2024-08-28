/**
 * boardService.js
 */
const n1 = 100;
const n2 = 200;

const svc = {
	// 댓글목록 메소드.
	replyList(param = { bno: 1, page: 1 }, successCall) {
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', 'replyList.do?bno=' + param.bno + '&page=' + param.page);
		xhtp.send();
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.response);
			successCall(result);
		}
	},
	// 댓글삭제
	removeReply(rno = 1, successCall, errorCall) {
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', 'removeReply.do?rno=' + rno);
		xhtp.send();
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.response);
			if (result.retCode == 'Success') {
				successCall();
			} else {
				errorCall();
			}
		}
	},
	// 페이징목록
	pagigList(bno = 1, successCall) {
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', 'replyCount.do?bno=' + bno);
		xhtp.send();
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.response); // "json" -> obj. 
			successCall(result);
		}
	},
	// 댓글등록
	addReply(rvo = { bno, reply, replyer }, successCall) {
		let xhtp = new XMLHttpRequest();
		xhtp.open('post', 'addReply.do');
		xhtp.setRequestHeader('Content-Type', "application/x-www-form-urlencoded");
		xhtp.send('bno=' + rvo.bno + '&reply=' + rvo.reply + '&replyer=' + rvo.replyer);
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.response); // "json" -> obj. 
			successCall(result);
		}
	}
} // end of svc.

export { svc };
