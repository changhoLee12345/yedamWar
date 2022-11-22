/**
 *  ajax for jquery
 */
$(function () {
    // 페이지 로딩.
    // 리스트 출력.
    $.ajax({
        url: 'ajaxBookList.do',
        method: 'get',
        // contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        // data: {},
        dataType: 'json',
        success: function (result) {
            console.log(result);
            $.each(result, function (prop, item) {
                $('#list').append(makeTr(item));
            })
        },
        error: function (error) {
            console.log(error);
        }
    });

    // 저장버튼.
    $('form input[type="submit"]').on('click', function (e) {
        e.preventDefault();

        console.log($('form[name="jfrm"]').serialize());

        $.ajax({
            url: 'ajaxBookAdd.do',
            method: 'post',
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            data: $('form[name="jfrm"]').serialize(),
            dataType: 'json',
            success: function (result) {
                $('#list').append(makeTr(result))
            },
            error: function (error) {
                console.log(error)
            }
        });
    })
})

function makeTr(book = {
    bookCode: 'bcode',
    bookTitle: 'title',
    bookAuthor: 'author',
    bookPress: 'press',
    bookPrice: 1000
}) {

    let tr = $('<tr />').append($('<td />').text(book.bookCode),
        $('<td />').text(book.bookTitle),
        $('<td />').text(book.bookAuthor),
        $('<td />').text(book.bookPress),
        $('<td />').text(book.bookPrice),
        // button
        $('<td />').append($('<button />').text('수정').on('click', book, modifyForm))
    )

    return tr;
}

function modifyForm(e) {

    if ($('#list tr').hasClass('modify')) {
        return;
    }

    let newTr = $('<tr />').addClass('modify').append($('<td />').text(e.data.bookCode),
        $('<td />').append($('<input />').val(e.data.bookTitle)),
        $('<td />').append($('<input />').val(e.data.bookAuthor)),
        $('<td />').append($('<input />').val(e.data.bookPress)),
        $('<td />').append($('<input />').val(e.data.bookPrice)),
        $('<td />').append($('<button />').text('적용').on('click', modifyData)))

    let oldTr = $(this).parentsUntil('#list');

    oldTr.replaceWith(newTr);

}

function modifyData(e) {
    // console.log(e);
    // console.log($(this).parent().parent())
    let tr = $(this).parent().parent();

    let code = tr.find('td:nth-child(1)').text();
    let title = tr.find('td:nth-child(2)>input').val();
    let author = tr.find('td:nth-child(3)>input').val();
    let press = tr.find('td:nth-child(4)>input').val();
    let price = tr.find('td:nth-child(5)>input').val();

    console.log(code, title, author, press, price)

    $.ajax({
        url: 'ajaxBookMod.do',
        method: 'post',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        data: {
            bcode: code,
            btitle: title,
            bauthor: author,
            bpress: press,
            bprice: price
        },
        dataType: 'json',
        success: function (result) {
            tr.replaceWith(makeTr(result));
        },
        error: function (error) {
            console.log(error)
        }
    });

}