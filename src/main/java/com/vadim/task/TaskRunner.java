package com.vadim.task;

import com.vadim.task.logic.GreetingMessageProducer;
import com.vadim.task.logic.TimeZoneProducer;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.TimeZone;
import lombok.extern.slf4j.Slf4j;

/**
 * entry point
 * @author Вадим
 */
@Slf4j(topic = "file")
public class TaskRunner {

    public static void main(String[] args) {
        log.info("application executed with root args {}", Arrays.toString(args));
        String cityName;
        String zone = null;
        if(args.length > 0) {
            cityName = args[0];
            if(args.length > 1) {
                zone = args[1];
            }
        } else {
            log.error("wrong argument list {}", Arrays.toString(args));
            System.out.println("ERROR: At least 1 argument required.");
            return;
        }

        try {
            TimeZoneProducer timeZoneProducer = new TimeZoneProducer();
            TimeZone timeZone = timeZoneProducer.getTimeZone(zone, cityName);
            if(timeZone != null) {
                ZoneId zoneId = timeZone.toZoneId();
                LocalTime zoneSpecificLocalTime = LocalTime.now(zoneId);
                GreetingMessageProducer messageProducer = new GreetingMessageProducer();
                String greeting = messageProducer.getGreeting(zoneSpecificLocalTime.getHour(), cityName);
                log.info("generated message: {}", greeting);
                System.out.println(greeting);
            } else {
                log.error("Zone not found");
                System.out.println("ERROR: Time zone not found.");
            }
        } catch(Exception e) {
            log.error("error occured", e);
            System.out.println("ERROR: data processing error.");
        }
            
    }
}
