<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 21/03/2023
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assignments</title>
    <link rel="stylesheet" href="/ASM_war_exploded/css/bootstrap.min.css" />
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
        <div class="container-fluid">
            <a class="navbar-brand" href="/ASM_war_exploded/khach-hang/index">Khách Hàng</a>
        </div>
        <div class="container-fluid">
            <a class="navbar-brand" href="/ASM_war_exploded/cua-hang/index">Cửa Hàng</a>
        </div>
        <div class="container-fluid">
            <a class="navbar-brand" href="/ASM_war_exploded/chuc-vu/index">Chức Vụ</a>
        </div>
        <div class="container-fluid">
            <a class="navbar-brand" href="/ASM_war_exploded/san-pham/index">Sản Phẩm</a>
        </div>
        <div class="container-fluid">
            <a class="navbar-brand" href="/ASM_war_exploded/mau-sac/index">Màu Sắc</a>
        </div>
        <div class="container-fluid">
            <a class="navbar-brand" href="/ASM_war_exploded/dong-san-pham/index">Dòng Sản Phẩm</a>
        </div>
        <div class="container-fluid">
            <a class="navbar-brand" href="/ASM_war_exploded/nha-san-xuat/index">Nhà Sản Xuất</a>
        </div>
        <div class="container-fluid">
            <a class="navbar-brand" href="/ASM_war_exploded/chi-tiet-san-pham/index">Chi Tiết SP</a>
        </div>
        <div class="container-fluid">
            <a class="navbar-brand" href="/ASM_war_exploded/nhan-vien/index">Nhân Viên</a>
        </div>
    </nav>

    <div class="row mt-10" style="min-height: 600px;">
        <div class="col-12">
            <jsp:include page="${ view }" />
        </div>
    </div>

    <footer class="container-fluid text-bg-secondary text-center">
        <p>Nguyễn Hữu Quang</p>
        <a style="color: white"  href="https://www.facebook.com/nguyenhuuquang23"><i class="fa fa-facebook-square"></i></a></i>
        <a style="color: white" href="https://www.instagram.com/gnaw_23/"><i class="fa fa-instagram"></i></a></i>
    </footer>
    <script src="/ASM_war_exploded/js/bootstrap.min.js"></script>

</body>
</html>
