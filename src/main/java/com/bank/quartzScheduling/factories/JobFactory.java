package com.bank.quartzScheduling.factories;

import com.google.inject.Singleton;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;

@Singleton
public class JobFactory {

    public JobDetail createJob(Class<? extends Job> jobClass, String jobName, String groupName) {
        return JobBuilder.newJob(jobClass)
                .withIdentity(jobName, groupName)
                .build();
    }
}
