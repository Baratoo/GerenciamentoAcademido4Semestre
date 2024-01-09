-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: trabalhointerface
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `idAluno` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `ra` varchar(45) DEFAULT NULL,
  `dataMatricula` date DEFAULT NULL,
  `situacao` varchar(45) DEFAULT NULL,
  `fkEndereco` int DEFAULT NULL,
  `fkCurso` int DEFAULT NULL,
  PRIMARY KEY (`idAluno`),
  KEY `alunoEndereco_idx` (`fkEndereco`),
  KEY `alunoCurso_idx` (`fkCurso`),
  CONSTRAINT `alunoCurso` FOREIGN KEY (`fkCurso`) REFERENCES `curso` (`idCurso`),
  CONSTRAINT `alunoEndereco` FOREIGN KEY (`fkEndereco`) REFERENCES `endereco` (`idEndereco`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'Mateus','123456','@hotmail',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'teste01','123456789','exemplo@hotmail.com','Feminino','2007-05-01','65432','2007-05-01','Em Andamento',4,NULL),(4,'Teste04','123456789','exmeplo@hotmail','Masculino','2004-03-02','321654','2004-03-02','Concuído',5,NULL),(5,'teste123','852741963','mateus@hotmail.com','Masculino','2003-06-02','123456','2003-06-02','Em Andamento',7,2);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-25 11:12:05
