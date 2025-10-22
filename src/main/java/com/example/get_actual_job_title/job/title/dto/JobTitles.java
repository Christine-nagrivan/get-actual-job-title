package com.example.get_actual_job_title.job.title.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobTitles {
    @JsonSetter("jobtitle")
    private List<JobTitle> jobTitleList;
}
