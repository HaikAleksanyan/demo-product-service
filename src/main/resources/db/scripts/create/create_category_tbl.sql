--liquibase formatted sql

--changeset hayk:create_category_tbl
CREATE TABLE v1.category_tbl
(
    id                 bigint PRIMARY KEY,
    name               text NOT NULL,
    parent_category_id bigint,
    FOREIGN KEY (parent_category_id) REFERENCES v1.category_tbl (id)
        ON DELETE SET NULL,
    UNIQUE (name)
) INHERITS (v1.audit);

--changeset hayk:alter_product_tbl
ALTER TABLE v1.product_tbl
    ADD category_id bigint,
    ADD CONSTRAINT prod_category
        FOREIGN KEY (category_id) REFERENCES v1.category_tbl (id)
            ON DELETE CASCADE;