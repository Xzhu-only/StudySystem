
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
%>
<html>
<head>
    <title>错误页</title>
    <link href="<%=path%>/page/static/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="header" >
    <div class="header_all">
        <div class="header_logo"><a href="<%=path%>/index.jsp"><img src="<%=path%>/page/static/images/logo1.png"/></a></div>
        <div class="header_div">
            <ul>
                <li class="header_li">在线学习平台错误页面</li>
            </ul>
        </div>
    </div>
</div>

<h3>
    请注意：出错了，你可能进行了不符合规则的操作。
</h3>
<input type="button" value="返回" onclick="history.back()">
</body>
</html>
