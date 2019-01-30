/*
Navicat MySQL Data Transfer

Source Server         : mysql-3306
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : purchase_record

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-01-17 16:20:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `contacts` varchar(60) NOT NULL DEFAULT '' COMMENT '联系人',
  `phone` varchar(13) DEFAULT '' COMMENT '手机号码',
  `telephone` varchar(13) DEFAULT '' COMMENT '电话号码',
  `address` varchar(255) DEFAULT '' COMMENT '地址',
  `remarks` varchar(255) DEFAULT '' COMMENT '备注',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '1' COMMENT '进货商状态(1正常，0未启动)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `contacts_unique` (`contacts`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供货商';

-- ----------------------------
-- Records of supplier
-- ----------------------------
