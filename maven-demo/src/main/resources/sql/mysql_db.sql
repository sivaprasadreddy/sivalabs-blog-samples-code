
DROP TABLE IF EXISTS users;

CREATE TABLE  users (
  user_id int(10) NOT NULL auto_increment,
  username varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  firstname varchar(45) NOT NULL,
  lastname varchar(45) default NULL,
  dob date default NULL,
  PRIMARY KEY  (user_id),
  UNIQUE KEY Index_2 (username)
);


insert into users(user_id, username, password, email,firstname,lastname,dob) values(1, 'siva', 'siva', 'sivaprasadreddy.k@gmail.com','Siva Prasad','K','1983-06-25');
insert into users(user_id, username, password, email,firstname,lastname,dob) values(2, 'admin', 'admin', 'admin@gmail.com','Administrator',NULL,NULL);

