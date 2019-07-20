/*
SQLyog Community v12.1 (32 bit)
MySQL - 5.1.37-community : Database - msa_studio
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`msa_studio` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `msa_studio`;

/*Table structure for table `technology_info` */

DROP TABLE IF EXISTS `technology_info`;

CREATE TABLE `technology_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parser` varchar(100) DEFAULT NULL,
  `technology` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `technology_info` */

insert  into `technology_info`(`id`,`parser`,`technology`) values (1,'Spring4Visitor','Spring4_Spring+Rest'),(2,'EJBVisitor','EJB'),(3,'Spring4Visitor','Spring4_Spring+JPA/Hibernate'),(4,'Spring4Visitor','Spring4_JDBCTemplate'),(5,'Struts1Visitor','Struts1.3_Hibernate');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
