<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<meta charset="utf-8">

<jsp:include page="header.jsp" />
<div class="container">
	<div class="row">
		<h1 class="fw-bold">Paying</h1>
		<hr>
		<table class="table table-bordered mt-2">
			<thead>
				<tr class="text-center">
					<th>Id</th>
					<th>image</th>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Amount</th>
					<th></th>
				</tr>
			</thead>
			<tbody class="text-center align-middle">
				<c:forEach var="item" items="${cart.items}">
					<form action="/cart/update/${item.id}" method="post">
						<input type="hidden" name="id" value="${item.id}">
						<tr>
							<td>${item.id}</td>
							<td><img src="/img/${item.image}" class="card-img-top "
								alt="..." style="max-width: 100px;" /></td>
							<td>${item.name}</td>
							<td>${item.price}</td>
							<td><form:errors path="qty"></form:errors>
								<div class="d-flex align-items-center"></div> <input
								type="number" name="qty" onblur="this.form.submit()"
								value="${item.qty}" onblur="this.form.submit()"
								style="width: 50px;"
								class="text-center form-control form-control-sm w-50 m-auto"
								min="0" max="100"></a></td>
							<td>${item.price * item.qty}</td>
							<td><a href="/cart/remove/${item.id}" class="btn btn-danger">Remove</a></td>
						</tr>
					</form>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5"><span class="fw-bold">Total: ${total}</span></td>

					<td colspan="2">
						<div class="d-flex justify-content-end gap-2">
							<a href="/cart/clear" class="btn btn-primary">Clear Cart</a> <a
								href="/paying" class="btn btn-primary">Thanh Toán</a>
						</div>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>