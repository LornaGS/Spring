DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `full_name` VARCHAR NOT NULL UNIQUE,
    `job` VARCHAR,
    `age` INTEGER






);