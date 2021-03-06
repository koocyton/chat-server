package com.doopp.gauss.server.configuration;


import com.doopp.gauss.server.task.WerewolfGame;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class TaskExecutorConfiguration {

    @Bean(name="wolfKillGame")
    public WerewolfGame wolfKillGame(@Qualifier("taskExecutor") ThreadPoolTaskExecutor taskExecutor) {
        return new WerewolfGame(taskExecutor);
    }

    @Bean(name="taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor () {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(25);
        return threadPoolTaskExecutor;
    }
}
