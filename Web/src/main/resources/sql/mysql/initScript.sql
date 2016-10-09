DROP DATABASE IF EXISTS instagram;

CREATE DATABASE `instagram` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE instagram;

-- MySQL dump 10.13  Distrib 5.6.27, for Win64 (x86_64)
--
-- Host: localhost    Database: instagram
-- ------------------------------------------------------
-- Server version	5.6.27-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `albums`
--

DROP TABLE IF EXISTS `albums`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `albums` (
  `albumId` INT(11)     NOT NULL AUTO_INCREMENT,
  `name`    VARCHAR(50) NOT NULL,
  `userId`  INT(11)              DEFAULT NULL,
  PRIMARY KEY (`albumId`),
  KEY `FK750B3C04F989E1BA` (`userId`),
  CONSTRAINT `FK750B3C04F989E1BA` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albums`
--

LOCK TABLES `albums` WRITE;
/*!40000 ALTER TABLE `albums`
  DISABLE KEYS */;
INSERT INTO `albums` VALUES (3, 'tepatel\'s album', 1), (4, 'Mikhail\'s album', 7), (5, 'Other pictures album', 7);
/*!40000 ALTER TABLE `albums`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dialog`
--

DROP TABLE IF EXISTS `dialog`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dialog` (
  `dialogId`      INT(11)      NOT NULL AUTO_INCREMENT,
  `membersString` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`dialogId`),
  UNIQUE KEY `dialogId_UNIQUE` (`dialogId`),
  UNIQUE KEY `membersString_UNIQUE` (`membersString`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dialog`
--

LOCK TABLES `dialog` WRITE;
/*!40000 ALTER TABLE `dialog`
  DISABLE KEYS */;
INSERT INTO `dialog` VALUES (10, '1,7');
/*!40000 ALTER TABLE `dialog`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forms`
--

DROP TABLE IF EXISTS `forms`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forms` (
  `formId`  INT(11)      NOT NULL AUTO_INCREMENT,
  `aboutMe` VARCHAR(50)  NOT NULL,
  `myPhoto` VARCHAR(255) NOT NULL,
  `userId`  INT(11)               DEFAULT NULL,
  PRIMARY KEY (`formId`),
  KEY `FK40E9C0FF989E1BA` (`userId`),
  CONSTRAINT `FK40E9C0FF989E1BA` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forms`
--

LOCK TABLES `forms` WRITE;
/*!40000 ALTER TABLE `forms`
  DISABLE KEYS */;
INSERT INTO `forms` VALUES (1, 'Tepatel user', '27.jpg', 1), (7, 'Mikhail', 'NoPhoto.jpg', 7);
/*!40000 ALTER TABLE `forms`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends` (
  `friendId`     INT(11) NOT NULL AUTO_INCREMENT,
  `userIdFirst`  INT(11)          DEFAULT NULL,
  `userIdSecond` INT(11)          DEFAULT NULL,
  PRIMARY KEY (`friendId`),
  UNIQUE KEY `friendId_UNIQUE` (`friendId`),
  KEY `secondUserKey_idx` (`userIdSecond`),
  KEY `FK3F73E1751909B7DE` (`userIdFirst`, `userIdSecond`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 19
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends`
  DISABLE KEYS */;
INSERT INTO `friends` VALUES (18, 1, 7), (17, 7, 1);
/*!40000 ALTER TABLE `friends`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `images` (
  `imageId`         INT(11)      NOT NULL AUTO_INCREMENT,
  `albumId`         INT(11)               DEFAULT NULL,
  `pictureDescribe` VARCHAR(100) NOT NULL,
  `pictureName`     VARCHAR(30)  NOT NULL,
  `pictureUrl`      VARCHAR(20)  NOT NULL,
  `votesNumber`     INT(11)               DEFAULT NULL,
  PRIMARY KEY (`imageId`),
  KEY `FK82BF6E98E7160BA2` (`albumId`),
  CONSTRAINT `FK82BF6E98E7160BA2` FOREIGN KEY (`albumId`) REFERENCES `albums` (`albumId`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 32
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images`
  DISABLE KEYS */;
INSERT INTO `images` VALUES (27, 3, 'Learn English motivator', 'original.jpg', '27.jpg', 2),
  (28, 4, 'Picture Describe', 'Picture Name', '28.jpg', 2),
  (29, 4, 'Picture Describe', 'girls-pics-17.jpg', '29.jpg', 2),
  (30, 5, 'Picture Describe', 'images-21.jpg', '30.jpg', 1), (31, 5, 'Picture Describe', 'Picture Name', '31.jpg', 1);
/*!40000 ALTER TABLE `images`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `messageId` INT(11)      NOT NULL AUTO_INCREMENT,
  `dialogId`  INT(11)               DEFAULT NULL,
  `text`      VARCHAR(255) NOT NULL,
  `userId`    INT(11)               DEFAULT NULL,
  PRIMARY KEY (`messageId`),
  KEY `FK38EB000714F5E59F` (`dialogId`),
  KEY `FK38EB0007F989E1BA` (`userId`),
  CONSTRAINT `FK38EB000714F5E59F` FOREIGN KEY (`dialogId`) REFERENCES `dialog` (`dialogId`)
    ON DELETE CASCADE,
  CONSTRAINT `FK38EB0007F989E1BA` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 16
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message`
  DISABLE KEYS */;
INSERT INTO `message` VALUES (11, 10, 'hi', 1), (12, 10, 'I am a tepatel user from the Wiley project', 1),
  (13, 10, 'Since of today, I am in Instagram!', 1), (14, 10, 'Hi', 7), (15, 10, 'Great!', 7);
/*!40000 ALTER TABLE `message`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `params`
--

DROP TABLE IF EXISTS `params`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `params` (
  `paramId`    INT(11) NOT NULL AUTO_INCREMENT,
  `paramName`  VARCHAR(255)     DEFAULT NULL,
  `paramValue` VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (`paramId`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `params`
--

LOCK TABLES `params` WRITE;
/*!40000 ALTER TABLE `params`
  DISABLE KEYS */;
INSERT INTO `params` VALUES (1, 'lastImageId', '31');
/*!40000 ALTER TABLE `params`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picturetags`
--

DROP TABLE IF EXISTS `picturetags`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picturetags` (
  `PictureTagId` INT(11) NOT NULL AUTO_INCREMENT,
  `pictureId`    INT(11)          DEFAULT NULL,
  `tagId`        INT(11)          DEFAULT NULL,
  PRIMARY KEY (`PictureTagId`),
  KEY `FK179D89F728FDFF42` (`tagId`),
  KEY `FK179D89F7E693B505` (`pictureId`),
  CONSTRAINT `FK179D89F728FDFF42` FOREIGN KEY (`tagId`) REFERENCES `tags` (`tagId`)
    ON DELETE CASCADE,
  CONSTRAINT `FK179D89F7E693B505` FOREIGN KEY (`pictureId`) REFERENCES `images` (`imageId`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picturetags`
--

LOCK TABLES `picturetags` WRITE;
/*!40000 ALTER TABLE `picturetags`
  DISABLE KEYS */;
INSERT INTO `picturetags` VALUES (6, 27, 1), (7, 28, 3), (8, 29, 2);
/*!40000 ALTER TABLE `picturetags`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tags` (
  `tagId`   INT(11)     NOT NULL AUTO_INCREMENT,
  `tagName` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`tagId`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags`
  DISABLE KEYS */;
INSERT INTO `tags` VALUES (1, 'other'), (2, 'girls'), (3, 'cars');
/*!40000 ALTER TABLE `tags`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userId`            INT(11)     NOT NULL AUTO_INCREMENT,
  `confirmationToken` VARCHAR(255)         DEFAULT NULL,
  `nickName`          VARCHAR(50) NOT NULL,
  `password`          VARCHAR(50) NOT NULL,
  `passwordSalt`      VARCHAR(255)         DEFAULT NULL,
  `rolesString`       VARCHAR(255)         DEFAULT NULL,
  `username`          VARCHAR(50) NOT NULL,
  PRIMARY KEY (`userId`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users`
  DISABLE KEYS */;
INSERT INTO `users` VALUES
  (1, NULL, 'Tepatel in Instagram', '10d2bfaf1a65873242a38c2c9629946f', 'KKezJ6XQQd', 'ROLE_USER,ROLE_ADMIN',
   'tepatel@wiley.com'),
  (7, NULL, 'Mikhail', '76beb336c30c95bf2f512dabe6a5b90f', 'qIZzeZsKqS', 'ROLE_USER', 'mikhailasadchy@gmail.com');
/*!40000 ALTER TABLE `users`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usersdialogs`
--

DROP TABLE IF EXISTS `usersdialogs`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usersdialogs` (
  `userDilogId` INT(11) NOT NULL AUTO_INCREMENT,
  `dialogId`    INT(11)          DEFAULT NULL,
  `userId`      INT(11)          DEFAULT NULL,
  PRIMARY KEY (`userDilogId`),
  KEY `FKDB2CC52314F5E59F` (`dialogId`),
  KEY `FKDB2CC523F989E1BA` (`userId`),
  CONSTRAINT `FKDB2CC52314F5E59F` FOREIGN KEY (`dialogId`) REFERENCES `dialog` (`dialogId`)
    ON DELETE CASCADE,
  CONSTRAINT `FKDB2CC523F989E1BA` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 14
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usersdialogs`
--

LOCK TABLES `usersdialogs` WRITE;
/*!40000 ALTER TABLE `usersdialogs`
  DISABLE KEYS */;
INSERT INTO `usersdialogs` VALUES (12, 10, 1), (13, 10, 7);
/*!40000 ALTER TABLE `usersdialogs`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `votes`
--

DROP TABLE IF EXISTS `votes`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `votes` (
  `voteId`    INT(11) NOT NULL AUTO_INCREMENT,
  `pictureId` INT(11)          DEFAULT NULL,
  `userId`    INT(11)          DEFAULT NULL,
  PRIMARY KEY (`voteId`),
  KEY `FK4F01AA9E693B505` (`pictureId`),
  KEY `FK4F01AA9F989E1BA` (`userId`),
  CONSTRAINT `FK4F01AA9E693B505` FOREIGN KEY (`pictureId`) REFERENCES `images` (`imageId`)
    ON DELETE CASCADE,
  CONSTRAINT `FK4F01AA9F989E1BA` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 18
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `votes`
--

LOCK TABLES `votes` WRITE;
/*!40000 ALTER TABLE `votes`
  DISABLE KEYS */;
INSERT INTO `votes`
VALUES (9, 27, 7), (10, 28, 7), (11, 29, 7), (12, 27, 1), (13, 30, 1), (14, 31, 1), (16, 28, 1), (17, 29, 1);
/*!40000 ALTER TABLE `votes`
  ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2016-10-04 16:33:05
