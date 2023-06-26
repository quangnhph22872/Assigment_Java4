<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 04/04/2023
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <center>
            <h1>Login</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<form method="post" action="/ASM_war_exploded/login">
<div class="container">
    <div class="row">
        <div class="col">
        </div>
        <div class="col-6">
            <div class="alert alert-danger">${ errorMessage }</div>
            <div class="mt-3">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" />
            </div>
            <div class="mt-3">
                <label>Mật khẩu</label>
                <input type="password" name="matKhau" class="form-control" />
            </div>
            <div class="mt-3">
                <button class="btn btn-primary">Đăng nhập</button>
            </div>
        </div>
        <div class="col">
        </div>
    </div>

</div>
</form>
