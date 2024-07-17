<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Send Mail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        .formMailer {
            width: 460px;
            margin: auto;
            margin-top: 1rem;
        }
        h2 {
            color: #0000FF;
        }
        .btnSend {
            margin-top: 1.5rem;
            width: 150px;
            font-size: 25px;
        }
        .btnMore {
            margin-top: 1rem;
        }
    </style>
</head>
<body>
<form enctype="multipart/form-data" class="formMailer" action="/sendMail" method="post">
    <h2>Gửi mail để đặt hàng</h2>
    <div class="form-group">
        <label for="formControlInput">Nhập email</label>
        <input type="email" class="form-control" id="formControlInput" name="to" placeholder="Nhập email người nhận...">
    </div>
    <div class="form-group">
        <label for="formControlInput2">Số điện thoại</label>
        <input type="text" class="form-control" id="formControlInput2" name="phone" placeholder="Nhập sđt">
    </div>
    <div class="form-group">
        <label for="formControlInput3">Địa chỉ</label>
        <input type="text" class="form-control" id="formControlInput3" name="address" placeholder="Nhập địa chỉ">
    </div>
    <div class="form-group">
        <label for="formControlInput4">Tiêu đề</label>
        <input type="text" class="form-control" id="formControlInput4" name="subject" placeholder="Nhập tiêu đề..." value="Đặt Hàng Từ CT Mobile">
    </div>
    <div class="form-group">
        <label for="formControlInput4">Giao Hàng</label>
        <input type="text" class="form-control" id="formControlInput5" name="delivery" placeholder="Nhập giao hàng">
    </div>
    <div class="form-group">
        <label for="formControlTextarea">Nội dung</label>
        <textarea class="form-control" id="formControlTextarea" name="content" rows="4" placeholder="Nhập nội dung..."></textarea>
    </div>
    <div class="form-group">
        <label for="formControlInput6">File đính kèm</label>
        <input type="file" class="form-control" id="formControlInput6" name="file">
    </div>
    <div id="fileMore" class="form-group" style="display: none;">
        <label for="formControlInput7">File đính kèm</label>
        <input type="file" class="form-control" id="formControlInput7" name="file1">
    </div>
    <div id="btnMore" class="btn btn-info btnMore">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
            <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
        </svg>
        Thêm tệp
    </div>
    <br/>
    <div class="d-flex justify-content-center">
        <button class="btn btn-warning btnSend mt-4 text-white">Đặt hàng</button>
    </div>
</form>
<script>
    const btnMore = document.getElementById('btnMore');
    const fileMore = document.getElementById("fileMore");
    btnMore.addEventListener('click', () => {
        fileMore.style.display = "block";
    });
</script>
</body>
</html>
