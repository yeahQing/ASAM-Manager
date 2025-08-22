package com.yq.edu;

import com.yq.edu.entity.Teacher;
import com.yq.edu.mapper.TeacherMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: edu
 * @description: 教室mapper测试
 * @author: YeahQing
 * @create: 2019-11-03 11:04
 **/
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TeacherMapperTest {

    @Resource
    private TeacherMapper teacherMapper;

    @Test
    public void selectTest(){
        List<Teacher> teachers = teacherMapper.selectList ( null );
        teachers.forEach ( System.out::println );
    }


}
