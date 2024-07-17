<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <form action="/product/Bai4save" method="post">
        <div class="mb-3">
            <label for="productName" class="form-label">Product Name</label>
            <input type="text" class="form-control" id="productName" name="name" value="${product.name}">
        </div>
        <div class="mb-3">
            <label for="productPrice" class="form-label">Product Price</label>
            <input type="text" class="form-control" id="productPrice" name="price" value="${product.price}">
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>

    <c:forEach var="p" items="${products}">
        <ul class="mt-3">
            <li>${p.name}</li>
            <li>${p.price}</li>
        </ul>
    </c:forEach>
</div>
</body>
</html>
