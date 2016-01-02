package com.toyioc.support;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class simpleLoggingTest {

    Logger log = LoggerFactory.getLogger(simpleLoggingTest.class);


    @Test
    public void ShouldLogSomething() {
        log.info("Hello World");
    }
}
