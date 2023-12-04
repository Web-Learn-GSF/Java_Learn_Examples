<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>登录成功页面</h1>
<hr>

username：${user}
<a href="${pageContext.request.contextPath}/user/logout">注销</a>
</body>
</html>

<hr>
4、在 index 页面上测试跳转！启动Tomcat 测试，未登录也可以进入主页！

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>首页</h1>
<hr>
<%--登录--%>
<a href="${pageContext.request.contextPath}/user/jumplogin">登录</a>
<a href="${pageContext.request.contextPath}/user/jumpSuccess">成功页面</a>
</body>
</html>