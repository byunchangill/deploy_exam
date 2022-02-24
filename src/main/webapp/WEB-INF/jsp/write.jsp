<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글쓰기</title>
</head>
<body>
    <h1>글쓰기</h1>
    <div>
        <form action="/write" method="post">
            <div>
                <input type="text" name="title" placeholder="제목">
            </div>
            <div>
                <textarea name="ctnt" placeholder="내용"></textarea>
            </div>
            <div>
                <input type="text" name="writer" placeholder="작성자">
            </div>
            <div>
                <input type="submit" value="저장">
                <input type="reset" value="초기화">
            </div>
        </form>
    </div>
</body>
</html>