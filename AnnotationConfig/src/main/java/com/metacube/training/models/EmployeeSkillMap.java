package com.metacube.training.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_skills")
public class EmployeeSkillMap {
    
    @Id
    @Column(name = "employee_skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeSkillId;
    
    @Column(name = "employee_code")
    private int employeeCode;
    
    @Column(name = "skill_id")
    private int skillId;
    
    
    
    public int getEmployeeSkillId() {
        return employeeSkillId;
    }

    public void setEmployeeSkillId(int employeeSkillId) {
        this.employeeSkillId = employeeSkillId;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}
