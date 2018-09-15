package com.metacube.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.metacube.training.models.Employee;
import com.metacube.training.models.Project;

public interface EmployeeRepository<P> extends JpaRepository<Employee, Integer> {
	
	public List<Employee> getAllEmployees(String enabled);

	public Employee getEmployeeByUsername(String email, String password);
	
	public Employee getEmployeeByEmail(String email);
	
	public Employee getEmployeeByCode(int code);

	@Modifying
	@Query("Update Employee SET enabled = ?1 WHERE code = ?2")
	public int deleteEmployee(String enabled, int code);

	@Query("Select e from Employee e, EmployeeProject ep , Project p where e.code = ep.employeeCode AND "
			+ "p.projectId = ep.projectId AND p.name = :projectName")
	public List<Employee> searchEmployeesByProject(String projectName);

	@Query("Select e from Employee e, EmployeeSkillMap es , Skills sm where e.code = es.employeeCode AND "
			+ "sm.skillId = es.skillId AND sm.skillName = :skill")
	public List<Employee> searchEmployees(String skill);

}
