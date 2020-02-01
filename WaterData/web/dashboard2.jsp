<%--
Created by IntelliJ IDEA.
User: dell
Date: 2019/3/22
Time: 19:38
To change this template use File | Settings | File Templates.
--%>
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

    <link href="assets/plugins/morris-chart/morris.css" rel="stylesheet">
    <link href="assets/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet"/>
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
            <li class="menu-list nav-active"><a href="index.jsp"><i class="icon-home"></i> <span>数据集</span></a>
                <ul class="sub-menu-list">
                    <li  class="active"><a href="DataReceive">原始数据</a></li>
                    <li><a href="WaterDataReceive"> 水印数据</a></li>
                </ul>
            </li>



            <li class="menu-list"><a href="#"><i class="icon-grid"></i> <span>A设备数据处理</span></a>
                <ul class="sub-menu-list">
                    <li><a href="table-responsive.html">数据分析</a></li>
                    <li><a href="addwater.jsp">水印嵌入</a></li>
                </ul>
            </li>



            <li class="menu-list"><a href="#"><i class="icon-lock"></i> <span>B设备数据处理</span></a>
                <ul class="sub-menu-list">
                    <li><a href="waterdata.html"> 数据分析 </a></li>
                    <li><a href="extractwater.jsp"> 水印提取 </a></li>

                </ul>
            </li>

        </ul>
        <!--End sidebar nav-->

    </div>
</div>
<!--End left side menu-->

    
    <!-- main content start-->
    <div class="main-content" >

        <!-- header section start-->
        <div class="header-section">

            <a class="toggle-btn"><i class="fa fa-bars"></i></a>

            <form class="searchform">
                <input type="text" class="form-control" name="keyword" placeholder="Search here..." />
            </form>



            <!--notification menu start -->

            <!--notification menu end -->



        </div>
        <!-- header section end-->


        <!--body wrapper start-->
        <div class="wrapper">

            <!--Start Page Title-->
            <div class="page-title-box">
                <h4 class="page-title">数据集</h4>
                <ol class="breadcrumb">
                    <li class="active">
                        原始数据
                    </li>

                    <li >
                        <a href="#">水印数据 </a>
                    </li>
                </ol>
                <div class="clearfix"></div>
            </div>
            <!--End Page Title-->

            <!--Start row-->
            <div class="row">
                <div class="container">
                    <div class="analytics-box">

                    </div>
                </div>
            </div>


            <!--End row-->

            <!--Start row-->

            <!--Start info box-->

            <!--End info box-->

            <!--Start info box-->

            <!--End info box-->

            <!--Start info box-->

            <!--End info box-->

            <!--Start info box-->

            <!--End info box-->


            <!--End row-->



            <!--Start row-->
            <div class="col-md-6">
                <div class="white-box">
                    <h2 class="header-title"> 身高数据 </h2>
                    <div class="table-wrap">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>平均身高</th>
                                <th>均方差</th>
                                <th>标准占比</th>
                            </tr>
                            </thead>
                            <tbody>

                            <tr>
                                <td>${info3.averge}</td>
                                <td>${info3.variance}</td>
                                <td>${info3.rate}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- End  Striped Table-->


            <div class="col-md-6">
                <div class="white-box">
                    <h2 class="header-title">体重数据</h2>
                    <div class="table-wrap">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>平均体重</th>
                                <th>均方差</th>
                                <th>标准占比</th>
                            </tr>
                            </thead>
                            <tbody>

                            <tr>
                                <td>${info4.averge}</td>
                                <td>${info4.variance}</td>
                                <td>${info4.rate}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- End  Striped Table-->

            <!--End row-->


            <!--Start row-->


            <!-- Start inbox widget-->

            <!-- End inbox widget-->

            <!--Start chat widget-->

            <!--End chat widget-->

            <!-- Start timeline-->

            <!-- End timeline-->

            <!--Start row-->
            <div class="row">
                <div class="col-md-12">
                    <div class="white-box">
                        <h2 class="header-title">数据集分组</h2>
                        <table id="example2" class="display table">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>身高</th>
                                <th>体重</th>
                                <th>年龄</th>
                                <th>数据类型</th>
                                <th>修改日期</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>编号</th>
                                <th>身高</th>
                                <th>体重</th>
                                <th>年龄</th>
                                <th>数据类型</th>
                                <th>修改日期</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${list2}" var="info">
                                <tr>
                                    <td>${info.id}</td>
                                    <td>${info.height}</td>
                                    <td>${info.weight}</td>
                                    <td>18</td>
                                    <td>水印数据</td>
                                    <td>${info.date}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!--End row-->

        </div>
        <!-- End Wrapper-->


        <!--Start  Footer -->
        <footer class="footer-main">let it go 邓玉文 胡世豪 陈艳瑜<a target="_blank" href="http://sc.chinaz.com/moban/"></a></footer>
        <!--End footer -->

    </div>
    


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
