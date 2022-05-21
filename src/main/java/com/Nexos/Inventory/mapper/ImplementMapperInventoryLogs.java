package com.Nexos.Inventory.mapper;

import com.Nexos.Inventory.model.Inventory;
import com.Nexos.Inventory.model.InventoryLog;
import com.Nexos.Inventory.model.Person;
import com.Nexos.Inventory.request.RequestInventoryLogs;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ImplementMapperInventoryLogs implements MapperInventoryLogs {

    @Override
    public InventoryLog createInventoryLogs(RequestInventoryLogs requestInventoryLogs,Inventory inventory) {
        InventoryLog inventoryLogs = new InventoryLog();
        inventoryLogs.setName(requestInventoryLogs.getName());
        inventoryLogs.setQuantity(requestInventoryLogs.getQuantity());
        inventoryLogs.setAdmissionDate(requestInventoryLogs.getAdmissionDate());
        inventoryLogs.setPersonModifications(requestInventoryLogs.getPersonModifications());
        inventoryLogs.setOriginUserId(UUID.fromString(requestInventoryLogs.getOriginPerson()));
        inventoryLogs.setInventory(inventory);

        return inventoryLogs;
    }
}
