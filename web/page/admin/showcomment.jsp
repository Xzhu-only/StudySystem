<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>评论信息管理</title>
</head>
<body>
<div style="text-align:center">
    <table>
        <tr class="headline">
            <td>评论编号</td>
            <td>用户号</td>
            <td>视频</td>
            <td>评论内容</td>
            <td>评论时间</td>
        </tr>
        <%--    --%>
        <jsp:useBean id="commentList" scope="request" type="java.util.List"/>
        <c:forEach items="${commentList}" var="comment">
            <tr >
                    <%--字段不区分大小写?\--%>
                <td>${comment.cid}</td>
                <td>${comment.uid}</td>
                <td>${comment.vid}</td>
                <td>${comment.comment}</td>
                <td>${comment.create_time}</td>
                <td><a href="<%=path%>/HandleDel?cid=${comment.cid}&uid=${comment.uid}&type=comment" onclick="if (confirm('确定要删除这条评论吗？')==false)return false" class="rounded-button">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<input type="button" value="返回" onclick="history.back()" class="rounded-button">

</body>
</html>
<script>
    function showModal() {
        var modal = document.getElementById("myModal");
        modal.style.display = "block";
    }
</script>