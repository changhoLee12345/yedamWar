$(document).ready(xmlCreate);

function xmlCreate() {

    $.ajax({
        url: './js/cd_catalog.xml',
        success: function (result) {
            // console.log(result);
            $('#show').append($('<table id="tbl" border="1" />').append($('<tbody id="list" />')))

            let titles = $(result).find('CATALOG>CD').eq(0).children()
            let thead = $('<thead />').append(
                $('<th />').text(titles[0].nodeName),
                $('<th />').text(titles[1].nodeName),
                $('<th />').text(titles[2].nodeName),
                $('<th />').text(titles[3].nodeName),
                $('<th />').text(titles[4].nodeName),
                $('<th />').text(titles[5].nodeName)
            );
            $('#tbl').prepend(thead)
            $(result).find('CATALOG>CD').each(function (idx, item) {
                //console.log($(item).children().eq(0).get()[0].nodeName);
                let tr = $('<tr />');
                let nodes = $(item).children();
                nodes.each(function (idx, item) {
                    tr.append($('<td />').text(item.textContent))
                })

                $('#list').append(tr)
            })
        },
        error: function (error) {
            console.lor(error)
        }
    })


}