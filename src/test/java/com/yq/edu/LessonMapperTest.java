package com.yq.edu;

import com.yq.edu.entity.Lesson;
import com.yq.edu.entity.Teacher;
import com.yq.edu.mapper.LessonMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: edu
 * @description: 课程mapper测试
 * @author: YeahQing
 * @create: 2019-11-03 11:05
 **/
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LessonMapperTest {

    @Resource
    private LessonMapper lessonMapper;

    @Test
    public void selectTest(){
        List<Lesson> lessons = lessonMapper.selectList ( null );
        lessons.forEach ( lesson -> {
            String lessonDay = lesson.getLessonDay ();
            String[] lessonDayList = lessonDay.split ( ";" );
            List<String> list = new ArrayList<>();
            for(int i = 0;i < lessonDayList.length;i++){
//                System.out.println (lessonDayList[i]);
                list.add ( lessonDayList[i] );
//                lesson.getLessonDayList ().add ( lessonDayList[i] );
            }
            String lessonDate = lesson.getLessonDate ();
            String[] lessonDateList = lessonDate.split ( ";" );
            for(int i = 0;i < lessonDateList.length;i++){
                System.out.println (lessonDateList[i]);
//                lesson.getLessonDateList ().add ( lessonDateList[i] );
            }
            lesson.setLessonDayList ( list );
            lesson.getLessonDayList ().forEach ( System.out::println);
//            lesson.getLessonDateList ().forEach ( System.out::println );
        } );
    }


}
