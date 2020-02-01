<%@ page import="java.util.Map" %>
<%@ page import="org.w3c.dom.css.CSSStyleRule" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/22
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link  href="./resource/css/bootstrap.min.css" rel="stylesheet">
    <link  href="./resource/css/creative.css" rel="stylesheet">
    <link href="./resource/css/font-awesome.min.css" rel="stylesheet">
    <style>
      body{
        height: 100%;
      }
      .container{
        height: 100%;
      }
      .calculator{
        overflow: auto;
      }
      #flag{
        display: none;
        background-color: #03A9F4;
      }
    </style>
  </head>
  <body>
      <form id='sub-form' action="GetInput" method="post">
        <input id='feval' type="hidden" name="eval" value="">
        <input id='ftype' type="hidden" name="type" value="">
      </form>
    <div class="container">
      <div class="col-md-6  calculator" align="center">
        <div class="row displayBox2" id="flag" >
        <div class="displayText" id="display2" contenteditable="true" nowrap>0</div>
        </div>
        <div class="row displayBox">
          <div class="displayText"  id="display" contenteditable="true" nowrap >0</div>
        </div>


        <div class="row numberPad">
          <div class="col-md-9">
            <div class="row">
              <button class="btn clear hvr-back-pulse" id="clear">C</button>
              <button class="btn btn-calc hvr-radial-out" id="sqrt">√</button>
              <button class="btn btn-calc hvr-radial-out hvr-radial-out" id="square">x<sup>2</sup></button>
              <button class="btn btn-calc hvr-radial-out hvr-radial-out" id="backspace"><i class="fa fa-chevron-left" aria-hidden="true"></i></button>
            </div>
            <div class="row">
              <button class="btn btn-calc hvr-radial-out" id="seven">7</button>
              <button class="btn btn-calc hvr-radial-out" id="eight">8</button>
              <button class="btn btn-calc hvr-radial-out" id="nine">9</button>
              <button class="btn btn-calc hvr-radial-out hvr-radial-out" id="left-b">(</button>
            </div>
            <div class="row">
              <button class="btn btn-calc hvr-radial-out" id="four">4</button>
              <button class="btn btn-calc hvr-radial-out" id="five">5</button>
              <button class="btn btn-calc hvr-radial-out" id="six">6</button>
              <button class="btn btn-calc hvr-radial-out hvr-radial-out" id="right-b">)</button>
            </div>
            <div class="row">
              <button class="btn btn-calc hvr-radial-out" id="one">1</button>
              <button class="btn btn-calc hvr-radial-out" id="two">2</button>
              <button class="btn btn-calc hvr-radial-out" id="three">3</button>
              <button class="btn btn-calc hvr-radial-out hvr-radial-out" id="abs">|</button>
            </div>
            <div class="row">
              <button class="btn btn-calc hvr-radial-out" id="plus_minus">&#177;</button>
              <button class="btn btn-calc hvr-radial-out" id="zero">0</button>
              <button class="btn btn-calc hvr-radial-out" id="decimal">.</button>
              <button class="btn btn-calc hvr-radial-out hvr-radial-out" id="assume" data-toggle="modal" data-target="#myModal"><i class="fa fa-cog fa-spin" aria-hidden="true"></i></button>
            </div>
          </div>
          <div class="col-md-3 operationSide">
            <button id="divide" class="btn btn-operation hvr-fade">÷</button>
            <button id="multiply" class="btn btn-operation hvr-fade">×</button>
            <button id="subtract" class="btn btn-operation hvr-fade">−</button>
            <button id="add" class="btn btn-operation hvr-fade">+</button>
            <button id="equals" class="btn btn-operation equals hvr-back-pulse"><i class="fa fa-chevron-right" aria-hidden="true"></i></button>
          </div>
        </div>
      </div>
      <div class="col-md-6  calculator" align="center" style="height:100%;">
        <div class="row numberPad" style="height:100%;">
          <%
            Map<String,String> map = (Map<String,String>)session.getAttribute("result");
            if (map != null){
              for (String id: map.keySet()) {
          %>
                <h2 class="bg-success"><%=id%></h2><br>
                <h2 class="bg-warning"><%=map.get(id)%></h2><br>
          <%
              }
            }
          %>
          <a href="Clear">Clear</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="History">计算历史</a>
        </div>


      </div>
    </div>
    <script src="./resource/js/jquery.min.js"></script>
    <script src="./resource/js/bootstrap.min.js"></script>
    <script src="./resource/js/calculate.js"></script>
  </body>
</html>
