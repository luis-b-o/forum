CREATE TABLE answer(
    id bigint not null AUTO_INCREMENT primary key,
    message VARCHAR(300) NOT NULL,
    created_at DATETIME NOT NULL,
    solution int NOT NULL,
    topic_id bigint NOT NULL,
    author_id bigint NOT NULL,
    foreign key(topic_id) references topic(id),
    foreign key(author_id) references users(id)
);
