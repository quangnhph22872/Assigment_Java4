<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 15/03/2023
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assignments</title>
    <link rel="stylesheet"
          href="/ASM_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <center>
            <h1>Sản Phẩm</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="col-8 offset-2">
    <form method="POST"
          action="/ASM_war_exploded/san-pham/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" />
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" />
            </div>
        </div>
        <div class="alert text-center">${ errorMessage6 }</div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
<script src="/ASM_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
