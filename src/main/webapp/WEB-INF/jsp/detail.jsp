<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${data.title}</title>
</head>
<body>
    <h1>디테일</h1>
    <div>
        <button onclick="isDel(${data.iboard});">삭제</button>
        <a href="/mod?iboard=${data.iboard}"><button>수정</button></a>
    </div>
    <div>번호 : ${data.iboard}</div>
    <div>제목 : ${data.title}</div>
    <div>작성자 : ${data.writer}</div>
    <div>작성일시 : ${data.rdt}</div>
    <hr>
    <div>${data.ctnt}</div>
    <script src="/res/js/detail.js"></script>
</body>
</html>
