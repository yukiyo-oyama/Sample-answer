<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ReportCard"%>
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

<% 
    ReportCard reportCard = (ReportCard) session.getAttribute("reportCard");
    if (reportCard != null) {
%>

<div class="form-wrapper">
    <form action="deleteresult" method="post">
        <div class="form-group">
            <p class="form-label">このデータを削除しますか？</p>
        </div>
        <div class="form-group">
            <input type="submit" name="action" value="削除する" class="button-base">
            <input type="submit" name="action" value="キャンセル" class="button-base">
        </div>
    </form>
</div>
      
    <div class="container">
        <div class="entry">
            <span>ID: <%= reportCard.getId() %></span> 
            <span><%= reportCard.getClassNumber() %>組</span>
            <span><%= reportCard.getName() %></span> 
            <span>英語: <%= reportCard.getEnglishScore() %>点</span> 
            <span>数学: <%= reportCard.getMathScore() %>点</span>
        </div>
    </div>
    
<%
    } else {
%>
    <p>生徒情報が見つかりませんでした。もう一度お試しください。</p>
<%
    }
%>

</body>
</html>