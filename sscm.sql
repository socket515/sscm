# Host: localhost  (Version: 5.5.40)
# Date: 2017-12-03 17:52:37
# Generator: MySQL-Front 5.3  (Build 4.120)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sno` varchar(15) NOT NULL DEFAULT '' COMMENT '学号',
  `sname` varchar(15) NOT NULL DEFAULT '' COMMENT '学生名',
  `password` varchar(15) NOT NULL DEFAULT '' COMMENT '登录口令',
  `ssex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别',
  `sage` int(11) NOT NULL DEFAULT '0' COMMENT '年龄',
  `sdept` varchar(31) NOT NULL DEFAULT '' COMMENT '部门',
  PRIMARY KEY (`sno`),
  UNIQUE KEY `sno` (`sno`,`password`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='学生信息表';

#
# Data for table "student"
#

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('201430340506','张三丰','123456',1,18,'武当派');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
