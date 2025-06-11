<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.ReportCard"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>成績一覧</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
    <%@ include file="menu.jsp"%>

    <h1>生徒一覧</h1>

    <!-- メッセージ表示(jsltバージョン) -->
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <div class="container">
        <!-- 成績一覧ループ -->
        <c:if test="${not empty list}">
            <c:forEach var="reportCard" items="${list}">
                <div class="entry">
                    <span>ID: ${reportCard.id}</span>
                    <span>${reportCard.classNumber}組</span>
                    <span>${reportCard.name}</span>
                    <span>英語: ${reportCard.englishScore}点</span>
                    <span>数学: ${reportCard.mathScore}点</span>
                </div>
            </c:forEach>
        </c:if>
    </div>

</body>
</html>
