<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
  <div class="center">

    <h3>회원등록화면(joinForm.jsp)</h3>
    <table class="table">
      <tr>
        <th>아이디</th>
        <td><input type="text" name="id"></td>
      </tr>
      <tr>
        <th>이름</th>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <th>연락처</th>
        <td><input type="text" name="phone"></td>
      </tr>
      <tr>
        <th>주소</th>
        <td><input type="text" name="addr"></td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td><input type="text" name="pass"></td>
      </tr>
      <tr>
        <td colspan="2">
          <input class="btn btn-primary" type="submit" value="등록"><input class="btn btn-primary" type="reset" value="취소">
        </td>
      </tr>
    </table>
  </div>
</div>