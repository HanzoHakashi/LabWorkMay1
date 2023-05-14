<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


</head>
<body>
<div class="container my-3">
    <h1>Product Catalog</h1>
    <form id="search-form" class="my-3">
        <div class="row">
            <div class="col-md-3">
                <input type="text" class="form-control" name="name" placeholder="Product Name">
            </div>
            <div class="col-md-3">
                <input type="text" class="form-control" name="description" placeholder="Description">
            </div>
            <div class="col-md-2">
                <input type="number" class="form-control" name="minPrice" placeholder="Min Price">
            </div>
            <div class="col-md-2">
                <input type="number" class="form-control" name="maxPrice" placeholder="Max Price">
            </div>
            <div class="col-md-2">
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </div>
    </form>

    <div id="search-results">  <#list products.content as product> </#list></div>
    <div class="container row row-cols-2 row-cols-lg-5 g-2 g-lg-3 justify-content-center" id="product-list">
        <#list products.content as product>

    </#list>
</div>


<nav aria-label="Page navigation">
    <ul class="pagination justify-content-center" id="pagination">
    </ul>
</nav>



<script type="module" src="script.js"></script>
</body>
</html>
