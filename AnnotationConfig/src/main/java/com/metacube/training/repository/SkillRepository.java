package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.models.Project;
import com.metacube.training.models.Skills;

public interface SkillRepository<P> extends JpaRepository<Skills, Long> {
	
	public Skills getSkillBySkillId(int skillId);
	
	@Modifying
	@Query("DELETE from Skills WHERE skillId = ?1")
	public int deleteSkill(int skillId);
}

