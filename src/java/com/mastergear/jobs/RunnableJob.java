package com.mastergear.jobs;

/**
 * User: denise
 * Date: 7/5/13
 * Time: 2:30 PM
 */
public interface RunnableJob {
    public void run();
    public void setJobId(int jobId);
    public void updateProgress();
}
