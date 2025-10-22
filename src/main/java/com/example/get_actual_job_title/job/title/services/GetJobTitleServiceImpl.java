package com.example.get_actual_job_title.job.title.services;

import com.example.get_actual_job_title.job.title.dto.JobTitleResult;
import com.example.get_actual_job_title.job.title.dto.JobTitles;
import com.example.get_actual_job_title.job.title.mapper.JobTitleMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class GetJobTitleServiceImpl implements GetJobTitleService{

    private JobTitleMapper jobTitleMapper;

    @Override
    public JobTitleResult getJobTitleLast(JobTitles jobTitles) {
        return jobTitleMapper.jobTitleResultMap(this.jobTitleLast(jobTitles.getJobTitleList()));
    }
}
