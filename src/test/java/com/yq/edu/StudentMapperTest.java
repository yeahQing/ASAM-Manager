package com.yq.edu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.edu.entity.Student;
import com.yq.edu.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: edu
 * @description: 学生类映射测试
 * @author: YeahQing
 * @create: 2019-11-02 21:25
 **/

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StudentMapperTest {

    @Resource
    private StudentMapper studentMapper;

    @Test
    public void selectStu(){
        List<Student> stuList = studentMapper.selectList ( null );
        stuList.forEach ( System.out::println );
    }

    @Test
    public void selectStuByStuId(){
        Student student = studentMapper.selectById ( "201620205024" );
        System.out.println (student.getStuName ());
    }

    @Test
    public void insertStu(){

    }

    @Test
    public void updateStu(){
        Student student = studentMapper.selectById ( "201620205024" );
        student.setMajor ( "软件工程(服务外包方向)" );
        int update = studentMapper.updateById ( student );
        if(update > 0){
            System.out.println ("修改成功!");
        }
    }

    @Test
    public void deleteStu(){}

    //分页查询测试
    @Test
    public void selectStuByPage(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

        queryWrapper.like ( "stu_name","张三" ).le ( "grade",2016 );

        Page<Student> page = new Page<>(2,2);

        //查询名字为张三且入学时间小于等于2016年
       IPage<Map<String, Object>> mapIPage = studentMapper.selectMapsPage ( page, queryWrapper );

        System.out.println ("总页数"+mapIPage.getPages ());
        System.out.println ("总记录数"+mapIPage.getTotal ());

        List<Map<String, Object>> records = mapIPage.getRecords ();
        records.forEach ( System.out::println );
    }
}
