<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
</head>

<body>
    <h3>Main Page</h3>

    <div id="app">
        <p>{{count}}</p>
        <button v-on:click="count++">Up</button>
    </div>

    <script src="js/main.js"></script>
</body>

</html>