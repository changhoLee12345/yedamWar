<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <h3>Hello</h3>
    <form action="searchBook.do" method="get">
        
        <div class="search">
            <select name="searchCondition" id="searchCondition">
                <option value="" disabled>::선택하세요::</option>
                <option value="title">제목</option>
                <option value="press">출판사</option>
            </select>
            <input type="text" name="searchKey" id="searchKey">
            <input type="submit" value="검색">
        </div>
    </form>
    
    <a href="bookList.do">Tiles</a>
</body>

</html>