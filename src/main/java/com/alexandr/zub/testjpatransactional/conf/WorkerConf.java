package com.alexandr.zub.testjpatransactional.conf;

import com.alexandr.zub.testjpatransactional.service.Worker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerConf {
    static int count;

    @Bean
    Worker workerLock() {
        return new Worker(true);
    }
    @Bean
    Worker workerNotLock() {
        return new Worker(false);
    }

}
