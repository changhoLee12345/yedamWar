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
	}
}