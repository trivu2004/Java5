<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create/Update Account</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            margin-top: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="checkbox"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="checkbox"] {
            width: auto;
            margin-top: 0;
        }
        button[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Create/Update Account</h1>
    <div th:if="${param.success_category != null}">
        <div class="alert alert-success" role="alert">
            <strong>Success!</strong> ${param.success_category}
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/account/newupdate" method="post">
        <div>
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" value="${user.id}" required/>
        </div>
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${user.username}" required/>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${user.password}" required/>
        </div>
        <div>
            <label for="fullname">Full Name:</label>
            <input type="text" id="fullname" name="fullname" value="${user.fullname}" required/>
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}" required/>
        </div>
        <div class="mt-3">
            <label for="photo">Photo URL:</label>
            <input type="file" id="photo" name="photo" value="${user.photo}" />
        </div>

        <div class="mt-4 text-center">
            <button type="submit" class="btn btn-primary">Cập nhật thông tin</button>
        </div>
        <div class="mt-3">
            <a href="/index">Trở về trang chủ</a>
        </div>
    </form>

</div>
</body>
</html>
