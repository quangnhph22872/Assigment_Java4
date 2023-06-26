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
            <h1>Cập Nhật Chi Tiết SP</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="col-8 offset-2">
    <form method="POST"
          action="/ASM_war_exploded/chi-tiet-san-pham/update?ma=${kh.id}">
        <div class="row mt-3">
            <div class="col-6">
                <label>Id</label>
                <input type="text" name="id" class="form-control" value="${ kh.id }" disabled/>
            </div>
            <div class="col-6">
                <label>Sản phẩm</label>
                <select name="idSP" class="form-select">
                    <c:forEach items="${ dssp }" var="sp2">
                        <option value="${sp2.id}" ${sp2.id == kh.sp.id ? "selected" :"" }>${sp2.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Nhà sản xuất</label>
                <select name="idNsx" class="form-select">
                    <c:forEach items="${ dsnxs }" var="nxs2">
                        <option value="${nxs2.id}" ${nxs2.id == kh.nsx.id ? "selected" :"" }>${nxs2.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Màu sắc</label>
                <select name="idMauSac" class="form-select">
                    <c:forEach items="${ dsms }" var="ms2">
                        <option value="${ms2.id}" ${ms2.id == kh.ms.id ? "selected" :"" }>${ms2.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Dòng sản phẩm</label>
                <select name="idDongSP" class="form-select">
                    <c:forEach items="${ dsdsp }" var="dsp2">
                        <option value="${dsp2.id}" ${dsp2.id == kh.dsp.id ? "selected" :"" }>${dsp2.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Năm bảo hành</label>
                <input type="text" name="namBH" value="${ kh.namBH }" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mô tả</label>
                <input type="text" name="moTa" value="${ kh.moTa }" class="form-control" />
            </div>
            <div class="col-6">
                <label>Số lượng tồn</label>
                <input type="text" name="soLuongTon" value="${ kh.soLuongTon }" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giá nhập</label>
                <input type="number" name="giaNhap" value="${ kh.giaNhap }" class="form-control" />
            </div>
            <div class="col-6">
                <label>Giá bán</label>
                <input type="number" name="giaBan" value="${ kh.giaBan }" class="form-control" />
            </div>
        </div>
        <br>
        <button class="btn btn-primary">Cập Nhật</button>

    </form>
</div>
<script src="/ASM_war_exploded/js/bootstrap.min.js"></script>
