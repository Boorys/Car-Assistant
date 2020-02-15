package com.car.asistant.demo.databaseJob;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class Work {

    SqlJob sqlJob;

    @Autowired
    public Work(SqlJob sqlJob) {
        this.sqlJob = sqlJob;
    }

 //   @Scheduled(fixedRate = 10000)
    public void work() {
        sqlJob.job();
        System.out.println("sql");
    }

}
