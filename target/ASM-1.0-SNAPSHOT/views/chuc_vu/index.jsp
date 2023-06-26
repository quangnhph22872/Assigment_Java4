<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 15/03/2023
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Assignments</title>
    <link rel="stylesheet" href="/ASM_war_exploded/css/bootstrap.min.css" />
</head>
<body><div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <center>
            <h1>Chức Vụ</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="col-12 mt-5">
    <div class="row">
        <div class="col-6">
            <a href="/ASM_war_exploded/chuc-vu/create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <c:if test="${ f:length(danhSachCV) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(danhSachCV) != 0 }">
        <table class="table table-striped mt-3">
            <thead class="table-dark">
            <tr>
                <th>Id</th>
                <th>Mã</th>
                <th>Tên</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${ danhSachCV }" var="cv">
                <tr>
                    <td>${ cv.id }</td>
                    <td>${ cv.ma }</td>
                    <td>${ cv.ten }</td>
                    <td>
                        <a class="btn btn-secondary"
                           href="/ASM_war_exploded/chuc-vu/edit?ma=${ cv.ma }">Cập nhật</a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/ASM_war_exploded/chuc-vu/delete?ma=${ cv.ma }">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

</div>

<script src="/ASM_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
