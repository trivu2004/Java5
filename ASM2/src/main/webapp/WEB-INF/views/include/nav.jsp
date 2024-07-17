<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div
	class="container mt-3 d-flex justify-content-between align-items-center">
	<button type="button" class="btn btn-danger btn-lg">
		<s:message code="header.product"></s:message>
	</button>
	<form method="post" action="/index">
		<div class="input-group me-2 ms-2">
			<span class="input-group-text" id="inputGroup-sizing-default"><i
				class="bi bi-search"></i></span> <input type="text" name="keywords"
				class="form-control keywords" value="${keywords}"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default"
				placeholder="<s:message
										code="header.search"></s:message>">
		</div>
	</form>


	<div class="col-md-3">
		<select class="form-select" id="validationCustom04" required>
			<option selected disabled value=""><s:message
					code="header.sort"></s:message></option>
			<option><a href="/sort?field=name">Name Product</a></option>
			<option><a href="/sort?field=price">pp</a></option>
			<option><a href="/sort?field=createDate">New Product</a></option>
		</select>
	</div>
</div>
<div class="container mt-3">
	<div class="row">

		<c:forEach var="item" items="${page.content}">
			<div class="col-sm-6 col-md-4 col-lg-3">
				<div class="card">
					<div>
						<img src="/img/${item.image}" class="card-img-top mt-2" alt="..." />
					</div>
					<hr>
					<div class="card-body">
						<h5 class="card-title Success text-success">
							<s:message code="header.name"></s:message>
							: ${item.name}
						</h5>
						<p class="card-text text-danger">
							<s:message code="header.price"></s:message>
							: ${item.price}VND
						</p>
						<a href="/cart/add/${item.id}" class="nut btn btn-primary "><s:message
								code="header.buy"></s:message></a>
					</div>
				</div>
			</div>
		</c:forEach>

		<div class="mt-2">
			<c:if test="${page.number == 0}">
				<a href="/index?p=0" class="disabled btn btn-primary"><s:message
						code="header.fisrt"></s:message></a>
				<a href="/index?p=${page.number-1}" class="disabled btn btn-primary"><s:message
						code="header.previous"></s:message></a>
			</c:if>

			<c:if test="${page.number != 0}">
				<a href="/index?p=0" class="btn btn-primary"><s:message
						code="header.fisrt"></s:message></a>
				<a href="/index?p=${page.number-1}" class="btn btn-primary"><s:message
						code="header.previous"></s:message></a>
			</c:if>

			<c:if test="${page.number == page.totalPages-1}">
				<a href="/index?p=${page.number+1}" class="disabled btn btn-primary"><s:message
						code="header.next"></s:message></a>
				<a href="/index?p=${page.totalPages-1}"
					class="disabled btn btn-primary"><s:message code="header.last"></s:message></a>
			</c:if>

			<c:if test="${page.number != page.totalPages-1}">
				<a href="/index?p=${page.number+1}" class="btn btn-primary"><s:message
						code="header.next"></s:message></a>
				<a href="/index?p=${page.totalPages-1}" class="btn btn-primary"><s:message
						code="header.last"></s:message></a>
			</c:if>
		</div>
	</div>
</div>

<div class="container mt-3 mb-2">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation">
			<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
				data-bs-target="#home-tab-pane" type="button" role="tab"
				aria-controls="home-tab-pane" aria-selected="true">
				<s:message code="header.sale"></s:message>
			</button>
		</li>
		<li class="nav-item" role="presentation">
			<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
				data-bs-target="#profile-tab-pane" type="button" role="tab"
				aria-controls="profile-tab-pane" aria-selected="false">
				<s:message code="header.sell"></s:message>
			</button>
		</li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="home-tab-pane"
			role="tabpanel" aria-labelledby="home-tab" tabindex="0">
			<div class="d-flex">
				<img src="/img/banner1.jfif" class="me-1" />
				<s:message code="header.body1"></s:message>
				
			</div>
		</div>

		<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel"
			aria-labelledby="profile-tab" tabindex="0">
			<div class="d-flex">
				<img src="/img/banner3.jfif" class="me-1" /> Uy Tín - Chat Luong -
				Dich Vu Hau Mai Chu Dao Chung toi cam ket dem den cho khach hang su
				tin cay va chat luong san pham hang dau. Dong thoi, dich vu hau mai
				duoc dinh huong de dap ung moi nhu cau cua khach hang, giup ban yen
				tam su dung san pham ma minh yeu thich. Hay nhanh tay lua chon cho
				minh chiec dien thoai ung y voi muc giam gia khung chi co trong thoi
				gian gioi han nay! Dung de bo lo co hoi dac biet nay, hay den ngay
				cua hang cua chung toi hoac truy cap vao website de chon cho minh
				chiec dien thoai dang mong doi nhat!
			</div>
		</div>
	</div>
</div>
