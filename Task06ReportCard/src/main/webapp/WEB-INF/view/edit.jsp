<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修正</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/edit_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
<%@ include file="menu.jsp" %>

<h1>修正</h1>

<div class="form-wrapper">
    <form action="edit" method="post">
     <label for="id" class="form-label">ID を入力してください</label>
    <input type="text" id="id" name="id" class="large-input">
    <input type="submit" value="修正" class="button-base">
    </form>
</div>

</body>
</html>