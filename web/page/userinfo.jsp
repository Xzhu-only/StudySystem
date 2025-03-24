<jsp:useBean id="userOne" scope="request" type="javaBean.UserBean"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>在线学习平台-空间</title>
    <link href="<%=path%>/page/static/css/main.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=path%>/page/static/js/indexjs.js"></script>
    <script src="<%=path%>/page/static/js/jquery-1.5.1.min.js"></script>
    <script src="<%=path%>/page/static/js/lanrenzhijia.js"></script>
    <style>
        /* 基本样式 */
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
    <h2>用户信息</h2>
    <table>
        <tr><td>学号:</td><td>${userOne.uid}</td></tr>
        <tr><td>姓名:</td><td>${userOne.uname}</td></tr>
        <tr><td>专业:</td><td>${userOne.major}</td></tr>
        <tr><td>班级:</td><td>${userOne.classname}</td></tr>
        <tr><td>简介:</td><td>${userOne.commits}</td></tr>
    </table>

    <div class="button-container">
        <a href="<%=path%>/HandleGetOne?uname=${userOne.uname}&type=usermod" class="button">修改我的信息</a>
        <a href="<%=path%>/HandleGetAll?type=comment1&uid=${userOne.uid}&uname=${userOne.uname}" class="button">我的评论</a>
        <a href="<%=path%>/page/modify.jsp" class="button">修改密码</a>
    </div>
</div>
</body>
</html>
