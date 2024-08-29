<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- member.jsp -->

<table class="table">
  <tr>
    <th>ID</th>
    <td><input type="text" id="mid"></td>
  </tr>
  <tr>
    <th>PW</th>
    <td><input type="password" id="mpw"></td>
  </tr>
  <tr>
    <th>이름</th>
    <td><input type="text" id="mname"></td>
  </tr>
  <tr>
    <th>연락처</th>
    <td><input type="text" id="phone"></td>
  </tr>
  <tr>
    <td colspan="2" align="center">
      <button id="addBtn">등록</button>
    </td>
  </tr>
</table>

<div id="show">
  <table class="table">
    <tbody id="list"></tbody>
  </table>
</div>


<script src="js/service.js"></script>
