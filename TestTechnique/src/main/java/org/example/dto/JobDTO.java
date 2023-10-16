package org.example.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;
@Builder
public record JobDTO(UUID uuid,
                     String CompanyName,
                     String positionHeld, 
                     PersonDTO personDTO,
                     LocalDate startDate,
                     LocalDate endDate) {
}
