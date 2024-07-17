<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/param/save/2021" method="post" class="mt-5">
        <div class="mb-3">
            <label for="x" class="form-label">X</label>
            <input type="text" class="form-control" id="x" name="x" value="2022">
        </div>
        <div class="mb-3">
            <label for="y" class="form-label">Y</label>
            <input type="text" class="form-control" id="y" name="y" value="2031">
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
    <ul class="mt-3">
        <li>${param.x}</li>
        <li>${param.y}</li>
    </ul>
</div>
</body>
</html>
