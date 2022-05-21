package com.Nexos.Inventory.service;

import com.Nexos.Inventory.mapper.MapperInventory;
import com.Nexos.Inventory.model.Inventory;
import com.Nexos.Inventory.repository.RepositoryInventory;
import com.Nexos.Inventory.repository.RepositoryPerson;
import com.Nexos.Inventory.request.RequestInventory;
import com.Nexos.Inventory.request.RequestInventoryLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceInventory {

    @Autowired
    private RepositoryInventory repositoryInventory;

    @Autowired
    private RepositoryPerson repositoryPerson;

    @Autowired
    private MapperInventory mapperInventory;

    @Autowired
    private ServiceInventoryLogs serviceInventoryLogs;

    public List<Inventory> listAllInventory() {
        return repositoryInventory.findAll();
    }

    public Inventory createInventory(RequestInventory requestCreateInventory) throws Exception {
        var user = repositoryPerson.findByIdPerson(UUID.fromString(requestCreateInventory.getPersonId()));
        try {
            var currentInventory = repositoryInventory.findByNameInventory(requestCreateInventory.getName());
            if (currentInventory != null) {
                throw new Exception("This product already exists");
            }
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
        return repositoryInventory.save(mapperInventory.createInventory(requestCreateInventory, user));
    }

    public Inventory updateInventory(RequestInventory requestInventory, UUID id) throws Exception {
        var currentInventory = repositoryInventory.findByIdInventory(id);
        var validateName = repositoryInventory.findByNameInventory(requestInventory.getName());
        try{
            if (currentInventory == null) {
                throw new Exception("This product not exists");
            } else if (validateName != null) {
                throw new Exception("This product already exists");
            }
            var requestInventoryLogs = buildRequestInvetoryLogs(requestInventory, currentInventory);
            serviceInventoryLogs.createInventoryLogs(requestInventoryLogs);
        }catch (Exception e){
            System.out.println("Error:" + e);
        }
        return repositoryInventory.save(mapperInventory.updateInventory(currentInventory, requestInventory));
    }

    public void deleteInventory(UUID id) throws Exception {
        try{
            Inventory inventory = repositoryInventory.findByIdInventory(id);
            if (inventory == null) {
                throw new Exception("This product not exists");
            }
            repositoryInventory.delete(inventory);
        }catch (Exception e){
            System.out.println("Error:" + e);
        }
    }

    public RequestInventoryLogs buildRequestInvetoryLogs(RequestInventory requestInventory, Inventory inventory) {

        RequestInventoryLogs requestInventoryLogs = new RequestInventoryLogs();
        requestInventoryLogs.setInventoryId(inventory.getId().toString());
        requestInventoryLogs.setName(requestInventory.getName());
        requestInventoryLogs.setQuantity(requestInventory.getQuantity().toString());
        requestInventoryLogs.setAdmissionDate(requestInventory.getAdmissionDate());
        requestInventoryLogs.setOriginPerson(inventory.getPerson().getPersonId().toString());
        requestInventoryLogs.setPersonModifications(requestInventory.getPersonId());

        return requestInventoryLogs;
    }
}
