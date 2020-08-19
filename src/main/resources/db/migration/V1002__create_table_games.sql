CREATE TABLE games (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    word_id INT NOT NULL,
    attempts INT NOT NULL,
    points INT NOT NULL,
    used_letters VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (word_id) REFERENCES words (id)
);