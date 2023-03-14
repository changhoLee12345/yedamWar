<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>Json Test</h3>
<button id="btn">Json</button>

<script>
    document.getElementById('btn').addEventListener('click', transferData);

    function transferData() {

        const url =
            'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=qCwQYxNXeK%2FaB1Ngf9oNZDttjmjQ6ku1OdR6%2Fd0Jj5EIdqOxMXolplih%2BYjTqB4uxCuK636co3tf9T5%2Fr9OLvw%3D%3D';
        fetch(url)
            .then(resolve => resolve.json())
            .then(result => {
                console.log(result)
                let tData = result.data;
                transferToControl(tData);
            })
            .catch(err => console.error(err))

        function transferToControl(args) {
            let jsonStr = JSON.stringify(args);
            console.log(jsonStr)
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