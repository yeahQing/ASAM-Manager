package com.yq.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.edu.entity.Student;
import com.yq.edu.entity.Teacher;
import com.yq.edu.vo.TeacherLessonVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TeacherMapper extends BaseMapper<Teacher> {

    @Select( "select * from tbl_teacher" )
    IPage<Teacher> selectTeacherListByPage(Page page);

    @Insert ( "insert into tbl_teacher_lesson values(#{id},#{teacherId},#{lessonId},#{date},#{state}) " )
    void saveAskingInfo(TeacherLessonVo teacherLessonVo);

    @Select ( "select * from tbl_teacher_lesson where state = 0" )
    IPage<TeacherLessonVo> selectTeacherLessonVo(Page page);

    @Select ( "select * from tbl_teacher_lesson where teacher_id = #{teacherId}" )
    IPage<TeacherLessonVo> selectTeacherLessonVoByTeacherId(Page<TeacherLessonVo> page, String teacherId);

    @Update ( "update tbl_teacher_lesson set state = #{state} where id = #{id}" )
    void updateTeacherLessonVoById(@Param ( "id" ) Integer id,@Param ( "state" ) Integer state);
}
