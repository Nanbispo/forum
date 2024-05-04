create table course(
    id bigint not null auto_increment,
    title varchar(50) not null,
    category varchar(50) not null,
    primary key(id)
);

insert into course values(1.0, 'Kotlin', 'Programacao');
insert into course values(2, 'HTML', 'Front-end');