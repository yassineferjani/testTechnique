package org.example.mapper;

import org.example.dto.JobDTO;
import org.example.dto.PersonDTO;
import org.example.model.Job;
import org.example.model.Person;

public class JobMapper {
    public static Job mapToModel (JobDTO dto){
        return Job.builder()
                .uuid(dto.uuid())
                .CompanyName(dto.CompanyName())
                .person(PersonMapper.mapToModel(dto.personDTO()))
                .positionHeld(dto.positionHeld())
                .build();
    }

    public static JobDTO mapToDto(Job job){
        return JobDTO.builder()
                .CompanyName(job.getCompanyName())
                .personDTO(PersonMapper.mapToDto(job.getPerson()))
                .positionHeld(job.getPositionHeld())
                .uuid(job.getUuid())
                .build();
    }
}
