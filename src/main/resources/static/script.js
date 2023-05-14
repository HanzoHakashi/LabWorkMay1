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

function displayPagination(page) {

  const pagination = document.getElementById("pagination");
  pagination.innerHTML = "";

  const pageNumbers = [];
  const totalPages = page.totalPages;
  const currentPage = page.number + 1;
  if (totalPages < 2) {
          return;
        }


  let startPage = 1;
  let endPage = totalPages;

  const maxPages = 5;

  if (totalPages > maxPages) {
    const middle = Math.floor(maxPages / 2);
    if (currentPage <= middle) {
      endPage = maxPages;
    } else if (currentPage + middle >= totalPages) {
      startPage = totalPages - maxPages + 1;
    } else {
      startPage = currentPage - middle;
      endPage = currentPage + middle;
    }
  }

  if (startPage > 1) {
    const li = document.createElement("li");
    const link = document.createElement("a");
    link.href = "#";
    link.innerHTML = "1";
    li.appendChild(link);
    pagination.appendChild(li);
    pagination.appendChild(document.createTextNode("..."));
  }

  for (let i = startPage; i <= endPage; i++) {
    const li = document.createElement("li");
    const link = document.createElement("a");
    link.href = "#";
    link.innerHTML = i;
    if (i === currentPage) {
      li.classList.add("active");
    }
    li.appendChild(link);
    pagination.appendChild(li);
  }

  if (endPage < totalPages) {
    pagination.appendChild(document.createTextNode("..."));
    const li = document.createElement("li");
    const link = document.createElement("a");
    link.href = "#";
    link.innerHTML = totalPages;
    li.appendChild(link);
    pagination.appendChild(li);
  }

  const links = pagination.getElementsByTagName("a");
  for (let i = 0; i < links.length; i++) {
    const link = links[i];
    link.addEventListener("click", async (e) => {
      e.preventDefault();
      const pageNumber = parseInt(link.innerHTML) - 1;
      const response = await fetch(`/product?page=${pageNumber}&size=10`);
      const products = await response.json();
      displayProducts(products.content);
      displayPagination(products);
    });
  }
}

window.onload = async () => {
  const response = await fetch("/product");
  const products = await response.json();
  displayProducts(products.content);

      displayPagination(products);
};
