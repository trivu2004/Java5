<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="/css/cart.css">
<jsp:include page="header.jsp"/>
<h1 class="text-danger text-center">Giỏ Hàng</h1>
<div class="container">
    <table class="table mx-1">
        <thead class="text-center text-light fs-4 bg-warning">
        <th scope="col" class="text-center">Mã Sản Phẩm</th>
        <th scope="col" class="text-center">Tên Sản Phẩm</th>
        <th scope="col" class="text-center">Sản phẩm</th>
        <th scope="col">Giá</th>
        <th scope="col">Số lượng</th>
        <th scope="col">Thành tiền</th>
        <th scope="col">Xoá</th>
        </thead>
        <tbody class="text-center">
        <c:forEach items="${cart}" var="c">
        <tr>
            <td class="text-center">${c.product.id}</td>
            <td class="text-center">${c.product.name}</td>
            <td class="d-flex justify-content-center align-items-center">
                <img src="/img/${c.product.image}" style="width: 100px; height: auto;" class="img-fluid" alt="...">
            </td>
            <td class="text-center">${c.product.price}</td>
            <td class="w-25 text-center">
                <form id="formsoluong" action="/cart/update">
                    <input type="hidden" name="id" value="${c.product.id}">
                    <input class="w-50" name="qty" id="${c.product.id}" value="${c.qty != null ? c.qty: 1}"
                           onlick="document.getElementById('formsoluong').submit();" type="number"
                           min="1" max="99"/>
                </form>
            </td>
            <td class="text-center">${c.qty * c.product.price}</td>
            <td class="text-center"><a href="/cart/delete/${c.product.id}" class="text-danger"><i
                    class="bi bi-trash"></i></a>
            </td>
        </tr>
        </tbody>
        </c:forEach>
    </table>

    <%--    <a href="/cart/clear">--%>
    <%--        <button type="button" class="float-end btn btn-danger">Clear</button>--%>
    <%--    </a>--%>
    <p class="text-right color-changing-text fs-3">Tổng Tiền: <span class="fs-3 text-danger">${tongtien} VNĐ</span></p>


    <%--    <p class="text-right color-changing-text fs-3">Giỏ Hàng Trống</p>--%>

</div>

<div class="d-flex justify-content-center">
    <a href="/mail">
        <button class="btn btn-warning fs-3 text-white ">Đặt hàng</button>
    </a>
</div>

<div class="box-why mt-3">
    <div class="why-item text-center  bg-secondary-subtle">
        <h2 class="color-changing-text">Đánh giá chất lượng giúp chúng tôi!</h2>
        <img src="/img/5.jpg" alt="">
    </div>
</div>
<jsp:include page="footer.jsp"/>