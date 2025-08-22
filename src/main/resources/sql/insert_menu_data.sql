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
-- Table structure for tbl_menu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_menu`;
CREATE TABLE `tbl_menu`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
  `parent_id` int NULL DEFAULT NULL COMMENT '父菜单id',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单url',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `menu_order` int NULL DEFAULT NULL COMMENT '菜单顺序',
  `role_id` int NULL DEFAULT NULL COMMENT '菜单所属角色',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`role_id` ASC) USING BTREE,
  CONSTRAINT `tbl_menu_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tbl_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_menu
-- ----------------------------
INSERT INTO `tbl_menu` VALUES (1, '首页', 0, '/admin/dashboard', 'fa-cog', 1, 1);
INSERT INTO `tbl_menu` VALUES (2, '学生管理', 0, '/admin/getStudentList', 'fa-users', 2, 1);
INSERT INTO `tbl_menu` VALUES (3, '学生列表', 2, '/admin/getStudentList', 'fa-user-tag', 3, 1);
INSERT INTO `tbl_menu` VALUES (4, '导入学生', 2, '/admin/importStu', 'fa-chalkboard-teacher', 4, 1);
INSERT INTO `tbl_menu` VALUES (5, '教师管理', 0, '/admin/getTeacherList', 'fa-user-graduate', 5, 1);
INSERT INTO `tbl_menu` VALUES (6, '教师列表', 5, '/admin/getTeacherList', 'fa-book', 6, 1);
INSERT INTO `tbl_menu` VALUES (7, '导入教师', 5, '/admin/importTeach', 'fa-user', 7, 1);
INSERT INTO `tbl_menu` VALUES (8, '课程管理', 0, '/admin/getLessonList', 'fa-book-open', 8, 1);
INSERT INTO `tbl_menu` VALUES (9, '课程列表', 8, '/admin/getLessonList', 'fa-graduation-cap', 9, 1);
INSERT INTO `tbl_menu` VALUES (10, '修改密码', 0, '/modifyPwd', 'fa-user', 3, 1);
INSERT INTO `tbl_menu` VALUES (11, '退出系统', 0, '/logout', 'fa-calendar-alt', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
