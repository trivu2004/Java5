<%--
  Created by IntelliJ IDEA.
  User: kahuk
  Date: 6/1/2024
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="/css/details.css">
<link rel="stylesheet" href="/css/header.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<div class="container mt-3">
    <div class="row">
        <div class="col-sm-7 mt-5">
            <img src="/img/${p.image}" class="img-fluid" alt="" width="100%" height="200px">
        </div>
        <div class="col-sm-5 mt-5 ">
            <div class="card shadow position-relative">
                <div class="card-body">
                    <h5 class="card-title color-changing-text1">Tên Sản Phẩm : ${p.name} </h5>
                    <p class="color-changing-text1  m-0"><b>Giá: ${p.price} VNĐ</b></p>
                    <h5>Lựa chọn màu và xem địa chỉ còn hàng</h5>
                    <div class="d-flex justify-content-center">
                        <div class="form-check me-3 border p-3 d-flex align-items-center">
                            <input class="form-check-input me-2" type="radio" name="color" id="radioXanh" value="Xanh" checked>
                            <label class="form-check-label" for="radioXanh">
                                <div data-name="Xanh" class="item">
                                    <span><strong>Xanh</strong></span><br>
                                    <strong>30,990,000 ₫</strong>
                                </div>
                            </label>
                        </div>
                        <div class="form-check me-3 border p-3 d-flex align-items-center">
                            <input class="form-check-input me-2" type="radio" name="color" id="radioKem" value="Kem">
                            <label class="form-check-label" for="radioKem">
                                <div data-name="Đen" class="item">
                                    <span><strong>Kem</strong></span><br>
                                    <strong>30,990,000 ₫</strong>
                                </div>
                            </label>
                        </div>
                        <div class="form-check border p-3 d-flex align-items-center">
                            <input class="form-check-input me-2" type="radio" name="color" id="radioDen" value="Đen">
                            <label class="form-check-label" for="radioDen">
                                <div data-name="Đen" class="item">
                                    <span><strong>Đen</strong></span><br>
                                    <strong>30,990,000 ₫</strong>
                                </div>
                            </label>
                        </div>
                    </div>
                    <br>
                    <div class="d-flex justify-content-center">
                        <button class="btn btn-warning text-white">Thêm vào giỏ hàng</button>
                    </div>
                    <hr>
                    <h5>ƯU ĐÃI THANH TOÁN</h5>
                    <ul>
                        <li>Ưu đãi trả góp 0% qua Shinhan Finance hoặc Mirae Asset Finance</li>
                        <li> Giảm 5% không giới hạn khuyến mãi qua Homepaylater</li>
                        <li> Giảm thêm tới 700.000đ khi thanh toán qua Kredivo.</li>
                        <li> Giảm 50% tối đa 700k khi mở thẻ tín dụng Vpbank trên SenID</li>
                        <li>Giảm 20% tối đa 500k khi mở thẻ tín dụng TPBank EVO</li>
                        <li>Mở thẻ tín dụng VIB - Nhận Voucher 600.000đ</li>
                    </ul>
                    <h5>ƯU ĐÃI ĐI KÈM</h5>
                    <ul>
                        <li> Ưu đãi sốc gói truyền hình K+ chỉ từ 33.000đ/tháng khi mua kèm điện thoại, Máy tính bảng,
                            TV tại CT Mobile
                        </li>
                        <li> Giảm sốc 50% giá SIM card khi mua kèm thiết bị.</li>
                        <li> Giảm thêm tới 1.000.000đ khi tham gia Thu cũ - Lên đời điện thoại Android</li>
                        <li> Giảm tới 200.000đ khi mua kèm Microsoft Office/Microsoft 365.</li>
                    </ul>
                    <p>
                        <i class="fa-regular fa-clock"></i>
                        <br/>
                        <i class="fa-regular fa-calendar"></i>
                    </p>


                </div>
            </div>

        </div>
    </div>
</div>

<footer class="mt-5">
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
