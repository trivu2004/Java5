<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <form action="/product/save" method="post">
        <div class="mb-3">
            <label class="fs-3">Name</label>
            <input type="text" class="form-control" name="name" placeholder="Product name">
        </div>
        <div class="mb-3">
            <label class="fs-3">Price</label>
            <input type="text" class="form-control" name="price" placeholder="Product price">
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>

    <ul class="mt-3">
        <li>${param.name}</li>
        <li>${param.price}</li>
    </ul>
</div>
</body>
</html>
