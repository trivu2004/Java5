<%--
  Created by IntelliJ IDEA.
  User: kahuk
  Date: 5/9/2024
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ctrl/ok" method="post">
    <button formaction="/ok1" class="btn btn-secondary mx-1">OK1 ${ok1}</button>
    <button formaction="/ok2"  class="btn btn-success mx-1">OK2 ${ok2}</button>
    <button formaction="/ok3"  class="btn btn-warning mx-1">OK3 ${ok3}</button>
</form>
<h1>${ok}</h1>

</body>
</html>
