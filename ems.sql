/*
SQLyog Professional v12.09 (64 bit)
MySQL - 10.4.11-MariaDB : Database - ems
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `attendence` */

DROP TABLE IF EXISTS `attendence`;

CREATE TABLE `attendence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `on_leave` tinyint(1) NOT NULL DEFAULT 0,
  `status` tinyint(1) NOT NULL DEFAULT 0,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `attendence` */

/*Table structure for table `documents` */

DROP TABLE IF EXISTS `documents`;

CREATE TABLE `documents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `belong_id` int(11) DEFAULT NULL,
  `belong_name` varchar(50) DEFAULT NULL,
  `original_file_link` varchar(255) DEFAULT NULL,
  `belong_type` enum('image','file') DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `documents` */

insert  into `documents`(`id`,`belong_id`,`belong_name`,`original_file_link`,`belong_type`,`created_at`,`updated_at`) values (1,6,'employee','G:\\\\My Drive\\\\RGB PICS\\\\Font Effects\\\\2-luminous-lines-style-font-effect-180187_720x.jpg','image','2024-12-01 00:31:07','2024-12-01 00:31:07'),(2,7,'employee','G:\\\\My Drive\\\\RGB PICS\\\\Font Bundle\\\\970-fonts-for-designers-bundle-1-785392_720x.jpg','image','2024-12-02 01:47:51','2024-12-02 01:47:51'),(3,8,'employee','G:\\\\My Drive\\\\RGB PICS\\\\Font Bundle\\\\970-fonts-for-designers-bundle-1-785392_720x.jpg','image','2024-12-02 20:30:37','2024-12-02 20:30:37'),(4,9,'employee','G:\\\\My Drive\\\\RGB PICS\\\\Font Bundle\\\\970-fonts-for-designers-bundle-1-785392_720x.jpg','image','2024-12-03 01:10:51','2024-12-03 01:10:51');

/*Table structure for table `employeesdata` */

DROP TABLE IF EXISTS `employeesdata`;

CREATE TABLE `employeesdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `gender` enum('male','female') DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `sent_email` int(1) DEFAULT 0,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `employeesdata` */

insert  into `employeesdata`(`id`,`user_id`,`name`,`email`,`phone`,`gender`,`position`,`sent_email`,`created_at`,`updated_at`) values (8,2,'Adil Shahzad','adil2@gmail.com','0302 60000006','male','Supervisor',0,'2024-12-02 20:30:37','2024-12-02 20:30:37'),(9,1,'Usman','usman@gmail.com','03022103233','male','Supervisor',0,'2024-12-03 01:10:51','2024-12-03 01:10:51'),(10,3,'Faizan','Faizan@mailinator.com','02343432435','male','Manager',0,'2024-12-21 22:48:16','2024-12-21 22:48:16');

/*Table structure for table `leaves` */

DROP TABLE IF EXISTS `leaves`;

CREATE TABLE `leaves` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `leave_type` varchar(50) NOT NULL,
  `leave_date` varchar(50) NOT NULL,
  `reason` text NOT NULL,
  `approved` tinyint(1) DEFAULT 0,
  `reject` tinyint(1) DEFAULT 0,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `leaves` */

insert  into `leaves`(`id`,`employee_id`,`leave_type`,`leave_date`,`reason`,`approved`,`reject`,`created_at`,`updated_at`) values (1,8,'Medical Leave','2024-12-17','asdfgb',1,1,'2024-12-21 12:13:08','2024-12-21 12:13:08'),(2,10,'Casual Leave','2024-12-24','This is the reason for leave',0,1,'2024-12-21 22:49:30','2024-12-21 22:49:30'),(3,8,'Study Leave','2024-12-31','xsdfghjkjhgfdsa',0,0,'2024-12-22 13:14:01','2024-12-22 13:14:01');

/*Table structure for table `notifications` */

DROP TABLE IF EXISTS `notifications`;

CREATE TABLE `notifications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `alerts` varchar(250) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `notifications` */

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `roles` */

insert  into `roles`(`id`,`name`,`created_at`,`updated_at`) values (1,'admin','2024-11-25 00:41:36','2024-11-25 00:41:36'),(2,'employee','2024-11-25 00:41:49','2024-11-25 00:41:49');

/*Table structure for table `salaries_and_taxes` */

DROP TABLE IF EXISTS `salaries_and_taxes`;

CREATE TABLE `salaries_and_taxes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `salary` int(11) NOT NULL DEFAULT 0,
  `salary_increment` int(11) NOT NULL DEFAULT 0,
  `leave_charges` int(11) NOT NULL DEFAULT 0,
  `tax_deduction` int(11) NOT NULL DEFAULT 0,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `salaries_and_taxes` */

insert  into `salaries_and_taxes`(`id`,`employee_id`,`salary`,`salary_increment`,`leave_charges`,`tax_deduction`,`created_at`,`updated_at`) values (1,8,12,0,0,0,'2024-12-03 00:15:58','2024-12-03 00:15:58'),(3,9,30000,0,0,0,'2024-12-22 13:17:25','2024-12-22 13:17:25');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`email`,`role_id`,`created_at`,`updated_at`) values (1,'Usman','usman','usman@mailinator.com',1,'2024-11-25 00:44:57','2024-11-25 00:44:57'),(2,'Adil Shahzad','Adil','adil@mailinator.com',2,'2024-12-13 23:15:02','2024-12-13 23:15:02'),(3,'Faizan','faizan','faizan@mailinator.com',2,'2024-12-21 22:47:07','2024-12-21 22:47:07');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
