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

 Date: 22/08/2025 15:13:38
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role`
(
    `role_id`   int                                                           NOT NULL AUTO_INCREMENT COMMENT '角色id',
    `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
    PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_role
-- ----------------------------
INSERT INTO `tbl_role`
VALUES (1, '管理员');
INSERT INTO `tbl_role`
VALUES (2, '学生');
INSERT INTO `tbl_role`
VALUES (3, '教职工');


-- ----------------------------
-- Table structure for tbl_menu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_menu`;
CREATE TABLE `tbl_menu`
(
    `id`         int                                                           NOT NULL AUTO_INCREMENT COMMENT '菜单id',
    `name`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
    `parent_id`  int NULL DEFAULT NULL COMMENT '父菜单id',
    `url`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单url',
    `icon`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单图标',
    `menu_order` int NULL DEFAULT NULL COMMENT '菜单顺序',
    `role_id`    int NULL DEFAULT NULL COMMENT '菜单所属角色',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX        `role_id`(`role_id` ASC) USING BTREE,
    CONSTRAINT `tbl_menu_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tbl_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_menu
-- ----------------------------
INSERT INTO `tbl_menu`
VALUES (1, '首页', 0, '/admin/dashboard', 'fa-cog', 1, 1);
INSERT INTO `tbl_menu`
VALUES (2, '学生管理', 0, '/admin/getStudentList', 'fa-users', 2, 1);
INSERT INTO `tbl_menu`
VALUES (3, '学生列表', 2, '/admin/getStudentList', 'fa-user-tag', 3, 1);
INSERT INTO `tbl_menu`
VALUES (4, '导入学生', 2, '/admin/importStu', 'fa-chalkboard-teacher', 4, 1);
INSERT INTO `tbl_menu`
VALUES (5, '教师管理', 0, '/admin/getTeacherList', 'fa-user-graduate', 5, 1);
INSERT INTO `tbl_menu`
VALUES (6, '教师列表', 5, '/admin/getTeacherList', 'fa-book', 6, 1);
INSERT INTO `tbl_menu`
VALUES (7, '导入教师', 5, '/admin/importTeach', 'fa-user', 7, 1);
INSERT INTO `tbl_menu`
VALUES (8, '课程管理', 0, '/admin/getLessonList', 'fa-book-open', 8, 1);
INSERT INTO `tbl_menu`
VALUES (9, '课程列表', 8, '/admin/getLessonList', 'fa-graduation-cap', 9, 1);
INSERT INTO `tbl_menu`
VALUES (10, '修改密码', 0, '/modifyPwd', 'fa-user', 3, 1);
INSERT INTO `tbl_menu`
VALUES (11, '退出系统', 0, '/logout', 'fa-calendar-alt', 1, 1);
INSERT INTO `tbl_menu`
VALUES (12, '首页', 0, '/teacher/dashboard', 'fa-cog', 1, 3);
INSERT INTO `tbl_menu`
VALUES (13, '个人信息', 0, '/teacher/getTeacherInfo', 'fa-user', 2, 3);
INSERT INTO `tbl_menu`
VALUES (14, '课程管理', 0, '/teacher/openLesson', 'fa-book-open', 3, 3);
INSERT INTO `tbl_menu`
VALUES (15, '开设课程', 14, '/teacher/openLesson', 'fa-plus-circle', 1, 3);
INSERT INTO `tbl_menu`
VALUES (16, '课程审计', 14, '/teacher/auditLesson', 'fa-list-alt', 2, 3);
INSERT INTO `tbl_menu`
VALUES (18, '修改密码', 0, '/modifyPwd', 'fa-lock', 4, 3);
INSERT INTO `tbl_menu`
VALUES (19, '退出系统', 0, '/logout', 'fa-sign-out-alt', 5, 3);
INSERT INTO `tbl_menu`
VALUES (20, '首页', 0, '/student/dashboard', 'fa-cog', 1, 2);
INSERT INTO `tbl_menu`
VALUES (21, '个人信息', 0, '/student/getStudentInfo', 'fa-user', 2, 2);
INSERT INTO `tbl_menu`
VALUES (22, '课程管理', 0, '/student/getLessonInfo', 'fa-book-open', 3, 2);
INSERT INTO `tbl_menu`
VALUES (23, '待选课程', 22, '/student/getLessonInfo', 'fa-plus-circle', 1, 2);
INSERT INTO `tbl_menu`
VALUES (24, '已选课程', 22, '/student/getSelectedLesson', 'fa-list-alt', 2, 2);
INSERT INTO `tbl_menu`
VALUES (25, '修改密码', 0, '/modifyPwd', 'fa-lock', 4, 2);
INSERT INTO `tbl_menu`
VALUES (26, '退出系统', 0, '/logout', 'fa-sign-out-alt', 5, 2);
INSERT INTO `tbl_menu`
VALUES (27, '审核课程', 8, '/admin/auditLesson', 'fa-sign-out-alt', 8, 1);

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`
(
    `user_id`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id 登录名',
    `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
    `user_pwd`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
    `role_id`   int NULL DEFAULT NULL COMMENT '用户所属角色',
    PRIMARY KEY (`user_id`) USING BTREE,
    INDEX       `role_id`(`role_id` ASC) USING BTREE,
    CONSTRAINT `tbl_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tbl_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user`
VALUES ('admin', '系统管理员', '123456', 1);
INSERT INTO `tbl_user`
VALUES ('s1001', '王五学生', '123456', 2);
INSERT INTO `tbl_user`
VALUES ('s1002', '赵六学生', '123456789', 2);
INSERT INTO `tbl_user`
VALUES ('t001', '张三老师', '123456', 3);
INSERT INTO `tbl_user`
VALUES ('t002', '李四老师', '123456', 3);

-- ----------------------------
-- Table structure for tbl_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tbl_teacher`;
CREATE TABLE `tbl_teacher`
(
    `teacher_id`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教职工号',
    `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
    `birth`        date NULL DEFAULT NULL COMMENT '出生日期',
    `gender`       int NULL DEFAULT NULL COMMENT '性别',
    `id_card`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
    `job`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职位',
    `profess`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职称',
    `educational`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '教育背景',
    `study_filed`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '研究方向',
    `department`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所属部门/学院',
    PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '教师表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_teacher
-- ----------------------------
INSERT INTO `tbl_teacher`
VALUES ('t001', '张三', '1980-01-15', 2, '110101198001151234', '讲师', '副教授', '博士研究生', '计算机科学',
        '计算机学院');
INSERT INTO `tbl_teacher`
VALUES ('t002', '李四', '1975-05-20', 1, '110101197505205678', '系主任', '教授', '博士研究生', '软件工程',
        '计算机学院');
INSERT INTO `tbl_teacher`
VALUES ('t003', '王五', '1985-11-30', 2, '110101198511309012', '讲师', '讲师', '硕士研究生', '数据科学', '计算机学院');

-- ----------------------------
-- Table structure for tbl_stu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_stu`;
CREATE TABLE `tbl_stu`
(
    `stu_id`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
    `stu_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
    `birth`     date NULL DEFAULT NULL COMMENT '出生日期',
    `gender`    int NULL DEFAULT NULL COMMENT '性别 0:未知 1:男 2:女',
    `id_card`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
    `major`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '专业',
    `grade`     int NULL DEFAULT NULL COMMENT '入学时间',
    `stu_class` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '班级',
    PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_stu
-- ----------------------------
INSERT INTO `tbl_stu`
VALUES ('s1001', '赵六', '2000-01-01', 1, '123123123123213', '计算机科学与技术', 2025, '计算机1902');
INSERT INTO `tbl_stu`
VALUES ('s1002', '孙七', '2000-02-15', 2, '110101200002155678', '软件工程', 2019, '软件1901');
INSERT INTO `tbl_stu`
VALUES ('s1003', '周八', '1999-12-10', 1, '110101199912109012', '数据科学与大数据技术', 2019, '数据1901');
INSERT INTO `tbl_stu`
VALUES ('s1004', '吴九', '2000-03-20', 2, '110101200003203456', '人工智能', 2019, '智能1901');

-- ----------------------------
-- Table structure for tbl_lesson
-- ----------------------------
DROP TABLE IF EXISTS `tbl_lesson`;
CREATE TABLE `tbl_lesson`
(
    `lesson_id`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程id',
    `lesson_name`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名称',
    `lesson_class`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '教室',
    `lesson_score` double NULL DEFAULT NULL COMMENT '学分',
    `lesson_time`   int NULL DEFAULT NULL COMMENT '课时',
    `lesson_day`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '上课天周一',
    `lesson_date`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '上课时间(8:00-10:00)',
    `lesson_type`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '考试类型',
    `lesson_logger` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '备注',
    PRIMARY KEY (`lesson_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_lesson
-- ----------------------------
INSERT INTO `tbl_lesson`
VALUES ('CS101', '数据结构', '计算机楼101', 3, 48, '周一,周三', '10:00-12:00', '考试', '必修课程');
INSERT INTO `tbl_lesson`
VALUES ('CS102', '操作系统', '计算机楼102', 3.5, 56, '周二,周四', '08:00-10:00', '考试', '必修课程');
INSERT INTO `tbl_lesson`
VALUES ('CS103', '计算机网络', '计算机楼103', 3, 48, '周二,周五', '14:00-16:00', '考试', '必修课程');
INSERT INTO `tbl_lesson`
VALUES ('CS104', '数据库原理', '计算机楼201', 3.5, 56, '周一,周四', '16:00-18:00', '考试', '必修课程');
INSERT INTO `tbl_lesson`
VALUES ('CS201', '人工智能导论', '计算机楼202', 2, 24, '周三', '8:00-9:50', '闭卷考试', '选修课程');
INSERT INTO `tbl_lesson`
VALUES ('L20250822144700', '高级软件工程', 'A213', 2.5, 24, '周四', '19:00-20:50', '开卷考试', '');
INSERT INTO `tbl_lesson`
VALUES ('L20250822145650', '大学英语', '教B301', 3, 24, '周二', '10:10-12:00', '开卷考试', '需要带英语课本');
INSERT INTO `tbl_lesson`
VALUES ('L20250822150147', '天天酷跑', 'A123', 3, 48, '周六', '16:10-18:00', '闭卷考试', '');
INSERT INTO `tbl_lesson`
VALUES ('L20250822150205', '高等数学B', 'B111', 3.5, 48, '周二', '14:00-15:50', '开卷考试', '');
INSERT INTO `tbl_lesson`
VALUES ('L20250822150230', '高级小白软件工程', 'A321', 2, 48, '周二', '10:10-12:00', '闭卷考试', '');

-- ----------------------------
-- Table structure for tbl_stu_lesson
-- ----------------------------
DROP TABLE IF EXISTS `tbl_stu_lesson`;
CREATE TABLE `tbl_stu_lesson`
(
    `id`          int                                                           NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `stu_id`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生学号',
    `lesson_id`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程id',
    `lesson_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程名称',
    `state`       int NULL DEFAULT NULL COMMENT '状态 0:未选 1:已选',
    `score`       int NULL DEFAULT NULL COMMENT '成绩',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `stu_id`(`stu_id` ASC) USING BTREE,
    INDEX         `lesson_id`(`lesson_id` ASC) USING BTREE,
    CONSTRAINT `tbl_stu_lesson_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `tbl_stu` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `tbl_stu_lesson_ibfk_2` FOREIGN KEY (`lesson_id`) REFERENCES `tbl_lesson` (`lesson_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生课程关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_stu_lesson
-- ----------------------------
INSERT INTO `tbl_stu_lesson`
VALUES (1, 's1001', 'CS101', '数据结构', 1, 85);
INSERT INTO `tbl_stu_lesson`
VALUES (2, 's1001', 'CS102', '操作系统', 1, 12);
INSERT INTO `tbl_stu_lesson`
VALUES (3, 's1001', 'CS103', '计算机网络', 1, 78);
INSERT INTO `tbl_stu_lesson`
VALUES (4, 's1002', 'CS101', '数据结构', 1, 92);
INSERT INTO `tbl_stu_lesson`
VALUES (5, 's1002', 'CS104', '数据库原理', 1, 88);
INSERT INTO `tbl_stu_lesson`
VALUES (6, 's1003', 'CS102', '操作系统', 1, 12);
INSERT INTO `tbl_stu_lesson`
VALUES (7, 's1003', 'CS103', '计算机网络', 1, 82);
INSERT INTO `tbl_stu_lesson`
VALUES (8, 's1003', 'CS201', '人工智能导论', 1, 95);
INSERT INTO `tbl_stu_lesson`
VALUES (9, 's1004', 'CS104', '数据库原理', 1, 80);
INSERT INTO `tbl_stu_lesson`
VALUES (10, 's1004', 'CS201', '人工智能导论', 1, 87);
INSERT INTO `tbl_stu_lesson`
VALUES (11, 's1001', 'L20250822144700', '高级软件工程', 1, 32);
INSERT INTO `tbl_stu_lesson`
VALUES (12, 's1002', 'L20250822144700', '高级软件工程', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (13, 's1003', 'L20250822144700', '高级软件工程', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (14, 's1004', 'L20250822144700', '高级软件工程', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (15, 's1001', 'L20250822145650', '大学英语', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (16, 's1002', 'L20250822145650', '大学英语', 1, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (17, 's1003', 'L20250822145650', '大学英语', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (18, 's1004', 'L20250822145650', '大学英语', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (19, 's1001', 'L20250822150147', '天天酷跑', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (20, 's1002', 'L20250822150147', '天天酷跑', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (21, 's1003', 'L20250822150147', '天天酷跑', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (22, 's1004', 'L20250822150147', '天天酷跑', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (23, 's1001', 'L20250822150205', '高等数学B', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (24, 's1002', 'L20250822150205', '高等数学B', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (25, 's1003', 'L20250822150205', '高等数学B', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (26, 's1004', 'L20250822150205', '高等数学B', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (27, 's1001', 'L20250822150230', '高级小白软件工程', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (28, 's1002', 'L20250822150230', '高级小白软件工程', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (29, 's1003', 'L20250822150230', '高级小白软件工程', 0, 0);
INSERT INTO `tbl_stu_lesson`
VALUES (30, 's1004', 'L20250822150230', '高级小白软件工程', 0, 0);


-- ----------------------------
-- Table structure for tbl_teacher_lesson
-- ----------------------------
DROP TABLE IF EXISTS `tbl_teacher_lesson`;
CREATE TABLE `tbl_teacher_lesson`
(
    `id`         int                                                           NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `teacher_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师工号',
    `lesson_id`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程id',
    `date`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建日期',
    `state`      int NULL DEFAULT NULL COMMENT '状态 0:待审核 1:已审核通过 2:审核未通过',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX        `teacher_id`(`teacher_id` ASC) USING BTREE,
    INDEX        `lesson_id`(`lesson_id` ASC) USING BTREE,
    CONSTRAINT `tbl_teacher_lesson_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `tbl_teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `tbl_teacher_lesson_ibfk_2` FOREIGN KEY (`lesson_id`) REFERENCES `tbl_lesson` (`lesson_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '教师课程关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_teacher_lesson
-- ----------------------------
INSERT INTO `tbl_teacher_lesson`
VALUES (1, 't001', 'CS101', '2023-09-01', 1);
INSERT INTO `tbl_teacher_lesson`
VALUES (2, 't001', 'CS102', '2023-09-01', 1);
INSERT INTO `tbl_teacher_lesson`
VALUES (3, 't002', 'CS103', '2023-09-01', 1);
INSERT INTO `tbl_teacher_lesson`
VALUES (4, 't002', 'CS104', '2023-09-01', 1);
INSERT INTO `tbl_teacher_lesson`
VALUES (5, 't003', 'CS201', '2023-09-01', 1);
INSERT INTO `tbl_teacher_lesson`
VALUES (6, 't001', 'L20250822144700', '2025-08-22 14:47:21', 1);
INSERT INTO `tbl_teacher_lesson`
VALUES (7, 't001', 'L20250822145650', '2025-08-22 14:57:25', 1);
INSERT INTO `tbl_teacher_lesson`
VALUES (8, 't002', 'L20250822150147', '2025-08-22 15:02:03', 2);
INSERT INTO `tbl_teacher_lesson`
VALUES (9, 't002', 'L20250822150205', '2025-08-22 15:02:24', 1);
INSERT INTO `tbl_teacher_lesson`
VALUES (10, 't002', 'L20250822150230', '2025-08-22 15:02:47', 2);



SET
FOREIGN_KEY_CHECKS = 1;
