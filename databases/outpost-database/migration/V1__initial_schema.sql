create table OUTPOST
(
    id       VARCHAR(20) NOT NULL,
    name     VARCHAR(20) NOT NULL,
    location VARCHAR(20) NOT NULL
);

ALTER TABLE OUTPOST ADD CONSTRAINT OUTPOST_PK PRIMARY KEY (id);