<%--
  Created by IntelliJ IDEA.
  User: 钱杨苓
  Date: 2024/11/17
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>内容上传</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
    <div class="header-container">
        <h1>内容上传</h1>
        <nav>
            <ul>
                <li><a href="teacherDashboard.jsp">首页</a></li>
                <li><a href="courseManagement.jsp">课程管理</a></li>
                <li><a href="personalInfo.jsp">个人信息</a></li>
            </ul>
        </nav>
    </div>
</header>
<main>
    <div class="upload-container">
        <h2>上传课程内容</h2>
        <form action="uploadContent" method="post" enctype="multipart/form-data" class="upload-form">
            <label for="file">选择文件：</label>
            <input type="file" id="file" name="file" required>
            <label for="courseId">选择课程：</label>
            <select name="courseId" id="courseId">
                <c:forEach var="course" items="${courseList}">
                    <option value="${course.id}">${course.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="上传" class="button upload-button">
        </form>
    </div>
</main>
</body>
</html>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }

    body {
        background-color: #f4f6f9;
        color: #333;
    }

    /* Header */
    header {
        background-color: #003366; /* 深蓝色 */
        color: #fff;
        padding: 15px 0;
    }

    .header-container {
        width: 90%;
        margin: 0 auto;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    nav ul {
        list-style: none;
        display: flex;
    }

    nav ul li {
        margin: 0 15px;
    }

    nav ul li a {
        color: #fff;
        text-decoration: none;
        font-weight: bold;
    }

    nav ul li a:hover {
        text-decoration: underline;
    }

    /* Main Content */
    main {
        padding: 20px;
        width: 90%;
        margin: 20px auto;
    }

    /* Dashboard */
    .dashboard-container {
        text-align: center;
    }

    .quick-links {
        display: flex;
        justify-content: space-around;
        margin-top: 20px;
    }

    .link-box {
        background-color: #004aad;
        color: #fff;
        padding: 20px;
        width: 30%;
        text-align: center;
        border-radius: 10px;
        cursor: pointer;
    }

    .link-box:hover {
        background-color: #004aad;
    }

    .quick-links .link-box h3 {
        margin-bottom: 10px;
    }

    .quick-links .link-box p {
        font-size: 14px;
    }

    /* Buttons */
    .button {
        background-color: #0766c5;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    .button:hover {
        background-color: #095ec8;
    }

    /* Course Management */
    .course-management-container {
        margin-top: 20px;
    }

    .course-table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    .course-table th, .course-table td {
        padding: 10px;
        border: 1px solid #ddd;
        text-align: center;
    }

    .course-table th {
        background-color: #096bcb;
        color: #fff;
    }

    /* Upload Form */
    .upload-container {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .upload-form label {
        margin-top: 10px;
    }

    .upload-form input[type="file"], .upload-form select {
        padding: 10px;
        margin-top: 10px;
        width: 100%;
        border: 1px solid #ddd;
        border-radius: 5px;
    }

    .upload-form input[type="submit"] {
        margin-top: 20px;
    }

    /* Form */
    .info-form input[type="text"], .info-form input[type="email"] {
        padding: 10px;
        margin-top: 10px;
        width: 100%;
        border: 1px solid #ddd;
        border-radius: 5px;
    }

    .info-form input[type="submit"] {
        margin-top: 20px;
    }
</style>
