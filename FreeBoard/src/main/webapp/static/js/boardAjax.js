/**
 * 
 */
const service = {
	replyList(param = {}, successCall, errorCall) {
		$.ajax({
			url: 'replyList.do?bno=' + param.bno + '&page=' + param.rpage,
			method: 'get',
			success: successCall,
			error: errorCall
		})
	},
	pageList(bno, successCall, errorCall) {
		$.ajax({
			url: 'getTotal.do',
			method: 'post',
			dataType: 'json',
			data: { bno },
			success: successCall,
			error: errorCall
		})
	},
	addReply(param = {}, successCall, errorCall) {
		$.ajax({
			url: 'addReply.do',
			method: 'post',
			data: param,
			dataType: 'json',
			success: successCall,
			error: errorCall
		})
	},
	removeReply(rno, successCall, errorCall) {
		$.ajax({
			url: 'removeReply.do',
			method: 'post',
			dataType: 'json',
			data: { rno: rno },
			success: successCall,
			error: errorCall
		})
	}
}