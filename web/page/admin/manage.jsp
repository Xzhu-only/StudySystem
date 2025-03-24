<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>管理员首页</title>
    <link href="<%=path%>/page/static/css/main.css" rel="stylesheet" type="text/css"/>
    <style>
        .rounded-button {
            display: inline-block;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            background-color: #337ab7;
            color: #fff;
            text-decoration: none;
        }

        .rounded-button:hover {
            background-color: #23527c;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #637ebb;
        }

        th {
            background-color: #637ebb;
        }
        .container {
            display: flex;
        }

        .sidebar {
            width: 200px;
            height: 700px;
            background-color: #637ebb;
        }
        .headline {
            width: 200px;
            background-color: #b3bfe0;
        }
        .content {
            flex: 1;
            padding: 20px;
        }

        .sidebar button {
            display: block;
            width: 100%;
            padding: 10px;
            border: none;
            background-color: transparent;
            text-align: left;
        }
        .sidebar-button {
            display: block;
            width: 100%;
            padding: 10px;
            font-size: 16px;
            color: #fff;
            background-color: #337ab7;
            border: none;
            border-radius: 4px;
            text-align: left;
            text-decoration: none;
        }

        .sidebar-button:hover {
            background-color: #23527c;
        }
    </style>
    <script>
        function loadPage(type) {
            var content = document.querySelector('.content');
            var url = '<%=path%>/HandleGetAll?type=' + type;
            content.innerHTML = 'Loading...';
            // 使用合适的方式加载对应管理页面的内容，例如使用Ajax请求或iframe嵌套等
            // 这里以简单的Ajax请求为例
            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;//允许处理跨域
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    content.innerHTML = xhr.responseText;
                }
            };
            xhr.open('GET', url, true);
            xhr.send();
        }
    </script>
</head>
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


<div class="container">
    <div class="sidebar">
        <button onclick="loadPage('user')" class="sidebar-button">用户管理</button>
        <button onclick="loadPage('teacher')" class="sidebar-button">教师管理</button>
        <button onclick="loadPage('video')" class="sidebar-button">课程管理</button>
        <button onclick="loadPage('admin')" class="sidebar-button">管理员列表</button>
        <button onclick="loadPage('comment')" class="sidebar-button">评论管理</button>
    </div>
    <div class="content" >
        <!-- 默认显示的内容 -->
        <h2>欢迎进入在线学习平台管理页面！</h2>
        <p>请选择你将要管理的类别</p>
    </div>
</div>
</body>
</html>
