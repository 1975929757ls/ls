/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.26 : Database - clothes
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`clothes` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `clothes`;

/*Table structure for table `ask` */

DROP TABLE IF EXISTS `ask`;

CREATE TABLE `ask` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `reply` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bid` (`bid`),
  KEY `cid` (`cid`),
  CONSTRAINT `ask_ibfk_1` FOREIGN KEY (`bid`) REFERENCES `business` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ask_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `chat` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `ask` */

insert  into `ask`(`id`,`bid`,`cid`,`reply`) values (1,1,1,'已修改'),(2,1,2,'修改完成'),(3,1,6,'已经制作不可修改'),(4,1,3,'修改完成');

/*Table structure for table `buliao` */

DROP TABLE IF EXISTS `buliao`;

CREATE TABLE `buliao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `materials` varchar(255) DEFAULT NULL,
  `price` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `buliao` */

insert  into `buliao`(`id`,`materials`,`price`) values (1,'麻布',100),(2,'棉布',150),(3,'丝绸',200),(4,'皮革',100),(5,'仿皮毛',100),(6,'呢绒',80),(7,'亚麻',80),(8,'磁性印花',150),(9,'混纺',220);

/*Table structure for table `business` */

DROP TABLE IF EXISTS `business`;

CREATE TABLE `business` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `business` */

insert  into `business`(`id`,`name`,`password`) values (1,'admin','admin'),(2,'business','admin');

/*Table structure for table `chat` */

DROP TABLE IF EXISTS `chat`;

CREATE TABLE `chat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info` varchar(500) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  CONSTRAINT `chat_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `chat` */

insert  into `chat`(`id`,`info`,`cid`) values (1,'将ID为1的订单尺寸改为xl',1),(2,'ID为20的订单布料改为皮革',1),(3,'修改订单37为宽松版',1),(6,'修改订单1的风格为日韩',1),(7,'修改订单4为欧美风格',1);

/*Table structure for table `coat` */

DROP TABLE IF EXISTS `coat`;

CREATE TABLE `coat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `overcoat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `coat` */

insert  into `coat`(`id`,`overcoat`) values (1,'夏季防嗮'),(2,'春秋薄款'),(3,'羽绒服'),(4,'夹克');

/*Table structure for table `color` */

DROP TABLE IF EXISTS `color`;

CREATE TABLE `color` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `colors` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `color` */

insert  into `color`(`id`,`colors`) values (1,'白色'),(2,'黑色'),(3,'红色'),(4,'黄色'),(5,'灰色'),(6,'蓝色'),(7,'紫色'),(8,'淡蓝'),(9,'海蓝');

/*Table structure for table `kuzi` */

DROP TABLE IF EXISTS `kuzi`;

CREATE TABLE `kuzi` (
  `buliao` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `size` varchar(50) DEFAULT NULL,
  `length` varchar(50) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `kuzi` */

/*Table structure for table `ordergoods` */

DROP TABLE IF EXISTS `ordergoods`;

CREATE TABLE `ordergoods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(255) DEFAULT NULL,
  `cid` int(255) DEFAULT NULL,
  `sid` int(255) DEFAULT NULL,
  `uid` int(255) DEFAULT NULL,
  `clothes` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT '未提交',
  `make` varchar(255) DEFAULT '未制作',
  `remarks` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bid` (`bid`),
  KEY `sid` (`sid`),
  KEY `cid` (`cid`),
  KEY `order_ibfk_6` (`uid`),
  CONSTRAINT `ordergoods_ibfk_2` FOREIGN KEY (`bid`) REFERENCES `buliao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ordergoods_ibfk_4` FOREIGN KEY (`sid`) REFERENCES `style` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ordergoods_ibfk_5` FOREIGN KEY (`cid`) REFERENCES `color` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ordergoods_ibfk_6` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `ordergoods` */

insert  into `ordergoods`(`id`,`bid`,`cid`,`sid`,`uid`,`clothes`,`size`,`state`,`make`,`remarks`,`sex`) values (1,1,1,1,1,'裤子','XL','已提交','未制作','宽松','男'),(2,2,2,2,1,'夏季防晒','XL','已提交','已制作',NULL,'男'),(3,3,4,4,1,'短裤','M','已提交','已制作',NULL,'女'),(4,6,2,1,1,'长裤','XL','已提交','已制作','宽松，印花','男'),(5,2,2,2,1,'春秋薄款','L','未提交','未制作','修身','男'),(6,3,4,2,1,'春秋薄款','XXL','已提交','未制作','小雏菊,修身','男'),(7,3,1,2,1,'短裤','L','已提交','未制作','','男'),(8,4,1,2,1,'短裤','L','已提交','未制作','','男'),(9,9,5,1,2,'夏季防晒外套','XL','未提交','未制作','修身','男'),(10,3,5,1,3,'羽绒服','XL','未提交','未制作','修身','男'),(13,2,1,1,1,'春秋薄款','M','已提交','未制作','','女'),(14,2,2,3,1,'春秋薄款','S','未提交','未制作','','男'),(15,3,1,1,1,'春秋薄款','XL','已提交','已制作','','男'),(18,3,2,3,1,'夹克','M','未提交','未制作','','男'),(19,3,2,1,1,'短裤','XL','未提交','未制作','','男'),(20,3,1,5,1,'春秋薄款','S','未提交','未制作','','女'),(21,2,2,2,1,'春秋薄款','M','未提交','未制作','','男');

/*Table structure for table `pants` */

DROP TABLE IF EXISTS `pants`;

CREATE TABLE `pants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trousers` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `pants` */

insert  into `pants`(`id`,`trousers`) values (1,'长裤'),(2,'短裤'),(3,'长裙'),(4,'短裙');

/*Table structure for table `picture` */

DROP TABLE IF EXISTS `picture`;

CREATE TABLE `picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `src` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `picture` */

insert  into `picture`(`id`,`src`,`info`) values (1,'D:\\files\\pic\\03.jpg','女士长裙，修身'),(2,'D:\\files\\pic\\20200426020_SH4781.jpg','男士，工装，混纺'),(3,'D:\\files\\pic\\CottonJacket_DownJacket_2020042014_sh5278.jpg','女士，工装，超短裙'),(4,'D:\\files\\pic\\20200426015_SH4781.jpg','男士，高领毛衣，纯棉'),(5,'D:\\files\\pic\\20200426015_SH4.jpg','男士，破洞，亚麻，非主流'),(6,'D:\\files\\pic\\20200426015_SH4732.jpg','女士，长裤，修身，呢绒'),(7,'D:\\files\\pic\\20200305021_SH4781.jpg','男士，非主流，工装'),(8,'D:\\files\\pic\\qunzi.jpg','女士，超短裙，丝绸'),(9,'D:\\files\\pic\\20200117_SH5126026.jpg','女士，修身，印花'),(10,'D:\\files\\pic\\CottonJacket_DownJacket_2020042005_sh5278.jpg','女士外套，非主流，混纺'),(30,'D:\\files\\pic\\20200305003_SH4781.jpg','男士短裤，工装，混纺'),(35,'D:\\files\\pic\\20191016006_SH4781.jpg','演示1');

/*Table structure for table `price` */

DROP TABLE IF EXISTS `price`;

CREATE TABLE `price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` int(255) DEFAULT NULL,
  `bid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bid` (`bid`),
  CONSTRAINT `price_ibfk_1` FOREIGN KEY (`bid`) REFERENCES `buliao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `price` */

insert  into `price`(`id`,`price`,`bid`) values (1,100,1),(2,200,2);

/*Table structure for table `style` */

DROP TABLE IF EXISTS `style`;

CREATE TABLE `style` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `styles` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `style` */

insert  into `style`(`id`,`styles`) values (1,'欧美'),(2,'日韩'),(3,'ins潮'),(4,'工装'),(5,'潮流'),(6,'港风'),(7,'韩版'),(8,'休闲'),(9,'网红');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`phone`,`email`) values (1,'mf','1234','13372788801','1975929766@qq.com'),(2,'mike','1234','18791296116','1975929778@qq.com'),(3,'leijing','1234','18292226891','1975929775@qq.com'),(4,'李立','123456','15777244465','1975929759@qq.com'),(5,'黎明','1234','16498786654','1975929737@qq.com'),(6,'王明','123456','18882726601','1975929747@qq.com'),(7,'王琦','123456','17782786691','1975929777@qq.com'),(8,'admin','1234','15029056659','1975929957@qq.com'),(9,'lss','1234','15029056658','1975929057@qq.com'),(10,'wll','admin','15029056678','1975929657@qq.com'),(11,'tim','1234','17782786601','1975929157@qq.com'),(12,'pw','1234','14309877765','1975929737@qq.com'),(13,'wang','1234','15777544065','1975929747@qq.com'),(14,'ly','1234','17782786601','1975929707@qq.com'),(16,'lei','123456','17782786690','1975929777@qq.com'),(17,'first','123456','13729056659','1975929757@qq.com'),(18,'lyz','1234','13799800021','1975929757@qq.com'),(19,'lrr','1234','13777899901','18791299@qq.com'),(20,'tom','admin','13777296980','19759297575@qq.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
