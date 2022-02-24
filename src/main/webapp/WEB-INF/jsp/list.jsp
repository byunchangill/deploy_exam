<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/res/css/common.css?ver=2">
    <title>List</title>
</head>
<body>
    <h1>리스트</h1>
    <div>
        <a href="/write">글쓰기</a>
    </div>
    <div class="container">
        <table>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>작성일시</th>
            </tr>
            <c:forEach items="${data}" var="vo">
            <tr onclick="moveToDetail(${vo.iboard});">
                <td>${vo.iboard}</td>
                <td>${vo.title}</td>
                <td>${vo.writer}</td>
                <td>${vo.rdt}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <script src="/res/js/list.js"></script>
</body>
</html>