<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<body>
<h1 class="text-primary-emphasis text-center mb-5 mt-3">Pagination</h1>
<table class="table table-light table-hover me-auto ms-auto w-50 mt-3 text-center">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Date</th>
    </tr>
    </thead>
    <tbody>
   <div class="d-flex justify-content-center mt-3">
       <form action="/product/search-and-page" method="post">
           <input name="keywords" value="${keywords}">
           <button>Search</button>
       </form>
   </div>
    <c:forEach items="${page.content}" var="p">
        <tr>
            <th scope="row">${p.id}</th>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.createDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <c:if test="${page.number == 0}">
            <li class="page-item disabled">
                <a class="page-link"><i class="bi bi-chevron-double-left"></i></a>
            </li>
            <li class="page-item disabled">
                <a class="page-link"><i class="bi bi-chevron-left"></i></a>
            </li>
        </c:if>
        <c:if test="${page.number != 0}">
            <li class="page-item">
                <a href="/product/page?p=0" class="page-link"><i class="bi bi-chevron-double-left"></i></a>
            </li>
            <li class="page-item">
                <a href="/product/page?p=${page.number-1}" class="page-link"><i class="bi bi-chevron-left"></i></a>
            </li>
        </c:if>
        <c:if test="${page.number == page.totalPages-1}">
            <li class="page-item disabled">
                <a class="page-link"><i class="bi bi-chevron-right"></i></a>
            </li>
            <li class="page-item disabled">
                <a class="page-link"><i class="bi bi-chevron-double-right"></i></a>
            </li>
        </c:if>
        <c:if test="${page.number != page.totalPages-1}">
            <li class="page-item">
                <a href="/product/page?p=${page.number+1}" class="page-link"><i class="bi bi-chevron-right"></i></a>
            </li>
            <li class="page-item">
                <a href="/product/page?p=${page.totalPages-1}" class="page-link"><i class="bi bi-chevron-double-right"></i></a>
            </li>
        </c:if>
    </ul>
</nav>
<div class="d-flex justify-content-center align-items-center">
    <ul class="list-unstyled">
        <li>Số thực thể hiện tại: ${page.numberOfElements}</li>
        <li>Trang số: ${page.number+1}</li>
        <li>Kích thước trang: ${page.size}</li>
        <li>Tổng số thực thể: ${page.totalElements}</li>
        <li>Tổng số trang: ${page.totalPages}</li>
    </ul>
</div>
</body>
</html>