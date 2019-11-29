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
 * @description: 学生实体类
 * @author: YeahQing
 * @create: 2019-11-02 20:48
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("tbl_stu")
public class Student {

    @ExcelProperty(value = "学号", index = 0)
    @TableId(value = "stu_id", type = IdType.INPUT)
    private String stuId;//学号

    @ExcelProperty(value = "姓名", index = 1)
    @TableField(value = "stu_name")
    private String stuName;//姓名

    @ExcelProperty(value = "出生日期", index = 2)
    @DateTimeFormat("yyyy-MM-dd")
    @TableField(value = "birth")
    private String birth;//1997-09-19

    @ExcelProperty(value = "性别", index = 3)
    @TableField(value = "gender")
    private Integer gender;//性别 0:未知 1:男 2:女

    @ExcelProperty(value = "身份证号", index = 4)
    @TableField(value = "id_card")
    private String idCard;//身份证号

    @ExcelProperty(value = "专业", index = 5)
    @TableField(value = "major")
    private String major;//软件工程

    @ExcelProperty(value = "入学时间", index = 6)
    @TableField(value = "grade")
    private Integer grade;//入学时间2016

    @ExcelProperty(value = "班级", index = 7)
    @TableField(value = "stu_class")
    private String stuClass;//班级
}
