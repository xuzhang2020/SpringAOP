<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Book</title>
</head>
<body>
<div id="box" style="width:350px; margin:auto; text-align:center;padding-top: 150px;">
    <h1>Add Book</h1>
    <form action="book" method="post">
        <p><input placeholder="ISBN" type="text" name="isbn"></p>
        <p><input placeholder="Book Name" type="text" name="name"></p>
        <p><input placeholder="Author Name" type="text" name="author"></p>
        <p><input placeholder="Date(YYYY-MM-dd)" name="publishDate"></p>
        <p><input id="add" type="submit" value="Add"></p>
    </form>
</div>
<div class="box">
<table>
    <thead>
    <tr>
        <th>ISBN</th>
        <th>BookName</th>
        <th>AuthorName</th>
        <th>PublishDate</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.isbn}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td><fmt:formatDate value="${book.publishDate}" pattern="yyyy-MM-dd"/></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
<style>
    .box {
        width: 500px;
        padding-top: 50px;
        margin: 0 auto;
    }

    h1 {
        text-align: center;
    }

    table {
        width: 500px;
        text-align: center;
        border-collapse: collapse;
        line-height: 35px;
    }
    #add {
        margin-top: 10px;
        background: #2d8cf0;
        color: #fff;
        border: 0;
    }
</style>
