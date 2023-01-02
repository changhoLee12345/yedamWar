<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <h3>Hello</h3>
    <form action="searchBook.do" method="get">

        <div class="search">
            <select name="searchCondition" id="searchCondition">
                <option value="" disabled>::선택하세요::</option>
                <option value="title">제목</option>
                <option value="press">출판사</option>
            </select>
            <input type="text" name="searchKey" id="searchKey">
            <input type="submit" value="검색">
        </div>
    </form>

    <a href="bookList.do">Tiles</a>

    <button id="btn">Json</button>

    <script>
        document.getElementById('btn').addEventListener('click', transferData);

        function transferData() {

            const url =
                'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=10&serviceKey=qCwQYxNXeK%2FaB1Ngf9oNZDttjmjQ6ku1OdR6%2Fd0Jj5EIdqOxMXolplih%2BYjTqB4uxCuK636co3tf9T5%2Fr9OLvw%3D%3D';
            fetch(url)
                .then(resolve => resolve.json())
                .then(result => {
                    console.log(result)
                    let tData = result.data;
                    transferToControl(tData);
                })
                .catch(err => console.error(err))

            function transferToControl(args) {
                console.log(args)
                let jsonStr = JSON.stringify(args);
                fetch('http://localhost:8081/HelloApp/createCenterInfo.do', {
                        method: 'post',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: jsonStr
                    })
                    .then(resolve => resolve.text())
                    .then(result => console.log(result))
                    .catch(err => console.log(err))
            }
        }
    </script>
</body>

</html>