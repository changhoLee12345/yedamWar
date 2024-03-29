<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<div class="container">
  <div class="center">
    <h3>회원등록화면(memberForm.jsp)</h3>
    <form action="insertMember.do" name="myFrm" method="post" enctype="multipart/form-data">
      <table class="table">
        <tr>
          <th>아이디</th>
          <td><input type="text" name="id" value="<c:out value='${member.id }' />"></td>
        </tr>
        <tr>
          <th>이름</th>
          <td><input type="text" name="name" value='<c:out value="${member.name }" />'></td>
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
          <td>
            <img width="200px" src="resources/images/${member.pfilename }" />
            <input type="file" id="image" name="image" style="display: none;">
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input class="btn btn-primary" type="submit" value="수정">
            <input class="btn btn-primary" type="reset" value="취소">
          </td>
        </tr>
      </table>
    </form>
    <hr>
  </div>
</div>
<script>
  document.querySelector('form img').addEventListener('click', function (e) {
    console.log('img click')
    document.getElementById('image').click();
  })

  document.getElementById('image').addEventListener('change', function (e) {
    console.log(e.target.files[0]);
    let imageFile = e.target.files[0];
    let formData = new FormData();
    formData.append('image', imageFile);
    formData.append('id', document.querySelector('input[name="id"]').value);

    let xhtp = new XMLHttpRequest();
    xhtp.open('post', 'imageUpload.do');
    xhtp.send(formData);
    xhtp.onload = function () {
      let result = JSON.parse(xhtp.response);
      if (result.retCode == 'Success') {
        document.querySelector('form img').src = 'resources/images/' + result.image;
      } else if (result.retCode == 'Fail') {
        console.log('error')
      } else {
        console.log('not known retcode')
      }
    }
  })
</script>