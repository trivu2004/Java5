<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<c:set var="localeCookie" value="${cookie['locale'].value}" />
<fmt:setLocale value="${localeCookie}" />
<fmt:setBundle basename="messages"/>
<nav class="navbar bg-success">
  <div class="container-fluid d-flex justify-content-center">
    <form class="d-flex" role="search" action="/product/search-and-page" method="post">
      <input class="form-control me-1" type="search" placeholder="Search" aria-label="Search" name="keywords" value="${keywords}">
      <button class="btn btn-danger" type="submit">Search</button>
    </form>
  </div>
</nav>
<nav class="navbar navbar-expand-lg bg-success navbar-expand-lg navbar-light">
  <div class="mx-5">
    <div>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item mx-3">
            <a class="nav-link active  text-light" aria-current="page" href="/index"><i class="bi bi-phone-fill"></i>CT Mobile</a>
          </li>
          <li class="nav-item mx-3">
            <a class="nav-link active  text-light" aria-current="page" href="/index"><i
                    class="bi bi-house-check-fill"></i><fmt:message key="trang_chu"/></a>
          </li>
          <li class="nav-item mx-3">
            <a class="nav-link text-light" href="#">
              <fmt:message key="ban_mobile"/>
            </a>
          </li>
          <li class="nav-item mx-3">
            <a class="nav-link text-light" href="#">
              <fmt:message key="san_pham_da_xem"/>
            </a>
          </li>
          <li class="nav-item mx-3">
            <a class="nav-link text-light" href="#">
              <fmt:message key="trung_tam_bao_hanh"/>
            </a>
          </li>
          <li class="nav-item mx-3">
            <a class="nav-link text-light" href="#">
              <fmt:message key="tuyen_dung"/>
            </a>
          </li>
          <li class="nav-item dropdown mx-3">
            <a class="nav-link dropdown-toggle  text-light" href="#" role="button" data-bs-toggle="dropdown"
               aria-expanded="false">
              <fmt:message key="tin_tuc"/>
            </a>
            <div class="dropdown-menu fs-5">
              <ul>
                <li><a class="dropdown-item text-black" href="#"><fmt:message key="ho_tro"/></a></li>
                <li><a class="dropdown-item text-black" href="#"><fmt:message key="gioi_thieu"/></a></li>
                <li><a class="dropdown-item text-black" href="#"><fmt:message key="dang_ky_thanh_vien"/></a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item dropdown mx-3">
            <a class="nav-link dropdown-toggle  text-light" href="#" role="button" data-bs-toggle="dropdown"
               aria-expanded="false">
              <i class="bi bi-person"></i>
              <fmt:message key="tai_khoan"/>
            </a>
            <div class="dropdown-menu fs-5">
              <ul>
                <li><a class="dropdown-item text-black" href="/login"><fmt:message key="dang_nhap"/></a></li>
                <li><a class="dropdown-item text-black" href="/account/new"><fmt:message key="chinh_sua_thong_tin"/></a></li>
                <li><a class="dropdown-item text-black" href=""><fmt:message key="quen_mat_khau"/></a></li>
                <li><a class="dropdown-item text-black" href="/logout"><fmt:message key="dang_xuat"/></a></li>
                <li><a class="dropdown-item text-black" href="#"><fmt:message key="doi_mat_khau"/></a>
                </li>
              </ul>
            </div>

          </li>
          <li class="nav-item mx-3">
            <a class="nav-link text-light" href="/locale?lang=en">
              Tiếng Anh
            </a>
          </li>
          <li class="nav-item mx-3">
            <a class="nav-link text-light" href="/locale?lang=vi">
              Tiếng Việt
            </a>
          </li>
        </ul>
        <div class="m-40">
          <span class="navbar-text p-2 text-light ">
            <a href="/cart"><i class="bi bi-cart"></i></a>
            <span></span>
          </span>

        </div>
      </div>
    </div>

  </div>
</nav>