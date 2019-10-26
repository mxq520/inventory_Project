/*
 Navicat Premium Data Transfer

 Source Server         : jishitongxun
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 127.0.0.1:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 26/10/2019 20:04:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tt_users
-- ----------------------------
DROP TABLE IF EXISTS `tt_users`;
CREATE TABLE `tt_users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tt_users
-- ----------------------------
INSERT INTO `tt_users` VALUES (1, 'mxq', '123456', 23, '贵州');
INSERT INTO `tt_users` VALUES (2, 'mxq', '123456', 23, '贵州');

SET FOREIGN_KEY_CHECKS = 1;
