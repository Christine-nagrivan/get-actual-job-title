package com.example.get_actual_job_title.job.title.services;

import com.example.get_actual_job_title.job.title.dto.JobTitle;
import com.example.get_actual_job_title.job.title.dto.JobTitleResult;
import com.example.get_actual_job_title.job.title.functions.JobTitleFunctions;
import com.example.get_actual_job_title.job.title.mapper.JobTitleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class GetJobTitleService implements JobTitleFunctions {
    private JobTitleMapper jobTitleMapper;

    public JobTitleResult getJobTitleLast(List<JobTitle> jobTitleList) {
        return jobTitleMapper.jobTitleResultMap(this.jobTitleLast(jobTitleList));
    }
}
