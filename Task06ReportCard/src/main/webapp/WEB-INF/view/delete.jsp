<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/delete_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
<%@ include file="menu.jsp" %>

<h1>削除</h1>

<div class="form-wrapper">
    <form action="delete" method="post">
     <label for="id" class="form-label">ID を入力してください</label>
    <input type="text" id="id" name="id" class="large-input">
    <input type="submit" value="削除" class="button-base">
    </form>
</div>

</body>
</html>