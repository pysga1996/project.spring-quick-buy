package com.revice.mindorder.quickbuy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
public class MindOrderTestConfig implements InitializingBean, DisposableBean {


    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
