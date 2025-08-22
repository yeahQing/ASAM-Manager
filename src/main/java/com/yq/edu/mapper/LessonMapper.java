package com.yq.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.edu.entity.Lesson;
import com.yq.edu.entity.Teacher;
import com.yq.edu.vo.LessonInfoVo;
import com.yq.edu.vo.StuLessonVo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LessonMapper extends BaseMapper<Lesson> {

    @Select( "select * from tbl_lesson" )
    IPage<Lesson> selectLessonListByPage(Page page);

    @Select ( "select tl.id,l.*,t.teacher_name from tbl_teacher t,tbl_lesson l,tbl_teacher_lesson tl,tbl_stu_lesson tsl where t.teacher_id = tl.teacher_id and l.lesson_id = tl.lesson_id and tl.state = 1 and tsl.state = 0 and tsl.stu_id = #{stuId} and tsl.lesson_id = l.lesson_id" )
    IPage<LessonInfoVo> getLessonInfo(Page<LessonInfoVo> page,String stuId);

    @Select( "select * from tbl_stu_lesson where stu_id = #{stuId} and state = 1" )
    IPage<StuLessonVo> getStuLesson(Page<StuLessonVo> page, @Param ( "stuId" ) String stuId);

    @Select ( "select count(*) from tbl_stu_lesson where stu_id = #{stuId} and state = 1" )
    int countLessons(@Param ( "stuId" ) String stuId);

    @Select ( "select count(*) from tbl_stu_lesson where stu_id = #{stuId} and state = 1 and score >= 60" )
    int countLessonsReScore(String userId);

    @Select ( "select count(*) from tbl_stu_lesson where stu_id = #{stuId} and state = 1 and score < 60" )
    int countLessonsLtScore(String userId);

    @Select ( "select count(*) from tbl_teacher_lesson where teacher_id = #{teacherId}" )
    int countAllTeacherLessons(@Param ( "teacherId" ) String teacherId);

    @Select ( "select count(*) from tbl_teacher_lesson where teacher_id = #{teacherId} and state = 1" )
    int countRightTeacherLessons(@Param ( "teacherId" ) String teacherId);

    @Select ( "select count(*) from tbl_teacher_lesson where teacher_id = #{teacherId} and state = 2" )
    int countErrorTeacherLessons(@Param ( "teacherId" ) String teacherId);

    @Select( "select * from tbl_stu_lesson where lesson_id = #{lessonId} and state = 1" )
    IPage<StuLessonVo> addLessonScore(Page<Object> page,@Param ( "lessonId" ) String lessonId);

    @Update ( "update tbl_stu_lesson set score = #{score} where id = #{id}" )
    void updateScoreById(@Param ( "id" ) Integer id,@Param ( "score" ) Integer score);

    @Delete ( "delete from tbl_stu_lesson where lesson_id = #{lessonId}" )
    void deleteStuLesson(@Param ( "lessonId" ) String lessonId);

    @Delete ( "delete from tbl_teacher_lesson where lesson_id = #{lessonId}" )
    void deleteTeacherLesson(String lessonId);

    @Update ( "update tbl_stu_lesson set lesson_name = #{lessonName} where lesson_id = #{lessonId}" )
    void updateStuLesson(@Param ( "lessonId" ) String lessonId,@Param ( "lessonName" ) String lessonName);

    @Update ( "update tbl_teacher_lesson set state = 0 where lesson_id = #{lessonId}" )
    void updateLessonState(@Param ( "lessonId" ) String lessonId);
}
