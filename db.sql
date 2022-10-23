
create database Hospital_Management;

use Hospital_Management;

create table patient(patient_id int primary key auto_increment,p_name varchar(20) not null,birth_date date, address varchar(30),mobile_no varchar(12) unique,password varchar(30) not null);

create table department(dept_id int primary key auto_increment,dept_name varchar(20) not null);

create table medicine(medicine_name varchar(20) primary key  ,price decimal(10,2) not null);
create table room(room_no int primary key auto_increment,room_type varchar(20) not null,cost_per_day decimal(10,2) not null);
create table test(test_name varchar(20) primary key ,price decimal(10,2) not null);



create table employee
 (emp_id int primary key auto_increment,
emp_name varchar(20) not null,
birth_date date not null, 
age int , 
address varchar(100) not null,
mobile_no varchar(12) unique key,
password varchar(20) not null,
dept_id int,
foreign key (dept_id)
references department (dept_id) );
alter table employee auto_increment=100;




create table appointment
 (appointment_id int primary key auto_increment,
patient_id int,
emp_id  int,
appointment_date_time datetime not null , 
prescription varchar(400) ,
test varchar(20),
cost decimal(8,2),
foreign key (patient_id) references patient (patient_id),
foreign key (emp_id ) references employee (emp_id) );
alter table appointment auto_increment=300;



create table admit
 (
patient_id int,
room_no int ,
admit_date date not null,
admit_id int primary key auto_increment , 
release_date date ,
emp_id  int,
appointment_id int,
test varchar(50) ,
prescription varchar(50) ,
foreign key (patient_id ) references patient (patient_id),
foreign key (room_no ) references room (room_no),
foreign key (appointment_id ) references appointment (appointment_id),
foreign key (emp_id ) references employee (emp_id) );
alter table admit auto_increment=500;


create table bill
 (
bill_id int primary key auto_increment , 
status varchar(6),
admit_id int,
appointment_id int,
cost decimal(10,2) default 0,
foreign key (admit_id ) references admit (admit_id),
foreign key (appointment_id ) references appointment (appointment_id)
);
alter table bill auto_increment=700;