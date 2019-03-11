package com.chaoxing.dao;

import com.chaoxing.model.po.TestPo;
import com.chaoxing.mybatis.MyBatisRepository;
import com.chaoxing.mybatis.basedao.IDao;
import com.chaoxing.mybatis.page.Page;
import org.apache.ibatis.annotations.Select;

/**
 * Created by sxc on 2018/9/3.
 * email sunxu@chaoxing.com
 */
@MyBatisRepository
public interface TestDao extends IDao<TestPo> {
    /**
     * 分页查询表信息
     *
     * @return
     */
    @Select("select * from test")
    Page<TestPo> getTest();

}
