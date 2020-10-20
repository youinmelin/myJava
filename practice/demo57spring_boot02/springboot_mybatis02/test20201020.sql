/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.5.27 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `classname` varchar(255) DEFAULT NULL,
  `monitor_sid` int(11) DEFAULT NULL,
  `masterteacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `class` */

insert  into `class`(`cid`,`classname`,`monitor_sid`,`masterteacher_id`) values (1,'3-4',2,5),(2,'3-1',3,5);

/*Table structure for table `file_msg` */

DROP TABLE IF EXISTS `file_msg`;

CREATE TABLE `file_msg` (
  `msgid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `message` text,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` int(11) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`msgid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `file_msg` */

insert  into `file_msg`(`msgid`,`uid`,`message`,`filename`,`filesize`,`datetime`) values (1,1,'english','english.txt',1,'2020-07-01 11:16:04'),(2,2,'water','water.txt',2,'2020-06-01 11:17:22'),(3,2,'java','java.txt',0,'2020-06-06 11:17:22');

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `uname` varchar(255) DEFAULT NULL,
  `message` text,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `message` */

insert  into `message`(`mid`,`ip`,`uname`,`message`,`date`,`time`) values (1,'1','1','你好','2020-08-05','11:15:04');

/*Table structure for table `students` */

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `students` */

insert  into `students`(`sid`,`name`,`number`,`gender`,`cid`) values (1,'lin',888,'male',1),(2,'nasa',222,'male',1),(3,'lang',111,'male',2);

/*Table structure for table `teachplan` */

DROP TABLE IF EXISTS `teachplan`;

CREATE TABLE `teachplan` (
  `id` varchar(32) NOT NULL,
  `pname` varchar(64) NOT NULL,
  `parentid` varchar(32) NOT NULL COMMENT '树形结构, 上一级节点的id. 0表示根节点',
  `grade` char(1) NOT NULL COMMENT '层级，分为1、2、3级',
  `ptype` char(1) DEFAULT NULL COMMENT '课程类型: 1视频、2文档',
  `description` varchar(500) DEFAULT NULL COMMENT '章节及课程时介绍',
  `timelength` double(5,2) DEFAULT NULL COMMENT '时长，单位分钟',
  `courseid` varchar(32) DEFAULT NULL COMMENT '课程id',
  `orderby` varchar(32) DEFAULT NULL COMMENT '排序字段',
  `status` char(1) NOT NULL COMMENT '状态：未发布、已发布',
  `trylearn` char(1) DEFAULT NULL COMMENT '是否试学',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teachplan` */

insert  into `teachplan`(`id`,`pname`,`parentid`,`grade`,`ptype`,`description`,`timelength`,`courseid`,`orderby`,`status`,`trylearn`) values ('1','Bootstrap开发框架','0','1','0',NULL,NULL,'4028e581617f945f01617f9dabc40000','1','0',NULL),('2','计算机原理','1','2','0','介绍计算机工作原理',NULL,'4028e581617f945f01617f9dabc40000','1','0',NULL),('22','spring cloud与spring boot实战','0','1',NULL,NULL,NULL,'4028e58161bcf7f40161bcf8b77c0000','1','0',NULL),('297e02f7639af61a01639afd3a7b0000','第一节','402885816243d2dd016243f24c040003','2','1',NULL,NULL,'402885816243d2dd016243f24c030002','1','0',NULL),('3','计算机硬件','2','3','1',NULL,10.00,'4028e581617f945f01617f9dabc40000','1','0',NULL),('4','计算机软件','2','3','1',NULL,12.00,'4028e581617f945f01617f9dabc40000','2','0',NULL),('402881e66417407b01641744afc30000','基础知识','4028858162e5d6e00162e5e0227b0000','2',NULL,NULL,NULL,'297e7c7c62b888f00162b8a965510001',NULL,'0',NULL),('402881e66417407b01641744fc650001','入门程序','402881e66417407b01641744afc30000','3','1','入门程序',11.00,'297e7c7c62b888f00162b8a965510001','1','0',NULL),('402881e764034e430164035091a00002','面向对象','4028858162bec7f30162becad8590000','2',NULL,'面向对象',NULL,'297e7c7c62b888f00162b8a7dec20000','3','0',NULL),('402881e764034e4301640351f3d70003','一切皆为对象','402881e764034e430164035091a00002','3','1','一切皆为对象',10.00,'297e7c7c62b888f00162b8a7dec20000','1','0',NULL),('402885816240d276016240f7e5010003','test','0','1',NULL,NULL,NULL,'402885816240d276016240f7e5000002','1','0',NULL),('402885816240d276016241019be70005','ddd','0','1',NULL,NULL,NULL,'402885816240d276016241019be70004','1','0',NULL),('402885816240d2760162410bac010007','ffff','0','1',NULL,NULL,NULL,'402885816240d2760162410bac010006','1','0',NULL),('402885816240d2760162414086a0000b','课程介绍','402885816240d276016240f7e5010003','2','1',NULL,NULL,'402885816240d276016240f7e5000002','1','0',NULL),('402885816240d2760162414102fd000c','如何学习一个项目','402885816240d2760162414086a0000b','3','1',NULL,NULL,'402885816240d276016240f7e5000002','1','0',NULL),('402885816240d2760162416df996000d','我是一个新课时，请点击修改填写正确信息','402885816240d2760162414086a0000b','3',NULL,NULL,NULL,'402885816240d276016240f7e5000002','2','0',NULL),('402885816243d2dd016243f24c040003','第一章','0','1',NULL,NULL,NULL,'402885816243d2dd016243f24c030002','1','0',NULL),('40288581625c7e7301625c8ed6be0001','test001','0','1',NULL,NULL,NULL,'40288581625c7e7301625c8ed6af0000','1','0',NULL),('4028858162bec7f30162becad8590000','test_java基础33','0','1',NULL,NULL,NULL,'297e7c7c62b888f00162b8a7dec20000','1','0',NULL),('4028858162bec7f30162bed26cd70001','java基础3','0','1',NULL,NULL,NULL,'297e7c7c62b8aa9d0162b8ab56ba0001','1','0',NULL),('4028858162bee2020162bee3c9c60000','我是一个新章节，请点击修改填写正确信息','4028858162bec7f30162bed26cd70001','2',NULL,NULL,NULL,'297e7c7c62b8aa9d0162b8ab56ba0001','1','0',NULL),('4028858162bee9e90162beea3f480000','java基础3','0','1',NULL,NULL,NULL,'297e7c7c62b8aa9d0162b8ab70e90002','1','0',NULL),('4028858162bee9e90162beea81690001','我是一个新章节，请点击修改填写正确信息','4028858162bee9e90162beea3f480000','2','1','fdsfds',2.00,'297e7c7c62b8aa9d0162b8ab70e90002','1','1',NULL),('4028858162e0bc0a0162e0bfdf2b0001','人工智能+python','0','1',NULL,NULL,NULL,'4028858162e0bc0a0162e0bfdf1a0000','1','0',NULL),('4028858162e5d6e00162e5e0227b0000','test_java基础2','0','1',NULL,NULL,NULL,'297e7c7c62b888f00162b8a965510001','1','0',NULL),('4028858162e5d6e00162e5e0727d0001','java基础语法','4028858162e5d6e00162e5e0227b0000','2','1',NULL,NULL,'297e7c7c62b888f00162b8a965510001','1','0',NULL),('4028858163012bbf01630136a5140000','java基础3','0','1',NULL,NULL,NULL,'297e7c7c62b8aa9d0162b8ab13910000','1','0',NULL),('40288581632b593e01632bd4ec360000','程序入门','4028858162bec7f30162becad8590000','2','1',NULL,NULL,'297e7c7c62b888f00162b8a7dec20000','1','0',NULL),('40288581632b593e01632bd53ff10001','Hello World','40288581632b593e01632bd4ec360000','3','1',NULL,NULL,'297e7c7c62b888f00162b8a7dec20000','1','0',NULL),('40288581632b593e01632bd597810002','编程基础','4028858162bec7f30162becad8590000','2','1',NULL,NULL,'297e7c7c62b888f00162b8a7dec20000','2','0',NULL),('40288581632b593e01632bd5d31f0003','表达式','40288581632b593e01632bd597810002','3','1',NULL,NULL,'297e7c7c62b888f00162b8a7dec20000','1','0',NULL),('40288581632b593e01632bd606480004','逻辑运算','40288581632b593e01632bd597810002','3','1',NULL,NULL,'297e7c7c62b888f00162b8a7dec20000','2','0',NULL),('402885816347f814016348d68bad0000','数据库基础知识','4028e581617ce7b601617ce801790000','3','1',NULL,NULL,'4028e581617f945f01617f9dabc40000','1','0',NULL),('402885816347f814016348d6c5920001','SQL查询','4028e581617ce7b601617ce801790000','3','1',NULL,NULL,'4028e581617f945f01617f9dabc40000','2','0',NULL),('402885816347f814016348d7153c0002','SQL优化','4028e581617ce7b601617ce801790000','3','1',NULL,NULL,'4028e581617f945f01617f9dabc40000','3','0',NULL),('4028e581617ce7b601617ce801790000','数据库编程','1','2','1','数据库编程数据库编程',11.00,'4028e581617f945f01617f9dabc40000','4','0',NULL),('4028e581617d02e101617d070ed90000','操作系统类型介绍','8','3','1','操作系统类型介绍操作系统类型介绍',11.00,'4028e581617f945f01617f9dabc40000','6','0',NULL),('4028e58161bbcd350161bbcefe3d0001','操作系统原理','8','3','1','操作系统原理操作系统原理操作系统原理操作系统原理',22.00,'4028e581617f945f01617f9dabc40000','6','0',NULL),('4028e58161bd14c20161bd14f1520000','微服务架构入门','22','2',NULL,'微服务架构入门',NULL,'4028e58161bcf7f40161bcf8b77c0000','1-1','0',NULL),('4028e58161bd18ea0161bd1b00ab0000','为什么要使用微服务:单体架构的特点','4028e58161bd14c20161bd14f1520000','3','1','为什么要使用微服务:单体架构的特点',44.00,'4028e58161bcf7f40161bcf8b77c0000','1','0',NULL),('4028e58161bd18ea0161bd1bd2d10001','为什么要使用微服务:微服务的优缺点','4028e58161bd14c20161bd14f1520000','3','1','为什么要使用微服务:微服务的优缺点',55.00,'4028e58161bcf7f40161bcf8b77c0000','2','0',NULL),('4028e58161bd18ea0161bd1c83590002','spring cloud 基础入门','22','2',NULL,'spring cloud 基础入门',NULL,'4028e58161bcf7f40161bcf8b77c0000','2','0',NULL),('4028e58161bd18ea0161bd1cc4850003','实战-Spring Boot','22','2',NULL,'实战-Spring Boot',NULL,'4028e58161bcf7f40161bcf8b77c0000','3','0',NULL),('4028e58161bd18ea0161bd1cf3e10004','注册中心Eureka','22','2',NULL,'注册中心Eureka',55.00,'4028e58161bcf7f40161bcf8b77c0000','4','0',NULL),('4028e58161bd18ea0161bd1d2f3f0005','为什么要选择spring cloud?','4028e58161bd18ea0161bd1c83590002','3','1','为什么要选择spring cloud?',12.00,'4028e58161bcf7f40161bcf8b77c0000','1','0',NULL),('4028e58161bd18ea0161bd1d8f1b0006','为什么springcloud要设计一套新的版本升级规则？','4028e58161bd18ea0161bd1c83590002','3','1','为什么springcloud要设计一套新的版本升级规则？',33.00,'4028e58161bcf7f40161bcf8b77c0000','2','0',NULL),('4028e58161bd18ea0161bd1df0ad0007','为什么越来越多的开发者选择使用spring boot？它解决了什么问题？','4028e58161bd18ea0161bd1cc4850003','3','1','为什么越来越多的开发者选择使用spring boot？它解决了什么问题？',10.00,'4028e58161bcf7f40161bcf8b77c0000','1','0',NULL),('4028e58161bd18ea0161bd1f73190008','spring boot的入门例子','4028e58161bd18ea0161bd1cc4850003','3','1','spring boot的入门例子',44.00,'4028e58161bcf7f40161bcf8b77c0000','2','0',NULL),('4028e58161bd18ea0161bd1fd31c0009','微服务架构为什么需要注册中心，它解决了什么问题？','4028e58161bd18ea0161bd1cf3e10004','3','1','微服务架构为什么需要注册中心，它解决了什么问题？',33.00,'4028e58161bcf7f40161bcf8b77c0000','1','0',NULL),('4028e58161bd18ea0161bd202c45000a',' 一个Eureka注册中心的入门例子','4028e58161bd18ea0161bd1cf3e10004','3','1',' 一个Eureka注册中心的入门例子',22.00,'4028e58161bcf7f40161bcf8b77c0000','2','0',NULL),('4028e58161bd22e60161bd2366fb0000','Javascript之VueJS','0','1',NULL,NULL,NULL,'4028e58161bd22e60161bd23672a0001','1','0',NULL),('4028e58161bd269f0161bd270a340000','Vuejs 第一讲','4028e58161bd22e60161bd2366fb0000','2',NULL,'Vuejs 第一讲',NULL,'4028e58161bd22e60161bd23672a0001','1','0',NULL),('4028e58161bd269f0161bd2778750001','第一节 vue基础、常用指令、bootstrap+vue的简易留言','4028e58161bd269f0161bd270a340000','3','1','第一节 vue基础、常用指令、bootstrap+vue的简易留言',22.00,'4028e58161bd22e60161bd23672a0001','1','0',NULL),('4028e58161bd269f0161bd27d7c50002','第二节 属性和事件、模板、交互、案例','4028e58161bd269f0161bd270a340000','3','1','第二节 属性和事件、模板、交互、案例',33.00,'4028e58161bd22e60161bd23672a0001','2','0',NULL),('4028e58161bd269f0161bd281bde0003','Vuejs 第二讲','4028e58161bd22e60161bd2366fb0000','2',NULL,NULL,NULL,'4028e58161bd22e60161bd23672a0001','2','0',NULL),('4028e58161bd269f0161bd284bad0004','Vuejs 第三讲','4028e58161bd22e60161bd2366fb0000','2',NULL,NULL,NULL,'4028e58161bd22e60161bd23672a0001','3','0',NULL),('4028e58161bd269f0161bd2877740005','第一节 计算属性的使用、vue实例的简单方法、提高循环的性能，让重复数据显示出来','4028e58161bd269f0161bd281bde0003','3',NULL,NULL,NULL,'4028e58161bd22e60161bd23672a0001','1','0',NULL),('4028e58161bd269f0161bd293df90006','第二节 自定义过滤器、自定义指令 、自定义键盘事件、数据的监听','4028e58161bd269f0161bd281bde0003','3','1',NULL,NULL,'4028e58161bd22e60161bd23672a0001','2','0',NULL),('4028e58161bd3b380161bd3bcd400001','Redis从入门到项目实战','0','1',NULL,NULL,NULL,'4028e58161bd3b380161bd3bcd2f0000','1','0',NULL),('4028e58161bd3b380161bd3e47da0003','第一章：redis简介','4028e58161bd3b380161bd3bcd400001','2',NULL,NULL,NULL,'4028e58161bd3b380161bd3bcd2f0000','1','0',NULL),('4028e58161bd3b380161bd3f484c0004','第二章：redis的安装与配置','4028e58161bd3b380161bd3bcd400001','2',NULL,NULL,NULL,'4028e58161bd3b380161bd3bcd2f0000','2','0',NULL),('4028e58161bd3b380161bd3f6f440005','第三章：Redis数据操作','4028e58161bd3b380161bd3bcd400001','2',NULL,NULL,NULL,'4028e58161bd3b380161bd3bcd2f0000','3','0',NULL),('4028e58161bd3b380161bd3fb0050006','第四章：Redis进阶操作','4028e58161bd3b380161bd3bcd400001','2',NULL,NULL,NULL,'4028e58161bd3b380161bd3bcd2f0000','4','0',NULL),('4028e58161bd3b380161bd3fd3420007','第五章：Redis主从配置','4028e58161bd3b380161bd3bcd400001','2',NULL,NULL,NULL,'4028e58161bd3b380161bd3bcd2f0000','5','0',NULL),('4028e58161bd3b380161bd3fe9220008','第一节 NoSQL简介','4028e58161bd3b380161bd3e47da0003','3','1',NULL,NULL,'4028e58161bd3b380161bd3bcd2f0000','1','0',NULL),('4028e58161bd3b380161bd40cf340009','第二节 认识Redis','4028e58161bd3b380161bd3e47da0003','3','1',NULL,NULL,'4028e58161bd3b380161bd3bcd2f0000','2','0',NULL),('5','计算机编程入门','1','2','0',NULL,NULL,'4028e581617f945f01617f9dabc40000','2','0',NULL),('6','java语法介绍','5','3','1',NULL,NULL,'4028e581617f945f01617f9dabc40000','1','0',NULL),('7','Hello World','5','3','1',NULL,NULL,'4028e581617f945f01617f9dabc40000','2','0',NULL),('8','操作系统原理','1','2',NULL,NULL,NULL,'4028e581617f945f01617f9dabc40000','6','0',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`name`,`birthday`) values (1,'zhangsan','123','张三','2020-09-01 00:00:00'),(2,'lisi','123','李四','1980-01-02 00:00:00'),(3,'lin','123','林林',NULL),(4,'nancy','123','南希',NULL);

/*Table structure for table `userentity` */

DROP TABLE IF EXISTS `userentity`;

CREATE TABLE `userentity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `usersex` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `userentity` */

insert  into `userentity`(`id`,`username`,`usersex`) values (1,'Nasa','male');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
