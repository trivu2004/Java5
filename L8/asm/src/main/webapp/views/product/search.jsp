<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Search</title>
</head>
<body>
	<h3>SEARCH BY PRICE</h3>
<form action="/product/search" method="post">
	<input name="min" value="${param.min}" placeholder="Min Price?">
	<input name="max" value="${param.max}" placeholder="Max Price?">
	<button>Search</button>
</form>
<table border="1" style="width:100%">
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Price</th>
	<th>Date</th>
</tr>
<c:forEach var="item" items="${items}">
	<tr>
		<td>${item.id}</td>
		<td>${item.name}</td>
		<td>${item.price}</td>
		<td>${item.createDate}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>