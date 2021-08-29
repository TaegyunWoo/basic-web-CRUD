CREATE TABLE IF NOT EXISTS user
(
    dbid bigint(5) NOT NULL AUTO_INCREMENT,
    email varchar(100) NOT NULL,
    name varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    PRIMARY KEY (dbid)
);