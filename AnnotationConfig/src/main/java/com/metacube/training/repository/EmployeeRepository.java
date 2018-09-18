package com.metacube.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.metacube.training.models.Employee;
import com.metacube.training.models.Project;

public interface EmployeeRepository<P> extends JpaRepository<Employee, Integer> {
	
    @Query("Select e from Employee e where e.enabled = ?1")
	public List<Employee> getAllEmployees(String enabled);

	@Query("Select e from Employee e where e.email = ?1 and e.password = ?2")
	public Employee getEmployeeByEmailAndPassword(String email, String password);
	
	@Query("Select e from Employee e where e.email = ?1")
	public Employee getEmployeeByEmail(String email);
	
	@Query("Select e from Employee e where e.code = ?1")
	public Employee getEmployeeByCode(int code);

	@Modifying
	@Query("Update Employee SET enabled = ?1 WHERE code = ?2")
	public int deleteEmployee(String enabled, int code);

	@Query("Select e from Employee e, EmployeeProject ep , Project p where e.code = ep.employeeCode AND "
			+ "p.projectId = ep.projectId AND p.name = ?1")
	public List<Employee> searchEmployeesByProject(String projectName);

	@Query("Select e from Employee e, EmployeeSkillMap es , Skills sm where e.code = es.employeeCode AND "
			+ "sm.skillId = es.skillId AND sm.skillName = ?1")
	public List<Employee> searchEmployeeBySkill(String skill);

}
