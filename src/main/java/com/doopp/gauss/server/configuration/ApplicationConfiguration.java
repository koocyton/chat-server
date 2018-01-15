package com.doopp.gauss.server.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableCaching

@Import({
    CommonUtil.class,
    EhcacheConfiguration.class,
    // RedisConfiguration.class,
    MyBatisConfiguration.class,
    TaskExecutorConfiguration.class,
    WebSocketConfiguration.class
})

@ComponentScan(basePackages={"com.doopp.gauss"}, excludeFilters={
    @ComponentScan.Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class)
})

public class ApplicationConfiguration {

}
