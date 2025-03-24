
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
%>
<html>
<head>
    <title>添加用户</title>
</head>
<link href="<%=path%>/page/static/css/main.css" rel="stylesheet" type="text/css"/>
<style>
  form {
    border: 1px solid #90a7e0; /* 设置表单边框样式 */
    padding: 10px; /* 设置表单内边距 */
    background-color: rgba(114, 109, 109, 0.5); /* 设置半透明的背景颜色 */
    width: 300px; /* 设置表单宽度 */
  }

  form label {
    display: block; /* 每个标签占据一行 */
    margin-bottom: 10px; /* 设置标签之间的间距 */
  }

  form input[type="submit"] {
    background-color: #fff; /* 设置提交按钮背景颜色 */
    padding: 5px 10px; /* 设置提交按钮内边距 */
  }
  form input[type="button"] {
    background-color: #fff; /* 设置提交按钮背景颜色 */
    padding: 5px 10px; /* 设置提交按钮内边距 */
  }
</style>
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
<form action="${pageContext.request.contextPath}/HandleAdd?type=user" method="post">
    <label>用户名<input type="text" name="username" id="username"></label>
    <label>专业<input type="text" name="major" id="major"></label>
    <label>班级<input type="text" name="claname" id="claname"></label>
    <label>密码<input type="password" name="password" id="password"></label>
    <label>评论<input type="text" name="commits" id="commits"></label>
    <label>密保<input type="text" name="safeanwser" id="safeanwser"></label>

  <input type="submit" value="添加">
  <input type="button" value="返回" onclick="history.back()">
</form>
</body>
</html>
