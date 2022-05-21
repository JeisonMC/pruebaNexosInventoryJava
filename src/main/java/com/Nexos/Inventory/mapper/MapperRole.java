package com.Nexos.Inventory.mapper;

import com.Nexos.Inventory.model.Role;
import com.Nexos.Inventory.request.RequestRole;

public interface MapperRole {
    Role createRole(RequestRole requestRole);

    Role updateRole(Role role , RequestRole requestRole);
}
