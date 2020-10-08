package com.ultral.tx.api;

import com.ultral.tx.api.dao.DevQuestionDao;
import com.ultral.tx.api.dao.UserDao;
import com.ultral.tx.api.entity.DevQuestionDO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ApplicationContextStart {

    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("spring-context.xml");
        DevQuestionDao devQuestionDao
                = context.getBean("devQuestionDao", DevQuestionDao.class);

//        List<DevQuestionDO> devQuestionDOS =
//                devQuestionDao.queryAllQuestion();
//        System.out.println(devQuestionDOS);

        UserDao userDao = context.getBean("userDao", UserDao.class);

        List<DevQuestionDO> devQuestionDOS = userDao.queryAllUser();
        devQuestionDOS.stream().forEach(u->{
            System.out.println(u);
        });
    }
}
