package com.chaoxing.service;

import com.chaoxing.dao.TestDao;
import com.chaoxing.model.po.TestPo;
import com.chaoxing.mybatis.page.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

/**
 *
 * Created by sxc on 2018/9/3.
 *
 * email sunxu@chaoxing.com
 *
 */
@Service
public class TestService {

    @Resource
    TestDao testDao;

    public Page<TestPo> getPageTest() {
        return testDao.getTest();
    }


    @Transactional
    public void testTransactional() {
        TestPo test = new TestPo();
        test.setMsg("123");
        testDao.insert(test);

        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        TestPo test1 = new TestPo();
        test1.setMsg("abc");
        testDao.insert(test1);
    }

}
