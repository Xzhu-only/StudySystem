
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>账号找回</title>
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

<form action="${pageContext.request.contextPath}/HandleFind" method="post">
    <label>账号<input required type="text" name="username"/></label><br/>
    <label>密保问题<input required type="text" name="safeanwser"/></label><br/>
    <input type="submit" value="找回">
</form>

</body>
</html>
<script>
    const message = "<%=request.getParameter("FindError")%>"
    console.error(message)
    if("fail"===message){
        alert("信息有误或验证失败，请重新验证")
        window.location='find.jsp'}
    else if("ban"===message){
        alert("账号封禁中")
        window.location='find.jsp'}
</script>