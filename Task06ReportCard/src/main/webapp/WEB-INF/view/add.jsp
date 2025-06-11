<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ReportCard"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>追加</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/add_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
<%@ include file="menu.jsp" %>

<h1>追加</h1>

<div class="form-wrapper">

<form action="add" method="post">
    <div class="form-group">
        <label for="class_number">クラス : </label>
        <input type="text" id="class_number" name="class_number" class="large-input" placeholder="1組" required>
    </div>
    <div class="form-group">
        <label for="name">氏　名 :</label>
        <input type="text" id="name" name="name" class="large-input" placeholder="山田太郎" required>
    </div>
    <div class="form-group">
        <label for="english_score">英　語 :</label>
        <input type="text" id="english_score" name="english_score" class="large-input" placeholder="80" required>
    </div>
    <div class="form-group">
        <label for="math_score">数　学 :</label>
        <input type="text" id="math_score" name="math_score" class="large-input" placeholder="90" required>
    </div>
    <input type="submit" value="追加" class="button-base">
</form>

</div>

</body>
</html>
