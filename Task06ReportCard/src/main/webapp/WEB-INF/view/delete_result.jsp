<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ReportCard" %>
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
    Boolean success = (Boolean)request.getAttribute("success");
    if (success != null && success) {
%>
    <p class="form-label">削除しました</p>
    
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
    <p>削除できませんでした。もう一度お試しください。</p>
<%
    }
    session.removeAttribute("reportCard");
%>
    

</body>
</html>