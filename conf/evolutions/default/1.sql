# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cupom_desconto (
  id                            serial not null,
  nome_documento                varchar(255),
  valor                         float,
  constraint pk_cupom_desconto primary key (id)
);


# --- !Downs

drop table if exists cupom_desconto cascade;

