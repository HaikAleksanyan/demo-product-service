--liquibase formatted sql

--changeset hayk:v1_schema
create schema if not exists v1;

--changeset hayk:hibernate_seq
create sequence if not exists HIBERNATE_SEQUENCE
    minvalue 100000
    maxvalue 9999999999999999
    start with 100060
    increment by 1
    cache 20;

--changeset hayk:audit_tbl
CREATE TABLE v1.audit
(
    creation_dt    timestamp without time zone,
    last_update_dt timestamp without time zone
);

--changeset hayk:product_tbl
create table v1.product_tbl
(
    id                  bigint PRIMARY KEY,
    title               text  NOT NULL,
    description         text,
    price_dollar        REAL NOT NULL DEFAULT 0.0,
    discount_percentage int
) INHERITS (v1.audit);