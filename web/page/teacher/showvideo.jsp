<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String paths = request.getContextPath();
%>
<html>
<head>
    <title>视频信息管理</title>
    <STYLE>
        .table-cell {
            height: 50px; /* 设置单元格的高度 */
            vertical-align: middle; /* 控制单元格中内容的垂直对齐方式 */
        }
        .table-fa {
            height: 52px; /* 设置单元格的高度 */
            vertical-align: middle; /* 控制单元格中内容的垂直对齐方式 */
        }
    </STYLE>
</head>
<body>
<div style="text-align: center;">
    <h2>教师视频信息管理</h2>
    <table border="1">
        <thead>
        <tr class="headline">
            <td>视频编号</td>
            <td>教师编号</td>
            <td>视频名</td>
            <td>分类</td>
            <td>难度等级</td>
            <td>介绍</td>
            <td>封面</td>
            <td>视频</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty videoList}">
            <c:forEach items="${videoList}" var="item">
                <tr class="table-fa">
                    <td class="table-cell">${item.vid}</td>
                    <td class="table-cell">${item.tid}</td>
                    <td class="table-cell">${item.vname}</td>
                    <td class="table-cell">${item.category}</td>
                    <td class="table-cell">${item.grade}</td>
                    <td class="table-cell">${item.introduce}</td>
                    <td class="table-cell">
                        <img style="height: 150px;width:170px" src="<%= request.getContextPath() %>${item.img}" alt="封面图">
                    </td>
                    <td class="table-cell">
                        <video style="height: 150px;width:170px" src="<%= request.getContextPath() %>${item.path}" controls="controls"></video>
                    </td>
                    <td>
                        <a href="<%= request.getContextPath() %>/HandleGetAll?vid=${item.vid}&type=comment2">查看评论</a>
                    </td>
<%--                    <td class="table-cell">--%>
<%--                        <a href="<%= paths %>/HandleGetOne?vname=${item.vname}&type=video1" class="rounded-button">修改</a>--%>
<%--                    </td>--%>
                    <td class="table-cell">
                        <a href="<%= paths %>/HandleDel?vname=${item.vname}&type=video1" onclick="if (confirm('确定要删除视频 ${item.vname} 吗？')==false)return false" class="rounded-button">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty videoList}">
            <tr>
                <td colspan="9" class="table-cell">暂无视频信息</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<a href="<%= paths %>/page/teacher/addvideo.jsp" class="rounded-button" onclick="showModal()">添加视频</a>
</body>
</html>
