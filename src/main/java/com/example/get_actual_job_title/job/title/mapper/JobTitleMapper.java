package com.example.get_actual_job_title.job.title.mapper;

import com.example.get_actual_job_title.job.title.dto.JobTitle;
import com.example.get_actual_job_title.job.title.dto.JobTitleResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

// Заказчику необходимо на выходе получить дату последнего приема на работу на последнюю должность без учета смены грейда
// {
//            "jobtitlename": "Operations Manager",
//            "starttime": "2022-08-01"
//        }

@Mapper
public interface JobTitleMapper {

    @Mapping(target = "jobTitleName", source = "jobTitle.jobTitleName")
    @Mapping(target = "startTimeLast", source = "jobTitle.startTime")
    JobTitleResult jobTitleResultMap(JobTitle jobTitle);
}

