
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<body>
<div class="row">
    <ul class="nav flex-column p-4 mb-2 col-2">
        <li class="nav-item mb-3">
            <a class="nav-link active text-primary fw-bold" aria-current="page" href="/home">
                <i class="bi bi-house-check me-2"></i> Trang Chủ
            </a>
        </li>

        <li class="nav-item mb-3">
            <a class="nav-link active text-primary fw-bold" href="/manager_user">
                <i class="bi bi-person me-2"></i> Quản Lí Người Dùng
            </a>
        </li>

        <li class="nav-item mb-3">
            <a class="nav-link active text-primary fw-bold" href="/manager_category">
                <i class="bi bi-list me-2"></i> Quản Lí Danh Mục
            </a>
        </li>

        <li class="nav-item mb-3">
            <a class="nav-link active text-primary fw-bold" href="/manager_author">
                <i class="bi bi-person-workspace me-2"></i> Quản Lí Tác Giả
            </a>
        </li>

        <li class="nav-item mb-3">
            <a class="nav-link active text-primary fw-bold" href="/manager_product">
                <i class="bi bi-box me-2"></i> Quản Lí Sản Phẩm
            </a>
        </li>
        <li class="nav-item mb-3">
            <a class="nav-link active text-primary fw-bold" href="/manager_discount">
                <i class="bi bi-tag me-2"></i> Mã Giảm Giá
            </a>
        </li>

        <li class="nav-item mb-3">
            <a class="nav-link active text-primary fw-bold" href="/manager_order">
                <i class="bi bi-receipt me-2"></i> Đơn Hàng
            </a>
        </li>
        <li class="nav-item mb-3">
            <a class="nav-link active text-primary fw-bold" href="/manager_statistic">
                <i class="bi bi-bar-chart me-2"></i> Thống Kê
            </a>
        </li>
        </li>
    </ul>
    <div class="col-10">
        <jsp:include page="${adminPage}" />
    </div>
</div>
<script src="https://kit.fontawesome.com/1a00e887fc.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>
