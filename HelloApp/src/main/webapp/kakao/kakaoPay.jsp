<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <a href="../PayServ">kakaoPay</a>

    <script>
        document.querySelector('a[href="../PayServ"]').addEventListener('click', function (e) {
            e.preventDefault();
            fetch(this.href)
                .then(resolve => resolve.json())
                .then(result => {
                    console.log(result)
                })
                .catch(reject => console.error(reject))
        })
    </script>
</body>

</html>