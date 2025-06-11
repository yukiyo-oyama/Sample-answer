<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja" translate="no">
<head>
<meta charset="UTF-8">
<title>成績管理メニュー</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">

</head>
<body>

<%
    String user = (String) session.getAttribute("user");
    if (user == null) {
        user = "ゲスト";
    }
%>
<div class="user-info">ようこそ、<%= user %> さん</div>

    <h1>成績管理メニュー</h1>

    <div class="menu-container">
        <a href="list" class="menu-button">1. 一覧</a>
        <a href="search" class="menu-button">2. 検索</a>
        <a href="add" class="menu-button">3. 追加</a>
        <a href="edit" class="menu-button">4. 修正</a>
        <a href="delete" class="menu-button">5. 削除</a>
        <a href="logout" class="menu-button">6. 終了</a>
    </div>
</body>
</html>
