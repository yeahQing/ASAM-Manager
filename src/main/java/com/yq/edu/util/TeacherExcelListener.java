package com.yq.edu.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.yq.edu.entity.Student;
import com.yq.edu.entity.Teacher;
import com.yq.edu.entity.User;
import com.yq.edu.service.StudentService;
import com.yq.edu.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: edu
 * @description: 教师excel监听器
 * @author: YeahQing
 * @create: 2019-11-03 15:13
 **/

public class TeacherExcelListener extends AnalysisEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger( TeacherExcelListener.class);
    private static final int BATCH_COUNT = 5;

    private TeacherService teacherService;

    public TeacherExcelListener(TeacherService teacherService){
        this.teacherService = teacherService;
    }
    //可以通过实例获取该值
    private List<Object> datas = new ArrayList<Object> ();
    private List<User> userList = new ArrayList<User>();

    public void invoke(Object data, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        datas.add(data);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        if (datas.size() >= BATCH_COUNT) {
            saveData();
            datas.clear();
        }
    }

    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", datas.size());
        for(int i = 0;i<datas.size ();i++){
            Teacher teacher = (Teacher)datas.get ( i );
            teacherService.save ( teacher );
            saveDataToUser(teacher);
        }
        LOGGER.info("存储数据库成功！");
    }

    private void saveDataToUser(Teacher teacher){
        User user = new User();
        user.setUserId ( teacher.getTeacherId ());
        user.setUserName ( teacher.getTeacherName () );
        user.setPassWord ( teacher.getIdCard () );
        user.setRoleId ( 3 );
        userList.add ( user );
    }

    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    public List<User> getUserList() {
        return userList;
    }
}
