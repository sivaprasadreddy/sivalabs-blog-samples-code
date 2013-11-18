

DROP TABLE IF EXISTS users;

CREATE TABLE  users 
(
  user_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY UNQ_USERNAME (username),
  UNIQUE KEY UNQ_EMAIL (email)
);

insert into users(user_id, username, password, email) values(1,'siva','siva','siva@gmail.com');
insert into users(user_id, username, password, email) values(2,'admin','admin','admin@gmail.com');
insert into users(user_id, username, password, email) values(3,'test','test','test@gmail.com');
