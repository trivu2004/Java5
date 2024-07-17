<%--
  Created by IntelliJ IDEA.
  User: kahuk
  Date: 5/13/2024
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form class="me-auto ms-auto w-50 mt-3" action="/form/save" method="post" modelAttribute="student" enctype="multipart/form-data">
    <h1 class="text-center">Student Management</h1>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Name</label>
        <form:input path="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
        <form:errors path="name" class="form-text text-danger" />
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email</label>
        <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
        <form:errors path="email" class="form-text text-danger" />
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Marks</label>
        <form:input path="marks" type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
        <form:errors path="marks" class="form-text text-danger" />
    </div>
    <div class="d-flex">
        <label class="ms-3 me-3">Gender: </label>
        <div class="me-3">
            <form:radiobuttons path="gender" items="${genders}" delimiter=" " class="form-check-input" name="gender" id="flexRadioDefault1"/>
        </div>
    </div>
    <form:errors path="gender" class="form-text text-danger mb-3" />
    <div class="d-flex mt-3">
        <label class="ms-3 me-3">Hobbies: </label>
        <div class="me-3">
            <form:checkboxes path="hobbies" delimiter="     " items="${listHobbies}" class="form-check-input" name="hobbies" id="flexRadioDefault1"/>
        </div>
    </div>
    <form:errors path="hobbies" class="form-text text-danger mb-3" />
    <form:select path="faculty" class="form-select mb-3 mt-3" aria-label="Default select example">
        <c:forEach items="${listFaculty}" var="f">
            <form:option value="${f}">${f}</form:option>
        </c:forEach>
    </form:select>
    <form:errors path="faculty" class="form-text text-danger" />
    <div class="mb-3">
        <label for="formFileSm" class="form-label">Choose Image </label>
        <input class="form-control form-control-sm" name="image" id="formFileSm" type="file">
    </div>
    <button type="submit" class="btn btn-primary float-end">Submit</button>
    <img src="/${dd}" height="220px" width="220px"></img>


</form:form>
<CENTER><table>
    <tr> <td> ${svdk.name} </td></tr>
    <tr> <td> ${svdk.email} </td></tr>
    <tr> <td> ${svdk.marks} </td></tr>
    <tr> <td> ${svdk.gender} </td></tr>
    <tr> <td> ${svdk.hobbies} </td></tr>
    <tr> <td> ${svdk.faculty} </td></tr>
</table>
    <h1>${thongbao}</h1>
</CENTER>

</body>
</html>
