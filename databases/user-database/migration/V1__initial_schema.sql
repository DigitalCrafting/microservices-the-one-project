create table USER
(
    username      VARCHAR(20) NOT NULL,
    password_hash CHAR(64)    NOT NULL,
    first_name    VARCHAR(20) NOT NULL,
    last_name     VARCHAR(20) NOT NULL
);

ALTER TABLE USER ADD CONSTRAINT USER_PK PRIMARY KEY (username);