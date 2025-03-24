
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>视频修改页</title>
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
<form action="${pageContext.request.contextPath}/HandleUpdate?type=video1" method="post">
   <label>视频编号<input type="text" name="vid" required value="${videoOne.vid}"/></label><br/>
<%--    <label>教师编号<input type="text" name="tid" readonly value="${videoOne.tid}"/></label><br/>--%>
    <label>视频名<input type="text" name="vname" required  value="${videoOne.vname}"/></label><br/>
    <label>分类<input type="text" name="category"  required    value="${videoOne.category}"/></label><br/>
    <label>难度等级<input type="text" name="grade"  required  value="${videoOne.grade}"/></label><br/>
    <label>介绍<input type="text" name="introduce" required   value="${videoOne.introduce}"/></label><br/>
    <input type="submit" value="修改">
    <input type="button" value="返回" onclick="history.back()">
</form>

</body>
</html>
