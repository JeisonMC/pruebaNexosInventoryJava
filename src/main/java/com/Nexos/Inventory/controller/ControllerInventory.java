package com.Nexos.Inventory.controller;

import com.Nexos.Inventory.model.Inventory;
import com.Nexos.Inventory.request.RequestInventory;
import com.Nexos.Inventory.service.ServiceInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/inventory")
public class ControllerInventory {

    @Autowired
    private ServiceInventory serviceInventory;

    public ControllerInventory(ServiceInventory serviceInventory) {
        this.serviceInventory = serviceInventory;
    }

    @GetMapping()
    public List<Inventory> findAllInventory() {
        return serviceInventory.listAllInventory();
    }

    @PostMapping()
    public Inventory createInventory(@RequestBody RequestInventory requestInventory) throws Exception {
        return serviceInventory.createInventory(requestInventory);
    }

    @PatchMapping("/{id}")
    public Inventory updateInventory(@PathVariable String id, @RequestBody RequestInventory requestInventory) throws Exception {
        return serviceInventory.updateInventory(requestInventory, UUID.fromString(id));
    }

    @DeleteMapping("/{code}")
    public void deleteInventory(@PathVariable String code) throws Exception {
        serviceInventory.deleteInventory(UUID.fromString(code));
    }
}
