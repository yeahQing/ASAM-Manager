package com.yq.edu.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.edu.entity.*;
import com.yq.edu.service.*;
import com.yq.edu.util.StudentExcelListener;
import com.yq.edu.util.TeacherExcelListener;
import com.yq.edu.vo.TeacherLessonVo;
import com.yq.edu.vo.UserRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @program: edu
 * @description: 管理员控制器
 * @author: YeahQing
 * @create: 2019-11-03 11:26
 **/

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private UserService userService;

    //首页仪表盘接口
    @RequestMapping("/dashboard")
    public String toDashBoard(Model model){
        int studentCount = studentService.count ();
        int teacherCount = teacherService.count ();
        int lessonCount = lessonService.count ();

        model.addAttribute ( "studentCount",studentCount );
        model.addAttribute ( "teacherCount",teacherCount );
        model.addAttribute ( "lessonCount",lessonCount );

        return "admin/dashboard";
    }

    //学生管理->学生列表
    @RequestMapping("/getStudentList")
    public String getStudentList(@RequestParam(value = "page",defaultValue = "0") Integer page, Model model) {
        if(page < 0){
            page = 0;
        }
        IPage<Student> studentIPage = studentService.selectStudentListByPage ( new Page<Student> ( page, 5 ) );
        model.addAttribute ( "studentIPage",studentIPage );
        return "admin/student/studentList";
    }

    //学生管理->学生列表->编辑学生
    @RequestMapping("/editStu/{stuId}")
    public String toEditStu(@PathVariable String stuId,Model model){
        Student student = studentService.getById ( stuId );
        model.addAttribute ( "student",student );
        return "admin/student/editStudent";
    }

    //学生管理->学生列表->修改学生
    @RequestMapping("/updateStu")
    public String updateStu(@ModelAttribute Student student){
        studentService.updateByStudentId(student);
        return "redirect:/admin/getStudentList";
    }

    //学生管理->学生列表->删除学生
    @RequestMapping("/delStu/{stuId}")
    public String toDelStu(@PathVariable String stuId){
        studentService.delStudentByStudentId(stuId);
        userService.delUser ( stuId );
        return "redirect:/admin/getStudentList";
    }

    //学生管理->导入学生
    //访问import界面
    @RequestMapping("/importStu")
    public String toStuImport(){
        return "admin/student/importStudents";
    }

    //导入接口
    @RequestMapping(value = "/importStudents",method = RequestMethod.POST)
    @ResponseBody
    public String importStudents(@RequestParam(value="filename") MultipartFile file) throws IOException {

        StudentExcelListener listener = new StudentExcelListener ( studentService );

        EasyExcel.read(file.getInputStream(), Student.class, listener).sheet().doRead();

        userService.saveUser ( listener.getUserList () );

        return "上传成功!";
    }

    //教师管理->教师列表
    @RequestMapping("/getTeacherList")
    public String getTeacherList(@RequestParam(value = "page",defaultValue = "0") Integer page, Model model) {
        if(page < 0){
            page = 0;
        }
        IPage<Teacher> teacherIPage =  teacherService.selectTeacherListByPage(new Page<Teacher> ( page, 5 ));
        model.addAttribute ( "teacherIPage",teacherIPage );
        return "admin/teacher/teacherList";
    }

    //教师管理->教师列表->编辑教师
    @RequestMapping("/editTeacher/{teacherId}")
    public String toEditTeacher(@PathVariable String teacherId,Model model){
        Teacher teacher = teacherService.getById ( teacherId );
        model.addAttribute ( "teacher",teacher );
        return "admin/teacher/editTeacher";
    }
    //教师管理->教师列表->修改教师
    @RequestMapping("/updateTeacher")
    public String updateTeacher(@ModelAttribute Teacher teacher){
        teacherService.updateByTeacherId(teacher);
        return "redirect:/admin/getTeacherList";
    }
    //教师管理->教师列表->删除教师
    @RequestMapping("/delTeacher/{teacherId}")
    public String toDelTeacher(@PathVariable String teacherId){
        teacherService.delTeacherByTeacherId(teacherId);
        userService.delUser ( teacherId );
        return "redirect:/admin/getTeacherList";
    }

    //教师管理->导入教师
    //访问import界面
    @RequestMapping("/importTeach")
    public String toTeachImport(){
        return "admin/teacher/importTeachers";
    }

    //教师管理->导入教师
    @RequestMapping(value = "/importTeachers",method = RequestMethod.POST)
    @ResponseBody
    public String importTeachers(@RequestParam(value="filename") MultipartFile file) throws IOException {

        //创建教师监听器
        TeacherExcelListener listener = new TeacherExcelListener ( teacherService );

        //EasyExcel解析文件
        EasyExcel.read(file.getInputStream(), Teacher.class, listener).sheet().doRead();

        //储存到用户
        userService.saveUser ( listener.getUserList () );

        return "上传成功!";
    }
    //课程管理->课程列表
    @RequestMapping("/getLessonList")
    public String getLessonList(@RequestParam(value = "page",defaultValue = "0") Integer page, Model model) {
        if(page < 0){
            page = 0;
        }
        IPage<Lesson> lessonIPage =  lessonService.selectLessonListByPage(new Page<Lesson> ( page, 5 ));
        model.addAttribute ( "lessonIPage",lessonIPage );
        return "admin/lesson/lessonList";
    }

    //课程管理->课程列表-> 编辑
    @RequestMapping("editLesson/{lessonId}")
    public String editLesson(@PathVariable String lessonId,Model model){
        Lesson lesson = lessonService.getById ( lessonId );
        model.addAttribute ( "lesson",lesson );
        return "admin/lesson/editLesson";
    }
    //课程管理->课程列表-> 修改
    @RequestMapping("/updateLesson")
    public String updateLesson(@ModelAttribute Lesson lesson){
        lessonService.updateByLessonId(lesson);
        return "redirect:/admin/getLessonList";
    }
    //课程管理->课程列表-> 删除
    @RequestMapping("/delLesson/{lessonId}")
    public String delLesson(@PathVariable String lessonId){
        //根据lessonId删除tbl_stundet_lesson表中的数据
        //根据lessonId删除tbl_teacher_lesson表中的数据
        lessonService.delLessonByLessonId(lessonId);
        return "redirect:/admin/getLessonList";
    }
    //课程管理->审核课程
    @RequestMapping("/auditLesson")
    public String auditLesson(@RequestParam(value = "page",defaultValue = "0") Integer page, Model model,HttpSession httpSession){
        if(page < 0){
            page = 0;
        }
        IPage<TeacherLessonVo> teacherLessonVoIPage = teacherService.selectTeacherLessonVo ( new Page<> ( page, 5 ) );
        model.addAttribute ( "teacherLessonVoIPage",teacherLessonVoIPage );
        return "admin/lesson/auditLesson";
    }

    //审核课程详情
    @RequestMapping("/getLessonInfo/{lessonId}/{id}")
    public String getLessonInfo(@PathVariable String lessonId,@PathVariable Integer id,Model model){
        Lesson lesson = lessonService.getById ( lessonId );
        model.addAttribute ( "lesson",lesson );
        model.addAttribute ( "id",id );
        return "admin/lesson/lessonInfo";
    }

    //审核是否通过
    @RequestMapping("/auditCondition")
    public String auditCondition(@RequestParam(value = "id") Integer id,@RequestParam(value = "state") Integer state){
        teacherService.updateTeacherLessonVoById(id,state);
        return "redirect:/admin/auditLesson";
    }


}

