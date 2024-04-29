<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- domForm.jsp -->
<h3>DOM 연습.</h3>

<!-- 멤버 추가 화면. -->
<form>
  <table class="table">
    <tr>
      <th>아이디</th>
      <td><input type="text" id="mid"></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><input type="text" id="fname"></td>
    </tr>
    <tr>
      <th>성씨</th>
      <td><input type="text" id="lname"></td>
    </tr>
    <tr>
      <th>이메일</th>
      <td><input type="email" id="email"></td>
    </tr>
    <tr>
      <th>급여</th>
      <td><input type="number" id="salary"></td>
    </tr>
    <tr>
      <th>성별</th>
      <td>
        <select id="gender">
          <option value="Male">Male</option>
          <option value="Female">Female</option>
        </select>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <button  id="addBtn" class="btn btn-primary">저장</button>
        <button type="button" id="editBtn" class="btn btn-primary">수정</button>
      </td>
    </tr>
  </table>
</form>

<input id="year"><input id="month"><button id="calBtn">선택</button>

<div id="show">
  <table border='1' class="table">
    <thead id="header" />
    <tbody id="list" />
  </table>
</div>
시간: <span id="timer"></span>

<script src="js/ajax.js"></script>
