<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.1.0/kakao.min.js"
  integrity="sha384-dpu02ieKC6NUeKFoGMOKz6102CLEWi9+5RQjWSV0ikYSFFd8M3Wp2reIcquJOemx" crossorigin="anonymous"></script>

<script>
  Kakao.init('03e7165cea2c22d9a74a7f000ea64d0e');
</script>

<a id="kakao-login-btn" href="javascript:loginWithKakao()">
  <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222" alt="카카오 로그인 버튼" />
</a>
<p id="token-result"></p>
<button class="api-btn" onclick="requestUserInfo()" style="visibility:hidden">사용자 정보 가져오기</button>

<script>
  function loginWithKakao() {
    Kakao.Auth.authorize({
      redirectUri: 'http://192.168.10.51:8080/HelloApp/oauth',
      state: 'userme',
    });
  }

  function requestUserInfo() {
    Kakao.API.request({
        url: '/v2/user/me',
      })
      .then(function (res) {
        alert(JSON.stringify(res));
        console.log(JSON.stringify(res));
      })
      .catch(function (err) {
        alert(
          'failed to request user information: ' + JSON.stringify(err)
        );
      });
  }

  // 아래는 데모를 위한 UI 코드입니다.
  displayToken()

  function displayToken() {
    var token = getCookie('authorize-access-token');
    console.log('token', token)

    if (token) {
      Kakao.Auth.setAccessToken(token);
      document.querySelector('#token-result').innerText = 'login success, ready to request API';
      document.querySelector('button.api-btn').style.visibility = 'visible';
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