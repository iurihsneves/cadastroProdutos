CREATE TABLE IF NOT EXISTS products.product(
    id bigserial primary key,
    product_identifier varchar not null,
    product_name varchar(100) not null,
    product_description varchar not null,
    price float not null,
    category_id bigint REFERENCES products.category(id)
);