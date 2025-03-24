<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<%
    String path = request.getContextPath();
%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>教师管理系统</title>
    <link rel="stylesheet" href="styles.css">
    <script>
        // 用于动态加载页面内容
        function loadPage(url) {
            const content = document.getElementById("content");
            fetch(url)
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Network response was not ok");
                    }
                    return response.text();
                })
                .then(html => {
                    content.innerHTML = html;  // 将返回的 HTML 内容插入到 #content 区域
                })
                .catch(error => {
                    content.innerHTML = `<p>无法加载页面: ${error.message}</p>`;
                });
        }
    </script>
</head>
<body>

<div class="container">
    <!-- 侧边栏 -->
    <aside class="sidebar">
        <div class="sidebar-header">
            <h2>教师管理系统</h2>
            <p>欢迎回来, ${Tname}</p>
        </div>
        <nav class="sidebar-nav">
            <ul>
                <li><a href="javascript:void(0)" onclick="loadPage('<%=path%>/courseManagement')" class="sidebar-link">课程管理</a></li>
                <li><a href="javascript:void(0)" onclick="loadPage('<%=path%>/HandleGetAll?type=video2&tname=${Tname != null ? Tname : 'defaultName'}')" class="sidebar-link">视频管理</a></li>
<%--                <li><a href="javascript:void(0)" onclick="loadPage('<%=path%>/comment')" class="sidebar-link">评论查看</a></li>--%>
                <li>
                    <a href="javascript:void(0)" onclick="loadPage('<%=path%>/HandleGetOne?type=teacher1&tname=${Tname != null ? Tname : 'defaultName'}')" class="logoa">个人资料</a>
                </li>

                <li> <li class="header_li"><a class="logoa"  href="<%=path%>/HandleLogout?uname=${Tname}">注销</a></li>
                </li>
            </ul>
        </nav>
    </aside>

    <!-- 主体内容 -->
    <main class="main-content">
        <section id="content">
            <p>请选择侧边栏中的功能以开始操作。</p>
        </section>
    </main>
</div>

</body>
</html>

<style>
    /* General Styles */
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }

    body {
        display: flex;
        height: 100vh;
        background-color: #f4f6f9;
        color: #333;
    }

    .container {
        display: flex;
        width: 100%;
    }

    /* Sidebar */
    .sidebar {
        width: 250px;
        background-color: #003366; /* 深蓝色 */
        color: #fff;
        display: flex;
        flex-direction: column;
        padding: 20px;
        box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
    }

    .sidebar-header h2 {
        font-size: 1.5rem;
        margin-bottom: 10px;
    }

    .sidebar-header p {
        font-size: 1rem;
        color: #ccc;
        margin-bottom: 20px;
    }

    .sidebar-nav ul {
        list-style: none;
        padding: 0;
    }

    .sidebar-nav ul li {
        margin-bottom: 10px;
    }

    .sidebar-nav ul li a {
        text-decoration: none;
        color: #fff;
        font-size: 1.1rem;
        display: block;
        padding: 10px 15px;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    .sidebar-nav ul li a:hover {
        background-color: #0066cc;
    }

    /* Main Content */
    .main-content {
        flex: 1;
        padding: 20px;
        overflow-y: auto;
    }

    .main-content header h1 {
        margin-bottom: 20px;
        font-size: 1.8rem;
    }

    #content p {
        font-size: 1.2rem;
        color: #555;
    }
</style>
