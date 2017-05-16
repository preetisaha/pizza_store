CREATE SCHEMA `pizza_store` ;

CREATE TABLE `pizza_store`.`user_login` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `address` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
  
CREATE TABLE `pizza_store`.`employee_login` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`employee_id`));
  
CREATE TABLE `pizza_store`.`pizza` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `size` INT NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `pizza_store`.`toppings` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `topping` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `image` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `pizza_store`.`order_detail` (
  `order_no` INT NOT NULL AUTO_INCREMENT,
  `uid` INT NOT NULL,
  `topping` VARCHAR(45) NOT NULL,
  `pizza_price` INT NOT NULL,
  PRIMARY KEY (`order_no`),
  INDEX `user_id_idx` (`uid` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`uid`)
    REFERENCES `pizza_store`.`user_login` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `pizza_store`.`order_topping` (
  `order_id` INT NOT NULL,
  `topping_id` INT NOT NULL,
  INDEX `order_no_idx` (`order_id` ASC),
  CONSTRAINT `order_no`
    FOREIGN KEY (`order_id`)
    REFERENCES `pizza_store`.`order_detail` (`order_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `topping_id`
    FOREIGN KEY (`topping_id`)
    REFERENCES `pizza_store`.`toppings` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


INSERT INTO `pizza_store`.`user_login`
(`name`,
`last_name`,
`address`,
`email`,
`password`)
VALUES
("Sam", "Jon", "54 West Street", "s@j", "asd");

INSERT INTO `pizza_store`.`user_login`
(`name`,
`last_name`,
`address`,
`email`,
`password`)
VALUES
("Riya", "ddd", "54 Westkk Street", "a@b", "asd");

INSERT INTO `pizza_store`.`pizza`
(`size`,
`price`)
VALUES
(10, 5);

INSERT INTO `pizza_store`.`pizza`
(`size`,
`price`)
VALUES
(12, 8);

INSERT INTO `pizza_store`.`pizza`
(`size`,
`price`)
VALUES
(14, 12);

INSERT INTO `pizza_store`.`pizza`
(`size`,
`price`)
VALUES
(16, 15);

INSERT INTO `pizza_store`.`toppings`
(`topping`,
`price`,
`image`)
VALUES
('chicken', 2, '../images/chicken.jpg');

INSERT INTO `pizza_store`.`toppings`
(`topping`,
`price`,
`image`)
VALUES
('cheese', 2, '../images/cheese.jpg');

INSERT INTO `pizza_store`.`toppings`
(`topping`,
`price`,
`image`)
VALUES
('jalapeno', 2, '../images/jalapeno.jpg');

INSERT INTO `pizza_store`.`toppings`
(`topping`,
`price`,
`image`)
VALUES
('mushrooms', 2, '../images/mushrooms.jpg');

INSERT INTO `pizza_store`.`toppings`
(`topping`,
`price`,
`image`)
VALUES
('onions', 1, '../images/onions.jpg');

INSERT INTO `pizza_store`.`toppings`
(`topping`,
`price`,
`image`)
VALUES
('pineapple', 2, '../images/pineapple.jpg');

INSERT INTO `pizza_store`.`toppings`
(`topping`,
`price`,
`image`)
VALUES
('chilli', 1, '../images/chilli.jpg');

INSERT INTO `pizza_store`.`toppings`
(`topping`,
`price`,
`image`)
VALUES
('spinach', 1, '../images/spinach.jpg');


