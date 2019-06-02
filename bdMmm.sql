-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: recetas
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `gustostabla`
--

DROP TABLE IF EXISTS `gustostabla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gustostabla` (
  `gusto` varchar(40) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  KEY `gustostabla_ibfk_1` (`usuario`),
  CONSTRAINT `gustostabla_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`Nombre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gustostabla`
--

LOCK TABLES `gustostabla` WRITE;
/*!40000 ALTER TABLE `gustostabla` DISABLE KEYS */;
INSERT INTO `gustostabla` VALUES ('PASTA','currupipi'),('ENSALADA','eleonorrigbi'),('PASTA','eleonorrigbi'),('ENSALADA','kurluka'),('PASTA','pepinnodemar'),('PASTA','freddyKru');
/*!40000 ALTER TABLE `gustostabla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta_plato`
--

DROP TABLE IF EXISTS `receta_plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `receta_plato` (
  `nombrePlato` varchar(70) NOT NULL,
  `ingredientes` varchar(200) NOT NULL,
  `tipo_gusto` varchar(45) NOT NULL,
  `num_personas` varchar(2) NOT NULL,
  `tiempo_coc` varchar(10) NOT NULL,
  `pasos` varchar(200) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  KEY `receta_plato_ibfk_1` (`usuario`),
  CONSTRAINT `receta_plato_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`Nombre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta_plato`
--

LOCK TABLES `receta_plato` WRITE;
/*!40000 ALTER TABLE `receta_plato` DISABLE KEYS */;
INSERT INTO `receta_plato` VALUES ('colacao','leche y colacao','BEBIDA','1','2:0','beberlo','jonymoney'),('papas con huevos camperitos','papas y huevos camperos','BEBIDA','1','0:20','comerlo','jonymoney'),('gazpacho','tomate-4gr.\n','ENSALADA\n','3','04:00','para el verano','freddyKru'),('','','CÓCTELES\n','0','00:00','','jonymoney');
/*!40000 ALTER TABLE `receta_plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `Nombre` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  PRIMARY KEY (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('a@aaa.es','aaaaaa','ssssss'),('aaa@aaa.es','aaaaaa','ssssss'),('currupipi','11111111','curru@.es'),('eleonorrigbi','11111111','elo'),('freddyKru','11111111','krukru'),('jonymoney','11111111','jm@hotmail.es'),('keithrichard','asdwewef','23231'),('kurluka','gggggggg','232412'),('pepinnodemar','huesitos','4565463'),('sdfsdfsdf','asdsdsd','sdfsdfsdf');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-02 23:42:20
