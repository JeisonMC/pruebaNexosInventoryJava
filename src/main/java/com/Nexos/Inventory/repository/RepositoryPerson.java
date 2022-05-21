package com.Nexos.Inventory.repository;

import com.Nexos.Inventory.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryPerson extends JpaRepository<Person, Long> {

    @Query("Select p from Person p where p.personId= :personId")
    Person findByIdPerson(UUID personId);

    @Query("Select p from Person p")
    Person findAllPerson();

    @Query("Select p from Person p where p.email =:email")
    Person findByEmailPerson(String email);
}
