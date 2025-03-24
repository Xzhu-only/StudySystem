<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>评论信息管理</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .headline {
            background-color: #007bff;
            color: white;
            text-align: center;
            font-weight: bold;
        }

        td, th {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .rounded-button {
            display: inline-block;
            padding: 8px 16px;
            font-size: 14px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .rounded-button:hover {
            background-color: #0056b3;
        }

        input[type="button"] {
            margin: 20px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #6c757d;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="button"]:hover {
            background-color: #5a6268;
        }

        div {
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <h2>评论信息管理</h2>
    <table>
        <tr class="headline">
            <td>评论编号</td>
            <td>用户号</td>
            <td>视频编号</td>
            <td>评论内容</td>
            <td>评论时间</td>
            <td>操作</td>
        </tr>
        <%-- 数据循环展示评论列表 --%>
        <jsp:useBean id="commentList" scope="request" type="java.util.List"/>
        <c:forEach items="${commentList}" var="comment">
            <tr>
                <td>${comment.cid}</td>
                <td>${comment.uid}</td>
                <td>${comment.vid}</td>
                <td>${comment.comment}</td>
                <td>${comment.create_time}</td>
                <td>
                    <a href="<%=path%>/HandleDel?cid=${comment.cid}&uid=${comment.uid}&type=comment2"
                       onclick="if (confirm('确定要删除这条评论吗？') == false) return false"
                       class="rounded-button">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
