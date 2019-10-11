-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;
CREATE DATABASE ma_db;
USE ma_db;

-- ************************************** `TypeSupport`

CREATE TABLE `TypeSupport`
(
    `id`   int NOT NULL AUTO_INCREMENT ,
    `type` varchar(40) NOT NULL ,

    PRIMARY KEY (`id`),
    UNIQUE KEY `AK1_Customer_CustomerName` (`type`)
) AUTO_INCREMENT=1 COMMENT='Basic information
about Customer';


-- ************************************** `TitreMusical`

CREATE TABLE `TitreMusical`
(
    `id`       int NOT NULL AUTO_INCREMENT ,
    `titre`    varchar(45) NOT NULL ,
    `id_type`  int NOT NULL ,
    `id_album` int NOT NULL ,

    PRIMARY KEY (`id`),
    KEY `fkIdx_133` (`id_type`),
    CONSTRAINT `FK_133` FOREIGN KEY `fkIdx_133` (`id_type`) REFERENCES `TypeSupport` (`id`),
    KEY `fkIdx_136` (`id_album`),
    CONSTRAINT `FK_136` FOREIGN KEY `fkIdx_136` (`id_album`) REFERENCES `Album` (`id`)
);

-- ************************************** `Artiste`

CREATE TABLE `Artiste`
(
    `id`  int NOT NULL AUTO_INCREMENT ,
    `nom` varchar(40) NULL ,

    PRIMARY KEY (`id`),
    UNIQUE KEY `AK1_Order_OrderNumber` (`nom`)
) AUTO_INCREMENT=1 COMMENT='Order information
like Date, Amount';


-- ************************************** `Album`

CREATE TABLE `Album`
(
    `id`         int NOT NULL AUTO_INCREMENT ,
    `nom`        varchar(45) NOT NULL ,
    `id_artiste` int NOT NULL ,

    PRIMARY KEY (`id`),
    KEY `fkIdx_126` (`id_artiste`),
    CONSTRAINT `FK_126` FOREIGN KEY `fkIdx_126` (`id_artiste`) REFERENCES `Artiste` (`id`)
);







