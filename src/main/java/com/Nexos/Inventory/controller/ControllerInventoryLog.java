package com.Nexos.Inventory.controller;

import com.Nexos.Inventory.model.Inventory;
import com.Nexos.Inventory.model.InventoryLog;
import com.Nexos.Inventory.request.RequestInventory;
import com.Nexos.Inventory.request.RequestInventoryLogs;
import com.Nexos.Inventory.request.RequestInventoryLogsById;
import com.Nexos.Inventory.service.ServiceInventoryLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/inventoryLog")
public class ControllerInventoryLog {

    @Autowired
    private ServiceInventoryLogs serviceInventoryLog;

    public ControllerInventoryLog(ServiceInventoryLogs serviceInventoryLog) {
        this.serviceInventoryLog = serviceInventoryLog;
    }

    @GetMapping()
    public List<InventoryLog> findAllInventory() {
        return serviceInventoryLog.listAllInventory();
    }

    @PostMapping()
    public InventoryLog createInventoryLog(@RequestBody RequestInventoryLogs requestInventoryLogs) throws Exception {
        return serviceInventoryLog.createInventoryLogs(requestInventoryLogs);
    }
    @PostMapping("/")
    public List<InventoryLog> listAllInventoryLogById(@RequestBody RequestInventoryLogsById requestInventoryLogsById) throws Exception {
        System.out.println(requestInventoryLogsById);
        return serviceInventoryLog.listAllInventoryById(UUID.fromString(requestInventoryLogsById.getInventoryId()));
    }
}
