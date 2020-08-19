alter table users
add column password varchar(60) not null,
add column enabled boolean not null DEFAULT TRUE;