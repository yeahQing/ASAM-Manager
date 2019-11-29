package com.yq.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yq.edu.entity.Teacher;
import com.yq.edu.vo.MenuRoleVo;
import com.yq.edu.vo.TeacherLessonVo;

public interface TeacherService extends IService<Teacher> {

    IPage<Teacher> selectTeacherListByPage(Page<Teacher> page);

    void updateByTeacherId(Teacher teacher);

    void delTeacherByTeacherId(String teacherId);

    void saveAskingInfo(String lessonId, String userId);

    IPage<TeacherLessonVo> selectTeacherLessonVo(Page<TeacherLessonVo> page);

    IPage<TeacherLessonVo> selectTeacherLessonVoByTeacherId(Page<TeacherLessonVo> page,String teacherId);

    void updateTeacherLessonVoById(Integer id, Integer state);
}
