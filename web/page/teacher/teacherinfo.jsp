<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>在线学习平台-教师空间</title>
    <link href="<%=path%>/page/static/css/main.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=path%>/page/static/js/indexjs.js"></script>
    <script src="<%=path%>/page/static/js/jquery-1.5.1.min.js"></script>
    <script src="<%=path%>/page/static/js/lanrenzhijia.js"></script>
</head>
<body>
<div class="header">
    <div class="header_logo">
        <a href="<%=path%>/index.jsp">
            <img src="<%=path%>/page/static/images/logo1.png" alt="Logo"/>
        </a>
    </div>
</div>

<div class="content">
    <h2>教师信息</h2>
    <table>

        <c:if test="${not empty teacherOne}">
            <tr><td>教师编号:</td><td>${teacherOne.tid}</td></tr>
            <tr><td>姓名:</td><td>${teacherOne.tname}</td></tr>
            <tr><td>联系方式:</td><td>${teacherOne.prone}</td></tr>
            <tr><td>简介:</td><td>${teacherOne.introduce}</td></tr>
        </c:if>
        <c:if test="${empty teacherOne}">
            <tr><td colspan="2">未找到教师信息或查询失败。</td></tr>
        </c:if>

    </table>

</div>
</body>
</html>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f8fb;
        margin: 0;
        padding: 0;
        color: #333;
    }

    /* 顶部导航栏样式 */
    .header {
        background-color: #004aad;
        padding: 15px;
        color: white;
        display: flex;
        justify-content: center;
    }
    .header_logo img {
        height: 50px;
    }

    /* 内容区域样式 */
    .content {
        max-width: 800px;
        margin: 30px auto;
        padding: 30px;
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
    }
    .content h2 {
        color: #004aad;
        text-align: center;
        margin-bottom: 20px;
    }

    /* 表格样式 */
    .content table {
        width: 100%;
        border-collapse: collapse;
    }
    .content td {
        border-bottom: 1px solid #e0e0e0;
        padding: 12px;
        font-size: 16px;
        color: #333;
    }
    .content td:first-child {
        font-weight: bold;
        color: #004aad;
    }

    /* 按钮样式 */
    .button-container {
        display: flex;
        justify-content: space-around;
        margin-top: 20px;
    }
    .button {
        background-color: #004aad;
        color: #ffffff;
        padding: 12px 24px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
        text-decoration: none;
    }
    .button:hover {
        background-color: #003080;
    }
    .button a {
        color: inherit;
        text-decoration: none;
        display: block;
    }
</style>
