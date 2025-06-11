<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>

	<h1>ログイン</h1>

	<div class="form-wrapper">
		<form action="login" method="post">
			<label for="id" class="form-label">id:</label> 
			     <input type="text" name="id" id="id" class="large-input"> 
			<label for="pw" class="form-label">pass:</label> 
			     <input type="text" name="pw" id="pw" class="large-input"> 
			     <input type="submit" value="ログイン" class="button-base">
		</form>
	</div>

</body>
</html>