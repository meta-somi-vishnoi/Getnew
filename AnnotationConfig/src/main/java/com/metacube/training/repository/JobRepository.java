package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.models.Employee;
import com.metacube.training.models.JobTitle;
import com.metacube.training.models.Project;

public interface JobRepository<P> extends JpaRepository<JobTitle, Integer> {

	public JobTitle getJobByJobCode(int jobId);
	
	
}

