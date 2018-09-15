package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.models.EmployeeSkillMap;
import com.metacube.training.models.Project;

public interface EmployeeSkillRepository<P> extends JpaRepository<EmployeeSkillMap, Integer> {

	public EmployeeSkillMap getEmployeeSkill(int employeeCode, int skillId);
}
