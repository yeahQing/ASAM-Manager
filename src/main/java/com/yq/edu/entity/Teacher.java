package com.yq.edu.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: edu
 * @description: 教师实体类
 * @author: YeahQing
 * @create: 2019-11-02 20:48
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("tbl_teacher")
public class Teacher {

    @TableId(value = "teacher_id",type = IdType.INPUT)
    @ExcelProperty(value = "教职工号", index = 0)
    private String teacherId;

    @TableField(value = "teacher_name")
    @ExcelProperty(value = "姓名", index = 1)
    private String teacherName;

    @TableField(value = "birth")
    @ExcelProperty(value = "出生日期", index = 2)
    @DateTimeFormat("yyyy-MM-dd")
    private String birth;

    @TableField(value = "gender")
    @ExcelProperty(value = "性别", index = 3)
    private Integer gender;

    @TableField(value = "id_card")
    @ExcelProperty(value = "身份证号", index = 4)
    private String idCard;

    @TableField(value = "job")
    @ExcelProperty(value = "职位", index = 5)
    private String job;

    @TableField(value = "profess")
    @ExcelProperty(value = "职称", index = 6)
    private String profess;

    @TableField(value = "educational")
    @ExcelProperty(value = "教育背景", index = 7)
    private String educational;

    @TableField(value = "study_filed")
    @ExcelProperty(value = "研究方向", index = 8)
    private String studyFiled;

    @TableField(value = "department")
    @ExcelProperty(value = "所属部门/学院", index = 9)
    private String department;
}
