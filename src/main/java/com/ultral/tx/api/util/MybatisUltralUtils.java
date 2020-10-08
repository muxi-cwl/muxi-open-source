package com.ultral.tx.api.util;

import com.ultral.tx.api.dao.DevQuestionDao;
import com.ultral.tx.api.entity.DevQuestionDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.Reader;
import java.util.List;


public class MybatisUltralUtils {

    SqlSessionFactoryBean sqlSessionFactoryBean;

      public static SqlSession getSqlSession() throws Exception{
          Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
          SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
          SqlSessionFactory factory = factoryBuilder.build(reader);
          SqlSession sqlSession = factory.openSession();
          return sqlSession;
      }

    public static void main(String[] args) throws Exception{
        SqlSession sqlSession = MybatisUltralUtils.getSqlSession();
        List<DevQuestionDO> devQuestionDOS = sqlSession.selectList("QuestionDO.queryPage", DevQuestionDO.class);

        for (DevQuestionDO d : devQuestionDOS) {
//            System.out.println(d);
        }

        DevQuestionDao questionDao = sqlSession.getMapper(DevQuestionDao.class);
        List<DevQuestionDO> devQuestionDOList = questionDao.queryAllQuestion();
        devQuestionDOList.stream().forEach(q->{
            System.out.println(q);
        });
    }
}
