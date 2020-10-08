package com.ultral.tx.api.dao;

import com.ultral.tx.api.entity.DevQuestionDO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DevQuestionDao {

    /**
     * 查询所有的问题
     * @return
     */
    @Select("select * from dev_question")
    List<DevQuestionDO> queryAllQuestion();
}
