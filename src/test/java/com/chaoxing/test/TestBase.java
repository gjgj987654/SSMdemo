package com.chaoxing.test;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志输出使用自定义日志文件
 */
public class TestBase {
    protected final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);

    @Before
    public void initLog() {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        try {
            configurator.doConfigure(Thread.currentThread().getContextClassLoader().getResourceAsStream("logback-spring.xml"));
        } catch (JoranException e) {
            LOGGER.error("init slf4j error:", e);
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
    }

}
