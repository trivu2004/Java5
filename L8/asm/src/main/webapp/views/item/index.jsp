<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
<ul>
<c:forEach var="item" items="${items}">
	<li>
		${item.name} (${item.price}) ::
		[<a href="/cart/add/${item.id}">Add To Cart</a>]
	</li>
</c:forEach>
</ul>
</body>
</html>