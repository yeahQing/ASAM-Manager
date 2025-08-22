/*
 Navicat Premium Dump SQL

 Source Server         : localhost3306
 Source Server Type    : MySQL
 Source Server Version : 90400 (9.4.0)
 Source Host           : localhost:3306
 Source Schema         : yeqhqing

 Target Server Type    : MySQL
 Target Server Version : 90400 (9.4.0)
 File Encoding         : 65001

 Date: 22/08/2025 14:27:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- 学生菜单数据
-- ----------------------------
INSERT INTO `tbl_menu` VALUES (12, '首页', 0, '/teacher/dashboard', 'fa-cog', 1, 3);
INSERT INTO `tbl_menu` VALUES (13, '个人信息', 0, '/teacher/getTeacherInfo', 'fa-user', 2, 3);
INSERT INTO `tbl_menu` VALUES (14, '课程管理', 0, '/teacher/openLesson', 'fa-book-open', 3, 3);
INSERT INTO `tbl_menu` VALUES (15, '开设课程', 14, '/teacher/openLesson', 'fa-plus-circle', 1, 3);
INSERT INTO `tbl_menu` VALUES (16, '课程审计', 14, '/teacher/auditLesson', 'fa-list-alt', 2, 3);
INSERT INTO `tbl_menu` VALUES (17, '课程打分', 14, '/teacher/addLessonScore', 'fa-graduation-cap', 3, 3);
INSERT INTO `tbl_menu` VALUES (18, '修改密码', 0, '/modifyPwd', 'fa-lock', 4, 3);
INSERT INTO `tbl_menu` VALUES (19, '退出系统', 0, '/logout', 'fa-sign-out-alt', 5, 3);

-- ----------------------------
-- 教师菜单数据
-- ----------------------------
INSERT INTO `tbl_menu` VALUES (20, '首页', 0, '/student/dashboard', 'fa-cog', 1, 2);
INSERT INTO `tbl_menu` VALUES (21, '个人信息', 0, '/student/getStudentInfo', 'fa-user', 2, 2);
INSERT INTO `tbl_menu` VALUES (22, '课程管理', 0, '/student/getLessonInfo', 'fa-book-open', 3, 2);
INSERT INTO `tbl_menu` VALUES (23, '待选课程', 22, '/student/getLessonInfo', 'fa-plus-circle', 1, 2);
INSERT INTO `tbl_menu` VALUES (24, '已选课程', 22, '/student/getSelectedLesson', 'fa-list-alt', 2, 2);
INSERT INTO `tbl_menu` VALUES (25, '修改密码', 0, '/modifyPwd', 'fa-lock', 4, 2);
INSERT INTO `tbl_menu` VALUES (26, '退出系统', 0, '/logout', 'fa-sign-out-alt', 5, 2);

SET FOREIGN_KEY_CHECKS = 1;