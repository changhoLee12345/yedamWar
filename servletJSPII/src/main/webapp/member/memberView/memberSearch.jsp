<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />

<h3>회원정보 검색</h3>
${error }
<form action="<%=request.getContextPath() %>/memberSearch.do" method="post">
    <input type="hidden" name="job" value="search">
    <table>
        <tr>
            <td>아이디</td>
            <td><input type="text" name="id"> <input type="submit" value="Search" class="btn btn-primary"></td>
        </tr>
    </table>
</form>

<jsp:include page="../includes/footer.jsp" />