drop database IF EXISTS l_Fuli;
CREATE database l_Fuli;
use l_Fuli;
CREATE table l_user(
            id int(10) PRIMARY KEY auto_increment,
            username VARCHAR(100),
            password VARCHAR (100),
            neckname VARCHAR (100)
);

create table l_number(
   id  int(10) primary KEY auto_increment ,
   NonMoney double,
   Rate double,
   Year int (10),
   userid int(10) ,
   FuterMoney double,
  CONSTRAINT FOREIGN KEY (userid) REFERENCES l_user(id)
);

GRANT ALL ON l_Fuli.* to 'root123'@'localhost' IDENTIFIED by '123';