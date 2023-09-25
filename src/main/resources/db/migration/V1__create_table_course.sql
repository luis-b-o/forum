CREATE TABLE course(
    id bigint not null AUTO_INCREMENT primary key,
    name VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL
);

insert into course values(1, 'Kotlin ', 'Programming');