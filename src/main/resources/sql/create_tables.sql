-- 创建数据库表脚本
-- 生成时间: " + new java.util.Date() + "

-- 创建课程表 tbl_lesson
CREATE TABLE IF NOT EXISTS tbl_lesson (
    lesson_id VARCHAR(255) PRIMARY KEY COMMENT '课程id',
    lesson_name VARCHAR(255) NOT NULL COMMENT '课程名称',
    lesson_class VARCHAR(255) COMMENT '教室',
    lesson_score DOUBLE COMMENT '学分',
    lesson_time INT COMMENT '课时',
    lesson_day VARCHAR(255) COMMENT '上课天周一',
    lesson_date VARCHAR(255) COMMENT '上课时间(8:00-10:00)',
    lesson_type VARCHAR(255) COMMENT '考试类型',
    lesson_logger TEXT COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程表';

-- 创建菜单表 tbl_menu
CREATE TABLE IF NOT EXISTS tbl_menu (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '菜单id',
    name VARCHAR(255) NOT NULL COMMENT '菜单名称',
    parent_id INT COMMENT '父菜单id',
    url VARCHAR(255) COMMENT '菜单url',
    icon VARCHAR(255) COMMENT '菜单图标',
    menu_order INT COMMENT '菜单顺序',
    role_id INT COMMENT '菜单所属角色',
    FOREIGN KEY (role_id) REFERENCES tbl_role(role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';

-- 创建角色表 tbl_role
CREATE TABLE IF NOT EXISTS tbl_role (
    role_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '角色id',
    role_name VARCHAR(255) NOT NULL COMMENT '角色名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- 创建学生表 tbl_stu
CREATE TABLE IF NOT EXISTS tbl_stu (
    stu_id VARCHAR(255) PRIMARY KEY COMMENT '学号',
    stu_name VARCHAR(255) NOT NULL COMMENT '姓名',
    birth DATE COMMENT '出生日期',
    gender INT COMMENT '性别 0:未知 1:男 2:女',
    id_card VARCHAR(255) COMMENT '身份证号',
    major VARCHAR(255) COMMENT '专业',
    grade INT COMMENT '入学时间',
    stu_class VARCHAR(255) COMMENT '班级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生表';

-- 创建教师表 tbl_teacher
CREATE TABLE IF NOT EXISTS tbl_teacher (
    teacher_id VARCHAR(255) PRIMARY KEY COMMENT '教职工号',
    teacher_name VARCHAR(255) NOT NULL COMMENT '姓名',
    birth DATE COMMENT '出生日期',
    gender INT COMMENT '性别',
    id_card VARCHAR(255) COMMENT '身份证号',
    job VARCHAR(255) COMMENT '职位',
    profess VARCHAR(255) COMMENT '职称',
    educational VARCHAR(255) COMMENT '教育背景',
    study_filed VARCHAR(255) COMMENT '研究方向',
    department VARCHAR(255) COMMENT '所属部门/学院'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='教师表';

-- 创建用户表 tbl_user
CREATE TABLE IF NOT EXISTS tbl_user (
    user_id VARCHAR(255) PRIMARY KEY COMMENT '用户id 登录名',
    user_name VARCHAR(255) NOT NULL COMMENT '用户名',
    user_pwd VARCHAR(255) NOT NULL COMMENT '密码',
    role_id INT COMMENT '用户所属角色',
    FOREIGN KEY (role_id) REFERENCES tbl_role(role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 创建学生课程关联表 tbl_stu_lesson
CREATE TABLE IF NOT EXISTS tbl_stu_lesson (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    stu_id VARCHAR(255) NOT NULL COMMENT '学生学号',
    lesson_id VARCHAR(255) NOT NULL COMMENT '课程id',
    lesson_name VARCHAR(255) COMMENT '课程名称',
    state INT COMMENT '状态 0:未选 1:已选',
    score INT COMMENT '成绩',
    FOREIGN KEY (stu_id) REFERENCES tbl_stu(stu_id),
    FOREIGN KEY (lesson_id) REFERENCES tbl_lesson(lesson_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生课程关联表';

-- 创建教师课程关联表 tbl_teacher_lesson
CREATE TABLE IF NOT EXISTS tbl_teacher_lesson (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    teacher_id VARCHAR(255) NOT NULL COMMENT '教师工号',
    lesson_id VARCHAR(255) NOT NULL COMMENT '课程id',
    date VARCHAR(255) COMMENT '创建日期',
    state INT COMMENT '状态 0:待审核 1:已审核通过 2:审核未通过',
    FOREIGN KEY (teacher_id) REFERENCES tbl_teacher(teacher_id),
    FOREIGN KEY (lesson_id) REFERENCES tbl_lesson(lesson_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='教师课程关联表';