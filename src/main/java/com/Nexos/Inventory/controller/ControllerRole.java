package com.Nexos.Inventory.controller;

import com.Nexos.Inventory.model.Inventory;
import com.Nexos.Inventory.model.Role;
import com.Nexos.Inventory.request.RequestInventory;
import com.Nexos.Inventory.request.RequestRole;
import com.Nexos.Inventory.service.ServiceInventory;
import com.Nexos.Inventory.service.ServiceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
public class ControllerRole {

    @Autowired
    private ServiceRole serviceRole;

    public ControllerRole(ServiceRole serviceRole) {
        this.serviceRole = serviceRole;
    }

    @GetMapping()
    public List<Role> findAllRole() {
        return serviceRole.listAllRole();
    }

    @PostMapping()
    public Role createRole(@RequestBody RequestRole requestRole) throws Exception {
        return serviceRole.createRole(requestRole);
    }

    @PatchMapping("/{id}")
    public Role updateRole(@PathVariable String id, @RequestBody RequestRole requestRole) throws Exception {
        return serviceRole.updateRole(requestRole, UUID.fromString(id));
    }
}
