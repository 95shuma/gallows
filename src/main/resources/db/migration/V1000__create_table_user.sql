CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    role VARCHAR(10) NOT NULL DEFAULT 'ROLE_USER'
);