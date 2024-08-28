<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
  String bno = (String) request.getAttribute("bno");
%>
<form action="removeBoard.do">
  <table class="table">
    <tr>
      <th>삭제글 번호</th>
      <td><input type="text" class="form-control" name="bno" value="<%=bno %>" readonly></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="삭제" class="btn btn-danger">
      </td>
    </tr>
  </table>
</form>
