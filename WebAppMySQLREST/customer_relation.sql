create database customer_relation;
create table account(account_id int primary key not null auto_increment,
account_no varchar(100) not null,
account_type_id int not null,
role_id int not null,
person_id int not null
);
create table person(
person_id int primary key not null auto_increment,
firstname varchar(250) not null,
lastname varchar(250) not null,
gender varchar(10) not null,
email varchar(500) not null,
cellnumber1 varchar(100) not null,
cellnumber2 varchar(100) not null,
fax varchar(100) not null,
date_created varchar(250) not null
);
create table account_type(
account_type_id int primary key not null auto_increment,
account_name varchar(250) not null,
description varchar(500) not null
);
create table login_details(
login_details_id int primary key not null auto_increment,
username varchar(250) not null,
password varchar(250) not null,
person_id int not null
);
create table role(
role_id int primary key not null auto_increment,
role_name varchar(250) not null,
description varchar(500) not null
);
create table DbTransactions(
db_transactions_id int primary key auto_increment not null,
description varchar(250) not null,
date_done varchar(100) not null,
person_id int not null
);