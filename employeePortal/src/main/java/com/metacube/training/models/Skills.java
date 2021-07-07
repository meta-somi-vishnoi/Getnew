package com.metacube.training.models;

import javax.validation.constraints.NotNull;

public class Skills {
	private int skillId;
	@NotNull
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
