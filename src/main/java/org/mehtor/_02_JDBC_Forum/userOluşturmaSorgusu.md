CREATE TABLE tbluser
(
id serial PRIMARY KEY ,
ad varchar(20) NOT NULL,
soyad varchar(20) NOT NULL,
username varchar(20) NOT NULL UNIQUE,
password varchar(20) NOT NULL,
state smallint DEFAULT 1,
createat bigint DEFAULT EXTRACT(epoch FROM Now()),
updateat bigint DEFAULT EXTRACT(epoch FROM Now())
)




--Güncel hali
CREATE TABLE tblpost
(
id serial PRIMARY KEY,
user_id Integer REFERENCES tbluser(id) NOT NULL,
baslik varchar(150),
icerik text,
paylasimTarihi timestamp Default NOW(),
state int DEFAULT 1,
createAt timestamp Default NOW(),
updateAt timestamp Default NOW() 
);