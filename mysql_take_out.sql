/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.20 : Database - testjdbc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`testjdbc` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `testjdbc`;

/*Table structure for table `t_admin` */

CREATE TABLE `t_admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(11) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`id`,`username`,`password`) values 
(1,'admin1','123123'),
(2,'admin2','123123');

/*Table structure for table `t_menu` */

CREATE TABLE `t_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `flavor` varchar(11) DEFAULT NULL,
  `tid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tid` (`tid`),
  CONSTRAINT `t_menu_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `t_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

/*Data for the table `t_menu` */

insert  into `t_menu`(`id`,`name`,`price`,`flavor`,`tid`) values 
(1,'香酥鸡',39,'五香',1),
(2,'烧椒扣肉',46,'微辣',1),
(3,'栗子三杯鸡',56,'五香',1),
(4,'毛血旺',50,'麻辣',1),
(5,'菠菜拌粉丝',22,'五香',2),
(6,'凉拌豆腐皮',19,'微辣',2),
(7,'酱牛肉',36,'麻辣',2),
(8,'鱼头豆腐汤',32,'五香',3),
(9,'瘦肉鸡蛋白菜汤',30,'五香',3),
(10,'西葫芦虾仁蒸饺',26,'五香',4),
(11,'蛋炒饭',18,'五香',4),
(12,'酥粒椰蓉面包',43,'香甜',5);

/*Table structure for table `t_order` */

CREATE TABLE `t_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL,
  `mid` int DEFAULT NULL,
  `aid` int DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `state` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `mid` (`mid`),
  KEY `aid` (`aid`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `t_menu` (`id`),
  CONSTRAINT `t_order_ibfk_3` FOREIGN KEY (`aid`) REFERENCES `t_admin` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`uid`,`mid`,`aid`,`date`,`state`) values 
(2,1,2,1,'2019-02-06 00:00:00',1),
(5,1,5,1,'2019-02-06 00:00:00',1),
(6,1,9,1,'2019-02-06 00:00:00',1),
(16,1,10,1,'2019-02-06 00:00:00',1),
(26,2,8,2,'2019-02-08 00:00:00',1),
(27,2,12,2,'2019-02-08 00:00:00',1),
(41,1,6,NULL,'2020-09-05 00:00:00',0),
(43,1,5,2,'2020-09-06 00:00:00',1),
(45,1,2,NULL,'2020-09-06 00:00:00',0),
(46,1,1,1,'2020-09-06 00:00:00',1),
(47,1,1,2,'2020-09-06 00:00:00',1),
(48,1,1,NULL,'2020-09-06 16:19:33',0),
(49,1,7,2,'2020-09-06 16:23:29',1),
(51,12,1,2,'2020-09-08 01:00:22',1),
(52,12,4,2,'2020-09-08 01:00:24',1),
(54,2,6,NULL,'2020-09-13 19:20:06',0),
(55,2,12,NULL,'2020-09-13 19:20:13',0),
(56,2,11,2,'2020-09-13 19:20:17',1),
(57,2,10,NULL,'2020-09-13 19:20:19',0),
(58,2,11,NULL,'2020-09-13 19:20:23',0),
(59,1,5,NULL,'2020-09-13 20:44:17',0),
(60,1,6,NULL,'2020-09-13 20:44:18',0),
(61,1,7,NULL,'2020-09-13 20:44:20',0);

/*Table structure for table `t_type` */

CREATE TABLE `t_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`name`) values 
(1,'热菜'),
(2,'凉菜'),
(3,'汤羹'),
(4,'主食'),
(5,'烘焙');

/*Table structure for table `t_user` */

CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(11) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  `nickname` varchar(11) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `registerdate` date DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`nickname`,`gender`,`telephone`,`registerdate`,`address`) values 
(1,'zhangsan','123123','张三','男','13576765678','2019-02-03','科技路'),
(2,'lisi','123123','李四','女','18678987676','2019-02-03','胜利北路'),
(12,'wangwu','111111','王五','女','12345678912','2020-09-02','世纪大道');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
