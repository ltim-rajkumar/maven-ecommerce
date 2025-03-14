CREATE SCHEMA `stepupdb` ;

CREATE TABLE `stepupdb`.`users` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `mobile_no` BIGINT(10) NULL,
  `address` VARCHAR(100) NULL,
  `user_type` TINYINT(1) NULL,
  `created_at` DATETIME(6) NULL,
  PRIMARY KEY (`id`));

