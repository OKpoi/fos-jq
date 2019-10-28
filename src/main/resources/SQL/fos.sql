/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : fos

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 06/06/2019 02:09:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `login_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6002 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES (6001, 'admin', 'admin', '2019-06-02 15:33:25', '2019-06-02 15:33:29');

-- ----------------------------
-- Table structure for tb_comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment_reply`;
CREATE TABLE `tb_comment_reply`  (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '影评回复id',
  `comment_id` int(11) NOT NULL COMMENT '评论ID',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  `create_time` datetime NOT NULL COMMENT '时间',
  `state` int(2) NOT NULL DEFAULT 0 COMMENT '删除与否(0-没删除,1-删除)',
  `parent_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL COMMENT '回复用户id',
  PRIMARY KEY (`reply_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4003 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '影评回复表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_comment_reply
-- ----------------------------
INSERT INTO `tb_comment_reply` VALUES (4001, 3003, '那是你没看懂啊', '2019-05-31 17:35:42', 0, 1004, 1003);
INSERT INTO `tb_comment_reply` VALUES (4002, 3003, '我干******', '2019-06-05 13:24:17', 1, 1004, 1002);

-- ----------------------------
-- Table structure for tb_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_info`;
CREATE TABLE `tb_info`  (
  `info_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `title` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `info_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `admin_id` int(11) NOT NULL,
  `info_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `info_from` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`info_id`) USING BTREE,
  INDEX `AdminID`(`admin_id`) USING BTREE,
  CONSTRAINT `AdminID` FOREIGN KEY (`admin_id`) REFERENCES `tb_admin` (`admin_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5003 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_info
-- ----------------------------
INSERT INTO `tb_info` VALUES (5001, '2019-06-02 15:32:38', '\"哥斯拉2\"儿童节发威单日票房破2亿', '继五一黄金周后，随着儿童节（周六）的到来，内地影市大盘推向新高。昨日（6月1日）大盘3.6亿元，是5月2日以来的最高单日票房，比前一日周五（5月31日）几乎增加2亿。纵观历年6月1日儿童节当日票房，可以看到现在大家越来越爱过儿童节了。2018年儿童节周五，单日票房2.13亿是此前的最好成绩，而今年又上了一个台阶。不过今年儿童节正好赶上周六也是一个原因。', 6001, '/5001/1.jpg', '时光网讯');
INSERT INTO `tb_info` VALUES (5002, '2019-06-02 17:07:22', '《X战警：黑凤凰》的“泽维尔天才青少年学校毕业典礼”粉丝庆典活动，实在无可挑剔，这回的福斯中国宣发，我给满分。', '5月29日，注定是一个让诸多“X战警”粉丝们激动得夜不能寐、辗转反侧的大日子，福斯新超级英雄电影《X战警：黑凤凰》在北京举办了空前盛大的首映式。“空前”两个字可不是通稿式的随便说说，“一美”詹姆斯·麦卡沃伊、“法鲨”迈克尔·法斯宾德、“凤凰女”索菲·特纳、“快银”伊万·彼得斯、“镭射眼”泰尔·谢里丹，以及《X战警》系列的元老级制片人、也是本片导演西蒙·金伯格，齐聚帝都的北展剧场。下午发布会中，主创们金句不绝于口；晚些红毯礼上，明星们互动惹人生爱，然而粉丝们绝对想象不到，这个夜晚真正的高潮还在后面——这场名为“泽维尔天才青少年学校毕业典礼”的粉丝庆典活动，是献给有深爱了“X战警”多年的新粉老粉们，一份最完美的告别礼物。而时光直播的“六城联动”活动，更是将身处上海、广州、成都、西安和武汉的粉丝们，与主创们隔空连线，共同见证了这难忘一晚。', 6001, '/5002/1.jpg', '新浪网');

-- ----------------------------
-- Table structure for tb_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_log`;
CREATE TABLE `tb_log`  (
  `log_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `content` varchar(8000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '日志内容',
  `operation` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户所做的操作',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_movie
-- ----------------------------
DROP TABLE IF EXISTS `tb_movie`;
CREATE TABLE `tb_movie`  (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '电影ID',
  `movie_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电影名',
  `type_id` int(10) NOT NULL COMMENT '类型id',
  `on_time` date NULL DEFAULT NULL COMMENT '上映时间',
  `language` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '语言类型',
  `country` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国家/地区',
  `movie_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电影时长',
  `director` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '导演名',
  `actor` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '演员',
  `movie_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片路径',
  `movie_video` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '视频路径',
  `profile` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`movie_id`) USING BTREE,
  INDEX `TypeID`(`type_id`) USING BTREE,
  INDEX `movie_id`(`movie_id`) USING BTREE,
  CONSTRAINT `Typeid` FOREIGN KEY (`type_id`) REFERENCES `tb_movie_type` (`type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2008 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '电影表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_movie
-- ----------------------------
INSERT INTO `tb_movie` VALUES (2001, '小黄人大眼萌', 1106, '2015-09-13', '英语', '美国', '91分钟', '皮埃尔·柯芬  凯尔·巴尔达 ', '皮埃尔·柯芬   桑德拉·布洛克', '/film/2001/1.jpg', '/2001/1.mp4', '《小黄人》围绕小黄人们的“前格鲁时代”展开叙述，并特别追溯了小黄人的起源。小黄人原本是一种单细胞体生物，之后逐渐进化为专为超级坏蛋提供服务的坏蛋助手。它们服务过的超级坏蛋包括：霸王龙、拿破仑、吸血鬼、北极熊。小黄人总是忠诚地为主人提供各种服务，兢兢业业，毫无怨言——直到它们失手“害死”每一任主人。在痛苦地失去一个又一个主人后，被困在冰洞之内小黄人们愈发焦躁不安，于是小黄人斯图尔特、凯文及鲍勃决定挺身而出，去到花花世界，再次寻找可以效劳的主人。');
INSERT INTO `tb_movie` VALUES (2002, '复仇者联盟4', 1101, '2019-04-24', '英语', '美国', '180分钟', '安东尼·罗素  乔·罗素', '小罗伯特·唐尼   克里斯·埃文斯', '/film/2002/1.jpg', '/2002/1.mp4', '《复仇者联盟3：无限战争》的毁灭性事件过后，宇宙由于疯狂泰坦灭霸的行动而变得满目疮痍。无论前方将遭遇怎样的后果，复仇者联盟都必须在剩余盟友的帮助下再一次集结，以逆转灭霸的所作所为，彻底恢复宇宙的秩序。');
INSERT INTO `tb_movie` VALUES (2003, '丁丁历险记', 1104, '2011-11-15', '英语', '美国', '107分钟', '史蒂文·斯皮尔伯格', '杰米·贝尔   安迪·瑟金斯', '/film/2003/1.jpg', '', '故事跟随着一个充满好奇心的年轻记者丁丁（杰米·贝尔 饰）和他忠心无比的狗狗白雪，他们发现一艘藏有惊爆秘密的模型船，于是丁丁受到这个流传几世纪的秘密吸引，并引起残暴恶棍萨卡林（丹尼尔·克雷格 饰）的注意，因为萨卡林相信丁丁偷了跟红色拉克姆有关的无价宝藏，不过由于狗狗白雪、坏脾气的航海家阿道克船长（安迪·瑟金斯 饰）及笨手笨脚的侦探搭挡杜庞与杜邦（西蒙·佩吉和尼·克弗斯特 饰）的帮助，丁丁将会游历半个地球，智取并赶过他的敌人，热切地寻找船舰独角兽号的最后落脚处，因为那正关键着一艘失事船的庞大财富……以及一则');
INSERT INTO `tb_movie` VALUES (2004, '傲慢与偏见', 1103, '2005-09-16', '英语', '法国 | 英国 | 美国', '129分钟', '乔·赖特', '凯拉·奈特莉   马修·麦克费登   吉娜·马隆', '/film/2004/1.jpg', '', '小乡绅班纳特有五个待字闺中的千金，班纳特太太整天操心着为女儿物色称心如意的丈夫。  \r\n新来的邻居彬格莱是个有钱的单身汉，他立即成了班纳特太太追猎的目标。在一次舞会上，彬格莱对班纳特家的大女儿吉英一见钟情，班纳特太太为此欣喜若狂。  \r\n参加舞会的还有彬格莱的好友达西。他仪表堂堂，非常富有，许多姑娘纷纷向他投去羡慕的目光；但他非常骄傲，认为她们都不配做他的舞伴，其中包括吉英的妹妹伊丽莎白。伊丽莎白自尊心很强，决定不去理睬这个傲慢的家伙。可是不久，达西对她活泼可爱的举止产生了好感，在另一次舞会上主动请她同舞');
INSERT INTO `tb_movie` VALUES (2005, '我不是药神', 1105, '2018-07-05', '中文', '中国', '116分钟', '文牧野', '徐峥   周一围   王传君', '/film/2005/1.jpg', '/2005/1.mp4', '一位不速之客的意外到访，打破了神油店老板程勇的平凡人生，他从一个交不起房租的男性保健品商贩，一跃成为印度仿制药“格列宁”的独家代理商。收获巨额利润的他，生活剧烈变化，被病患们冠以“药神”的称号。但是，一场关于救赎的拉锯战也在波涛暗涌中慢慢展开……');
INSERT INTO `tb_movie` VALUES (2006, '大侦探皮卡丘', 1102, '2019-05-10', '英语', '日本 | 美国 | 英国', '104分钟', '罗伯·莱特曼', '贾斯提斯·史密斯   凯瑟琳·纽顿', '/film/2006/1.jpg', '/2006/1.mp4', '蒂姆·古德曼（贾斯提斯·史密斯饰）为寻找下落不明的父亲来到莱姆市，意外与父亲的前宝可梦搭档大侦探皮卡丘（瑞安·雷诺兹 配音）相遇，并惊讶地发现自己是唯一能听懂皮卡丘说话的人类，他们决定组队踏上揭开真相的刺激冒险之路。探案过程中他们邂逅了各式各样的宝可梦，并意外发现了一个足以毁灭整个宝可梦宇宙的惊天阴谋。');
INSERT INTO `tb_movie` VALUES (2007, 'X战警：黑凤凰 ', 1101, '2019-06-06', '英语', '美国', '114分钟', '西蒙·金伯格', '索菲·特纳   詹姆斯·麦卡沃伊   迈克尔·法斯宾德', '/film/2007/1.jpg', '/2007/1.mp4', '影片剧情围绕X战警中最受欢迎成员之一的琴·葛蕾展开，讲述她逐渐转化为黑凤凰的故事。在一次危及生命的太空营救行动中，琴被神秘的宇宙力量击中，成为最强大的变种人。此后琴·葛蕾不仅要设法掌控日益增长、极不稳定的力量，更要与自己内心的恶魔抗争，她的失控让整个X战警大家庭分崩离析，也让整个星球陷入毁灭的威胁之中。《X战警：黑凤凰》是迄今为止气氛最紧张、情感最丰富的一部《X战警》电影，是《X战警》系列20年来的集大成之作，大家非常熟悉和热爱的变种人大家庭即将面对最为强大的敌人——而她恰恰还是他们中的一员.');

-- ----------------------------
-- Table structure for tb_movie_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_movie_comment`;
CREATE TABLE `tb_movie_comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `movie_id` int(11) NOT NULL COMMENT '电影ID参看Movie表',
  `user_id` int(11) NOT NULL COMMENT '用户ID参考User表',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  `create_time` datetime NOT NULL COMMENT '时间',
  `start` float(3, 1) NULL DEFAULT NULL COMMENT '评分(从低到高 1-5)',
  `state` int(2) NOT NULL DEFAULT 0 COMMENT '删除与否(0-没删除,1-删除)',
  `flag` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `UID`(`user_id`) USING BTREE,
  INDEX `MID`(`movie_id`) USING BTREE,
  CONSTRAINT `MID` FOREIGN KEY (`movie_id`) REFERENCES `tb_movie` (`movie_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `UID` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3020 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '评论表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_movie_comment
-- ----------------------------
INSERT INTO `tb_movie_comment` VALUES (3001, 2005, 1003, '国产良心之作！好评！', '2019-06-03 00:55:50', 5.0, 0, 0);
INSERT INTO `tb_movie_comment` VALUES (3002, 2002, 1001, '期待很久啦！', '2019-06-01 00:55:55', 5.0, 0, 0);
INSERT INTO `tb_movie_comment` VALUES (3003, 2004, 1004, '与经典相差太大', '2019-05-08 00:56:01', 2.0, 0, 0);
INSERT INTO `tb_movie_comment` VALUES (3004, 2003, 1004, 'hhhh 很有趣！！', '2019-04-02 00:56:07', 2.0, 0, 0);
INSERT INTO `tb_movie_comment` VALUES (3005, 2003, 1001, '挺经典的一部作品，但是内容不够充分', '2019-04-16 00:56:12', 4.0, 0, 0);
INSERT INTO `tb_movie_comment` VALUES (3006, 2001, 1004, '最爱小黄人这个电影！！最爱小黄人这个电影！！最爱小黄人这个电影！！最爱小黄人这个电影！！最爱小黄人这个电影！！最爱小黄人这个电影！！最爱小黄人这个电影！！最爱小黄人这个电影！！最爱小黄人这个电影！！最爱小黄人这个电影！！最爱小黄人这个电影！！最爱小黄人这个电影！！', '2019-04-09 00:56:17', 4.5, 0, 0);
INSERT INTO `tb_movie_comment` VALUES (3007, 2002, 1004, '粗鄙之语******************************', '2019-02-13 00:56:23', 1.0, 1, 0);
INSERT INTO `tb_movie_comment` VALUES (3008, 2005, 1004, '看的时候就在思考这个片子中有没有所谓的正与邪，其实说深点都是关于群体利益之间的关系，药厂没有有些人中所谓的恶人，药厂也是商业啊，也要赚钱啊，不然拿爱心养护工人和公司？', '2019-06-05 12:38:08', 4.0, 0, 0);
INSERT INTO `tb_movie_comment` VALUES (3009, 2006, 1004, '第一，不解释', '2019-06-03 00:56:34', 5.0, 0, 0);
INSERT INTO `tb_movie_comment` VALUES (3010, 2006, 1001, '楼上是魔鬼吧', '2019-06-03 00:56:37', 0.0, 0, 0);
INSERT INTO `tb_movie_comment` VALUES (3011, 2006, 1002, '真的好好看!!!!!', '2019-06-03 00:57:12', 5.0, 0, 0);
INSERT INTO `tb_movie_comment` VALUES (3012, 2006, 1003, '无感，陪别人一起看的', '2019-06-03 00:57:49', 2.0, 0, 0);
INSERT INTO `tb_movie_comment` VALUES (3014, 2007, 1001, '', '2019-06-03 15:54:32', 0.0, 0, 1);

-- ----------------------------
-- Table structure for tb_movie_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_movie_type`;
CREATE TABLE `tb_movie_type`  (
  `type_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名字',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1107 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '电影类型表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_movie_type
-- ----------------------------
INSERT INTO `tb_movie_type` VALUES (1101, '动作');
INSERT INTO `tb_movie_type` VALUES (1102, '科幻');
INSERT INTO `tb_movie_type` VALUES (1103, '爱情');
INSERT INTO `tb_movie_type` VALUES (1104, '冒险');
INSERT INTO `tb_movie_type` VALUES (1105, '历史');
INSERT INTO `tb_movie_type` VALUES (1106, '动画');

-- ----------------------------
-- Table structure for tb_rank
-- ----------------------------
DROP TABLE IF EXISTS `tb_rank`;
CREATE TABLE `tb_rank`  (
  `rank_id` int(15) NOT NULL AUTO_INCREMENT COMMENT '排名标识符',
  `movie_id` int(15) NOT NULL COMMENT '电影ID参考Comment表',
  `avg_star` smallint(5) NULL DEFAULT 0 COMMENT '平均分',
  PRIMARY KEY (`rank_id`) USING BTREE,
  INDEX `CommentID`(`movie_id`) USING BTREE,
  CONSTRAINT `CommentID` FOREIGN KEY (`movie_id`) REFERENCES `tb_movie_comment` (`movie_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '排名表,MID是确保评分是同一个电影的评分且评分不是同一个用户反复多次打分' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_rank
-- ----------------------------
INSERT INTO `tb_rank` VALUES (1, 2002, 5);
INSERT INTO `tb_rank` VALUES (2, 2005, 4);
INSERT INTO `tb_rank` VALUES (3, 2004, 2);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `sex` int(1) NULL DEFAULT NULL COMMENT '性别0男 1女 未添加是-1',
  `age` smallint(100) UNSIGNED NULL DEFAULT NULL COMMENT '年龄',
  `user_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电话',
  `create_time` datetime NOT NULL COMMENT '用户创建时间',
  `state` int(1) NOT NULL COMMENT '登陆状态（‘0’未登陆 ，‘1’登陆状态）',
  `user_type` int(1) NULL DEFAULT NULL COMMENT '用户类型（‘0’普通用户 ‘1’超级管理员）',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1005 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1001, 'test', 'test', 0, 20, '/common/1.jpg', NULL, NULL, '2019-05-10 12:55:43', 0, 0);
INSERT INTO `tb_user` VALUES (1002, 'test2', 'tes2', NULL, NULL, '/common/1.jpg', NULL, NULL, '0000-00-00 00:00:00', 0, NULL);
INSERT INTO `tb_user` VALUES (1003, 'test3', 'test3', NULL, NULL, '/common/1.jpg', NULL, NULL, '0000-00-00 00:00:00', 0, NULL);
INSERT INTO `tb_user` VALUES (1004, 'lomofu', 'dfcf273b1e06318db2e8e330bdfac341', 0, 16, '/upload/item/user/1004/201906052157483107.jpg', '2357650152@qq.com', '13728705419', '2019-05-31 14:20:35', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
