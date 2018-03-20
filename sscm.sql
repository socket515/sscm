# Host: localhost  (Version: 5.5.40)
# Date: 2018-03-20 23:47:31
# Generator: MySQL-Front 5.3  (Build 4.120)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(15) NOT NULL DEFAULT '',
  `password` varchar(15) CHARACTER SET gbk NOT NULL DEFAULT '' COMMENT '密码',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES ('admin','admin');

#
# Structure for table "arrange"
#

DROP TABLE IF EXISTS `arrange`;
CREATE TABLE `arrange` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cno` varchar(15) NOT NULL DEFAULT '' COMMENT '课程id',
  `tno` varchar(15) NOT NULL DEFAULT '0' COMMENT '教师id',
  `anum` int(11) NOT NULL DEFAULT '0' COMMENT '剩余人数',
  `maxnum` int(11) NOT NULL DEFAULT '0' COMMENT '最大人数',
  `atime` int(11) NOT NULL DEFAULT '0' COMMENT '课程时间',
  `address` varchar(31) NOT NULL DEFAULT '0' COMMENT '地点',
  `sd` date NOT NULL DEFAULT '2018-02-15' COMMENT '开始日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `b` (`atime`,`address`),
  UNIQUE KEY `a` (`tno`,`atime`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=gbk COMMENT='课程安排表';

#
# Data for table "arrange"
#

/*!40000 ALTER TABLE `arrange` DISABLE KEYS */;
INSERT INTO `arrange` VALUES (3,'188491','200130472',47,50,2,'2','2018-01-08'),(4,'188489','200130472',62,65,1,'1','2018-03-08'),(5,'188493','201220488',42,45,15,'18','2018-03-01'),(6,'188489','200510572',42,46,18,'12','2018-02-09'),(7,'188499','200910588',43,45,7,'6','2018-02-15'),(8,'188500','200910588',39,40,10,'14','2018-04-10');
/*!40000 ALTER TABLE `arrange` ENABLE KEYS */;

#
# Structure for table "course"
#

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cno` varchar(15) NOT NULL DEFAULT '',
  `cname` varchar(15) NOT NULL DEFAULT '' COMMENT '课程名字',
  `credit` int(11) NOT NULL DEFAULT '0' COMMENT '学分',
  `type` tinyint(3) NOT NULL DEFAULT '0',
  `state` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0可以修改1可以',
  `introduction` varchar(255) DEFAULT '',
  PRIMARY KEY (`cno`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=gbk COMMENT='课程';

#
# Data for table "course"
#

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('188489','电子工程',4,0,0,'大学生必修的数学课程00'),('188490','大学英语',2,0,0,'外语是连接世界的桥梁'),('188491','大学语文',2,1,0,'语言文学的基础'),('188492','近代史',2,0,0,'学习好历史博古通今'),('188493','养猪学',2,1,0,'实力养猪教学'),('188494','水产养殖',2,1,0,'接触皮皮虾从这门课开始'),('188495','马克思哲学理论',4,0,0,'从今天开始成为共产主义接班人'),('188496','java程序设计',2,1,0,'做码农从今天开始'),('188497','AI人工智能',2,1,0,'感受天网的威力'),('188498','结构力学',2,0,0,'钢筋水泥才是力量'),('188499','犯罪心理学',2,1,0,'了解罪犯'),('188500','军事理论',2,1,0,'军训'),('188501','数据结构',4,0,0,'测试');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

#
# Structure for table "notice"
#

DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dt` datetime NOT NULL DEFAULT '2018-01-01 00:00:00' COMMENT '发布日期',
  `creator` varchar(15) NOT NULL DEFAULT '' COMMENT '创建者',
  `content` varchar(255) NOT NULL DEFAULT '' COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=gbk COMMENT='公告表';

#
# Data for table "notice"
#

/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (2,'2018-01-12 00:00:00','admin','永远快乐'),(3,'2018-01-12 00:00:00','admin','新年好'),(4,'2018-01-12 00:00:00','admin','永远快乐'),(5,'2018-01-13 11:39:17','admin','你好你好啊');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;

#
# Structure for table "sc"
#

DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `aid` int(11) NOT NULL,
  `sno` varchar(15) NOT NULL DEFAULT '0',
  PRIMARY KEY (`aid`,`sno`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=gbk COMMENT='学生选课表';

#
# Data for table "sc"
#

/*!40000 ALTER TABLE `sc` DISABLE KEYS */;
INSERT INTO `sc` VALUES (3,'200830740903'),(3,'201430340506'),(3,'201530240510'),(4,'200830740903'),(4,'201430340506'),(4,'201530240510'),(5,'200830740903'),(5,'201430340513'),(5,'201530240510'),(6,'200830740903'),(6,'201430340506'),(6,'201530240510'),(7,'200830740903'),(7,'201530240510'),(8,'201430340513');
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
  `major` varchar(15) NOT NULL DEFAULT '' COMMENT '专业',
  `sdept` varchar(31) NOT NULL DEFAULT '' COMMENT '部门',
  `dt` date NOT NULL DEFAULT '2014-09-12' COMMENT '入学日期',
  PRIMARY KEY (`sno`),
  UNIQUE KEY `sno` (`sno`,`password`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='学生信息表';

#
# Data for table "student"
#

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('200830740903','周杰伦','200830740903',1,21,'电气工程','电子信息学院','2008-09-19'),('201430340506','黄少杰','123456',1,19,'软件工程','数学与信息学院','2014-09-12'),('201430340507','黄宇飞','123456',1,18,'软件工程','数学与信息学院','2014-09-12'),('201430340508','黄梓秦','123456',1,18,'软件工程','数学与信息学院','2014-09-12'),('201430340509','江伟隆','123456',1,18,'软件工程','数学与信息学院','2014-09-12'),('201430340510','黎志亮','123456',1,18,'软件工程','数学与信息学院','2014-09-12'),('201430340513','梁泽华','123456',1,18,'软件工程','数学与信息学院','2014-09-12'),('201430340514','林佳炜','123456',1,18,'网络工程','数学与信息学院','2014-09-12'),('201430340515','邱德智','123456',1,18,'网络工程','数学与信息学院','2014-09-12'),('201430340516','龙羽梦','123456',0,18,'网络工程','数学与信息学院','2014-09-12'),('201430340518','翁宇洁','123456',0,18,'网络工程','数学与信息学院','2014-09-12'),('201530240507','黄大飞','123456',1,18,'动物科学','动物科学院','2015-09-12'),('201530240508','黄子晴','123456',0,18,'动物科学','动物科学院','2015-09-12'),('201530240509','江龙飞','123456',1,18,'动物科学','动物科学院','2015-09-12'),('201530240510','黎嘉亮','123456',0,18,'动物科学','动物科学院','2015-09-12'),('201530240511','黎明健','123456',1,18,'动物科学','动物科学院','2015-09-12'),('201530240512','黎佳颖','123456',0,18,'动物科学','动物科学院','2015-09-12'),('201530240513','陈泽华','123456',1,18,'动物科学','动物科学院','2015-09-12'),('201530240514','林佳怡','123456',0,18,'动物科学','动物科学院','2015-09-12'),('201530240515','邱德馨','123456',0,18,'动物科学','动物科学院','2015-09-12'),('2018050345','刘得花','2018050345',1,46,'','电子与信息学院','2018-03-07');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

#
# Structure for table "teacher"
#

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tno` varchar(15) NOT NULL DEFAULT '',
  `tname` varchar(15) NOT NULL DEFAULT '' COMMENT '教师名字',
  `tpass` varchar(15) NOT NULL DEFAULT '' COMMENT '登录密码',
  `tdept` varchar(15) NOT NULL DEFAULT '' COMMENT '教师院系',
  `dt` date NOT NULL DEFAULT '2008-06-05' COMMENT '入职时间',
  `tcomment` varchar(255) DEFAULT NULL COMMENT '教师简介',
  PRIMARY KEY (`tno`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk COMMENT='教师表';

#
# Data for table "teacher"
#

/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('199310572','张春','123456','数学与信息学院','1993-08-12',NULL),('199510442','老夫子','123456','动物科学院','1995-08-12','实力养猪教学'),('199840052','诸葛亮','123456','工程学院','1998-03-12','专业布阵'),('200130472','杨永信','123456','电子信息学院','2001-07-22','雷电法王掌控雷电'),('200210572','孙燕姿','123456','电子信息学院','2002-08-12','尽职认真的老师'),('200410592','华罗庚','123456','数学与信息学院','2004-08-12','尽职认真的老师'),('200430573','陈奕迅','123456','工程学院','2005-08-12','尽职认真的老师'),('200510572','蒋明星','123456','数学与信息学院','2005-08-12','尽职认真的老师'),('200910588','方木','123456','工程学院','2009-08-12','尽职认真的老师'),('200922572','侧田','123456','电子信息学院','2009-08-12','雷电法王掌控雷电'),('201220488','明凯','123456','动物科学院','2012-06-19','实力养猪教学'),('201320052','妲己','123456','动物科学院','2013-08-12','尽职认真的老师');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
