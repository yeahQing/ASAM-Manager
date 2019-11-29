package com.yq.edu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.edu.entity.Lesson;
import com.yq.edu.entity.Student;
import com.yq.edu.entity.Teacher;
import com.yq.edu.service.LessonService;
import com.yq.edu.service.StudentService;
import com.yq.edu.vo.LessonInfoVo;
import com.yq.edu.vo.StuLessonVo;
import com.yq.edu.vo.TeacherLessonVo;
import com.yq.edu.vo.UserRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @program: edu
 * @description: 学生控制器
 * @author: YeahQing
 * @create: 2019-11-03 11:27
 **/

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private LessonService lessonService;

    //首页仪表盘接口
    @RequestMapping("/dashboard")
    public String toDashBoard(HttpSession httpSession,Model model){
        UserRoleVo user = (UserRoleVo) httpSession.getAttribute ( "user" );
        //已选课程数
        int selectedLessonsNum = lessonService.countLessons(user.getUserId ());
        //分数大于等于60分的课程 及格
        int lessonsReScoreNum = lessonService.countLessonsReScore(user.getUserId ());
        //分数小于60分的课程 不及格
        int lessonsLtScoreNum = lessonService.countLessonsLtScore(user.getUserId ());
        model.addAttribute ( "selectedLessonsNum",selectedLessonsNum );
        model.addAttribute ( "lessonsReScoreNum",lessonsReScoreNum );
        model.addAttribute ( "lessonsLtScoreNum",lessonsLtScoreNum );
        return "student/dashboard";
    }

    //获得学生信息
    @RequestMapping("/getStudentInfo")
    public String getStudentInfo(Model model, HttpSession httpSession){
        UserRoleVo user = (UserRoleVo) httpSession.getAttribute ( "user" );
        Student student = studentService.getById ( user.getUserId () );
        model.addAttribute ( "student",student );
        return "student/studentInfo";
    }

    //保存学生信息
    @RequestMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student){
        studentService.updateByStudentId (student);
        return "redirect:/student/getStudentInfo";
    }

    //待选课程
    @RequestMapping("/getLessonInfo")
    public String getLessonInfo(@RequestParam(value = "page",defaultValue = "0") Integer page, Model model,HttpSession httpSession){
        if(page < 0){
            page = 0;
        }
        UserRoleVo user = (UserRoleVo) httpSession.getAttribute ( "user" );
        IPage<LessonInfoVo> lessonInfo = lessonService.getLessonInfo ( new Page<LessonInfoVo> ( page, 5 ),user.getUserId ());
        model.addAttribute ( "lessonInfo",lessonInfo );
        return "student/lessonInfoList";
    }

    //选课
    @RequestMapping("/chooseLesson/{lessonId}")
    public String chooseLesson(@PathVariable String lessonId,HttpSession httpSession){
        UserRoleVo user = (UserRoleVo) httpSession.getAttribute ( "user" );
        studentService.saveLesson(lessonId,user.getUserId (),1);
        return "redirect:/student/getSelectedLesson";
    }

    //退课
    @RequestMapping("/quitLesson/{lessonId}")
    public String quitLesson(@PathVariable String lessonId,HttpSession httpSession){
        UserRoleVo user = (UserRoleVo) httpSession.getAttribute ( "user" );
        studentService.saveLesson(lessonId,user.getUserId (),0);
        return "redirect:/student/getLessonInfo";
    }

    //已选课程
    @RequestMapping("/getSelectedLesson")
    public String getSelectedLesson(@RequestParam(value = "page",defaultValue = "0") Integer page, Model model,HttpSession httpSession){
        if(page < 0){
            page = 0;
        }
        UserRoleVo user = (UserRoleVo) httpSession.getAttribute ( "user" );
        IPage<StuLessonVo> stuLesson = lessonService.getStuLesson ( new Page<StuLessonVo> ( page, 5 ), user.getUserId () );
        model.addAttribute ( "stuLesson",stuLesson );
        return "student/selectedLessonList";
    }
}
