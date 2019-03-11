package com.chaoxing.service;

import com.chaoxing.dao.TestDao;
import com.chaoxing.modules.utils.mapper.JsonMapper;
import com.chaoxing.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest extends TestBase {

    @Resource
    TestDao testDao;

    @Resource
    TestService testService;

    @Test
    public void testService() {
        LOGGER.info(JsonMapper.defaultMapper().toJson(testDao.getTest().get(0)));
        LOGGER.info(JsonMapper.defaultMapper().toJson(testService.getPageTest().get(0)));
    }

    @Test
    public void testTransactional() {
        testService.testTransactional();
    }
}
