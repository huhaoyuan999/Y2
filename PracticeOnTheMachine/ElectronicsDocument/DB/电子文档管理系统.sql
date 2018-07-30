DROP DATABASE IF EXISTS `EDOC`;
/*创建电子文档数据库*/
CREATE DATABASE `EDOC`;
USE `EDOC`;

/*电子文档分类*/
DROP TABLE IF EXISTS `edoc_category`;
CREATE TABLE `edoc_category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '分类编号',
  `name` VARCHAR(15) NOT NULL COMMENT '分类名称'
)CHARSET=utf8 COMMENT='电子文档分类表';


/*电子文档条目表*/
DROP TABLE IF EXISTS `edoc_entry`;
CREATE TABLE `edoc_entry` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '编号',
  `categoryId` BIGINT(20) NOT NULL COMMENT ' 分类编号',
  `title` VARCHAR(50) NOT NULL COMMENT '文档名称',
  `summary` VARCHAR(50) NULL COMMENT '摘要',
  `uploaduser` VARCHAR(50) NULL COMMENT '上传人',
   `createdate` DATE NOT NULL COMMENT '创建时间'
)CHARSET=utf8 COMMENT='电子文档分类表';

#添加约束
ALTER TABLE edoc_entry ADD CONSTRAINT fk_entry_category FOREIGN KEY (categoryId) REFERENCES edoc_category(id);

/*插入电子文档分类信息*/
INSERT  INTO `edoc_category`(`id`,`name`) VALUES (1,'IT计算机'),(2,'言情小说'),(3,'武侠小说');



/*插入电子文档条目信息*/
INSERT  INTO `edoc_entry`(`id`,`categoryId`,`title`,`summary`,`uploaduser`,`createdate`) 
VALUES (1,1,'Oracle学习','Oracle学习精品','李晓明','2013-03-05'),
(2,1,'区块链','区块链安全技术指南','谈颖','2013-03-15'),
(3,1,'高效计算','结构化并行程序设计','李晓明','2013-03-05'),
(4,1,'ROS机器人','ROS机器人项目开发','椰丝糖','2017-03-05'),
(5,1,'SQL应用','SQL应用及误区分析','李晓明','2010-03-05'),
(6,1,'深入理解Java','深入理解Java虚拟机','李晓明','2018-03-05'),
(7,1,'Java编程','Java编程思想','李晓明','2011-03-05'),
(8,1,'PHP和MySQL','PHP和MySQL Web开发','李晓明','2013-06-05'),
(9,2,'蜗牛有爱情','如果蜗牛有爱情','丁墨','2013-08-05'),
(10,2,'女主养成','暖萌甜宠文','卿玖思','2013-03-05'),
(11,3,'影后重生','影后重生之豪门萌妻','浮光锦','2011-03-05'),
(12,3,'温馨宠文','古言宫廷 重生忠犬男主','豆豆麻麻','2013-09-05'),
(13,2,'我和你差之微毫的世界','温少远出现','北倾','2010-10-05'),
(14,2,'我的邻居是前夫','秦苒和谢简出生','二货乃总','2014-03-25'),
(15,3,'离婚这件小事','杨薇和祁笑言结婚一年','宋子恒','2016-07-05'),
(16,3,'金陵春','周少瑾重生了','苏婉','2015-01-05'),
(17,2,'荒唐','却独独没有爱情','杨薇','2014-06-05'),
(18,3,'高岭之花','都市甜文','李晓明','2011-09-05'),
(19,2,'最佳女主角','现代重生','祁笑','2013-03-05');





/*查询电子文档分类表*/
SELECT * FROM `edoc_category`;
/*查询电子文档条目表*/
SELECT * FROM `edoc_entry`;






