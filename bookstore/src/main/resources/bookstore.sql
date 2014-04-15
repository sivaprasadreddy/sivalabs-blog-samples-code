
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS payments;
DROP TABLE IF EXISTS addresses;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;


CREATE TABLE categories (
  cat_id int(11) NOT NULL auto_increment,
  name varchar(100) default NULL,
  description varchar(512) default NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (cat_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE products (
  product_id int(11) NOT NULL auto_increment,
  cat_id int(11) default NULL,
  name varchar(100) default NULL,
  description varchar(512) default NULL,
  price decimal(19,2) default NULL,
  image_url varchar(255) default NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (product_id),
  KEY FK_mrb6cdmhln6h36nx2u3b5hv79 (cat_id),
  CONSTRAINT FK_mrb6cdmhln6h36nx2u3b5hv79 FOREIGN KEY (cat_id) REFERENCES categories (cat_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE addresses (
  addr_id int(11) NOT NULL auto_increment,
  addr_line1 varchar(255) default NULL,
  addr_line2 varchar(255) default NULL,
  city varchar(255) default NULL,
  state varchar(255) default NULL,
  zip_code varchar(255) default NULL,
  country varchar(255) default NULL,
  PRIMARY KEY  (addr_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE customers (
  cust_id int(11) NOT NULL auto_increment,
  email varchar(100) NOT NULL,
  password varchar(50) NOT NULL,
  firstname varchar(50) NOT NULL,
  lastname varchar(50) default NULL,
  phone varchar(15) default NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (cust_id),
  UNIQUE KEY UK_rfbvkrffamfql7cjmen8v976v (email)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE payments (
  payment_id int(11) NOT NULL auto_increment,
  cc_number varchar(255) default NULL,
  cvv varchar(255) default NULL,
  expiry_date datetime default NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (payment_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE orders (
  order_id int(11) NOT NULL auto_increment,
  cust_id int(11) NOT NULL,
  shipping_addr_id int(11) NOT NULL,
  payment_id int(11) NOT NULL,
  status varchar(255) default NULL,
  created_on datetime NOT NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (order_id),
  KEY FK_s32ku57qouy9bwgs8uhxv3s0j (cust_id),
  KEY FK_haujdjk1ohmeixjhnhslchrp1 (payment_id),
  KEY FK_t866pm0ujvn06a89h3ay899re (shipping_addr_id),
  CONSTRAINT FK_t866pm0ujvn06a89h3ay899re FOREIGN KEY (shipping_addr_id) REFERENCES addresses (addr_id),
  CONSTRAINT FK_haujdjk1ohmeixjhnhslchrp1 FOREIGN KEY (payment_id) REFERENCES payments (payment_id),
  CONSTRAINT FK_s32ku57qouy9bwgs8uhxv3s0j FOREIGN KEY (cust_id) REFERENCES customers (cust_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE order_items (
  order_item_id int(11) NOT NULL auto_increment,
  order_id int(11) NOT NULL,
  product_id int(11) NOT NULL,
  quantity int(11) NOT NULL,
  created_on datetime default NULL,
  updated_on datetime default NULL,
  PRIMARY KEY  (order_item_id),
  KEY FK_3fea23hxar30bx7m7h8ed25n9 (product_id),
  KEY FK_9gap2fmw66v092ntb58rtohwh (order_id),
  CONSTRAINT FK_9gap2fmw66v092ntb58rtohwh FOREIGN KEY (order_id) REFERENCES orders (order_id),
  CONSTRAINT FK_3fea23hxar30bx7m7h8ed25n9 FOREIGN KEY (product_id) REFERENCES products (product_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO categories (cat_id,created_on,description,name,updated_on) VALUES 
 (1,NULL,'Java Books','Java',NULL),
 (2,NULL,'MS.NET Books','MS.NET',NULL);
 
 
INSERT INTO products (product_id,created_on,description,image_url,name,price,updated_on,cat_id) VALUES 
 (1,NULL,'Java Persistence with MyBatis3',NULL,'Java Persistence with MyBatis3','500.00',NULL,1),
 (2,NULL,'PrimeFaces Beginners Guide',NULL,'PrimeFaces Beginners Guide','2500.00',NULL,1),
 (3,NULL,'CSharp DotNet book',NULL,'C Shart .NET book','1500.00',NULL,2);


INSERT INTO customers (cust_id,created_on,email,firstname,lastname,password,phone,updated_on) VALUES 
 (1,NULL,'siva@gmail.com','Siva','K','siva',NULL,NULL),
 (2,NULL,'admin@gmail.com','Admin',NULL,'admin',NULL,NULL);


INSERT INTO addresses (addr_id,addr_line1,addr_line2,city,country,state,zip_code) VALUES 
 (1,'Balaji Nagar','KP','Hyd','INDIA','AP','500072');


INSERT INTO payments (payment_id,created_on,cc_number,cvv,expiry_date,updated_on) VALUES 
 (1,NULL,'1234567890','123','2105-12-30 00:00:00',NULL);
 
INSERT INTO orders (order_id,created_on,status,updated_on,cust_id,payment_id,shipping_addr_id) VALUES 
 (1,'2013-12-17 00:00:00','NEW',NULL,2,1,1);



INSERT INTO order_items (order_item_id,created_on,quantity,updated_on,product_id,order_id) VALUES 
 (1,'2013-12-17 00:00:00',2,NULL,1,1),
 (2,'2013-12-17 00:00:00',1,NULL,2,1);

