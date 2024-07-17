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
<div class="container-fluid d-flex justify-content-center mt-3">
    <form class="d-flex" role="search" action="/account/search-and-page" method="post">
        <input class="form-control me-1" type="search" placeholder="Search" aria-label="Search" name="keywords" value="${keywords}">
        <button class="btn btn-danger" type="submit">Search</button>
    </form>
</div>
<form:form modelAttribute="accountItem" method="post" class="me-auto ms-auto w-50 mt-3 row">
    <h1 class="text-primary-emphasis text-center mb-5">User Management</h1>
    <c:if test="${not empty success_category}">
        <div class="alert alert-success" role="alert">
                ${success_category}
        </div>
    </c:if>
    <div class="mb-3">
        <form:input path="id" type="text" placeholder="User Id" class="form-control"/>
        <form:errors path="id" class="form-text text-danger" />
        <c:if test="${not empty error_category}">
            <div class="form-text text-danger" >${error_category}</div>
        </c:if>
    </div>
    <div class="mb-3">
        <form:input path="username" type="text" placeholder="user Name" class="form-control"/>
        <form:errors path="username" class="form-text text-danger" />
    </div>
    <div class="mb-3">
        <form:input path="password" type="text" placeholder="password" class="form-control"/>
        <form:errors path="password" class="form-text text-danger" />
    </div>
    <div class="mb-3">
        <form:input path="fullname" type="text" placeholder="fullname" class="form-control"/>
        <form:errors path="fullname" class="form-text text-danger" />
    </div>
    <div class="mb-3">
        <form:input path="email" type="text" placeholder="email" class="form-control"/>
        <form:errors path="email" class="form-text text-danger" />
    </div>
    <div class="mb-3">
        <form:input path="admin" type="text" placeholder="admin" class="form-control"/>
        <form:errors path="admin" class="form-text text-danger" />
    </div>
    <div>
        <div class="float-end">
            <button formaction="/account/create" type="submit" class="btn btn-primary">Create</button>
            <button formaction="/account/update" type="submit" class="btn btn-secondary">Update</button>
            <button formaction="/account/delete" type="submit" class="btn btn-danger">Delete</button>
            <button formaction="/account/new1" type="submit" class="btn btn-warning">Reset</button>
        </div>
    </div>
</form:form>

<table class="table table-light table-hover me-auto ms-auto w-50 mt-3 text-center">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Password</th>
        <th scope="col">Fullname</th>
        <th scope="col">Vai Trò</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${accountItems}" var="ac">
        <tr>
            <th scope="row">${ac.id}</th>
            <td>${ac.username}</td>
            <td>${ac.password}</td>
            <td>${ac.fullname}</td>
            <td>${ac.email}</td>
            <td>${ac.admin}</td>
            <td>
                <a href="/account/edit?id=${ac.id}"><i class="bi bi-pencil text-success me-2"></i></a>
                <a href="/account/delete?id=${ac.id}"><i class="bi bi-trash3 text-danger"></i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
