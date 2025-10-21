package com.example.get_actual_job_title.job.title;

import com.example.get_actual_job_title.job.title.dto.JobTitle;
import com.example.get_actual_job_title.job.title.dto.JobTitleResult;
import com.example.get_actual_job_title.job.title.mapper.JobTitleMap;

import java.util.List;

public abstract class GetJobTitle implements JobTitleFunctions {
    private JobTitleMap jobTitleMap;

    public JobTitleResult getJobTitleLast(List<JobTitle> jobTitleList) {

        return jobTitleMap.jobTitleResultMap(this.jobTitleLast(jobTitleList));
    }
}
