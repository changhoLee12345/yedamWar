/**
 * 
 */
console.log('datatable.js')

var table = $('#example').DataTable({
	ajax: 'dataTable.do?bno=' + bno,
	columns: [
		{ data: 'replyNo' },
		{ data: 'reply' },
		{ data: 'replyer' },
		{ data: 'replyDate' }
	],
	lengthMenu: [
		[5, 10, 25, 50, -1],
		[5, 10, 25, 50, 'All']
	]
});

var counter = 1;

$('.addReply').on('click', function() {
	let reply = $('#reply').val();
	$.ajax({
		url: 'addReply.do',
		method: 'post',
		data: { bno, reply, replyer },
		dataType: 'json'
	})
		.done(function(result) {
			let item = result.retVal;
			console.log(item);
			table.row
				.add({
					'replyNo': item.replyNo, 'reply': item.reply, 'replyer': item.replyer, 'replyDate': item.replyDate
				})
				.draw(false);
		})
		.fail(function(err) {
			console.log(err);
		})

	counter++;
});