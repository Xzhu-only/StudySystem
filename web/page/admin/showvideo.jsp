
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String paths = request.getContextPath();
%>
<html>
<head>
    <title>视频信息管理</title>
</head>
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
<body>
<div style="text-align: center;">
<table>
    <tr class="headline">
        <td>视频编号</td>
        <td>教师编号</td>
        <td>视频名</td>
        <td>分类</td>
        <td>难度等级</td>
        <td>介绍</td>
        <td>封面</td>
        <td>视频</td>
    </tr>
    <c:forEach items="${videoList}" var="items">
        <tr class="table-fa">
                <%--字段不区分大小写?\--%>
            <td class="table-cell">${items.vid}</td>
            <td class="table-cell">${items.tid}</td>
            <td class="table-cell">${items.vname}</td>
            <td class="table-cell">${items.category}</td>
            <td class="table-cell">${items.grade}</td>
            <td class="table-cell">${items.introduce}</td>
                    <td class="table-cell">
                        <img style="height: 150px;width:170px" src="<%= request.getContextPath() %>${items.img}" alt="">
                    </td>
                    <td class="table-cell">
                        <video style="height: 150px;width:170px" src="<%= request.getContextPath() %>${items.path}" controls="controls"></video>
                    </td>
            <td class="table-cell"><a href="<%=paths%>/HandleGetOne?vname=${items.vname}&type=video" class="rounded-button">修改</a></td>
            <td class="table-cell"><a href="<%=paths%>/HandleDel?vname=${items.vname}&type=video" onclick="if (confirm('确定要删除'+'${video.vname}'+'吗？')==false)return false" class="rounded-button">删除</a></td>
        </tr>
    </c:forEach>
</table>
</div>
<a href="<%=paths%>/page/admin/addvideo.jsp" class="rounded-button" onclick="showModal()">添加视频</a>
</body>
</html>
