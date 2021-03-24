package com.milos.fleetapp.services;

import com.milos.fleetapp.models.JobTitle;
import com.milos.fleetapp.repositories.JobTitleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {

    private final JobTitleRepository jobTitleRepository;

    public JobTitleService(JobTitleRepository jobTitleRepository) {
        this.jobTitleRepository = jobTitleRepository;
    }

    //get all
    public List<JobTitle> getJobTitles(){
        return jobTitleRepository.findAll();
    }

    //save
    public void saveJobTitle (JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }

    //find by id
    public Optional<JobTitle> findJobById(Integer id) {
        return jobTitleRepository.findById(id);
    }

    //delete by id
    public void deleteJobTitle(Integer id) {
        jobTitleRepository.deleteById(id);
    }
}
