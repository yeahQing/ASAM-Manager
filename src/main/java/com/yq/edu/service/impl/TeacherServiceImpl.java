package com.yq.edu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yq.edu.entity.Teacher;
import com.yq.edu.mapper.TeacherMapper;
import com.yq.edu.service.TeacherService;
import com.yq.edu.vo.TeacherLessonVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: edu
 * @description: 教师业务层实现
 * @author: YeahQing
 * @create: 2019-11-03 11:36
 **/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public IPage<Teacher> selectTeacherListByPage(Page<Teacher> page) {
        return teacherMapper.selectTeacherListByPage ( page );
    }

    @Override
    public void updateByTeacherId(Teacher teacher) {
        teacherMapper.updateById ( teacher );
    }

    @Override
    public void delTeacherByTeacherId(String teacherId) {
        teacherMapper.deleteById ( teacherId );
    }

    @Override
    public void saveAskingInfo(String lessonId, String userId) {
        TeacherLessonVo teacherLessonVo = new TeacherLessonVo();
        String date = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" ).format ( new Date () );
        teacherLessonVo.setId ( null );
        teacherLessonVo.setLessonId ( lessonId );
        teacherLessonVo.setTeacherId ( userId );
        teacherLessonVo.setDate ( date );
        teacherLessonVo.setState ( 0 );
        teacherMapper.saveAskingInfo(teacherLessonVo);
    }

    @Override
    public IPage<TeacherLessonVo> selectTeacherLessonVo(Page<TeacherLessonVo> page) {
        return teacherMapper.selectTeacherLessonVo ( page );
    }

    @Override
    public IPage<TeacherLessonVo> selectTeacherLessonVoByTeacherId(Page<TeacherLessonVo> page, String teacherId) {
        return teacherMapper.selectTeacherLessonVoByTeacherId(page,teacherId);
    }

    @Override
    public void updateTeacherLessonVoById(Integer id, Integer state) {
        teacherMapper.updateTeacherLessonVoById(id,state);
    }
}
