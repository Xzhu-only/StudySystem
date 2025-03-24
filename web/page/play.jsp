<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>在线学习平台-课程播放</title>
<link href="<%=path%>/page/static/css/main.css" rel="stylesheet" type="text/css"/>
<link href="<%=path%>/page/static/css/play.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=path%>/page/static/js/indexjs.js"></script>
<script type="text/javascript" src="<%=path%>/page/static/js/jquery-1.4.4.js"></script>
<script src="<%=path%>/page/static/js/jquery-1.5.1.min.js"></script>
<head>
    <title>课程播放页</title>
</head>
<body>
<div class="header" >
    <div class="header_all">
        <div class="header_logo" ><a href="<%=path%>/index.jsp"><img src="<%=path%>/page/static/images/logo1.png"/></a></div>
        <div class="header_div">
            <ul class="header_ul">
                <%--                <jsp:useBean id="uname" scope="session" type="java.lang.String"/>--%>
                <c:if test="${empty uname}">
                    <li class="header_li"><a class="logoa"  href="<%=path%>/page/login.jsp">登录</a></li>
                    <li class="header_li"><a class="logoa"  href="<%=path%>/page/register.jsp">注册</a></li>
                </c:if>
                <c:if test="${not empty uname}">
                    <li class="header_li"><a class="logoa">欢迎您,${uname}</a></li>
                    <li class="header_li"><a class="logoa"  href="<%=path%>/HandleGetOne?type=user1&uname=${uname}">空间</a></li>
                </c:if>
                <li class="header_li"><a class="logoa"  href="<%=path%>/HandleGetAll?type=video1">所有课程</a></li>
                <li class="header_li"><a class="logoa"  href="<%=path%>index.jsp#course">推荐课程</a></li>
                <li class="header_li"><a class="logoa"  href="<%=path%>#foot">联系我们</a></li>
            </ul>
        </div>
    </div>
</div>

<div style="text-align:center">
<video src="${videoOne.path}" controls="controls" class="video_play"></video>
    <div class="btns">
        <button>播放</button>
        <button>暂停</button>
        <button>快进</button>
        <button>快退</button>
        <button>快倍速</button>
        <button>慢倍速</button>
    </div>
</div>
<div>
    <p class="video_css" style="font-size: 20px;">${videoOne.vname}</p>
    <p class="video_css" style="font-size: 15px;">简介：${videoOne.introduce}</p>
</div>

<div class="comment-section">
    <div class="comment-input">
        <form action="<%=path%>/HandleAdd?type=comment1&uname=<%=session.getAttribute("uname")%>&vid=${videoOne.vid}" method="post">
            <label>
                <input required type="text" name="comments" placeholder="输入评论..." />
            </label>
            <button type="submit">发送</button>
        </form>
    </div>
    <div class="comment-display">
        <%-- 循环遍历评论列表，并显示每条评论 --%>
        <c:forEach var="comment" items="${commentslist}">
            <div style="border: 1px solid #90a7e0; margin-bottom: 10px;">
            <p >${comment.uid},${comment.create_time}</p>
            <p>${comment.comment}</p>
            </div>
        </c:forEach>
    </div>
</div>


<a name="foot"></a>
<div class="foot">
    <div class="foot_all" >
        <div class="foot_right">
            <p style="  color:#fff; font-size:14px;
	" >联系我们</p>
            <p style=" color:#fff; font-size:29px;"><img src="<%=path%>page/static/images/call.png" style=" margin-bottom:-3px; margin-right:10px;"  />13398522912</p>
            <p style=" color:#9A9EA7; font-size:14px;">邮箱：sdc.lzqian22@gzu.edu.cn</p>
            <p style=" color:#9A9EA7; font-size:14px; margin-top:-6px;">联系电话：13398522912</p>
        </div>
    </div>
</div>
<script>
    //1.通过标签名获取视频
    var video=document.getElementsByTagName('video')[0];
    //2.获取class名按钮
    var btns=document.getElementsByClassName('btns')[0];
    console.log(btns);
    //3.判断按钮的文本内容、绑定事件
    btns.onclick=function(){
        //4.获取按钮内的事件 因为这里产生了点击 所以有点击事件
        var text=event.target.innerText;
        if(text === '播放'){video.play()}
        if(text === '暂停'){video.pause()}
        if(text === '快进'){
            video.currentTime +=10
            video.play()}
        if(text === '快退'){
            video.currentTime -=10
            video.play()}
        if(text === '快倍速'){
            console.log(video.playbackRate);
            video.playbackRate *= 1.8
            video.play()}
        if(text === '慢倍速'){
            video.playbackRate *= 0.5
            video.play()}
    }
</script>
</body>
</html>
