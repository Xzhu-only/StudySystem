<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="adminOne" scope="request" class="javaBean.AdminBean" />


<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>管理员信息修改</title>
</head>
<link href="<%=path%>/page/static/css/main.css" rel="stylesheet" type="text/css"/>
<style>
    form {
        border: 1px solid #90a7e0; /* 设置表单边框样式 */
        padding: 10px; /* 设置表单内边距 */
        background-color: rgba(114, 109, 109, 0.5); /* 设置半透明的背景颜色 */
        width: 300px; /* 设置表单宽度 */
    }
    form label {
        display: block; /* 每个标签占据一行 */
        margin-bottom: 10px; /* 设置标签之间的间距 */
    }

    form input[type="submit"] {
        background-color: #fff; /* 设置提交按钮背景颜色 */
        padding: 5px 10px; /* 设置提交按钮内边距 */
    }
    form input[type="button"] {
        background-color: #fff; /* 设置提交按钮背景颜色 */
        padding: 5px 10px; /* 设置提交按钮内边距 */
    }
</style>
<body>
<div class="header" >
    <div class="header_all">
        <div class="header_logo"><a href="<%=path%>/index.jsp"><img src="<%=path%>/page/static/images/logo1.png"/></a></div>
        <div class="header_div">
            <ul>
                <li class="header_li">在线学习平台管理页面</li>
            </ul>
        </div>
    </div>
</div>
<form action="${pageContext.request.contextPath}/HandleUpdate?type=admin" method="post">
    <label>编号<input type="text" name="aid" readonly value="${adminOne.aid}"/></label><br/>
    <label>账号<input type="text" name="username" required value="${adminOne.aname}"/></label><br/>
    <label>密码<input type="text" name="password" required value="${adminOne.apassword}"/></label><br/>
    <input type="submit" value="修改">
    <input type="button" value="返回" onclick="history.back()">
</form>
</body>
</html>
