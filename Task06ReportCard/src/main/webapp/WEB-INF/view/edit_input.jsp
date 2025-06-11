<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.ReportCard"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修正</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/edit_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
	<%@ include file="menu.jsp"%>

	<h1>修正</h1>

	<%
	ReportCard reportCard = (ReportCard) request.getAttribute("reportCard");
	if (reportCard != null) {
	%>
	<div class="form-wrapper">
		<form action="editresult" method="post">

			<div class="form-group">
				<label for="id">I D :</label> <input type="text" id="id"
					name="displayId" class="large-input"
					value="<%=reportCard.getId()%>" readonly>
			</div>

			<!-- サーブレットに送る用（表示されない） -->
			<input type="hidden" name="id" value="<%=reportCard.getId()%>">

			<div class="form-group">
				<label for="class_number">クラス : </label> <input type="text"
					id="class_number" name="class_number" class="large-input"
					value="<%=reportCard.getClassNumber()%>" required>
			</div>

			<div class="form-group">
				<label for="name">氏 名 :</label> <input type="text" id="name"
					name="name" class="large-input" value="<%=reportCard.getName()%>"
					required>
			</div>

			<div class="form-group">
				<label for="english_score">英 語 :</label> <input type="text"
					id="english_score" name="english_score" class="large-input"
					value="<%=reportCard.getEnglishScore()%>" required>
			</div>

			<div class="form-group">
				<label for="math_score">数 学 :</label> <input type="text"
					id="math_score" name="math_score" class="large-input"
					value="<%=reportCard.getMathScore()%>" required>
			</div>

			<input type="submit" value="修正する" class="button-base">

		</form>
	</div>
	<%
	} else {
	%>
	<p>生徒情報が見つかりませんでした。</p>
	<%
	}
	%>

</body>
</html>