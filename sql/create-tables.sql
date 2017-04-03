DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS bookref;

CREATE TABLE user(
    user_id INTEGER primary key,
    name TEXT,
    pw_hash TEXT
);

CREATE TABLE bookref(
    ref_id INTEGER PRIMARY KEY,
    owner INTEGER REFERENCES user(user_id),
    year INTEGER,
    variety TEXT,
    title TEXT,
    subtitle TEXT,
    author TEXT,
    article TEXT,
    publisher TEXT
);

INSERT INTO user (user_id, name, pw_hash)
VALUES (1, 'arto', '$2a$10$ZTw6OEDyKOqMABQn4Cga2.D3zNjlHzHuQBsMYqk4AMaItiOFDbCNK');

INSERT INTO bookref (owner, year, title)
VALUES (1, 1493, 'agile arts II');
