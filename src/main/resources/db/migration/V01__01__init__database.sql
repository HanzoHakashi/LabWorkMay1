CREATE TABLE products (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255),
  description TEXT,
  price NUMERIC(10,2),
  image VARCHAR(255)
);
