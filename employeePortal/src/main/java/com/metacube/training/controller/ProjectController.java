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
import com.metacube.training.services.ProjectService;


@Controller
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
	private ProjectService projectService;

	@RequestMapping(path = "/addProject", method = RequestMethod.GET)
	public String createProject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "/addProject", method = RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute("project") Project project) {
		if(project!= null && project.getProjectId() == 0) {
			projectService.addProject(project);	
		}else {
			projectService.updateProject(project);
		}
		return "redirect:allProjects";
	}

	@RequestMapping(path = "/allProjects", method = RequestMethod.GET)
	public String getAllProjects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "/admin/allProjects";
	}

	@RequestMapping(path = "/editProject", method = RequestMethod.GET)
	public String editProject(Model model, @RequestParam("id") int id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/editProject";
	}

	@RequestMapping(path = "/delete", method = RequestMethod.GET)
	public String deleteProject(@RequestParam("id") int id) {
		projectService.deleteProject(id);
		return "redirect:allProjects";
	}
}
