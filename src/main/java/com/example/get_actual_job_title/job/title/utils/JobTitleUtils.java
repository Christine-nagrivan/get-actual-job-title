package com.example.get_actual_job_title.job.title.utils;

import com.example.get_actual_job_title.job.title.dto.JobTitle;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public interface JobTitleUtils {
    List<String> GRADES = List.of("Junior", "Middle", "Senior");

    default JobTitle jobTitleLast(List<JobTitle> jobTitleList) {
        jobTitleList = jobTitleList.stream().map(this::jobTitleNameTrimGrade)
                .sorted(Comparator.comparing(JobTitle::getStartTime).reversed()).toList();
        for (int i = 0; i <= jobTitleList.size(); i++) {
            JobTitle jobTitleI = jobTitleList.get(i);
            JobTitle jobTitlePrev = jobTitleList.get(i+1);
            if (!jobTitleI.getJobTitleName().equalsIgnoreCase(jobTitlePrev.getJobTitleName())) {
                return jobTitleI;
            }
        }
        return jobTitleList.getLast();
    }

    default JobTitle jobTitleNameTrimGrade(JobTitle jobTitle) {
        if (Objects.nonNull(jobTitle) && StringUtils.hasText(jobTitle.getJobTitleName())) {
            String[] jobTitleNames = jobTitle.getJobTitleName().split("");
            List<String> jobTitleNamesNew = new ArrayList<>();
            for (String grade : GRADES) {
                for (String jobTitleName : jobTitleNames) {
                    if (grade.equalsIgnoreCase(jobTitleName.trim())) {
                         jobTitleNamesNew = Arrays.stream(jobTitleNames).filter(s -> !s.equalsIgnoreCase(jobTitleName)).toList();
                    }
                }
            }
            if (!jobTitleNamesNew.isEmpty()) {
                jobTitle.setJobTitleName(String.join(" ", jobTitleNamesNew));
            }
        }
        return jobTitle;
    }
}
