package com.yq.edu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: edu
 * @description: 选课信息Vo
 * @author: YeahQing
 * @create: 2019-11-03 22:27
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonInfoVo {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    //课程id
    @TableField(value = "lesson_id")
    private String lessonId;

    //课程名称
    @TableField(value = "lesson_name")
    private String lessonName;

    //教室
    @TableField(value = "lesson_class")
    private String lessonClass;

    //学分
    @TableField(value = "lesson_score")
    private Double lessonScore;

    //课时
    @TableField(value = "lesson_time")
    private Integer lessonTime;

    //上课天周一
    @TableField(value = "lesson_day")
    private String lessonDay;

    //上课时间(8:00-10:00)
    @TableField(value = "lesson_date")
    private String lessonDate;

    //考试类型
    @TableField(value = "lesson_type")
    private String lessonType;

    //备注
    @TableField(value = "lesson_logger")
    private String lessonLogger;

    //授课教师
    @TableField(value = "teacher_name")
    private String teacherName;



}
