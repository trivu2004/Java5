document.getElementById('filter-btn').addEventListener('click', function() {
    const priceRange = document.getElementById('price-range').value;
    const sortOrder = document.getElementById('sort-order').value;
    const brand = document.getElementById('brand').value;

    let minPrice = null;
    let maxPrice = null;

    if (priceRange === '1') {
        minPrice = 3000000;
        maxPrice = 5000000;
    } else if (priceRange === '2') {
        minPrice = 5000000;
        maxPrice = 10000000;
    } else if (priceRange === '3') {
        minPrice = 7000000;
        maxPrice = 15000000;
    }

    const url = new URL(window.location.href);
    url.searchParams.set('minPrice', minPrice);
    url.searchParams.set('maxPrice', maxPrice);
    url.searchParams.set('sort', sortOrder);
    url.searchParams.set('brand', brand);

    window.location.href = url.toString();
});