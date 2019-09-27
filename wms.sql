/*
Navicat MySQL Data Transfer

Source Server         : kzh
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : wms

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2019-09-27 17:07:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for t_borrower
-- ----------------------------
DROP TABLE IF EXISTS `t_borrower`;
CREATE TABLE `t_borrower` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_borrower
-- ----------------------------

-- ----------------------------
-- Table structure for t_borrowform
-- ----------------------------
DROP TABLE IF EXISTS `t_borrowform`;
CREATE TABLE `t_borrowform` (
  `id` int(11) NOT NULL,
  `delivery_date` datetime DEFAULT NULL,
  `expect_date` datetime DEFAULT NULL,
  `product_num` int(11) DEFAULT NULL,
  `repay_date` datetime DEFAULT NULL,
  `borrower` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKctbhgrlbmro6qw50y7l9ch7e7` (`borrower`),
  KEY `FKbklxxoynarecfhtnq6mhbradx` (`product_id`),
  KEY `FKlsmdehnw0hjn1f0x0ssg4i53c` (`staff_id`),
  CONSTRAINT `FKbklxxoynarecfhtnq6mhbradx` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`),
  CONSTRAINT `FKctbhgrlbmro6qw50y7l9ch7e7` FOREIGN KEY (`borrower`) REFERENCES `t_borrower` (`id`),
  CONSTRAINT `FKlsmdehnw0hjn1f0x0ssg4i53c` FOREIGN KEY (`staff_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_borrowform
-- ----------------------------

-- ----------------------------
-- Table structure for t_deliveryform
-- ----------------------------
DROP TABLE IF EXISTS `t_deliveryform`;
CREATE TABLE `t_deliveryform` (
  `id` int(11) NOT NULL,
  `delivery_date` datetime DEFAULT NULL,
  `product_num` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqrrru6oqbo3jayrcn20vi9wro` (`product_id`),
  KEY `FKcois8jafbk1h0lv0q32vcqkta` (`staff_id`),
  CONSTRAINT `FKcois8jafbk1h0lv0q32vcqkta` FOREIGN KEY (`staff_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKqrrru6oqbo3jayrcn20vi9wro` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_deliveryform
-- ----------------------------

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_product
-- ----------------------------

-- ----------------------------
-- Table structure for t_stockfrom
-- ----------------------------
DROP TABLE IF EXISTS `t_stockfrom`;
CREATE TABLE `t_stockfrom` (
  `id` int(11) NOT NULL,
  `product_num` int(11) DEFAULT NULL,
  `stock_date` datetime DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqrhfkwi3bbd9gyon4rxdaq7iw` (`product_id`),
  KEY `FKsdthlvhiach8roha4aaxxri7v` (`staff_id`),
  CONSTRAINT `FKqrhfkwi3bbd9gyon4rxdaq7iw` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`),
  CONSTRAINT `FKsdthlvhiach8roha4aaxxri7v` FOREIGN KEY (`staff_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_stockfrom
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for t_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse`;
CREATE TABLE `t_warehouse` (
  `id` int(11) NOT NULL,
  `product_num` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7ivmip0404jyf61xyf57r5x09` (`product_id`),
  CONSTRAINT `FK7ivmip0404jyf61xyf57r5x09` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_warehouse
-- ----------------------------
