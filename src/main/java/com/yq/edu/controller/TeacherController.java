package com.yq.edu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.edu.entity.Lesson;
import com.yq.edu.entity.Student;
import com.yq.edu.entity.Teacher;
import com.yq.edu.service.LessonService;
import com.yq.edu.service.StudentService;
import com.yq.edu.service.TeacherService;
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
import java.util.List;

/**
 * @program: edu
 * @description: 教室控制器
 * @author: YeahQing
 * @create: 2019-11-03 11:27
 **/
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private StudentService studentService;

    //首页仪表盘接口
    @RequestMapping("/dashboard")
    public String toDashBoard(HttpSession httpSession,Model model){
        UserRoleVo user = (UserRoleVo) httpSession.getAttribute ( "user" );
        //申请课程数
        int allTeacherLessons = lessonService.countAllTeacherLessons(user.getUserId ());
        //申请课程state=1合格的
        int rightTeacherLessons = lessonService.countRightTeacherLessons(user.getUserId ());
        //申请课程state=2不合格的
        int errorTeacherLessons = lessonService.countErrorTeacherLessons(user.getUserId ());
        model.addAttribute ( "allTeacherLessons",allTeacherLessons );
        model.addAttribute ( "rightTeacherLessons",rightTeacherLessons );
        model.addAttribute ( "errorTeacherLessons",errorTeacherLessons );
        return "teacher/dashboard";
    }

    //获得教师信息
    @RequestMapping("/getTeacherInfo")
    public String getTeacherInfo(Model model, HttpSession httpSession){
        UserRoleVo user = (UserRoleVo) httpSession.getAttribute ( "user" );
        Teacher teacher = teacherService.getById ( user.getUserId () );
        model.addAttribute ( "teacher",teacher );
        return "teacher/teacherInfo";
    }

    //保存教师信息
    @RequestMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute Teacher teacher){
        teacherService.updateByTeacherId(teacher);
        return "redirect:/teacher/getTeacherInfo";
    }

    //教师开设课程页面
    @RequestMapping("/openLesson")
    public String openLesson(Model model){
        //生成课程编号
        String lessonId = lessonService.generateLessonId ();
        model.addAttribute ( "lessonId",lessonId );
        return "teacher/openLesson";
    }

    //教师申请开设课程
    @RequestMapping("/askLesson")
    public String askLesson(@ModelAttribute Lesson lesson,HttpSession httpSession){
        System.out.println (lesson);
        boolean save = lessonService.save ( lesson );
        if(save){
            List<Student> studentList = studentService.list ();
            studentList.forEach ( stu ->{
                studentService.insertLesson ( lesson,stu.getStuId (),0 );
            } );
            UserRoleVo user = (UserRoleVo) httpSession.getAttribute ( "user" );
            teacherService.saveAskingInfo(lesson.getLessonId (),user.getUserId ());
        }else{
            return "redirect:/teacher/dashboard";
        }
        return "redirect:/teacher/auditLesson";
    }

    //课程审计
    @RequestMapping("/auditLesson")
    public String auditLesson(@RequestParam(value = "page",defaultValue = "0") Integer page, Model model,HttpSession httpSession){
        if(page < 0){
            page = 0;
        }
        UserRoleVo user = (UserRoleVo) httpSession.getAttribute ( "user" );
//        IPage<TeacherLessonVo> teacherLessonVoIPage = teacherService.selectTeacherLessonVo ( new Page<> ( page, 5 ) );
        IPage<TeacherLessonVo> teacherLessonVoIPage = teacherService.selectTeacherLessonVoByTeacherId ( new Page<> ( page, 5 ), user.getUserId () );
        model.addAttribute ( "teacherLessonVoIPage",teacherLessonVoIPage );
        return "teacher/auditLesson";
    }

    //课程打分
    @RequestMapping("/addLessonScore/{lessonId}")
    public String addLessonScore(@PathVariable String lessonId,@RequestParam(value = "page",defaultValue = "0") Integer page, Model model) {
        if (page < 0) {
            page = 0;
        }
        IPage<StuLessonVo> lessonScorePage =  lessonService.addLessonScore(new Page<> ( page, 5 ),lessonId);
        model.addAttribute ( "lessonScorePage",lessonScorePage );
        model.addAttribute ( "lessonId",lessonId );
        return "teacher/addLessonScore";
    }

    @RequestMapping("confirmScore/{id}/{lessonId}")
    public String confirmScore(@PathVariable Integer id,@PathVariable String lessonId,@RequestParam("score") Integer score){
        lessonService.updateScoreById(id,score);
        return "redirect:/teacher/addLessonScore/"+lessonId;
    }

    @RequestMapping("changeLessonState/{lessonId}")
    public String changeLessonState(@PathVariable String lessonId){
        lessonService.changeLessonState(lessonId);
        return "redirect:/teacher/auditLesson";
    }
}
