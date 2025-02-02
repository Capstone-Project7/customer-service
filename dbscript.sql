create database customer_service_db;
use customer_service_db;

create table customer_details(
	customer_id int primary key auto_increment,
    customer_name varchar(20),
    email varchar(50),
    phone_number varchar(10),
    is_active boolean default true);

