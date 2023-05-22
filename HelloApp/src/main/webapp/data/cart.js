export let basket = {
    cartCount: 0,
    cartTotal: 0,
    delCheckedItem: function () {
        document.querySelectorAll('input[name=buy]:checked').forEach(function (item) {
            item.parentElement.parentElement.parentElement.remove()
        })
        this.reCalc();
        this.updateUI();
    },
    delAllItem: function () {
        document.querySelectorAll('.row.data').forEach(function (item) {
            item.remove()
        })
        this.cartCount = 0;
        this.cartTotal = 0;
        this.reCalc();
        this.updateUI();
    },
    reCalc: function () {
        this.cartCount = 0;
        this.cartTotal = 0;
        document.querySelectorAll('div.row.data:not(.template) .p_num').forEach(function (item) {
            //console.log(item, ',', item.getAttribute('value'))
            var count = parseInt(item.getAttribute('value'));
            this.cartCount += count;
            var price = item.parentElement.parentElement.previousElementSibling.firstElementChild.getAttribute('value');
            this.cartTotal += count * price;
            //console.log(this.cartTotal)
        }, this)
    },
    updateUI: function () {
        document.querySelector('#sum_p_num').textContent = '상품개수: ' + this.cartCount.formatNumber() + '개'
        document.querySelector('#sum_p_price').textContent = '합계금액: ' + this.cartTotal.formatNumber() + '원'
    },
    changePNum: function (pos) {
        var item = document.querySelector('input[name=p_num' + pos + ']');
        var p_num = parseInt(item.getAttribute('value'));
        var newval = event.target.classList.contains('up') ? p_num + 1 : event.target.classList.contains('down') ? p_num - 1 : event.target.value;
        if (parseInt(newval) < 1 || parseInt(newval) > 99) {
            return false;
        }
        item.setAttribute('value', newval);
        item.value = newval;
        var price = item.parentElement.parentElement.previousElementSibling.firstElementChild.getAttribute('value');
        item.parentElement.parentElement.nextElementSibling.textContent = (newval * price).formatNumber() + "원"
        this.reCalc();
        this.updateUI();
    },
    delItem: function () {
        event.target.parentElement.parentElement.parentElement.remove()
    },
    cartList: function () {
        cartItems.forEach((item, idx) => {
            let template = document.querySelector('#template>div.row.data').cloneNode(true);
            // template.style.display = 'block';
            // template.classList.remove('template');
            template.querySelector('.img>img').setAttribute('src', '../img/' + item.image)
            template.querySelector('.pname>span').textContent = item.productNm
            template.querySelector('.basketprice>input').value = item.price
            template.querySelector('.basketprice').childNodes[2].textContent = item.price.formatNumber() + "원"
            template.querySelector('.updown>input').value = item.qty
            template.querySelector('.updown>input').setAttribute('value', item.qty)
            template.querySelector('.updown>input').setAttribute('id', 'p_num' + (idx + 1));
            template.querySelector('.sum').textContent = (item.price * item.qty).formatNumber() + "원"
            //console.log(template)
            document.querySelector('#basket').append(template)
        })
        this.reCalc();
        this.updateUI();
    }
};

var cartItems = [{
        no: 1,
        productNm: '이것이 민트다.',
        qty: 2,
        price: 12000,
        image: 'item1.PNG'
    },
    {
        no: 2,
        productNm: '와 아이스크림.',
        qty: 1,
        price: 22000,
        image: 'item2.PNG'
    },
    {
        no: 3,
        productNm: '모나카 케익.',
        qty: 1,
        price: 13600,
        image: 'item3.PNG'
    }
]

// 숫자 3자리 콤마찍기
Number.prototype.formatNumber = function () {
    if (this == 0) return 0;
    let regex = /(^[+-]?\d+)(\d{3})/;
    let nstr = (this + '');
    while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
    return nstr;
};