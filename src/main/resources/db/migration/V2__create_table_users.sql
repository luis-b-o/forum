CREATE TABLE users(
    id bigint not null AUTO_INCREMENT primary key,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

insert into users values(1, 'John Doe', 'john.doe@gmail.com');