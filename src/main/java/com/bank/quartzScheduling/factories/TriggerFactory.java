package com.bank.quartzScheduling.factories;

import com.google.inject.Singleton;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

@Singleton
public class TriggerFactory {

    public Trigger createTrigger(String triggerName, String groupName, int intervalMinutes) {
        return TriggerBuilder.newTrigger()
                .withIdentity(triggerName, groupName)
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInMinutes(intervalMinutes)
                        .repeatForever())
                .build();
    }
}
