package com.milos.fleetapp.controllers;

import com.milos.fleetapp.models.JobTitle;
import com.milos.fleetapp.services.JobTitleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    private final JobTitleService jobTitleService;

    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/jobtitles")
    public String getJobTitles(Model model) {
        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
        model.addAttribute("jobtitles", jobTitleList);
        return "jobTitle";
    }

    @PostMapping("/jobtitles/addNew")
    public String addNewJob(JobTitle jobTitle) {
        jobTitleService.saveJobTitle(jobTitle);
        return "redirect:/jobtitles";
    }

    @GetMapping("/jobtitles/findById")
    @ResponseBody
    public Optional<JobTitle> findJobTById(Integer id) {
         return jobTitleService.findJobById(id);
    }

    @RequestMapping(value = "/jobtitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateJobTitle(JobTitle jobTitle) {
        jobTitleService.saveJobTitle(jobTitle);
        return "redirect:/jobtitles";
    }

    @RequestMapping(value = "/jobtitles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteJobTitle(Integer id) {
        jobTitleService.deleteJobTitle(id);
        return "redirect:/jobtitles";
    }
}
