<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <!-- <a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=708649bd2a5f285a82328c026a3c29a4&redirect_uri=http://localhost:8080/HelloApp/SomeResourceServ">rest_key</a> -->

    <script>
        // let url = document.querySelector('a').href;
        // console.log(url);
    </script>

    <script src="https://t1.kakaocdn.net/kakao_js_sdk/2.1.0/kakao.min.js"
        integrity="sha384-dpu02ieKC6NUeKFoGMOKz6102CLEWi9+5RQjWSV0ikYSFFd8M3Wp2reIcquJOemx" crossorigin="anonymous">
    </script>

    <script>
        Kakao.init('03e7165cea2c22d9a74a7f000ea64d0e');
    </script>

    <a id="kakao-login-btn" href="javascript:loginWithKakao()">
        <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222" alt="카카오 로그인 버튼" />
    </a>
    <p id="token-result"></p>
    <button class="api-btn" onclick="requestUserInfo()" style="visibility:hidden">사용자 정보 가져오기</button>

    <form name="loginFrm" action="memberLogin.do" method="post">
        <input type="hidden" name="userId">
        <input type="hidden" name="userPw">
    </form>

    <script>
        function loginWithKakao() {
            // Kakao.Auth.authorize({
            //     redirectUri: 'http://localhost:8080/HelloApp/SomeResourceServ',
            //     state: 'userme',
            // })

            let url =
                'https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=03e7165cea2c22d9a74a7f000ea64d0e&redirect_uri=http://localhost:8080/HelloApp/SomeResourceServ'
            location.href = url;
        }

        function requestUserInfo() {
            Kakao.API.request({
                    url: '/v2/user/me',
                })
                .then(function (res) {
                    //alert(JSON.stringify(res));
                    console.log(res, ', ', res.kakao_account.email, ', ', res.id);
                    // page 이동.
                    let loginFrm = document.querySelector('form[name="loginFrm"]');
                    loginFrm.userId.value = res.kakao_account.email;
                    loginFrm.userPw.value = res.id;
                    loginFrm.submit();
                })
                .catch(function (err) {
                    alert('failed to request user information: ' + JSON.stringify(err));
                });
        }

        // 아래는 데모를 위한 UI 코드입니다.
        displayToken()

        function displayToken() {
            var token = getCookie('authorize-access-token');

            let tokenJson = null; //JSON.parse(document.getElementById('token').innerText);
            if ('${token}') {
                tokenJson = JSON.parse('${token }');
                token = tokenJson.access_token;
            }

            if (token) {
                Kakao.Auth.setAccessToken(token);
                document.querySelector('#token-result').innerText = 'login success, ready to request API';
                document.querySelector('button.api-btn').style.visibility = 'visible';
                // token이 생성되었으면 로그인 작업을 처리하고 main.do로 이동한다.

                requestUserInfo();
            }
        }

        function getCookie(name) {
            console.log(document.cookie);
            var parts = document.cookie.split(name + '=');
            if (parts.length === 2) {
                return parts[1].split(';')[0];
            }
        }
    </script>
</body>

</html>