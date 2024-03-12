-- MySQL dump 10.13  Distrib 5.7.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sky_take_out
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `sky_take_out`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `sky_take_out` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sky_take_out`;

--
-- Table structure for table `address_book`
--

DROP TABLE IF EXISTS `address_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `consignee` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人',
  `sex` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `phone` varchar(11) COLLATE utf8_bin NOT NULL COMMENT '手机号',
  `province_code` varchar(12) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '省级区划编号',
  `province_name` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '省级名称',
  `city_code` varchar(12) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '市级区划编号',
  `city_name` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '市级名称',
  `district_code` varchar(12) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '区级区划编号',
  `district_name` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '区级名称',
  `detail` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '详细地址',
  `label` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '标签',
  `is_default` tinyint(1) NOT NULL DEFAULT '0' COMMENT '默认 0 否 1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地址簿';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_book`
--

LOCK TABLES `address_book` WRITE;
/*!40000 ALTER TABLE `address_book` DISABLE KEYS */;
INSERT INTO `address_book` VALUES (1,1,'你好','0','15737571998','11','北京市','1101','市辖区','110102','西城区','朝阳北三环','1',1);
/*!40000 ALTER TABLE `address_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` int(11) DEFAULT NULL COMMENT '类型   1 菜品分类 2 套餐分类',
  `name` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '分类名称',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '顺序',
  `status` int(11) DEFAULT NULL COMMENT '分类状态 0:禁用，1:启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_category_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜品及套餐分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (11,1,'酒水饮料',10,1,'2022-06-09 22:09:18','2022-06-09 22:09:18',1,1),(12,1,'传统主食',9,1,'2022-06-09 22:09:32','2022-06-09 22:18:53',1,1),(13,2,'人气套餐',12,1,'2022-06-09 22:11:38','2022-06-10 11:04:40',1,1),(15,2,'商务套餐',13,1,'2022-06-09 22:14:10','2022-06-10 11:04:48',1,1),(16,1,'蜀味烤鱼',5,1,'2022-06-09 22:15:37','2024-02-27 15:50:18',1,1),(17,1,'蜀味牛蛙',4,1,'2022-06-09 22:16:14','2024-02-27 17:25:12',1,1),(18,1,'特色蒸菜',6,1,'2022-06-09 22:17:42','2022-06-09 22:17:42',1,1),(19,1,'新鲜时蔬',7,1,'2022-06-09 22:18:12','2022-06-09 22:18:28',1,1),(20,1,'水煮鱼',8,1,'2022-06-09 22:22:29','2022-06-09 22:23:45',1,1),(21,1,'汤类',11,1,'2022-06-10 10:51:47','2022-06-10 10:51:47',1,1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish`
--

DROP TABLE IF EXISTS `dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dish` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '菜品名称',
  `category_id` bigint(20) NOT NULL COMMENT '菜品分类id',
  `price` decimal(10,2) DEFAULT NULL COMMENT '菜品价格',
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '描述信息',
  `status` int(11) DEFAULT '1' COMMENT '0 停售 1 起售',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_dish_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish`
--

LOCK TABLES `dish` WRITE;
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
INSERT INTO `dish` VALUES (46,'王老吉',11,6.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/d56e0f46-7898-4bea-bd8e-e3b5982f4d5a.png','',1,'2022-06-09 22:40:47','2024-03-06 15:51:57',1,1),(47,'北冰洋',11,4.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/39556647-dcbf-4fb6-ad9f-19790e9fb26c.png','还是小时候的味道',1,'2022-06-10 09:18:49','2024-03-06 15:52:06',1,1),(48,'雪花啤酒',11,4.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/8fb5f82a-b482-453d-9d25-c7fb8a8dcc87.png','',1,'2022-06-10 09:22:54','2024-03-06 15:52:19',1,1),(49,'米饭',12,2.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/0928e094-1bc2-4f5f-bf0a-a39a1d8f498d.png','精选五常大米',1,'2022-06-10 09:30:17','2024-03-06 15:52:30',1,1),(50,'馒头',12,1.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/051c1507-d8da-4979-94c4-12c0ae28c585.png','优质面粉',1,'2022-06-10 09:34:28','2024-03-06 15:52:53',1,1),(51,'老坛酸菜鱼',20,56.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/f66ead71-e5f4-427e-afca-e6a5f3bdd5ca.png','原料：汤，草鱼，酸菜',1,'2022-06-10 09:40:51','2024-03-06 15:53:05',1,1),(52,'经典酸菜鮰鱼',20,66.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/a3d23ab5-5165-471e-83ed-f6e28bb52033.png','原料：酸菜，江团，鮰鱼',1,'2022-06-10 09:46:02','2024-03-06 15:53:17',1,1),(53,'蜀味水煮草鱼',20,38.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/78e0a496-98bb-46d4-95c0-232bebe5add1.png','原料：草鱼，汤',1,'2022-06-10 09:48:37','2024-03-06 15:53:26',1,1),(54,'清炒小油菜',19,18.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/f2e11fb2-7f6a-467e-904d-cea3edbae15f.png','原料：小油菜',1,'2022-06-10 09:51:46','2024-03-06 15:53:34',1,1),(55,'蒜蓉娃娃菜',19,18.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/bd50b92c-3b3e-4fdd-8fa5-51c01dbea0e5.png','原料：蒜，娃娃菜',1,'2022-06-10 09:53:37','2024-03-06 15:51:49',1,1),(56,'清炒西兰花',19,18.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/3a340b6d-512a-4ba8-bf49-4be5f9b4dcfc.png','原料：西兰花',1,'2022-06-10 09:55:44','2024-03-06 15:51:40',1,1),(57,'炝炒圆白菜',19,18.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/31b19b44-79fb-4bf8-aac5-3a6706d6c5de.png','原料：圆白菜',1,'2022-06-10 09:58:35','2024-03-06 15:51:32',1,1),(58,'清蒸鲈鱼',18,98.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/ec012a3c-54ac-486f-ac10-9052d8bd6280.png','原料：鲈鱼',1,'2022-06-10 10:12:28','2024-03-06 15:51:23',1,1),(59,'东坡肘子',18,138.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/f1e9c400-caac-4866-aa2a-6b5342ff68b9.png','原料：猪肘棒',1,'2022-06-10 10:24:03','2024-03-06 15:51:03',1,1),(60,'梅菜扣肉',18,58.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/89aaf4d2-41cb-4cca-9af7-49af8a2229a9.png','原料：猪肉，梅菜',1,'2022-06-10 10:26:03','2024-03-06 15:50:52',1,1),(61,'剁椒鱼头',18,66.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/c768a054-abbd-48ca-9e14-98e00953443e.png','原料：鲢鱼，剁椒',1,'2022-06-10 10:28:54','2024-03-06 15:50:45',1,1),(62,'金汤酸菜牛蛙',17,88.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/3a745c52-0f73-44fc-87e0-287e1351cedb.png','原料：鲜活牛蛙，酸菜',1,'2022-06-10 10:33:05','2024-03-06 15:50:37',1,1),(63,'香锅牛蛙',17,88.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/d6680976-0359-46ca-be86-5ec0f72b187e.png','配料：鲜活牛蛙，莲藕，青笋',1,'2022-06-10 10:35:40','2024-03-06 15:50:30',1,1),(64,'馋嘴牛蛙',17,90.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/de456e9a-36b7-4dcc-adf8-91dbccf38d72.png','配料：鲜活牛蛙，丝瓜，黄豆芽',1,'2022-06-10 10:37:52','2024-03-06 15:50:22',1,1),(65,'草鱼2斤',16,68.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/637aa529-1aef-4110-9b1d-d15842951a60.png','原料：草鱼，黄豆芽，莲藕',1,'2022-06-10 10:41:08','2024-03-06 15:50:11',1,1),(66,'江团鱼2斤',16,119.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/8641f8e6-da4d-472d-8bc4-9b8d690569b6.png','配料：江团鱼，黄豆芽，莲藕',1,'2022-06-10 10:42:42','2024-03-06 15:50:05',1,1),(67,'鮰鱼2斤',16,72.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/e48578d9-1c77-43fa-8b5d-d4630f461323.png','原料：鮰鱼，黄豆芽，莲藕',1,'2022-06-10 10:43:56','2024-03-06 15:49:58',1,1),(68,'鸡蛋汤',21,4.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/b05a738c-56e4-44a5-903d-c62c758b31bd.png','配料：鸡蛋，紫菜',1,'2022-06-10 10:54:25','2024-02-29 10:58:48',1,1),(69,'平菇豆腐汤',21,10.00,'https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/e9d4d07e-57b8-4363-a1f4-b5bba02366a4.png','配料：豆腐，平菇',1,'2022-06-10 10:55:02','2024-02-29 10:51:11',1,1);
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish_flavor`
--

DROP TABLE IF EXISTS `dish_flavor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dish_flavor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dish_id` bigint(20) NOT NULL COMMENT '菜品',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '口味名称',
  `value` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '口味数据list',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜品口味关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish_flavor`
--

LOCK TABLES `dish_flavor` WRITE;
/*!40000 ALTER TABLE `dish_flavor` DISABLE KEYS */;
INSERT INTO `dish_flavor` VALUES (40,10,'甜味','[\"无糖\",\"少糖\",\"半糖\",\"多糖\",\"全糖\"]'),(41,7,'忌口','[\"不要葱\",\"不要蒜\",\"不要香菜\",\"不要辣\"]'),(42,7,'温度','[\"热饮\",\"常温\",\"去冰\",\"少冰\",\"多冰\"]'),(45,6,'忌口','[\"不要葱\",\"不要蒜\",\"不要香菜\",\"不要辣\"]'),(46,6,'辣度','[\"不辣\",\"微辣\",\"中辣\",\"重辣\"]'),(47,5,'辣度','[\"不辣\",\"微辣\",\"中辣\",\"重辣\"]'),(48,5,'甜味','[\"无糖\",\"少糖\",\"半糖\",\"多糖\",\"全糖\"]'),(49,2,'甜味','[\"无糖\",\"少糖\",\"半糖\",\"多糖\",\"全糖\"]'),(50,4,'甜味','[\"无糖\",\"少糖\",\"半糖\",\"多糖\",\"全糖\"]'),(51,3,'甜味','[\"无糖\",\"少糖\",\"半糖\",\"多糖\",\"全糖\"]'),(52,3,'忌口','[\"不要葱\",\"不要蒜\",\"不要香菜\",\"不要辣\"]'),(104,70,'甜味','[\"无糖\",\"少糖\",\"半糖\",\"多糖\",\"全糖\"]'),(105,70,'忌口','[\"不要葱\",\"不要蒜\",\"不要香菜\",\"不要辣\"]'),(106,70,'温度','[\"热饮\",\"常温\",\"去冰\",\"少冰\",\"多冰\"]'),(107,70,'辣度','[\"不辣\",\"微辣\",\"中辣\",\"重辣\"]'),(108,71,'',''),(109,69,'温度','[\"热饮\",\"常温\",\"去冰\",\"少冰\",\"多冰\"]'),(110,46,'辣度','[\"不辣\",\"微辣\",\"中辣\",\"重辣\"]'),(111,47,'辣度','[\"不辣\",\"微辣\",\"中辣\",\"重辣\"]'),(112,48,'甜味','[\"无糖\",\"少糖\",\"半糖\",\"多糖\",\"全糖\"]'),(113,49,'甜味','[\"无糖\",\"少糖\",\"半糖\",\"多糖\",\"全糖\"]'),(114,50,'甜味','[\"无糖\",\"少糖\",\"半糖\",\"多糖\",\"全糖\"]'),(115,51,'甜味','[\"无糖\",\"少糖\",\"半糖\",\"多糖\",\"全糖\"]'),(116,52,'忌口','[\"不要葱\",\"不要蒜\",\"不要香菜\",\"不要辣\"]');
/*!40000 ALTER TABLE `dish_flavor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `username` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `phone` varchar(11) COLLATE utf8_bin NOT NULL COMMENT '手机号',
  `sex` varchar(2) COLLATE utf8_bin NOT NULL COMMENT '性别',
  `id_number` varchar(18) COLLATE utf8_bin NOT NULL COMMENT '身份证号',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0:禁用，1:启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='员工信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'管理员','admin','e10adc3949ba59abbe56e057f20f883e','13812312312','1','110101199001010047',1,'2022-02-15 15:51:20','2022-02-17 09:16:20',10,1),(2,'李四','lisi','e10adc3949ba59abbe56e057f20f883e','15837577777','1','410482199904205033',1,'2024-02-26 19:17:12','2024-02-26 19:17:12',10,10),(6,'王五','wangwu','e10adc3949ba59abbe56e057f20f883e','18763908310','1','410482199909214033',1,'2024-02-26 19:22:58','2024-02-26 19:22:58',10,10),(11,'王五','wangwu1','e10adc3949ba59abbe56e057f20f883e','18763908310','0','410482199909214033',1,'2024-02-26 20:41:11','2024-02-28 10:11:21',1,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '名字',
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `dish_id` bigint(20) DEFAULT NULL COMMENT '菜品id',
  `setmeal_id` bigint(20) DEFAULT NULL COMMENT '套餐id',
  `dish_flavor` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '口味',
  `number` int(11) NOT NULL DEFAULT '1' COMMENT '数量',
  `amount` decimal(10,2) NOT NULL COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单明细表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (13,'馋嘴牛蛙','https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/de456e9a-36b7-4dcc-adf8-91dbccf38d72.png',9,64,NULL,NULL,1,90.00),(14,'香锅牛蛙','https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/d6680976-0359-46ca-be86-5ec0f72b187e.png',10,63,NULL,NULL,1,88.00),(15,'香锅牛蛙','https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/d6680976-0359-46ca-be86-5ec0f72b187e.png',11,63,NULL,NULL,2,88.00),(16,'香锅牛蛙','https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/d6680976-0359-46ca-be86-5ec0f72b187e.png',12,63,NULL,NULL,1,88.00),(17,'香锅牛蛙','https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/d6680976-0359-46ca-be86-5ec0f72b187e.png',13,63,NULL,NULL,1,88.00),(18,'香锅牛蛙','https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/d6680976-0359-46ca-be86-5ec0f72b187e.png',14,63,NULL,NULL,2,88.00),(19,'馋嘴牛蛙','https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/de456e9a-36b7-4dcc-adf8-91dbccf38d72.png',15,64,NULL,NULL,1,90.00);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '订单号',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '订单状态 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消 7退款',
  `user_id` bigint(20) NOT NULL COMMENT '下单用户',
  `address_book_id` bigint(20) NOT NULL COMMENT '地址id',
  `order_time` datetime NOT NULL COMMENT '下单时间',
  `checkout_time` datetime DEFAULT NULL COMMENT '结账时间',
  `pay_method` int(11) NOT NULL DEFAULT '1' COMMENT '支付方式 1微信,2支付宝',
  `pay_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '支付状态 0未支付 1已支付 2退款',
  `amount` decimal(10,2) NOT NULL COMMENT '实收金额',
  `remark` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `phone` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `user_name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名称',
  `consignee` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人',
  `cancel_reason` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '订单取消原因',
  `rejection_reason` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '订单拒绝原因',
  `cancel_time` datetime DEFAULT NULL COMMENT '订单取消时间',
  `estimated_delivery_time` datetime DEFAULT NULL COMMENT '预计送达时间',
  `delivery_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '配送状态  1立即送出  0选择具体时间',
  `delivery_time` datetime DEFAULT NULL COMMENT '送达时间',
  `pack_amount` int(11) DEFAULT NULL COMMENT '打包费',
  `tableware_number` int(11) DEFAULT NULL COMMENT '餐具数量',
  `tableware_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '餐具数量状态  1按餐量提供  0选择具体数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (9,'1709869993248',5,1,1,'2024-03-08 11:53:13','2024-03-08 11:53:14',1,1,97.00,'','15737571998','朝阳北三环',NULL,'你好',NULL,NULL,NULL,'2024-03-08 12:53:00',0,'2024-03-10 15:50:23',1,0,0),(10,'1709870467401',5,1,1,'2024-03-08 12:01:07','2024-03-08 12:01:09',1,1,95.00,'','15737571998','朝阳北三环',NULL,'你好',NULL,NULL,NULL,'2024-03-08 13:01:00',0,'2024-03-10 15:50:23',1,0,0),(11,'1709870542871',5,1,1,'2024-03-08 12:02:23','2024-03-08 12:02:24',1,1,184.00,'','15737571998','朝阳北三环',NULL,'你好',NULL,NULL,NULL,'2024-03-08 13:02:00',0,'2024-03-10 15:50:23',2,0,0),(12,'1709883279483',5,1,1,'2024-03-08 15:34:39','2024-03-08 15:34:40',1,1,95.00,'','15737571998','朝阳北三环',NULL,'你好',NULL,NULL,NULL,'2024-03-08 16:34:00',0,'2024-03-10 15:50:22',1,0,0),(13,'1709883325959',5,1,1,'2024-03-08 15:35:26','2024-03-08 15:35:27',1,1,95.00,'','15737571998','朝阳北三环',NULL,'你好',NULL,NULL,NULL,'2024-03-08 16:35:00',0,'2024-03-10 15:50:22',1,0,0),(14,'1709883523326',5,1,1,'2024-03-08 15:38:43','2024-03-08 15:38:47',1,1,184.00,'','15737571998','朝阳北三环',NULL,'你好',NULL,NULL,NULL,'2024-03-08 16:38:00',0,'2024-03-10 15:50:22',2,0,0),(15,'1710070045800',5,1,1,'2024-03-10 19:27:26','2024-03-10 19:27:30',1,1,97.00,'','15737571998','朝阳北三环',NULL,'你好',NULL,NULL,NULL,'2024-03-10 20:27:00',0,'2024-03-10 19:28:18',1,0,0);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setmeal`
--

DROP TABLE IF EXISTS `setmeal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `setmeal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` bigint(20) NOT NULL COMMENT '菜品分类id',
  `name` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '套餐名称',
  `price` decimal(10,2) NOT NULL COMMENT '套餐价格',
  `status` int(11) DEFAULT '1' COMMENT '售卖状态 0:停售 1:起售',
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '描述信息',
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_setmeal_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='套餐';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setmeal`
--

LOCK TABLES `setmeal` WRITE;
/*!40000 ALTER TABLE `setmeal` DISABLE KEYS */;
INSERT INTO `setmeal` VALUES (2,13,'vMe50',50.00,1,'豪华超值套餐','https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/a9c4b832-ba84-4407-9658-5269fbdd19a7.png','2024-02-29 15:47:18','2024-02-29 16:35:04',1,1),(3,15,'vM50',50.10,0,'新的套餐','https://sky-take-out-gsf.oss-cn-beijing.aliyuncs.com/d2b39015-2a7c-47c3-9dab-5ef19e323d87.png','2024-02-29 16:12:23','2024-02-29 16:35:06',1,1);
/*!40000 ALTER TABLE `setmeal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setmeal_dish`
--

DROP TABLE IF EXISTS `setmeal_dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `setmeal_dish` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `setmeal_id` bigint(20) DEFAULT NULL COMMENT '套餐id',
  `dish_id` bigint(20) DEFAULT NULL COMMENT '菜品id',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '菜品名称 （冗余字段）',
  `price` decimal(10,2) DEFAULT NULL COMMENT '菜品单价（冗余字段）',
  `copies` int(11) DEFAULT NULL COMMENT '菜品份数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='套餐菜品关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setmeal_dish`
--

LOCK TABLES `setmeal_dish` WRITE;
/*!40000 ALTER TABLE `setmeal_dish` DISABLE KEYS */;
INSERT INTO `setmeal_dish` VALUES (10,2,49,'米饭',2.00,1),(11,2,48,'雪花啤酒',4.00,1),(12,2,69,'平菇豆腐汤',10.00,1),(19,3,55,'蒜蓉娃娃菜',18.00,1),(20,3,66,'江团鱼2斤',119.00,1),(21,3,64,'馋嘴牛蛙',88.00,1);
/*!40000 ALTER TABLE `setmeal_dish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopping_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '商品名称',
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `user_id` bigint(20) NOT NULL COMMENT '主键',
  `dish_id` bigint(20) DEFAULT NULL COMMENT '菜品id',
  `setmeal_id` bigint(20) DEFAULT NULL COMMENT '套餐id',
  `dish_flavor` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '口味',
  `number` int(11) NOT NULL DEFAULT '1' COMMENT '数量',
  `amount` decimal(10,2) NOT NULL COMMENT '金额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='购物车';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `openid` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '微信用户唯一标识',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `phone` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `sex` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `id_number` varchar(18) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号',
  `avatar` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'oDXW66__CXGs-jVrvtsxNgYPnOHw',NULL,NULL,NULL,NULL,NULL,'2024-03-04 11:17:59');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-11 15:51:30
