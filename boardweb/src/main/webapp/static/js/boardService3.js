/**
 * boardService3.js
 */
let param = {
	bno: bno,
	rpage: rpage
}

service.reply(param,
	function (result) {
		console.log(result);
	},
	function (err) {
	console.log(err);
	})