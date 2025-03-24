<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="adminOne" scope="request" class="javaBean.UserBean" />
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>学生信息修改</title>
    <link href="<%=path%>/page/static/css/main.css" rel="stylesheet" type="text/css"/>
    <style>
        /* 全局样式 */
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
        .header_div ul {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            color: #fff;
            font-size: 20px;
        }

        /* 表单容器样式 */
        .form-container {
            max-width: 500px;
            margin: 30px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
        }

        /* 表单样式 */
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
            color: #333;
        }
        form label {
            font-weight: bold;
            color: #004aad;
        }
        form input[type="text"],
        form input[type="password"],
        form select {
            width: 100%;
            padding: 10px;
            border: 1px solid #90a7e0;
            border-radius: 5px;
            font-size: 16px;
        }

        /* 按钮样式 */
        .button-container {
            display: flex;
            justify-content: space-between;
            gap: 10px;
            margin-top: 20px;
        }
        form input[type="submit"],
        form input[type="button"] {
            background-color: #004aad;
            color: #ffffff;
            padding: 10px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            width: 48%;
        }
        form input[type="submit"]:hover,
        form input[type="button"]:hover {
            background-color: #003080;
        }

        /* 表单标题样式 */
        .form-title {
            text-align: center;
            font-size: 24px;
            color: #004aad;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<div class="header">
    <div class="header_all">
        <div class="header_logo"><a href="<%=path%>/index.jsp"><img src="<%=path%>/page/static/images/logo1.png" alt="Logo"/></a></div>
    </div>
</div>

<div class="form-container">
    <h2 class="form-title">学生信息修改</h2>
    <form action="${pageContext.request.contextPath}/HandleUpdate?type=user" method="post">
        <label>学号<input type="text" name="uid"  value="${userOne.uid}"/></label>
        <label>姓名<input type="text" name="username"  value="${userOne.uname}"/></label>
        <label>专业<input type="text" name="major"  value="${userOne.major}"/></label>
        <label>班级<input type="text" name="classname"  value="${userOne.classname}"/></label>
        <label>密码<input type="password" name="password"  value="${userOne.upassword}"/></label>
        <label>简介<input type="text" name="commits"  value="${userOne.commits}"/></label>
        <label>密保<input type="password" name="safeanwser"  value="${userOne.safeanwser}"/></label>
        <label>封禁
            <select name="isdelete">
                <option value="${userOne.isdelete}">${userOne.isdelete}</option>
                <option value="no">非封禁</option>
                <option value="yes">封禁</option>
            </select>
        </label>

        <!-- 按钮容器，使按钮在同一行显示 -->
        <div class="button-container">
            <input type="submit" value="修改">
            <input type="button" value="返回" onclick="history.back()">
        </div>
    </form>
</div>

</body>
</html>
