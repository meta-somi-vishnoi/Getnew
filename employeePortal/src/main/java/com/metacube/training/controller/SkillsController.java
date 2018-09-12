package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import com.metacube.training.models.Project;
import com.metacube.training.models.Skills;
import com.metacube.training.services.ProjectService;
import com.metacube.training.services.SkillsService;

@Controller
@RequestMapping(value = "/skills")
public class SkillsController {

	@Autowired
	private SkillsService skillsService;

	@RequestMapping(path = "/addSkills", method = RequestMethod.GET)
	public String createSkill(Model model) {
		model.addAttribute("skill", new Skills());
		return "admin/editSkill";
	}

	@RequestMapping(path = "/addSkills", method = RequestMethod.POST)
	public String saveSkill(@ModelAttribute("skill") Skills skill) {
		if (skill != null && skill.getSkillId() == 0) {
			skillsService.addSkill(skill);
		} else {
			skillsService.updateSkill(skill);
		}
		return "redirect:allSkills";
	}

	@RequestMapping(path = "/allSkills", method = RequestMethod.GET)
	public String getAllSkills(Model model) {
		model.addAttribute("skills", skillsService.getAllSkills());
		return "/admin/allSkills";
	}

	@RequestMapping(path = "/editSkill", method = RequestMethod.GET)
	public String editSkill(Model model,@Valid @RequestParam("id") int id) {
		model.addAttribute("skill", skillsService.getSkillById(id));
		return "admin/editSkill";
	}

	@RequestMapping(path = "/deleteSkill", method = RequestMethod.GET)
	public String deleteSkill(@RequestParam("id") int id) {
		skillsService.deleteSkill(id);
		return "redirect:allSkills";
	}
}
