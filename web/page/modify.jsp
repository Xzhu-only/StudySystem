<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    Object pname = request.getAttribute("Uname");
    if (pname != null) {
        pname = pname.toString();
        // 进行后续操作
    } else {
        // 处理 pname 为 null 的情况
    }
%>
<html>
<head>
    <title>修改密码信息</title>
</head>
<link href="<%=path%>/page/static/css/main.css" rel="stylesheet" type="text/css"/>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f4f8;
        margin: 0;
        padding: 0;
        color: #333;
    }

    .header {
        background-color: #004aad;
        color: white;
        padding: 15px;
        text-align: center;
        font-size: 24px;
    }

    form {
        border: 1px solid #004aad; /* 深蓝色边框 */
        padding: 20px;
        background-color: #ffffff; /* 白色背景 */
        width: 100%;
        max-width: 400px; /* 设定表单最大宽度 */
        margin: 30px auto; /* 居中对齐 */
        border-radius: 8px; /* 边角圆滑 */
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1); /* 添加阴影效果 */
    }

    form label {
        font-weight: bold;
        color: #004aad; /* 深蓝色标签文本 */
        margin-bottom: 8px;
    }

    form input[type="text"],
    form input[type="password"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #90a7e0;
        border-radius: 4px;
        font-size: 16px;
        margin-bottom: 15px; /* 输入框之间的间距 */
        box-sizing: border-box;
    }

    .button-container {
        display: flex;
        justify-content: space-between;
        margin-top: 10px;
    }

    form input[type="submit"],
    form input[type="button"] {
        background-color: #004aad; /* 深蓝色按钮背景 */
        color: #ffffff;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    form input[type="submit"]:hover,
    form input[type="button"]:hover {
        background-color: #003080; /* 悬停时的更深蓝色 */
    }

    .form-title {
        text-align: center;
        font-size: 24px;
        color: #004aad; /* 表单标题颜色 */
        margin-bottom: 20px;
    }

</style>
<body>
<div class="header" >
    <div class="header_all">
        <div class="header_logo"><a href="<%=path%>/index.jsp"><img src="<%=path%>/page/static/images/logo1.png"/></a></div>
        <div class="header_div">
            <ul>
                <li class="header_li"><a class="logoa">正在修改密码，请谨慎操作</a></li>
            </ul>
        </div>
    </div>
</div>

<%--<c:if test="${empty uname}">--%>
<%--<form action="${pageContext.request.contextPath}/HandleUpdate?type=userp" method="post">--%>
<%--    <label>用户名<input type="text" name="uname" readonly value=<%=pname%>></label><br/>--%>
<%--    <label>密码<input type="text" required name="password"/></label><br/>--%>
<%--    <input type="submit" value="修改">--%>
<%--</form>--%>
<%--</c:if>--%>
<c:if test="${not empty uname}">
    <form action="${pageContext.request.contextPath}/HandleUpdate?type=userp" method="post">
        <label>用户名<input type="text" name="uname" readonly value=${uname}></label><br/>
        <label>密码<input type="text" required name="password"/></label><br/>
        <input type="submit" value="修改">
    </form>
</c:if>

</body>
</html>
