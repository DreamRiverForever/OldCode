<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="keywords" content="">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="assets/images/favicon.png" type="image/png">
  <title></title>
   <link href="assets/css/icons.css" rel="stylesheet">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/responsive.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
          <script src="js/html5shiv.min.js"></script>
          <script src="js/respond.min.js"></script>
    <![endif]-->

</head>

<body class="sticky-header">
<!--Start left side Menu-->
<div class="left-side sticky-left-side">

    <!--logo-->
    <div class="logo">
        <a href="index.jsp"><img src="assets/images/logo.png" alt=""></a>
    </div>

    <div class="logo-icon text-center">
        <a href="index.jsp"><img src="assets/images/logo-icon.png" alt=""></a>
    </div>
    <!--logo-->

    <div class="left-side-inner">
        <!--Sidebar nav-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li class="menu-list"><a href="index.jsp"><i class="icon-home"></i> <span>数据集</span></a>
                <ul class="sub-menu-list">
                    <li><a href="DataReceive"> 原始数据</a></li>
                    <li><a href="WaterDataReceive"> 水印数据</a></li>
                </ul>
            </li>



            <li class="menu-list"><a href="#"><i class="icon-grid"></i> <span>A设备数据处理</span></a>
                <ul class="sub-menu-list">
                    <li><a href="table-responsive.html">数据分析</a></li>
                    <li><a href="addwater.jsp">水印嵌入</a></li>
                </ul>
            </li>



            <li class="menu-list nav-active"><a href="#"><i class="icon-lock"></i> <span>B设备数据处理</span></a>
                <ul class="sub-menu-list">
                    <li><a href="waterdata.html"> 数据分析 </a></li>
                    <li class="active"><a href="extractwater.jsp"> 水印提取 </a></li>

                </ul>
            </li>

        </ul>
        <!--End sidebar nav-->

    </div>
</div>
<!--End left side menu-->

<div class="main-content" >

    <!-- header section start-->
    <div class="header-section">

        <a class="toggle-btn"><i class="fa fa-bars"></i></a>

        <form class="searchform">
            <input type="text" class="form-control" name="keyword" placeholder="Search here..." />
        </form>
    </div>
    <!-- header section end-->



    <!--body wrapper start-->
    <div class="wrapper" style="height: 15px;">

        <!--Start Page Title-->
        <div class="page-title-box">
            <h4 class="page-title">数据处理</h4>
            <ol class="breadcrumb">
                <li>
                    数据分析
                </li>
                <li class="active">
                    <a href="#"> 水印提取</a>
                </li>
            </ol>
            <div class="clearfix"></div>
        </div>
        <!--End Page Title-->




        <div class="col-md-1">
        </div>
        <div class="col-md-5">
            <div class="white-box">
                <h2 class="header-title">水印提取</h2>
                <form action="ExtractWaterServlet" method="get">
                    <div class="form-group">
                        <label>水印信息</label>
                        <input class="form-control"  placeholder="Enter data" name="len">
                    </div>
                    <div class="form-group">
                        <label>秘钥</label>
                        <input class="form-control" placeholder="Password" name="password">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
        <div class="col-md-5">
            <div class="panel panel-default" style="height: 270px">
                <div class="panel-heading">
                    <h3 class="panel-title">水印信息</h3>
                </div>
                <div class="panel-body">
                    <h4 font style="font-family:楷体">数据拥有者：${username}</h4>
                </div>
            </div>
        </div>
        <div class="col-md-1">
        </div>

    <div class="row">
        <div class="col-md-12" style="height: 200px">
        </div>
    </div>
</div>
    <footer class="footer-main">let it go 邓玉文 胡世豪 陈艳瑜<a target="_blank" href="http://sc.chinaz.com/moban/"></a></footer>
    <!--End footer -->

</div>
  <!--End login Section-->



    <!--Begin core plugin -->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/plugins/moment/moment.js"></script>
    <script  src="assets/js/jquery.slimscroll.js "></script>
    <script src="assets/js/jquery.nicescroll.js"></script>
    <script src="assets/js/functions.js"></script>
    <!-- End core plugin -->

</body>

</html>
