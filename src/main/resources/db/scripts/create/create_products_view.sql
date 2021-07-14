--liquibase formatted sql

--changeset hayk:product_view

create view v1.product_view as
select id, title, price_dollar, CURRENT_DATE
from v1.product_tbl
where price_dollar > 1.0