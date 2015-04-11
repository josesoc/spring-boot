package com.mios.spring.boot.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//http://www.quartz-scheduler.org/documentation/quartz-1.x/tutorials/crontrigger
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //Fire every 5 seconds
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
    
    //0 56 10 * * ?		- Fire at 10:56 am every day
    @Scheduled(cron="0 52 11 * * ?")
    public void reportCurrentTime_date() {
        System.out.println("The date is now " + dateFormat.format(new Date()));
    }
}
