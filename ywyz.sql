/*
 Navicat Premium Data Transfer

 Source Server         : yanyuzhi
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : ylsm1

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 14/01/2021 14:09:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `Mno` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Mname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Mtel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Memail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Mno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('001', '小王', ' 8266', ' whr.com', '111');
INSERT INTO `admin` VALUES ('002', '小阳', '11112', 'yx.com', '123');
INSERT INTO `admin` VALUES ('003', '小闫', '1320', 'yyz.com', '123');
INSERT INTO `admin` VALUES ('004', '小翟', '6482', 'zjz.com', '123');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `Bno` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Bname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Bauthor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Bsource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Bedition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Bprice` decimal(30, 2) NULL DEFAULT NULL,
  `Bnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Bno`) USING BTREE,
  INDEX `Bname`(`Bname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('01', 'JAVA2实用程序', '耿祥义', '清华大学出版社', '第三版', 59.00, '2100');
INSERT INTO `book` VALUES ('02', '数值计算方法', '马东升', '机械工业出版社', '第三版', 35.00, '3548');
INSERT INTO `book` VALUES ('03', '软件工程概论', '伊恩·萨默维尔', '机械工业出版社', '第十版', 89.00, '4211');
INSERT INTO `book` VALUES ('04', '工程制图方法', '张大庆', '清华大学出版社', '第一版', 46.00, '1980');
INSERT INTO `book` VALUES ('05', '理论力学', '范钦珊', '清华大学出版社', '第一版', 34.00, '2153');
INSERT INTO `book` VALUES ('06', '分布式设计', '秦效国', '兰村帝国出版社', '第N版', 25.00, '1684');
INSERT INTO `book` VALUES ('07', '机械原理与设计', '马履中', '机械工业出版社', '第一版', 24.00, '2150');
INSERT INTO `book` VALUES ('08', '特性材料', '季振国', '科学出版社', '第二版', 26.00, '4521');
INSERT INTO `book` VALUES ('09', '操作系统', '汤小丹', '西安电子科技大学出版社', '第四版', 53.00, '2408');
INSERT INTO `book` VALUES ('10', '环境监测方法', '王建国', '新华出版社', '第一版', 24.00, '2456');
INSERT INTO `book` VALUES ('11', '通信原理技术', '杨中天', '科学技术出版社', '第一版', 26.00, '3546');
INSERT INTO `book` VALUES ('12', '电子分析技术', '张小华', '北京教育出版社', '第二版', 46.00, '3121');
INSERT INTO `book` VALUES ('13', '数据库系统概论', '王珊 萨师煊', '高等教育出版社', '第五版', 42.00, '6604');
INSERT INTO `book` VALUES ('14', '计算机组成原理', '唐朔飞', '高等教育出版社', '第二版', 39.00, '1279');
INSERT INTO `book` VALUES ('15', '分析数学教程', '常庚哲', '高等教育出版社', '第三版', 36.00, '4231');
INSERT INTO `book` VALUES ('16', '管理学', '李倩慧', '清华大学出版社', '第一班', 42.00, '3645');
INSERT INTO `book` VALUES ('17', '大学英语教程', '王竞泽', '外语教学与研究出版社', '第三版', 38.00, '4236');
INSERT INTO `book` VALUES ('18', 'python基础', '闫泓儒', '高等教育出版社', '第一版', 35.00, '1569');
INSERT INTO `book` VALUES ('19', '单片机原理', '张毅刚', '高等教育出版社', '第二版', 58.00, '3548');
INSERT INTO `book` VALUES ('20', '组网技术基础', '杨云江', '清华大学出版社', '第一般', 61.00, '2698');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `CCno` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CCname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CCtno` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CCbno` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CCmno` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CCset_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CCissue_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`CCno`) USING BTREE,
  INDEX `CCtno_foreign`(`CCtno`) USING BTREE,
  INDEX `CCbno_foreign`(`CCbno`) USING BTREE,
  INDEX `CCmno_foreign`(`CCmno`) USING BTREE,
  CONSTRAINT `CCbno_foreign` FOREIGN KEY (`CCbno`) REFERENCES `book` (`Bno`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `CCmno_foreign` FOREIGN KEY (`CCmno`) REFERENCES `monitor` (`Cno`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `CCtno_foreign` FOREIGN KEY (`CCtno`) REFERENCES `teacher` (`Tno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('001', '数据库', '11', NULL, '18070141', '未设置', '否');
INSERT INTO `course` VALUES ('002', '数值分析', '11', NULL, '18070141', '未设置', '否');
INSERT INTO `course` VALUES ('003', '软件工程', '11', NULL, '18070141', '未设置', '否');
INSERT INTO `course` VALUES ('004', '操作系统', '11', NULL, '18070142', '未设置', '否');
INSERT INTO `course` VALUES ('005', '计算机组成原理', '11', NULL, '18070143', '未设置', '否');
INSERT INTO `course` VALUES ('006', 'JAVA程序设计基础', '11', NULL, '18070144', '未设置', '否');
INSERT INTO `course` VALUES ('007', '分布式', '03', NULL, '18070541', '未设置', '否');
INSERT INTO `course` VALUES ('008', '工程制图', '17', NULL, '18010141', '未设置', '否');
INSERT INTO `course` VALUES ('009', '机械原理', '18', NULL, '18020141', '未设置', '否');
INSERT INTO `course` VALUES ('010', '材料特性', '24', NULL, '18030141', '未设置', '否');
INSERT INTO `course` VALUES ('011', '环境监测', '19', NULL, '18040141', '未设置', '否');
INSERT INTO `course` VALUES ('012', '通信原理', '11', NULL, '18050141', '未设置', '否');
INSERT INTO `course` VALUES ('013', '电子系统', '20', NULL, '18060141', '未设置', '否');
INSERT INTO `course` VALUES ('014', '分析数学', '21', NULL, '18080141', '未设置', '否');
INSERT INTO `course` VALUES ('015', '管理学', '22', NULL, '18090141', '未设置', '否');
INSERT INTO `course` VALUES ('016', '大学英语', '23', NULL, '18100141', '未设置', '否');
INSERT INTO `course` VALUES ('017', 'python', '06', NULL, '18070541', '未设置', '否');
INSERT INTO `course` VALUES ('018', '分布式', '03', NULL, '18070542', '未设置', '否');
INSERT INTO `course` VALUES ('019', '单片机', '08', NULL, '18070241', '未设置', '否');
INSERT INTO `course` VALUES ('020', '组网技术', '09', NULL, '18070242', '未设置', '否');

-- ----------------------------
-- Table structure for monitor
-- ----------------------------
DROP TABLE IF EXISTS `monitor`;
CREATE TABLE `monitor`  (
  `Cno` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Cgrade` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Cdept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Cmajor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Cnum` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Cno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of monitor
-- ----------------------------
INSERT INTO `monitor` VALUES ('18010141', '123', '3', '机电工程学院', '智能化工程', '49');
INSERT INTO `monitor` VALUES ('18020141', '123', '3', '机械工程学院', '机械制造', '48');
INSERT INTO `monitor` VALUES ('18030141', '123', '3', '材料工程学院', '特种材料', '47');
INSERT INTO `monitor` VALUES ('18040141', '123', '3', '环境安全工程学院', '安全工程', '50');
INSERT INTO `monitor` VALUES ('18050141', '123', '3', '信通工程学院', '电子信息', '50');
INSERT INTO `monitor` VALUES ('18060141', '123', '3', '仪器与电子学院', '精密仪器', '49');
INSERT INTO `monitor` VALUES ('18070141', '123', '3', '大数据学院', '人工智能', '50');
INSERT INTO `monitor` VALUES ('18070142', '123', '3', '大数据学院', '人工智能', '46');
INSERT INTO `monitor` VALUES ('18070143', '123', '3', '大数据学院', '网络安全', '50');
INSERT INTO `monitor` VALUES ('18070144', '123', '3', '大数据学院', '网络安全', '50');
INSERT INTO `monitor` VALUES ('18070241', '123', '3', '大数据学院', '物联网工程', '50');
INSERT INTO `monitor` VALUES ('18070242', '123', '3', '大数据学院', '物联网工程', '50');
INSERT INTO `monitor` VALUES ('18070541', '123', '3', '大数据学院', '数据科学与大数据技术', '50');
INSERT INTO `monitor` VALUES ('18070542', '123', '3', '大数据学院', '数据科学与大数据技术', '50');
INSERT INTO `monitor` VALUES ('18080141', '123', '3', '理学院', '数学', '45');
INSERT INTO `monitor` VALUES ('18090141', '123', '3', '经济与管理学院', '国际贸易', '50');
INSERT INTO `monitor` VALUES ('18100141', '123', '3', '人文社科学院', '商务英语', '49');

-- ----------------------------
-- Table structure for reserve
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve`  (
  `Rno` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CCno` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Bno` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Cno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Rnum` int NULL DEFAULT NULL,
  `R_year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Rissue_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TotalPrice` double NULL DEFAULT NULL,
  PRIMARY KEY (`Rno`) USING BTREE,
  INDEX `Bno_foreign`(`Bno`) USING BTREE,
  INDEX `CCno_foreign`(`CCno`) USING BTREE,
  CONSTRAINT `Bno_foreign` FOREIGN KEY (`Bno`) REFERENCES `book` (`Bno`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `CCno_foreign` FOREIGN KEY (`CCno`) REFERENCES `course` (`CCno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of reserve
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `Tno` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Tname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Tdept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Ttel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Temail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Tno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('03', '123', '王彦博', '大数据学院', '123', '123');
INSERT INTO `teacher` VALUES ('04', '123', '熊风光', '大数据学院', '666', '789');
INSERT INTO `teacher` VALUES ('05', '123', '李玲', '大数据学院', '456', '654');
INSERT INTO `teacher` VALUES ('06', '123', '井超', '大数据学院', '123', '789');
INSERT INTO `teacher` VALUES ('07', '123', '韩慧妍', '大数据学院', '122', '111');
INSERT INTO `teacher` VALUES ('08', '123', '乔钢柱', '大数据学院', '123', '456');
INSERT INTO `teacher` VALUES ('09', '123', '韩燮', '大数据学院', '123', '654');
INSERT INTO `teacher` VALUES ('11', '456', '闫禹至', '信通工程学院', '250', '250');
INSERT INTO `teacher` VALUES ('14', '123', '张元', '大数据学院', '222', '333');
INSERT INTO `teacher` VALUES ('15', '123', '况立群', '大数据学院', '111', '111');
INSERT INTO `teacher` VALUES ('16', '123', '李顺增', '大数据学院', '111', '111');
INSERT INTO `teacher` VALUES ('17', '123', '翟竞泽', '机电工程学院', '111', '222');
INSERT INTO `teacher` VALUES ('18', '123', '李四', '机械工程学院', '222', '333');
INSERT INTO `teacher` VALUES ('19', '123', '赵五', '环境安全工程学院', '333', '444');
INSERT INTO `teacher` VALUES ('20', '123', '王泓儒', '仪器与电子学院', '444', '555');
INSERT INTO `teacher` VALUES ('21', '123', '杨晓峰', '理学院', '555', '666');
INSERT INTO `teacher` VALUES ('22', '123', '阳旭', '经济管理学院', '666', '777');
INSERT INTO `teacher` VALUES ('23', '123', '卫春艳', '人文社科学院', '777', '888');
INSERT INTO `teacher` VALUES ('24', '123', '李老师', '材料工程学院', '123', '321');

-- ----------------------------
-- View structure for buy
-- ----------------------------
DROP VIEW IF EXISTS `buy`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `buy` AS select `book`.`Bno` AS `Bno`,sum(`reserve`.`Rnum`) AS `Number` from (`book` join `reserve`) where (`book`.`Bno` = `reserve`.`Bno`) group by `book`.`Bno`;

-- ----------------------------
-- View structure for purchase
-- ----------------------------
DROP VIEW IF EXISTS `purchase`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `purchase` AS select `book`.`Bno` AS `Bno`,`book`.`Bname` AS `Bname`,`book`.`Bauthor` AS `Bauthor`,`book`.`Bsource` AS `Bsource`,`book`.`Bedition` AS `Bedition`,`book`.`Bprice` AS `Bprice`,`buy`.`Number` AS `BNumber` from (`book` join `buy`) where (`book`.`Bno` = `buy`.`Bno`);

SET FOREIGN_KEY_CHECKS = 1;
