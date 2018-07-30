 

drop database if exists edoc;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`edoc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `edoc`;

/*Table structure for table `edoc_category` */

DROP TABLE IF EXISTS `edoc_category`;

CREATE TABLE `edoc_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='电子文档分类表';

/*Data for the table `edoc_category` */

insert  into `edoc_category`(`id`,`name`) values (1,'篮球'),(2,'娱乐八卦'),(3,'养生');

/*Table structure for table `edoc_entry` */

DROP TABLE IF EXISTS `edoc_entry`;

CREATE TABLE `edoc_entry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `categoryId` bigint(20) NOT NULL COMMENT '分类编号',
  `title` varchar(1000) NOT NULL COMMENT '文档名称',
  `summary` varchar(1000) DEFAULT NULL COMMENT '摘要',
  `uploaduser` varchar(1000) DEFAULT NULL COMMENT '上传人',
  `createdate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='电子文档条目\r\n';

/*Data for the table `edoc_entry` */

insert  into `edoc_entry`(`id`,`categoryId`,`title`,`summary`,`uploaduser`,`createdate`) values (1,1,'杜兰特很帅','杜兰特说杜兰特很可爱','小杜兰特','2018-07-01 13:43:45'),(2,1,'科比又吹牛了','detail','kobe','2018-07-02 13:44:22'),(3,2,'热巴竟然..','一个夜黑风高的夜晚，热巴HE...','丞相','2018-07-08 13:45:29'),(4,2,'冰冰和李晨出现了分歧，原因竟然是...','去年今天还是很相爱，今年就，，，','佚名','2018-07-08 13:46:48'),(5,3,'洗脚的五个细节','脱袜子','恶趣味的小王','2018-07-13 13:47:33'),(6,3,'你每天尺的东西里面竟然有...','致癌很恐怖，不要再吃了','cc','2018-07-18 13:48:16');
 