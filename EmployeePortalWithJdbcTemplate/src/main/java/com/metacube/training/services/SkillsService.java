package com.metacube.training.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.dao.SkillsDao;
import com.metacube.training.models.Skills;

@Service
public class SkillsService {
	@Autowired
	private SkillsDao skillsDao;

	public Status addSkill(Skills skill) {
        Status status = skillsDao.addSkill(skill);
        return status;
    }
	
	public Skills getSkillById(int id) {
		return skillsDao.getSkillById(id);
	}

	public List<Skills> getAllSkills() {
		return skillsDao.getAllSkills();
	}

	public Status deleteSkill(int id) {
		Skills skill = skillsDao.getSkillById(id);
		if(skill==null) {
			return Status.NOT_EXIST;
		} else {
			Status status = skillsDao.deleteSkill(skill);
			return status;
		}
	}

	public Status updateSkill(Skills skill) {
		List<Skills> listOfSkills = new ArrayList<Skills>();
        listOfSkills = skillsDao.getAllSkills();
        for (Skills existingSkill : listOfSkills) {
            if (skill.getSkillId()== existingSkill.getSkillId()) {
                Status status = skillsDao.updateSkill(skill);
                return status;
            }
        } 
        return Status.NOT_EXIST;
	}
}
