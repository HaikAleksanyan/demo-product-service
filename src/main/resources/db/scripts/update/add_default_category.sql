--liquibase formatted sql

--changeset hayk:alter_default_category
INSERT INTO v1.category_tbl(id, name)
VALUES (1, 'Default');

UPDATE v1.product_tbl
SET category_id=1
WHERE category_id IS NULL;

ALTER TABLE v1.product_tbl
    ALTER COLUMN category_id SET NOT NULL;