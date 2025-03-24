
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String path = request.getContextPath();
%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>在线学习平台-首页</title>
  <link href="page/static/css/main.css" rel="stylesheet" type="text/css"/>
  <link href="page/static/css/style.css" rel="stylesheet" type="text/css"/>
  <script type="text/javascript" src="page/static/js/indexjs.js"></script>
  <script type="text/javascript" src="page/static/js/jquery-1.4.4.js"></script>
  <style>
    *{
      margin: 0;
      padding: 0;
    }
    ul li {
      list-style: none;
    }
    .slideshow{
      position: relative;
      width: 1400px;
      height: 600px;
      margin: 0 auto;
      overflow: hidden;
    }
    .slideshow ul{
      width: 600%;
      position: absolute;
      height: 600px;
      left: 0;
      top: 0;
      /* transition: all 0s; */
    }
    .slideshow ul li{
      float: left;
      width: 1400px;
      height: 600px;
    }
    .slideshow ul li a img{
      width: 1400px;
      height: 600px;
    }
  </style>
</head>
<body><div class="header">
  <div class="header_all">
    <div class="header_logo"><a href="index.jsp"><img src="page/static/images/logo1.png"/></a></div>
    <div class="header_div">
      <ul class="header_ul">
        <c:if test="${empty uname}">
          <li class="header_li"><a class="logoa"  href="page/login.jsp">登录</a></li>
          <li class="header_li"><a class="logoa"  href="page/register.jsp">注册</a></li>
        </c:if>
        <c:if test="${not empty uname}">
          <li class="header_li"><a class="logoa">欢迎您,${uname}</a></li>
          <li class="header_li"><a class="logoa"  href="<%=path%>/HandleGetOne?type=user1&uname=${uname}">个人资料</a></li>
          <li class="header_li"><a class="logoa"  href="<%=path%>/HandleLogout?uname=${uname}">注销</a></li>
        </c:if>
        <li class="header_li"><a class="logoa"  href="<%=path%>/HandleGetAll?type=video1">所有课程</a></li>
        <li class="header_li"><a class="logoa"  href="#course">推荐课程</a></li>
        <li class="header_li"><a class="logoa"  href="#foot">联系我们</a></li>
      </ul>
    </div>
  </div>
</div>

<footer class="slideshow">
  <ul>
    <li><a href="<%=path%>/HandlePlay?vid=1"><img style="height: 100%; width: 100%" src="<%=path%>/page/static/images/videos/在线学习平台1.webp" alt=""></a></li>
    <li><a href="<%=path%>/HandlePlay?vid=2"><img style="height: 100%; width: 100%" src="<%=path%>/page/static/images/videos/在线学习平台2.webp" alt=""></a></li>
    <li><a href="#"><img style="height: 100%; width: 100%" src="<%=path%>/page/static/images/videos/在线学习平台3.webp" alt=""></a></li>
  </ul>
</footer>
<div class="center">
  <div class="center_all">

    <div class="center_video">
    <video src="<%=path%>/page/static/images/videos/gaodeng.mp4" width="650" height="430" controls="controls"></video>
    </div>
    <div class="center_right" style="background:url(/page/static/images/videos/jisuanji.webp);">
      <div class="center_right_dh" id="rightdh" onmouseover="centerdhdiv()" onmouseout="centerdhdivout()">
        <div id="righttit">
          <h1 style="font-family:'微软雅黑'; font-weight:500;">c语言基础</h1>
          <h2>练习攻略</h2>
          <div class="center_right_dh_but"><a href="<%=path%>/HandlePlay?vid=20">立即查看</a></div>
        </div>

        <div id="dhrighttit" class="center_right_dh_two" style="display:none">
          <h2 style="font-family:'微软雅黑'; font-weight:100; margin-left:-160px;" >C语言基础课程</h2>
          <h3>练习攻略</h3>
          <p>C语言的基础阶段课程将从熟悉语法，初识C语言，打牢计算机知识基础，以便于后续的学习......</p>
          <div class="center_right_dh_two_but"><a href="<%=path%>/HandlePlay?vid=7">立即查看</a></div>
        </div>
      </div>
    </div><br />
    <div class="center_left_bom">
      <div class="center_left_bom_div" id="bomdiv"  onmouseover="bomdivOver()" >
        <h2 style="font-weight:500;
		color:#444;">所有课程</h2>
        <div class="center_left_bom_div_but"><a href="<%=path%>/HandleGetAll?type=video1">立即查看</a></div><%--跳转到视频列表页--%>
<%--        --%>
      </div>
      <div class="center_left_bom_show" style="" id="bomshowimg">

      </div>
    </div>
    <a href="#">
      <div class="center_cen_bom" style="margin:420px 0px 0px 360px;">
        <div class="cen_bom_div">
          <h1  font-family:'微软雅黑';letter-spacing:4px; font-size:31px;" >平台特色</h1>
          <p class="pone">给你最优质的环境：<br />专业负责的师资团队</p>
          <p class="ptwo">随时随地在线学习，展现你的计算机天赋</p>
        </div>
      </div></a>
    <a href="#course">
      <div class="center_cen_right_one" id="ccro" style="background-image: url('page/static/images/videos/jisuanji6.webp'); background-size: cover;">
        <div class="center_cen_right_one_div" id="ccros">
          <h1 style="font-weight:100; margin-left:20px; margin-top:0px; font-family:'微软雅黑'; letter-spacing:4px; font-size:31px;">推荐课程</h1>
        </div>
      </div>
    </a>

    <div class="center_cen_right_two" style="background-image: url('page/static/images/videos/jisuanji1.webp'); background-size: cover;">
      <div class="crt">
        <h1 style="font-size:40px; margin-top:5px; font-weight:100;">联系我们</h1>
        <p style="margin-top:20px;">联系电话：13398522912</p>
        <div class="crt_div"><a href="#foot">立即查看</a></div>
      </div>
    </div>
  </div>
</div>

<a name="course"></a>
<div class="center_read">
  <div class="titles">
    <div class="left_img"></div>
    <div class="center_title" >推荐课程</div>
    <div class="right_img"></div>
  </div>
  <div class="read_all">
    <center>
    <div class="read_one" >

      <div class="readone-image-container"> <a href="<%=path%>/HandlePlay?vid=7"> <img src="page/static/images/bianyiyuanli.jpg" class="news-image"></a></div><%--课程封面--%>
      <div class="read_div" >
        <p class="read-summary">编译原理（Compiler Design）是计算机科学中的一门重要学科，研究如何将高级编程语言（如 C、Java、Python 等）翻译成计算机能够理解和执行的低级语言（通常是机器语言或汇编语言）的过程。<%--添加课程介绍--%></p>
      </div>

    </div>
    <div class="read_two" >
      <div class="readone-image-container"><a href="<%=path%>/HandlePlay?vid=8"><img src="page/static/images/gailvlun.jpg" class="news-image"></a></div>
      <div class="read_div" >
        <p class="read-summary">概率论研究随机现象的规律性，分析事件发生的可能性及其统计特性。</p>
      </div>
    </div>
    <div class="read_three" >
      <div class="readone-image-container"><a href="<%=path%>/HandlePlay?vid=9"><img src="page/static/images/linux.webp" class="news-image"></a></div>
      <div class="read_div">
        <p class="read-summary">Linux是一个开源、类Unix操作系统，广泛应用于服务器、嵌入式系统等，支持多用户、多任务、可定制。</p>
      </div>
    </div>
    <div class="read_four" >
      <div class="readone-image-container"><a href="<%=path%>/HandlePlay?vid=10"><img src="page/static/images/python.png" class="news-image"></a></div>
      <div class="read_div">
        <p class="read-summary">Python是一种高级编程语言，简洁易读，支持多种编程范式，广泛应用于数据分析、机器学习、Web开发等领域。</p>
      </div>
    </div>
    <div class="read_five" >
      <div class="readone-image-container"><a href="<%=path%>/HandlePlay?vid=11"><img src="page/static/images/springboot.webp" class="news-image"></a></div>
      <div class="read_div">
        <p class="read-summary">Spring Boot是一个基于Spring框架的开源Java框架，简化开发流程，提供快速构建、自动配置和内嵌服务器支持。</p>
      </div>
    </div>
    <div class="read_six" >
      <div class="readone-image-container"><a href="<%=path%>/HandlePlay?vid=12"><img src="page/static/images/xianxingdaishu.jpg" class="news-image"></a> </div>
      <div class="read_div">
        <p class="read-summary">线性代数研究向量、矩阵及其运算，广泛应用于计算机科学、物理学、工程学和经济学等领域。</p>
      </div>
    </div>
      </center>
  </div>
</div>
<!--底部-->
<a name="foot"></a>
<div class="foot">
  <div class="foot_all" >
    <div class="foot_right">
      <p style=" color:#fff; font-size:14px;">联系我们</p>
      <p style=" color:#fff; font-size:29px;"><img src="page/static/images/call.png" style=" margin-bottom:-3px; margin-right:10px;"  />13398522912</p>
      <p style=" color:#9A9EA7; font-size:14px;">邮箱：sdc.lzqian@gzu.edu.cn</p>
      <p style=" color:#9A9EA7; font-size:14px; margin-top:-6px;">联系电话：13398522912</p>
    </div>
  </div>
</div>
<script type="text/javascript">
  window.addEventListener("load", function () {//轮播
    var a = document.querySelector(".slideshow ul");
    // a.style.left="-1400px"
    // console.dir(a.children[0])
    console.log(a.children.length);
    var num = 0;
    var len = a.children[0].clientWidth;
    console.log(a.children[0].clientWidth);
    setInterval(function(){
      if(num===a.children.length){
        a.style.left="0px";
        a.style.transition="left 0s";
        num = 1;
      }else{
        a.style.left=-len*num+"px";
        a.style.transition="left 1s";
        num++;
      }
    },1500);
  })
</script>
</body>
</html>

