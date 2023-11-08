// Intl 객체를 사용하여 포맷 지정.
function number_format(amount) {
	return new Intl.NumberFormat('ko-KR', {
		style: 'currency',
		currency: 'KRW'
	}).format(amount);
}

// prototype에 정의해서 메소드 추가: 숫자 3자리 콤마찍기
Number.prototype.formatNumber = function () {
	if (this == 0) return 0;
	let regex = /(^[+-]?\d+)(\d{3})/;
	let nstr = (this + '');
	while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
	return nstr;
};
// 1,000,000 => 1000000
//console.log('1,000,000'.replace(/,/g, ''));

// event 등록하기.
document.addEventListener("DOMContentLoaded", function (e) {

	// 수량증가.
	document.querySelectorAll('i.up').forEach(item => {
		item.addEventListener('click', basket.changePNum);
	})

	// 수량감소.
	document.querySelectorAll('i.down').forEach(item => {
		item.addEventListener('click', basket.changePNum);
	})

	// 삭제.
	document.querySelectorAll('div.basketcmd > a').forEach(item => {
		item.addEventListener('click', function (e) {
			basket.delItem(e);
		})
	})

	// 선택삭제.
	document.querySelectorAll('div.basketrowcmd>a')[0].addEventListener('click', function (e) {
		basket.delCheckedItem();
	})

	// 전체선택삭제.
	document.querySelectorAll('div.basketrowcmd>a')[1].addEventListener('click', function (e) {
		basket.delAllItem();
	})
})

let basket = {
	cartCount: 0,
	cartTotal: 0,
	delCheckedItem: function () {
		document.querySelectorAll('div.row.data').forEach(item => {
			if (item.querySelector('input:checked'))
				item.remove();
		})
		this.reCalc();
		this.updateUI();

	},
	delAllItem: function () {
		document.querySelectorAll('div.row.data').forEach(item => {
			item.remove();
		})
		this.reCalc();
		this.updateUI();

	},
	reCalc: function () {
		this.cartCount = 0;
		this.cartTotal = 0;
		document.querySelectorAll('input.p_num').forEach(item => {
			this.cartCount += parseInt(item.value);
		})
		document.querySelectorAll('div.sum').forEach(item => {
			let amt = item.dataset.amt;
			if (amt) {
				this.cartTotal += parseInt(amt);
			}
		})
	},
	updateUI: function () {
		document.querySelector('div#sum_p_num').innerText = "상품갯수: " + this.cartCount + "개";
		document.querySelector('div#sum_p_price').innerText = "합계금액: " + this.cartTotal.formatNumber() + "원";
	},
	changePNum: function (e) {
		let qtyItem;
		if (e.target.classList.contains('up')) {
			qtyItem = e.target.parentElement.previousElementSibling;
			qtyItem.value++;
		}
		if (e.target.classList.contains('down')) {
			qtyItem = e.target.parentElement.previousElementSibling.previousElementSibling;
			if (qtyItem.value > 1)
				qtyItem.value--;
		}
		// sum의 data-set속성을 변경해준다.
		let parent = e.target.parentElement.parentElement.parentElement.parentElement;
		let price = parent.children[0].children[0].value;
		let qty = qtyItem.value;
		let amt = price * qty;
		parent.children[2].setAttribute('data-amt', amt);
		parent.children[2].innerText = amt.formatNumber() + "원";
		basket.reCalc();
		basket.updateUI();
	},
	delItem: function (e) {
		e.target.parentElement.parentElement.parentElement.remove();
		basket.reCalc();
		basket.updateUI();
	},
	cartList: function () {
		cartItems.forEach((item) => {
			let template = document.querySelector('div.row.data').cloneNode(true);
			template.style.display = 'block';
			template.querySelector('img').src = './img/' + item.image;
			template.querySelector('div.pname>span').innerText = item.productNm;
			template.querySelector('input#p_price1').value = item.price;
			template.querySelector('input#p_num1').value = item.qty;
			template.querySelector('div.basketprice').childNodes[2].nodeValue = parseInt(item.price).formatNumber() + "원";
			template.querySelector('div.sum').innerText = (item.price * item.qty).formatNumber() + "원";
			template.querySelector('div.sum').setAttribute('data-amt', (item.price * item.qty));
			document.querySelector('#basket').append(template);
		})
		this.reCalc();
		this.updateUI();
	}
};

var cartItems = [{
		no: 1,
		productNm: '이것이자바다',
		qty: 2,
		price: 12000,
		image: 'basket1.jpg'
	},
	{
		no: 2,
		productNm: '바로하는 C#',
		qty: 3,
		price: 22000,
		image: 'basket2.jpg'
	},
	{
		no: 3,
		productNm: '파이썬하기',
		qty: 1,
		price: 13600,
		image: 'basket3.jpg'
	}
]

basket.cartList();

// 1. db를 연결해서 사용하려면 아래의 내용으로 작업을 하면 됨.
//fetch('cartSelectList')
//	.then(resolve => resolve.json())
//	.then(result => {
//		//console.log(result);
//		basket.cartList();
//	})
//	.catch(err => console.log(err))