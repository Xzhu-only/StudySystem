<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>教师注册</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f9;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    .container {
      background-color: #ffffff;
      border: 1px solid #ddd;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      width: 100%;
      max-width: 400px;
    }

    h2 {
      text-align: center;
      margin-bottom: 20px;
    }

    label {
      display: block;
      margin: 10px 0 5px;
    }

    input[type="text"], input[type="password"], textarea {
      width: 100%;
      padding: 8px;
      margin: 5px 0 15px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    textarea {
      resize: vertical;
      height: 80px;
    }

    button {
      width: 100%;
      padding: 10px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    button:hover {
      background-color: #45a049;
    }

    p {
      text-align: center;
      font-size: 14px;
    }

    p[style="color: red;"] {
      color: red;
    }

    p[style="color: green;"] {
      color: green;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>教师注册</h2>
  <form action="/HandleRegister" method="post">
    <input type="hidden" name="type" value="teacher">

    <label for="name">姓名:</label>
    <input type="text" id="name" name="name" required placeholder="请输入姓名">

    <label for="password">密码:</label>
    <input type="password" id="password" name="password" required placeholder="请输入密码">

    <label for="password2">确认密码:</label>
    <input type="password" id="password2" name="password2" required placeholder="请确认密码">

    <label for="phone">电话:</label>
    <input type="text" id="phone" name="phone" required placeholder="请输入电话号码">

    <label for="info">个人简介:</label>
    <textarea id="info" name="info" required placeholder="请输入个人简介"></textarea>

    <button type="submit">注册</button>
  </form>

  <c:if test="${param.RegisterError == 'success'}">
    <p style="color: green;">注册成功！</p>
    <script>
      // 注册成功后显示弹窗，并在3秒后跳转到登录页面
      setTimeout(function() {
        alert('注册成功！正在跳转到登录页面...');
        window.location.href = '/page/login.jsp'; // 跳转到登录页面
      }, 3000); // 3秒后跳转
    </script>
  </c:if>
</div>
</body>
</html>
