/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50519
 Source Host           : localhost:3306
 Source Schema         : yiyuan

 Target Server Type    : MySQL
 Target Server Version : 50519
 File Encoding         : 65001

 Date: 28/11/2022 23:57:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for geren
-- ----------------------------
DROP TABLE IF EXISTS `geren`;
CREATE TABLE `geren`  (
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of geren
-- ----------------------------
INSERT INTO `geren` VALUES ('1', '1', '1');
INSERT INTO `geren` VALUES ('10086', '小刚 ', '1');
INSERT INTO `geren` VALUES ('6', '6', '6');

-- ----------------------------
-- Table structure for huanzhe
-- ----------------------------
DROP TABLE IF EXISTS `huanzhe`;
CREATE TABLE `huanzhe`  (
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dh` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(10) NULL DEFAULT NULL,
  `jtdz` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of huanzhe
-- ----------------------------
INSERT INTO `huanzhe` VALUES ('小刚', '男', '0001', '10020', 19, '深圳');
INSERT INTO `huanzhe` VALUES ('小马', '男', '0002', '10021', 19, '香港');
INSERT INTO `huanzhe` VALUES ('小玲', '女', '0003', '10023', 18, '广州');
INSERT INTO `huanzhe` VALUES ('小香', '女', '0004', '100021', 19, '南京');

-- ----------------------------
-- Table structure for kanbing
-- ----------------------------
DROP TABLE IF EXISTS `kanbing`;
CREATE TABLE `kanbing`  (
  `h_id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `y_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ypm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `feiyong` int(11) NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `bk` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病况',
  PRIMARY KEY (`h_id`, `y_id`) USING BTREE,
  INDEX `pk_y_id`(`y_id`) USING BTREE,
  CONSTRAINT `pk_h_id` FOREIGN KEY (`h_id`) REFERENCES `huanzhe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pk_y_id` FOREIGN KEY (`y_id`) REFERENCES `yaopin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kanbing
-- ----------------------------
INSERT INTO `kanbing` VALUES ('0001', '0002', '12', 12, 12, '12');
INSERT INTO `kanbing` VALUES ('0002', '0001', '感冒灵', 2, 23, '感冒');
INSERT INTO `kanbing` VALUES ('0002', '0002', '安眠药', 12, 11, '失眠');
INSERT INTO `kanbing` VALUES ('0003', '0001', '感冒灵', 12, 120, '感冒');
INSERT INTO `kanbing` VALUES ('0003', '0002', '止痛药', 12, 12, '摔伤');

-- ----------------------------
-- Table structure for yaopin
-- ----------------------------
DROP TABLE IF EXISTS `yaopin`;
CREATE TABLE `yaopin`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `scrq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bzq` int(11) NULL DEFAULT NULL,
  `jhqd` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of yaopin
-- ----------------------------
INSERT INTO `yaopin` VALUES ('0001', '感冒灵', 23, '2021年6月12日', 21, '河南郑州');
INSERT INTO `yaopin` VALUES ('0002', '安眠药', 30, '2021年6月10日', 30, '河南开封');
INSERT INTO `yaopin` VALUES ('0003', '止痛药', 39, '2021年6月12日', 39, '河南禹州');

-- ----------------------------
-- Table structure for yisheng
-- ----------------------------
DROP TABLE IF EXISTS `yisheng`;
CREATE TABLE `yisheng`  (
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dh` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jtdz` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of yisheng
-- ----------------------------
INSERT INTO `yisheng` VALUES ('张三', '男', '0001', '10010', '儿科', '河南禹州');
INSERT INTO `yisheng` VALUES ('小红', '女', '0002', '10012', '妇科', '河南郑州');
INSERT INTO `yisheng` VALUES ('小明', '男', '0003', '10013', '急诊科', '北京');
INSERT INTO `yisheng` VALUES ('小兰', '女', '0004', '10014', '外科', '上海');

SET FOREIGN_KEY_CHECKS = 1;
