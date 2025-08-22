package com.yq.edu.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.yq.edu.entity.Student;
import com.yq.edu.entity.User;
import com.yq.edu.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: edu
 * @description: 导入表格监听器
 * @author: YeahQing
 * @create: 2019-11-02 20:46
 **/

public class StudentExcelListener extends AnalysisEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger( StudentExcelListener.class);
    private static final int BATCH_COUNT = 5;

    private StudentService studentService;

    public StudentExcelListener(StudentService studentService){
        this.studentService = studentService;
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
            Student stu = (Student)datas.get ( i );
            studentService.save ( stu );
            saveDataToUser(stu);
        }
        LOGGER.info("存储数据库成功！");
    }

    private void saveDataToUser(Student stu ){
        User user = new User();
        user.setUserId ( stu.getStuId ());
        user.setUserName ( stu.getStuName () );
        user.setPassWord ( stu.getIdCard () );
        user.setRoleId ( 2 );
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