package com.yq.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.edu.entity.Student;
import com.yq.edu.vo.MenuRoleVo;
import com.yq.edu.vo.StuLessonVo;
import com.yq.edu.vo.TeacherLessonVo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @Select ( "select * from tbl_stu" )
    IPage<Student> selectStudentListByPage(Page page);


    @Update ( "update tbl_stu_lesson set state = #{state} where stu_id = #{stuId} and lesson_id = #{lessonId}" )
    void saveLesson(@Param ( "state" ) Integer state, @Param ( "stuId" ) String stuId, @Param ( "lessonId" ) String lessonId);

    @Insert ( "insert into tbl_stu_lesson values(#{id},#{stuId},#{lessonId},#{lessonName},#{state},#{score})" )
    void insertLesson(StuLessonVo stuLessonVo);
}
