package com.yq.edu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yq.edu.entity.Lesson;
import com.yq.edu.mapper.LessonMapper;
import com.yq.edu.service.LessonService;
import com.yq.edu.vo.LessonInfoVo;
import com.yq.edu.vo.StuLessonVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: edu
 * @description: 课程业务层实现
 * @author: YeahQing
 * @create: 2019-11-03 11:37
 **/

@Service
public class LessonServiceImpl extends ServiceImpl<LessonMapper, Lesson> implements LessonService {

    @Resource
    private LessonMapper lessonMapper;

    @Override
    public IPage<Lesson> selectLessonListByPage(Page<Lesson> page) {
        return lessonMapper.selectLessonListByPage ( page );
    }

    @Override
    public String generateLessonId() {
        String lessonId = "L"+new SimpleDateFormat ( "yyyyMMddHHmmss" ).format ( new Date () );
//        System.out.println (lessonId);
        return lessonId;
    }

    @Override
    public IPage<LessonInfoVo> getLessonInfo(Page<LessonInfoVo> page,String stuId) {
        return lessonMapper.getLessonInfo ( page,stuId);
    }

    @Override
    public IPage<StuLessonVo> getStuLesson(Page<StuLessonVo> page, String stuId) {
        return lessonMapper.getStuLesson(page,stuId);
    }

    @Override
    public int countLessons(String userId) {
        return lessonMapper.countLessons(userId);
    }

    @Override
    public int countLessonsReScore(String userId) {
        return lessonMapper.countLessonsReScore(userId);
    }

    @Override
    public int countLessonsLtScore(String userId) {
        return lessonMapper.countLessonsLtScore(userId);
    }

    @Override
    public int countAllTeacherLessons(String userId) {
        return lessonMapper.countAllTeacherLessons(userId);
    }

    @Override
    public int countRightTeacherLessons(String userId) {
        return lessonMapper.countRightTeacherLessons(userId);
    }

    @Override
    public int countErrorTeacherLessons(String userId) {
        return lessonMapper.countErrorTeacherLessons(userId);
    }

    @Override
    public IPage<StuLessonVo> addLessonScore(Page<Object> page, String lessonId) {
        return lessonMapper.addLessonScore(page,lessonId);
    }

    @Override
    public void updateScoreById(Integer id, Integer score) {
        lessonMapper.updateScoreById(id,score);
    }

    @Override
    public void updateByLessonId(Lesson lesson) {
        lessonMapper.updateById ( lesson );
        lessonMapper.updateStuLesson(lesson.getLessonId (),lesson.getLessonName ());
    }

    @Override
    public void delLessonByLessonId(String lessonId) {
        lessonMapper.deleteById ( lessonId );
        lessonMapper.deleteStuLesson( lessonId );
        lessonMapper.deleteTeacherLesson(lessonId);
    }

    @Override
    public void changeLessonState(String lessonId) {
        lessonMapper.updateLessonState(lessonId);
    }

}
