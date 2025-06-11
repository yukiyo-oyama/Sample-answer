<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/logout_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>


<h1>ログアウト</h1>

<div class="form-wrapper">
    <form action="logout" method="post">
        <p>ログアウトしますか？</p>
        <input type="submit" value="ログアウト" class="button-base">
    </form>
</div>

</body>
</html>