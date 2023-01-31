<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>NoticeList를 사용해서 삭제시 비동기처리함수의 async/await 연습용.</title>
</head>

<body>
    <h3>게시글목록</h3>
    <div id="show">
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Writer</th>
                    <th>Subject</th>
                    <th><input type="checkbox"></th>
                </tr>
            </thead>
            <tbody id="list"></tbody>
        </table>
    </div>

    <button id="delSel">DeleteSel</button>

    <script>
        fetch('noticeListJson.do')
            .then(resolve => resolve.json())
            .then(result => {
                //console.log(result);
                for (let i = 0; i < 10; i++) {
                    list.append(makeTr(result[i]))
                }
            })
            .catch(reject => {
                console.log(reject)
            })

        document.querySelector('#delSel').addEventListener('click', function () {
            deleteSelectFnc();
        })

        async function deleteSelectFnc() {
            let ids = [];
            let chks = document.querySelectorAll('tbody input[type="checkbox"]:checked');
            for (let i = 0; i < chks.length; i++) {
                let id = chks[i].parentElement.parentElement.firstChild.innerText;
                console.log(id)
                const response = await fetch('deleteNoticeJson.do?id=' + id);
                const json = await response.json();
                console.log(response, ', ', json);
                ids.push(json.id);
            }
            console.log('ids>> ', ids);
        }

        let fields = ['noticeId', 'noticeTitle', 'noticeWriter', 'noticeSubject']

        function makeTr(item = {}) {
            // console.log(item)
            let tr = document.createElement('tr')

            fields.forEach(field => {
                let td = document.createElement('td')
                td.innerText = item[field];
                tr.append(td);
            })

            let td = document.createElement('td')
            let inp = document.createElement('input')
            inp.setAttribute('type', 'checkbox')
            td.append(inp)
            tr.append(td)

            return tr;
        }
    </script>
</body>

</html>