package com.mastergear

import com.mastergear.jobs.Job
import com.mastergear.jobs.JobStatus

import java.util.concurrent.Callable
import java.util.concurrent.Executors

class JobSchedulingService {

    def threadPool = Executors.newCachedThreadPool()

    def scheduleJob(String jobType, f) {
        final int jobId = createJob(jobType);
        final JobSchedulingService service = this;

        threadPool.submit(new Callable() {
            Object call() throws Exception {
                try {
                    service.updateJobStatus(jobId, JobStatus.RUNNING);
                    f(jobId);
                } catch (Throwable t) {
                    service.updateJobStatus(jobId, JobStatus.FAILED);
                    service.updateResult(jobId, t.getMessage());
                    return;
                }
                service.updateJobStatus(jobId, JobStatus.SUCCESSFUL);
            }
        })
    }

    def createJob(String jobType) {
        Job job = new Job();
        job.setJobType(jobType);
        job.setStatus(JobStatus.SCHEDULED);
        job.setProgress(0);
        Job.withTransaction {
            job.save(flush:true);
        }

        return job.getId();
    }

    def updateJobStatus(int jobId, JobStatus status) {
        Job job = Job.get(jobId);
        job.setStatus(status);
        Job.withTransaction {
            job.save(flush:true);
        }
    }

    def updateJobProgress(int jobId, int progress) {
        Job job = Job.get(jobId);
        job.setProgress(progress);
        Job.withTransaction {
            job.save(flush:true);
        }
    }

    def updateResult(int jobId, String result) {
        Job job = Job.get(jobId);
        job.setResult(result.substring(0,Math.min(result.length(), 500)));
        Job.withTransaction {
            job.save(flush:true);
        }
    }
}
