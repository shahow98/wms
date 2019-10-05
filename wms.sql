/*
Navicat MySQL Data Transfer

Source Server         : kzh
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : wms

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-10-05 23:01:45
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
INSERT INTO `hibernate_sequence` VALUES ('26');
INSERT INTO `hibernate_sequence` VALUES ('26');
INSERT INTO `hibernate_sequence` VALUES ('26');
INSERT INTO `hibernate_sequence` VALUES ('26');
INSERT INTO `hibernate_sequence` VALUES ('26');
INSERT INTO `hibernate_sequence` VALUES ('26');
INSERT INTO `hibernate_sequence` VALUES ('26');

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
INSERT INTO `t_borrower` VALUES ('18', 'k', '123456');
INSERT INTO `t_borrower` VALUES ('25', 'h', '12314124');

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
  `product_id` int(11) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `borrower_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbklxxoynarecfhtnq6mhbradx` (`product_id`),
  KEY `FKlsmdehnw0hjn1f0x0ssg4i53c` (`staff_id`),
  KEY `FKp8ui9hghd6vnkycpx59hiusxo` (`borrower_id`),
  CONSTRAINT `FKbklxxoynarecfhtnq6mhbradx` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`),
  CONSTRAINT `FKlsmdehnw0hjn1f0x0ssg4i53c` FOREIGN KEY (`staff_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKp8ui9hghd6vnkycpx59hiusxo` FOREIGN KEY (`borrower_id`) REFERENCES `t_borrower` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_borrowform
-- ----------------------------
INSERT INTO `t_borrowform` VALUES ('19', '2019-10-03 12:34:59', '2019-10-09 16:00:00', '1', '2019-10-04 14:44:27', '6', '1', '18', '3');
INSERT INTO `t_borrowform` VALUES ('20', '2019-10-04 15:30:22', '2019-10-04 15:30:25', '1', null, '6', '1', '18', '4');

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
INSERT INTO `t_deliveryform` VALUES ('13', '2019-10-01 14:10:43', '1', '6', '1');

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
INSERT INTO `t_product` VALUES ('6', null, '苹果');
INSERT INTO `t_product` VALUES ('11', null, 'asd');
INSERT INTO `t_product` VALUES ('15', null, '菠萝');
INSERT INTO `t_product` VALUES ('22', null, '火龙果');

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
INSERT INTO `t_stockfrom` VALUES ('9', '6', '2019-10-01 02:49:08', '6', '1');
INSERT INTO `t_stockfrom` VALUES ('14', '12', '2019-10-01 14:13:29', '6', '1');
INSERT INTO `t_stockfrom` VALUES ('16', '12', '2019-10-01 14:14:01', '15', '1');

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
INSERT INTO `t_user` VALUES ('1', 'kint', 'yyy');
INSERT INTO `t_user` VALUES ('5', '科学', '123');
INSERT INTO `t_user` VALUES ('24', 'root', '123456');

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
INSERT INTO `t_warehouse` VALUES ('10', '17', '6');
INSERT INTO `t_warehouse` VALUES ('17', '12', '15');
INSERT INTO `t_warehouse` VALUES ('23', '0', '22');
