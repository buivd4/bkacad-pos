create database bkacad_pos;
use bkacad_pos;
create table users (
    username varchar(10) PRIMARY KEY,
    password varchar(18) NOT NULL,
    role char(1) NOT NULL
);

insert into users (username, password, role) values ('admin', 'pass', 'A');