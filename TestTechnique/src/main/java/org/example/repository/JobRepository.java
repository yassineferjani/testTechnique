package org.example.repository;

import org.example.model.Job;
import org.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Repository

public interface JobRepository extends JpaRepository<Job, UUID> {
/*
    @Query("SELECT j.person FROM Job j WHERE j.companyName = :companyName")
    List<Person> findPeopleByCompanyName(@Param("companyName") String companyName);
*/
    List<Job> findByPersonUuidAndEndDateBetween(UUID personUuid, LocalDate startDate, LocalDate endDate);

}
