package org.example.service;

import org.example.dto.JobDTO;
import org.example.mapper.JobMapper;
import org.example.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class JobImp implements IJob{
    private final JobRepository repository;

    public JobImp(final JobRepository repository) {
        this.repository = repository;
    }


    @Override
    public JobDTO save(JobDTO jobDTO) {
        return Stream.of(jobDTO)
                .map(JobMapper::mapToModel)
                .map(repository::save)
                .map(JobMapper::mapToDto)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public JobDTO update(JobDTO jobDTO) {
        return Stream.of(jobDTO)
                .map(JobMapper::mapToModel)
                .map(repository::save)
                .map(JobMapper::mapToDto)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public List<JobDTO> findAll() {
        return repository.findAll().stream()
                .map(JobMapper::mapToDto)
                .toList();
    }

    @Override
    public Optional<JobDTO> findById(UUID id) {
        return Optional.of(repository.findById(id)
                .map(JobMapper::mapToDto)
                .orElseThrow(()->new RuntimeException("Not exist")));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<JobDTO> getJobsByPerson(final UUID personId, final LocalDate startDate, final LocalDate endDate) {
       return repository.findByPersonUuidAndEndDateBetween(personId,startDate,endDate)
               .stream()
               .map(JobMapper::mapToDto)
               .toList();
    }

/*    @Override
    public List<PersonDTO> getPeopleByCompany(final String companyName) {
        return repository.findPeopleByCompanyName(companyName)
                .stream()
                .map(PersonMapper::mapToDto)
                .toList();
    }*/
}
