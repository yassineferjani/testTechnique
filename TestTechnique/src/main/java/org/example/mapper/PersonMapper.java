package org.example.mapper;

import org.example.dto.PersonDTO;
import org.example.model.Person;

public class PersonMapper {
    public static Person mapToModel (PersonDTO dto){
        return Person.builder()
                .uuid(dto.uuid())
                .firstname(dto.firstname())
                .lastname(dto.lastname())
                .build();
    }

    public static PersonDTO mapToDto(Person person){
        return PersonDTO.builder()
                .uuid(person.getUuid())
                .firstname(person.getFirstname())
                .birthdate(person.getBirthDate())
                .lastname(person.getLastname())
                .build();
    }
}
