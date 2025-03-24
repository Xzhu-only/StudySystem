<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>在线学习平台-视频列表</title>
<link href="<%=path%>page/static/css/main.css" rel="stylesheet" type="text/css"/>
<link href="<%=path%>page/static/css/style.css" rel="stylesheet" type="text/css"/>
<link href="<%=path%>page/static/css/lanrenzhijia.css" type="text/css" rel="stylesheet" />
<link href="<%=path%>page/static/css/initializtion.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=path%>page/static/js/indexjs.js"></script>
<script type="text/javascript" src="<%=path%>page/static/js/jquery-1.4.4.js"></script>
<script src="<%=path%>page/static/js/jquery-1.5.1.min.js"></script>
<head>
    <title>课程展示页</title>
</head>
<style>
    .search-form {
        display: flex;
        justify-content: center;
        align-items: center;
        margin-bottom: 15px;
    }

    .search-form input[type="text"] {
        width: 300px;
        padding: 10px;
        font-size: 10px;
    }

    .search-form button[type="submit"] {
        margin-left: 10px;
        font-size: 10px;
    }
</style>
<body>
<div class="header" >
    <div class="header_all">
        <div class="header_logo" ><a href="<%=path%>/index.jsp"><img src="<%=path%>page/static/images/logo1.png"/></a></div>
        <div class="header_div">
            <ul class="header_ul">
                <c:if test="${empty uname}">
                    <li class="header_li"><a class="logoa"  href="<%=path%>login.jsp">登录</a></li>
                    <li class="header_li"><a class="logoa"  href="<%=path%>register.jsp">注册</a></li>
                </c:if>
                <c:if test="${not empty uname}">
                    <li class="header_li"><a class="logoa">欢迎您,${uname}</a></li>
                    <li class="header_li"><a class="logoa"  href="<%=path%>/HandleGetOne?type=user1&uname=${uname}">空间</a></li>
                </c:if>
                <li class="header_li"><a class="logoa"  href="<%=path%>/HandleGetAll?type=video1">所有课程</a></li>
                <li class="header_li"><a class="logoa" href="<%=path%>/index.jsp#course">推荐课程</a></li>
                <li class="header_li"><a class="logoa" href="<%=path%>/index.jsp#foot">联系我们</a></li>
                <%--        <li class="header_li"><input id="texts" type="text" onclick="cleartext('texts')" style="height:27px;width:190px; color:#ccc; font-family:'微软雅黑'; font-size:18px;" value="搜索教室或课程" /><input type="image" src="page/static/images/search.png" style=" border:1px solid #CCC; width:25px; margin-left:-30px; margin-top:0px; margin-bottom:-6px; border-bottom:none; border-top:none; border-right:none;" /></li>--%>

            </ul>
        </div>
    </div>
</div>
<a name="videos"></a>
<div class="center_read">
    <div class="titles">
        <div class="left_img"></div>
        <div class="center_title" >课程列表</div>
        <div class="right_img"></div>
    </div>
    <div class="search-form">
        <form action="<%=path%>/HandleSearch?type=search" method="post">
            <input type="text" name="keyword" placeholder="输入课程名关键字...">
            <button type="submit">搜索</button>
        </form>
    </div>
    <div class="search-form">
        <form action="<%=path%>/HandleSearch" method="post" accept-charset="UTF-8">
            <input type="hidden" name="type" value="category">
            <select name="instrumentType">
                <option value="">全部</option>
                <option value="专业选修">专业选修</option>
                <option value="学科大类必修">学科大类必修</option>
                <option value="专业必修">专业必修</option>

            </select>

            <select name="hardType">
                <option value="">全部</option>
                <option value="初级">初级</option>
                <option value="中级">中级</option>
                <option value="高级">高级</option>
            </select>

            <button type="submit">搜索</button>
        </form>


    </div>


    <div class="read_all">
        <c:forEach items="${videoList}" var="items">
            <div style="width: 33%;height: 80px;background-color: lightblue;">
                <a href="<%=path%>/HandlePlay?vid=${items.vid}">
                    <img class="news-image" src=${items.img} alt=""/></a>
                <div class="read_div" >
                    <p class="read-summary">${items.vname}</p>
                    <p class="read-summary">${items.introduce}</p>
                </div>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
<div class="pagination-container">
    <div class="pagination">
        <ul id="pagination-list">
            <!-- 分页导航条 -->
        </ul>
        <button id="prev-button">上一页</button> <!-- 上一页按钮 -->
        <button id="next-button">下一页</button> <!-- 下一页按钮 -->
    </div>
</div>

<a name="foot"></a>
<div class="foot">
    <div class="foot_all" >
        <div class="foot_right">
            <p style="  color:#fff; font-size:14px;
	" >联系我们</p>
            <p style=" color:#fff; font-size:29px;"><img src="<%=path%>page/static/images/call.png" style=" margin-bottom:-3px; margin-right:10px;"  />13398522912</p>
            <p style=" color:#9A9EA7; font-size:14px;">邮箱：sdc.lzqian22.gzu.edu.cn</p>
            <p style=" color:#9A9EA7; font-size:14px; margin-top:-6px;">联系电话：13398522912</p>
        </div>
    </div>
</div>
<script>
    var videoList = [
        <c:forEach items="${videoList}" var="video" varStatus="status">
        {
            vid: '${video.vid}',
            vname: '${video.vname}',
            img:'${video.img}',
            introduce: '${video.introduce}',
        }<c:if test="${!status.last}">,</c:if>
        </c:forEach>
    ];
    var itemsPerPage = 6; // 每页显示的数据条数
    var totalItems = videoList.length; // 数据总数
    var totalPages = Math.ceil(totalItems / itemsPerPage); // 计算总页数

    var currentPage = 1; // 当前页码

    function displayData() {
        var startIndex = (currentPage - 1) * itemsPerPage; // 起始索引
        var endIndex = startIndex + itemsPerPage; // 结束索引（不包含）

        var readAllDiv = document.querySelector('.read_all');
        readAllDiv.innerHTML = ''; // 清空容器

        for (var i = startIndex; i < endIndex && i < totalItems; i++) {
            var item = videoList[i];

            var div = document.createElement('div');
            div.style.width = '330px';
            div.style.height = 'auto';
            div.style.float = 'left';
            div.style.display = 'inline';
            //设置list内的值
            var a = document.createElement('a');
            a.href = '<%= path %>/HandlePlay?vid=' + item.vid;

            var img = document.createElement('img');
            img.className = 'news-image';
            img.src = item.img;

            var readDiv = document.createElement('div');
            readDiv.className = 'read_div';

            var p1 = document.createElement('p');//废弃
            p1.className = 'read-summary';
            p1.textContent = item.vname;

            var p2 = document.createElement('p');//废弃
            p2.className = 'read-summary';
            p2.textContent = item.introduce;

            readDiv.appendChild(p1);
            readDiv.appendChild(p2);

            a.appendChild(img);
            a.appendChild(readDiv);

            div.appendChild(a);

            readAllDiv.appendChild(div);
        }
    }
    function createPagination() {
        var paginationList = document.getElementById('pagination-list');
        for (var i = 1; i <= totalPages; i++) {
            var li = document.createElement('li');
            paginationList.appendChild(li);
        }
    }
    function updatePagination() {
    }
    function nextPage() {//下一页函数
        if (currentPage < totalPages) {
            currentPage++;
            displayData();
            updatePagination();
        }
    }
    function prevPage() {//上一页函数
        if (currentPage > 1) {
            currentPage--;
            displayData();
            updatePagination();
        }
    }
    createPagination();
    displayData();
    var prevButton = document.getElementById('prev-button');//上一页点击
    prevButton.addEventListener('click', prevPage);
    var nextButton = document.getElementById('next-button');//下一页点击
    nextButton.addEventListener('click', nextPage);
</script>

</body>
</html>
