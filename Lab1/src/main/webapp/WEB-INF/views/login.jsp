<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body, html {
            height: 100%;
        }
        .form-container {
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .form-box {
            width: 100%;
            max-width: 400px;
            padding: 20px;
            border: 2px solid #007bff; /* Border color */
            border-radius: 10px; /* Rounded corners */
            background-color: #f8f9fa; /* Optional: background color for the form */
        }
        .form-label {
            font-size: 1.25rem; /* Increase label size */
        }
        .form-control {
            height: calc(1.5em + 1rem + 2px); /* Increase input height */
            font-size: 1.25rem; /* Increase input text size */
        }
        .form-group {
            margin-bottom: 1.5rem; /* Increase space between input fields */
        }
        .btn {
            font-size: 1.25rem; /* Increase button text size */
            padding: 0.75rem 1.25rem; /* Increase button padding */
        }
    </style>
</head>
<body>
<div class="container form-container">
    <div class="form-box">
        <h2 class="text-center">Login</h2>
        <form action="/result" method="post" class="mt-3">
            <div class="form-group mb-3">
                <label for="userName" class="form-label">Username</label>
                <input type="text" class="form-control" id="userName" name="userName" required>
            </div>
            <div class="form-group mb-3">
                <label for="passWord" class="form-label">Password</label>
                <input type="password" class="form-control" id="passWord" name="passWord" required>
            </div>
            <div class="d-flex justify-content-center ">
                <button type="submit" class="btn btn-primary ">Login</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
