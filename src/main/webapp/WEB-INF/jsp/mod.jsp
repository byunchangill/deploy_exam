<%@ page import="com.koreait.deploy.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% BoardVO data = (BoardVO)request.getAttribute("data"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글수정</title>
</head>
<body>
    <h1>글수정</h1>
    <div>
        <form action="/mod" method="post">
            <input type="hidden" name="iboard" value="<%=data.getIboard()%>">
            <div>
                <input type="text" name="title" placeholder="제목" value="<%=data.getTitle()%>">
            </div>
            <div>
                <textarea name="ctnt" placeholder="내용"><%=data.getCtnt()%></textarea>
            </div>
            <div>
                <input type="text" name="writer" placeholder="작성자" value="<%=data.getWriter()%>">
            </div>
            <div>
                <input type="submit" value="수정">
                <input type="reset" value="초기화">
            </div>
        </form>
    </div>
</body>
</html>