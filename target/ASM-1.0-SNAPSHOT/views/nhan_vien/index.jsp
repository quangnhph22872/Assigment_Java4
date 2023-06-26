<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23/03/2023
  Time: 01:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>Nhân Viên</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="col-12 mt-5">
    <div class="row">
        <div class="col-6">
            <a href="/ASM_war_exploded/nhan-vien/create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <c:if test="${ f:length(DSNhanVien) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(DSNhanVien) != 0 }">
        <table class="table table-striped mt-3">
            <thead class="table-dark">
            <tr>
                <th>Mã</th>
                <th>Họ tên</th>
                <th>Giới tính</th>
                <th>Ngày sinh</th>
                <th>Địa chỉ</th>
                <th>SDT</th>
                <th>Mật khẩu</th>
                <th>Cửa hàng</th>
                <th>Chức vụ</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${ DSNhanVien }" var="nv">
                <tr>
                    <td>${ nv.ma }</td>
                    <td>${ nv.ho } ${ nv.tenDem } ${ nv.ten }</td>
                    <td>${ nv.gioiTinh }</td>
                    <td>${ nv.ngaySinh }</td>
                    <td>${ nv.diaChi }</td>
                    <td>${ nv.sdt }</td>
                    <td>${ nv.matKhau }</td>
                    <td>${ nv.cuaHang.ten }</td>
                    <td>${ nv.cv.ten }</td>
                    <td>
                        <a class="btn btn-secondary"
                           href="/ASM_war_exploded/nhan-vien/edit?ma=${ nv.ma }">Cập nhật</a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/ASM_war_exploded/nhan-vien/delete?ma=${ nv.ma }">Xóa</a>
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
