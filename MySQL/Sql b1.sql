create database employeedb;
use employeedb;

create table department(
	DepartmentID int auto_increment primary key,
    DepartmentName varchar(100) not null
    );
    
create table employee(
	EmployeeID int auto_increment primary key,
    FullName varchar(100) not null,
    Salary double not null,
    DepartmentID int,
    foreign key (DepartmentID) references Department(DepartmentID)
    );
    
    -- Sample Data
    insert into department (DepartmentName) 
    values ('IT'),
    ('HR'),
    ('Sale');
    
    insert into employee(FullName, Salary, DepartmentID)
    values
    ('Hoang Dao Thuy', 1000, 1 ),
    ('Le Quang Dao', 1500, 2 ),
    ('Hoang Quoc viet', 2000, 1 ),
    ('Ngueyn Chi Thanh', 1200, 3 )

