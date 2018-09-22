create table person
(
id integer not null,
name varchar(25) not null,
location varchar(25),
birth_Date timestamp,
primary key(id)
);

insert into person values(10001,'Milind','Canada',sysdate());

insert into person values(10002,'Ganesh','Canada',sysdate());

insert into person values(10003,'Suresh','Canada',sysdate());