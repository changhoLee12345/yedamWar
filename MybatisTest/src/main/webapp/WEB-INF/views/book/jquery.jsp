<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
    #header {
        width: 50%;
        border: 2px solid red;
    }

    #header label {
        margin-left: 30px;
        display: inline-block;
        width: 100px;
        text-align: left;
    }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="./js/ajaxJquery.js"></script>

<div id="header">
    <form action="" name="jfrm">
        <label for="">도서코드:</label> <input type="text" name="bcode" id="bcode" value="K0001"><br>
        <label for="">도서명:</label> <input type="text" name="btitle" id="btitle" value="홍길동전"><br>
        <label for="">도서저자:</label> <input type="text" name="bauthor" id="bauthor" value="허균"><br>
        <label for="">도서출판사:</label> <input type="text" name="bpress" id="bpress" value="활빈당"><br>
        <label for="">도서가격:</label> <input type="number" name="bprice" id="bprice" value="20000"><br>
        <input type="submit" value="저장">
    </form>
</div>

<div id="show">
    <table id="tbl" border="1">
        <thead>
            <tr>
                <th>도서코드</th>
                <th>도서명</th>
                <th>도서저자</th>
                <th>도서출판사</th>
                <th>도서가격</th>
                <th>수정</th>
            </tr>
        </thead>
        <tbody id="list"></tbody>
    </table>
</div>