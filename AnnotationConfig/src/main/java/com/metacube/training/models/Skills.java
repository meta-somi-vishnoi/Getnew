package com.metacube.training.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skill_master")
public class Skills {
	
	@Id
	@Column(name = "skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
		
	@Column(name = "skill_name")
	private String skillName;
	
    public int getSkillId() {
        return skillId;
    }
    public String getSkillName() {
        return skillName;
    }
    
    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
    
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
