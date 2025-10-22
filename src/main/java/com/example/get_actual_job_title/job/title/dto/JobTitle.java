package com.example.get_actual_job_title.job.title.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobTitle {
    @JsonSetter("jobtitlename")
    private String jobTitleName;
    @JsonSetter("starttime")
    private LocalDate startTime;
}
