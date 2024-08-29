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

let basket = {
	cartCount: 0, // 전체수량.
	cartTotal: 0, // 전체금액.

	list: function() {
		// 목록.
		svc.cartList(function(result) {

			result.forEach(cart => {
				basket.cartCount += cart.qty;
				basket.cartTotal += (cart.qty * cart.price);

				const rowDiv = document.querySelector('div[data-id="0"]').cloneNode(true);
				rowDiv.style.display = 'block';

				rowDiv.setAttribute('data-id', cart.no);
				rowDiv.querySelector('img').setAttribute('src', 'image/' + cart.productNm + '.jpg');
				rowDiv.querySelector('div.pname span').innerText = cart.productNm;
				rowDiv.querySelector('div.basketprice').childNodes[2].textContent = cart.price.numberFormat() + "원";
				rowDiv.querySelector('div.basketprice input[name="p_price"]').value = cart.price; // 가격부분.
				rowDiv.querySelector('div.basketprice input[name="p_price"]').setAttribute('id', 'p_price' + cart.no);

				rowDiv.querySelector('div.updown input[name="p_num0"]').value = cart.qty; // 수량출력부분.
				rowDiv.querySelector('div.updown input[name="p_num0"]').setAttribute('id', 'p_num' + cart.no); //

				rowDiv.querySelector('div.updown input').onkeyup = () => basket.changePNum(cart.no);
				rowDiv.querySelector('div.updown span').onclick = () => basket.changePNum(cart.no);
				rowDiv.querySelector('div.updown span:nth-of-type(2)').onclick = () => basket.changePNum(cart.no);

				rowDiv.querySelector('div.sum').textContent = (cart.qty * cart.price).numberFormat() + "원";
				rowDiv.querySelector('div.sum').setAttribute('id', 'p_sum' + cart.no);

				document.querySelector('#basket').append(rowDiv);
			})
			basket.reCalc();

		}, function(err) {
			console.error(err)
		})
	},

	delItem: function() {
		let delNo = event.currentTarget.parentElement.parentElement.parentElement.dataset.id;
		svc.cartRemove(delNo,
			(result) => {
				if (result.retCode == 'Success') {

					let price = document.querySelector('#p_price' + delNo).value;
					let qty = document.querySelector('#p_num' + delNo).value;
					basket.cartCount -= qty;
					basket.cartTotal -= (price * qty);
					basket.reCalc();

					document.querySelector('[data-id="' + delNo + '"]').remove();
				}

			},
			(err) => { console.error(err) })
	},

	reCalc: function() {
		//수량, 금액 합계 계산
		//합계 자리에 출력
		document.querySelector('#sum_p_num span').textContent = basket.cartCount;
		document.querySelector('#sum_p_price span').textContent = basket.cartTotal.numberFormat();
	},

	changePNum: function(no) {

		let qty = -1; // 초기값을 -1로 주고 수량을 증가하려면 1을 넣어주는 방식으로 처리하기.
		// 다소 복잡한 방식으로 항목을 얻어올 수 있으나 아래 방법으로 id값으로 가져오는게 쉽다.
		let price = event.currentTarget.parentElement.parentElement.previousElementSibling.children[0].value;
		let sumElemement = event.currentTarget.parentElement.parentElement.nextElementSibling;
		let qtyElement = event.currentTarget;

		if (event.target.nodeName == "I") { // 아이콘을 선택했을 때.
			if (event.target.className.indexOf('up') != -1) {
				qtyElement = event.currentTarget.previousElementSibling;
				qty = 1;
			} else {
				qtyElement = event.currentTarget.previousElementSibling.previousElementSibling;
			}

		} else if (event.target.nodeName == "INPUT") { // 상하 화살표를 눌렀을 때.			
			if (event.key == 'ArrowUp') {
				qty = 1;
			}

		}

		// 아래는 id값을 부여해서 간편하게 가져온다.
		price = document.querySelector('#p_price' + no).value;
		qtyElement = document.querySelector('#p_num' + no);
		sumElemement = document.querySelector('#p_sum' + no);

		let cvo = { no, qty }
		svc.cartUpdate(cvo,
			() => {
				//수량, 금액변경.
				qtyElement.value = parseInt(qtyElement.value) + qty;
				sumElemement.innerText = (parseInt(price) * parseInt(qtyElement.value)).numberFormat() + "원";

				//전체수량, 전체금액
				basket.cartCount += qty;
				basket.cartTotal += (price * qty);

				basket.reCalc();
			},
			() => alert('error'));
	},

	delCheckedItem: function() {
		document.querySelectorAll('[data-id]').forEach((item, idx) => {
			if (idx > 0) {
				if (item.querySelector('div.check input:checked')) {
					let price = item.querySelector('div.basketprice input').value;
					let qty = item.querySelector('div.updown input').value;
					let no = item.dataset.id;

					svc.cartRemove(no,
						result => {
							if (result.retCode == 'Success') {

								basket.cartCount -= qty;
								basket.cartTotal -= (parseInt(price) * parseInt(qty));
								basket.reCalc();

								document.querySelector('[data-id="' + no + '"]').remove();
							}
						},
						err => {
							console.error(err);
						}
					)
				}// end of checked.
			}// end of row
		}); // end of forEach.
	},

	delAllItem: function() {
		// 전체선택을 해놓고 선택삭제를 실행하는 것처럼 작동.
		document.querySelectorAll('[data-id]').forEach((item, idx) => {
			if (idx > 0) {
				item.querySelector('div.check input').checked = true;
			}
		})

		basket.delCheckedItem();
	},
};

basket.list();
