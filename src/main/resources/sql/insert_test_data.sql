-- 插入测试数据脚本
-- 生成时间: " + new java.util.Date() + "

-- 1. 插入角色数据
INSERT INTO tbl_role (role_id, role_name) VALUES
(1, '管理员'),
(2, '教师'),
(3, '学生');

-- 2. 插入用户数据
INSERT INTO tbl_user (user_id, user_name, user_pwd, role_id) VALUES
('admin', '系统管理员', '123456', 1),
('t001', '张三老师', '123456', 2),
('t002', '李四老师', '123456', 2),
('s1001', '王五学生', '123456', 3),
('s1002', '赵六学生', '123456', 3);

-- 3. 插入菜单数据
INSERT INTO tbl_menu (id, name, parent_id, url, icon, menu_order, role_id) VALUES
(1, '系统管理', 0, '/admin/dashboard.html', 'fa-cog', 1, 1),
(2, '用户管理', 1, '/admin/user', 'fa-users', 1, 1),
(3, '角色管理', 1, '/admin/role', 'fa-user-tag', 2, 1),
(4, '教师管理', 1, '/admin/teacher/teacherList.html', 'fa-chalkboard-teacher', 3, 1),
(5, '学生管理', 1, '/admin/student', 'fa-user-graduate', 4, 1),
(6, '课程管理', 1, '/admin/lesson/lessonList.html', 'fa-book', 5, 1),
(7, '个人中心', 0, '/teacher/dashboard.html', 'fa-user', 2, 2),
(8, '我的课程', 7, '/teacher/openLesson.html', 'fa-book-open', 1, 2),
(9, '成绩管理', 7, '/teacher/addLessonScore.html', 'fa-graduation-cap', 2, 2),
(10, '学生中心', 0, '/student/dashboard.html', 'fa-user', 3, 3),
(11, '课程表', 10, '/student/lessonInfoList.html', 'fa-calendar-alt', 1, 3),
(12, '我的成绩', 10, '/student/studentInfo.html', 'fa-chart-line', 2, 3);

-- 4. 插入教师数据
INSERT INTO tbl_teacher (teacher_id, teacher_name, birth, gender, id_card, job, profess, educational, study_filed, department) VALUES
('t001', '张三', '1980-01-15', 1, '110101198001151234', '讲师', '副教授', '博士研究生', '计算机科学', '计算机学院'),
('t002', '李四', '1975-05-20', 1, '110101197505205678', '系主任', '教授', '博士研究生', '软件工程', '计算机学院'),
('t003', '王五', '1985-11-30', 2, '110101198511309012', '讲师', '讲师', '硕士研究生', '数据科学', '计算机学院');

-- 5. 插入学生数据
INSERT INTO tbl_stu (stu_id, stu_name, birth, gender, id_card, major, grade, stu_class) VALUES
('s1001', '赵六', '2000-01-01', 1, '110101200001011234', '计算机科学与技术', 2019, '计算机1901'),
('s1002', '孙七', '2000-02-15', 2, '110101200002155678', '软件工程', 2019, '软件1901'),
('s1003', '周八', '1999-12-10', 1, '110101199912109012', '数据科学与大数据技术', 2019, '数据1901'),
('s1004', '吴九', '2000-03-20', 2, '110101200003203456', '人工智能', 2019, '智能1901');

-- 6. 插入课程数据
INSERT INTO tbl_lesson (lesson_id, lesson_name, lesson_class, lesson_score, lesson_time, lesson_day, lesson_date, lesson_type, lesson_logger) VALUES
('CS101', '数据结构', '计算机楼101', 3.0, 48, '周一,周三', '10:00-12:00', '考试', '必修课程'),
('CS102', '操作系统', '计算机楼102', 3.5, 56, '周二,周四', '08:00-10:00', '考试', '必修课程'),
('CS103', '计算机网络', '计算机楼103', 3.0, 48, '周二,周五', '14:00-16:00', '考试', '必修课程'),
('CS104', '数据库原理', '计算机楼201', 3.5, 56, '周一,周四', '16:00-18:00', '考试', '必修课程'),
('CS201', '人工智能导论', '计算机楼202', 2.0, 32, '周三,周五', '10:00-12:00', '考查', '选修课程');

-- 7. 插入教师课程关联数据
INSERT INTO tbl_teacher_lesson (teacher_id, lesson_id, date, state) VALUES
('t001', 'CS101', '2023-09-01', 1),
('t001', 'CS102', '2023-09-01', 1),
('t002', 'CS103', '2023-09-01', 1),
('t002', 'CS104', '2023-09-01', 1),
('t003', 'CS201', '2023-09-01', 1);

-- 8. 插入学生课程关联数据
INSERT INTO tbl_stu_lesson (stu_id, lesson_id, lesson_name, state, score) VALUES
('s1001', 'CS101', '数据结构', 1, 85),
('s1001', 'CS102', '操作系统', 1, 90),
('s1001', 'CS103', '计算机网络', 1, 78),
('s1002', 'CS101', '数据结构', 1, 92),
('s1002', 'CS104', '数据库原理', 1, 88),
('s1003', 'CS102', '操作系统', 1, 75),
('s1003', 'CS103', '计算机网络', 1, 82),
('s1003', 'CS201', '人工智能导论', 1, 95),
('s1004', 'CS104', '数据库原理', 1, 80),
('s1004', 'CS201', '人工智能导论', 1, 87);