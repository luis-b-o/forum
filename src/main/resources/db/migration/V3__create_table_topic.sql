CREATE TABLE topic(
    id bigint not null AUTO_INCREMENT primary key,
    title VARCHAR(50) NOT NULL,
    message VARCHAR(50) NOT NULL,
    created_at DATETIME NOT NULL,
    status VARCHAR(20) NOT NULL,
    course_id bigint NOT NULL,
    author_id bigint NOT NULL,
    foreign key(course_id) references course(id),
    foreign key(author_id) references users(id)
);
