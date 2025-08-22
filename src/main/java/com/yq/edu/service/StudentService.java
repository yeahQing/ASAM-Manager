package com.yq.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yq.edu.entity.Lesson;
import com.yq.edu.entity.Student;
import com.yq.edu.vo.MenuRoleVo;
import com.yq.edu.vo.UserRoleVo;

public interface StudentService extends IService<Student> {

    //分页查询studnet
    IPage<Student> selectStudentListByPage(Page<Student> page);

    //修改学生信息
    void updateByStudentId(Student student);

    //删除学生信息
    void delStudentByStudentId(String stuId);

    void saveLesson(String lessonId, String stuId,Integer state);

    void insertLesson(Lesson lesson, String stuId, Integer state);
}
