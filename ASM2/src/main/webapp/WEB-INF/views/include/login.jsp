<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<meta charset="utf-8">
<jsp:include page="header.jsp" />
<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-md-6">
			<div class="card">
				<h5 class="card-header text-center">ĐĂNG NHẬP</h5>
				<div class="card-body">
					<form action="/login" method="post">
						<div class="form-group">
							<label for="username">Tên đăng nhập</label> <input type="text"
								class="form-control" id="username" name="username"
								placeholder="Username" value="user9">
						</div>
						<div class="form-group">
							<label for="password">Mật khẩu</label> <input type="password"
								class="form-control" id="password" name="password"
								placeholder="Password" value="password9">
						</div>
						<br>
						<div class="position-relative mt-4">
							<div class="position-absolute bottom-0 end-0">
								<button type="submit" class="btn btn-primary btn-block">Đăng
									nhập</button>
							</div>
						</div>
						<a href="/index"><i class="bi bi-arrow-left  mb-3"></i>Về
							trang chủ</a>
				</div>
				</form>

			</div>
		</div>
	</div>
</div>