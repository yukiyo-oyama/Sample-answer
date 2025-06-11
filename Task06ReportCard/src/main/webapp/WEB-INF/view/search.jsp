<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.ReportCard"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/search_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
<%@ include file="menu.jsp" %>

<h1>検索</h1>

<div class="form-wrapper">
    <form action="search" method="post">
     <label for="name" class="form-label">名前を入力してください</label>
    <input type="text" name="name"  id="name" placeholder="山田太郎" class="large-input">
    <input type="submit" value="検索" class="button-base">
    </form>
</div>

    <% if (request.getAttribute("message") != null) {%>
    <p><%=request.getAttribute("message")%></p><%}%>
    
<%
ArrayList<ReportCard> found = (ArrayList<ReportCard>) request.getAttribute("found");
if (found != null && !found.isEmpty()) {
%>
<div class="container">
    <% for (ReportCard reportCard : found) { %>
    <div class="entry">
        <span>ID: <%=reportCard.getId()%></span> 
        <span><%=reportCard.getClassNumber()%>組</span>
        <span><%=reportCard.getName()%></span> 
        <span>英語: <%=reportCard.getEnglishScore()%>点</span> 
        <span>数学: <%=reportCard.getMathScore()%>点</span>
    </div>
    <% } %>
</div>
<% } %>

</body>
</html>