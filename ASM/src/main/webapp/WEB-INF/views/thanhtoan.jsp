<%--
  Created by IntelliJ IDEA.
  User: kahuk
  Date: 6/3/2024
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="card shadow position-relative mt-3">
    <form id="bookingForm">
        <div class="mb-3">
            <label for="name" class="form-label mt-4">Họ và tên</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Số điện thoại</label>
            <input type="tel" class="form-control" id="phone" name="phone" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Số lượng muốn đặt</label>
            <input type="number">
        </div>
        <div class="mb-3">
            <label for="message" class="form-label">Lời nhắn</label>
            <textarea class="form-control" id="message" name="message" rows="4"></textarea>
        </div>
        <div class="text-center mt-3">
            <button class="btn btn-warning  text-white">Đặt Hàng</button>
        </div>
    </form>
</div>
</body>
</html>
