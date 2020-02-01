<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/24
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link  href="./css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="SearchStudentServlet">



     <div class="row col-lg-10" >
        <table border="1" width="700" class="table table-striped table-bordered .table-condensed">
            <tr >
                <td colspan="8">
                    <div class="row form-inline">
                        <div class="col-xs-2 input-group" >
                            <span class="input-group-addon" id="basic-addon1">按姓名查询</span>
                            <input type="text" class="form-control"  placeholder="Username" name="name">
                        </div>
                        &nbsp;&nbsp;&nbsp;&nbsp;

                        <div class="col-xs-2 input-group" >
                            <span class="input-group-addon" id="basic-addon1">gender</span>
                            <select name="gender" class="form-control" p>
                            <option value="">请选择
                            <option value="男" >男
                            <option value="女" >女
                           </select>
                        </div>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="submit" value="查询" class="btn-default">查询</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="add.jsp">添加</a>
                    </div>
                </td>

            </tr >
            <tr align="center">
                <td>编号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>电话</td>
                <td>生日</td>
                <td>爱好</td>
                <td>简介</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${pageStudent.list}" var="stu">
            <tr align="center">
                <td>${stu.id}</td>
                <td>${stu.name}</td>
                <td>${stu.gender}</td>
                <td>${stu.phone}</td>
                <td>${stu.birthday}</td>
                <td>${stu.hobby}</td>
                <td>${stu.info}</td>
                <td><a href="Edit?id=${stu.id}">更新</a>  <a href="#" onclick="delet(${stu.id})">删除</a></td>
            </tr>
            </c:forEach>
            <tr>
                <td colspan="8">
                    第${pageStudent.currentPage}/${pageStudent.totalPage}
                    &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    每页显示${pageStudent.pageSize}条
                    &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    总记录数${pageStudent.totalSize}
                    &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    <c:if test="${pageStudent.currentPage != 1}"><a href="StudentlistPage?currentPage=1">首页</a> |
                        <a href="StudentlistPage?currentPage=${pageStudent.currentPage-1}">上一页</a>
                    </c:if>
                    <c:forEach begin="1" end="${pageStudent.totalPage}" var="count">
                        <c:if test="${pageStudent.currentPage == count}">
                            ${count}
                        </c:if>
                        <c:if test="${pageStudent.currentPage != count}">
                            <a href="StudentlistPage?currentPage=${count}">${count}</a>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pageStudent.currentPage != pageStudent.totalPage}">
                        <a href="StudentlistPage?currentPage=${pageStudent.currentPage+1}">下一页</a> |
                       <a href="StudentlistPage?currentPage=${pageStudent.totalPage}">尾页</a>
                    </c:if>

                </td>


            </tr>
        </table>
     </div>
</form>
<script>
    function delet(id) {
        var flag = confirm("是否确定删除");
        if (flag){
            window.location.href = "Delete?id="+id;
        }
        
    }
</script>
</body>
</html>
