package com.chaoxing.control;

import com.chaoxing.dao.TestDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by sxc on 2018/9/3.
 * email sunxu@chaoxing.com
 */

@Controller
public class TestController {
    @Resource
    TestDao testDao;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String test(Model model) {
        model.addAttribute("test", testDao.getTest().get(0));
        return "index";
    }
}
