package com.example.get_actual_job_title.job.title.services;

import com.example.get_actual_job_title.job.title.dto.JobTitle;
import com.example.get_actual_job_title.job.title.dto.JobTitleResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

class GetJobTitleServiceTest {
    private List<JobTitle> jobTitleList;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private GetJobTitleService getJobTitleService;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        jobTitleList = objectMapper.readValue("src/test/resources/jobtitles.json", new TypeReference<>() {});
    }

    @Test
    void getJobTitleLast() {
        JobTitleResult jobTitleResultActual = getJobTitleService.getJobTitleLast(jobTitleList);
        JobTitleResult jobTitleResultExpenses = JobTitleResult.builder()
                .jobTitleName("Operations Manager")
                .startTime(LocalDate.parse("2022-08-01"))
                .build();
        Assertions.assertEquals(jobTitleResultExpenses.getJobTitleName(), jobTitleResultActual.getJobTitleName());
        Assertions.assertEquals(jobTitleResultExpenses.getStartTime(), jobTitleResultActual.getStartTime());
    }
}