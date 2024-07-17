<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<jsp:include page="header.jsp" />
<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-md-6">
			<div class="card">
				<h5 class="card-header text-center">ĐĂNG KÝ</h5>
				<div class="card-body">
					<form:form action="/signup" modelAttribute="item" method="post">
						<div class="mb-3">
							<label for="username" class="form-label">Tên đăng nhập</label>
							<form:input path="username" id="username" class="form-control"
								placeholder="Username" />
							<form:errors path="username" cssClass="text-danger" />
						</div>

						<div class="mb-3">
							<label for="password" class="form-label">Mật khẩu</label>
							<form:input path="password" id="password" class="form-control"
								placeholder="Password" />
							<form:errors path="password" cssClass="text-danger" />
						</div>

						<div class="mb-3">
							<label for="fullname" class="form-label">Họ và tên</label>
							<form:input path="fullname" id="fullname" class="form-control"
								placeholder="Full Name" />
							<form:errors path="fullname" cssClass="text-danger" />
						</div>

						<div class="mb-3">
							<label for="email" class="form-label">Email</label>
							<form:input path="email" id="email" class="form-control"
								placeholder="Email" />
							<form:errors path="email" cssClass="text-danger" />
						</div>
						<br>
						<div class="position-relative mt-2">
							<div class="position-absolute bottom-0 end-0">
								<button type="submit" class="btn btn-primary text-end">Đăng
									ký</button>
							</div>
						</div>

					</form:form>
					<a href="/index"><i class="bi bi-arrow-left mt-2"></i>Về trang
						chủ</a>
				</div>
			</div>
		</div>
	</div>
</div>