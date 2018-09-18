package com.metacube.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.models.JobTitle;
import com.metacube.training.models.Skills;
import com.metacube.training.repository.JobRepository;
import com.metacube.training.repository.SkillRepository;

@Service
public class SkillsService {
	@Autowired
	private SkillRepository<Skills> skillRepository;

    public Status addSkill(Skills skill) {
        skillRepository.save(skill);
        return Status.INSERTED;
    }

    public Skills getSkillById(int id) {
        return skillRepository.getSkillBySkillId(id);
    }

    public List<Skills> getAllSkills() {
        return skillRepository.findAll();
    }

    public Status deleteSkill(int id) {
        Skills skill = skillRepository.getSkillBySkillId(id);
        if (skill == null) {
            return Status.NOT_EXIST;
        } else {
            skillRepository.deleteSkill(skill.getSkillId());
            return Status.DELETED;
        }
    }

    public Status updateSkill(Skills skill) {
        Skills skillPresent = skillRepository.getSkillBySkillId(skill.getSkillId());
        if (skillPresent != null) {
            skillRepository.save(skill);
            return Status.UPDATED;
        }
        return Status.NOT_EXIST;
    }
}
