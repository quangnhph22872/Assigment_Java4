<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22/03/2023
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <center>
            <h1>Chi Tiết Sản Phẩm</h1>
        </center>
    </div>
    <div class="col-md-4"></div>
</div>
<br>
<div>
    <div class="row">
        <div class="col-6">
            <a href="/ASM_war_exploded/chi-tiet-san-pham/create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <c:if test="${ f:length(DSCTSP) == 0 }">
        <h3 class="alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(DSCTSP) != 0 }">
        <table class="table table-striped mt-3">
            <thead class="table-dark">
            <tr>
                <th>Id</th>
                <th>Sản Phẩm</th>
                <th>Nhà Sản Xuất</th>
                <th>Màu Sắc</th>
                <th>Dòng Sản Phẩm</th>
                <th>Năm Bảo Hành</th>
                <th>Mô Tả</th>
                <th>Số Lượng Tồn</th>
                <th>Giá Nhập</th>
                <th>Giá Bán</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${ DSCTSP }" var="ct">
                <tr>
                    <td>${ ct.id }</td>
                    <td>${ ct.sp.ten }</td>
                    <td>${ ct.nsx.ten }</td>
                    <td>${ ct.ms.ten }</td>
                    <td>${ ct.dsp.ten }</td>
                    <td>${ ct.namBH }</td>
                    <td>${ ct.moTa }</td>
                    <td>${ ct.soLuongTon }</td>
                    <td>${ ct.giaNhap }</td>
                    <td>${ ct.giaBan }</td>
                    <td>
                        <a class="btn btn-secondary"
                           href="/ASM_war_exploded/chi-tiet-san-pham/edit?ma=${ ct.id }">
                            Cập nhật
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/ASM_war_exploded/chi-tiet-san-pham/delete?ma=${ ct.id }">
                            Xóa
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
