package org.example.service;

import org.example.advising.PersonAgeException;
import org.example.dto.PersonDTO;
import org.example.mapper.PersonMapper;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
@Service
public class PersonImp implements IPerson {
    private final PersonRepository repository;

    public PersonImp(final PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonDTO save(PersonDTO studentDTO) {
        isValidPerson(studentDTO.birthdate());
        return Stream.of(studentDTO)
                .map(PersonMapper::mapToModel)
                .map(repository::save)
                .map(PersonMapper::mapToDto)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public PersonDTO update(PersonDTO studentDTO) {
        isValidPerson(studentDTO.birthdate());
        return Stream.of(studentDTO)
                .map(PersonMapper::mapToModel)
                .map(repository::save)
                .map(PersonMapper::mapToDto)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public List<PersonDTO> findAll() {
        return repository.findAll().stream()
                .map(PersonMapper::mapToDto)
                .toList();
    }

    @Override
    public Optional<PersonDTO> findById(UUID id) {
        return Optional.of(repository.findById(id)
                .map(PersonMapper::mapToDto)
                .orElseThrow(()->new RuntimeException("Not exist")));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    private void isValidPerson(LocalDate date) {
        LocalDate now = LocalDate.now();
        if (date.until(now).getYears() >= 150) {
            throw new PersonAgeException("The person over 150 years old cannot be registered.");
        }
    }
}
