<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Search & Page</title>
</head>
<body>
	<h3>SEARCH & PAGE</h3>
<form action="/product/search-and-page" method="post">
	<input name="keywords" value="${keywords}" placeholder="Keywords?">
	<button>Search</button>
</form>	
<table border="1" style="width:100%">
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Price</th>
	<th>Date</th>
</tr>
<c:forEach var="item" items="${page.content}">
	<tr>
		<td>${item.id}</td>
		<td>${item.name}</td>
		<td>${item.price}</td>
		<td>${item.createDate}</td>
	</tr>
</c:forEach>
</table>
<a href="/product/search-and-page?p=0">First</a>
<a href="/product/search-and-page?p=${page.number-1}">Previous</a>
<a href="/product/search-and-page?p=${page.number+1}">Next</a>
<a href="/product/search-and-page?p=${page.totalPages-1}">Last</a>
<ul>
	<li>Số thực thể hiện tại: ${page.numberOfElements}</li>
	<li>Trang số: ${page.number}</li>
	<li>Kích thước trang: ${page.size}</li>
	<li>Tổng số thực thể: ${page.totalElements}</li>
	<li>Tổng số trang: ${page.totalPages}</li>
</ul>
</body>
</html>