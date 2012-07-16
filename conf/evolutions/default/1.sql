# Tasks schema

# -- !Ups

create sequence TASK_ID_SEQ;

create table TASK (
  ID integer not null default nextval('TASK_ID_SEQ'),
  LABEL varchar(255)
);

# -- !Downs

drop table TASK;

drop sequence TASK_ID_SEQ;
