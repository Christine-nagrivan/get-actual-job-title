package com.example.get_actual_job_title.job.title.services;

import com.example.get_actual_job_title.job.title.dto.JobTitleResult;
import com.example.get_actual_job_title.job.title.dto.JobTitles;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@SpringBootTest
class GetJobTitleServiceImplTest {
    private final File FILE_JSON = new File("src/test/resources/jobtitles.json");
    private JobTitles jobTitles;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private GetJobTitleService getJobTitleService;

    @BeforeEach
    void setUp() throws IOException {
        objectMapper.registerModule(new JavaTimeModule());
        jobTitles = objectMapper.readValue(FILE_JSON, new TypeReference<>() {});
    }

    @Test
    void getJobTitleLast() {
        JobTitleResult jobTitleResultActual = getJobTitleService.getJobTitleLast(jobTitles);
        JobTitleResult jobTitleResultExpenses = JobTitleResult.builder()
                .jobTitleName("Operations Manager")
                .startTime(LocalDate.parse("2022-08-01"))
                .build();
        Assertions.assertEquals(jobTitleResultExpenses.getJobTitleName(), jobTitleResultActual.getJobTitleName());
        Assertions.assertEquals(jobTitleResultExpenses.getStartTime(), jobTitleResultActual.getStartTime());
    }
}