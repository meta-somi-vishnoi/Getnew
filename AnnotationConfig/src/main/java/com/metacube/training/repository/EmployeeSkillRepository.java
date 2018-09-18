package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.models.Employee;
import com.metacube.training.models.EmployeeSkillMap;
import com.metacube.training.models.Project;

public interface EmployeeSkillRepository<P> extends JpaRepository<EmployeeSkillMap, Integer> {

    @Query("SELECT e from EmployeeSkillMap e where e.employeeCode = ?1 and e.skillId = ?2")
	public EmployeeSkillMap getEmployeeSkill(int employeeCode, int skillId);
    
//    @Query("select e from Employee e, Skills s inner join e.map  inner join s.mapper where "
//            + "s.skillName = ?1")
//    public List<Employee> searchEmployeeBySkill(String skill); 
}
 