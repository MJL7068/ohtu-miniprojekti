-- DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Reference;

-- CREATE TABLE User(
--     id INTEGER primary key,
--     name TEXT,
--     pw_hash TEXT
-- );

CREATE TABLE Reference(
    id INTEGER PRIMARY KEY,
--     owner INTEGER REFERENCES user(id),
--     year INTEGER,
--     variety TEXT,
    title varchar(255)
--     subtitle TEXT,
--     author TEXT,
--     article TEXT,
--     publisher TEXT
);
