<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Account Management</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
	<div class="container">
		<nav
			class="navbar navbar-expand-lg bg-body-light text-nowrap flex-nowrap bg-transparent mb-3 mt-3"
			style="height: 20px;">
			<div class="container bg-transparent">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
					aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="sidebar offcanvas offcanvas-end" tabindex="-1"
					id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
					<div class="offcanvas-header">
						<h5 class="offcanvas-title" id="offcanvasNavbarLabel">Sale
							Phone</h5>
						<button type="button" class="btn-close"
							data-bs-dismiss="offcanvas" aria-label="Close"></button>
					</div>
					<div class="offcanvas-body">
						<ul class="navbar-nav justify-content-center flex-grow-1 pe-3">
							<li class="nav-item tag"><a
								class="nav-link active text-dark fw-semibold"
								aria-current="page" href="/index">Home</a></li>
							<li class="nav-item tag"><a
								class="nav-link active text-dark fw-semibold"
								aria-current="page" href="#">About us</a></li>
							<li class="nav-item tag"><a
								class="nav-link active text-dark fw-semibold"
								aria-current="page" href="#!Contact">Contact</a></li>
							<li class="nav-item tag"><a
								class="nav-link active text-dark fw-semibold"
								aria-current="page" href="#!DatTour"> Product</a></li>
							<li class="nav-item tag"><a
								class="nav-link active text-dark fw-semibold"
								aria-current="page" href="/cart/view">Paying</a></li>
						</ul>
						<ul class="navbar-nav  justify-content-end flex-grow-1 pe-3">
							<div class="dropdown">
								<button class="btn btn-secondary dropdown-toggle" type="button"
									data-bs-toggle="dropdown" aria-expanded="false">
									<i class="bi bi-person-circle me-1"></i>Account
									${user.username}
								</button>
								<ul class="dropdown-menu">
									<c:if test="${not empty user}">
										<li><a href="/logout" class="dropdown-item">Logout</a></li>
									</c:if>
									<c:if test="${empty user}">
										<li><a href="/login" class="dropdown-item">Login</a></li>
										<li><a href="/signup" class="dropdown-item">Sign up</a></li>
									</c:if>
								</ul>
							</div>

						</ul>
					</div>
				</div>
			</div>
		</nav>
	</div>

	<div class="container mt-5">
		<div class="mt-2">
			<a href="/admin/account" class="btn btn-primary">Tài khoản</a> <a
				href="/product" class="btn btn-primary">Sản phẩm</a> <a
				class="btn btn-primary" href="/report/inventory-by-category">Thống
				kê</a> <a class="btn btn-primary" href="/admin/order">Hóa đơn</a> <a
				class="btn btn-primary" href="/admin/orderdl">Hóa đơn chi tiết</a>
		</div>
		<div class="mt-3">
			<h2>Hóa đơn</h2>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Tên người dùng</th>
						<th>Ngày mua</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${items}">
						<tr>
							<td>${item.id}</td>
							<td>${item.account.fullname}</td>
							<td>${item.createDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
