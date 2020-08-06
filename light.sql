/*
Navicat MySQL Data Transfer

Source Server         : dmbjz
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : light

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2020-08-05 19:21:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for crm_banner
-- ----------------------------
DROP TABLE IF EXISTS `crm_banner`;
CREATE TABLE `crm_banner` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT 'ID',
  `title` varchar(20) DEFAULT '' COMMENT '标题',
  `image_url` varchar(500) NOT NULL DEFAULT '' COMMENT '图片地址',
  `link_url` varchar(500) DEFAULT '' COMMENT '链接地址',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='首页banner表';

-- ----------------------------
-- Records of crm_banner
-- ----------------------------
INSERT INTO `crm_banner` VALUES ('1288853850979078145', 'Shopee跨境电商实战教学', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/30/e90785afc6014853b4f7334f2c46978c下载 (3).jpg', '', '0', '1', '2020-07-30 23:07:58', '2020-08-01 10:54:37');
INSERT INTO `crm_banner` VALUES ('1288857611776593921', 'IOS高级开发集训营', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/30/3f860a8bcaca4d72b08ad8630a13947b下载.jpg', '', '0', '0', '2020-07-30 23:22:55', '2020-08-01 10:35:00');
INSERT INTO `crm_banner` VALUES ('1288859017233338369', '小白165天逆袭全栈工程师', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/30/6a41f797911e414c80af7bd85b6c5d9a下载 (1).jpg', '', '0', '0', '2020-07-30 23:28:30', '2020-07-30 23:32:05');

-- ----------------------------
-- Table structure for edu_chapter
-- ----------------------------
DROP TABLE IF EXISTS `edu_chapter`;
CREATE TABLE `edu_chapter` (
  `id` char(19) NOT NULL COMMENT '章节ID',
  `course_id` char(19) NOT NULL COMMENT '课程ID',
  `title` varchar(50) NOT NULL COMMENT '章节名称',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '显示排序',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程';

-- ----------------------------
-- Records of edu_chapter
-- ----------------------------
INSERT INTO `edu_chapter` VALUES ('1287692551121362946', '1287692488794005505', '环境搭建', '1', '2020-07-27 18:13:23', '2020-07-27 18:13:23');
INSERT INTO `edu_chapter` VALUES ('1287692780935667714', '1287692488794005505', '后台实现', '2', '2020-07-27 18:14:17', '2020-07-27 18:14:17');
INSERT INTO `edu_chapter` VALUES ('1287693143281590274', '1287692488794005505', '前台实现', '0', '2020-07-27 18:15:44', '2020-07-27 18:15:44');
INSERT INTO `edu_chapter` VALUES ('1287693321539510273', '1287692488794005505', '系统测试', '0', '2020-07-27 18:16:26', '2020-07-27 18:16:26');
INSERT INTO `edu_chapter` VALUES ('1287728748782727170', '1287728708148310018', '环境搭建', '0', '2020-07-27 20:37:13', '2020-07-27 20:37:13');
INSERT INTO `edu_chapter` VALUES ('1287728784434311170', '1287728708148310018', '微信小程序入门', '0', '2020-07-27 20:37:21', '2020-07-27 20:37:21');
INSERT INTO `edu_chapter` VALUES ('1287728830093504513', '1287728708148310018', '后端搭建', '0', '2020-07-27 20:37:32', '2020-07-27 20:37:32');
INSERT INTO `edu_chapter` VALUES ('1287728861554978818', '1287728708148310018', '腾讯云上线部署', '0', '2020-07-27 20:37:40', '2020-07-27 20:37:40');
INSERT INTO `edu_chapter` VALUES ('1287916594793615362', '1287916487025168386', ' 支付宝小程序基础架构', '0', '2020-07-28 09:03:39', '2020-07-28 09:03:39');
INSERT INTO `edu_chapter` VALUES ('1287916651026649089', '1287916487025168386', '支付宝小程序首页模块开发', '0', '2020-07-28 09:03:52', '2020-07-28 09:03:52');
INSERT INTO `edu_chapter` VALUES ('1287916798347382785', '1287916487025168386', '后端内容扩展', '0', '2020-07-28 09:04:27', '2020-07-28 09:04:27');
INSERT INTO `edu_chapter` VALUES ('1288119174090055682', '1288119126707003393', '环境及框架准备【必备基础】', '0', '2020-07-28 22:28:37', '2020-07-28 22:28:37');
INSERT INTO `edu_chapter` VALUES ('1288119202204475394', '1288119126707003393', 'TP6基础知识【新框架】', '0', '2020-07-28 22:28:44', '2020-07-28 22:28:44');
INSERT INTO `edu_chapter` VALUES ('1288119235565969410', '1288119126707003393', '商城项目需求整体分析以及前期准备工作', '0', '2020-07-28 22:28:52', '2020-07-28 22:28:52');
INSERT INTO `edu_chapter` VALUES ('1288119264259203073', '1288119126707003393', '用户后台管理模块', '0', '2020-07-28 22:28:59', '2020-07-28 22:28:59');
INSERT INTO `edu_chapter` VALUES ('1288119291379572738', '1288119126707003393', '商城前端登录模块开发', '0', '2020-07-28 22:29:05', '2020-07-28 22:29:05');
INSERT INTO `edu_chapter` VALUES ('1288309093211062274', '1288309023887605762', '准备工作【工欲善其事，必先利其器】', '0', '2020-07-29 11:03:18', '2020-07-29 11:03:18');
INSERT INTO `edu_chapter` VALUES ('1288309126392201217', '1288309023887605762', 'SpringBoot 开发框架【基础打不牢，学问攀不高】', '0', '2020-07-29 11:03:26', '2020-07-29 11:03:26');
INSERT INTO `edu_chapter` VALUES ('1288309159975993346', '1288309023887605762', '系统通用组件搭建【要想上梯子，必须从底下爬起】', '0', '2020-07-29 11:03:34', '2020-07-29 11:03:34');
INSERT INTO `edu_chapter` VALUES ('1288309189923323905', '1288309023887605762', ' 微服务系统通用配置开发【企业级开发常见抽象】', '0', '2020-07-29 11:03:41', '2020-07-29 11:03:41');
INSERT INTO `edu_chapter` VALUES ('1288309219157622786', '1288309023887605762', '优惠券系统整体业务思想与架构【编码之前先要做好设计】', '0', '2020-07-29 11:03:48', '2020-07-29 11:03:48');
INSERT INTO `edu_chapter` VALUES ('1288309257191571458', '1288309023887605762', '优惠券模板微服务编码实现【第一个功能微服务，注重细节与思路】', '0', '2020-07-29 11:03:57', '2020-07-29 11:03:57');
INSERT INTO `edu_chapter` VALUES ('1288309294889975810', '1288309023887605762', ' 优惠券分发微服务功能定义说明【持续实践、得心应手】', '0', '2020-07-29 11:04:06', '2020-07-29 11:04:06');
INSERT INTO `edu_chapter` VALUES ('1288309329560092673', '1288309023887605762', ' 优惠券分发微服务功能编码实现【持续实践、得心应手】', '0', '2020-07-29 11:04:14', '2020-07-29 11:04:14');
INSERT INTO `edu_chapter` VALUES ('1288309374095212545', '1288309023887605762', '优惠券结算微服务编码实现【继续开发，渐入佳境】', '0', '2020-07-29 11:04:25', '2020-07-29 11:04:25');
INSERT INTO `edu_chapter` VALUES ('1288309412556980225', '1288309023887605762', ' 优惠券系统可用性测试【开发完功能，验证下是否好用】', '0', '2020-07-29 11:04:34', '2020-07-29 11:04:34');
INSERT INTO `edu_chapter` VALUES ('1288309450796449793', '1288309023887605762', '（番外彩蛋篇一）用户权限系统的开发与集成', '0', '2020-07-29 11:04:43', '2020-07-29 11:04:43');
INSERT INTO `edu_chapter` VALUES ('1288309502956814337', '1288309023887605762', '（番外彩蛋篇二）前端页面完善', '0', '2020-07-29 11:04:55', '2020-07-29 11:04:55');
INSERT INTO `edu_chapter` VALUES ('1288310594675425282', '1288310524735406081', '第1章 课程介绍', '0', '2020-07-29 11:09:16', '2020-07-29 11:09:16');
INSERT INTO `edu_chapter` VALUES ('1288310620185182210', '1288310524735406081', '第2章 项目概要设计&数据表设计', '0', '2020-07-29 11:09:22', '2020-07-29 11:09:22');
INSERT INTO `edu_chapter` VALUES ('1288310646487662594', '1288310524735406081', '第3章 SpringBoot工程框架搭建与技巧', '0', '2020-07-29 11:09:28', '2020-07-29 11:09:28');
INSERT INTO `edu_chapter` VALUES ('1288310670525218817', '1288310524735406081', '第4章 用户注册及个人页面功能开发', '0', '2020-07-29 11:09:34', '2020-07-29 11:09:34');
INSERT INTO `edu_chapter` VALUES ('1288310702779416578', '1288310524735406081', '第5章 房产和推荐功能开发（分页组件、Ajax、Redis）', '0', '2020-07-29 11:09:41', '2020-07-29 11:09:41');
INSERT INTO `edu_chapter` VALUES ('1288314013494558722', '1288313904581066754', '第1章 课程导学与准备工作', '0', '2020-07-29 11:22:51', '2020-07-29 11:22:51');
INSERT INTO `edu_chapter` VALUES ('1288314252880265217', '1288313904581066754', '第2章 企业级App重构之路', '0', '2020-07-29 11:23:48', '2020-07-29 11:23:48');
INSERT INTO `edu_chapter` VALUES ('1288314288083058689', '1288313904581066754', '第3章 登录业务组件化重构', '0', '2020-07-29 11:23:56', '2020-07-29 11:23:56');
INSERT INTO `edu_chapter` VALUES ('1288316347054309377', '1288316291471392770', ' 第1章 课程介绍', '0', '2020-07-29 11:32:07', '2020-07-29 11:32:07');
INSERT INTO `edu_chapter` VALUES ('1288316370571771905', '1288316291471392770', ' 第2章 Hybrid 技术原理', '0', '2020-07-29 11:32:13', '2020-07-29 11:32:13');
INSERT INTO `edu_chapter` VALUES ('1288316396802949121', '1288316291471392770', ' 第3章 开发前的准备', '0', '2020-07-29 11:32:19', '2020-07-29 11:32:19');
INSERT INTO `edu_chapter` VALUES ('1288316438234284034', '1288316291471392770', '第4章 京东商城首页（上）', '0', '2020-07-29 11:32:29', '2020-07-29 11:32:29');
INSERT INTO `edu_chapter` VALUES ('1288316460971606018', '1288316291471392770', '第5章 京东商城首页（下）', '0', '2020-07-29 11:32:34', '2020-07-29 11:32:34');
INSERT INTO `edu_chapter` VALUES ('1288317353456582658', '1288317235273678850', '第1章 课程概述', '0', '2020-07-29 11:36:07', '2020-07-29 11:36:07');
INSERT INTO `edu_chapter` VALUES ('1288317375338266625', '1288317235273678850', '第2章 EasySwoole框架快速上手', '0', '2020-07-29 11:36:12', '2020-07-29 11:36:12');
INSERT INTO `edu_chapter` VALUES ('1288317397769404418', '1288317235273678850', ' 第3章 性能测试', '0', '2020-07-29 11:36:18', '2020-07-29 11:36:18');
INSERT INTO `edu_chapter` VALUES ('1288317421739851777', '1288317235273678850', '第4章 玩转高性能消息队列服务', '0', '2020-07-29 11:36:23', '2020-07-29 11:36:23');
INSERT INTO `edu_chapter` VALUES ('1288317448554037249', '1288317235273678850', '第5章 小视频服务平台 - 前后端分离以及平台后端整体架构', '0', '2020-07-29 11:36:30', '2020-07-29 11:36:30');

-- ----------------------------
-- Table structure for edu_comment
-- ----------------------------
DROP TABLE IF EXISTS `edu_comment`;
CREATE TABLE `edu_comment` (
  `id` char(19) NOT NULL COMMENT '讲师ID',
  `course_id` varchar(19) NOT NULL DEFAULT '' COMMENT '课程id',
  `teacher_id` char(19) NOT NULL DEFAULT '' COMMENT '讲师id',
  `member_id` varchar(19) NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '会员头像',
  `content` varchar(500) DEFAULT NULL COMMENT '评论内容',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_teacher_id` (`teacher_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论';

-- ----------------------------
-- Records of edu_comment
-- ----------------------------
INSERT INTO `edu_comment` VALUES ('1194898406466420738', '1287728708148310018', '1189389726308478977', '1', 'hello', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '11', '0', '2019-11-14 16:42:35', '2019-11-14 16:42:35');
INSERT INTO `edu_comment` VALUES ('1194898484388200450', '1287728708148310018', '1189389726308478977', '1', 'word', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '111', '0', '2019-11-14 16:42:53', '2019-11-14 16:42:53');
INSERT INTO `edu_comment` VALUES ('1195251020861317122', '1287728708148310018', '1189389726308478977', '1', null, 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', '2233', '0', '2019-11-15 16:03:45', '2019-11-15 16:03:45');
INSERT INTO `edu_comment` VALUES ('1195251382720700418', '1287728708148310018', '1189389726308478977', '1', null, 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', '4455', '0', '2019-11-15 16:05:11', '2019-11-15 16:05:11');
INSERT INTO `edu_comment` VALUES ('1195252819177570306', '1287728708148310018', '1189389726308478977', '1', '小三1231', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', '55', '0', '2019-11-15 16:10:53', '2019-11-15 16:10:53');
INSERT INTO `edu_comment` VALUES ('1195252899448160258', '1287728708148310018', '1189389726308478977', '1', '小三1231', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', '55', '0', '2019-11-15 16:11:13', '2019-11-15 16:11:13');
INSERT INTO `edu_comment` VALUES ('1195252920587452417', '1287728708148310018', '1189389726308478977', '1', '小三1231', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', '223344', '0', '2019-11-15 16:11:18', '2019-11-15 16:11:18');
INSERT INTO `edu_comment` VALUES ('1196264505170767874', '1287728708148310018', '1189389726308478977', '1', '小三1231', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '666666', '0', '2019-11-18 11:10:58', '2019-11-18 11:10:58');
INSERT INTO `edu_comment` VALUES ('1289492519469547521', '1287728708148310018', '1189389726308478977', '1288715177314787330', 'dmbjz', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', '111111', '0', '2020-08-01 17:25:48', '2020-08-01 17:25:48');
INSERT INTO `edu_comment` VALUES ('1289555065232785409', '1287728708148310018', '1189389726308478977', '1288715177314787330', 'dmbjz', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', 'aaaa', '0', '2020-08-01 21:34:20', '2020-08-01 21:34:20');
INSERT INTO `edu_comment` VALUES ('1289572616042020865', '1287728708148310018', '1189389726308478977', '1288715177314787330', 'dmbjz', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', 'qwqwqw', '0', '2020-08-01 22:44:05', '2020-08-01 22:44:05');
INSERT INTO `edu_comment` VALUES ('1289572833701142530', '1287728708148310018', '1189389726308478977', '1288715177314787330', 'dmbjz', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', 'asda', '0', '2020-08-01 22:44:57', '2020-08-01 22:44:57');
INSERT INTO `edu_comment` VALUES ('1289572833701142531', '1287728708148310018', '1189389726308478977', '1288715177314787330', 'dmbjz', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', 'asda', '0', '2020-08-01 22:44:57', '2020-08-01 22:44:57');
INSERT INTO `edu_comment` VALUES ('1289572994217156610', '1287916487025168386', '1192327476087115778', '1288715177314787330', 'dmbjz', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', '我觉得还行', '0', '2020-08-01 22:45:35', '2020-08-01 22:45:35');
INSERT INTO `edu_comment` VALUES ('1290121723726860290', '1287916487025168386', '1192327476087115778', '1288715177314787330', 'dmbjz', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', '能学到新知识，好评', '0', '2020-08-03 11:06:02', '2020-08-03 11:06:02');
INSERT INTO `edu_comment` VALUES ('1290536875810963457', '1287916487025168386', '1192327476087115778', '1288715177314787330', 'dmbjz', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', '学到了，谢谢', '0', '2020-08-04 14:35:42', '2020-08-04 14:35:42');
INSERT INTO `edu_comment` VALUES ('1290552171414188033', '1290551067192356866', '1286314995398737921', '1288715177314787330', 'dmbjz', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', '测试', '0', '2020-08-04 15:36:29', '2020-08-04 15:36:29');

-- ----------------------------
-- Table structure for edu_course
-- ----------------------------
DROP TABLE IF EXISTS `edu_course`;
CREATE TABLE `edu_course` (
  `id` char(19) NOT NULL COMMENT '课程ID',
  `teacher_id` char(19) NOT NULL COMMENT '课程讲师ID',
  `subject_id` char(19) NOT NULL COMMENT '课程专业ID',
  `subject_parent_id` char(19) DEFAULT NULL COMMENT '课程专业父级ID',
  `title` varchar(50) NOT NULL COMMENT '课程标题',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '课程销售价格，设置为0则可免费观看',
  `lesson_num` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '总课时',
  `cover` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '课程封面图片路径',
  `buy_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '销售数量',
  `view_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '浏览数量',
  `version` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `status` varchar(10) NOT NULL DEFAULT '0' COMMENT '课程状态 Draft未发布  Normal已发布',
  `is_deleted` tinyint(3) DEFAULT NULL COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_title` (`title`),
  KEY `idx_subject_id` (`subject_id`),
  KEY `idx_teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程';

-- ----------------------------
-- Records of edu_course
-- ----------------------------
INSERT INTO `edu_course` VALUES ('1287692488794005505', '1213128382317873251', '1286845234382147586', '1286845234365370369', '虾米音乐SSM实战课程', '220.00', '45', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/cover/1.jpg', '357', '593', '1', '1', null, '2020-07-27 18:13:08', '2020-07-27 18:17:08');
INSERT INTO `edu_course` VALUES ('1287728708148310018', '1189389726308478977', '1286845234415702017', '1286845234365370369', 'SpringBoot微信仿抖音', '199.00', '80', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/cover/7.jpg', '847', '1231', '1', '1', null, '2020-07-27 20:37:03', '2020-07-27 20:40:06');
INSERT INTO `edu_course` VALUES ('1287916487025168386', '1192327476087115778', '1286845234205986818', '1286845234151460866', '支付宝商城小程序实战', '0.01', '68', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/cover/3.jpg', '120', '127', '1', '1', null, '2020-07-28 09:03:13', '2020-07-28 09:03:13');
INSERT INTO `edu_course` VALUES ('1288119126707003393', '1189389729308078910', '1286845234415702017', '1286845234365370369', 'TP6.0从0到1构建高并发电商服务系统', '0.00', '103', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/cover/4.png', '314', '462', '1', '1', null, '2020-07-28 22:28:26', '2020-07-28 22:29:34');
INSERT INTO `edu_course` VALUES ('1288309023887605762', '1192249914833055746', '1286845234415702020', '1286845234365370369', 'SpringCloud打造企业级优惠券系统', '0.00', '103', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/cover/5.png', '83', '136', '1', '1', null, '2020-07-29 11:03:01', '2020-07-29 11:07:39');
INSERT INTO `edu_course` VALUES ('1288310524735406081', '1182734823731731341', '1286845234415702020', '1286845234365370369', 'Java从单体到微服务打造房产销售平台', '0.00', '156', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/cover/1.jpg', '123', '4577', '1', '1', null, '2020-07-29 11:08:59', '2020-07-29 11:10:44');
INSERT INTO `edu_course` VALUES ('1288313904581066754', '1182734823731731341', '1286845234415702341', '1286845234365371241', '实战企业级项目 践行App重构之路', '299.00', '179', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/cover/2.jpg', '92', '123', '1', '1', null, '2020-07-29 11:22:25', '2020-07-29 11:24:29');
INSERT INTO `edu_course` VALUES ('1288316291471392770', '1189389726308478977', '1286845234415703412', '1286845234365371241', '混合开发入门 Vue结合Android/iOS开发仿京东项目App', '270.00', '84', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/cover/8.jpg', '123', '342', '1', '1', null, '2020-07-29 11:31:54', '2020-07-29 11:33:06');
INSERT INTO `edu_course` VALUES ('1288317235273678850', '1192249914833055746', '1286845234415702124', '1286845234365370369', 'EasySwoole+ElasticSearch 打造高性能小视频服务系统', '699.00', '145', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/cover/9.jpg', '70', '781', '1', '1', null, '2020-07-29 11:35:39', '2020-08-01 13:25:38');

-- ----------------------------
-- Table structure for edu_course_collect
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_collect`;
CREATE TABLE `edu_course_collect` (
  `id` char(19) NOT NULL COMMENT '收藏ID',
  `course_id` char(19) NOT NULL COMMENT '课程讲师ID',
  `member_id` char(19) NOT NULL DEFAULT '' COMMENT '课程专业ID',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程收藏';

-- ----------------------------
-- Records of edu_course_collect
-- ----------------------------

-- ----------------------------
-- Table structure for edu_course_description
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_description`;
CREATE TABLE `edu_course_description` (
  `id` char(19) NOT NULL COMMENT '课程ID',
  `description` longtext COMMENT '课程简介',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程简介';

-- ----------------------------
-- Records of edu_course_description
-- ----------------------------
INSERT INTO `edu_course_description` VALUES ('1287692488794005505', '高仿虾米音乐项目\n使用Ieda开发工具\n技术点：SSM+jersy+Bootstrap，通过Java反射手写分页逻辑\n前台实现歌曲播放/歌手查看/专辑查看，支持歌词滚动\n后台自动跳转到登录页，实现歌曲/歌手/流派/专辑的增删改查 + 注销登录\n', '2020-07-27 18:13:08', '2020-07-27 18:13:08');
INSERT INTO `edu_course_description` VALUES ('1287728708148310018', '本课程基于微信小程序和目前主流的后端技术SpringBoot/SpringMVC来实现一个完整的短视频小程序App。通过对本套课程的学习，可以使你独立开发一个短视频小程序并部署到腾讯云上，掌握全栈式开发，更是毕业设计利器！', '2020-07-27 20:37:03', '2020-07-27 20:37:03');
INSERT INTO `edu_course_description` VALUES ('1287916487025168386', '本课程选用线上真实项目进行教学，让你快速积累商业级小程序开发经验；同时采用RESTful风格API，对接线上数据，让你突破小程序与服务端交互难题。课程会从基础知识讲解到复杂原理剖析，让你在开发项目的同时学懂核心技术点；同时手把手写代码，即使前端新手也能看的懂学的会；最后课中结合老师丰富的开发经验，带你入坑出坑，让你在开发支付宝小程序的路上少走弯路，迅速成长。', '2020-07-28 09:03:13', '2020-07-28 09:03:13');
INSERT INTO `edu_course_description` VALUES ('1288119126707003393', '运用最新版TP6.0框架，结合讲师多年开发经验，本课程除了对TP6.0基础和电商逻辑整体开发进行讲解，还包含了企业级通用解决方案，如：消息队列、redis集群、分布式session解决方案、支付模块服务化、分布式锁、限流、容灾、服务降级、商品抢购、排队机制等高级的内容。整个课程手把手带你体验从需求分析、项目开发、系统优化、服务评估、再到项目部署上线的全流程。', '2020-07-28 22:28:26', '2020-07-28 22:28:26');
INSERT INTO `edu_course_description` VALUES ('1288309023887605762', '电商前端页面教程很多，完整而实用的优惠券系统教程却很少。本课程将手把手实战搭建优惠券系统，基于Java主流的微服务开发框架SpringCloud，结合常用工具MySQL、Redis、Kafka，通过优惠劵模板、分发和结算三个微服务完成电商优惠券系统核心业务，是小伙伴们毕设、加薪、跳槽、转型的必备利器。', '2020-07-29 11:03:01', '2020-07-29 11:03:01');
INSERT INTO `edu_course_description` VALUES ('1288310524735406081', '微服务是近年来非常流行的架构，是后端资深开发工程师必备技能。本课程将基于房产销售平台，首先带你进行单体开发，然后进行微服务架构改造，并深入剖析微服务架构原理。快速提升你的项目开发与微服务架构能力，更好的向资深开发工程师及架构师方向进阶。', '2020-07-29 11:08:59', '2020-07-29 11:08:59');
INSERT INTO `edu_course_description` VALUES ('1288313904581066754', '实战企业级项目 践行App重构之路\n随着企业级App功能不断累加强大，App代码质量下降、设计缺陷、难以维护、迭代困难等问题越来越突出，App的重构迭代已经成为Android工程师急需解决的核心工作内容。本课程还原一线互联网公司App所经历的重构过程，基于模块化，以组件化重构和插件化重构为核心，让大家掌握一线互联网公司App的最新架构和技术，并且能够解决重构过程中碰到的所有难题，更有助于拿到大厂offer。', '2020-07-29 11:22:25', '2020-07-29 11:22:25');
INSERT INTO `edu_course_description` VALUES ('1288316291471392770', '无需原生开发基础，也能完美呈现京东商城。本课程融合vue、Android、IOS等目前流行的前端和移动端技术，混合开发经典电商APP京东。课程将各种复杂功能与知识点完美融合，从技术原理到开发上线，让你真实感受到一个明星产品开发的全过程。功能实现之外，还有一流用户体验和优秀交互设计等你一探究竟，拓宽开发眼界。', '2020-07-29 11:31:54', '2020-07-29 11:31:54');
INSERT INTO `edu_course_description` VALUES ('1288317235273678850', '<p><strong>EasySwoole底层是基于swoole开发的常驻内存型的分布式PHP框架，专为API而生，是swoole专业型上层PHP框架，让开发者以最低的学习成本和精力编写出多进程，可异步，高可用的应用服务。本课程将理论结合实战，带你从基础开始系统学习EasySwoole框架, 同时利用EasySwoole带你打造高性能API服务，并结合分布式搜索引擎-ElasticSearch带你打造一个高性能小视频服务系统，让你从容处理各种高并发高性能业务场景。</strong></p>', '2020-07-29 11:35:39', '2020-08-01 13:25:38');

-- ----------------------------
-- Table structure for edu_subject
-- ----------------------------
DROP TABLE IF EXISTS `edu_subject`;
CREATE TABLE `edu_subject` (
  `id` char(19) NOT NULL COMMENT '课程类别ID',
  `title` varchar(12) NOT NULL COMMENT '类别名称',
  `parent_id` char(19) NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程科目';

-- ----------------------------
-- Records of edu_subject
-- ----------------------------
INSERT INTO `edu_subject` VALUES ('1286845234151460866', '前端开发', '0', '0', '2020-07-25 10:06:26', '2020-07-25 10:06:26');
INSERT INTO `edu_subject` VALUES ('1286845234172432386', 'JavaScript', '1286845234151460866', '0', '2020-07-25 10:06:26', '2020-07-25 10:06:26');
INSERT INTO `edu_subject` VALUES ('1286845234205986818', 'Vue', '1286845234151460866', '0', '2020-07-25 10:06:26', '2020-07-25 10:06:26');
INSERT INTO `edu_subject` VALUES ('1286845234235346946', 'Jquery', '1286845234151460866', '0', '2020-07-25 10:06:26', '2020-07-25 10:06:26');
INSERT INTO `edu_subject` VALUES ('1286845234264707073', 'EasyUI', '1286845234151460866', '0', '2020-07-25 10:06:26', '2020-07-25 10:06:26');
INSERT INTO `edu_subject` VALUES ('1286845234289872897', 'Bootstrap', '1286845234151460866', '0', '2020-07-25 10:06:26', '2020-07-25 10:06:26');
INSERT INTO `edu_subject` VALUES ('1286845234319233025', 'Axios', '1286845234151460866', '0', '2020-07-25 10:06:26', '2020-07-25 10:06:26');
INSERT INTO `edu_subject` VALUES ('1286845234348593154', 'ElementUI', '1286845234151460866', '0', '2020-07-25 10:06:26', '2020-07-25 10:06:26');
INSERT INTO `edu_subject` VALUES ('1286845234365370369', '后端开发', '0', '0', '2020-07-25 10:06:26', '2020-07-25 10:06:26');
INSERT INTO `edu_subject` VALUES ('1286845234365371241', '移动开发', '0', '0', '2020-07-16 11:14:17', '2020-08-08 11:14:20');
INSERT INTO `edu_subject` VALUES ('1286845234382147586', 'SSM', '1286845234365370369', '0', '2020-07-25 10:06:26', '2020-07-25 10:06:26');
INSERT INTO `edu_subject` VALUES ('1286845234415701723', 'Django', '1286845234365370369', '0', '2020-07-23 11:13:09', '2020-07-29 11:13:11');
INSERT INTO `edu_subject` VALUES ('1286845234415702017', 'SpringBoot', '1286845234365370369', '0', '2020-07-25 10:06:26', '2020-07-25 10:06:26');
INSERT INTO `edu_subject` VALUES ('1286845234415702020', 'SpringCloud', '1286845234365370369', '0', '2020-07-01 11:01:21', '2020-07-15 11:01:26');
INSERT INTO `edu_subject` VALUES ('1286845234415702124', 'PHP', '1286845234365370369', '0', '2020-07-29 11:12:27', '2020-07-29 11:12:30');
INSERT INTO `edu_subject` VALUES ('1286845234415702341', 'Android', '1286845234365371241', '0', '2020-07-04 11:15:06', '2020-07-09 11:15:10');
INSERT INTO `edu_subject` VALUES ('1286845234415703412', 'ios', '1286845234365371241', '0', '2020-07-10 11:15:38', '2020-07-30 11:15:42');

-- ----------------------------
-- Table structure for edu_teacher
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher`;
CREATE TABLE `edu_teacher` (
  `id` char(19) NOT NULL COMMENT '讲师ID',
  `name` varchar(20) NOT NULL COMMENT '讲师姓名',
  `intro` varchar(500) NOT NULL DEFAULT '' COMMENT '讲师简介',
  `career` varchar(500) DEFAULT NULL COMMENT '讲师资历,一句话说明讲师',
  `level` int(10) unsigned NOT NULL COMMENT '头衔 1高级讲师 2首席讲师',
  `avatar` varchar(255) DEFAULT NULL COMMENT '讲师头像',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='讲师';

-- ----------------------------
-- Records of edu_teacher
-- ----------------------------
INSERT INTO `edu_teacher` VALUES ('1128934820942781223', '星云', '20年+的软件开发和培训经验，历经JavaEE、Android和大数据三个时代，曾就职于京东等大中型企业，有着丰富的大数据架构搭建和大数据应用实战经验，熟悉电商系统的spark开发和hive等的数据仓库开发，对大数据框架的源码有深入了解', 'P8工程师', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/18686defce6f49cf9d22a2a20c1d3ee0file.png', '0', '0', '2020-06-11 21:08:05', '2020-07-29 15:24:33');
INSERT INTO `edu_teacher` VALUES ('1175293849284912341', '丁雷空', '渡一教育高级讲师，搜狐产品技术部资深web前端工程师，搜狐首页前端项目负责人。', 'P8工程师', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', '0', '0', '2020-06-11 21:10:29', '2020-07-29 15:24:21');
INSERT INTO `edu_teacher` VALUES ('1182734823731731341', '唐耀华', '复旦大学博士，具有多年海外留学经历，华东地区211高校副教授，人工智能方向专家，发表SCI论文20余篇，授权发明专利多项，与企业联系密切，曾多次帮助企业解决技术难题。', 'P8工程师', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/5f45a9fb43c94847adb3ffbf096b228afile.png', '0', '0', '2020-06-10 21:09:24', '2020-07-29 15:24:47');
INSERT INTO `edu_teacher` VALUES ('1189389726308478977', '连杨学', '5年大数据工作经验，曾任中国电信大数据主管，玖富集团技术架构师等职位，参与过中国电信用户移动轨迹分析平台，舆情分析系统，玖富金融平台等多个大型互联网项目，精通SSM，SpringBoot，SpringCloud等主流Java开源框架以及Hadoop，Kafka，Hive，HBASE Storm，Spark，Kylin等主流大数据技术。', 'P8工程师', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', '1', '0', '2020-05-30 11:53:03', '2020-07-21 22:00:07');
INSERT INTO `edu_teacher` VALUES ('1189389729308078910', '李彦亮', '13年IT行业工作经验！授课风趣幽默、课程中注重思想的传播、注重学习方法和学习习惯的养成。实战派专家，先后就职于中国住房公积金管理中心、中国工商银行、Oracle甲骨文公司。历任程序员、产品总监、架构师。熟悉Unix/Linux/Windows系统运维/网络运维/对云计算、虚拟化、容器技术有深刻理解。', 'P8工程师', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/18e6f7ed76b74abda3a18a78d4ffc68afile.png', '0', '0', '2020-05-30 11:53:03', '2020-07-29 15:24:59');
INSERT INTO `edu_teacher` VALUES ('1189390295668469762', '赵珊珊', '世界500强内训专家讲师，税务系统业务专家，从事多年培训行业。培养学员3000+，人美声甜会讲课，学生点名上课，深受欢迎。', 'P8工程师', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', '2', '0', '2020-05-30 11:53:03', '2020-07-21 22:00:07');
INSERT INTO `edu_teacher` VALUES ('1189426437876985857', '马士兵', 'Team Leader、Project Manager、CTO等职位，有过十几个大型项目的开发经验。 推动Java生根中国，推动大数据生根中国，推动AI生根中国，视频课程下载次数累计数十亿次。 目前正致力于打造像面授一样高质量的网课平台。', 'P8工程师', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/d3af1120dbdb471e95e6c97cc9adb3f4file.png', '0', '0', '2020-03-20 14:18:56', '2020-07-29 15:25:10');
INSERT INTO `edu_teacher` VALUES ('1189426464967995393', '李明喆', '千万量级大型互联网金融公司测试负责人，精通软件测试流程、Linux环境、MySQL数据库，具有丰富的互联网金融后台系统、大数据等测试经验；具有敏锐的问题洞察能力，带你快速定位问题。', 'P6工程师', '1', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/47042c9eb77e40db9d3e29457c839151file.png', '0', '0', '2020-03-20 14:18:56', '2020-07-29 15:25:31');
INSERT INTO `edu_teacher` VALUES ('1192249914833055746', '韩非', '曾任职华为担任架构师，参与华为云平台的架构设计，对分布式、微服务等架构设计有丰富的经验，对Spring Boot、Spring Cloud、消息队列等技术有深入研究', 'P8工程师', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/a613e8f2376a4831b9431bcf08a5f5edfile.png', '0', '0', '2020-03-20 14:18:56', '2020-07-29 15:25:20');
INSERT INTO `edu_teacher` VALUES ('1192327476087115778', '周瑜', '十年互联网电商、互联网金融行业从业经验，在系统架构设计、系统性能调优、高并发秒杀系统、开源项目等方面有非常丰富的经验。 曾任蚂蚁金服高级开发工程师、大众点评高级架构师，同时也是开源框架Dubbo的源码贡献者、鲁班学院金牌讲师。', 'P8工程师', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/26204f82d01046b1b1bb37b8994b124dfile.png', '0', '0', '2020-03-20 14:18:56', '2020-07-29 15:27:37');
INSERT INTO `edu_teacher` VALUES ('1195337453429129218', '许昭君', '曾就职于亚信、步步高集团高级工程师，有多年互联网技术开发管理经验，多次参与电商大促技术支持与保障。在分布式、微服务、高并发、高可用等技术架构具有丰富的实战经验，注重代码质量改善和敏捷开发实践。', 'P8工程师', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/dfc899ab33fa4ec4a5da486ace6fb76dfile.png', '0', '0', '2020-03-10 21:47:12', '2020-07-29 15:27:07');
INSERT INTO `edu_teacher` VALUES ('1213128382317873251', '诸葛', '图灵学院联合创始人 前唯品会京东资深架构师 十余年一线研发经验，曾就职于唯品会、京东电商等多家互联网公司，历任Java资深架构师、技术总监等职位，参与并主导多个千万级并发互联网产品研发，对大型分布式，高并发及微服务架构有非常深入研究。', 'P8工程师', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/fcbf8c53c02a4f058124b1a84408db4efile.png', '0', '0', '2020-07-02 21:04:47', '2020-07-29 15:25:44');
INSERT INTO `edu_teacher` VALUES ('1231391231412738123', '郭嘉', '前小米架构师 前步步高资深架构师 曾就职小米，步步高等多家互联网公司，近十年一线大厂研发经验，多年大型互联网电商与金融项目研发经验，曾主导过多个微服务架构项目落地实施，擅长JVM性能调优，分布式与微服务架构。', 'P7工程师', '1', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/07564ab3ac86400889f0ab915d2db3c9file.png', '0', '0', '2020-07-22 21:03:55', '2020-07-29 15:23:58');
INSERT INTO `edu_teacher` VALUES ('1285570340197527554', '刘子龙', '曾就职于同花顺， 猎聘网等互联网企业Java研发。主要方向为搜索引擎研发，参与主导了同花顺I问财平台研发，步步高搜索平台架构设计。', 'P7工程师', '1', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/5196cd8024524c2fb2731da19ff80737file.png', '0', '0', '2020-03-10 21:47:12', '2020-07-29 15:26:54');
INSERT INTO `edu_teacher` VALUES ('1286314995398737921', 'Frank', '曾参与某银行大型项目非功能测试，担任过互联网公司测试主管，熟悉各种测试方法，擅长性能测试。', 'P7工程师', '1', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/a1bfb0ba795d4d4bb7617d8d50a6afa9file.png', '1', '0', '2020-07-23 22:59:28', '2020-07-29 15:23:46');
INSERT INTO `edu_teacher` VALUES ('1286315647147454465', '宇轩英建', '小米有品首席架构师', 'P8工程师', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/3557d822af8349ee8a2bda1e3679ea112.jpg', '4', '1', '2020-07-23 23:02:03', '2020-07-23 23:02:03');
INSERT INTO `edu_teacher` VALUES ('1286461069308588033', 'Bob', '毕业于中南民族大学计算机专业，从事Android，python企业开发技术7年 曾在武汉某it创业型公司担任项目负责人', 'P7工程师', '1', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/3557d822af8349ee8a2bda1e3679ea112.jpg', '1', '1', '2020-07-24 08:39:54', '2020-07-24 08:39:54');
INSERT INTO `edu_teacher` VALUES ('1286481658505191426', '丫丫', '曾参与某银行大型项目非功能测试，担任过互联网公司测试主管，熟悉各种测试方法，擅长性能测试。', 'P8运维', '1', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/d0088aa866a44e3eb7607edda0985773file.png', '1', '0', '2020-07-24 10:01:43', '2020-08-01 13:24:20');
INSERT INTO `edu_teacher` VALUES ('1287691240384585730', '阿萨德111', '111', '11111111', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/27/2faa08504bb846d59d33a449fd335caefile.png', '3', '1', '2020-07-27 18:08:10', '2020-07-27 18:08:17');
INSERT INTO `edu_teacher` VALUES ('1289431881569386498', 'ceshi1', '1231', '123', '2', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/08/01/58abdcbc43bf4d8cbca20985e0b84303file.png', '1', '1', '2020-08-01 13:24:51', '2020-08-01 13:24:51');
INSERT INTO `edu_teacher` VALUES ('1290544107218878466', '小莉', '这是老师简历', '测试数据111', '1', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/08/04/8100c44278694761ae7ad436523a6c91file.png', '1', '1', '2020-08-04 15:04:26', '2020-08-04 15:04:34');
INSERT INTO `edu_teacher` VALUES ('1294787172378164112', 'Kelly', '资深UI设计师，5年视觉设计+6年交互设计+3年教学经验，曾担任设计总监。精通平面设计、电商设计、网页设计、UI设计、交互设计、前端代码。具备丰富的实战经验、教学经验及带队经验。擅长教给同学们诸多工作中实用技巧方法来解锁更高的工作效率。', 'P7工程师', '1', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/29/3afbe9e4fe3e41dca14ef44a13d7eafcfile.png', '0', '0', '2020-07-14 21:06:24', '2020-07-29 15:25:49');

-- ----------------------------
-- Table structure for edu_video
-- ----------------------------
DROP TABLE IF EXISTS `edu_video`;
CREATE TABLE `edu_video` (
  `id` char(19) NOT NULL COMMENT '视频ID',
  `course_id` char(19) NOT NULL COMMENT '课程ID',
  `chapter_id` char(19) NOT NULL COMMENT '章节ID',
  `title` varchar(50) NOT NULL COMMENT '节点名称',
  `video_source_id` varchar(100) DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100) DEFAULT NULL COMMENT '原始文件名称',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `play_count` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '播放次数',
  `is_free` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否可以试听：0收费 1免费',
  `duration` float NOT NULL DEFAULT '0' COMMENT '视频时长（秒）',
  `status` varchar(20) NOT NULL DEFAULT 'Empty' COMMENT 'Empty未上传 Transcoding转码中  Normal正常',
  `size` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '视频源文件大小（字节）',
  `version` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_chapter_id` (`chapter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程视频';

-- ----------------------------
-- Records of edu_video
-- ----------------------------
INSERT INTO `edu_video` VALUES ('1287692599863369730', '1287692488794005505', '1287692551121362946', 'JDK安装', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '1', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:13:34', '2020-07-27 18:13:34');
INSERT INTO `edu_video` VALUES ('1287692631039631362', '1287692488794005505', '1287692551121362946', 'Idea安装', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '2', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:13:42', '2020-07-27 18:13:42');
INSERT INTO `edu_video` VALUES ('1287692674245156866', '1287692488794005505', '1287692551121362946', 'Maven配置', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '3', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:13:52', '2020-07-27 18:13:52');
INSERT INTO `edu_video` VALUES ('1287692827018485762', '1287692488794005505', '1287692780935667714', '歌手功能实现', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '1', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:14:28', '2020-07-27 18:14:28');
INSERT INTO `edu_video` VALUES ('1287692856126955522', '1287692488794005505', '1287692780935667714', '歌曲功能实现', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:14:35', '2020-07-27 18:14:35');
INSERT INTO `edu_video` VALUES ('1287692892818726913', '1287692488794005505', '1287692780935667714', '专辑功能实现', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:14:44', '2020-07-27 18:14:44');
INSERT INTO `edu_video` VALUES ('1287692925660127234', '1287692488794005505', '1287692780935667714', '流派功能实现', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:14:52', '2020-07-27 18:14:52');
INSERT INTO `edu_video` VALUES ('1287692966793666561', '1287692488794005505', '1287692780935667714', '登录注销功能实现', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:15:02', '2020-07-27 18:15:02');
INSERT INTO `edu_video` VALUES ('1287693039694864386', '1287692488794005505', '1287692551121362946', 'LayUI教学', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:15:19', '2020-07-27 18:15:19');
INSERT INTO `edu_video` VALUES ('1287693074708914177', '1287692488794005505', '1287692551121362946', 'SSM基础搭建', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:15:27', '2020-07-27 18:15:27');
INSERT INTO `edu_video` VALUES ('1287693191826464770', '1287692488794005505', '1287693143281590274', '流派页面', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:15:55', '2020-07-27 18:15:55');
INSERT INTO `edu_video` VALUES ('1287693215645917186', '1287692488794005505', '1287693143281590274', '专辑页面', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:16:01', '2020-07-27 18:16:01');
INSERT INTO `edu_video` VALUES ('1287693238865584130', '1287692488794005505', '1287693143281590274', '歌手页面', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:16:06', '2020-07-27 18:16:06');
INSERT INTO `edu_video` VALUES ('1287693293798383618', '1287692488794005505', '1287693143281590274', '在线播放页', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:16:20', '2020-07-27 18:16:20');
INSERT INTO `edu_video` VALUES ('1287693357870571522', '1287692488794005505', '1287693321539510273', 'Swagger使用', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:16:35', '2020-07-27 18:16:35');
INSERT INTO `edu_video` VALUES ('1287693465609658369', '1287692488794005505', '1287693321539510273', 'Jmaster峰值测试', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 18:17:01', '2020-07-27 18:17:01');
INSERT INTO `edu_video` VALUES ('1287728893507186689', '1287728708148310018', '1287728748782727170', 'Maven', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:37:47', '2020-07-27 20:37:47');
INSERT INTO `edu_video` VALUES ('1287728927053230081', '1287728708148310018', '1287728748782727170', 'Redis', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:37:55', '2020-07-27 20:37:55');
INSERT INTO `edu_video` VALUES ('1287728980555771906', '1287728708148310018', '1287728748782727170', 'Nginx', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:38:08', '2020-07-27 20:38:08');
INSERT INTO `edu_video` VALUES ('1287729020493934594', '1287728708148310018', '1287728784434311170', '布局教学', '76d48ecb3a1f4ef18d7e2cd33f404b9d', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:38:17', '2020-07-27 20:38:17');
INSERT INTO `edu_video` VALUES ('1287729073673515009', '1287728708148310018', '1287728784434311170', '组件教学', '76d48ecb3a1f4ef18d7e2cd33f404b9d', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:38:30', '2020-07-27 20:38:30');
INSERT INTO `edu_video` VALUES ('1287729130325979137', '1287728708148310018', '1287728784434311170', '微信支付', '76d48ecb3a1f4ef18d7e2cd33f404b9d', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:38:44', '2020-07-27 20:38:44');
INSERT INTO `edu_video` VALUES ('1287729199943036930', '1287728708148310018', '1287728784434311170', '项目上线', '76d48ecb3a1f4ef18d7e2cd33f404b9d', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:39:00', '2020-07-27 20:39:00');
INSERT INTO `edu_video` VALUES ('1287729230066528258', '1287728708148310018', '1287728830093504513', '登录', '76d48ecb3a1f4ef18d7e2cd33f404b9d', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:39:07', '2020-07-27 20:39:07');
INSERT INTO `edu_video` VALUES ('1287729254443823105', '1287728708148310018', '1287728830093504513', '上传视频', '76d48ecb3a1f4ef18d7e2cd33f404b9d', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:39:13', '2020-07-27 20:39:13');
INSERT INTO `edu_video` VALUES ('1287729287922757634', '1287728708148310018', '1287728830093504513', '管理员功能实现', '76d48ecb3a1f4ef18d7e2cd33f404b9d', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:39:21', '2020-07-27 20:39:21');
INSERT INTO `edu_video` VALUES ('1287729315437391874', '1287728708148310018', '1287728830093504513', '举报及分享', '76d48ecb3a1f4ef18d7e2cd33f404b9d', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:39:28', '2020-07-27 20:39:28');
INSERT INTO `edu_video` VALUES ('1287729349268647937', '1287728708148310018', '1287728830093504513', '腾讯云视频点播', '76d48ecb3a1f4ef18d7e2cd33f404b9d', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:39:36', '2020-07-27 20:39:36');
INSERT INTO `edu_video` VALUES ('1287729374660964354', '1287728708148310018', '1287728861554978818', '服务器部署', '76d48ecb3a1f4ef18d7e2cd33f404b9d', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:39:42', '2020-07-27 20:39:42');
INSERT INTO `edu_video` VALUES ('1287729413420527617', '1287728708148310018', '1287728861554978818', '证书申请', '76d48ecb3a1f4ef18d7e2cd33f404b9d', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:39:51', '2020-07-27 20:39:51');
INSERT INTO `edu_video` VALUES ('1287729452750516226', '1287728708148310018', '1287728861554978818', '个人上线', '76d48ecb3a1f4ef18d7e2cd33f404b9d', null, '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-27 20:40:01', '2020-07-27 20:40:01');
INSERT INTO `edu_video` VALUES ('1288119387357831169', '1288119126707003393', '1288119264259203073', '后端页面部署到项目服务器中', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', 'dmbjz.mp4', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-28 22:29:28', '2020-07-28 22:29:28');
INSERT INTO `edu_video` VALUES ('1288309858520547329', '1288309023887605762', '1288309093211062274', 'Maven配置', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', 'dmbjz.mp4', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:06:20', '2020-07-29 11:06:20');
INSERT INTO `edu_video` VALUES ('1288309968826548226', '1288309023887605762', '1288309093211062274', 'Redis ', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', 'dmbjz.mp4', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:06:46', '2020-07-29 11:06:46');
INSERT INTO `edu_video` VALUES ('1288310024967307265', '1288309023887605762', '1288309093211062274', 'MySQL', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', 'dmbjz.mp4', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:07:00', '2020-07-29 11:07:00');
INSERT INTO `edu_video` VALUES ('1288310065782079489', '1288309023887605762', '1288309126392201217', '编写 SpringBoot 应用', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', 'dmbjz.mp4', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:07:09', '2020-07-29 11:07:17');
INSERT INTO `edu_video` VALUES ('1288310155468881922', '1288309023887605762', '1288309126392201217', ' SpringBoot 配置文件', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', 'dmbjz.mp4', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:07:31', '2020-07-29 11:07:31');
INSERT INTO `edu_video` VALUES ('1288310741278932993', '1288310524735406081', '1288310594675425282', ' 1-1 课前必读（不看会错过一个亿）', '76d48ecb3a1f4ef18d7e2cd33f404b9d', '', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:09:51', '2020-07-29 11:09:51');
INSERT INTO `edu_video` VALUES ('1288310765467484162', '1288310524735406081', '1288310594675425282', ' 1-2 课程导学', '76d48ecb3a1f4ef18d7e2cd33f404b9d', '', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:09:56', '2020-07-29 11:09:56');
INSERT INTO `edu_video` VALUES ('1288310790901743617', '1288310524735406081', '1288310620185182210', ' 2-1 项目需求分析', '76d48ecb3a1f4ef18d7e2cd33f404b9d', '', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:10:02', '2020-07-29 11:10:02');
INSERT INTO `edu_video` VALUES ('1288310813509042178', '1288310524735406081', '1288310620185182210', ' 2-2 单体项目技术选型和架构设计', '76d48ecb3a1f4ef18d7e2cd33f404b9d', '', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:10:08', '2020-07-29 11:10:08');
INSERT INTO `edu_video` VALUES ('1288310836200226817', '1288310524735406081', '1288310620185182210', ' 2-3 数据库设计概述', '76d48ecb3a1f4ef18d7e2cd33f404b9d', '', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:10:13', '2020-07-29 11:10:13');
INSERT INTO `edu_video` VALUES ('1288314360204115970', '1288313904581066754', '1288314013494558722', ' 1-1 课前必读（不看会错过一个亿）', 'f405eb9a6ea64562b450299fe32d466c', 'dmbjz.mp4', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:24:13', '2020-07-29 11:24:13');
INSERT INTO `edu_video` VALUES ('1288314407205486594', '1288313904581066754', '1288314013494558722', '1-2 课程介绍及学习指导', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', 'dmbjz.mp4', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:24:25', '2020-07-29 11:24:25');
INSERT INTO `edu_video` VALUES ('1288316493250969602', '1288316291471392770', '1288316347054309377', ' 1-1 目前主流的混合开发方案', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', '', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:32:42', '2020-07-29 11:32:52');
INSERT INTO `edu_video` VALUES ('1288316574037458945', '1288316291471392770', '1288316370571771905', ' 2-1 Android 与 Web 的互相调用', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', '', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:33:01', '2020-07-29 11:33:01');
INSERT INTO `edu_video` VALUES ('1288317482515316738', '1288317235273678850', '1288317353456582658', ' 1-1 导学', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', '', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:36:38', '2020-07-29 11:36:38');
INSERT INTO `edu_video` VALUES ('1288317506166996994', '1288317235273678850', '1288317353456582658', ' 1-2 easyswoole简介', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', '', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-29 11:36:43', '2020-07-29 11:36:43');
INSERT INTO `edu_video` VALUES ('1289196142248091650', '1287916487025168386', '1287916594793615362', '创建第一个小程序', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', '', '0', '0', '1', '0', 'Empty', '0', '1', '2020-07-31 21:48:07', '2020-07-31 21:56:58');
INSERT INTO `edu_video` VALUES ('1289196258077990913', '1287916487025168386', '1287916594793615362', '小程序布局教学', 'f6fbf6e9ac1a45c7a4242b93fb6b438c', '', '0', '0', '0', '0', 'Empty', '0', '1', '2020-07-31 21:48:34', '2020-07-31 21:48:34');

-- ----------------------------
-- Table structure for statistics_daily
-- ----------------------------
DROP TABLE IF EXISTS `statistics_daily`;
CREATE TABLE `statistics_daily` (
  `id` char(19) NOT NULL COMMENT '主键',
  `date_calculated` varchar(20) NOT NULL COMMENT '统计日期',
  `register_num` int(11) NOT NULL DEFAULT '0' COMMENT '注册人数',
  `login_num` int(11) NOT NULL DEFAULT '0' COMMENT '登录人数',
  `video_view_num` int(11) NOT NULL DEFAULT '0' COMMENT '每日播放视频数',
  `course_num` int(11) NOT NULL DEFAULT '0' COMMENT '每日新增课程数',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `statistics_day` (`date_calculated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站统计日数据';

-- ----------------------------
-- Records of statistics_daily
-- ----------------------------
INSERT INTO `statistics_daily` VALUES ('1290210561325383681', '2020-07-28', '3', '102', '103', '134', '2020-08-03 16:59:03', '2020-08-03 16:59:03');
INSERT INTO `statistics_daily` VALUES ('1290210561325383683', '2020-07-29', '35', '213', '780', '134', '2020-08-03 18:00:45', '2020-08-03 18:00:47');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` char(19) NOT NULL DEFAULT '',
  `order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '订单号',
  `course_id` varchar(19) NOT NULL DEFAULT '' COMMENT '课程id',
  `course_title` varchar(100) DEFAULT NULL COMMENT '课程名称',
  `course_cover` varchar(255) DEFAULT NULL COMMENT '课程封面',
  `teacher_name` varchar(20) DEFAULT NULL COMMENT '讲师名称',
  `member_id` varchar(19) NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `mobile` varchar(11) DEFAULT NULL COMMENT '会员手机',
  `total_fee` decimal(10,2) DEFAULT '0.01' COMMENT '订单金额（分）',
  `pay_type` tinyint(3) DEFAULT NULL COMMENT '支付类型（1：微信 2：支付宝）',
  `status` tinyint(3) DEFAULT NULL COMMENT '订单状态（0：未支付 1：已支付）',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_order_no` (`order_no`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单';

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1290090398118690817', '20200803090134283', '1287916487025168386', '支付宝商城小程序实战', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/cover/3.jpg', 'test', '1288715177314787330', 'dmbjz', '17689481721', '0.01', '1', '1', '0', '2020-08-03 09:01:34', '2020-08-03 09:02:00');
INSERT INTO `t_order` VALUES ('1290552190804463617', '20200804153634557', '1290551067192356866', '仿阿里系优酷网-企业级Go改造PHP项目踩坑避坑指北', 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/08/04/12fe281b143a43e586fdbfeb207738385ee0782708609a8506000338-360-202.jpg', 'test', '1288715177314787330', 'dmbjz', '17689481721', '0.01', '1', '1', '0', '2020-08-04 15:36:34', '2020-08-04 15:36:51');

-- ----------------------------
-- Table structure for t_pay_log
-- ----------------------------
DROP TABLE IF EXISTS `t_pay_log`;
CREATE TABLE `t_pay_log` (
  `id` char(19) NOT NULL DEFAULT '',
  `order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '订单号',
  `pay_time` datetime DEFAULT NULL COMMENT '支付完成时间',
  `total_fee` decimal(10,2) DEFAULT '0.01' COMMENT '支付金额（分）',
  `transaction_id` varchar(30) DEFAULT NULL COMMENT '交易流水号',
  `trade_state` char(20) DEFAULT NULL COMMENT '交易状态',
  `pay_type` tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付类型（1：微信 2：支付宝）',
  `attr` text COMMENT '其他属性',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_order_no` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付日志表';

-- ----------------------------
-- Records of t_pay_log
-- ----------------------------
INSERT INTO `t_pay_log` VALUES ('1290090506298179585', '20200803090134283', '2020-08-03 09:02:00', '0.01', '4200000574202008035604018281', 'SUCCESS', '1', '{\"transaction_id\":\"4200000574202008035604018281\",\"nonce_str\":\"XxEgIJ6iJHTQ6ki0\",\"trade_state\":\"SUCCESS\",\"bank_type\":\"OTHERS\",\"openid\":\"oNTiQ1hQHAo_YA6hFttvzwz_Jv8Y\",\"sign\":\"1CB164AFBC9D633330C2B89017EDD3E6\",\"return_msg\":\"OK\",\"fee_type\":\"CNY\",\"mch_id\":\"1536725911\",\"cash_fee\":\"1\",\"out_trade_no\":\"20200803090134283\",\"cash_fee_type\":\"CNY\",\"appid\":\"wx0609f8351dca9750\",\"total_fee\":\"1\",\"trade_state_desc\":\"支付成功\",\"trade_type\":\"NATIVE\",\"result_code\":\"SUCCESS\",\"attach\":\"\",\"time_end\":\"20200803090158\",\"is_subscribe\":\"N\",\"return_code\":\"SUCCESS\"}', '0', '2020-08-03 09:02:00', '2020-08-03 09:02:00');
INSERT INTO `t_pay_log` VALUES ('1290552261155524609', '20200804153634557', '2020-08-04 15:36:51', '0.01', '4200000592202008049613883410', 'SUCCESS', '1', '{\"transaction_id\":\"4200000592202008049613883410\",\"nonce_str\":\"uuCMLwpqYMn6fTc6\",\"trade_state\":\"SUCCESS\",\"bank_type\":\"OTHERS\",\"openid\":\"oNTiQ1hQHAo_YA6hFttvzwz_Jv8Y\",\"sign\":\"025410C8AA112927142DBD804B6945D3\",\"return_msg\":\"OK\",\"fee_type\":\"CNY\",\"mch_id\":\"1536725911\",\"cash_fee\":\"1\",\"out_trade_no\":\"20200804153634557\",\"cash_fee_type\":\"CNY\",\"appid\":\"wx0609f8351dca9750\",\"total_fee\":\"1\",\"trade_state_desc\":\"支付成功\",\"trade_type\":\"NATIVE\",\"result_code\":\"SUCCESS\",\"attach\":\"\",\"time_end\":\"20200804153652\",\"is_subscribe\":\"N\",\"return_code\":\"SUCCESS\"}', '0', '2020-08-04 15:36:51', '2020-08-04 15:36:51');

-- ----------------------------
-- Table structure for ucenter_member
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_member`;
CREATE TABLE `ucenter_member` (
  `id` char(19) NOT NULL COMMENT '会员id',
  `openid` varchar(128) DEFAULT NULL COMMENT '微信openid',
  `mobile` varchar(11) DEFAULT '' COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(2) unsigned DEFAULT NULL COMMENT '性别 1 女，2 男',
  `age` tinyint(3) unsigned DEFAULT NULL COMMENT '年龄',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `sign` varchar(100) DEFAULT NULL COMMENT '用户签名',
  `is_disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否禁用 1（true）已禁用，  0（false）未禁用',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员表';

-- ----------------------------
-- Records of ucenter_member
-- ----------------------------
INSERT INTO `ucenter_member` VALUES ('1288680482787074050', null, '17689481723', '53d68c0f386532b7ff587a84406a1a90', 'dmbjz', null, null, 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', null, '0', '0', '2020-07-28 11:39:04', '2020-07-30 11:39:04');
INSERT INTO `ucenter_member` VALUES ('1288685848585347074', null, '17689481725', 'c31b32364ce19ca8fcd150a417ecce58', 'bilibili', null, null, 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', null, '0', '0', '2020-07-28 12:00:23', '2020-07-30 12:00:23');
INSERT INTO `ucenter_member` VALUES ('1288715177314787330', null, '17689481721', 'ea580ce398796de290c5dd817569a73a', 'dmbjz', null, null, 'https://light-dmbjz.oss-cn-beijing.aliyuncs.com/2020/07/24/bfce7c14064d4974905dfeb6bccd183817.jpeg', null, '0', '0', '2020-07-30 13:56:56', '2020-07-30 13:56:56');
INSERT INTO `ucenter_member` VALUES ('1288811727281999873', 'o3_SC5x8-LJ70865tzTCEi80cSBs', '17689481727', null, '脱离方二', null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/2U9aHrNgXg3A1IiayiaKKqLfPn7m1ffcc2bndmTIELIP7ziaoNNk2YrsnbytSWjxp6JWLIo7YPI4uOtPU5JgBM4icA/132', null, '0', '0', '2020-07-30 20:20:35', '2020-07-30 20:20:35');
