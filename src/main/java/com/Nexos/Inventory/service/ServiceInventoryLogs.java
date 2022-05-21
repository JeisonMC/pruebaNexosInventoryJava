package com.Nexos.Inventory.service;

import com.Nexos.Inventory.mapper.MapperInventoryLogs;
import com.Nexos.Inventory.model.InventoryLog;
import com.Nexos.Inventory.repository.RepositoryInventory;
import com.Nexos.Inventory.repository.RepositoryInventoryLog;
import com.Nexos.Inventory.request.RequestInventoryLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceInventoryLogs {

    @Autowired
    private RepositoryInventory repositoryInventory;

    @Autowired
    private RepositoryInventoryLog repositoryInventoryLog;

    @Autowired
    private MapperInventoryLogs mapperInventoryLogs;


    public List<InventoryLog> listAllInventory() {
        return repositoryInventoryLog.findAllInventoryLog();
    }

    public List<InventoryLog> listAllInventoryById(UUID id) throws Exception {
        try{
            var currentInventoryLog = repositoryInventory.findByIdInventory(id);
            if (currentInventoryLog == null) {
                throw new Exception("This product not exists");
            }
        }catch (Exception e) {
            System.out.println("Error:" + e);
        }
        return repositoryInventoryLog.findAllInventoryLogById(id);
    }

    public InventoryLog createInventoryLogs(RequestInventoryLogs requestCreateInventoryLog) {
        var currentInvetory = repositoryInventory.findByIdInventory(UUID.fromString(requestCreateInventoryLog.getInventoryId()));
        try{
            if (currentInvetory == null) {
                throw new Exception("This product not exists");
            }
        }catch ( Exception e){
            System.out.println("Error:" + e);
        }
        return repositoryInventoryLog.save(mapperInventoryLogs.createInventoryLogs(requestCreateInventoryLog, currentInvetory));
    }
}
