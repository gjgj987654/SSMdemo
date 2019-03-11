package com.chaoxing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 扫描根路径
 */
@SpringBootApplication
@EnableScheduling
@ServletComponentScan
public class BootApplication extends SpringBootServletInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(BootApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BootApplication.class);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(BootApplication.class, args);
        String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            LOGGER.info("BootApplication use profile:{}", profile);
        }
    }
}
