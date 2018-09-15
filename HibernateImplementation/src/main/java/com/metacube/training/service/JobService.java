package com.metacube.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.dao.JobDao;
import com.metacube.training.dao.ProjectDao;
import com.metacube.training.models.JobTitle;
import com.metacube.training.models.Project;

@Service
public class JobService {

    @Autowired
    private JobDao jobDao;

    public Status addJob(JobTitle job) {
        Status status = jobDao.addJob(job);
        return status;
    }

    public JobTitle getJobByCode(int code) {
        return jobDao.getJobByCode(code);
    }

    public List<JobTitle> getAllJobs() {
        return jobDao.getAllJobs();
    }

    public Status deleteJob(int code) {
        JobTitle job = jobDao.getJobByCode(code);
        if (job == null) {
            return Status.NOT_EXIST;
        } else {
            Status status = jobDao.deleteJob(job);
            return status;
        }
    }

    public Status updateJob(JobTitle job) {
        JobTitle existingJob = jobDao.getJobByCode(job.getJobCode());
        if (existingJob != null) {
            Status status = jobDao.updateJob(job);
            return status;
        }
        return Status.NOT_EXIST;
    }
}
