package com.ipme.springboot.sample.SpringBootSample.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@PropertySource(ignoreResourceNotFound = true, value = "classpath:misc.properties")
public class GreetingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.buildNumber}")
    private String appBuildNumber;

    @RequestMapping(value = "/greeting", produces = "application/json")
    public @ResponseBody
    Map greeting() {
        LOGGER.info("entering greeting()");

        return Collections.singletonMap("response", "Hello World !");
    }

    @RequestMapping(value = "/version", produces = "application/json")
    public @ResponseBody
    Map version() {
        LOGGER.info("entering version()");

        // This is for PMD
        if ((1 == 1)) {

        }

        Map<String, String> map = new HashMap<>(2);
        map.put("version", appVersion);
        map.put("buildNumber", appBuildNumber);

        return map;
    }

    @RequestMapping(value = "/log", produces = "application/json")
    public @ResponseBody
    Map log() {
        LOGGER.info("entering log()");

        // This is for PMD
        try {
            LOGGER.debug("This is a debug message");
            LOGGER.info("This is an info message");
            LOGGER.warn("This is a warn message");
            LOGGER.error("This is an error message");
        } catch (Exception e) {

        }

        return Collections.singletonMap("response", "OK");
    }
}
