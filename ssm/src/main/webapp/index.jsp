<%--
  Created by IntelliJ IDEA.
  User: 龙含日月
  Date: 2023/7/3
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Hello World</h2>
<a href="/account/findAll">测试springMVC</a>



<form action="account/save"   method="post" accept-charset="UTF-8">
    姓名:<input type="text" name="name"><br>
    金额:<input type="text" name="money"><br>
    <input type="submit" value="保存">
</form>
</body>
</html>
