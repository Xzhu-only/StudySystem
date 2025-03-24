
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path=request.getContextPath();
%>
<html>
<head>
    <title>在线学习平台-登录</title>
    <link href="<%=path%>/page/static/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/page/static/css/denglu.css" rel="stylesheet" type="text/css"/>
</head>

<style>
    form input[type="submit"] {
        background-color: #90a7e0; /* 设置提交按钮背景颜色 */
        padding: 5px 10px; /* 设置提交按钮内边距 */
    }
</style>

<body>
<div class="header" >
    <div class="header_all">
        <div class="header_logo"><a href="<%=path%>/index.jsp"><img src="<%=path%>/page/static/images/logo1.png"/></a></div>
        <div class="header_div">
            <ul>
                <li class="header_li"><a class="logoa" href="<%=path%>/HandleGetAll?type=video1">所有课程</a></li>
                <li class="header_li"><a class="logoa" href="<%=path%>/index.jsp#course">推荐课程</a></li>
                <li class="header_li"><a class="logoa" href="<%=path%>/index.jsp#foot">联系我们</a></li>
            </ul>
        </div>
    </div>
</div>
<%--$串是获取url，此页面是登录页--%>
<div class="login-box">
    <div class="input-box">
        <form action="${pageContext.request.contextPath}/HandleLogin" method="post">
        <div class="input-text">
                <label>账号<input required type="text" name="username"/></label><br/>
            </div>
            <div class="input-text">
                <label>密码<input required type="password" name="password"/></label><br/>
            </div>
            <label>学生<input name="type" type="radio" value="user" checked="checked"></label>
          <label>教师<input name="type" type="radio" value="teacher"></label>
            <label>管理员<input name="type" type="radio" value="admin"></label>
            <div>
              <input type="submit" value="登录">
            </div>
        </form>
        <div style="font-size: 15px;display: flex;justify-content: center;text-decoration: none; width: 100%;color: #000000;">
            <a onclick="window.location='register.jsp';">用户注册</a>
           <a onclick="window.location='teacher/register.jsp';">教师注册</a>
            <a href="<%=path%>/page/find.jsp">忘记密码</a>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    // 用户登录弹窗
    const message = "<%=request.getParameter("LoginError")%>";
    if (message) {
        console.error(message);
        if ("WrongName" === message) {
            alert("用户名未注册，请先注册");
            window.location = 'register.jsp';
        } else if ("nothing" === message) {
            alert("用户信息为空，请先登录");
            window.location = 'login.jsp';
        } else if ("ban" === message) {
            alert("账户被封禁，无法登录");
            window.location = 'login.jsp';
        } else if ("WrongPass" === message) {
            alert("密码错误，请重新登录！");
            window.location = 'login.jsp';
        }
    }
    // 教师登录弹窗
    const message1= "<%=request.getParameter("TeacherLoginError")%>";
    if (message1) {
        console.error(message1);
        if ("WrongName" === message1) {
            alert("教师用户名未注册，请先注册");
            window.location = 'teacher/register.jsp';
        } else if ("nothing" === message1) {
            alert("教师信息为空，请先登录");
            window.location = 'login.jsp';
        } else if ("WrongPass" === message1) {
            alert("密码错误，请重新登录!!!");
            window.location = 'login.jsp';
        } else if ("Success" === message1) {
            alert("教师登录成功");
            window.location = 'teacher/TeacherFirst.jsp'; // 根据教师登录成功后的页面路径替换
        }
    }

    // 管理员登录弹窗
    const message2 = "<%=request.getParameter("ALError")%>";
    if (message2) {
        console.error(message2);
        if ("WrongName" === message2) {
            alert("该账户不存在");
            window.location = 'login.jsp';
        } else if ("nothing" === message2) {
            alert("登录信息为空");
            window.location = 'login.jsp';
        } else if ("WrongPass" === message2) {
            alert("密码错误，请重新登录");
            window.location = 'login.jsp';
        } else if ("Success" === message2) {
            alert("登录成功");
            window.location = 'admin/manage.jsp';
        }
    }

    // 密码修改成功提示
    const message3 = "<%=request.getParameter("ModifyError")%>";
    if (message3) {
        console.error(message3);
        if ("success" === message3) {
            alert("密码修改成功，请登录");
            window.location = 'login.jsp';
        }
    }


</script>


