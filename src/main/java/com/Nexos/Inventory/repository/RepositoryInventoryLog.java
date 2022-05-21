package com.Nexos.Inventory.repository;

import com.Nexos.Inventory.model.InventoryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepositoryInventoryLog extends JpaRepository<InventoryLog, Long> {

    @Query("Select i from InventoryLog i ")
    List<InventoryLog> findAllInventoryLog();

    @Query("Select i from InventoryLog i where i.inventory.id = :id")
    List<InventoryLog> findAllInventoryLogById(UUID id);
}
