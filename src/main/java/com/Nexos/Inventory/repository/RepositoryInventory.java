package com.Nexos.Inventory.repository;

import com.Nexos.Inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepositoryInventory extends JpaRepository<Inventory, Long> {

    @Query("Select i from Inventory i ")
    List<Inventory> findByInventory();

    @Query("Select i from Inventory i where i.id= :id")
    Inventory findByIdInventory(UUID id);

    @Query("Select i from Inventory i where i.name= :name")
    Inventory findByNameInventory(String name);
}
