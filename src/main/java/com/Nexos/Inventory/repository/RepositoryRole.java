package com.Nexos.Inventory.repository;

import com.Nexos.Inventory.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepositoryRole extends JpaRepository<Role, Long> {

    @Query("Select r from Role r")
    List<Role> findAllRole();

    @Query("Select r from Role r where r.roleId = :id")
    Role findByIdRol(UUID id);

    @Query("Select r from Role r where r.name = :name")
    Role findRoleByName(String name);
}
