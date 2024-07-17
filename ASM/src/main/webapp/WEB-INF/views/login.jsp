<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/css/login.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<div class="section">
    <div class="container">
        <div class="row full-height justify-content-center">
            <div class="col-12 text-center align-self-center py-5">
                <div class="section pb-5 pt-5 pt-sm-2 text-center text-danger">
                    <h6 class="mb-0 pb-3">
                        <span>Log In</span>
                        <span>Sign Up</span>
                    </h6>
                    <input class="checkbox" type="checkbox" id="reg-log" name="reg-log"/>
                    <label for="reg-log"></label>
                    <div class="card-3d-wrap mx-auto">
                        <div class="card-3d-wrapper">
                            <div class="card-front">
                                <div class="center-wrap">
                                    <div class="section text-center">
                                        <h4 class="mb-4 pb-2">Log In</h4>
                                        <form action="/checkLogin" method="post">
                                            <div class="form-group">
                                                <input type="text" name="username" class="form-style" placeholder="Your Username" id="username" autocomplete="off">
                                                <i class="input-icon bi bi-person mt-3"></i>
                                            </div>
                                            <div class="form-group mt-2">
                                                <input type="password" name="password" class="form-style" placeholder="Your Password" id="password" autocomplete="off">
                                                <i class="input-icon bi-file-lock mt-2"></i>
                                            </div>
                                            <button type="submit" class="btn mt-4 text-white">Login</button>
                                            <p class="mb-0 mt-4 text-center">
                                                <a href="#0" class="link">Forgot your password?</a>
                                            </p>
                                        </form>
                                        <c:if test="${not empty error}">
                                            <div class="alert alert-danger mt-2">
                                                    ${error}
                                            </div>
                                        </c:if>
                                        <c:if test="${not empty message}">
                                            <div class="alert alert-success mt-2">
                                                    ${message}
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                            <div class="card-back">
                                <div class="center-wrap">
                                    <div class="section text-center">
                                        <h4 class="mb-4 pb-3">Sign Up</h4>
                                        <form action="/signup" method="post">
                                            <div class="form-group">
                                                <input type="text" name="username" class="form-style" placeholder="Your Full Name" autocomplete="off">
                                                <i class="input-icon bi bi-person mt-3"></i>
                                            </div>
                                            <div class="form-group mt-2">
                                                <input type="email" name="email" class="form-style" placeholder="Your Email" autocomplete="off">
                                                <i class="input-icon bi bi-envelope mt-3"></i>
                                            </div>
                                            <div class="form-group mt-2">
                                                <input type="password" name="password" class="form-style" placeholder="Your Password" autocomplete="off">
                                                <i class="input-icon bi-file-lock mt-3"></i>
                                            </div>
                                            <button type="submit" class="btn mt-4 text-white">Signup</button>
                                        </form>
                                        <c:if test="${not empty error}">
                                            <div class="alert alert-danger mt-2">
                                                    ${error}
                                            </div>
                                        </c:if>
                                        <c:if test="${not empty message}">
                                            <div class="alert alert-success mt-2">
                                                    ${message}
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<footer class="mt-3">
    <jsp:include page="footer.jsp"/>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
