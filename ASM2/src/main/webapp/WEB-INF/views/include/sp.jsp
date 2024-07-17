<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<jsp:include page="header.jsp" />
<div class="container mt-2">
	<div class="row">
		<div class="col-sm-3">
			<h4 class="fw-blod">Danh mục sản phẩm</h4>
			<ul class="list-group">
				<c:forEach var="item" items="${cate}">
					<li class="list-group-item"><a href="/sp/${item.id}"
						class="text-black fs-5">${item.name}</a></li>
				</c:forEach>
			</ul>

			<div class="row">
				<form action="/sp/price" method="post" class="mb-2 mt-2">
					<input name="min" value="${param.min}" placeholder="Min Price"
						class="form-control"> <input name="max"
						value="${param.max}" placeholder="Max Price"
						class="form-control mt-2 mb-2">
					<button class="btn btn-primary">search</button>
				</form>
			</div>
		</div>

		<div class="col-sm-9">
			<div class="row">
				<c:forEach var="item" items="${items}">
					<div class="col-sm-12 col-md-4 col-lg-4 mb-2">
						<div class="card">
							<div>
								<img src="/img/${item.image}" class="card-img-top mt-2"
									alt="..." />
							</div>
							<hr>
							<div class="card-body">
								<h5 class="card-title Success text-success">${item.name}</h5>
								<p class="card-text text-danger">${item.price}VND</p>
								<a href="/cart/add/${item.id}" class="nut btn btn-primary ">Buy
									Now</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
