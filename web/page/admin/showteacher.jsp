<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>教师信息管理</title>
</head>
<body>
<table>
    <tr class="headline">
        <td>教师编号</td>
        <td>教师名</td>
        <td>密码</td>
        <td>介绍</td>
        <td>证明</td>
        <td>封禁</td>
    </tr>

    <c:forEach items="${teacherList}" var="teacher">

        <tr>
            <td>${teacher.tid}</td>
            <td>${teacher.tname}</td>
            <td>**********</td>
            <td>${teacher.prone}</td>
            <td>${teacher.introduce}</td>
            <td>${teacher.isdelete}</td>
            <td><a href="<%=path%>/HandleGetOne?tname=${teacher.tname}&type=teacher" class="rounded-button">修改</a></td>
            <td><a href="<%=path%>/HandleDel?tname=${teacher.tname}&type=teacher" onclick="if (confirm('确定要删除'+'${teacher.tname}'+'吗？')==false)return false" class="rounded-button">删除</a></td>
        </tr>
    </c:forEach>
</table>
<a href="<%=path%>/page/admin/addteacher.jsp" class="rounded-button" onclick="showModal()">添加教师</a>
</body>
</html>
<script>
    function showModal() {
        var modal = document.getElementById("myModal");
        modal.style.display = "block";
    }
</script>
