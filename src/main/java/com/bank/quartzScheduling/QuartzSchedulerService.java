package com.bank.quartzScheduling;

import com.bank.quartzScheduling.factories.JobFactory;
import com.bank.quartzScheduling.factories.TriggerFactory;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

@Singleton
public class QuartzSchedulerService {

    @Inject
    JobFactory jobFactory;

    @Inject
    TriggerFactory triggerFactory;

    public void scheduleJob(Scheduler scheduler, Class<? extends Job> jobClass, String groupName, int intervalMinutes) throws SchedulerException {
        String jobName = jobClass.getName();
        JobDetail job = jobFactory.createJob(jobClass, jobName, groupName);
        String triggerName = jobName + "Trigger";
        Trigger trigger = triggerFactory.createTrigger(triggerName, groupName, intervalMinutes);

        scheduler.scheduleJob(job, trigger);
    }
}
