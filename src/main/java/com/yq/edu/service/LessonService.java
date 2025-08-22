package com.yq.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yq.edu.entity.Lesson;
import com.yq.edu.vo.LessonInfoVo;
import com.yq.edu.vo.StuLessonVo;

public interface LessonService extends IService<Lesson> {
    IPage<Lesson> selectLessonListByPage(Page<Lesson> page);

    String generateLessonId();

    IPage<LessonInfoVo> getLessonInfo(Page<LessonInfoVo> page,String stuId);

    IPage<StuLessonVo> getStuLesson(Page<StuLessonVo> stuLessonVoPage, String userId);

    int countLessons(String userId);

    int countLessonsReScore(String userId);

    int countLessonsLtScore(String userId);

    int countAllTeacherLessons(String userId);

    int countRightTeacherLessons(String userId);

    int countErrorTeacherLessons(String userId);

    IPage<StuLessonVo> addLessonScore(Page<Object> page, String lessonId);

    void updateScoreById(Integer id, Integer score);


    void updateByLessonId(Lesson lesson);

    void delLessonByLessonId(String lessonId);

    void changeLessonState(String lessonId);
}
