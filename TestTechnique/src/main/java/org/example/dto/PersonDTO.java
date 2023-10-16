package org.example.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;
@Builder
public record PersonDTO(UUID uuid, String firstname, String lastname, LocalDate birthdate) {
}
