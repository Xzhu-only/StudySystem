
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>管理员列表</title>
</head>
<body>
<div style="text-align: center;">

    <table>
        <tr class="headline">
            <td>管理员编号</td>
            <td>管理员</td>
            <td>密码</td>
        </tr>
        <%--    --%>
        <jsp:useBean id="adminList" scope="request" type="java.util.List"/>
        <c:forEach items="${adminList}" var="admin">
            <tr >
                    <%--字段不区分大小写?\--%>
                <td>${admin.aid}</td>
                <td>${admin.aname}</td>
                <td>${admin.apassword}</td>
                <td><a href="<%=path%>/HandleGetOne?aname=${admin.aname}&type=admin" class="rounded-button">修改</a></td>
                <td><a href="<%=path%>/HandleDel?aname=${admin.aname}&type=admin" onclick="if (confirm('确定要删除'+'${admin.aname}'+'吗？')==false)return false" class="rounded-button">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<a href="<%=path%>/page/admin/addadmin.jsp" class="rounded-button" onclick="showModal()">添加管理员</a>
</body>
</html>
<script>
    function showModal() {
        var modal = document.getElementById("myModal");
        modal.style.display = "block";
    }
</script>