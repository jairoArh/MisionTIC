-- MySQL dump 10.19  Distrib 10.3.29-MariaDB, for debian-linux-gnueabihf (armv7l)
--
-- Host: localhost    Database: bills
-- ------------------------------------------------------
-- Server version	10.3.29-MariaDB-0+deb10u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `BILL`
--

DROP TABLE IF EXISTS `BILL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BILL` (
  `number` varchar(10) NOT NULL,
  `date` date NOT NULL,
  `type_pay` enum('E','C') NOT NULL,
  `CUSTOMER_nit` varchar(10) NOT NULL,
  PRIMARY KEY (`number`),
  KEY `fk_BILL_CUSTOMER_idx` (`CUSTOMER_nit`),
  CONSTRAINT `fk_BILL_CUSTOMER` FOREIGN KEY (`CUSTOMER_nit`) REFERENCES `CUSTOMER` (`nit`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BILL`
--

LOCK TABLES `BILL` WRITE;
/*!40000 ALTER TABLE `BILL` DISABLE KEYS */;
INSERT INTO `BILL` VALUES ('12345','2019-11-22','E','1234567'),('12346','2018-10-28','C','1234567'),('12347','2021-01-05','C','1234567'),('12348','2021-04-15','E','7654321'),('12349','2021-04-01','E','7654321');
/*!40000 ALTER TABLE `BILL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER`
--

DROP TABLE IF EXISTS `CUSTOMER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMER` (
  `nit` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `min_residue` int(11) NOT NULL,
  `city` varchar(30) NOT NULL,
  `phone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`nit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER`
--

LOCK TABLES `CUSTOMER` WRITE;
/*!40000 ALTER TABLE `CUSTOMER` DISABLE KEYS */;
INSERT INTO `CUSTOMER` VALUES ('1234567','Ana Catalina','Rojas Gutiérrez',200000,'Bogotá D.C.','3003057890'),('24680','Diana María','Restrepo Arroyave',1500000,'Medellín','3208927821'),('7654321','Juan Camilo','Pérez Buitrago',500000,'Sogamoso','3134648890');
/*!40000 ALTER TABLE `CUSTOMER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DETAIL`
--

DROP TABLE IF EXISTS `DETAIL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DETAIL` (
  `idDETAIL` int(11) NOT NULL AUTO_INCREMENT,
  `cant` smallint(6) NOT NULL,
  `BILL_number` varchar(10) NOT NULL,
  `PRODUCT_code` varchar(10) NOT NULL,
  PRIMARY KEY (`idDETAIL`),
  KEY `fk_DETAIL_BILL1_idx` (`BILL_number`),
  KEY `fk_DETAIL_PRODUCT1_idx` (`PRODUCT_code`),
  CONSTRAINT `fk_DETAIL_BILL1` FOREIGN KEY (`BILL_number`) REFERENCES `BILL` (`number`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DETAIL_PRODUCT1` FOREIGN KEY (`PRODUCT_code`) REFERENCES `PRODUCT` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DETAIL`
--

LOCK TABLES `DETAIL` WRITE;
/*!40000 ALTER TABLE `DETAIL` DISABLE KEYS */;
INSERT INTO `DETAIL` VALUES (1,2,'12349','PRD005'),(2,1,'12349','PRD001'),(3,3,'12349','PRD002'),(4,2,'12345','PRD010'),(5,5,'12345','PRD006'),(6,1,'12345','PRD001'),(7,1,'12345','PRD009'),(8,2,'12345','PRD004'),(9,3,'12345','PRD003'),(10,3,'12346','PRD005'),(11,1,'12346','PRD007'),(12,1,'12347','PRD008'),(13,1,'12347','PRD009'),(14,2,'12347','PRD010'),(15,1,'12348','PRD010'),(16,1,'12348','PRD001'),(17,1,'12348','PRD009'),(18,3,'12348','PRD003'),(19,7,'12348','PRD006');
/*!40000 ALTER TABLE `DETAIL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCT`
--

DROP TABLE IF EXISTS `PRODUCT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCT` (
  `code` varchar(10) NOT NULL,
  `description` varchar(45) NOT NULL,
  `value` decimal(10,2) NOT NULL,
  `stock` smallint(6) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCT`
--

LOCK TABLES `PRODUCT` WRITE;
/*!40000 ALTER TABLE `PRODUCT` DISABLE KEYS */;
INSERT INTO `PRODUCT` VALUES ('PRD001','Arroz x 25Kg',37500.00,123),('PRD002','Leche en Polvo  x 750Kg',19800.00,250),('PRD003','Panela x 6 Und',7500.00,90),('PRD004','Café x 500 grm',4000.00,178),('PRD005','Chocolate Libra Corona',6000.00,278),('PRD006','Pasta Doria',3200.00,420),('PRD007','Salsa de Tomate Fruco',12200.00,34),('PRD008','Aceite de Oliva',17500.00,42),('PRD009','Aceite Gourmet x 3 Ltr',47500.00,71),('PRD010','Libra de Sal',2500.00,171);
/*!40000 ALTER TABLE `PRODUCT` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-20 21:44:53
