package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Person {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String lastname;
    private String firstname;
    private LocalDate birthDate;
}
