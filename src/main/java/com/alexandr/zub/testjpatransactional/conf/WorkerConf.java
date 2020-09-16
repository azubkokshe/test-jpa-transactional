package com.alexandr.zub.testjpatransactional.conf;

import com.alexandr.zub.testjpatransactional.service.Worker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerConf {
    @Bean
    Worker workerLock() {
        return new Worker(true);
    }
}
