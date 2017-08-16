DROP TABLE IF EXISTS transaction;

CREATE TABLE user (
  id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email_id VARCHAR(100) NOT NULL,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  address VARCHAR(200) NOT NULL,
  mobile_number VARCHAR(100) NOT NULL,
  type VARCHAR(10) NOT NULL,
  gender varchar(10),
  date_of_birth DATE,
  pan_number varchar(10),
  exp_in_years INT(2),
  exp_in_months INT(2),
  PRIMARY KEY (id)
);

CREATE TABLE product (
  id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(200) NOT NULL,
  price NUMBER(10, 2) NOT NULL,
  image_url VARCHAR(500) NOT NULL,
  available_quantity INT NOT NULL,
  category VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);