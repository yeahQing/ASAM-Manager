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
 * @description: 学生课程vo
 * @author: YeahQing
 * @create: 2019-11-04 00:22
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("tbl_stu_lesson")
public class StuLessonVo implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "stu_id")
    private String stuId;

    @TableField(value = "lesson_id")
    private String lessonId;

    @TableField(value = "lesson_name")
    private String lessonName;

    @TableField(value = "state")
    private Integer state;

    @TableField(value = "score")
    private Integer score;
}
