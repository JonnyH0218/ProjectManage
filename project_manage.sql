/*
 Navicat Premium Data Transfer

 Source Server         : huangqiang
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : project_manage

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 17/06/2019 10:12:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for download
-- ----------------------------
DROP TABLE IF EXISTS `download`;
CREATE TABLE `download`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of download
-- ----------------------------
INSERT INTO `download` VALUES (1, '项目日志.xlsx', '2019-05-26 17:30:00', '测试项目2');

-- ----------------------------
-- Table structure for p_equipment
-- ----------------------------
DROP TABLE IF EXISTS `p_equipment`;
CREATE TABLE `p_equipment`  (
  `id` int(11) NOT NULL,
  `equipment_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_sketch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_handler_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_handler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `founder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `copySender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for p_equipmentsolution
-- ----------------------------
DROP TABLE IF EXISTS `p_equipmentsolution`;
CREATE TABLE `p_equipmentsolution`  (
  `id` int(11) NOT NULL,
  `equipment_id` int(11) NULL DEFAULT NULL,
  `equipment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_handler_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_handler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `founder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `copySender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for p_flash
-- ----------------------------
DROP TABLE IF EXISTS `p_flash`;
CREATE TABLE `p_flash`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flash_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flash_serialNumber` int(11) NOT NULL,
  `flash_hander` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `founder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flash_handler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for p_image
-- ----------------------------
DROP TABLE IF EXISTS `p_image`;
CREATE TABLE `p_image`  (
  `id` int(11) NOT NULL,
  `record_id` int(11) NULL DEFAULT NULL,
  `problem_id` int(11) NULL DEFAULT NULL,
  `equipment_id` int(11) NULL DEFAULT NULL,
  `equipmentSolution_id` int(11) NULL DEFAULT NULL,
  `imagesUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `imgSHA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attachmentUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attachmentSHA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `productException_id` int(11) NULL DEFAULT NULL,
  `configSystem_id` int(11) NULL DEFAULT NULL,
  `documentUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `documentSHA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `batUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `batSHA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `databaseUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `databaseSHA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `instrument_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for p_message
-- ----------------------------
DROP TABLE IF EXISTS `p_message`;
CREATE TABLE `p_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `actionUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `relationId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `entity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `herfAjax` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `messageRelease_id` int(11) NULL DEFAULT NULL,
  `message_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `founder_check` int(11) NULL DEFAULT NULL,
  `handler_check` int(11) NULL DEFAULT NULL,
  `refuse_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `relationfounder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `message_handler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `founder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `copySender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of p_message
-- ----------------------------
INSERT INTO `p_message` VALUES (1, '黄强新建项目：测试项目3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '2019-05-26 00:28:12', NULL);
INSERT INTO `p_message` VALUES (2, '黄强新建项目：测试项目2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '2019-05-26 00:33:21', NULL);
INSERT INTO `p_message` VALUES (3, '黄强新建项目：测试项目2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '2019-05-26 00:36:58', NULL);
INSERT INTO `p_message` VALUES (4, '黄强添加了项目人员黄强', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-05-26 01:18:25', NULL);
INSERT INTO `p_message` VALUES (5, '黄强添加了项目人员黄强', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-05-26 01:20:03', NULL);
INSERT INTO `p_message` VALUES (6, '黄强添加了项目人员黄强', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-05-26 01:32:23', NULL);
INSERT INTO `p_message` VALUES (7, '黄强提交项目null', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-05-26 14:04:14', NULL);
INSERT INTO `p_message` VALUES (8, '黄强新建项目：答辩测试项目', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-06-02 00:16:43', NULL);
INSERT INTO `p_message` VALUES (9, '黄强发布项目问题:测试项目问题', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-06-02 00:17:46', NULL);
INSERT INTO `p_message` VALUES (10, '黄强解决了测试项目问题', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-06-02 00:18:37', NULL);
INSERT INTO `p_message` VALUES (11, '黄强添加了项目人员黄强', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-06-02 00:19:22', NULL);
INSERT INTO `p_message` VALUES (12, '黄强解决了测试数据', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-06-02 00:33:34', NULL);
INSERT INTO `p_message` VALUES (13, '黄强新建项目：答辩测试项目2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-06-02 00:43:58', NULL);
INSERT INTO `p_message` VALUES (14, '黄强发布项目问题:测试问题', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-06-02 00:45:13', NULL);
INSERT INTO `p_message` VALUES (15, '黄强解决了测试问题', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-06-02 00:46:17', NULL);
INSERT INTO `p_message` VALUES (16, '黄强添加了项目人员黄强', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-06-02 00:47:42', NULL);
INSERT INTO `p_message` VALUES (17, '黄强删除了项目人员黄强', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-06-02 00:48:19', NULL);

-- ----------------------------
-- Table structure for p_messagerelease
-- ----------------------------
DROP TABLE IF EXISTS `p_messagerelease`;
CREATE TABLE `p_messagerelease`  (
  `id` int(11) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `actionUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `relationId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `herfAjax` int(11) NULL DEFAULT NULL,
  `showHide` int(11) NULL DEFAULT NULL,
  `founder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for p_personnel
-- ----------------------------
DROP TABLE IF EXISTS `p_personnel`;
CREATE TABLE `p_personnel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `personnel_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `personnel_duty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `personnel_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `personnel_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `personnel_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `founder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of p_personnel
-- ----------------------------
INSERT INTO `p_personnel` VALUES (3, '答辩测试项目', '项目主管', NULL, '黄强', NULL, NULL, '黄强', '2019-06-02 00:19:22');

-- ----------------------------
-- Table structure for p_problem
-- ----------------------------
DROP TABLE IF EXISTS `p_problem`;
CREATE TABLE `p_problem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `project_assembly` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem_sketch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem_handler_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem_handler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem_priority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `founder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `copySender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expect_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of p_problem
-- ----------------------------
INSERT INTO `p_problem` VALUES (1, '测试2', '其他', '测试数据', '这是一个测试问题', '已解决', NULL, '黄强', '高', '黄强', '2019-05-07 21:31:35', NULL, '2019-05-08 23:53:24');
INSERT INTO `p_problem` VALUES (11, '测试2', NULL, '无', '空', '未解决', NULL, '黄强', NULL, '黄强', NULL, NULL, '2019-05-14 16:00:00');
INSERT INTO `p_problem` VALUES (13, '答辩测试项目2', NULL, '测试问题', '测试问题描述', '已解决', NULL, '黄强', NULL, '黄强', '2019-06-02 00:45:13', NULL, '2019-06-01 16:00:00');

-- ----------------------------
-- Table structure for p_problemsolution
-- ----------------------------
DROP TABLE IF EXISTS `p_problemsolution`;
CREATE TABLE `p_problemsolution`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `problem_id` int(11) NULL DEFAULT NULL,
  `problem_sketch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem_review` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem_solution` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem_handler_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `problem_handler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `founder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `copySender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of p_problemsolution
-- ----------------------------
INSERT INTO `p_problemsolution` VALUES (8, 1, '测试评论', NULL, '测试解决方案', NULL, NULL, NULL, '黄强', NULL, NULL);
INSERT INTO `p_problemsolution` VALUES (9, 13, '测试问题评论', NULL, '测试问题解决方案', NULL, NULL, NULL, '黄强', NULL, NULL);

-- ----------------------------
-- Table structure for p_project
-- ----------------------------
DROP TABLE IF EXISTS `p_project`;
CREATE TABLE `p_project`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sign_adress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sign_time` datetime NULL DEFAULT NULL,
  `confirm_time` datetime NULL DEFAULT NULL,
  `finish_time` datetime NULL DEFAULT NULL,
  `production_startTime` datetime NULL DEFAULT NULL,
  `production_endTime` datetime NULL DEFAULT NULL,
  `approach_time` datetime NULL DEFAULT NULL,
  `install_time` datetime NULL DEFAULT NULL,
  `aloneDebug_startTime` datetime NULL DEFAULT NULL,
  `aloneDebug_endTime` datetime NULL DEFAULT NULL,
  `onlineDebug_startTime` datetime NULL DEFAULT NULL,
  `accompany_startTime` datetime NULL DEFAULT NULL,
  `accompany_endTime` datetime NULL DEFAULT NULL,
  `check_startTime` datetime NULL DEFAULT NULL,
  `check_endTime` datetime NULL DEFAULT NULL,
  `project_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `project_charger` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `founder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creat_time` datetime NULL DEFAULT NULL,
  `reguire_flashTotal` int(11) NULL DEFAULT NULL,
  `reguire_liftTotal` int(11) NULL DEFAULT NULL,
  `project_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `implementation_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of p_project
-- ----------------------------
INSERT INTO `p_project` VALUES (1, '测试2', '武汉', '2019-04-11 10:44:04', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '设计', '黄强', NULL, '2019-04-18 15:05:25', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `p_project` VALUES (5, '测试项目2', '武汉', '2019-05-25 16:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-05-26 00:36:58', NULL, NULL, '测试项目', NULL, '钉钉', NULL);
INSERT INTO `p_project` VALUES (6, '答辩测试项目', '武汉', '2019-06-01 16:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-06-02 00:16:43', NULL, NULL, '一个测试项目', NULL, '江汉大学', NULL);
INSERT INTO `p_project` VALUES (7, '答辩测试项目2', '武汉', '2019-06-29 16:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '黄强', '黄强', '2019-06-02 00:43:58', NULL, NULL, '答辩测试项目', NULL, '江汉大学', NULL);

-- ----------------------------
-- Table structure for p_record
-- ----------------------------
DROP TABLE IF EXISTS `p_record`;
CREATE TABLE `p_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `record_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `project_charger` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `founder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `copySender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of p_record
-- ----------------------------
INSERT INTO `p_record` VALUES (2, '测试项目2', '日志', '黄强', '2019-05-26 15:06:11', '黄强', '测试项目', NULL);

-- ----------------------------
-- Table structure for p_roles
-- ----------------------------
DROP TABLE IF EXISTS `p_roles`;
CREATE TABLE `p_roles`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_time` datetime NULL DEFAULT NULL COMMENT '最进登陆时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of p_roles
-- ----------------------------
INSERT INTO `p_roles` VALUES (1, '李灿', 'personal', 'dfaa', '2019-05-25 20:20:33');
INSERT INTO `p_roles` VALUES (2, '黄强', 'admin', '1984343840@qq.com', '2019-06-02 00:48:31');

SET FOREIGN_KEY_CHECKS = 1;
