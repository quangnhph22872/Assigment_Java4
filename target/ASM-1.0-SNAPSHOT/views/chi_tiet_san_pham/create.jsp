<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22/03/2023
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <center>
            <h1>Chi Tiết Sản Phẩm</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form  method="POST"
               action="/ASM_war_exploded/chi-tiet-san-pham/store">
            <div class="row mt-3">
                <div class="col-6">
                    <label>Sản phẩm</label>
                    <select name="idSP" class="form-select">
                        <c:forEach items="${ dssp }" var="sp">
                            <option value="${sp.id}">${sp.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-6">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Nhà sản xuất</label>
                    <select name="idNsx" class="form-select">
                        <c:forEach items="${ dsnxs }" var="nxs">
                            <option value="${nxs.id}">${nxs.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-6">
                    <label>idMauSac</label>
                    <select name="Màu sắc" class="form-select">
                        <c:forEach items="${ dsms }" var="ms">
                            <option value="${ms.id}">${ms.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Dòng sản phẩm</label>
                    <select name="idDongSP" class="form-select">
                        <c:forEach items="${ dsdsp }" var="dsp">
                            <option value="${dsp.id}">${dsp.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-6">
                    <label>Năm bảo hành</label>
                    <input type="text" name="namBH" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Mô tả</label>
                    <input type="text" name="moTa" class="form-control" />
                </div>
                <div class="col-6">
                    <label>Số lượng tồn</label>
                    <input type="text" name="soLuongTon" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Giá nhập</label>
                    <input type="number" name="giaNhap" class="form-control" />
                </div>
                <div class="col-6">
                    <label>Giá bán</label>
                    <input type="number" name="giaBan" class="form-control" />
                </div>
            </div>
            <div class="alert text-center">${ errorMessage9 }</div>
            <br>
            <button type="submit" class="btn btn-primary">Thêm Mới</button>
        </form>
    </div>
    <script src="/ASM_war_exploded/js/bootstrap.min.js"></script>
    <div class="col-md-2"></div>
</div>
