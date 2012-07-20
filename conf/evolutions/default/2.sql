# Tasks schema

# -- !Ups

create sequence CUSTOMER_ID_SEQ;

create table CUSTOMER (
  ID integer not null default nextval('CUSTOMER_ID_SEQ'),
  NAME varchar(255),
  ADDRESS varchar(255)
);

# -- !Downs

drop table CUSTOMER;

drop sequence CUSTOMER_ID_SEQ;
