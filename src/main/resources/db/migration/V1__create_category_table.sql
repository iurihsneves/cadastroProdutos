CREATE SCHEMA IF NOT EXISTS products;

CREATE TABLE IF NOT EXISTS products.category(
    id bigserial primary key,
    category_name varchar(100) not null
)

