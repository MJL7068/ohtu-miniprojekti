CREATE TABLE reference (
    ref_id integer PRIMARY KEY,
    user_id integer REFERENCES user(user_id),
    type text,
    author text,
    title text,
    article text
)
