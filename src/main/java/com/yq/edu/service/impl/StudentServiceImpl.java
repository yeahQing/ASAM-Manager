package com.yq.edu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yq.edu.entity.Lesson;
import com.yq.edu.entity.Student;
import com.yq.edu.mapper.StudentMapper;
import com.yq.edu.service.StudentService;
import com.yq.edu.vo.StuLessonVo;
import com.yq.edu.vo.UserRoleVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: edu
 * @description: 学生业务层
 * @author: YeahQing
 * @create: 2019-11-02 21:28
 **/

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    //分页查询学生信息
    @Override
    public IPage<Student> selectStudentListByPage(Page<Student> page) {
        return studentMapper.selectStudentListByPage ( page );
    }

    //修改某一个学生的信息
    @Override
    public void updateByStudentId(Student student) {
        studentMapper.updateById ( student );
    }

    @Override
    public void delStudentByStudentId(String stuId) {
        studentMapper.deleteById ( stuId );
    }

    @Override
    public void saveLesson(String lessonId, String stuId,Integer state) {
        studentMapper.saveLesson(state,stuId,lessonId);
    }

    @Override
    public void insertLesson(Lesson lesson, String stuId, Integer state) {
        StuLessonVo stuLessonVo = new StuLessonVo ();
        stuLessonVo.setId (null);
        stuLessonVo.setLessonId ( lesson.getLessonId () );
        stuLessonVo.setStuId ( stuId );
        stuLessonVo.setLessonName ( lesson.getLessonName () );
        stuLessonVo.setScore ( 0 );
        stuLessonVo.setState ( state );
        studentMapper.insertLesson(stuLessonVo);
    }
}
