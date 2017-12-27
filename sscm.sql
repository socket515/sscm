# Host: localhost  (Version: 5.5.40)
# Date: 2017-12-27 23:16:51
# Generator: MySQL-Front 5.3  (Build 4.120)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `admin` varchar(15) NOT NULL DEFAULT '',
  `password` varchar(15) NOT NULL DEFAULT '' COMMENT '密码',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk COMMENT='管理员表';

#
# Data for table "admin"
#

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

#
# Structure for table "arrange"
#

DROP TABLE IF EXISTS `arrange`;
CREATE TABLE `arrange` (
  `cno` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `tno` int(11) NOT NULL DEFAULT '0' COMMENT '教师id',
  `anum` int(11) NOT NULL DEFAULT '0' COMMENT '剩余人数',
  `maxnum` int(11) NOT NULL DEFAULT '0' COMMENT '最大人数',
  `atime` varchar(31) NOT NULL DEFAULT '' COMMENT '课程时间',
  `address` varchar(31) NOT NULL DEFAULT '' COMMENT '地点',
  PRIMARY KEY (`cno`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk COMMENT='课程安排表';

#
# Data for table "arrange"
#

/*!40000 ALTER TABLE `arrange` DISABLE KEYS */;
/*!40000 ALTER TABLE `arrange` ENABLE KEYS */;

#
# Structure for table "course"
#

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cno` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程表id',
  `cname` varchar(15) NOT NULL DEFAULT '' COMMENT '课程名',
  `credit` int(11) NOT NULL DEFAULT '0' COMMENT '学分',
  `type` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0 为必修 1为选修',
  `Introduction` varchar(255) DEFAULT NULL COMMENT '课程简介',
  PRIMARY KEY (`cno`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk COMMENT='课程表';

#
# Data for table "course"
#

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

#
# Structure for table "sc"
#

DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `cno` int(11) NOT NULL AUTO_INCREMENT,
  `sno` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`cno`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk COMMENT='学生选课表';

#
# Data for table "sc"
#

/*!40000 ALTER TABLE `sc` DISABLE KEYS */;
/*!40000 ALTER TABLE `sc` ENABLE KEYS */;

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

#
# Structure for table "teache"
#

DROP TABLE IF EXISTS `teache`;
CREATE TABLE `teache` (
  `tno` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师号',
  `tname` varchar(15) NOT NULL DEFAULT '' COMMENT '教师名字',
  `tpass` varchar(15) NOT NULL DEFAULT '' COMMENT '登录密码',
  `tdept` varchar(15) NOT NULL DEFAULT '' COMMENT '教师院系',
  `tcomment` varchar(255) DEFAULT NULL COMMENT '教师简介',
  PRIMARY KEY (`tno`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk COMMENT='教师表';

#
# Data for table "teache"
#

/*!40000 ALTER TABLE `teache` DISABLE KEYS */;
/*!40000 ALTER TABLE `teache` ENABLE KEYS */;
