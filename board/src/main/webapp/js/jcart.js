// 숫자 3자리 콤마찍기
Number.prototype.numberFormat = function() {
	if (this == 0)
		return 0;
	let regex = /(^[+-]?\d+)(\d{3})/;
	let nstr = (this + '');
	while (regex.test(nstr)) {
		nstr = nstr.replace(regex, '$1' + ',' + '$2');
	}
	return nstr;
};

const basket = {
	cartCount: 0, // 전체수량.
	cartTotal: 0, // 전체금액.


	/////////////////////////////
	// 목록.
	/////////////////////////////
	list: function() {
		svc.cartList(function(result) {

			result.forEach(cart => {
				basket.cartCount += cart.qty;
				basket.cartTotal += (cart.qty * cart.price);

				const rowDiv = $('div[data-id="0"]').clone();
				rowDiv.css('display', 'block');

				rowDiv.attr('data-id', cart.no);
				rowDiv.find('img').attr('src', 'image/' + cart.productNm + '.jpg');
				rowDiv.find('div.pname span').text(cart.productNm);
				rowDiv.find('div.basketprice').text(cart.price.numberFormat() + "원");
				rowDiv.find('div.basketprice').prepend($('<input />')
					.attr({ 'type': 'hidden', 'name': 'p_price', 'id': 'p_price' + cart.no })
					.addClass("p_price")
					.val(cart.price));
				rowDiv.find('div.basketprice input[name="p_price"]').val(cart.price); // 가격부분.
				rowDiv.find('div.basketprice input[name="p_price"]').attr('id', 'p_price' + cart.no);

				rowDiv.find('div.updown input[name="p_num0"]').val(cart.qty); // 수량출력부분.
				rowDiv.find('div.updown input[name="p_num0"]').attr('id', 'p_num' + cart.no); //

				rowDiv.find('div.updown input').keyup(() => basket.changePNum(cart.no));
				rowDiv.find('div.updown span').click(() => basket.changePNum(cart.no));

				rowDiv.find('div.sum').text((cart.qty * cart.price).numberFormat() + "원");
				rowDiv.find('div.sum').attr('id', 'p_sum' + cart.no);

				//$('#basket').append(rowDiv);
				rowDiv.appendTo('#basket');
			})// end of forEach.

			basket.reCalc();

		}, function(err) {
			console.error(err)
		})
	},


	/////////////////////////////
	// 삭제버튼.
	/////////////////////////////
	delItem: function() {
		let delNo = event.currentTarget.parentElement.parentElement.parentElement.dataset.id;
		delNo = $(event.currentTarget).closest('div.row').data('id');

		svc.cartRemove(delNo,
			result => {
				if (result.retCode == 'Success') {

					let price = $('#p_price' + delNo).val();
					let qty = $('#p_num' + delNo).val();
					basket.cartCount -= qty;
					basket.cartTotal -= (price * qty);
					basket.reCalc();

					$('[data-id="' + delNo + '"]').remove();
				}

			},
			err => { console.error(err) })
	},


	/////////////////////////////
	// 화면재계산.
	/////////////////////////////
	reCalc: function() {
		//수량, 금액 합계 계산
		//합계 자리에 출력
		$('#sum_p_num span').text(basket.cartCount);
		$('#sum_p_price span').text(basket.cartTotal.numberFormat());
	},


	/////////////////////////////
	// 수량변경.
	/////////////////////////////
	changePNum: function(no) {

		if (!no) return;

		let qty = -1;
		let price = $(event.currentTarget).parentsUntil('div.row').find('input.p_price').val();
		let sumElemement = $(event.currentTarget).parentsUntil('div.row').find('div.sum');
		let qtyElement = $(event.currentTarget).parentsUntil('div.row').find('input.p_num');

		if (event.target.nodeName == "I") {
			if (event.target.className.indexOf('up') != -1) {
				qty = 1;
			}

		} else if (event.target.nodeName == "INPUT") {
			if (event.key == 'ArrowUp') {
				qty = 1;
			}

		}

		price = $('#p_price' + no).val();
		qtyElement = $('#p_num' + no);
		sumElemement = $('#p_sum' + no);

		console.log(price, sumElemement, qtyElement);

		let curQty = qtyElement.val();
		let cvo = { no, qty }
		svc.cartUpdate(cvo,
			() => {
				//수량, 금액변경.
				qtyElement.val(parseInt(curQty) + qty);
				sumElemement.text((parseInt(price) * (parseInt(curQty) + qty)).numberFormat() + "원");

				//전체수량, 전체금액
				basket.cartCount += qty;
				basket.cartTotal += (price * qty);

				basket.reCalc();
			},
			() => alert('error'));
	},


	/////////////////////////////
	// 선택삭제.
	/////////////////////////////
	delCheckedItem: function() {

		$('div[data-id]').each((idx, item) => {
			if (idx > 0) {
				if ($(item).find('div.check input:checked').length) {
					let price = $(item).find('div.basketprice input').val();
					let qty = $(item).find('div.updown input').val();
					let no = $(item).data('id');

					svc.cartRemove(no,
						(result) => {
							if (result.retCode == "Success") {
								basket.cartCount -= qty;
								basket.cartTotal -= (price * qty);
								basket.reCalc();

								$(item).remove();
							}
						},
						(err) => { console.error(err) }
					);
				} // end of check item.
			} // end of db item.
		})
	},


	/////////////////////////////
	// 비우기.
	/////////////////////////////
	delAllItem: function() {
		$('div[data-id]').each((idx, item) => {
			if (idx > 0)
				$(item).find('div.check input').prop('checked', true);
		});
		basket.delCheckedItem();
	},
};

basket.list();
