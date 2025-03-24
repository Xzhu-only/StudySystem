<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>在线学习平台 - 评论列表</title>
    <link href="<%=path%>/page/static/css/main.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=path%>/page/static/js/jquery-1.5.1.min.js"></script>
    <style>
        /* Header样式 */
        .header {
            background-color: #004aad; /* 深蓝色背景 */
            color: #fff; /* 白色字体 */
            width: 100%;
            height: 90px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0 50px;
        }

        .header_logo img {
            height: 60px;
            margin-top: 15px;
        }

        .header_div ul {
            list-style: none;
            display: flex;
            gap: 30px;
        }

        .header_div li {
            padding-top: 10px;
        }

        .logoa {
            color: #fff;
            text-decoration: none;
            font-size: 18px;
            transition: color 0.3s;
        }

        .logoa:hover {
            color: #87ceeb; /* 浅蓝色悬停效果 */
        }

        /* 表格样式 */
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 30px auto;
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
        }

        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #004aad; /* 深蓝色背景 */
            color: #ffffff; /* 白色字体 */
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2; /* 间隔行浅灰色 */
        }

        tr:hover {
            background-color: #e0e7ff; /* 悬停时背景色 */
        }

        a {
            color: #004aad;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            color: #529AB0;
            text-decoration: underline;
        }
    </style>
</head>

<body>
<div class="header">
    <div class="header_logo">
        <a href="<%=path%>/index.jsp"><img src="<%=path%>/page/static/images/logo1.png" alt="Logo"/></a>
    </div>
    <div class="header_div">
        <ul>
            <li><a class="logoa" href="<%=path%>/HandleGetAll?type=video1">所有课程</a></li>
            <li><a class="logoa" href="<%=path%>/index.jsp#course">推荐课程</a></li>
            <li><a class="logoa" href="<%=path%>/index.jsp#foot">联系我们</a></li>
        </ul>
    </div>
</div>

<div style="text-align:center">
    <table>
        <tr>
            <th>评论编号</th>
            <th>用户名</th>
            <th>视频</th>
            <th>评论内容</th>
            <th>评论时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${commentList}" var="comment">
            <tr>
                <td>${comment.cid}</td>
                <td>${comment.uid}</td>
                <td>${comment.vid}</td>
                <td>${comment.comment}</td>
                <td>${comment.create_time}</td>
                <td>
                    <a href="<%=path%>/HandleDel?cid=${comment.cid}&uid=${comment.uid}&uname=${uname}&type=comment1"
                       onclick="return confirm('确定要删除这条评论吗？');">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
