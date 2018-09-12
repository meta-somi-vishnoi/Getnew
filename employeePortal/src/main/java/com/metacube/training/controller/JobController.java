package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.models.JobTitle;
import com.metacube.training.models.Project;
import com.metacube.training.models.Skills;
import com.metacube.training.services.JobService;
import com.metacube.training.services.ProjectService;
import com.metacube.training.services.SkillsService;

@Controller
@RequestMapping(value = "/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping(path = "/addJobs", method = RequestMethod.GET)
    public String createJob(Model model) {
        model.addAttribute("job", new JobTitle());
        return "admin/addJob";
    }

    @RequestMapping(path = "/addJobs", method = RequestMethod.POST)
    public String saveJob(@ModelAttribute("job") JobTitle job) {
        if (job != null && job.getJobCode() == 0) {
            jobService.addJob(job);
        } else {
            jobService.updateJob(job);
        }
        return "redirect:allJobs";
    }

    @RequestMapping(path = "/allJobs", method = RequestMethod.GET)
    public String getAllJob(Model model) {
        model.addAttribute("job", jobService.getAllJobs());
        return "/admin/allJobs";
    }

    @RequestMapping(path = "/editJob", method = RequestMethod.GET)
    public String editJob(Model model, @RequestParam("code") int code) {
        model.addAttribute("job", jobService.getJobByCode(code));
        return "admin/addJob";
    }

    @RequestMapping(path = "/deleteJob", method = RequestMethod.GET)
    public String deleteJob(@RequestParam("code") int code) {
        jobService.deleteJob(code);
        return "redirect:allJobs";
    }
}
