<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<h1>上传文件</h1>
<h2>上传单个文件，java原生代码实现</h2>
<form action="/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
</form>

<h2>上传单个文件，调file.TransferTo保存文件代码</h2>
<form action="/upload2" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
</form>

<h2>上传多个文件（多个文件选择框实现），调file.TransferTo保存文件代码</h2>
<form action="/upload3" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="file" name="file"/>
    <input type="submit" value="upload">
</form>

<h2>上传多个文件（单个文件选择框实现），调file.TransferTo保存文件代码</h2>
<form action="/upload3" enctype="multipart/form-data" method="post">
    <input type="file" name="file" multiple/>
    <input type="submit" value="upload">
</form>
</body>

<h1>下载文件</h1>
<h2>java原生代码实现</h2>
<a href="/download">点击下载</a>
</html>
