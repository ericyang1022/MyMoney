-- MySQL dump 10.11
--
-- Host: localhost    Database: mymoney
-- ------------------------------------------------------
-- Server version	5.0.67

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `Account` (
  `ACCOUNT_ID` bigint(20) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `shortName` varchar(255) default NULL,
  `accountNum` varchar(255) default NULL,
  `notes` varchar(255) default NULL,
  `amount` decimal(19,2) default NULL,
  `currency` varchar(255) default NULL,
  PRIMARY KEY  (`ACCOUNT_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `Account`
--

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;
INSERT INTO `Account` VALUES (1,'Chase Checking Account','Chase','1234-5678','Main checking account','0.00','USD'),(2,'Discover Card','Discover','1234-5678-9012-3456','','0.00','USD'),(3,'Bank of America Visa','Visa','2222-4444-6666-8888','','0.00','USD');
/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Transaction`
--

DROP TABLE IF EXISTS `Transaction`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `Transaction` (
  `TRANSACTION_ID` bigint(20) NOT NULL auto_increment,
  `account_id` bigint(20) NOT NULL,
  `category` varchar(255) default NULL,
  `subCategory` varchar(255) default NULL,
  `description` varchar(255) default NULL,
  `payee` varchar(255) default NULL,
  `amount` decimal(19,2) default NULL,
  `currency` varchar(255) default NULL,
  PRIMARY KEY  (`TRANSACTION_ID`),
  KEY `FKE30A7ABE14A47A2E` (`account_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `Transaction`
--

LOCK TABLES `Transaction` WRITE;
/*!40000 ALTER TABLE `Transaction` DISABLE KEYS */;
INSERT INTO `Transaction` VALUES (1,1,'Food','Coffee Shops','Breakfast with George','Starbucks','8.50','USD'),(2,1,'Food','Groceries','Weekly shopping','Ralphs','88.20','USD'),(3,1,'Entertainment','Movies','Cinema','Vars Cinema','10.00','USD'),(4,2,'Biils','Utilities','Electricity','PG&E','49.23','USD'),(5,2,'Biils','Utilities','Water','S&T Water','12.34','USD'),(6,3,'Gas & Fuel','Gas','CA Trip','Shell','40.00','USD'),(7,3,'Gas & Fuel','Gas','CA Trip','76','30.00','USD');
/*!40000 ALTER TABLE `Transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-19  6:27:26
