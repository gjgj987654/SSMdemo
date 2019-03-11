package com.chaoxing.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * druid监控页面
 */
@WebServlet(urlPatterns = "/druid/*",
        initParams = {
                @WebInitParam(name = "loginUsername", value = "admin"),// 用户名
                @WebInitParam(name = "loginPassword", value = "admin"),// 密码
                @WebInitParam(name = "resetEnable", value = "false"),
                @WebInitParam(name = "allow", value = "127.0.0.1,192.168.98.45"),// IP白名单(没有配置或者为空，则允许所有访问)
                @WebInitParam(name = "deny", value = "192.168.98.50"),// IP黑名单 (存在共同时，deny优先于allow)

        })
public class DruidMonitor extends StatViewServlet {

}