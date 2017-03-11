/*
Navicat MySQL Data Transfer

Source Server         : root+dev
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : forsql

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2017-03-11 15:41:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `author` varchar(20) default NULL,
  `price` decimal(11,0) default NULL,
  `quantity` int(11) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', '水浒', '施耐庵', '188', '3');
INSERT INTO `books` VALUES ('2', '计算机网络', '谢希仁', '49', '3');
INSERT INTO `books` VALUES ('3', '计算方法', '严蔚敏', '58', '3');
INSERT INTO `books` VALUES ('4', '计算方法习题集', '殷人昆', '188', '3');
INSERT INTO `books` VALUES ('5', '数据库技术及应用', '王珊', '38', '3');
INSERT INTO `books` VALUES ('6', '组合数学', '周伟', '28', '3');
INSERT INTO `books` VALUES ('7', 'Redis初探', '周旭龙', '25', '3');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `pk` int(11) NOT NULL auto_increment,
  `cardId` int(11) default NULL,
  `bookId` int(11) default NULL,
  `returnDate` timestamp NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`pk`),
  UNIQUE KEY `pk` (`pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('4', '1', '1', '2017-02-16 00:00:00');
INSERT INTO `borrow` VALUES ('5', '2', '1', '2017-02-16 00:00:00');
INSERT INTO `borrow` VALUES ('6', '3', '1', '2016-12-14 11:00:44');
INSERT INTO `borrow` VALUES ('7', '4', '3', '2016-12-14 11:00:48');
INSERT INTO `borrow` VALUES ('8', '4', '6', '2016-12-14 11:00:53');
INSERT INTO `borrow` VALUES ('9', '5', '6', '2016-12-14 11:00:57');
INSERT INTO `borrow` VALUES ('10', '7', '7', '2016-12-14 11:01:01');

-- ----------------------------
-- Table structure for cards
-- ----------------------------
DROP TABLE IF EXISTS `cards`;
CREATE TABLE `cards` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `class` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cards
-- ----------------------------
INSERT INTO `cards` VALUES ('1', '张三', '计科一班');
INSERT INTO `cards` VALUES ('2', '李四', '计科一班');
INSERT INTO `cards` VALUES ('3', '王五', '计科二班');
INSERT INTO `cards` VALUES ('4', '六四', '计科二班');
INSERT INTO `cards` VALUES ('5', '七七', '软工一班');
INSERT INTO `cards` VALUES ('6', '粑粑', '软工二班');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseNo` int(11) default NULL,
  `name` varchar(20) default NULL,
  `teacherNo` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '语文', '1');
INSERT INTO `course` VALUES ('2', '数学', '2');
INSERT INTO `course` VALUES ('3', '英语', '3');
INSERT INTO `course` VALUES ('4', '物理', '4');

-- ----------------------------
-- Table structure for fruits
-- ----------------------------
DROP TABLE IF EXISTS `fruits`;
CREATE TABLE `fruits` (
  `type` varchar(20) default NULL,
  `variety` varchar(20) default NULL,
  `price` double(15,3) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fruits
-- ----------------------------
INSERT INTO `fruits` VALUES ('apple', 'gala', '2.790');
INSERT INTO `fruits` VALUES ('apple', 'fuji', '0.240');
INSERT INTO `fruits` VALUES ('apple', 'limbertwig', '2.870');
INSERT INTO `fruits` VALUES ('orange', 'valencia', '3.590');
INSERT INTO `fruits` VALUES ('orange', 'navel', '9.360');
INSERT INTO `fruits` VALUES ('pear', 'bradford', '6.050');
INSERT INTO `fruits` VALUES ('pear', 'bartlett', '2.140');
INSERT INTO `fruits` VALUES ('cherry', 'bing', '2.550');
INSERT INTO `fruits` VALUES ('cherry', 'chelan', '6.330');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `StudentNo` int(11) default NULL,
  `CourseNo` int(11) default NULL,
  `score` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '2', '78');
INSERT INTO `score` VALUES ('1', '3', '67');
INSERT INTO `score` VALUES ('1', '4', '67');
INSERT INTO `score` VALUES ('2', '1', '52');
INSERT INTO `score` VALUES ('2', '2', '81');
INSERT INTO `score` VALUES ('2', '3', '92');
INSERT INTO `score` VALUES ('2', '4', '67');
INSERT INTO `score` VALUES ('3', '1', '52');
INSERT INTO `score` VALUES ('3', '2', '47');
INSERT INTO `score` VALUES ('3', '3', '88');
INSERT INTO `score` VALUES ('3', '4', '67');
INSERT INTO `score` VALUES ('4', '2', '88');
INSERT INTO `score` VALUES ('4', '3', '90');
INSERT INTO `score` VALUES ('4', '4', '67');
INSERT INTO `score` VALUES ('5', '1', '52');
INSERT INTO `score` VALUES ('5', '3', '78');
INSERT INTO `score` VALUES ('5', '4', '67');
INSERT INTO `score` VALUES ('6', '1', '52');
INSERT INTO `score` VALUES ('6', '2', '68');
INSERT INTO `score` VALUES ('6', '4', '67');
INSERT INTO `score` VALUES ('1', '1', '52');
INSERT INTO `score` VALUES ('5', '2', '72');
INSERT INTO `score` VALUES ('7', '2', '72');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `name` varchar(32) default NULL,
  `age` int(11) default NULL,
  `sex` varchar(8) default NULL,
  `studentNo` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('钱二', '19', '女', '2');
INSERT INTO `student` VALUES ('刘一', '18', '男', '1');
INSERT INTO `student` VALUES ('张三', '17', '男', '3');
INSERT INTO `student` VALUES ('李四', '18', '女', '4');
INSERT INTO `student` VALUES ('王五', '17', '男', '5');
INSERT INTO `student` VALUES ('赵6', '19', '女', '6');
INSERT INTO `student` VALUES ('钱二', '25', '男', '7');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherNo` int(11) default NULL,
  `name` varchar(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '叶平');
INSERT INTO `teacher` VALUES ('2', '贺高');
INSERT INTO `teacher` VALUES ('3', '杨艳');
INSERT INTO `teacher` VALUES ('4', '叶平');
