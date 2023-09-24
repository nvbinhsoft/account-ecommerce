create schema account;

create table users
(
    id         bigint auto_increment,
    email      varchar(250) not null,
    mobile     varchar(250) not null,
    password   varchar(500) not null,
    username   varchar(500) not null,
    created_at timestamp    null,
    created_by varchar(250) null,
    updated_at timestamp    null,
    updated_by varchar(250) null,
    constraint User_pk
        primary key (id)
);