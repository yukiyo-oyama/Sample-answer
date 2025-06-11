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

<% 
    // 変数を定義し、requestスコープから値を取得
    ReportCard reportCard = (ReportCard) session.getAttribute("reportCard");

    // reportCard の値をチェック
    if (reportCard != null) {
%>
<h3>登録が完了しました！</h3>
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
        // 表示後にセッションから削除
        session.removeAttribute("reportCard");
    } else {
%>
    <p>登録できませんでした。もう一度お試しください。</p>

<%
    }
%>

</body>
</html>
