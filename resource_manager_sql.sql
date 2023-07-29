DROP SCHEMA IF EXISTS `myappdb`;

create database `myappdb`;

DROP TABLE IF exists `myappdb`.`members`;

CREATE TABLE `myappdb`.`members` (
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nickname VARCHAR(55),
    first_name VARCHAR(55),
    last_name VARCHAR(55),
    creation_date TIMESTAMP,
    modification_date TIMESTAMP,
    user_type VARCHAR(50)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF exists `myappdb`.`items`;

CREATE TABLE `myappdb`.`items` (
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    item_name VARCHAR(55),
    creation_date TIMESTAMP,
    modification_date TIMESTAMP,
    owner_id INT,
    object_type VARCHAR(50),
    metadata JSON,
   FOREIGN KEY (owner_id) REFERENCES myappdb.members (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `myappdb`.`members`(nickname, first_name, last_name, creation_date, modification_date, user_type)
VALUES ('john123', 'John', 'Doe', '2023-06-21 09:12:34', '2023-06-21 09:12:34', 'DEFAULT');

INSERT INTO `myappdb`.`members` (nickname, first_name, last_name, creation_date, modification_date, user_type)
VALUES ('sarah89', 'Sarah', 'Johnson', '2023-06-20 18:45:23', '2023-06-20 18:45:23', 'DEFAULT');

INSERT INTO `myappdb`.`members` (nickname, first_name, last_name, creation_date, modification_date, user_type)
VALUES ('alex27', 'Alex', 'Smith', '2023-06-19 15:30:12', '2023-06-19 15:30:12', 'DEFAULT');

INSERT INTO `myappdb`.`members` (nickname, first_name, last_name, creation_date, modification_date, user_type)
VALUES ('admin1', 'Admin', 'User', '2023-06-18 12:01:45', '2023-06-18 12:01:45', 'SUPER_USER');

INSERT INTO `myappdb`.`members` (nickname, first_name, last_name, creation_date, modification_date, user_type)
VALUES ('admin1', 'Admin', 'User', '2023-06-18 12:01:45', '2023-06-18 12:01:45', 'SUPER_USER');

INSERT INTO `myappdb`.`members` (nickname, first_name, last_name, creation_date, modification_date, user_type)
VALUES ('jenny99', 'Jenny', 'Anderson', '2023-06-17 20:14:59', '2023-06-17 20:14:59', 'DEFAULT');

INSERT INTO `myappdb`.`items` (first_name, creation_date, modification_date, owner_id, object_type, metadata)
VALUES ('Resource 1', '2023-06-21 09:12:34', '2023-06-21 09:12:34', 1, 'MAP', '{"key1": "value1", "key2": "value2"}');

INSERT INTO `myappdb`.`items` (first_name, creation_date, modification_date, owner_id, object_type, metadata)
VALUES ('Resource 2', '2023-06-20 18:45:23', '2023-06-20 18:45:23', 2, 'RESEARCH', '{"name": "Research Study 1", "participants": 50, "completed": true}');

INSERT INTO `myappdb`.`items` (first_name, creation_date, modification_date, owner_id, object_type, metadata)
VALUES ('Resource 3', '2023-06-19 15:30:12', '2023-06-19 15:30:12', 1, 'FILE', '{"file_name": "document.txt", "file_size": "10 KB", "file_type": "text/plain"}');

INSERT INTO `myappdb`.`items` (first_name, creation_date, modification_date, owner_id, object_type, metadata)
VALUES ('Resource 4', '2023-06-18 12:01:45', '2023-06-18 12:01:45', 3, 'MAP', '{"latitude": 40.7128, "longitude": -74.0060, "zoom_level": 12}');

INSERT INTO `myappdb`.`items` (first_name, creation_date, modification_date, owner_id, object_type, metadata)
VALUES ('Resource 5', '2023-06-17 20:14:59', '2023-06-17 20:14:59', 2, 'RESEARCH', '{"title": "Market Research", "target_audience": "18-35", "questions": ["Question 1", "Question 2", "Question 3"]}');



CREATE TABLE `myappdb`.`users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: mypassword321
--

INSERT INTO `myappdb`.`users` 
VALUES 
('user_resource','{bcrypt}$2a$10$xZFr8i/Gqz4Th8cmoblu4.839KnmwCxWkXtOYc5xzJ5iShpvkUUAS',1),
('manager_resource','{bcrypt}$2a$10$xZFr8i/Gqz4Th8cmoblu4.839KnmwCxWkXtOYc5xzJ5iShpvkUUAS',1),
('admin_resource','{bcrypt}$2a$10$xZFr8i/Gqz4Th8cmoblu4.839KnmwCxWkXtOYc5xzJ5iShpvkUUAS',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `myappdb`.`authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `myappdb`.`authorities` 
VALUES 
('user_resource','ROLE_EMPLOYEE'),
('manager_resource','ROLE_EMPLOYEE'),
('manager_resource','ROLE_MANAGER'),
('admin_resource','ROLE_EMPLOYEE'),
('admin_resource','ROLE_MANAGER'),
('admin_resource','ROLE_ADMIN');
