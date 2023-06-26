<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 19/03/2023
  Time: 00:56
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
            <h1>Cập Nhật Chức Vụ</h1>
        </center>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="col-8 offset-2">
    <form method="POST"
          action="/ASM_war_exploded/chuc-vu/update?ma=${cv.ma}">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ cv.ma }" disabled />
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${ cv.ten }" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Cập Nhật</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
<script src="/ASM_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
