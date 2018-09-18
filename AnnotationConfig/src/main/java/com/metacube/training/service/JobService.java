package com.metacube.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.Status.Status;
import com.metacube.training.models.Employee;
import com.metacube.training.models.JobTitle;
import com.metacube.training.models.Project;
import com.metacube.training.repository.JobRepository;

@Service
public class JobService {
	@Autowired
	private JobRepository<JobTitle> jobRepository;

    public Status addJob(JobTitle job) {
        jobRepository.save(job);
        return Status.INSERTED;
    }

    public JobTitle getJobByCode(int code) {
        return jobRepository.getJobByJobCode(code);
    }

    public List<JobTitle> getAllJobs() {
        return jobRepository.findAll();
    }

    public Status deleteJob(int code) {
//        JobTitle job = jobRepository.getJobByCode(code);
//        if (job == null) {
//            return Status.NOT_EXIST;
//        } else {
//            jobRepository.de
//            return Status.DELETED;
//        }
        jobRepository.delete(code);
        return Status.DELETED;
    }

    public Status updateJob(JobTitle job) {
        JobTitle existingJob = jobRepository.getJobByJobCode(job.getJobCode());
        if (existingJob != null) {
            jobRepository.save(job);
            return Status.UPDATED;
        }
        return Status.NOT_EXIST;
    }
}
