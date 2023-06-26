<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 15/03/2023
  Time: 19:46
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
<body>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <center>
            <h1>Cửa Hàng</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="col-12 mt-5">
    <div class="row">
        <div class="col-6">
            <a href="create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <c:if test="${ f:length(danhSachCH) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(danhSachCH) != 0 }">
        <table class="table table-hover mt-3">
            <thead class="table-dark">
            <tr>
                <th>Id</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Địa Chỉ</th>
                <th>Thành Phố</th>
                <th>Quốc Gia</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${ danhSachCH }" var="ch">
                <tr>
                    <td>${ ch.id }</td>
                    <td>${ ch.ma }</td>
                    <td>${ ch.ten }</td>
                    <td>${ ch.diaChi }</td>
                    <td>${ ch.thanhPho }</td>
                    <td>${ ch.quocGia }</td>
                    <td>
                        <a class="btn btn-secondary"
                           href="/ASM_war_exploded/cua-hang/edit?ma=${ ch.ma }">Cập nhật</a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/ASM_war_exploded/cua-hang/delete?ma=${ ch.ma }">Xóa</a>
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
