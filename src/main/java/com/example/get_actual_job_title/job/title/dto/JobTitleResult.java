package com.example.get_actual_job_title.job.title.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobTitleResult {
    private String jobTitleName;
    private LocalDate startTime;
}
