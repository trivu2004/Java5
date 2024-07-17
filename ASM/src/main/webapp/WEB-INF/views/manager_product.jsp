<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="productItem" method="post" class="me-auto ms-auto w-50 mt-3 row">
    <h1 class="text-primary-emphasis text-center mb-5">Product Management</h1>
    <c:if test="${not empty success_category}">
        <div class="alert alert-success" role="alert">
                ${success_category}
        </div>
    </c:if>
    <div class="mb-3">
        <form:input path="id" type="text" placeholder="Product Id" class="form-control"/>
        <form:errors path="id" class="form-text text-danger" />
        <c:if test="${not empty error_category}">
            <div class="form-text text-danger" >${error_category}</div>
        </c:if>
    </div>
    <div class="mb-3">
        <form:input path="name" type="text" placeholder="Product Name" class="form-control"/>
        <form:errors path="name" class="form-text text-danger" />
    </div>
    <div class="mb-3">
        <form:input path="image" type="text" placeholder="image Name" class="form-control"/>
        <form:errors path="image" class="form-text text-danger" />
    </div>
    <div class="mb-3">
        <form:input path="price" type="text" placeholder="price" class="form-control"/>
        <form:errors path="price" class="form-text text-danger" />
    </div>
<%--    <div class="mb-3">--%>
<%--        <form:input path="createDate" type="text" placeholder="createDate" class="form-control"/>--%>
<%--        <form:errors path="createDate" class="form-text text-danger" />--%>
<%--    </div>--%>
    <div>
        <div class="float-end">
            <button formaction="/product/create" type="submit" class="btn btn-primary">Create</button>
            <button formaction="/product/update" type="submit" class="btn btn-secondary">Update</button>
            <button formaction="/product/delete" type="submit" class="btn btn-danger">Delete</button>
            <button formaction="/product/index" type="submit" class="btn btn-warning">Reset</button>
        </div>
    </div>
</form:form>

<table class="table table-light table-hover me-auto ms-auto w-50 mt-3 text-center">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Image</th>
        <th scope="col">Price</th>
        <th scope="col">Date</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productItems}" var="pro">
        <tr>
            <th scope="row">${pro.id}</th>
            <td>${pro.name}</td>
            <td>${pro.image}</td>
            <td>${pro.price}</td>
            <td>${pro.createDate}</td>
            <td>
                <a href="/product/edit?id=${pro.id}"><i class="bi bi-pencil text-success me-2"></i></a>
                <a href="/product/delete?id=${pro.id}"><i class="bi bi-trash3 text-danger"></i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
