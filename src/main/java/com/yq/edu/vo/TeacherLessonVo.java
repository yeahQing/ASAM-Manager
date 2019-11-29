package com.yq.edu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: edu
 * @description: 教师课程vo
 * @author: YeahQing
 * @create: 2019-11-03 20:42
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("tbl_teacher_lesson")
public class TeacherLessonVo implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "teacher_id")
    private String teacherId;

    @TableField(value = "lesson_id")
    private String lessonId;

    @TableField(value = "date")
    private String date;

    @TableField(value = "state")
    private Integer state;

}
