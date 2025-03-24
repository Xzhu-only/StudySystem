<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>修改个人信息</title>
    <link href="<%=path%>/page/static/css/main.css" rel="stylesheet" type="text/css"/>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f8fb;
            margin: 0;
            padding: 0;
            color: #333;
        }
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
            gap: 20px;
            color: #fff;
            font-size: 18px;
        }
        .header_li a {
            color: white;
            text-decoration: none;
            transition: color 0.3s;
        }
        .header_li a:hover {
            color: #a0c4ff;
        }
        .form-container {
            max-width: 500px;
            margin: 30px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
        }
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
        form input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #90a7e0;
            border-radius: 5px;
            font-size: 16px;
        }
        /* 按钮样式 */
        .button-container {
            display: flex;
            justify-content: space-between; /* 按钮左右对齐 */
        }
        form input[type="submit"],
        form input[type="button"] {
            background-color: #004aad;
            color: #ffffff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            flex: 1; /* 按钮宽度一致 */
            margin: 0 5px; /* 按钮之间的间距 */
        }
        form input[type="submit"]:hover,
        form input[type="button"]:hover {
            background-color: #003080;
        }
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
        <div class="header_div">
            <ul>
                <li class="header_li"><a class="logoa" href="<%=path%>/HandleGetAll?type=video1">所有课程</a></li>
                <li class="header_li"><a class="logoa" href="<%=path%>/index.jsp#course">推荐课程</a></li>
                <li class="header_li"><a class="logoa" href="<%=path%>/index.jsp#foot">联系我们</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="form-container">
    <h2 class="form-title">修改个人信息</h2>
    <form action="${pageContext.request.contextPath}/HandleUpdate?type=usermod" method="post">
        <label>学号<input type="text" name="uid" readonly value="${userOne.uid}"/></label>
        <label>姓名<input type="text" name="username" required value="${userOne.uname}"/></label>
        <label>专业<input type="text" name="major" readonly value="${userOne.major}"/></label>
        <label>班级<input type="text" name="classname" required value="${userOne.classname}"/></label>
        <label>密码<input type="password" name="password" readonly value="${userOne.upassword}"/></label>
        <label>简介<input type="text" name="commits" value="${userOne.commits}"/></label>
        <label>密保<input type="password" name="safeanwser" readonly value="${userOne.safeanwser}"/></label>
        <div class="button-container">
            <input type="submit" value="修改">
            <input type="button" value="返回" onclick="history.back()">
        </div>
    </form>
</div>

</body>
</html>
