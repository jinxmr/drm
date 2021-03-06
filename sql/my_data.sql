/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : localhost:3306
 Source Schema         : my_data

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 22/09/2019 12:46:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_info
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'app名字',
  `app_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'applogo',
  `app_description` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'app描述',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态1有效0无效3删除',
  `qy_agent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业微信agentid',
  `qy_secret` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业微信Secret',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'app表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of app_info
-- ----------------------------
INSERT INTO `app_info` VALUES (1, '基础权限', '/upload/app/2018-12-10/1544410210325.jpg', '', 1, '1', 'y0Oq3bTmCvmR2YaNIkcolnNSAkd3I8XJOxsI1zNeCUw', '2018-11-14 16:44:46', '2018-12-10 10:50:31');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父级编号',
  `order_sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `menu_type` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` int(11) NULL DEFAULT 0 COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `method_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单方法名称',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  `app_id` int(11) NULL DEFAULT NULL COMMENT '关联APPID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 1, NULL, 'M', 0, NULL, NULL, 'layui-icon layui-icon-set', 'admin', '2019-07-19 10:33:14', '', 1);
INSERT INTO `sys_menu` VALUES (2, '应用管理', 0, 3, NULL, 'C', 0, NULL, NULL, 'layui-icon layui-icon-app', 'admin\r\n\r\n\r\n\r\n\r\n\r\n', '2019-07-19 10:33:18', '', 1);
INSERT INTO `sys_menu` VALUES (3, '用户管理', 1, 1, '/back/sysUser', 'C', 0, 'system:user:view', NULL, 'fa fa-gear', 'admin\r\n\r\n\r\n\r\n\r\n\r\n', '2019-07-19 10:33:21', '', 1);
INSERT INTO `sys_menu` VALUES (4, '角色管理', 1, 2, '/back/sysRole', 'C', 0, 'system:role:view', NULL, 'fa fa-gear', 'admin\r\n\r\n\r\n\r\n\r\n\r\n', '2019-07-19 10:33:23', '', 1);
INSERT INTO `sys_menu` VALUES (5, '菜单管理', 1, 3, '/back/sysMenu', 'C', 0, 'system:menu:view', NULL, 'fa fa-gear', 'admin\r\n\r\n\r\n\r\n\r\n\r\n', '2019-07-19 10:33:26', '', 1);
INSERT INTO `sys_menu` VALUES (6, '应用管理', 2, 1, '/back/app', 'C', 0, 'system:app:view', NULL, 'fa fa-gear', 'admin\r\n\r\n\r\n\r\n\r\n\r\n', '2019-07-19 10:33:29', '', 1);
INSERT INTO `sys_menu` VALUES (7, '删除', 3, 4, '/back/sysUser/delUser', 'F', 0, 'system:user:remove', NULL, 'fa fa-gear', 'admin\r\n\r\n\r\n\r\n\r\n\r\n', '2019-07-19 10:33:32', '', 1);
INSERT INTO `sys_menu` VALUES (8, '工具管理', 0, 2, '', 'M', 0, NULL, NULL, 'layui-icon layui-icon-util', 'admin', '2019-07-30 11:37:04', '', 1);
INSERT INTO `sys_menu` VALUES (9, '代码生成', 8, 1, '/back/tool/gen', 'C', 0, 'tool:gen:view', NULL, 'fa fa-gear', 'admin', '2019-07-30 11:38:43', '', 1);
INSERT INTO `sys_menu` VALUES (10, '生成代码', 9, 2, '/back/code/gen', 'F', 0, 'tool:gen:code', NULL, 'fa fa-gear', 'admin', '2019-07-30 11:41:13', '', 1);
INSERT INTO `sys_menu` VALUES (11, '表查询', 9, 3, '/back/tool/gen/list', 'C', 0, 'tool:gen:list', NULL, 'fa fa-gear', 'admin', '2019-07-30 13:43:55', '', 1);
INSERT INTO `sys_menu` VALUES (12, '查看', 4, 1, NULL, 'F', 0, 'system:role:list', NULL, 'fa fa-gear', 'admin\r\n\r\n\r\n\r\n\r\n\r\n', '2019-07-19 10:33:32', '', 1);
INSERT INTO `sys_menu` VALUES (13, '新增', 4, 2, NULL, 'F', 0, 'system:role:add', NULL, 'fa fa-gear', 'admin\r\n\r\n\r\n\r\n\r\n\r\n', '2019-07-19 10:33:32', '', 1);
INSERT INTO `sys_menu` VALUES (14, '编辑', 4, 3, NULL, 'F', 0, 'system:role:edit', NULL, 'fa fa-gear', 'admin\r\n\r\n\r\n\r\n\r\n\r\n', '2019-07-19 10:33:32', '', 1);
INSERT INTO `sys_menu` VALUES (15, '删除', 4, 4, NULL, 'F', 0, 'system:role:remove', NULL, 'fa fa-gear', 'admin\r\n\r\n\r\n\r\n\r\n\r\n', '2019-07-19 10:33:32', '', 1);
INSERT INTO `sys_menu` VALUES (16, '新增', 3, 2, NULL, 'F', 0, 'system:user:add', NULL, 'fa fa-gear', 'admin', '2019-07-19 10:33:32', '', 1);
INSERT INTO `sys_menu` VALUES (17, '编辑', 3, 3, NULL, 'F', 0, 'system:user:edit', NULL, 'fa fa-gear', 'admin', '2019-07-19 10:33:32', '', 1);
INSERT INTO `sys_menu` VALUES (19, '重置密码', 3, 5, NULL, 'F', 0, 'system:user:reset', NULL, 'fa fa-gear', 'admin', '2019-07-19 10:33:32', '', 1);
INSERT INTO `sys_menu` VALUES (20, '权限分配', 4, 5, NULL, 'F', 0, 'system:role:dist', NULL, 'fa fa-gear', 'admin', '2019-07-19 10:33:32', '', 1);
INSERT INTO `sys_menu` VALUES (21, '查看', 3, 1, NULL, 'F', 0, 'system:user:list', NULL, 'fa fa-gear', 'admin\r\n\r\n\r\n\r\n\r\n\r\n', '2019-07-19 10:33:32', '', 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色权限标识',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 0, '1', '0', 'admin', '2018-10-24 00:00:00', NULL);
INSERT INTO `sys_role` VALUES (4, '普通管理员', 'ordinaryAdmin', 2, '1', '0', '靳祥民', '2019-09-22 03:52:55', NULL);
INSERT INTO `sys_role` VALUES (5, '业务管理员', 'businessAdmin', 3, '1', '0', '靳祥民', '2019-09-22 04:08:02', NULL);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `menu_id` int(11) NULL DEFAULT NULL COMMENT '菜单id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单中间表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (4, 1);
INSERT INTO `sys_role_menu` VALUES (4, 3);
INSERT INTO `sys_role_menu` VALUES (4, 21);
INSERT INTO `sys_role_menu` VALUES (4, 16);
INSERT INTO `sys_role_menu` VALUES (4, 17);
INSERT INTO `sys_role_menu` VALUES (4, 7);
INSERT INTO `sys_role_menu` VALUES (4, 19);
INSERT INTO `sys_role_menu` VALUES (4, 4);
INSERT INTO `sys_role_menu` VALUES (4, 12);
INSERT INTO `sys_role_menu` VALUES (4, 13);
INSERT INTO `sys_role_menu` VALUES (4, 14);
INSERT INTO `sys_role_menu` VALUES (4, 15);
INSERT INTO `sys_role_menu` VALUES (4, 20);
INSERT INTO `sys_role_menu` VALUES (4, 8);
INSERT INTO `sys_role_menu` VALUES (4, 9);
INSERT INTO `sys_role_menu` VALUES (4, 10);
INSERT INTO `sys_role_menu` VALUES (4, 11);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `login_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `work_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `photo` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `login_ip` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime(0) NULL DEFAULT NULL COMMENT '最后登陆时间',
  `create_date` datetime(0) NOT NULL COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(11) NOT NULL DEFAULT 0 COMMENT '删除标记 ',
  `wx_open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信openID',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态 0停用 1启用',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别 0男1女',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_user_login_name`(`login_name`) USING BTREE,
  INDEX `sys_user_update_date`(`update_date`) USING BTREE,
  INDEX `sys_user_del_flag`(`del_flag`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '928bfd2577490322a6e19b793691467e', NULL, '靳祥民', '12@3.com', '17635672203', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563512518224&di=fd2148a2f3f47501eb3871da6ac23909&imgtype=0&src=http%3A%2F%2Fs2.sinaimg.cn%2Fmw690%2F006hikKrzy7sly8VuDfb1%26690', '0.0.0.0', '2019-07-19 10:14:22', '2019-07-19 10:14:26', '2019-07-19 10:14:29', '超级管理员', 0, NULL, 0, 1);
INSERT INTO `sys_user` VALUES (10, 'jinxmsir', '1c6a532e23ed5e59eb24c44b510d2d56', NULL, '靳祥民', '1@2.com', '18636891101', NULL, NULL, NULL, '2019-09-09 14:43:48', NULL, 'jinxmsir', 0, NULL, 0, 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色中间表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (10, 4);

SET FOREIGN_KEY_CHECKS = 1;
