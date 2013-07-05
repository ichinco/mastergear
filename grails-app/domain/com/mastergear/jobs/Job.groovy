package com.mastergear.jobs

class Job {

    String jobType;
    int progress;
    JobStatus status;
    Date lastUpdated;
    Date dateCreated;
    String result;

    static constraints = {
        result length:500, nullable:true
    }

}
