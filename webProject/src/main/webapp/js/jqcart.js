/*
* jqcart.js
*/
// 숫자 3자리 콤마찍기
Number.prototype.formatNumber = function() {
	if (this == 0)
		return 0;
	let regex = /(^[+-]?\d+)(\d{3})/;
	let nstr = (this + '');
	while (regex.test(nstr)) {
		nstr = nstr.replace(regex, '$1' + ',' + '$2');
	}
	return nstr;
};

console.log('start');

const basket = {
	cartCount: 0, //전체수량.
	cartTotal: 0, // 전체금액.
	//목록.
	list: function() {
		svc.cartList(function(result) {
			console.log(result);
			result.forEach(cart => {
				// 수량누적.
				basket.cartCount += cart.qty;
				basket.cartTotal += (cart.qty * cart.price);

				let temp = $('[data-id]:eq(0)').clone();
				temp.css('display', 'block');
				temp.attr('data-id', cart.no);
				temp.find('div.img img').attr('src', 'image/' + cart.productNm + '.jpg');
				temp.find('div.pname span').text(cart.productNm);
				temp.find('div.basketprice').text(cart.price.formatNumber() + "원");
				temp.find('div.basketprice').prepend($('<input />')
					.attr({ 'type': 'hidden', 'name': 'p_price', 'id': 'p_price' + cart.no })
					.addClass('p_price')
					.val(cart.price)
				);
				temp.find('div.sum').text((cart.price * cart.qty).formatNumber() + "원");
				temp.find('div.sum').attr('id', 'p_sum' + cart.no);
				temp.find('div.updown input').val(cart.qty);
				temp.find('div.updown input').attr('id', 'p_num' + cart.no);

				// keyup, click 등록.
				temp.find('div.updown input').keyup(() => basket.changePNum(cart.no));
				temp.find('div.updown span').click(() => basket.changePNum(cart.no));

				temp.appendTo('#basket');
			});
			basket.reCalc();

		}, function(err) {
			console.log(err);
		})
	}, // end of list.
	// 합계수량, 금액 출력.
	reCalc() {
		$('#sum_p_num span').text(basket.cartCount);
		$('#sum_p_price span').text(basket.cartTotal.formatNumber());
	},
	// 수량변경. no, qty(1, -1)
	changePNum(no) {

		if (!no) {
			return;
		}
		console.log(event);
		let qty = -1;
		if (event.target.nodeName == "I") {
			if (event.target.className.indexOf('up') != -1) {
				qty = 1;
			}
		} else if (event.target.nodeName == "INPUT") {
			if (event.key == 'ArrowUp') {
				qty = 1;
			}
		} // end of if.

		let qtyElem = $('#p_num' + no); //현재수량의 input.
		let sumElem = $('#p_sum' + no); //현재합계금액.
		let price = $('#p_price' + no).val(); // 단가.
		let curQty = qtyElem.val();

		let cvo = { no, qty }
		svc.cartUpdate(cvo,
			(result) => {
				console.log(result);
				if (result.retCode == "Success") {
					qtyElem.val(parseInt(curQty) + qty);
					sumElem.text(((parseInt(curQty) + qty) * parseInt(price)).formatNumber() + "원");
					// 수량, 금액 변경.
					basket.cartCount += qty;
					basket.cartTotal += (price * qty);

					basket.reCalc(); // 합계부분.
				}
			},
			() => {
				alert('에러가 발생.');
			}
		);

	}, // end of changePNum.

	// 한건삭제.
	delItem() {
		let delNo = $(event.currentTarget).closest('div.row').data('id');
		console.log(delNo);

		svc.cartRemove(delNo,
			(result) => {
				if (result.retCode == 'Success') {
					let price = $('#p_price' + delNo).val();
					let qty = $('#p_num' + delNo).val();
					basket.cartCount -= qty;
					basket.cartTotal -= (price * qty);
					basket.reCalc();

					$('[data-id="' + delNo + '"]').remove();
				}
			},
			(err) => {

			}
		)
	},// end of delItem.
	delCheckedItem() {

	}, // end of delCheckedItem
	delAllItem() {

	} // end of delAllItem
}

basket.list();