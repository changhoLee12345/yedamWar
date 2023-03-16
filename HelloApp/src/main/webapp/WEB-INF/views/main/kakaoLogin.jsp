<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.1.0/kakao.min.js"
  integrity="sha384-dpu02ieKC6NUeKFoGMOKz6102CLEWi9+5RQjWSV0ikYSFFd8M3Wp2reIcquJOemx" crossorigin="anonymous">
</script>

<!-- <script src="https://t1.kakaocdn.net/kakao_js_sdk/2.1.0/kakao.min.js"
  integrity="sha384-dpu02ieKC6NUeKFoGMOKz6102CLEWi9+5RQjWSV0ikYSFFd8M3Wp2reIcquJOemx" crossorigin="anonymous"></script> -->

<script>
  // Kakao.init('c089c8172def97eb00c07217cae17495'); // 사용하려는 앱의 JavaScript 키 입력
  Kakao.init('03e7165cea2c22d9a74a7f000ea64d0e');
</script>

<a id="kakao-login-btn" href="javascript:loginWithKakao()">
  <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222" alt="카카오 로그인 버튼" />
</a>
<p id="token-result"></p>

<script>
  function loginWithKakao() {
    Kakao.Auth.authorize({
      // redirectUri: 'https://developers.kakao.com/tool/demo/oauth',
      redirectUri: 'http://localhost:8080/HelloApp/oauth'
    });
  }

  // 아래는 데모를 위한 UI 코드입니다.
  displayToken()

  function displayToken() {
    var token = getCookie('authorize-access-token');
    console.log(token);

    if (token) {
      Kakao.Auth.setAccessToken(token);
      Kakao.Auth.getStatusInfo()
        .then(function (res) {
          if (res.status === 'connected') {
            document.getElementById('token-result').innerText = 'login success, token: ' + Kakao.Auth
              .getAccessToken();
          }
        })
        .catch(function (err) {
          Kakao.Auth.setAccessToken(null);
        });
    }
  }

  function getCookie(name) {
    var parts = document.cookie.split(name + '=');
    if (parts.length === 2) {
      return parts[1].split(';')[0];
    }
  }
</script>


<script>
  // SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해야 합니다.
  Kakao.init('03e7165cea2c22d9a74a7f000ea64d0e');
  // SDK 초기화 여부를 판단합니다.
  console.log(Kakao.isInitialized());

  // fetch('oauth', {
  //   method: 'post',
  //   headers: {
  //     'Content-Type': 'application/x-www-form-urlencoded'
  //   },
  //   body: 'auth=' + 'youareauthoried'
  // });
</script>