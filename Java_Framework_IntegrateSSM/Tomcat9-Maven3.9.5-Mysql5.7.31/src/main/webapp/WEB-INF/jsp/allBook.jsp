<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示</title>
    <%--    BootStrap 美化界面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%--栅格--%>
<div class="container">
    <%--    清除浮动--%>
    <div class="row clearfix">
        <%--    把屏幕分成12份--%>
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表------显示所有书籍</small>
                </h1>
            </div>
        </div>
        <%--    row  使它一行12列--%>
        <div class="row">
            <div class="col-md-4 column">
                <%--            toAddBook--%>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示所有书籍</a>
            </div>

            <div class="col-md-8 column">
                <%--            a标签是不能通过查询的--%>
                <%--            查询书籍--%>
                <form class="form-inline" action="${pageContext.request.contextPath}/book/queryBook" method="post" style="float: right">
                    <span style="color: red; font-weight: bold">${error}</span>
                    <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称">
                    <input type="submit" value="查询" class="btn btn-primary">

                </form>
            </div>
        </div>


    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <%--            table-hover上下变色 table-striped 有格子--%>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>

                </thead>
                <%--               书籍从数据库中查询出来，从这个list中遍历出来：foreach--%>
                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>

                            <a href="${pageContext.request.contextPath}/book/toUpdate?id=${book.bookID}">修改</a>
                            &nbsp; | &nbsp;
                            <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>

            </table>

        </div>
    </div>
</div>

</body>
</html>

