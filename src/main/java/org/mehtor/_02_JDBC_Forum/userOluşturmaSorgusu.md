CREATE TABLE tbluser
(
id serial PRIMARY KEY ,
ad varchar(20) NOT NULL,
soyad varchar(20) NOT NULL,
username varchar(20) NOT NULL,
password varchar(20) NOT NULL,
state smallint DEFAULT 1,
createat bigint DEFAULT EXTRACT(epoch FROM Now()),
updateat bigint DEFAULT EXTRACT(epoch FROM Now())
)