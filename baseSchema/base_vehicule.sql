-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: base
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehicule` (
  `matricule` varchar(10) NOT NULL,
  `marque` varchar(45) NOT NULL,
  `modele` varchar(45) NOT NULL,
  `puissance` varchar(45) NOT NULL,
  `prix_jour` int(11) NOT NULL,
  `penalisation_jour` int(11) NOT NULL,
  `assurance` varchar(45) NOT NULL,
  `visite` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `capacite` int(11) DEFAULT NULL,
  `nbPlace` int(11) DEFAULT NULL,
  `disponibilite` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicule`
--

LOCK TABLES `vehicule` WRITE;
/*!40000 ALTER TABLE `vehicule` DISABLE KEYS */;
INSERT INTO `vehicule` VALUES ('10tun14','10','10','10',10,10,'2018-12-29','2018-12-26','',10,NULL,NULL),('120tun1200','11100','1','111',10,1,'2018-12-19','2018-12-19','camion',1000,NULL,'Non disponible'),('140tun1874','ford','fiesta','5cv',90,40,'2019-06-06','2019-07-18','voiture',NULL,NULL,'Non disponible'),('166tun5896','renaut','r15','10cv',250,200,'2018-12-27','2018-12-18','',2,NULL,'Non disponible'),('17tun73','17','tunis','17',17,100,'2018-12-28','2018-12-13','camion',17,NULL,NULL),('1tun1','1','1','1',1,1,'2018-12-27','2018-12-28','',1,NULL,NULL),('22tun27','22','22','22',22,22,'2018-12-29','2018-12-14','camion',22,NULL,NULL);
/*!40000 ALTER TABLE `vehicule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-12 13:04:06
