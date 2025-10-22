package com.example.get_actual_job_title.job.title.services;

import com.example.get_actual_job_title.job.title.dto.JobTitleResult;
import com.example.get_actual_job_title.job.title.dto.JobTitles;
import com.example.get_actual_job_title.job.title.utils.JobTitleUtils;

public interface GetJobTitleService extends JobTitleUtils {

    JobTitleResult getJobTitleLast(JobTitles jobTitles);
}
