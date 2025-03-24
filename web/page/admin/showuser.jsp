<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>用户信息管理</title>
</head>
<body>
<table>
    <tr class="headline">
        <td>用户编号</td>
        <td>用户名</td>
        <td>密码</td>
        <td>简介</td>
        <td>密保</td>
        <td>封禁</td>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.uid}</td>
            <td>${user.uname}</td>
            <td>**********</td>
            <td>${user.commits}</td>
            <td>**********</td>
            <td>${user.isdelete}</td>
            <td><a href="${path}/HandleGetOne?uname=${user.uname}&type=user" class="rounded-button">修改</a></td>
            <td><a href="${path}/HandleDel?uname=${user.uname}&type=user" onclick="return confirm('确定要删除 ${user.uname} 吗？')" class="rounded-button">删除</a></td>
        </tr>
    </c:forEach>
</table>
<a href="${path}/page/admin/adduser.jsp" class="rounded-button" onclick="showModal()">添加用户</a>
</body>
</html>
<script>
    function showModal() {
        var modal = document.getElementById("myModal");
        modal.style.display = "block";
    }
</script>

<%--<script>--%>
<%--    const message = "<%=request.getParameter("deleteInfo")%>"--%>
<%--    console.error(message)--%>
<%--    if ("success"===message){--%>
<%--        alert("删除成功")--%>
<%--        window.location='moduser.jsp'--%>
<%--    }else if ("fail"===message){--%>
<%--        alert("删除失败")--%>
<%--        window.location='moduser.jsp'--%>
<%--    }--%>
<%--</script>--%>