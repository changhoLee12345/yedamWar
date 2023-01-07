<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<div class="container">
  <div class="center">
    <h3>회원등록화면(joinForm.jsp)</h3>
    <form action="insertMember.do" name="myFrm" method="post" enctype="multipart/form-data">
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
          <th>이미지</th>
          <td><input type="file" name="image"></td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input class="btn btn-primary" type="submit" value="등록">
            <input class="btn btn-primary" type="reset" value="취소">
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
          <th>수정</th>
        </tr>
      </thead>
      <tbody id="list">
      </tbody>
    </table>

  </div>
</div>

<script>
  function makeRow(obj = {}) {
    console.log(obj)
    let delBtn = $('<button />').text('Mod');
    delBtn.on('click', function () {
      let curTr = $(this).parent().parent();
      console.log()
      $.ajax({
        url: 'memberDelAjax.do',
        data: 'id=' + obj['id'],
        method: 'post',
        dataType: 'json',
        success: function (result) {
        	console.log(result)
          alert('success');
          curTr.remove();
        },
        error: function (reject) {
          console.log(reject)
        }
      })
    })

    $('#list').append($('<tr />').append(
      $('<td />').text(obj['id']),
      $('<td />').text(obj['name']),
      $('<td />').text(obj['phoneNumber']),
      $('<td />').text(obj['addr']),
      $('<td />').text(obj['passwd']),
      $('<td />').text(obj['responbility']),
      $('<td />').append(delBtn)
    ))
  }

  // page loading ..
  $(document).ready(function () {
    $.ajax({
      url: 'memberListAjax.do',
      method: 'get',
      dataType: 'json',
      success: function (result) {
        console.log(result);
        $(result).each((idx, member) => {
          $('#list').append(makeRow(member))
        })
      }
    });
  })

  let frm = $('form[name="myFrm"]')
  frm.on('submit', multiPartFnc);

  function multiPartFnc(e) {
    e.preventDefault();
    let myfrm = document.querySelector('form[name="myFrm"]');
    let formData = new FormData(myfrm);

    $.ajax({
      url: 'memberJoinAjax.do',
      type: 'post',
      data: formData,
      dataType: 'json',
      contentType: false,
      processData: false,
      success: function (result) {
        console.log(result);
        if (result.retCode == 'Success') {
          $('#list').append(makeRow(result.data));
        } else {
          alert('error occurred.')
        }
      },
      error: function (reject) {
        console.log(reject)
      }
    })
  }

  function serialDataFnc() {
    let param = frm.serialize();
    console.log(decodeURI(param))

    $.post('memberJoin.do', param)
      .done(result => {
        console.log(result)
      })
      .fail(reject => {
        console.log(reject)
      })

  }
</script>