package org.example.service;

import org.example.dto.JobDTO;
import org.example.dto.PersonDTO;
import org.example.model.Person;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IJob {
    JobDTO save(JobDTO jobDTO);
    JobDTO update(JobDTO jobDTO);
    List<JobDTO> findAll();
    Optional<JobDTO> findById(final UUID id);
    void deleteById(final UUID id);
    List<JobDTO> getJobsByPerson(UUID personId, LocalDate startDate, LocalDate endDate);
   // List<PersonDTO> getPeopleByCompany(String companyName);
}
