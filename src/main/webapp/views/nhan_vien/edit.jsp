<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23/03/2023
  Time: 01:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <center>
            <h1>Cập Nhật Nhân Viên</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form method="POST" action="/ASM_war_exploded/nhan-vien/update?ma=${nv.ma}">
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Mã</label>
                        <input type="text" class="form-control" name="ma" value="${ nv.ma }" disabled>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Họ</label>
                        <input type="text" class="form-control" name="ho" value="${ nv.ho }">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Tên Đệm</label>
                        <input type="text" class="form-control" name="tenDem" value="${ nv.tenDem }">
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Tên</label>
                        <input type="text" class="form-control" name="ten" value="${ nv.ten }">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>Giới Tính </label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gioiTinh"
                               value="Nam"${ nv.gioiTinh == "Nam" ? "checked" : ""  }>
                        <label class="form-check-label" >
                            Nam
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gioiTinh"
                               value="Nữ"${ nv.gioiTinh == "Nữ" ? "checked" : ""  } >
                        <label class="form-check-label" >
                            Nữ
                        </label>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Ngày Sinh</label>
                        <input type="date" class="form-control" name="ngaySinh" value="${ nv.ngaySinh }">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Địa chỉ</label>
                        <input type="text" class="form-control" name="diaChi" value="${ nv.diaChi }">
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Số điện thoại</label>
                        <input type="text" class="form-control" name="sdt" value="${ nv.sdt }"
                               id="exampleInputEmail145">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label for="inputPassword" class="form-label">Mật khẩu</label>
                        <input type="password" name="matKhau" value="${ nv.matKhau }" class="form-control" id="inputPassword">
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Cửa hàng</label>
                        <select class="form-select" name="idCH" aria-label="Default select example">
                            <c:forEach items="${ dsch }" var="ch">
                                <option value="${ch.id}" ${ch.id == nv.cuaHang ? "selected" :"" }>${ch.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label class="form-label">Chức Vụ</label>
                        <select class="form-select" name="idCV" aria-label="Default select example">
                            <c:forEach items="${ dscv }" var="cv">
                                <option value="${cv.id}" ${cv.id == nv.cv ? "selected" :"" }>${cv.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-6">
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Cập nhật</button>
        </form>
    </div>
    <script src="/ASM_war_exploded/js/bootstrap.min.js"></script>
    <div class="col-md-2"></div>
</div>
