<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<c:set var="localeCookie" value="${cookie['locale'].value}" />
<fmt:setLocale value="${localeCookie}" />
<fmt:setBundle basename="messages"/>
<header>
    <jsp:include page="header.jsp"/>
</header>
<div class="container mt-3">
    <div id="carouselExampleControlsNoTouching" class="carousel slide" data-bs-touch="false">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="/img/a.jpg" class="d-block w-100 img-fluid object-fit-cover" alt="...">
            </div>
            <div class="carousel-item">
                <img src="/img/b.jpg" class="d-block w-100 img-fluid object-fit-cover" alt="...">
            </div>
            <div class="carousel-item">
                <img src="/img/c.jpg" class="d-block w-100 img-fluid object-fit-cover" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControlsNoTouching"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControlsNoTouching"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>
<!-- Product Buttons Section -->
<div class="container mt-3">
    <div class="row">
        <!-- Repeated block for product buttons -->
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-3">
            <button class="btn btn-outline-primary btn-custom">
                <h3>Redmi note 13</h3>
                <span><fmt:message key="gia_sieu_tot"/></span>
            </button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-3">
            <button class="btn btn-outline-primary btn-custom">
                <h3>Redmi note 13</h3>
                <span><fmt:message key="gia_sieu_tot"/></span>
            </button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-3">
            <button class="btn btn-outline-primary btn-custom">
                <h3>Redmi note 13</h3>
                <span><fmt:message key="gia_sieu_tot"/></span>
            </button>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-3">
            <button class="btn btn-outline-primary btn-custom">
                <h3>Redmi note 13</h3>
                <span><fmt:message key="gia_sieu_tot"/></span>
            </button>
        </div>
    </div>
</div>

<!-- Product Images Section -->
<div class="container mt-3">
    <div class="row">
        <!-- Repeated block for product images -->
        <div class="col-12 col-md-6 col-lg-3 mt-3 img-container">
            <a href="#"><img src="/img/sanphamhot-1.png" class="img-fluid" alt="Product Image 1"></a>
        </div>
        <div class="col-12 col-md-6 col-lg-3 mt-3 img-container">
            <a href="#"><img src="/img/sanphamhot-2.png" class="img-fluid" alt="Product Image 2"></a>
        </div>
        <div class="col-12 col-md-6 col-lg-3 mt-3 img-container">
            <a href="#"><img src="/img/sanphamhot-4.png" class="img-fluid" alt="Product Image 3"></a>
        </div>
        <div class="col-12 col-md-6 col-lg-3 mt-3 img-container">
            <a href="#"><img src="/img/sanphamhot3.png" class="img-fluid" alt="Product Image 4"></a>
        </div>
    </div>
</div>

<h1 class="text-center text-danger mt-3"> <fmt:message key="dien_thoai_moi"/></h1>
<div class="container">
    <div class="row">
        <div class="d-flex justify-content-center mt-4">
            <form action="/product/search" method="post" class="d-flex align-items-center gap-2">
                <input type="number" class="form-control" name="min" value="${min}" placeholder="Min Price?" aria-label="Min Price">
                <input type="number" class="form-control" name="max" value="${max}" placeholder="Max Price?" aria-label="Max Price">
                <button type="submit" class="btn btn-danger">Search</button>
            </form>
        </div>
        <div class="col-auto">
            <select id="sort-order" class="form-select" aria-label="Default select example">
                <option selected value="0">Tất cả</option>
                <option value="${min}">Tăng Dần</option>
                <option value="${max}">Giảm Dần</option>
            </select>
        </div>

        <div class="col-auto">
            <select id="brand" class="form-select" aria-label="Default select example">
                <option selected value="0">Tất cả</option>
                <option name="keywords" value="${keywords}">Iphone</option>
                <option name="keywords" value="${keywords}">SamSung</option>
                <option name="keywords" value="${keywords}">Xiaomi</option>
            </select>
        </div>
    </div>
</div>


<%--<article class="container mt-4">--%>
<%--    <div class="row bg-body-secondary">--%>
<%--        <c:forEach items="${search}" var="s">--%>
<%--            <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-3">--%>
<%--                <div class="card bg-secondary-subtle">--%>
<%--                    <img src="/img/${s.image}" class="card-img-top" alt="...">--%>
<%--                    <div class="card-body">--%>
<%--                        <h5 class="card-title text-center">${s.name}</h5>--%>
<%--                        <h5 class="text-center">--%>
<%--                            <fmt:formatNumber value="${s.price}"/> VNĐ--%>
<%--                        </h5>--%>
<%--                        <br>--%>
<%--                        <div class="text-center">--%>
<%--                            <a href="/addcart/${s.id}" class="btn btn-primary">Thêm Vào Giỏ Hàng</a>--%>
<%--                            <a href="/details" class="btn btn-primary mt-2">Xem--%>
<%--                                Chi Tiết</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>
<%--</article>--%>

<article class="container mt-4">
    <div class="row bg-body-secondary">
        <c:forEach items="${products}" var="p">
            <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-3">
                <div class="card bg-secondary-subtle">
                    <img src="/img/${p.image}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title text-center">${p.name}</h5>
                        <h5 class="text-center">
                            <fmt:formatNumber value="${p.price}"/>VNĐ
                        </h5>
                        <br>
                        <div class="text-center">
                            <a href="/addcart/${p.id}" class="btn btn-primary"><fmt:message key="them_vao_gio_hang"/></a>
                            <a href="/details" class="btn btn-primary mt-2"><fmt:message key="xem_chi_tiet"/></a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</article>
<%--<nav aria-label="Page navigation example ">--%>
<%--    <ul class="pagination justify-content-center mt-4">--%>
<%--        <c:if test="${page.number == 0}">--%>
<%--            <li class="page-item disabled">--%>
<%--                <a class="page-link"><i class="bi bi-chevron-double-left"></i></a>--%>
<%--            </li>--%>
<%--            <li class="page-item disabled">--%>
<%--                <a class="page-link"><i class="bi bi-chevron-left"></i></a>--%>
<%--            </li>--%>
<%--        </c:if>--%>
<%--        <c:if test="${page.number != 0}">--%>
<%--            <li class="page-item">--%>
<%--                <a href="/product/page?p=0" class="page-link"><i class="bi bi-chevron-double-left"></i></a>--%>
<%--            </li>--%>
<%--            <li class="page-item">--%>
<%--                <a href="/product/page?p=${page.number-1}" class="page-link"><i class="bi bi-chevron-left"></i></a>--%>
<%--            </li>--%>
<%--        </c:if>--%>
<%--        <c:forEach begin="0" end="${page.totalPages-1}" var="i">--%>
<%--            <li class="page-item ${i == page.number ? 'active' : ''}">--%>
<%--                <a href="/product/page?p=${i}" class="page-link">${i + 1}</a>--%>
<%--            </li>--%>
<%--        </c:forEach>--%>
<%--        <c:if test="${page.number == page.totalPages-1}">--%>
<%--            <li class="page-item disabled mt-2">--%>
<%--                <a class="page-link"><i class="bi bi-chevron-right"></i></a>--%>
<%--            </li>--%>
<%--            <li class="page-item disabled">--%>
<%--                <a class="page-link"><i class="bi bi-chevron-double-right"></i></a>--%>
<%--            </li>--%>
<%--        </c:if>--%>
<%--        <c:if test="${page.number != page.totalPages-1}">--%>
<%--            <li class="page-item">--%>
<%--                <a href="/product/page?p=${page.number+1}" class="page-link"><i class="bi bi-chevron-right"></i></a>--%>
<%--            </li>--%>
<%--            <li class="page-item">--%>
<%--                <a href="/product/page?p=${page.totalPages-1}" class="page-link"><i class="bi bi-chevron-double-right"></i></a>--%>
<%--            </li>--%>
<%--        </c:if>--%>
<%--    </ul>--%>
<%--</nav>--%>
<div class="box-why mt-5">
    <div class="why-item text-center  bg-secondary-subtle">
        <h2 class="color-changing-text">Đánh giá chất lượng giúp chúng tôi!</h2>
        <img src="/img/5.jpg" alt="">
    </div>
</div>


<footer class="mt-3">
    <jsp:include page="footer.jsp"/>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- Include Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<%--<script src="/script/index.js"></script>--%>
<%--<script type="text/javascript">--%>
<%--    function updateQty(id) {--%>
<%--        location.href = "/cart/update?id=" + id + "&qty=" + document.getElementById(id + "input").value;--%>
<%--    }--%>
<%--</script>--%>
<%--<script src="/script/script.js"></script>--%>
</body>
</html>
