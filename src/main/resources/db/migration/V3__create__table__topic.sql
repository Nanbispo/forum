create table topic(
    id bigint not null auto_increment,
    title varchar not null,
    message varchar not null,
    creation_date datetime not null,
    status varchar not null,
    course_id bigint not null,
    author_id bigint not null,
    primary key(id),
    foreign key(course_id) references course(id),
    foreign key(author_id) references users(id)
);

