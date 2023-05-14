function displayProducts(products) {
  const productDiv = document.getElementById("product-list");
  productDiv.innerHTML = "";
  products.forEach((product) => {
    const card = document.createElement("div");
    card.classList.add("col");
    card.innerHTML = `
        <div class="card">
            <img src="/images/${product.image}" class="card-img-top" alt="${product.name}">
            <div class="card-body">
                <h5 class="card-title">${product.name}</h5>
                <p class="card-text">${product.description}</p>
                <p class="card-text">${product.price}</p>
            </div>
        </div>
    `;
    productDiv.appendChild(card);
  });
}

function hideProductList() {
  const productDiv = document.getElementById("product-list");
  productDiv.innerHTML = "";
}
const searchForm = document.getElementById("search-form");
searchForm.addEventListener("submit", async (e) => {
  e.preventDefault();
  const formData = new FormData(searchForm);
  const searchParams = new URLSearchParams(formData).toString();
  const response = await fetch(`/product/search?${searchParams}`);
  const products = await response.json();
  hideProductList();

  displayProducts(products.content);
});


window.onload = async () => {
  const response = await fetch("/product");
  const products = await response.json();
  displayProducts(products.content);
};
