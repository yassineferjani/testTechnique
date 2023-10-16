package org.example.service;

import org.example.dto.PersonDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPerson {
    PersonDTO save(PersonDTO personDTO);
    PersonDTO update(PersonDTO personDTO);
    List<PersonDTO> findAll();
    Optional<PersonDTO> findById(final UUID id);
    void deleteById(final UUID id);
}
