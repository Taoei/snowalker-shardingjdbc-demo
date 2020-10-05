/*
 Navicat Premium Data Transfer

 Source Server         : qa
 Source Server Type    : MySQL
 Source Server Version : 50616
 Source Host           : rm-ks-qa.mysql.rds.aliyuncs.com:3306
 Source Schema         : taowei

 Target Server Type    : MySQL
 Target Server Version : 50616
 File Encoding         : 65001

 Date: 25/09/2020 11:33:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user_0000
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0000`;
CREATE TABLE `t_user_0000` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `region_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_0000
-- ----------------------------
BEGIN;
INSERT INTO `t_user_0000` VALUES (1, 110, '表0用户1', 5);
INSERT INTO `t_user_0000` VALUES (2, 120, '表0用户2', 5);
COMMIT;

-- ----------------------------
-- Table structure for t_user_0001
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0001`;
CREATE TABLE `t_user_0001` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `region_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_0001
-- ----------------------------
BEGIN;
INSERT INTO `t_user_0001` VALUES (1, 211, '表1用户1', 1);
INSERT INTO `t_user_0001` VALUES (2, 221, '表1用户2', 1);
COMMIT;

-- ----------------------------
-- Table structure for t_user_0002
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0002`;
CREATE TABLE `t_user_0002` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `region_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_0002
-- ----------------------------
BEGIN;
INSERT INTO `t_user_0002` VALUES (1, 312, '表2用户1', 2);
INSERT INTO `t_user_0002` VALUES (2, 322, '表2用户2', 2);
COMMIT;

-- ----------------------------
-- Table structure for t_user_0003
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0003`;
CREATE TABLE `t_user_0003` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `region_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_0003
-- ----------------------------
BEGIN;
INSERT INTO `t_user_0003` VALUES (1, 413, '表3用户1', 3);
INSERT INTO `t_user_0003` VALUES (2, 423, '表3用户2', 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
