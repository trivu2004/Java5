<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="row ">
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
								aria-current="page" href="/index"><s:message
										code="header.home"></s:message></a></li>

							<li class="nav-item tag"><a
								class="nav-link active text-dark fw-semibold"
								aria-current="page" href="#"><s:message code="header.about"></s:message></a></li>
							<li class="nav-item tag"><a
								class="nav-link active text-dark fw-semibold"
								aria-current="page" href="#!Contact"><s:message
										code="header.contact"></s:message></a></li>
							<li class="nav-item tag"><a
								class="nav-link active text-dark fw-semibold"
								aria-current="page" href="/sp"> <s:message
										code="header.product"></s:message></a></li>
							<li class="nav-item tag"><a
								class="nav-link active text-dark fw-semibold"
								aria-current="page" href="/cart/view"> <s:message
										code="header.paying"></s:message></a></li>
							<li>
								<div class="dropdown">
									<button class="btn btn-secondary dropdown-toggle" type="button"
										data-bs-toggle="dropdown" aria-expanded="false">
										<s:message code="header.languages"></s:message>
									</button>
									<ul class="dropdown-menu">

										<li><a href="?lang=vi" class="dropdown-item">VN</a></li>
										<li><a href="?lang=en" class="dropdown-item">EN</a></li>
									</ul>
								</div>
							</li>
						</ul>
						<ul class="navbar-nav  justify-content-end flex-grow-1 pe-3">
							<div class="dropdown">
								<button class="btn btn-secondary dropdown-toggle" type="button"
									data-bs-toggle="dropdown" aria-expanded="false">
									<i class="bi bi-person-circle me-1"></i>
									<s:message code="header.account"></s:message>
									${user.username}
								</button>
								<ul class="dropdown-menu">
									<c:if test="${not empty user}">
										<li><a href="/logout" class="dropdown-item"><s:message
													code="header.logout"></s:message></a></li>
									</c:if>
									<c:if test="${empty user}">
										<li><a href="/login" class="dropdown-item"><s:message
													code="header.login"></s:message></a></li>
										<li><a href="/signup" class="dropdown-item"><s:message
													code="header.signup"></s:message></a></li>
									</c:if>
								</ul>
							</div>

						</ul>
					</div>
				</div>
			</div>
		</nav>
	</div>
</div>


