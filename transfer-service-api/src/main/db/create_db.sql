/*
SQLyog Enterprise - MySQL GUI v8.12 
MySQL - 5.6.24-log : Database - ingenico
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`ingenico` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ingenico`;

/*Table structure for table `account` */
DROP TABLE IF EXISTS `transfer`;
DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` varchar(36) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(36) NOT NULL,
  `type` tinyint(4) NOT NULL,
  `balance` bigint(16) NOT NULL,
  `status` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`id`,`created`,`modified`,`name`,`type`,`balance`,`status`) values ('123sd-236sd5-adsf589-asdf87','2018-06-14 11:14:47',NULL,'Account1',0,100000799,1),('123sd-236sd5-adsf589-asdf88','2018-06-14 11:16:18','2018-06-14 11:16:18','Account2',0,88888088,1);

/*Table structure for table `transfer` */

CREATE TABLE `transfer` (
  `id` varchar(36) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `from_account` varchar(36) NOT NULL,
  `to_account` varchar(36) NOT NULL,
  `amount` bigint(16) NOT NULL,
  `transaction_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(4) DEFAULT '0',
  `error` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_transfer_from_account` (`from_account`),
  KEY `fk_transfer_to_account` (`to_account`),
  CONSTRAINT `fk_transfer_from_account` FOREIGN KEY (`from_account`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transfer_to_account` FOREIGN KEY (`to_account`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `transfer` */

insert  into `transfer`(`id`,`created`,`modified`,`from_account`,`to_account`,`amount`,`transaction_date`,`status`,`error`) values ('4028b88163fe1d9e0163fe1f20000001','2018-06-14 17:17:22','2018-06-14 17:49:39','123sd-236sd5-adsf589-asdf88','123sd-236sd5-adsf589-asdf87',100,'2018-06-14 17:17:22',0,'error message1'),('4028b88163fe395c0163fe3a04430000','2018-06-14 17:46:45','2018-06-14 17:49:39','123sd-236sd5-adsf589-asdf88','123sd-236sd5-adsf589-asdf87',100,'2018-06-14 17:46:45',0,'error message1'),('4028b88163fe395c0163fe3db6c60001','2018-06-14 17:50:47',NULL,'123sd-236sd5-adsf589-asdf88','123sd-236sd5-adsf589-asdf87',100,'2018-06-14 17:50:47',0,NULL),('4028b88163fe395c0163fe3dd28c0002','2018-06-14 17:50:54',NULL,'123sd-236sd5-adsf589-asdf88','123sd-236sd5-adsf589-asdf87',100,'2018-06-14 17:50:54',0,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
