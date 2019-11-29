package com.yq.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: edu
 * @description: 课程实体类
 * @author: YeahQing
 * @create: 2019-11-02 20:50
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("tbl_lesson")
public class Lesson{

    //课程id
    @TableId(value = "lesson_id",type = IdType.INPUT)
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

    //上课天列表
    @TableField(exist = false)
    private List<String> lessonDayList;

    //上课时间列表
    @TableField(exist = false)
    private List<String> lessonDateList;
}
