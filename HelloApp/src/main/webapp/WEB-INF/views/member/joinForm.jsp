<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<div class="container">
  <div class="center">
    <h3>회원등록화면(joinForm.jsp)</h3>
    <form action="" name="myFrm" method="post">

      <table class="table">
        <tr>
          <th>아이디</th>
          <td><input type="text" name="id" value="user1"></td>
        </tr>
        <tr>
          <th>이름</th>
          <td><input type="text" name="name" value="홍길동"></td>
        </tr>
        <tr>
          <th>연락처</th>
          <td><input type="text" name="phone" value="010-4444-3333"></td>
        </tr>
        <tr>
          <th>주소</th>
          <td><input type="text" name="addr" value="Daegu, joongangno"></td>
        </tr>
        <tr>
          <th>비밀번호</th>
          <td><input type="text" name="pass" value="1234"></td>
        </tr>
        <tr>
          <th>권한</th>
          <td><select name="responsibility">
              <option value="">::select::</option>
              <option value="User" selected>일반사용자</option>
              <option value="Admin">관리자</option>
            </select>
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <input class="btn btn-primary" type="submit" value="등록"><input class="btn btn-primary" type="reset"
              value="취소">
          </td>
        </tr>
      </table>
    </form>

    <hr>

    <table class="table">
      <thead>
        <tr>
          <th>아이디</th>
          <th>이름</th>
          <th>연락처</th>
          <th>주소</th>
          <th>비밀번호</th>
          <th>권한</th>
        </tr>
      </thead>
      <tbody>
      </tbody>
    </table>

  </div>
</div>

<script>
  // page loading ..
  $(document).ready(function () {
    $.ajax({
      url: 'memberListAjax.do',
      method: 'get',
      dataType: 'json',
      success: function (result) {
        console.log(result);
      }
    });
  })
  let frm = $('form[name="myFrm"]')

  frm.on('submit', function () {
    let param = frm.serialize();
    console.log(decodeURI(param))

    $.post('memberJoin.do', param)
      .done(result => {
        console.log(result)
      })
      .fail(reject => {
        console.log(reject)
      })
  })
</script>